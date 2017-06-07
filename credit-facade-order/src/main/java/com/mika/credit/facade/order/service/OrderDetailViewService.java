package com.mika.credit.facade.order.service;

import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.order.OrderDetailView;
import com.mika.credit.common.entity.order.OrderDetailViewQuery;

/**
 * 订单视图服务
 *
 * @author zj001
 */
public interface OrderDetailViewService {
    //==============================================================全字段查询

    /**
     * 根据订单明细id查询视图
     *
     * @param orderDetailId 订单明细id
     * @return 查询结果
     */
    ResponseResult<OrderDetailView> findByDetailId(Long orderDetailId);

    /**
     * 根据订单id查询视图
     *
     * @param bootGrid 分页条件
     * @param orderId  订单id
     * @return 根据订单id分页查询视图结果
     */
    BootGrid<OrderDetailView> findByOrderId(BootGrid<OrderDetailView> bootGrid, Long orderId);

    /**
     * 根据条件分页查询视图
     *
     * @param bootGrid 分页条件
     * @param example  查询条件
     * @return 分页查询结果
     */
    BootGrid<OrderDetailView> findByExample(BootGrid<OrderDetailView> bootGrid, OrderDetailViewQuery example);


}
