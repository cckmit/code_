package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.ResponseResult;

/**
 *  经营异常
 */
public interface OperationAbnormalInfosService {

    /**
     * 查询经营异常
     * @param
     * @return
     */
    ResponseResult<String> operationAbnormalInfos(String crefoNo);


}
