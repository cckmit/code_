package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.ResponseResult;

/**
 * 品牌专利
 * @author jack，michael
 */
public interface BrandsService {

    /**
     * 根据crefoNo查询品牌专利
     * @param crefoNo
     * @return
     */
    ResponseResult<String> brands(String crefoNo);


}
