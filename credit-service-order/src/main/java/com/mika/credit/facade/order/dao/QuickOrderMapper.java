package com.mika.credit.facade.order.dao;


import com.mika.credit.common.entity.order.QuickOrder;
import com.mika.credit.common.entity.order.QuickOrderQuery;

import java.util.List;

/**
 * Created by dell on 2017/3/2.
 */
public interface QuickOrderMapper extends BaseMapper<QuickOrder> {

    /**
     * 根据QuickOrderQuery查询订单
     *
     * @param quickOrderQuery
     * @return
     */
    List<QuickOrder> queryListByOrderQuery(QuickOrderQuery quickOrderQuery);

    /**
     * 根据QuickOrderQuery查询订单数量
     *
     * @param quickOrderQuery
     * @return
     */
    Integer queryTotalByOrderQuery(QuickOrderQuery quickOrderQuery);

    /**
     * 修改快速订单状态
     *
     * @param record
     * @return
     */
    Integer updateStatus(QuickOrder record);

    /**
     * 修改快速订单支付日期
     *
     * @param record
     * @return
     */
    Integer updatePay(QuickOrder record);

    /**
     * 修改快速订单交付日期
     *
     * @param record
     * @return
     */
    Integer updateSubmit(QuickOrder record);

    /**
     * 修改快速订单完成日期
     *
     * @param record
     * @return
     */
    Integer updateFinish(QuickOrder record);


    Integer updateImgUrl(QuickOrder record);
}
