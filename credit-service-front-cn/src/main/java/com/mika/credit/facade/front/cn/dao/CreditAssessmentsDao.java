package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.CreditAssessments;

/**
 * Created by michael on 2017/2/17.
 */
public interface CreditAssessmentsDao extends BaseDao<CreditAssessments> {

    CreditAssessments findById(Integer id);

    CreditAssessments findByFullReportId(Integer fullReportId);
}
