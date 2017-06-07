package com.mika.credit.facade.order.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.MqRecord;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.order.*;
import com.mika.credit.common.entity.pay.PayBackBean;
import com.mika.credit.common.enums.MqTypeEnum;
import com.mika.credit.common.util.UtilGenerateID;
import com.mika.credit.facade.order.dao.ProductMapper;
import com.mika.credit.facade.order.dao.QuickOrderMapper;
import com.mika.credit.facade.order.mq.OrderMessageCreator;
import com.mika.credit.facade.order.service.QuickOrderService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.jms.Destination;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by dell on 2017/3/17.
 */
@Service("quickOrderService")
public class QuickOrderServiceImpl implements QuickOrderService {
    private static final Log logger = LogFactory.getLog(QuickOrderServiceImpl.class);
    @Autowired
    private QuickOrderMapper quickOrderMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    @Qualifier("orderJmsTemplate")
    private JmsTemplate orderJmsTemplate;
    @Autowired
    @Qualifier("creditQueue")
    private Destination emailQueue;//需要发送的队列:en
    @Override
    public ResponseResult<QuickOrder> saveQuickOrder(QuickOrder quickOrder) {
        logger.info("进入保存快速订单saveQuickOrder方法");
        ResponseResult<QuickOrder> responseResult = new ResponseResult<>();
        if (quickOrder != null) {
            if (StringUtils.isBlank(quickOrder.getCompanyName())||StringUtils.isBlank(quickOrder.getCompanyArea())||
            StringUtils.isBlank(quickOrder.getCompanyCountry())||quickOrder.getProductId()==null){
                responseResult.setMsg("信息不全,订单保存失败");
                responseResult.setCode(false);
                return responseResult;
            }
            quickOrder.setOrderNo(UtilGenerateID.generateID("GE"));
            quickOrder.setNo(UtilGenerateID.generateID("QO"));
            quickOrder.setStatus(OrderStatusEnum.TO_PAY.getStatusCode());
            quickOrder.setCreateTime(new Date());
            Integer productId = quickOrder.getProductId();
            Product product = productMapper.queryById(productId);
            if (product != null) {
                BigDecimal price = product.getPrice();
                quickOrder.setAmount(price);
                quickOrder.setAmountActual(price);
                quickOrder.setHasPay(false);
                int save = quickOrderMapper.save(quickOrder);
                if (save > 0) {
                    sendEmail(quickOrder,"fastOrder");
                    responseResult.setMsg("快速订单保存成功");
                    responseResult.setCode(true);
                    responseResult.setContent(quickOrder);
                }
            }
        }
        if (!responseResult.getCode()) {
            responseResult.setMsg("快速订单保存失败");
        }
        logger.info("保存快速订单saveQuickOrder方法结束,返回结果:"+ JSON.toJSONString(responseResult));
        return responseResult;
    }

    @Override
    public ResponseResult<QuickOrder> findQuickOrderById(Long quickOrderId) {
        logger.info("进入根据快速订单id查询快速订单findQuickOrderById方法");
        ResponseResult<QuickOrder> responseResult = new ResponseResult<>();
        if (quickOrderId != null) {
            QuickOrder quickOrder = quickOrderMapper.queryById(quickOrderId);
            if (quickOrder != null) {
                responseResult.setContent(quickOrder);
                responseResult.setCode(true);
            }
        }
        if (!responseResult.getCode()) {
            responseResult.setMsg("查询快速订单失败");
        }
        logger.info("根据快速订单id查询快速订单方法findQuickOrderById结束,返回结果:"+ JSON.toJSONString(responseResult));
        return responseResult;
    }

    @Override
    public BootGrid<QuickOrder> findQuickOrders(BootGrid<QuickOrder> bootGrid, QuickOrderQuery example) {
        logger.info("进入根据条件查询快速订单findQuickOrders方法");
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
            bootGrid.setRows(quickOrderMapper.queryListByOrderQuery(example));
            bootGrid.setTotal((int) page.getTotal());
            bootGrid.setResult(true);
        }
        logger.info("进入条件查询快速订单findQuickOrders方法,返回结果:"+ JSON.toJSONString(bootGrid));
        return bootGrid;
    }

    @Override
    public ResponseResult<QuickOrder> deleteQuickOrder(Long quickOrderId) {
        logger.info("进入根据订单id取消快速订单deleteQuickOrder方法");
        ResponseResult<QuickOrder> responseResult = new ResponseResult<>();
        if (quickOrderId != null) {
            int delete = quickOrderMapper.deleteById(quickOrderId);
            if (delete > 0) {
                responseResult.setMsg("快速订单取消成功");
                responseResult.setCode(true);
            } else {
                responseResult.setMsg("快速订单取消失败");
            }
        } else {
            responseResult.setMsg("没有此项订单");
        }
        logger.info("根据订单id取消快速订单deleteQuickOrder方法结束,返回结果:"+JSON.toJSONString(responseResult));
        return responseResult;
    }

    @Override
    public ResponseResult<QuickOrder> deleteQuickOrderPhysical(Long quickOrderId) {
        logger.info("进入根据订单id删除快速订单deleteQuickOrderPhysical方法");
        ResponseResult<QuickOrder> responseResult = new ResponseResult<>();
        if (quickOrderId != null) {
            QuickOrder quickOrder = new QuickOrder();
            quickOrder.setStatus(OrderStatusEnum.CANCELED.getStatusCode());
            quickOrder.setId(quickOrderId);
            int delete = quickOrderMapper.updateStatus(quickOrder);
            if (delete > 0) {
                responseResult.setMsg("快速订单删除成功");
                responseResult.setCode(true);
            } else {
                responseResult.setMsg("快速订单删除失败");
            }
        } else {
            responseResult.setMsg("没有此项订单");
        }
        logger.info("根据订单id删除快速订单deleteQuickOrderPhysical方法结束,返回结果:"+JSON.toJSONString(responseResult));
        return responseResult;
    }

    @Override
    public ResponseResult<QuickOrder> deleteQuickOrder(QuickOrder record) {
        logger.info("进入根据条件取消快速订单deleteQuickOrder方法");
        boolean flag = true;
        ResponseResult<QuickOrder> responseResult = new ResponseResult<>();
        if (record != null) {
            List<QuickOrder> quickOrders = quickOrderMapper.queryList(record);
            if (!CollectionUtils.isEmpty(quickOrders)) {
                for (QuickOrder quickOrder : quickOrders) {
                    quickOrder.setStatus(OrderStatusEnum.CANCELED.getStatusCode());
                    flag &= quickOrderMapper.updateStatus(quickOrder) > 0;
                }
                if (flag) {
                    responseResult.setMsg("取消快速订单成功");
                    responseResult.setCode(true);
                } else {
                    responseResult.setMsg("取消快速订单失败");
                }
            } else {
                responseResult.setMsg("没有此项订单");
            }
        } else {
            responseResult.setMsg("没有此项订单");
        }
        logger.info("根据条件取消快速订单deleteQuickOrder方法结束,返回结果:"+JSON.toJSONString(responseResult));
        return responseResult;
    }

    @Override
    public ResponseResult<QuickOrder> deleteQuickOrderPhysical(QuickOrder record) {
        logger.info("进入根据条件删除快速订单deleteQuickOrderPhysical方法");
        boolean flag = true;
        ResponseResult<QuickOrder> responseResult = new ResponseResult<>();
        if (record != null) {
            List<QuickOrder> quickOrders = quickOrderMapper.queryList(record);
            if (!CollectionUtils.isEmpty(quickOrders)) {
                for (QuickOrder quickOrder : quickOrders) {
                    flag &= quickOrderMapper.deleteById(quickOrder.getId()) > 0;
                }
                if (flag) {
                    responseResult.setMsg("删除快速订单成功");
                    responseResult.setCode(true);
                } else {
                    responseResult.setMsg("删除快速订单失败");
                }
            } else {
                responseResult.setMsg("没有此项订单");
            }
        } else {
            responseResult.setMsg("没有此项订单");
        }
        logger.info("根据条件删除快速订单deleteQuickOrderPhysical方法结束,返回结果:"+JSON.toJSONString(responseResult));
        return responseResult;
    }

    @Override
    public ResponseResult<QuickOrder> updateStatus(QuickOrder record) {
        logger.info("进入修改快速订单状态updateStatus方法");
        ResponseResult<QuickOrder> responseResult = new ResponseResult<>();
        if (record != null && record.getId() != null) {
            Integer updateStatus = quickOrderMapper.updateStatus(record);
            if (updateStatus > 0) {
                responseResult.setMsg("修改快速订单状态成功");
                responseResult.setCode(true);
            } else {
                responseResult.setMsg("修改快速订单状态失败");
            }
        } else {
            responseResult.setMsg("无此订单");
        }
        logger.info("修改快速订单状态updateStatus方法结束,返回结果:"+JSON.toJSONString(responseResult));
        return responseResult;
    }

    @Override
    public ResponseResult<QuickOrder> updatePay(QuickOrder record) {
        logger.info("进入修改快速订单支付状态updatePay方法");
        ResponseResult<QuickOrder> responseResult = new ResponseResult<>();
        if (record != null && record.getId() != null) {
            record.setHasPay(true);
            record.setPayTime(new Date());
            Integer updateStatus = quickOrderMapper.updatePay(record);
            if (updateStatus > 0) {
                responseResult.setMsg("快速订单支付成功");
                responseResult.setCode(true);
            } else {
                responseResult.setMsg("快速订单支付失败");
            }
        } else {
            responseResult.setMsg("无此订单");
        }
        logger.info("修改快速订单支付状态updatePay方法结束,返回结果:"+JSON.toJSONString(responseResult));
        return responseResult;
    }

    @Override
    public ResponseResult<QuickOrder> updateSubmit(QuickOrder record) {
        logger.info("进入快速订单交付updateSubmit方法");
        ResponseResult<QuickOrder> responseResult = new ResponseResult<>();
        if (record != null && record.getId() != null) {
            record.setExpectTime(new Date());
            Integer submit = quickOrderMapper.updateSubmit(record);
            if (submit > 0) {
                responseResult.setMsg("快速订单交付成功");
                responseResult.setCode(true);
            } else {
                responseResult.setMsg("快速订单交付失败");
            }
        } else {
            responseResult.setMsg("没有此项订单");
        }
        logger.info("快速订单交付updateSubmit方法结束,返回结果:"+JSON.toJSONString(responseResult));
        return responseResult;
    }

    @Override
    public ResponseResult<QuickOrder> updateFinish(QuickOrder record) {
        logger.info("进入快速订单完成updateFinish方法");
        ResponseResult<QuickOrder> responseResult = new ResponseResult<>();
        if (record != null && record.getId() != null) {
            record.setFinishTime(new Date());
            Integer updateFinish = quickOrderMapper.updateFinish(record);
            if (updateFinish > 0) {
                responseResult.setCode(true);
                responseResult.setMsg("快速订单已完成");
            } else {
                responseResult.setMsg("完成订单失败");
            }
        } else {
            responseResult.setMsg("没有此项订单");
        }
        logger.info("快速订单完成updateFinish方法结束,返回结果:"+JSON.toJSONString(responseResult));
        return responseResult;
    }

    @Override
    public ResponseResult<QuickOrder> paid(PayBackBean payBackBean) {
        logger.info("进入快速订单支付paid方法");
        ResponseResult<QuickOrder> responseResult = new ResponseResult<>();
        if (payBackBean != null) {
            String orderNo = payBackBean.getOrderNo();
            QuickOrder quickOrder = new QuickOrder();
            quickOrder.setOrderNo(orderNo);
            quickOrder = quickOrderMapper.query(quickOrder);
            if (quickOrder != null) {
                quickOrder.setAmountActual(payBackBean.getAmount());
                quickOrder.setPayMethod(Byte.parseByte(payBackBean.getPayMethod() + ""));
                return updatePay(quickOrder);

            } else {
                responseResult.setMsg("无此订单");
            }
        }
        logger.info("快速订单支付paid方法结束,返回结果:"+JSON.toJSONString(responseResult));
        return responseResult;
    }

    @Override
    public ResponseResult<QuickOrder> uploadImg(QuickOrder record) {
        logger.info("进入快速订单修改图片路径uploadImg方法");
        ResponseResult<QuickOrder> responseResult = new ResponseResult<>();
        if (record != null) {
            String imgUrl = record.getImgUrl();
            if (StringUtils.isNotBlank(imgUrl)) {
                Integer integer = quickOrderMapper.updateImgUrl(record);
                if (integer > 0) {
                    responseResult.setMsg("修改图片路径成功");
                    responseResult.setCode(true);
                }
            }
        }
        if (StringUtils.isBlank(responseResult.getMsg())) {
            responseResult.setMsg("修改图片路径失败");
        }
        logger.info("快速订单修改图片路径uploadImg方法结束,返回结果:"+JSON.toJSONString(responseResult));
        return responseResult;
    }

    public void sendEmail(QuickOrder orders, String templateType) {
        if (StringUtils.isNotBlank(orders.getCustomerEmail())) {
            Map<String, Object> map = new HashMap<>();
            map.put("invokeObj", "globalEagle");
            map.put("templateType", templateType);
            Map<String, Object> mapData = new HashMap<>();
            mapData.put("quickOrder", JSON.toJSONString(orders));
            mapData.put("toAddress", orders.getCustomerEmail());
            map.put("mapData", JSON.toJSONString(mapData));
            MqRecord<Map> mqRecord = new MqRecord<>();
            mqRecord.setContent(map);
            mqRecord.setMqType(MqTypeEnum.EMAIL.getValue());
            //ResponseResult<String> responseResult = emailService.sendEmail("globalEagle", "order", map);
            orderJmsTemplate.send(emailQueue, new OrderMessageCreator(JSON.toJSONString(mqRecord)));//给email消息队列发送消息
        }
    }
}
