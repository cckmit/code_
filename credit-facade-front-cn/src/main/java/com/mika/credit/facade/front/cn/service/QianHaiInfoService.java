package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.ResponseResult;

import java.util.Map;

/**
 * 前海业务
 */
public interface QianHaiInfoService {

    ResponseResult<String> getQianHaiData(String companyName, String crefoNo);


    String sendQianHaiData(String companyName,String crefoNo);
}
