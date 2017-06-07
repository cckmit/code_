package com.mika.credit.facade.order.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.MqRecord;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.order.*;
import com.mika.credit.common.entity.pay.PayBackBean;
import com.mika.credit.common.enums.MqTypeEnum;
import com.mika.credit.common.fastdfs.FastDFSClient;
import com.mika.credit.common.util.HttpUtil;
import com.mika.credit.common.util.UtilGenerateID;
import com.mika.credit.facade.order.dao.OrderDetailViewMapper;
import com.mika.credit.facade.order.dao.OrderDetailsMapper;
import com.mika.credit.facade.order.dao.OrderMapper;
import com.mika.credit.facade.order.dao.ProductMapper;
import com.mika.credit.facade.order.entity.OrdersBiz;
import com.mika.credit.facade.order.mq.OrderMessageCreator;
import com.mika.credit.facade.order.service.OrderService;
import com.mika.credit.facade.order.util.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by dell on 2017/3/2.
 */
@SuppressWarnings("Duplicates")
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    private static final Log logger = LogFactory.getLog(OrderServiceImpl.class);


    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderDetailsMapper orderDetailsMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    @Qualifier("orderJmsTemplate")
    private JmsTemplate orderJmsTemplate;
    @Autowired
    @Qualifier("creditQueue")
    private Destination creditQueue;
    @Autowired
    private OrderDetailViewMapper orderDetailViewMapper;
    @Value("${CPMOrderUrl}")
    private String CPMOrderUrl;

    @Override
    public BootGrid<Orders> findOrders(BootGrid<Orders> bootGrid, OrderQuery example) {
        logger.info("进入查询订单findOrders方法");
        if (bootGrid != null && example != null) {
            //+1天，否则查询有误
            Date createDateTo = example.getCreateDateTo();
            if (createDateTo != null) {
                Calendar c = Calendar.getInstance();
                c.setTime(createDateTo);
                c.add(Calendar.DATE, 1);
                example.setCreateDateTo(c.getTime());
            }
            Page<Orders> page = PageHelper.startPage(bootGrid.getCurrent(), bootGrid.getRowCount());
            bootGrid.setRows(orderMapper.queryListByOrderQuery(example));
            bootGrid.setTotal((int) page.getTotal());
            bootGrid.setResult(true);
        }
        logger.info("findOrders订单查询方法结束,返回结果:" + JSON.toJSONString(bootGrid));
        return bootGrid;
    }

    @Override
    public ResponseResult<Orders> findOrdersById(Long orderId) { //TODO:查询缓存中的数据
        logger.info("进入查询订单findOrdersById方法");
        ResponseResult<Orders> responseResult = new ResponseResult<>();
        if (orderId != null) {
            Orders orders = orderMapper.queryById(orderId);
            if (orders != null) {
                responseResult.setCode(true);
                responseResult.setContent(orders);
            }
        }
        if (!responseResult.getCode()) {
            responseResult.setMsg("无此订单");
        }
        logger.info("findOrdersById订单查询方法结束,返回结果:" + JSON.toJSONString(responseResult));
        return responseResult;
    }

    @Override
    public ResponseResult<Orders> saveOrder(Orders record) {
        logger.info("进入保存订单saveOrder方法");
        Set<Long> orderIds = new HashSet<>();
        ResponseResult<Orders> responseResult = new ResponseResult<>();
        if (record != null && !CollectionUtils.isEmpty(record.getOrderDetails())) {
            if (record.getSource() == null) {
                responseResult.setMsg("订单来源不能为空");
                return responseResult;
            }
            List<OrderDetail> orderDetails = record.getOrderDetails();//当前订单的明细
            Integer customerId = record.getCustomerId();
            for (OrderDetail orderDetail : orderDetails) {
                if ((StringUtils.isBlank(orderDetail.getCompanyName()) || orderDetail.getProductId() == null) && !record.getSource().equals(SourceEnum.GUGU.getSource())) {
                    responseResult.setMsg("信息缺失,订单保存失败");
                    logger.info("信息缺失,订单保存失败");
                    return responseResult;
                }
                Product product = productMapper.queryById(orderDetail.getProductId());
                if (product != null) {
                    BigDecimal price = product.getPrice();
                    orderDetail.setPrice(price);
                    orderDetail.setPriceActual(price);
                    orderDetail.setExpectHour(product.getExpectHour());
                } else if (!record.getSource().equals(SourceEnum.GUGU.getSource())) {
                    responseResult.setMsg("无此产品,订单无效");
                    logger.info("无此产品,订单无效");
                    return responseResult;
                }
                OrderDetailViewQuery view = new OrderDetailViewQuery();
                view.setCustomerId(customerId);
                view.setCompanyName(orderDetail.getCompanyName());
                //根据customerId和companyName查询最近订单
                List<OrderDetailView> orderDetailViews = orderDetailViewMapper.queryListByOrderDetailQuery(view);
                if (orderDetailViews.size() > 0) {
                    OrderDetailView detailView = orderDetailViews.get(0);
                    Long orderId = detailView.getOrderId();
                    //该订单id之前未在所有订单id集合中,为新id
                    if (orderIds.add(orderId)) {
                        BigDecimal priceNow = orderDetail.getPrice();
                        BigDecimal priceBefore = detailView.getPrice();
                        int compareTo = priceNow.compareTo(priceBefore);
                        //与原金额相等;已完成
                        if (compareTo == 0 && Objects.equals(detailView.getStatus(), OrderDetailStatusEnum.FINISHED.getStatusCode())) {
                            Date createTime = detailView.getCreateTime();
                            Date now = new Date();
                            long weekTime = 7 * 24 * 60 * 60 * 1000;
                            //超过七天,需要更新报告
                            if ((now.getTime() - createTime.getTime()) >= weekTime) {
                                reloadData(orderDetail.getId());
                            } else {
                                responseResult.setMsg("您最近一个星期已下过该企业的订单,该订单未保存成功");
                                responseResult.setCode(false);
                                logger.info("您最近一个星期已下过该企业的订单,该订单未保存成功");
                                return responseResult;
                            }
                            //等于原金额;未完成/小于原金额;未完成;已完成
                        } else if ((compareTo == 0 && !Objects.equals(detailView.getStatus(), OrderDetailStatusEnum.CANCELED.getStatusCode()) && detailView.getStatus() != OrderDetailStatusEnum.FINISHED.getStatusCode())
                                || (compareTo == -1 && detailView.getStatus() != OrderDetailStatusEnum.CANCELED.getStatusCode())) {
                            responseResult.setMsg("您最近已下过该企业的订单,该订单未保存成功");
                            responseResult.setCode(false);
                            logger.info("您最近已下过该企业的订单,该订单未保存成功");
                            return responseResult;
                        } else if (compareTo == 1 && !Objects.equals(detailView.getStatus(), OrderDetailStatusEnum.CANCELED.getStatusCode())) {//大于原金额;未完成
                            Boolean hasPay = detailView.getHasPay();
                            //已支付
                            if (hasPay) {
                                orderDetail.setPriceActual(priceNow.subtract(priceBefore));//支付余额
                            }
                        }
                    }
                }

            }
            BigDecimal amount = new BigDecimal(0);//订单总金额
            BigDecimal amountActual = new BigDecimal(0);//订单实际金额
            for (OrderDetail orderDetail : orderDetails) {
                if (orderDetail.getPrice() == null || orderDetail.getPrice().compareTo(new BigDecimal(0)) == -1) {
                    responseResult.setMsg("订单价格不合法");
                    logger.info("订单价格不合法");
                    return responseResult;
                }
                amount = amount.add(orderDetail.getPrice());
                amountActual = amountActual.add(orderDetail.getPriceActual());
            }
            //根据产品价格设置该订单金额
            record.setAmount(amount);
            record.setAmountActual(amountActual);

            //保存订单
            Date now = new Date();
            record.setCreateTime(now);
            record.setUpdateTime(now);
            record.setStatus(OrderStatusEnum.TO_PAY.getStatusCode());
            if (SourceEnum.GLOBAL_SEARCH.getSource().equals(record.getSource())) {
                record.setNo(UtilGenerateID.generateID("GS"));
            } else if (SourceEnum.GUGU.getSource().equals(record.getSource())) {
                record.setNo(UtilGenerateID.generateID("GG"));
            } else if (SourceEnum.CPM.getSource().equals(record.getSource())) {
                record.setNo(UtilGenerateID.generateID("CP"));
            } else {
                record.setNo(UtilGenerateID.generateID("GE"));
            }
            record.setHasPay(false);
            record.setDetailCount((byte) orderDetails.size());

            int saveOrder = orderMapper.save(record);

            for (OrderDetail orderDetail : orderDetails) {
                orderDetail.setUpdateTime(now);
                orderDetail.setStatus(OrderDetailStatusEnum.TO_PAY.getStatusCode());
                Long id = record.getId();
                orderDetail.setOrderId(id);
            }

            int saveOrderDetails = orderDetailsMapper.saveBatch(orderDetails);//保存订单明细

            if (saveOrder > 0 && saveOrderDetails > 0) {
                responseResult.setCode(true);
                responseResult.setMsg("订单保存成功");
                responseResult.setContent(record);
            } else {
                responseResult.setMsg("订单保存失败");

            }
        } else {
            responseResult.setMsg("订单保存失败");
        }
        logger.info("订单保存方法saveOrder结束,返回结果:" + JSON.toJSONString(responseResult));
        return responseResult;
    }

    @Override
    public ResponseResult<Orders> saveOrderToCPM(Orders record) {
        if (record != null) {
            String cpmCustomerId = "8953";
            String orderSourceId = "3";
            String reportTypeId = "1";
            List<OrderDetail> orderDetails = this.findOrderDetailByOrderId(record.getId());
            if (orderDetails != null && orderDetails.size() > 0) {
                OrderDetail orderDetail = orderDetails.get(0);
                Integer productId = orderDetail.getProductId();
                Product product = productMapper.queryById(productId);
                Byte level = product.getLevel();
                String companyName = orderDetail.getCompanyName();
                if (level != 1) {
                    reportTypeId = "2";
                }
                String crefoNo = orderDetail.getCrefoNo();
                Long globalHawkid = orderDetail.getId();
                if (crefoNo == null || crefoNo.equals("") || globalHawkid == null) {
                    ResponseResult<Orders> result = new ResponseResult<>();
                    result.setCode(false);
                    result.setMsg("操作失败");
                    return result;
                } else {
                    try {
                        String url = CPMOrderUrl;
                        OrdersBiz ordersBiz = new OrdersBiz();
                        companyName = java.net.URLEncoder.encode(companyName, "UTF-8");
                        ordersBiz.setNote(level + "");
                        ordersBiz.setSubjectObj(companyName);
                        ordersBiz.setCid(Integer.parseInt(cpmCustomerId));
                        ordersBiz.setReportTypeId(reportTypeId);
                        ordersBiz.setOrderSourceId(orderSourceId);
                        ordersBiz.setCrefoNo(crefoNo);
                        ordersBiz.setBizid(Integer.parseInt(globalHawkid + ""));
                        url += "?param=" + JSON.toJSONString(ordersBiz);
                        String clstr = HttpUtil.syncData(url);
                        if (StringUtils.isNotBlank(clstr)) {
                            JSONObject cl = JSON.parseObject(clstr);
                            ResponseResult<Orders> result = new ResponseResult<>();
                            if (cl.getString("code").equals("1")) {
                                result.setCode(true);
                                result.setMsg("操作成功");
                            } else {
                                result.setCode(false);
                                result.setMsg("操作失败");
                            }
                            return result;
                        }
                    } catch (Exception e) {
                        logger.error("\n-------------------------------------------\n");
                        logger.error("Error Message:" + e.getMessage(), e);
                        logger.error("\n-------------------------------------------\n");
                    }

                }
            }
        }
        return null;
    }


    @Override
    public ResponseResult<Orders> deleteOrder(Orders record) {
        logger.info("进入取消订单deleteOrder方法");
        ResponseResult<Orders> responseResult = new ResponseResult<>();
        boolean flag = true;
        if (record != null) {
            List<Orders> orders = orderMapper.queryList(record);
            if (!CollectionUtils.isEmpty(orders)) {
                for (Orders order : orders) {
                    List<OrderDetail> orderDetails = orderDetailsMapper.findOrderDetailByOrderId(order.getId());
                    if (!CollectionUtils.isEmpty(orderDetails)) {
                        for (OrderDetail orderDetail : orderDetails) {
                            orderDetail.setStatus(OrderDetailStatusEnum.CANCELED.getStatusCode());
                            flag &= orderDetailsMapper.updateStatus(orderDetail) > 0;
                        }
                    }
                    sendEmail(order, "cancel");
                }
                record.setStatus(OrderStatusEnum.CANCELED.getStatusCode());
                flag &= orderMapper.updateStatus(record) > 0;
            }
            if (flag) {
                responseResult.setCode(true);
                responseResult.setMsg("订单取消成功");
            } else {
                responseResult.setMsg("订单取消失败");
            }
        }
        logger.info("取消订单deleteOrder方法结束,返回结果:" + JSON.toJSONString(responseResult));
        return responseResult;
    }

    @Override
    public ResponseResult<Orders> deleteOrderPhysical(Orders record) {
        logger.info("进入删除订单deleteOrderPhysical方法");
        ResponseResult<Orders> responseResult = new ResponseResult<>();
        boolean flag = true;
        if (record != null) {
            List<Orders> orders = orderMapper.queryList(record);
            if (!CollectionUtils.isEmpty(orders)) {
                for (Orders order : orders) {
                    List<OrderDetail> details = orderDetailsMapper.findOrderDetailByOrderId(order.getId());
                    if (!CollectionUtils.isEmpty(details)) {
                        flag &= orderDetailsMapper.deleteOrderDetailsByOrderId(order.getId()) > 0;
                    }
                }
                flag &= orderMapper.delete(record) > 0;
                if (flag) {
                    responseResult.setCode(true);
                    responseResult.setMsg("订单删除成功");
                } else {
                    responseResult.setMsg("订单删除失败");
                }
            } else {
                responseResult.setMsg("没有此项订单");
            }
        } else {
            responseResult.setMsg("没有此项订单");
        }
        logger.info("删除订单deleteOrderPhysical方法结束,返回结果:" + JSON.toJSONString(responseResult));
        return responseResult;
    }

    @Override
    public ResponseResult<Orders> deleteOrder(Long orderId) {
        logger.info("进入取消订单deleteOrder方法,orderId=" + orderId);
        ResponseResult<Orders> responseResult = new ResponseResult<>();
        if (orderId != null) {
            Orders order = new Orders();
            order.setId(orderId);
            return deleteOrder(order);
        }
        responseResult.setMsg("订单id不能为空");
        logger.info("删除订单deleteOrder方法结束,返回结果" + JSON.toJSONString(responseResult));
        return responseResult;
    }

    @Override
    public ResponseResult<Orders> deleteOrderPhysical(Long orderId) {
        logger.info("进入删除订单deleteOrderPhysical方法,orderId=" + orderId);
        ResponseResult<Orders> responseResult = new ResponseResult<>();
        if (orderId != null) {
            Orders order = new Orders();
            order.setId(orderId);
            return deleteOrderPhysical(order);
        }
        responseResult.setMsg("订单id不能为空");
        logger.info("删除订单deleteOrderPhysical方法结束,返回结果" + JSON.toJSONString(responseResult));
        return responseResult;
    }


    @Override
    public ResponseResult<Orders> updateStatus(Orders record) {
        logger.info("进入修改订单状态updateStatus方法");
        ResponseResult<Orders> responseResult = new ResponseResult<>();
        boolean flag = true;
        if (record != null && record.getId() != null) {
            flag &= orderMapper.updateStatus(record) > 0;
            List<OrderDetail> orderDetails = orderDetailsMapper.findOrderDetailByOrderId(record.getId());
            if (!CollectionUtils.isEmpty(orderDetails)) {
                for (OrderDetail orderDetail : orderDetails) {
                    orderDetail.setStatus(record.getStatus());
                    flag &= orderDetailsMapper.updateStatus(orderDetail) > 0;
                }
            }
            if (flag) {
                responseResult.setCode(true);
                responseResult.setMsg("订单状态修改成功");
            } else {
                responseResult.setMsg("订单状态修改失败");
            }
        } else {
            responseResult.setMsg("没有此项订单");
        }
        logger.info("修改订单状态updateStatus方法结束,返回结果:" + JSON.toJSONString(responseResult));
        return responseResult;
    }

    @Override
    public ResponseResult<Orders> updatePay(Orders record) {
        logger.info("进入修改支付状态updatePay方法");
        ResponseResult<Orders> responseResult = new ResponseResult<>();
        if (record != null && record.getId() != null) {
            List<OrderDetail> orderDetails = orderDetailsMapper.findOrderDetailByOrderId(record.getId());
            if (!CollectionUtils.isEmpty(orderDetails)) {
                boolean flag = true;
                for (OrderDetail orderDetail : orderDetails) {
                    Integer productId = orderDetail.getProductId();
                    Product product = productMapper.queryById(productId);
                    if (product.getLevel() == 1) {
                        orderDetail.setStatus(OrderDetailStatusEnum.FINISHED.getStatusCode());//若产品等级为1,该明细已完成
                        orderDetail.setFinishTime(new Date());
                    } else {
                        flag = false;
                        orderDetail.setStatus(OrderDetailStatusEnum.MAKING.getStatusCode());
                        Integer expectHour = product.getExpectHour();
                        //orderDetail.setExpectHour(expectHour);
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(new Date());
                        orderDetail.setExpectTime(DateUtil.addDateByWorkDay(calendar, expectHour / 24).getTime());
                    }
                }
                if (flag) {
                    record.setStatus(OrderStatusEnum.FINISHED.getStatusCode());
                    record.setFinishTime(new Date());
                } else {
                    record.setStatus(OrderStatusEnum.MAKING.getStatusCode());
                }
                Integer updateBatch = orderDetailsMapper.updateBatch(orderDetails);
                record.setPayTime(new Date());
                record.setHasPay(true);
                Integer integer = orderMapper.updatePay(record);
                if (integer > 0 && updateBatch > 0) {
                    record.setOrderDetails(orderDetailsMapper.findOrderDetailByOrderId(record.getId()));
                    responseResult.setCode(true);
                    responseResult.setMsg("订单支付完成");
                    responseResult.setContent(record);
                } else {
                    responseResult.setMsg("订单支付失败");
                }
            } else {
                responseResult.setMsg("没有此项订单");
            }
        }
        logger.info("修改支付状态updatePay方法结束,返回结果:" + JSON.toJSONString(responseResult));
        return responseResult;
    }

    @Override
    public ResponseResult<Orders> updateSubmit(Orders record) {
        logger.info("进入修改订单交付日期updateSubmit方法");
        ResponseResult<Orders> responseResult = new ResponseResult<>();
        if (record != null && record.getId() != null) {
            record.setExpectTime(new Date());
            Integer submit = orderMapper.updateSubmit(record);
            if (submit > 0) {
                responseResult.setMsg("订单交付成功");
                responseResult.setCode(true);
            } else {
                responseResult.setMsg("订单交付失败");
            }
        } else {
            responseResult.setMsg("没有此项订单");
        }
        logger.info("修改订单交付日期updateSubmit方法结束,返回结果:" + JSON.toJSONString(responseResult));
        return responseResult;
    }

    @Override
    public ResponseResult<Orders> updateFinish(Orders record) {
        logger.info("进入修改订单完成日期updateFinish方法");
        ResponseResult<Orders> responseResult = new ResponseResult<>();
        if (record != null && record.getId() != null) {
            record.setFinishTime(new Date());
            Integer updateFinish = orderMapper.updateFinish(record);
            if (updateFinish > 0) {
                responseResult.setCode(true);
                responseResult.setMsg("订单已完成");
            } else {
                responseResult.setMsg("完成订单失败");
            }
        } else {
            responseResult.setMsg("没有此项订单");
        }
        logger.info("修改订单完成日期updateFinish方法结束,返回结果:" + JSON.toJSONString(record));
        return responseResult;
    }

    @Override
    public BootGrid<OrderDetail> findOrderDetail(BootGrid<OrderDetail> bootGrid, OrderDetailQuery example) {
        if (bootGrid != null && example != null) {
            //+1天，否则查询有误
            Date createDateTo = example.getCreateDateTo();
            if (createDateTo != null) {
                Calendar c = Calendar.getInstance();
                c.setTime(createDateTo);
                c.add(Calendar.DATE, 1);
                example.setCreateDateTo(c.getTime());
            }
            Page<Object> page = PageHelper.startPage(bootGrid.getCurrent(), bootGrid.getRowCount());
            List<OrderDetail> details = orderDetailsMapper.queryListByOrderDetailQuery(example);//
            bootGrid.setRows(details);
            bootGrid.setTotal((int) page.getTotal());
            bootGrid.setResult(true);
        }
        return bootGrid;
    }

    @Override
    public List<OrderDetail> findOrderDetail(OrderDetail orderDetail) {
        if (orderDetail != null) {
            return orderDetailsMapper.queryList(orderDetail);
        }
        return null;
    }

    @Override
    public ResponseResult<OrderDetail> findOrderDetailById(Long OrderDetailId) {
        ResponseResult<OrderDetail> responseResult = new ResponseResult<>();
        if (OrderDetailId != null) {
            OrderDetail orderDetail = orderDetailsMapper.queryById(OrderDetailId);
            if (orderDetail != null) {
                responseResult.setCode(true);
                responseResult.setContent(orderDetail);
            }
        }
        if (!responseResult.getCode()) {
            responseResult.setMsg("无此明细");
        }
        return responseResult;
    }

    @Override
    public ResponseResult<OrderDetail> findOrderDetailByIdWithData(Long OrderDetailId) {
        OrderDetail orderDetail = orderDetailsMapper.queryById(OrderDetailId);
        ResponseResult<OrderDetail> responseResult = new ResponseResult<>();
        if (orderDetail != null) {
            String dataUrl = orderDetail.getPathData();
            if (StringUtils.isNotBlank(dataUrl)) {
                orderDetail.setData(getData(dataUrl));
            }
            //else {
            //    reloadData(OrderDetailId);
            //}
            responseResult.setCode(true);
            responseResult.setContent(orderDetail);
        }
        if (!responseResult.getCode()) {
            responseResult.setMsg("无此明细");
        }
        return responseResult;
    }

    @Override
    public BootGrid<OrderDetail> findOrderDetail(BootGrid<OrderDetail> bootGrid, Long orderId) {
        if (bootGrid != null && orderId != null) {
            Page<Object> page = PageHelper.startPage(bootGrid.getCurrent(), bootGrid.getRowCount());
            List<OrderDetail> orderDetails = orderDetailsMapper.findOrderDetailByOrderId(orderId);
            if (!CollectionUtils.isEmpty(orderDetails)) {
                bootGrid.setRows(orderDetails);
                bootGrid.setTotal((int) page.getTotal());
                bootGrid.setResult(true);
            }
        }
        return bootGrid;
    }

    @Override
    public List<OrderDetail> findOrderDetailByOrderId(Long orderId) {
        if (orderId != null) {
            return orderDetailsMapper.findOrderDetailByOrderId(orderId);
        }
        return null;
    }

    @Override
    public BootGrid<OrderDetail> findOrderDetailWithData(BootGrid<OrderDetail> bootGrid, Long orderId) {
        if (bootGrid != null && orderId != null) {
            Page<Object> page = PageHelper.startPage(bootGrid.getCurrent(), bootGrid.getRowCount());
            List<OrderDetail> orderDetails = orderDetailsMapper.findOrderDetailByOrderId(orderId);
            if (!CollectionUtils.isEmpty(orderDetails)) {
                for (OrderDetail orderDetail : orderDetails) {
                    String dataUrl = orderDetail.getPathData();
                    if (StringUtils.isNotBlank(dataUrl)) {
                        orderDetail.setData(getData(dataUrl));
                    }

                }
                bootGrid.setRows(orderDetails);
                bootGrid.setTotal((int) page.getTotal());
                bootGrid.setResult(true);
            }
        }

        return bootGrid;
    }


    @Override
    public ResponseResult<OrderDetail> deleteOrderDetail(OrderDetail record) {
        ResponseResult<OrderDetail> responseResult = new ResponseResult<>();
        boolean flag = true;
        boolean flagDetail = true;
        if (record != null) {
            List<OrderDetail> details = orderDetailsMapper.queryList(record);
            if (!CollectionUtils.isEmpty(details)) {
                for (OrderDetail detail : details) {
                    detail.setStatus(OrderDetailStatusEnum.CANCELED.getStatusCode());
                    flagDetail &= orderDetailsMapper.updateStatus(detail) > 0;
                    Long orderId = detail.getOrderId();
                    List<OrderDetail> orderDetails = orderDetailsMapper.findOrderDetailByOrderId(orderId);
                    if (!CollectionUtils.isEmpty(orderDetails)) {
                        for (OrderDetail orderDetail : orderDetails) {
                            flag &= orderDetail.getStatus() == OrderDetailStatusEnum.CANCELED.getStatusCode();
                        }
                        if (flag) {
                            //flag为true表示该订单下所有报告均已取消,此时需要取消订单
                            Orders order = new Orders();
                            order.setId(orderId);
                            order.setStatus(OrderStatusEnum.CANCELED.getStatusCode());
                            orderMapper.updateStatus(order);
                        }
                    }
                }
                if (flagDetail) {
                    responseResult.setCode(true);
                    responseResult.setMsg("已取消该报告");
                } else {
                    responseResult.setMsg("报告取消失败");
                }
            }
        }
        if (StringUtils.isBlank(responseResult.getMsg())) {
            responseResult.setMsg("无此报告");
        }
        return responseResult;
    }

    public ResponseResult<OrderDetail> deleteOrderDetailPhysical(OrderDetail record) {
        ResponseResult<OrderDetail> responseResult = new ResponseResult<>();
        boolean flag = true;
        if (record != null) {
            List<OrderDetail> details = orderDetailsMapper.queryList(record);
            if (!CollectionUtils.isEmpty(details)) {
                for (OrderDetail detail : details) {
                    flag &= orderDetailsMapper.delete(detail) > 0;
                    Long orderId = detail.getOrderId();
                    List<OrderDetail> orderDetails = orderDetailsMapper.findOrderDetailByOrderId(orderId);
                    if (CollectionUtils.isEmpty(orderDetails)) {
                        flag &= orderMapper.deleteById(orderId) > 0;//该订单下已无订单明细
                    } else {
                        Orders order = new Orders();
                        order.setId(orderId);
                        order.setDetailCount((byte) orderDetails.size());
                        flag &= orderMapper.updateDetailCount(order) > 0;
                    }
                }
                if (flag) {
                    responseResult.setCode(true);
                    responseResult.setMsg("删除报告成功");
                } else {
                    responseResult.setMsg("删除报告失败");
                }
            }
        }
        if (StringUtils.isBlank(responseResult.getMsg())) {
            responseResult.setMsg("无此报告");
        }
        return responseResult;
    }

    @Override
    public ResponseResult<OrderDetail> deleteOrderDetail(Long orderDetailId) {
        ResponseResult<OrderDetail> responseResult = new ResponseResult<>();
        if (orderDetailId != null) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setId(orderDetailId);
            return deleteOrderDetail(orderDetail);
        }
        responseResult.setMsg("无此报告");
        return responseResult;
    }


    public ResponseResult<OrderDetail> deleteOrderDetailPhysical(Long orderDetailId) {
        ResponseResult<OrderDetail> responseResult = new ResponseResult<>();
        if (orderDetailId != null) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setId(orderDetailId);
            return deleteOrderDetailPhysical(orderDetail);
        }
        responseResult.setMsg("无此报告");
        return responseResult;
    }

    @Override
    public ResponseResult<OrderDetail> updateSendProvider(OrderDetail record) {
        ResponseResult<OrderDetail> responseResult = new ResponseResult<>();
        if (record != null && record.getId() != null) {
            Integer integer = orderDetailsMapper.updateSendProvider(record);
            if (integer > 0) {
                responseResult.setCode(true);
                responseResult.setMsg("修改供应商成功");
            } else {
                responseResult.setMsg("修改供应商失败");
            }
        } else {
            responseResult.setMsg("无此报告");
        }
        return responseResult;
    }

    @Override
    public ResponseResult<OrderDetail> updateReceiveProvider(OrderDetail record) {
        ResponseResult<OrderDetail> responseResult = new ResponseResult<>();
        if (record != null && record.getId() != null) {
            Integer integer = orderDetailsMapper.updateReceiveProvider(record);
            if (integer > 0) {
                responseResult.setCode(true);
                responseResult.setMsg("供应商交付成功");
            } else {
                responseResult.setMsg("供应商交付失败");
            }
        } else {
            responseResult.setMsg("无此报告");
        }

        return responseResult;
    }

    @Override
    public ResponseResult<OrderDetail> updateMake(OrderDetail record) {
        ResponseResult<OrderDetail> responseResult = new ResponseResult<>();
        if (record != null && record.getId() != null) {
            Integer integer = orderDetailsMapper.updateMake(record);
            if (integer > 0) {
                responseResult.setMsg("修改报告制作人员成功");
                responseResult.setCode(true);
            } else {
                responseResult.setMsg("修改报告制作人员失败");
            }
        } else {
            responseResult.setMsg("无此报告");
        }
        return responseResult;
    }

    @Override
    public ResponseResult<OrderDetail> updateCheck(OrderDetail record) {
        ResponseResult<OrderDetail> responseResult = new ResponseResult<>();
        if (record != null && record.getId() != null) {
            Integer integer = orderDetailsMapper.updateCheck(record);
            if (integer > 0) {
                responseResult.setMsg("修改报告审核人员成功");
                responseResult.setCode(true);
            } else {
                responseResult.setMsg("修改报告审核人员失败");
            }
        } else {
            responseResult.setMsg("无此报告");
        }
        return responseResult;
    }

    @Override
    public ResponseResult<OrderDetail> updateManger(OrderDetail record) {
        ResponseResult<OrderDetail> responseResult = new ResponseResult<>();
        if (record != null && record.getId() != null) {
            Integer integer = orderDetailsMapper.updateManger(record);
            if (integer > 0) {
                responseResult.setMsg("修改报告负责人成功");
                responseResult.setCode(true);
            } else {
                responseResult.setMsg("修改报告负责人失败");
            }
        } else {
            responseResult.setMsg("无此报告");
        }
        return responseResult;
    }

    @Override
    public ResponseResult<OrderDetail> updateFinish(OrderDetail record) {
        boolean flag = true;
        ResponseResult<OrderDetail> responseResult = new ResponseResult<>();
        if (record != null && record.getId() != null) {
            record.setFinishTime(new Date());
            Integer integer = orderDetailsMapper.updateFinish(record);
            if (integer > 0) {
                Long orderId = record.getOrderId();
                List<OrderDetail> orderDetails = orderDetailsMapper.findOrderDetailByOrderId(orderId);
                for (OrderDetail orderDetail : orderDetails) {
                    flag &= Objects.equals(orderDetail.getStatus(), OrderStatusEnum.FINISHED.getStatusCode());
                }
                if (flag) {//该订单下所有产品均已完成
                    Orders orders = new Orders();
                    orders.setId(orderId);
                    orders.setStatus(OrderStatusEnum.FINISHED.getStatusCode());
                    this.updateStatus(orders);
                }
                responseResult.setMsg("该报告已完成发布");
                responseResult.setCode(true);
            } else {
                responseResult.setMsg("报告发布失败");
            }
        } else {
            responseResult.setMsg("无此报告");
        }
        return responseResult;
    }

    @Override
    public ResponseResult<OrderDetail> updateUpload(OrderDetail record) {
        ResponseResult<OrderDetail> responseResult = new ResponseResult<>();
        OrderDetail query = orderDetailsMapper.queryById(record.getId());
        if (query != null && record.getPathFile() != null) {
            Integer integer = orderDetailsMapper.updateUpload(record);
            if (integer > 0) {
                responseResult.setMsg("报告文件上传成功");
                responseResult.setCode(true);
                OrderDetailViewQuery view = new OrderDetailViewQuery();
                view.setId(record.getId());
                List<OrderDetailView> views = orderDetailViewMapper.queryListByOrderDetailQuery(view);
                if (views.size() > 0) {
                    OrderDetailView orderDetailView = views.get(0);
                    sendEmail(orderDetailView, "reportSuccess");
                    Orders orders = orderDetailView.getOrders();
                    if (orders.getId() != null) {
                        List<OrderDetail> orderDetails = orderDetailsMapper.findOrderDetailByOrderId(orders.getId());
                        boolean flag = true;
                        if (!CollectionUtils.isEmpty(orderDetails)) {
                            for (OrderDetail orderDetail : orderDetails) {
                                flag &= orderDetail.getStatus() == OrderDetailStatusEnum.FINISHED.getStatusCode();
                            }
                            if (flag) {//若明细均完成,则该订单已完成
                                orders.setStatus(OrderStatusEnum.FINISHED.getStatusCode());
                                orderMapper.updateFinish(orders);
                            }
                        }
                    }
                }
            }
        }
        if (!responseResult.getCode()) {
            responseResult.setMsg("报告文件上传失败");
        }
        return responseResult;
    }

    @Override
    public ResponseResult<OrderDetail> updateDataUpload(OrderDetail record) {
        ResponseResult<OrderDetail> result = new ResponseResult<>();
        if (record != null && StringUtils.isNotBlank(record.getPathDataFile())) {
            Integer dataUpload = orderDetailsMapper.updateDataUpload(record);
            if (dataUpload > 0) {
                logger.info("pdf上传成功");
                result.setCode(true);
            }
        }
        if (!result.getCode()) {
            result.setMsg("修改数据报告上传路径失败");
        }

        return result;
    }

    @Override
    public ResponseResult<OrderDetail> updateDataPathUpload(OrderDetail record) {
        ResponseResult<OrderDetail> result = new ResponseResult<>();
        if (record != null) {
            Integer integer = orderDetailsMapper.updateDataUrl(record);
            if (integer > 0) {
                result.setCode(true);
            }
        }
        return result;
    }

    @Override
    public ResponseResult<OrderDetail> updateUrgent(OrderDetail record) {
        ResponseResult<OrderDetail> responseResult = new ResponseResult<>();
        if (record != null && record.getId() != null) {
            Integer integer = orderDetailsMapper.updateUrgent(record);
            if (integer > 0) {
                responseResult.setMsg("此报告已改为加急");
                responseResult.setCode(true);
            } else {
                responseResult.setMsg("修改报告加急失败");
            }
        } else {
            responseResult.setMsg("无此报告");
        }
        return responseResult;
    }

    @Override
    public ResponseResult<Orders> paid(PayBackBean payBackBean) {
        ResponseResult<Orders> responseResult = new ResponseResult<>();
        if (payBackBean != null && payBackBean.getOrderNo() != null) {
            Orders order = new Orders();
            order.setNo(payBackBean.getOrderNo());
            Orders query = orderMapper.query(order);
            if (query != null && !query.getHasPay()) {
                List<OrderDetail> orderDetails = orderDetailsMapper.findOrderDetailByOrderId(query.getId());
                if (!CollectionUtils.isEmpty(orderDetails)) {
                    query.setAmountActual(payBackBean.getAmount());
                    query.setPayMethod(Byte.parseByte(payBackBean.getPayMethod() + ""));
                    ResponseResult<Orders> updatePay = this.updatePay(query);
                    if (updatePay.getCode()) {//支付成功,加载数据 TODO:判断是否为lv3客户
                        Orders content = updatePay.getContent();
                        if (Objects.equals(content.getSource(), SourceEnum.GLOBAL_EAGLE.getSource())) {
                            sendEmail(content, "order");
                        } else if (Objects.equals(content.getSource(), SourceEnum.GLOBAL_SEARCH.getSource())) {
                            sendEmail(content, "orderEN");
                        } else if (Objects.equals(content.getSource(), SourceEnum.GUGU.getSource())) {
                            return updatePay;
                        }
                        for (OrderDetail orderDetail : orderDetails) {
                            Product product = productMapper.queryById(orderDetail.getProductId());
                            if (product.getLevel() > 1) {//大于99报告向cpm下单
                                saveOrderToCPM(query);
                            }
                            if (StringUtils.isBlank(orderDetail.getPathData())) {
                                reloadData(orderDetail.getId());
                            }
                        }
                    }
                    return updatePay;
                }
            } else {
                responseResult.setMsg("您已支付过此订单,请勿重复操作");
            }
        } else {
            responseResult.setMsg("支付失败,无此订单");
        }
        return responseResult;
    }

    @Override
    public String saveData(OrderDetail record) throws IOException {
        String data = record.getData();
        Boolean dbIsUpDate = record.getDbIsUpDate();
        Boolean cpmIsUpdate = record.getCpmIsUpdate();
        String fileName = record.getId() + System.currentTimeMillis() + ".txt";
        record.setDbIsUpDate(null);
        record.setCpmIsUpdate(null);
        record = orderDetailsMapper.query(record);
        String dataPath = null;
        if (StringUtils.isNotBlank(data) && record != null) {
            FileWriter fileWriter = null;
            String path = this.getClass().getResource("/").getPath();
            SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
            String format = yyyyMMdd.format(new Date());
            File file = new File(path + format);
            if (!file.exists())
                file.mkdirs();
            dataPath = path + format + "/" + fileName;
            try {
                fileWriter = new FileWriter(dataPath);
                fileWriter.write(data);
                fileWriter.flush();
                String uploadPath = FastDFSClient.uploadFile(new File(dataPath), fileName);
                if (StringUtils.isNotBlank(uploadPath)) {
                    record.setPathData(uploadPath);
                    if (dbIsUpDate != null && dbIsUpDate) {
                        record.setDbIsUpDate(true);
                    }
                    if (cpmIsUpdate != null && cpmIsUpdate) {
                        record.setCpmIsUpdate(true);
                    }
                    orderDetailsMapper.updateDataUrl(record);

                    try {
                        Map<String, Object> pdfMapData = new HashMap<>();
                        OrderDetailView view = orderDetailViewMapper.queryById(record.getId());
                        Integer productId = record.getProductId();
                        Product product = productMapper.queryById(productId);
                        if (product != null) {
                            if (product.getLevel() == 1 && product.getSource() == 1) {
                                pdfMapData.put("code", "cn_two");
                            } else if ((product.getLevel() == 2 || product.getLevel() == 3) && product.getSource() == 1) {
                                pdfMapData.put("code", "cn_three");
                            } else if (product.getLevel() == 2 && product.getSource() == 2) {
                                pdfMapData.put("code", "en_three");
                            } else if ((product.getLevel() == 1 && product.getSource() == 2)) {
                                pdfMapData.put("code", "en_two");
                            } else if ((product.getLevel() == 3 && product.getSource() == 2)) {
                                pdfMapData.put("code", "en_four");
                            }
                            pdfMapData.put("fullreport", data);
                            pdfMapData.put("orderDetailView", JSON.toJSONString(view));
                            MqRecord<Map> pdfRecord = new MqRecord<>();
                            pdfRecord.setContent(pdfMapData);
                            pdfRecord.setMqType(MqTypeEnum.ORDER_PDF_DATAPDF.getValue());
                            orderJmsTemplate.send(creditQueue, new OrderMessageCreator(JSON.toJSONString(pdfRecord)));//拿到en/cn的消息后发送data数据消息到pdf队列
                        }
                    } catch (JmsException e) {
                        e.printStackTrace();
                        logger.error("发送pdf数据错误" + e);
                    }
                }
                return uploadPath;
            } finally {
                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (StringUtils.isNotBlank(dataPath)) {
                    delFile(dataPath);
                }
            }
        }
        return null;
    }

    @Override
    public void saveDataUrl(OrderDetail record){
        if (record != null && StringUtils.isNotBlank(record.getPathData())) {
            Boolean dbIsUpDate = record.getDbIsUpDate();
            Boolean cpmIsUpdate = record.getCpmIsUpdate();
            String uploadPath = record.getPathData();
            record.setDbIsUpDate(null);
            record.setCpmIsUpdate(null);
            record = orderDetailsMapper.query(record);
            record.setPathData(uploadPath);
            if (dbIsUpDate != null && dbIsUpDate) {
                record.setDbIsUpDate(true);
            }
            if (cpmIsUpdate != null && cpmIsUpdate) {
                record.setCpmIsUpdate(true);
            }
            orderDetailsMapper.updateDataUrl(record);
        }
    }


    public void sendEmail(Orders orders, String templateType) {
        if (StringUtils.isNotBlank(orders.getCustomerEmail())) {
            Map<String, Object> map = new HashMap<>();
            if (Objects.equals(orders.getSource(), SourceEnum.GLOBAL_SEARCH.getSource())) {
                map.put("invokeObj", "globalSearch");
            } else if (Objects.equals(orders.getSource(), SourceEnum.GLOBAL_EAGLE.getSource())) {
                map.put("invokeObj", "globalEagle");
            }
            map.put("templateType", templateType);
            Map<String, Object> mapData = new HashMap<>();
            mapData.put("orders", JSON.toJSONString(orders));
            mapData.put("toAddress", orders.getCustomerEmail());
            map.put("mapData", JSON.toJSONString(mapData));
            MqRecord<Map> mqRecord = new MqRecord<>();
            mqRecord.setContent(map);
            mqRecord.setMqType(MqTypeEnum._EMAIL_SENDEMAIL.getValue());
            orderJmsTemplate.send(creditQueue, new OrderMessageCreator(JSON.toJSONString(mqRecord)));//给email消息队列发送消息
        }
    }

    public void sendEmail(OrderDetailView orders, String templateType) {
        if (StringUtils.isNotBlank(orders.getCustomerEmail())) {
            Map<String, Object> map = new HashMap<>();
            Map<String, Object> mapData = new HashMap<>();
            if (Objects.equals(orders.getSource(), SourceEnum.GLOBAL_SEARCH.getSource())) {
                map.put("invokeObj", "globalSearch");
            } else if (Objects.equals(orders.getSource(), SourceEnum.GLOBAL_EAGLE.getSource())) {
                map.put("invokeObj", "globalEagle");
            }
            map.put("templateType", templateType);
            mapData.put("orderDetailView", JSON.toJSONString(orders));
            mapData.put("toAddress", orders.getCustomerEmail());
            map.put("mapData", JSON.toJSONString(mapData));
            MqRecord<Map> mqRecord = new MqRecord<>();
            mqRecord.setContent(map);
            mqRecord.setMqType(MqTypeEnum._EMAIL_SENDEMAIL.getValue());
            orderJmsTemplate.send(creditQueue, new OrderMessageCreator(JSON.toJSONString(mqRecord)));//给email消息队列发送消息
        }
    }

    @Override
    public ResponseResult<OrderDetail> reloadData(Long orderDetailId) {
        ResponseResult<OrderDetail> responseResult = new ResponseResult<>();
        OrderDetail orderDetail = orderDetailsMapper.queryById(orderDetailId);
        if (orderDetail != null) {
            MqRecord<Map> mqRecord = new MqRecord<>();
            Map<String, Object> mapData = new HashMap<>();
            mapData.put("crefoNo", orderDetail.getCrefoNo());
            //companyNameCN只适用于全搜
            if (StringUtils.isNotBlank(orderDetail.getCompanyNameCN())) {
                mapData.put("companyName", orderDetail.getCompanyNameCN());
            } else {
                mapData.put("companyName", orderDetail.getCompanyName());
            }
            mapData.put("companyNo", orderDetail.getCompanyNo());
            mapData.put("productId", orderDetail.getProductId());
            mapData.put("orderDetailId", orderDetail.getId());
            Integer productId = orderDetail.getProductId();
            Product product = productMapper.queryById(productId);
            Byte productType = product.getProductType();
            mapData.put("typeCode", productType);
            mapData.put("level", product.getLevel());
            mqRecord.setContent(mapData);
            if (productType.equals(ProductTypeEnum.CHINA.getTypeCode())) {//中国报告
                mqRecord.setMqType(MqTypeEnum.ORDER_CN_FULLREPORT.getValue());
                orderJmsTemplate.send(creditQueue, new MessageCreator() {
                    @Override
                    public Message createMessage(Session session) throws JMSException {
                        String msg = JSONObject.toJSONString(mqRecord);
                        return session.createTextMessage(msg);
                    }
                });
            } else if (productType.equals(ProductTypeEnum.FOREIGN.getTypeCode())) {//外国报告
                mqRecord.setMqType(MqTypeEnum.ORDER_EN_FULLREPORT.getValue());
                orderJmsTemplate.send(creditQueue, new MessageCreator() {
                    @Override
                    public Message createMessage(Session session) throws JMSException {
                        String msg = JSONObject.toJSONString(mqRecord);
                        return session.createTextMessage(msg);
                    }
                });
            }
            responseResult.setMsg("重新加载报告数据成功");
            responseResult.setCode(true);
            responseResult.setContent(orderDetail);
            return responseResult;

        }
        responseResult.setMsg("重新加载报告数据失败");
        return responseResult;
    }

    @Override
    public ResponseResult<OrderDetail> reloadFinanceDataFromCPM(Long orderDetailId, String crefoNo) {
        ResponseResult<OrderDetail> result = reloadData(orderDetailId);
        if (result.getCode()) {
            OrderDetail detail = result.getContent();
            detail.setStatus(OrderDetailStatusEnum.MAKING.getStatusCode());
            Integer updateStatus = orderDetailsMapper.updateStatus(detail);
            if (updateStatus <= 0) {
                result.setCode(false);
                result.setMsg("重新加载报告数据失败");
            }
        }
        return result;
    }

    public static String getData(String dataUrl) {
        InputStream in = null;
        try {
            if (StringUtils.isNotBlank(dataUrl)) {
                InputStream stream = FastDFSClient.downloadFile(dataUrl);//从文件系统获取data数据
                if (stream != null) {
                    in = new BufferedInputStream(stream);
                    byte[] bytes = new byte[1024 * 10];
                    int len = 0;
                    StringBuilder data = new StringBuilder();
                    while ((len = in.read(bytes)) != -1) {
                        data.append(new String(bytes, 0, len));
                    }
                    return data.toString();
                }
            }
            return "";
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 上传手工pdf文件至本地
     *
     * @param in
     * @return
     */
    private String uploadPath(String fileName, byte[] in) {
        OutputStream out = null;
        try {
            String dataPath = this.getClass().getResource("/").getPath();
            String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
            File pdfFile = new File(dataPath + format);
            if (!pdfFile.exists()) {
                pdfFile.mkdirs();
            }
            dataPath = dataPath + format + "/" + fileName;
            out = new BufferedOutputStream(new FileOutputStream(dataPath));
            out.write(in);
            return dataPath;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 上传文件系统后删除本地文件
     *
     * @param filePath
     */
    public static void delFile(String filePath) {
        File file = new File(filePath);
        if (file.isFile()) {
            boolean delete = file.delete();
            if (delete) {
                logger.info("文件" + filePath + "删除成功");
            }
        }
    }
}
