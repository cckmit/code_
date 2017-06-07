package com.mika.credit.facade.pay.service;

import com.mika.credit.common.entity.pay.DisActivityBean;

/**
 * Created by Hunter on 2017/3/6.
 */
public interface DisActivityService {

    /**
     * 充值活动--->充多少送多少
     * @param disActivityBean
     * @return
     */
    Integer sendGold(DisActivityBean disActivityBean);

    /**
     * 充值活动--->折扣券
     * @param disActivityBean
     * @return
     */
    Integer Voucher(DisActivityBean disActivityBean);

}
