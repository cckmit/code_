package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.report.cn.FinancialStatement;

import java.util.List;

/**
 *
 */
public interface FinancialStatementService {

    /**
     *
     * @param
     * @return
     */
    FinancialStatement findById(Integer id);

    List<FinancialStatement> findByFullReportId(Integer id);

}
