package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.report.cn.EnterpriseShareholder;

import java.util.List;

/**
 * 企业公示股东及出资
 * @author jack，michael
 */
public interface EnterpriseShareholderService {
    /**
     * 查询企业公示股东及出资
     * @param id
     * @return
     */
    EnterpriseShareholder findById(Integer id);

    /**
     * 查询企业公示股东及出资
     * @param fullReportId
     * @return
     */
    List<EnterpriseShareholder> findByFullReportId(Integer fullReportId);

}
