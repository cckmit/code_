package com.mika.credit.facade.globalsearch.core.service;

import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.globalsearch.core.model.Recharge;


/**
 * Created by joyce on 2016/7/30.
 */
public interface RechargeService {
    BootGrid<Recharge> getRecharges(Recharge recharge);

    ResponseResult<Recharge> addRecharge(Recharge recharge);

    ResponseResult<Recharge> modifyOkRecharge(Recharge recharge);

    ResponseResult<Recharge> modifyCancelRecharge(Recharge recharge);
}
