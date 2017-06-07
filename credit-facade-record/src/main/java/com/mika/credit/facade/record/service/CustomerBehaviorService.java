package com.mika.credit.facade.record.service;

import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.record.model.CustomerBehavior;
import com.mika.credit.facade.record.model.CustomerBehaviorQuery;


/**
 * Created by Mike on 2017/6/6.
 */
public interface CustomerBehaviorService {
    /**
     *  根据id判断是否新增/修改
     * @param customerBehavior
     * @return
     */
    ResponseResult<CustomerBehavior> saveCustomerBehavior(CustomerBehavior customerBehavior);

    /**
     * 删除
     * @param customerBehavior
     * @return
     */
    ResponseResult<CustomerBehavior> delCustomerBehavior(CustomerBehavior customerBehavior);

    /**
     * 按条件查询/分页
     * @param customerBehavior
     * @return
     */
    BootGrid<CustomerBehaviorQuery> selSecCustomerBehavior(CustomerBehaviorQuery customerBehavior);

    /**
     * 根据Id查
     * @param customerBehaviorId
     * @return
     */
    ResponseResult<CustomerBehavior> selByIdCustomerBehavior(Integer customerBehaviorId);


}
