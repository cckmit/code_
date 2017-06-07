package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.RelatedCompanies;

import java.util.List;

/**
 * 关联公司信息
 * Created by jack on 2017/2/17.
 */
public interface RelatedCompaniesDao extends BaseDao<RelatedCompanies> {
    RelatedCompanies findById(Integer id);


    List<RelatedCompanies> findByFullReportId(Integer fullReportId);
}
