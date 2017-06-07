package com.mika.credit.facade.globaleagle.admin.service;


import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.globaleagle.core.model.Recharge;

/**
 * Created by joyce on 2016/7/30.
 */
public interface RechargeManagerService {
    BootGrid<Recharge> getRecharges(Recharge recharge);

    ResponseResult<Recharge> addRecharge(Recharge recharge);

    ResponseResult<Recharge> modifyOkRecharge(Recharge recharge);

    ResponseResult<Recharge> modifyCancelRecharge(Recharge recharge);
}
