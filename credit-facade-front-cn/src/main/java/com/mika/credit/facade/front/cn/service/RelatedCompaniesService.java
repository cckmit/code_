package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.report.cn.RelatedCompanies;

import java.util.List;

/**
 * 关联公司信息
 */
public interface RelatedCompaniesService {

    /**
     *
     * @param
     * @return
     */

    RelatedCompanies findById(Integer id);

    List<RelatedCompanies> findByFullReportId(Integer fullReportId);

}
