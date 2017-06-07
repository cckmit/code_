package com.mika.credit.facade.pay.service;


import com.mika.credit.common.entity.pay.AliPayBackBean;
import com.mika.credit.common.entity.pay.AlipayBean;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by dell on 2017/2/7.
 */
public interface AlipayService {
    /**
     * 组织相关数据，并跳转到支付宝支付界面
     * @param alipayBean
     * @return 直接跳转到支付宝支付页面
     */
    String pay(AlipayBean alipayBean);

}
