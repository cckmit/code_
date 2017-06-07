package com.mika.credit.facade.pay.service;


import com.mika.credit.common.entity.pay.WXPayBackBean;
import com.mika.credit.common.entity.pay.WXPayBean;

/**
 * Created by Gavin on 2017/2/17.
 */
public interface WXPayService {
    /**
     * 调用统一下单接口，创建订单，返回json
     * @param wxPayBean
     * 正常：{result:true,obj:二维码url}
     * 错误：{result:false,resultDes:报错内容}
     */
    String pay(WXPayBean wxPayBean);

    String wxBackRecord(WXPayBackBean wxBackBean,String Return_code,Integer Total_fee,String Out_trade_no,String Time_end,String Openid);


}
