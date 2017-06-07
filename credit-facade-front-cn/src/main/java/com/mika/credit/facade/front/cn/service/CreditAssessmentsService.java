package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.report.cn.CreditAssessments;

/**
 *分析评估
 * @author jack，michael
 */
public interface CreditAssessmentsService {

    /**
     *查询分析评估
     * @param id
     * @return
     */
    CreditAssessments findById(Integer id);

    /**
     * 查询分析评估
     * @param fullReportId
     * @return
     */
    CreditAssessments findByFullReportId(Integer fullReportId);

}
