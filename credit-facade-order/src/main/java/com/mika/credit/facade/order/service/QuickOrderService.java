package com.mika.credit.facade.order.service;

import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.order.QuickOrder;
import com.mika.credit.common.entity.order.QuickOrderQuery;
import com.mika.credit.common.entity.pay.PayBackBean;

/**
 * 快速订单服务
 *
 * @author zj001
 */
public interface QuickOrderService {

    /**
     * 保存快速订单
     * @param quickOrder 需要保存的快速订单
     * @return 快速订单保存结果
     */
    ResponseResult<QuickOrder> saveQuickOrder(QuickOrder quickOrder);

    /**
     * 根据id查询快速订单
     * @param quickOrderId 快速订单id
     * @return 快速订单查询结果
     */
    ResponseResult<QuickOrder> findQuickOrderById(Long quickOrderId);

    /**
     * 查询快速订单列表
     * @param bootGrid 分页条件
     * @param example 快速订单查询条件
     * @return 查询结果
     */
    BootGrid<QuickOrder> findQuickOrders(BootGrid<QuickOrder> bootGrid, QuickOrderQuery example);

    /**
     * 根据id删除(取消)快速订单(逻辑删除)
     * @param quickOrderId 快速订单id
     * @return 删除结果
     */
    ResponseResult<QuickOrder> deleteQuickOrder(Long quickOrderId);

    /**
     * 根据id删除快速订单(物理删除)
     * @param quickOrderId 快速订单id
     * @return 删除结果
     */
    ResponseResult<QuickOrder> deleteQuickOrderPhysical(Long quickOrderId);

    /**
     * 删除(取消)快速订单(逻辑删除)
     * @param record 需要删除的快速订单
     * @return 删除结果
     */
    ResponseResult<QuickOrder> deleteQuickOrder(QuickOrder record);

    /**
     * 删除快速订单(物理删除)
     * @param record 需要取消的快速订单
     * @return 订单取消结果
     */
    ResponseResult<QuickOrder> deleteQuickOrderPhysical(QuickOrder record);

    /**
     * 修改快速订单状态
     * @param record 需要修改的快速订单
     * @return 状态修改结果
     */
    ResponseResult<QuickOrder> updateStatus(QuickOrder record);

    /**
     * 修改快速订单支付日期
     * @param record 需要修改的快速订单
     * @return 修改支付日期结果
     */
    ResponseResult<QuickOrder> updatePay(QuickOrder record);

    /**
     * 修改快速订单交付日期
     * @param record 需要修改的快速订单
     * @return 修改交付日期结果
     */
    ResponseResult<QuickOrder> updateSubmit(QuickOrder record);

    /**
     * 修改快速订单完成日期
     * @param record 需要修改的快速订单
     * @return 修改完成日期结果
     */
    ResponseResult<QuickOrder> updateFinish(QuickOrder record);

    /**
     * 支付回调操作
     * @param payBackBean 回调参数
     * @return 支付结果
     */
    ResponseResult<QuickOrder> paid(PayBackBean payBackBean);

    /**
     * 上传目标公司图片
     * @param record 需要上传图片的公司参数
     * @return 修改结果
     */
    ResponseResult<QuickOrder> uploadImg(QuickOrder record);

}
