package com.mika.credit.facade.order.service;

import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.order.entity.AccessOrder;
import com.mika.credit.facade.order.entity.AccessOrderQuery;

import java.util.List;

/**
 *
 * Created by dell on 2017/5/19.
 */
public interface AccessOrderService {
    ResponseResult<AccessOrder> save(AccessOrder record);
    BootGrid<AccessOrder> find(BootGrid<AccessOrder> bootGrid, AccessOrderQuery example);
    List<AccessOrder> find(AccessOrderQuery example);
    ResponseResult<AccessOrder> findById(Long id);
    ResponseResult<AccessOrder> findByNO(String no);
    ResponseResult<AccessOrder> delete(AccessOrder record);
    ResponseResult<AccessOrder> updateFinish(AccessOrder record);
    ResponseResult<AccessOrder> updateCrefoNo(AccessOrder record);
    ResponseResult<AccessOrder> updateDbTarget(AccessOrder record);
}
