package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.CreditAssessments;
import com.mika.credit.facade.front.cn.dao.CreditAssessmentsDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by michael on 2017/2/27.
 */
@Repository("creditAssessmentsDao")
public class CreditAssessmentsDaoImpl extends BaseDaoImpl<CreditAssessments> implements CreditAssessmentsDao {


    @Override
    public CreditAssessments findById(Integer id) {
        CreditAssessments result = getById(id);
        return result;
    }

    @Override
    public CreditAssessments findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        CreditAssessments result = getBy(params);
        return result;
    }
}
