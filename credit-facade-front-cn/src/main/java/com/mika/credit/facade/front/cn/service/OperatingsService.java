package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.report.cn.Operatings;

import java.util.List;

/**
 * 经营现状表
 */
public interface OperatingsService {

    /**
     *
     * @param
     * @return
     */


    Operatings findById(Integer id);

    List<Operatings> findByFullReportId(Integer fullReportId);
}
