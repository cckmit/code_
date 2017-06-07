package com.mika.credit.facade.gugu.service;

/**
 * Created by dong jian hua on 2017/4/17.
 */
public interface OrderInfoService {

    /**
     * 订单列表
     * @param data
     * @return
     */
    String orderList(String data);

    /**
     * 订单详情
     * @param data
     * @return
     */
    String orderDetail(String data);

}
