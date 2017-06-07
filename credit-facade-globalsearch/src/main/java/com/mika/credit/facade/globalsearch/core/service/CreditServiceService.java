package com.mika.credit.facade.globalsearch.core.service;

import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.globalsearch.core.model.CreditService;


/**
 * Created by mika on 2016/7/28.
 */
public interface CreditServiceService {
    //添加
    ResponseResult<CreditService> add(CreditService creditService);
    //修改
    ResponseResult<CreditService> modify(CreditService creditService);
    //根据ID查询
    ResponseResult<CreditService> getCreditServiceById(CreditService creditService);
    //根据ID删除
    ResponseResult<CreditService> delById(int id);
    //分页查询
    BootGrid<CreditService> getCreditService(BootGrid <CreditService> grid, CreditService creditService);
}
