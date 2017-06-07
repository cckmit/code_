package com.mika.credit.facade.gugu.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.order.OrderDetail;
import com.mika.credit.common.entity.order.Orders;
import com.mika.credit.common.util.StringUtil;
import com.mika.credit.facade.gugu.dao.BusinessCardMapper;
import com.mika.credit.facade.gugu.dao.CreditCertificationMapper;
import com.mika.credit.facade.gugu.model.BusinessCard;
import com.mika.credit.facade.gugu.model.CreditCertification;
import com.mika.credit.facade.gugu.service.OrderInfoService;
import com.mika.credit.facade.order.service.OrderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dong jian hua on 2017/4/17.
 */
@Service("orderInfoService")
public class OrderInfoServiceImpl implements OrderInfoService {
    private static Logger logger = Logger.getLogger(OrderInfoServiceImpl.class);

    @Autowired
    private OrderService orderService;
    @Autowired
    private BusinessCardMapper businessCardMapper;
    @Autowired
    private CreditCertificationMapper creditCertificationMapper;

    @Override
    public String orderList(String data) {
        ResponseResult<String> result = new ResponseResult<>();
        JSONObject json = JSONObject.parseObject(data);
        JSONArray array = new JSONArray();
        String cardId = json.getString("cardId");
        if(StringUtil.isNotNull(cardId)){
            List<CreditCertification> certification = creditCertificationMapper.selectByPrimaryCardId(Integer.valueOf(cardId));
            if(certification.size()>0){
                for (CreditCertification certifications:certification) {
                    ResponseResult<Orders> orders = orderService.findOrdersById(Long.valueOf(certifications.getOrderId()));
                    if(orders.getCode()){
                        array.add(orders);
                    }else{
                        continue;
                    }
                }
                if(array.size()>0){
                    result.setCode(true);
                    result.setMsg("获取订单列表成功");
                    result.setResult(array);
                    return JSONObject.toJSONString(result);
                }else{
                    result.setCode(false);
                    result.setMsg("获取订单列表失败");
                }

            }else{
                result.setCode(false);
                result.setMsg("获取订单列表失败");
            }
        }else{
            result.setCode(false);
            result.setMsg("获取订单列表失败");
        }
        return JSONObject.toJSONString(result);
    }

    @Override
    public String orderDetail(String data) {
        ResponseResult<String> result = new ResponseResult<>();
        JSONObject json = JSONObject.parseObject(data);
        String cardId = json.getString("cardId");
        String orderId = json.getString("orderId");
        if(StringUtil.isNotNull(cardId)&&StringUtil.isNotNull(orderId)){
            CreditCertification ccf = new CreditCertification();
            ccf.setCardId(Integer.valueOf(cardId));
            ccf.setOrderId(Integer.valueOf(orderId));
            List<CreditCertification> certification = creditCertificationMapper.selectByPrimaryKeySelective(ccf);
            if(certification.size()>0) {
                for (CreditCertification cc:certification) {
                    List<OrderDetail> orderDetails = orderService.findOrderDetailByOrderId(Long.valueOf(cc.getOrderId()));
                    if (orderDetails.size() > 0) {
                        result.setCode(false);
                        result.setMsg("获取订单详情成功");
                        result.setResult(orderDetails);
                        return JSONObject.toJSONString(result);
                    } else {
                        result.setCode(false);
                        result.setMsg("获取订单详情失败");
                        return JSONObject.toJSONString(result);
                    }
                }
            } else {
                result.setCode(false);
                result.setMsg("获取订单详情失败");
            }
        }else{
            result.setCode(false);
            result.setMsg("获取订单详情失败");
        }
        return JSONObject.toJSONString(result);
    }
}
