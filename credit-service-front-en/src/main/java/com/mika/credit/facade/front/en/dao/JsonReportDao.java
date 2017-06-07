package com.mika.credit.facade.front.en.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.facade.front.en.entity.JsonReport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("jsonReportDao")
public interface JsonReportDao extends BaseDao<JsonReport> {

    List<JsonReport> selectByCompanyId(String companyId);


}