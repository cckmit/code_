package com.mika.credit.facade.gugu.service;

/**
 * Created by dong jian hua on 2017/4/15.
 */

public interface VerificationResultService {


    /**
     * 获取名片核实信息
     * @param json
     * @return
     */
    String getVerificationResultInfo(String json);

    /**
     * 获取认证信息
     * @param data
     * @return
     */
    String authInfo(String data);

    /**
     * 获取最新认证信息
     * @param data
     * @return
     */
    String newAuthInfo(String data);

    /**
     * 获取已认证的列表
     * @param data
     * @return
     */
    String cardListByCertification(String data);

    /**
     * 获取商圈列表中的认证信息
     * @param data
     * @return
     */
    String cerificationInfo(String data);


}
