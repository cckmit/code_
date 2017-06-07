package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.ResponseResult;

/**
 * 年报提供担保信息
 */
public interface GuaranteeAnnualService {

    /**
     * 查询年报提供担保信息
     * @param
     * @return
     */
    ResponseResult<String> guaranteeAnnual(String crefoNo);


}
