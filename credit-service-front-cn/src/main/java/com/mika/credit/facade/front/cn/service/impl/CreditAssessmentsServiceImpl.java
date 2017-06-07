package com.mika.credit.facade.front.cn.service.impl;

import com.mika.credit.common.entity.report.cn.CreditAssessments;
import com.mika.credit.facade.front.cn.dao.CreditAssessmentsDao;
import com.mika.credit.facade.front.cn.service.CreditAssessmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dell on 2017/2/17.
 */
@Service("creditAssessmentsService")
public class CreditAssessmentsServiceImpl implements CreditAssessmentsService {

    @Autowired
    CreditAssessmentsDao creditAssessmentsDao;

    @Override
    public CreditAssessments findById(Integer id) {
        return creditAssessmentsDao.findById(id);
    }

    @Override
    public CreditAssessments findByFullReportId(Integer fullReportId) {
        return creditAssessmentsDao.findByFullReportId(fullReportId);
    }
}
