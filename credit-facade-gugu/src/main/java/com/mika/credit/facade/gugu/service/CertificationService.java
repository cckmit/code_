package com.mika.credit.facade.gugu.service;

/**
 * Created by dong jian hua on 2017/4/14.
 */
public interface CertificationService {

    /**
     * 核实下单
     * @param json
     * @return
     */
    String addVerifyOrder(String json);

    /**
     * 认购(认证)下单
     * @param json
     * @return
     */
    String addMobiletOrder(String json);

    /**
     * 认证
     * @return
     */
    String addsubscribe(String json);

}
