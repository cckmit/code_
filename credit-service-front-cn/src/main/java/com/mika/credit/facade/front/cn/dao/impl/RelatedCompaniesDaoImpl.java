package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.RelatedCompanies;
import com.mika.credit.facade.front.cn.dao.RelatedCompaniesDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/2/27.
 */
@Repository("relatedCompaniesDao")
public class RelatedCompaniesDaoImpl extends BaseDaoImpl<RelatedCompanies> implements RelatedCompaniesDao {
    @Override
    public RelatedCompanies findById(Integer id) {
        RelatedCompanies result = getById(id);
        return result;
    }

    @Override
    public List<RelatedCompanies> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<RelatedCompanies> result = listBy(params);
        return result;
    }
}
