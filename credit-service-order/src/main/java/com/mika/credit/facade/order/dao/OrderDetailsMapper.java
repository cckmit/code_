package com.mika.credit.facade.order.dao;


import com.mika.credit.common.entity.order.OrderDetail;
import com.mika.credit.common.entity.order.OrderDetailQuery;

import java.util.List;

public interface OrderDetailsMapper extends BaseMapper<OrderDetail> {

    /**
     * 根据OrderDetailQuery查询订单
     *
     * @param orderDetailQuery
     * @return
     */
    List<OrderDetail> queryListByOrderDetailQuery(OrderDetailQuery orderDetailQuery);

    /**
     * 根据OrderDetailQuery查询订单数量
     *
     * @param orderDetailQuery
     * @return
     */
    Integer queryTotalByOrderDetailQuery(OrderDetailQuery orderDetailQuery);

    /**
     * 修改订单明细状态
     * @param record
     * @return
     */
    Integer updateStatus(OrderDetail record);

    /**
     * 根据订单id查询订单明细
     * @param orderId
     * @return
     */
    List<OrderDetail> findOrderDetailByOrderId(Long orderId);

    /**
     * 根据订单id删除对应订单明细
     * @param orderId
     * @return
     */
    int deleteOrderDetailsByOrderId(Long orderId);

    /**
     * 根据订单id查询所有订单明细个数
     * @param orderId
     * @return
     */
    Integer queryTotalByOrderId(Long orderId);

    /**
     * 修改供应商
     * @param record
     * @return
     */
    Integer updateSendProvider(OrderDetail record);

    /**
     * 供应商交付
     * @param record
     * @return
     */
    Integer updateReceiveProvider(OrderDetail record);

    /**
     * 修改报告制作人员
     * @param record
     * @return
     */
    Integer updateMake(OrderDetail record);

    /**
     * 修改报告审核人员
     * @param record
     * @return
     */
    Integer updateCheck(OrderDetail record);

    /**
     * 修改报告负责人
     * @param record
     * @return
     */
    Integer updateManger(OrderDetail record);

    /**
     * 修改报告发布日期
     * @param record
     * @return
     */
    Integer updateFinish(OrderDetail record);

    /**
     * 修改报告上传路径
     * @param record
     * @return
     */
    Integer updateUpload(OrderDetail record);

    /**
     * 修改data版数据报告上传路径
     * @param record
     * @return
     */
    Integer updateDataUpload(OrderDetail record);

    /**
     * 是否加急
     * @param record
     * @return
     */
    Integer updateUrgent(OrderDetail record);

    /**
     * 修改数据保存路径
     * @param record
     * @return
     */
    Integer updateDataUrl(OrderDetail record);


    Integer updateBatch(List<OrderDetail> orderDetails);
}