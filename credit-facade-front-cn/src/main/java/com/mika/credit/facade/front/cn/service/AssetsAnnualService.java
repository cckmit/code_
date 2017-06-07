package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.ResponseResult;

/**
 * 年报资产信息
 * @author jack，michael
 */
public interface AssetsAnnualService {

    /**
     * 根据crefoNo查询年报资产信息
     * @param crefoNo
     * @return
     */
    ResponseResult<String> assetsAnnual(String crefoNo);


}
