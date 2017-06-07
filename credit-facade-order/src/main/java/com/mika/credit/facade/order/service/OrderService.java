package com.mika.credit.facade.order.service;

import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.order.OrderDetail;
import com.mika.credit.common.entity.order.OrderDetailQuery;
import com.mika.credit.common.entity.order.OrderQuery;
import com.mika.credit.common.entity.order.Orders;
import com.mika.credit.common.entity.pay.PayBackBean;

import java.io.IOException;
import java.util.List;

/**
 * 订单服务
 *
 * @author zj001
 */
public interface OrderService {

    /**
     * 查询订单列表
     *
     * @param bootGrid 分页参数
     * @param example  查询条件
     * @return 订单分页查询结果
     */
    BootGrid<Orders> findOrders(BootGrid<Orders> bootGrid, OrderQuery example);

    /**
     * 根据订单id查询订单
     *
     * @param orderId 订单id
     * @return 查询到的订单信息
     */
    ResponseResult<Orders> findOrdersById(Long orderId);

    /**
     * 保存订单
     *
     * @param record 需要保存的订单信息
     * @return 保存结果
     */
    ResponseResult<Orders> saveOrder(Orders record);

    /**
     * 向cpm保存订单
     *
     * @param record 需要保存的订单信息
     * @return 保存结果
     */
    ResponseResult<Orders> saveOrderToCPM(Orders record);

    /**
     * 取消订单(逻辑删除)
     *
     * @param record 需要删除订单的条件
     * @return 取消结果
     */
    ResponseResult<Orders> deleteOrder(Orders record);

    /**
     * 删除订单(物理删除)
     *
     * @param record 需要删除订单的条件
     * @return 删除结果
     */
    ResponseResult<Orders> deleteOrderPhysical(Orders record);

    /**
     * 根据id取消订单(逻辑删除)
     *
     * @param orderId 订单id
     * @return 取消结果
     */
    ResponseResult<Orders> deleteOrder(Long orderId);

    /**
     * 根据id取消订单(物理删除)
     *
     * @param orderId 订单id
     * @return 删除结果
     */
    ResponseResult<Orders> deleteOrderPhysical(Long orderId);


    /**
     * 修改订单状态
     *
     * @param record 需要修改的订单
     * @return 修改状态结果
     */
    ResponseResult<Orders> updateStatus(Orders record);

    /**
     * 修改订单支付日期
     *
     * @param record 需要修改的订单
     * @return 修改订单支付日期结果
     */
    ResponseResult<Orders> updatePay(Orders record);

    /**
     * 修改订单交付日期
     *
     * @param record 需要修改的订单
     * @return 修改订单交付日期结果
     */
    ResponseResult<Orders> updateSubmit(Orders record);

    /**
     * 修改订单完成日期
     *
     * @param record 需要修改的订单
     * @return 修改订单完成日期结果
     */
    ResponseResult<Orders> updateFinish(Orders record);

    /**
     * 查询订单明细
     *
     * @param bootGrid 分页参数
     * @param example  订单明细分页查询条件
     * @return 订单明细分页查询结果
     */
    BootGrid<OrderDetail> findOrderDetail(BootGrid<OrderDetail> bootGrid, OrderDetailQuery example);

    /**
     * 条件查询订单明细
     * @param orderDetail
     * @return
     */
    List<OrderDetail> findOrderDetail(OrderDetail orderDetail);

    /**
     * 根据订单明细id查询订单明细
     *
     * @param OrderDetailId 订单明细id
     * @return 订单明细查询结果
     */
    ResponseResult<OrderDetail> findOrderDetailById(Long OrderDetailId);

    /**
     * 根据订单明细id查询订单明细(包括data数据)
     *
     * @param OrderDetailId 订单明细id
     * @return 订单明细查询结果
     */
    ResponseResult<OrderDetail> findOrderDetailByIdWithData(Long OrderDetailId);

    /**
     * 根据订单id查询订单明细
     *
     * @param bootGrid 分页参数
     * @param orderId  订单id
     * @return 订单明细分页查询结果
     */
    BootGrid<OrderDetail> findOrderDetail(BootGrid<OrderDetail> bootGrid, Long orderId);

    /**
     * 根据订单id查询订单明细(不分页)
     *
     * @param orderId 订单id
     * @return 订单明细集合
     */
    List<OrderDetail> findOrderDetailByOrderId(Long orderId);

    /**
     * 根据订单id查询订单明细(包含data数据)
     *
     * @param bootGrid 分页参数
     * @param orderId  订单id
     * @return 包含data数据的订单明细分页查询结果
     */
    BootGrid<OrderDetail> findOrderDetailWithData(BootGrid<OrderDetail> bootGrid, Long orderId);


    /**
     * 异步发送消息重新获取data数据
     *
     * @param orderDetailId 订单明细id
     * @return data数据获取结果
     */
    ResponseResult<OrderDetail> reloadData(Long orderDetailId);

    /**
     * cpm重新获取财务数据
     *
     * @param orderDetailId 订单明细id
     * @param crefoNo
     * @return data数据获取结果
     */
    ResponseResult<OrderDetail> reloadFinanceDataFromCPM(Long orderDetailId, String crefoNo);

    /**
     * 取消订单明细(逻辑删除)
     *
     * @param record 需要取消的订单明细条件
     * @return 取消明细结果
     */
    ResponseResult<OrderDetail> deleteOrderDetail(OrderDetail record);

    /**
     * 删除订单明细(物理删除)
     *
     * @param record 需要删除的订单明细条件
     * @return 删除明细结果
     */
    ResponseResult<OrderDetail> deleteOrderDetailPhysical(OrderDetail record);


    /**
     * 根据明细id取消订单明细(逻辑删除)
     *
     * @param orderDetailId 明细id
     * @return 取消明细结果
     */
    ResponseResult<OrderDetail> deleteOrderDetail(Long orderDetailId);

    /**
     * 根据明细id删除订单明细(物理删除)
     *
     * @param orderDetailId 明细id
     * @return 删除明细结果
     */
    ResponseResult<OrderDetail> deleteOrderDetailPhysical(Long orderDetailId);

    /**
     * 修改供应商
     *
     * @param record 需要修改供应商的明细
     * @return 修改供应商结果
     */
    ResponseResult<OrderDetail> updateSendProvider(OrderDetail record);

    /**
     * 供应商交付
     *
     * @param record 需要交付的明细
     * @return 交付结果
     */
    ResponseResult<OrderDetail> updateReceiveProvider(OrderDetail record);

    /**
     * 修改报告制作人员
     *
     * @param record 需要修改的明细
     * @return 修改报告制作人员结果
     */
    ResponseResult<OrderDetail> updateMake(OrderDetail record);

    /**
     * 修改报告审核人员
     *
     * @param record 需要修改的明细
     * @return 报告审核人员修改结果
     */
    ResponseResult<OrderDetail> updateCheck(OrderDetail record);

    /**
     * 修改报告负责人
     *
     * @param record 需要修改的明细
     * @return 报告负责人修改结果
     */
    ResponseResult<OrderDetail> updateManger(OrderDetail record);

    /**
     * 修改明细完成日期
     *
     * @param record 需要修改的明细
     * @return 明细完成日期修改结果
     */
    ResponseResult<OrderDetail> updateFinish(OrderDetail record);

    /**
     * 修改手工pdf报告上传路径
     *
     * @param record 需要修改路径的报告
     * @return 路径修改结果
     */
    ResponseResult<OrderDetail> updateUpload(OrderDetail record);

    /**
     * 修改数据版pdf报告上传路径
     *
     * @param record 需要修改的明细
     * @return 路径修改结果
     */
    ResponseResult<OrderDetail> updateDataUpload(OrderDetail record);
    /**
     * 修改txt上传路径
     *
     * @param record 需要修改的明细
     * @return 路径修改结果
     */
    ResponseResult<OrderDetail> updateDataPathUpload(OrderDetail record);

    /**
     * 是否加急
     *
     * @param record 需要修改的明细
     * @return 修改结果
     */
    ResponseResult<OrderDetail> updateUrgent(OrderDetail record);

    /**
     * 支付回调操作
     *
     * @param payBackBean 支付回调信息
     * @return 支付结果
     */
    ResponseResult<Orders> paid(PayBackBean payBackBean);

    /**
     * 保存data数据
     *
     * @param record 需要保存data数据的订单明细
     * @return data数据保存路径
     */
    String saveData(OrderDetail record) throws IOException;

    /**
     * 保存data数据
     *
     * @param record 需要保存data数据的订单明细
     * @return data数据保存路径
     */
    void saveDataUrl(OrderDetail record);


}
