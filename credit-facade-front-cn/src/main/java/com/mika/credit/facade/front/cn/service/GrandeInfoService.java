package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.ResponseResult;

/**
 * 格兰德订单业务
 */
public interface GrandeInfoService {

    /**
     * 查询格兰德工商信息(即时)
     * @param
     * @return
     */
      // ResponseResult<String> grandeOrgData(String companyName);
//
   // ResponseResult<String> grandeOrgDataV2(String companyName);

   // ResponseResult<String> grandeSifaData(String companyName);
    ResponseResult<String> getGrandeData(String companyName);

     String sendGLDOrgData(String companyName);
}
