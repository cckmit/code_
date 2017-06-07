package com.mika.credit.facade.front.cn.parse;

import com.mika.credit.common.entity.ResponseResult;

/**
 * Created by aixingwen on 2017/3/20.
 */
public interface InterfaceData {


        /**
         * 获取财务数据
         * */
        public ResponseResult getFinancialData(String companyName);

        /*
        *获取诉讼数据
        * **/
        public ResponseResult getLitigationData(String companyName);

        /**
         * 获取工商注册数据
         * */
        public ResponseResult getRegistrationData(String companyName);

        /*
        *获取访问数据
        * **/
        public ResponseResult getInterviewData(String companyName);

        /*
        * 获取新闻数据
        * **/
        public ResponseResult getNewsData(String companyName);

        /*
        * 获取资质数据(专利和icp)
        * **/
        public ResponseResult getAptitude(String companyName);

        /**
         * 获取其他数据
         * */
        public ResponseResult getOthersData(String companyName);



}
