package com.mika.credit.facade.front.en.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.facade.front.en.dao.JsonReportDao;
import com.mika.credit.facade.front.en.entity.JsonReport;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("jsonReportDao")
public class JsonReportDaoImpl extends BaseDaoImpl<JsonReport> implements JsonReportDao {


    @Override
    public List<JsonReport> selectByCompanyId(String companyId) {
        Map<String,Object> params = new HashMap<>();
        params.put("companyId",companyId);
        List<JsonReport> result = listBy(params);
        return result;
    }

}