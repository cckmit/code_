package com.mika.credit.facade.order.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.order.OrderStatusEnum;
import com.mika.credit.common.entity.order.Orders;
import com.mika.credit.common.entity.order.Product;
import com.mika.credit.common.util.HttpUtil;
import com.mika.credit.common.util.UtilGenerateID;
import com.mika.credit.facade.coredb.en.entity.FullReportEN;
import com.mika.credit.facade.order.dao.BusinessOrderMapper;
import com.mika.credit.facade.order.entity.BusinessOrder;
import com.mika.credit.facade.order.entity.BusinessOrderQuery;
import com.mika.credit.facade.order.entity.OrdersBiz;
import com.mika.credit.facade.order.service.BusinessOrderService;
import com.mika.credit.facade.order.service.ProductService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Gavin on 2017/5/9.
 */

@SuppressWarnings("Duplicates")
@Service("businessOrderService")
public class BusinessOrderServiceImpl implements BusinessOrderService {
    private static Logger logger = Logger.getLogger(BusinessOrderServiceImpl.class);
    @Autowired
    private BusinessOrderMapper businessOrderMapper;
    @Autowired
    private ProductService productService;
    @Value("${CPMOrderUrl}")
    private String CPMOrderUrl;
    @Value("${BIGNETOrderUrl}")
    private String BIGNETOrderUrl;

    @Override
    public BootGrid<BusinessOrder> find(BootGrid<BusinessOrder> bootGrid, BusinessOrderQuery example) {
        logger.info("进入查询商业订单find方法");
        if (bootGrid != null && example != null) {
            //+1天，否则查询有误
            Date createDateTo = example.getCreateDateTo();
            if (createDateTo != null) {
                Calendar c = Calendar.getInstance();
                c.setTime(createDateTo);
                c.add(Calendar.DATE, 1);
                example.setCreateDateTo(c.getTime());
            }
            Page<BusinessOrder> page = PageHelper.startPage(bootGrid.getCurrent(), bootGrid.getRowCount());
            bootGrid.setRows(businessOrderMapper.selectByQuery(example));
            bootGrid.setTotal((int) page.getTotal());
            bootGrid.setResult(true);
        }
        logger.info("find商业订单查询方法结束,返回结果:" + JSON.toJSONString(bootGrid));
        return bootGrid;
    }

    @Override
    public List<BusinessOrder> find(BusinessOrderQuery example) {
        logger.info("进入查询商业订单find方法");
        if (example != null) {
            List<BusinessOrder> businessOrders = businessOrderMapper.selectByQuery(example);
            logger.info("find商业订单查询方法结束,返回结果:" + JSON.toJSONString(businessOrders));
            return businessOrders;
        }
        return null;
    }

    @Override
    public ResponseResult<BusinessOrder> findById(Long id) {
        logger.info("进入查询商业订单findById方法");
        ResponseResult<BusinessOrder> responseResult = new ResponseResult<>();
        if (id != null) {
            BusinessOrder businessOrder = businessOrderMapper.selectByPrimaryKey(id);
            if (businessOrder != null) {
                responseResult.setCode(true);
                responseResult.setContent(businessOrder);
            }
        }
        if (!responseResult.getCode()) {
            responseResult.setMsg("无此订单");
        }
        logger.info("findById商业订单查询方法结束,返回结果:" + JSON.toJSONString(responseResult));
        return responseResult;
    }

    @Override
    public ResponseResult<BusinessOrder> findByNO(String no) {
        logger.info("进入查询商业订单findByNO方法");
        ResponseResult<BusinessOrder> responseResult = new ResponseResult<>();
        if (no != null) {
            BusinessOrder businessOrder = businessOrderMapper.selectByNO(no);
            if (businessOrder != null) {
                responseResult.setCode(true);
                responseResult.setContent(businessOrder);
            }
        }
        if (!responseResult.getCode()) {
            responseResult.setMsg("无此订单");
        }
        logger.info("findByNO商业订单查询方法结束,返回结果:" + JSON.toJSONString(responseResult));
        return responseResult;
    }

    @Override
    public ResponseResult<BusinessOrder> findByIdWithData(Long id) {
        logger.info("进入查询商业订单findByIdWithData方法");
        ResponseResult<BusinessOrder> result = new ResponseResult<>();
        if (id != null) {
            result = this.findById(id);
            if (result.getCode()) {
                BusinessOrder order = result.getContent();
                if (StringUtils.isNotBlank(order.getPathData())) {
                    result.setCode(true);
                    String data = OrderServiceImpl.getData(order.getPathData());
                    FullReportEN report = JSON.parseObject(data, FullReportEN.class);
                    order.setFullReportData(report);
                }
            }
        }
        if (!result.getCode()) {
            result.setMsg("查询失败");
        }
        logger.info("findById商业订单查询方法结束,返回结果:" + JSON.toJSONString(result));
        return result;
    }

    @Override
    public ResponseResult<BusinessOrder> findByNOWithData(String no) {
        logger.info("进入查询商业订单findByNOWithData方法");
        ResponseResult<BusinessOrder> result = new ResponseResult<>();
        if (StringUtils.isNotBlank(no)) {
            result = this.findByNO(no);
            if (result.getCode()) {
                BusinessOrder order = result.getContent();
                if (StringUtils.isNotBlank(order.getPathData())) {
                    result.setCode(true);
                    String data = OrderServiceImpl.getData(order.getPathData());
                    FullReportEN report = JSON.parseObject(data, FullReportEN.class);
                    order.setFullReportData(report);
                }
            }
        }
        if (!result.getCode()) {
            result.setMsg("查询失败");
        }
        logger.info("findByNOWithData商业订单查询方法结束,返回结果:" + JSON.toJSONString(result));
        return result;
    }

    @Override
    public ResponseResult<BusinessOrder> save(BusinessOrder record) {
        logger.info("进入保存商业订单save方法");
        ResponseResult<BusinessOrder> responseResult = new ResponseResult<>();
        if (record != null) {
            Integer productId = record.getProductId();
            if (productId != null) {
                ResponseResult<Product> result = productService.findProductById(productId);
                if (result.getCode()) {
                    record.setNo(UtilGenerateID.generateID("BOR"));
                    //BigInteger lastEntryId = businessOrderMapper.findLastEntryId(null);//最大的entryId
                    //if (lastEntryId == null) {
                    //    lastEntryId = BigInteger.ZERO;
                    //}
                    //record.setExpectHour(result.getContent().getExpectHour());
                    //record.setEntryId(lastEntryId.add(BigInteger.ONE));
                    record.setCreateTime(new Date());
                    record.setStatus(OrderStatusEnum.MAKING.getStatusCode());
                    if (businessOrderMapper.insertSelective(record) > 0) {
                        responseResult.setCode(true);
                        responseResult.setContent(record);
                        if (result.getContent().getLevel() >= 5) {
                            saveOrderToCPM(record);//bigNet订单等级大于5向cpm下单
                        }
                    }
                } else {
                    responseResult.setMsg("无此产品,订单无效");
                }
            } else {
                responseResult.setMsg("信息缺失,订单无效");
            }

        }
        logger.info("商业订单保存方法save结束,返回结果:" + JSON.toJSONString(responseResult));
        return responseResult;
    }

    @Override
    public boolean updateDataURLById(BusinessOrder record) {
        logger.info("进入修改商业订单数据文件路径updateDataURLById方法");
        boolean result = false;
        //TODO 进行必要的非空判断
        if (record != null && StringUtils.isNotBlank(record.getPathData()) && record.getId() != null) {
            Long id = record.getId();
            BusinessOrder businessOrder = businessOrderMapper.selectByPrimaryKey(id);
            if (businessOrder != null) {
                //若该订单为level5等级且在制作中,以参数状态为准
                if (businessOrder.getProductId() == 15 && businessOrder.getStatus().equals(OrderStatusEnum.MAKING.getStatusCode())) {
                    businessOrder.setStatus(record.getStatus());
                } else {
                    businessOrder.setStatus(OrderStatusEnum.FINISHED.getStatusCode());
                }
                businessOrder.setPathData(record.getPathData());
                result = updateDataURL(businessOrder);
            }
        }
        logger.info("修改商业订单数据文件路径updateDataURLById结束,返回结果:" + result);
        return result;
    }

    @Override
    public boolean updateDataURLByNO(BusinessOrder record) {
        logger.info("进入修改商业订单数据文件路径updateDataURLByNO方法");
        boolean result = false;
        //TODO 进行必要的非空判断
        if (record != null && StringUtils.isNotBlank(record.getPathData()) && record.getNo() != null) {
            String no = record.getNo();
            String url = record.getPathData();
            BusinessOrder businessOrder = businessOrderMapper.selectByNO(no);
            if (businessOrder != null) {
                //若该订单为level5等级且在制作中,以参数状态为准
                if (businessOrder.getProductId() == 15 && businessOrder.getStatus().equals(OrderStatusEnum.MAKING.getStatusCode())) {
                    businessOrder.setStatus(record.getStatus());
                } else {
                    businessOrder.setStatus(OrderStatusEnum.FINISHED.getStatusCode());
                }
                businessOrder.setPathData(record.getPathData());
                result = updateDataURL(businessOrder);
            }
        }
        logger.info("修改商业订单数据文件路径updateDataURLByNO结束,返回结果:" + result);
        return result;
    }

    //@Override
    //public ResponseResult<BusinessOrder> deleteBusinessOrder(BusinessOrder record) {
    //    logger.info("进入删除business订单deleteBusinessOrder方法");
    //    ResponseResult<BusinessOrder> result = new ResponseResult<>();
    //    if (record != null) {
    //        if (businessOrderMapper.delete(record) > 0) {
    //            result.setCode(true);
    //            result.setMsg("删除成功");
    //        }
    //    }
    //    if (!result.getCode()) {
    //        result.setMsg("删除失败");
    //    }
    //    logger.info("删除business订单deleteBusinessOrder方法结束,返回结果:" + JSON.toJSONString(result));
    //    return result;
    //}

    private boolean updateDataURL(BusinessOrder businessOrder) {
        String syncData = "false";
        businessOrder.setFinishTime(new Date());
        if (businessOrderMapper.updateByPrimaryKeySelective(businessOrder) > 0) {
            Boolean result = businessOrder.getStatus() == 8;
            String bigUrl = BIGNETOrderUrl + "?orderId=" + businessOrder.getId() + "&result=" + result + "&msg=" + businessOrder.getRemark();
            //TODO:http调用bigNet服务,获取返回值,表示该订单已完成
            syncData = HttpUtil.syncData(bigUrl);
        }
        return Boolean.valueOf(syncData);
    }

    //private boolean updateDataURL(BusinessOrder businessOrder) {
    //    BigInteger entryId = businessOrder.getEntryId();
    //    BigInteger max = getLastFinishedEntryId();//最近制作完成订单的entryId
    //    BusinessOrder lastMakingOrder = businessOrderMapper.findOrderByEntryId(max.add(BigInteger.ONE));//最近制作中的订单
    //    if (lastMakingOrder != null) {
    //        lastMakingOrder.setEntryId(entryId);//交换entryId
    //        businessOrderMapper.updateByPrimaryKeySelective(lastMakingOrder);
    //    }
    //    businessOrder.setEntryId(max.add(BigInteger.ONE));
    //    //businessOrder.setPathData(url);
    //    businessOrder.setStatus(OrderStatusEnum.FINISHED.getStatusCode());
    //    businessOrder.setFinishTime(new Date());
    //    return businessOrderMapper.updateByPrimaryKeySelective(businessOrder) > 0;
    //}

    //@Override
    //public ResponseResult<BusinessOrder> findOrderByEntryId(BigInteger entryId) {
    //    logger.info("进入根据entryId查询订单findOrderByEntryId方法");
    //    ResponseResult<BusinessOrder> result = new ResponseResult<>();
    //    if (entryId != null) {
    //        BusinessOrder businessOrder = businessOrderMapper.findOrderByEntryId(entryId);
    //        if (businessOrder != null) {
    //            result.setCode(true);
    //            result.setContent(businessOrder);
    //        }
    //    }
    //    if (!result.getCode()) {
    //        result.setMsg("无此订单");
    //    }
    //    logger.info("根据entryId查询订单findOrderByEntryId方法结束,返回结果:" + JSON.toJSONString(result));
    //    return result;
    //}
    //
    //@Override
    //public ResponseResult<BusinessOrder> findAfterEntryId(BigInteger entryId) {
    //    logger.info("进入查询此entryId后续订单findAfterEntryId方法");
    //    ResponseResult<BusinessOrder> result = new ResponseResult<>();
    //    if (entryId != null) {
    //        List<BusinessOrder> businessOrderList = businessOrderMapper.findOrderListByEntryId(entryId);
    //        if (CollectionUtils.isNotEmpty(businessOrderList)) {
    //            result.setCode(true);
    //            result.setResult(businessOrderList);
    //        }
    //    }
    //    if (!result.getCode()) {
    //        result.setMsg("无此订单");
    //    }
    //    logger.info("查询此entryId后续订单方法方法结束,返回结果:" + JSON.toJSONString(result));
    //    return result;
    //}

    @Override
    public ResponseResult<BusinessOrder> doReportFailed(BusinessOrder record) {
        ResponseResult<BusinessOrder> result = new ResponseResult<>();
        boolean flag = true;
        if (record != null && StringUtils.isNotBlank(record.getCrefoNo())) {
            BusinessOrderQuery order = new BusinessOrderQuery();
            String crefoNo = record.getCrefoNo();
            order.setCrefoNo(crefoNo);
            order.setStatus(OrderStatusEnum.MAKING.getStatusCode());
            //order.setProductId(15);
            List<BusinessOrder> businessOrders = businessOrderMapper.selectByQuery(order);
            if (CollectionUtils.isNotEmpty(businessOrders)) {
                for (BusinessOrder businessOrder : businessOrders) {
                    businessOrder.setStatus(OrderStatusEnum.FAILURE.getStatusCode());
                    //BigInteger lastFinishedEntryId = getLastFinishedEntryId();
                    //BusinessOrder orderByEntryId = businessOrderMapper.findOrderByEntryId(lastFinishedEntryId.add(BigInteger.ONE));
                    //if (orderByEntryId != null) {
                    //    orderByEntryId.setEntryId(businessOrder.getEntryId());
                    //    businessOrderMapper.updateEntryId(orderByEntryId);
                    //}
                    //businessOrder.setEntryId(lastFinishedEntryId.add(BigInteger.ONE));
                    //TODO:订单制作失败调用bignet接口
                    //flag &= businessOrderMapper.updateByPrimaryKeySelective(businessOrder) > 0;
                    flag &= updateDataURL(businessOrder);
                }
            } else {
                flag = false;
            }
        }
        if (flag) {
            result.setCode(true);
            result.setMsg("已标识订单制作失败");
        }
        return result;
    }

    //@Override
    //public ResponseResult<BusinessOrder> updateStatus(BusinessOrder businessOrder) {
    //    logger.info("进入更改订单状态updateStatus方法");
    //    ResponseResult<BusinessOrder> result = new ResponseResult<>();
    //    result.setContent(businessOrder);
    //    if (businessOrder != null && businessOrder.getStatus() != null) {
    //        if (businessOrderMapper.updateStatus(businessOrder) > 0) {
    //            result.setCode(true);
    //        }
    //    }
    //    if (!result.getCode()) {
    //        result.setMsg("修改订单状态失败");
    //    }
    //    logger.info("更改订单状态updateStatus方法结束,返回结果:" + JSON.toJSONString(result));
    //    return result;
    //}

    //@Override
    //public ResponseResult<BusinessOrder> updateEntryId(BusinessOrder record) {
    //    logger.info("进入更改订单entryId方法");
    //    ResponseResult<BusinessOrder> result = new ResponseResult<>();
    //    result.setContent(record);
    //    if (record != null) {
    //        if (businessOrderMapper.updateEntryId(record) > 0) {
    //            result.setCode(true);
    //        }
    //    }
    //    if (!result.getCode()) {
    //        result.setMsg("修改entryId失败");
    //    }
    //    logger.info("进入更改订单entryId方法结束,返回结果:" + JSON.toJSONString(result));
    //    return result;
    //}
    //
    //public BigInteger getLastFinishedEntryId() {
    //    BigInteger finishedEntryId = businessOrderMapper.findLastEntryId(OrderStatusEnum.FINISHED.getStatusCode());
    //    BigInteger failureEntryId = businessOrderMapper.findLastEntryId(OrderStatusEnum.FAILURE.getStatusCode());
    //    if (finishedEntryId == null) {
    //        finishedEntryId = BigInteger.ZERO;
    //    }
    //    if (failureEntryId == null) {
    //        failureEntryId = BigInteger.ZERO;
    //    }
    //    return finishedEntryId.max(failureEntryId);//最近制作完成订单的entryId
    //}

    public ResponseResult<Orders> saveOrderToCPM(BusinessOrder record) {
        if (record != null) {
            String cpmCustomerId = "8953";
            //String orderSourceId = "3";
            String reportTypeId = "2";
            //List<OrderDetail> orderDetails = this.findOrderDetailByOrderId(record.getId());
            try {
                ResponseResult<Product> responseResult = productService.findProductById(record.getProductId());
                if (responseResult.getCode()) {
                    String url = CPMOrderUrl;
                    OrdersBiz ordersBiz = new OrdersBiz();
                    //companyName = java.net.URLEncoder.encode(companyName, "UTF-8");
                    ordersBiz.setNote(responseResult.getContent().getLevel() + "");
                    ordersBiz.setCid(Integer.parseInt(cpmCustomerId));
                    ordersBiz.setBizid(Integer.parseInt(record.getId() + ""));
                    ordersBiz.setReportTypeId(reportTypeId);
                    ordersBiz.setCrefoNo(record.getCrefoNo().replace("CN", ""));
                    //ordersBiz.setBizid(Integer.parseInt(globalHawkid + ""));
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
                }
            } catch (Exception e) {
                logger.error("\n-------------------------------------------\n");
                logger.error("Error Message:" + e.getMessage(), e);
                logger.error("\n-------------------------------------------\n");
            }

        }
        return null;
    }


    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate localDate = LocalDate.parse("2017-05-25");
        System.out.println(localDate.getMonth());
        int year = now.getYear();
        System.out.println(year);
    }
}
