package com.mika.credit.facade.order.service;

import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.order.entity.BusinessOrder;
import com.mika.credit.facade.order.entity.BusinessOrderQuery;

import java.util.List;

/**
 * Created by Gavin on 2017/5/9.
 */
public interface BusinessOrderService {
    /**
     * 根据条件查询订单
     * @param bootGrid
     * @param example
     * @return
     */
    BootGrid<BusinessOrder> find(BootGrid<BusinessOrder> bootGrid, BusinessOrderQuery example);

    /**
     * 无分页查询订单
     * @param example
     * @return
     */
    List<BusinessOrder> find(BusinessOrderQuery example);

    /**
     * 根据订单id查询订单
     * @param id
     * @return
     */
    ResponseResult<BusinessOrder> findById(Long id);

    /**
     * 根据订单号查询订单
     * @param no
     * @return
     */
    ResponseResult<BusinessOrder> findByNO(String no);

    /**
     * 根据订单id查询订单包含报告数据
     * @param id
     * @return
     */
    ResponseResult<BusinessOrder> findByIdWithData(Long id);

    /**
     * 根据订单号查询订单包含报告数据
     * @param no
     * @return
     */
    ResponseResult<BusinessOrder> findByNOWithData(String no);


    /**
     * 保存订单
     * @param record
     * @return
     */
    ResponseResult<BusinessOrder> save(BusinessOrder record);

    /**
     * 根据订单id修改报告路径
     * @param record
     * @return
     */
    boolean updateDataURLById(BusinessOrder record);

    /**
     * 根据订单号修改报告路径
     * @param record
     * @return
     */
    boolean updateDataURLByNO(BusinessOrder record);

    /**
     * 删除订单
     * @param record
     * @return
     */
    //ResponseResult<BusinessOrder> deleteBusinessOrder(BusinessOrder record);

    /**
     * 根据entryId查询订单
     * @param entryId
     * @return
     */
    //ResponseResult<BusinessOrder> findOrderByEntryId(BigInteger entryId);

    /**
     * 根据entryId查询后续订单
     * @param entryId
     * @return
     */
    //ResponseResult<BusinessOrder> findAfterEntryId(BigInteger entryId);

    /**
     * 修改订单状态
     * @param record
     * @return
     */
    //ResponseResult<BusinessOrder> updateStatus(BusinessOrder record);

    /**
     * 订单制作失败
     * @param record
     * @return
     */
    ResponseResult<BusinessOrder> doReportFailed(BusinessOrder record);

    /**
     * 修改entryId
     * @param record
     * @return
     */
    //ResponseResult<BusinessOrder> updateEntryId(BusinessOrder record);
}
