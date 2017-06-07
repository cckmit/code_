package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.report.cn.Fygg;

import java.util.List;

/**
 * 年报资产信息
 */
public interface FyggService {

    /**
     * 查询年报资产信息
     * @param
     * @return
     */
    Fygg findById(Integer id);


    List<Fygg> findByFullReportId(Integer fullReportId);


}
