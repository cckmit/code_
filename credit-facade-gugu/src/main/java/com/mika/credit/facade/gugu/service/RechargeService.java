package com.mika.credit.facade.gugu.service;

import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.pay.RechargeBean;
import com.mika.credit.facade.gugu.model.RechargeLog;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by dong jian hua on 2017/4/18.
 */
public interface RechargeService {

    /**
     * 充值列表
     * @param data
     * @return
     */
    String rechargeList(String data);

    /**
     * 充值金额
     * @param data
     * @return
     */
    String rechargeAmount(String data);


}
