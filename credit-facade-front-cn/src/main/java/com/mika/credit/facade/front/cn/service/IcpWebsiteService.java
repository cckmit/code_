package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.ResponseResult;

/**
 * 互联网登记
 */
public interface IcpWebsiteService {

    /**
     * 查询互联网登记
     * @param
     * @return
     */
    ResponseResult<String> icpWebsite(String crefoNo);


}
