package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.report.cn.PaymentHistories;

import java.util.List;

/**
 * 支付款记录
 */
public interface PaymentHistoriesService {

    /**
     *
     * @param
     * @return
     */


    PaymentHistories findById(Integer id);

    List<PaymentHistories> findByFullReportId(Integer fullReportId);
}
