package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.ResponseResult;

/**
 * 年报基本信息
 * @author jack，michael
 */
public interface BasicAnnuaService {

    /**
     * 查询年报基本信息
     * @param
     * @return
     */
    ResponseResult<String> baiscAnnua(String crefoNo);


}
