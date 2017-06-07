package com.mika.credit.facade.order.dao;

import com.mika.credit.common.entity.order.OrderDetailView;
import com.mika.credit.common.entity.order.OrderDetailViewQuery;

import java.util.List;

/**
 * Created by dell on 2017/3/15.
 */
public interface OrderDetailViewMapper extends BaseMapper<OrderDetailView>{
    /**
     * 根据订单id查询视图v_order_detail
     * @param orderId
     * @return
     */
    List<OrderDetailView> queryListByOrderId(Long orderId);

    /**
     * 根据订单id查询视图v_order_detail数据数量
     * @param orderId
     * @return
     */
    Integer queryTotalByOrderId(Long orderId);

    /**
     * 根据orderDetailViewQuery查询视图v_order_detail
     *
     * @param orderDetailViewQuery
     * @return
     */
    List<OrderDetailView> queryListByOrderDetailQuery(OrderDetailViewQuery orderDetailViewQuery);

    /**
     * 根据orderDetailViewQuery查询视图v_order_detail数据数量
     *
     * @param orderDetailViewQuery
     * @return
     */
    Integer queryTotalByOrderDetailQuery(OrderDetailViewQuery orderDetailViewQuery);
}
