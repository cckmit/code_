package com.mika.credit.facade.pay.service;


import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.pay.RechargeBean;

/**
 * Created by Hunter on 2017/3/3.
 */
public interface RechargeService {

    /**
     * 新增充值
     * @param record
     * @return responseResult
     *
     */
    ResponseResult<RechargeBean> saveRecharge(RechargeBean record);

    /**
     * 修改充值
     * @param record
     * @return responseResult
     */
    ResponseResult<RechargeBean> updateRecharge(RechargeBean record);

    /**
     * 删除充值
     * @param record
     * @return responseResult
     */
    ResponseResult<RechargeBean> deleteRecharge(RechargeBean record);


    /**
     * 根据rechargeBean Id删除充值记录
     * @param rechargeId
     * @return responseResult
     */
    ResponseResult<RechargeBean> deleteRecharge(Long rechargeId);


    /**
     * 查询全部的充值记录
     * @param grid
     * @param example
     * @return grid
     */
    BootGrid<RechargeBean> findRechargeBeans(BootGrid<RechargeBean> grid, RechargeBean example);


}
