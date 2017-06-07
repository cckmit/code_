package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.report.cn.Sxgg;

import java.util.List;

/**
 * 失信被执行人
 */
public interface SxggService {

    /**
     *
     * @param
     * @return
     */
    Sxgg findById(Integer id);

    List<Sxgg> findByFullReportId(Integer fullReportId);

}
