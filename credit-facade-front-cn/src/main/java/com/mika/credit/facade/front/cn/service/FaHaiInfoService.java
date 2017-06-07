package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.ResponseResult;

import java.util.Map;

/**
 * 法海业务
 * @author jack，michael
 */
public interface FaHaiInfoService {

//    ResponseResult<String> getFahaiData(String method, Map param);

        /**
         * 获取法海业务数据信息
         * @param companyName
         * @param method
         * @return
         */
        ResponseResult<String> getFaHaiData(String companyName, String method);

        /**
         * 获取法海业务数据信息
         * @param param
         * @return
         */
        String sendfahaiDataOrderData(Map<String, String> param);
}
