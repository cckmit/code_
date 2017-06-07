package com.mika.credit.facade.front.en.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.en.FullReport;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface FullReportDao extends BaseDao<FullReport>{
    FullReport findById(Integer id);

    List<FullReport> findByFullReportId(Integer fullReportId);

    FullReport findByCompanyNo(String companyNo);

}