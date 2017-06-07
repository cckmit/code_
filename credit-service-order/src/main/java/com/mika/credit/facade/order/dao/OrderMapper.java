package com.mika.credit.facade.order.dao;


import com.mika.credit.common.entity.order.OrderQuery;
import com.mika.credit.common.entity.order.Orders;

import java.util.List;

/**
 * Created by dell on 2017/3/2.
 */
public interface OrderMapper extends BaseMapper<Orders> {

    /**
     * 根据OrderQuery查询订单
     *
     * @param orderQuery
     * @return
     */
    List<Orders> queryListByOrderQuery(OrderQuery orderQuery);

    /**
     * 根据OrderQuery查询订单数量
     *
     * @param orderQuery
     * @return
     */
    Integer queryTotalByOrderQuery(OrderQuery orderQuery);

    /**
     * 修改订单状态
     *
     * @param record
     * @return
     */
    Integer updateStatus(Orders record);

    /**
     * 修改订单支付日期
     *
     * @param record
     * @return
     */
    Integer updatePay(Orders record);

    /**
     * 修改订单交付日期
     *
     * @param record
     * @return
     */
    Integer updateSubmit(Orders record);

    /**
     * 修改订单完成日期
     *
     * @param record
     * @return
     */
    Integer updateFinish(Orders record);

    /**
     * 修改明细数量
     *
     * @param record
     * @return
     */
    Integer updateDetailCount(Orders record);
}
