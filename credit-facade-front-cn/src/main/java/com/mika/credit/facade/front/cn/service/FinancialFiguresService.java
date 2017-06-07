package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.report.cn.FinancialFigures;

import java.util.List;

/**
 *
 */
public interface FinancialFiguresService {

    /**
     *
     * @param
     * @return
     */
    FinancialFigures findById(Integer id);

    List<FinancialFigures> findByFullReportId(Integer fullReportId);

}
