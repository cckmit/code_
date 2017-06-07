package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.report.cn.Frpositioninfos;

import java.util.List;

/**
 *
 */
public interface FrpositioninfosService {

    /**
     *
     * @param
     * @return
     */
    Frpositioninfos findById(Integer id);


    List<Frpositioninfos> findByFullReportId(Integer fullReportId);

}
