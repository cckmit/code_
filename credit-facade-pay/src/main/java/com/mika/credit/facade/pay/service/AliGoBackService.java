package com.mika.credit.facade.pay.service;

import com.mika.credit.common.entity.pay.AliPayBackBean;

import java.util.Date;

/**
 * Created by dong jian hua on 2017/3/15.
 */
public interface AliGoBackService {

    /**
     * 支付宝回调修改支付记录
     * @param aliPayBackBean
     * @return
     */
    String payBackOrder(AliPayBackBean aliPayBackBean, String out_trade_no, Date gmt_payment, String buyer_id,Integer total_amount);
}
