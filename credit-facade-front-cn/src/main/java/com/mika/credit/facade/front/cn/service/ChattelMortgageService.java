package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.ResponseResult;

/**
 * 动产抵押登记信息
 * @author jack，michael
 */
public interface ChattelMortgageService {

    /**
     * 查询动产抵押登记信息
     * @param crefoNo
     * @return ResponseResult
     */
    ResponseResult<String> chattelMortgage(String crefoNo);


}
