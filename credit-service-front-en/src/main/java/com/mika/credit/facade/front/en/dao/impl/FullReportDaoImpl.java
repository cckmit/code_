package com.mika.credit.facade.front.en.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.en.FullReport;
import com.mika.credit.facade.front.en.dao.FullReportDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/3/3.
 */
@Repository("fullReportDao")
public class FullReportDaoImpl extends BaseDaoImpl<FullReport> implements FullReportDao {

    @Override
    public FullReport findById(Integer id) {
        FullReport result = getById(id);
        return result;
    }

    @Override
    public List<FullReport> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<FullReport> result = listBy(params);
        return result;
    }

    @Override
    public FullReport findByCompanyNo(String companyNo) {
        Map<String,Object> params = new HashMap<>();
        params.put("companyNo",companyNo);
        FullReport result = getBy(params);
        return result;
    }
}
