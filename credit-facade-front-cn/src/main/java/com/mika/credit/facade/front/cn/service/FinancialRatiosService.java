package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.report.cn.FinancialRatios;

import java.util.List;

/**
 *
 */
public interface FinancialRatiosService {

    /**
     *
     * @param
     * @return
     */
    FinancialRatios findById(Integer id);

    List<FinancialRatios> findByFullReportId(Integer fullReportId);

}
