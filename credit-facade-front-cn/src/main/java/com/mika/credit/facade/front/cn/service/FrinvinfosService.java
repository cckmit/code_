package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.report.cn.Frinvinfos;

import java.util.List;

/**
 * 法人对外投资信息
 */
public interface FrinvinfosService {

    /**
     *
     * @param
     * @return
     */
    Frinvinfos findById(Integer id);

    List<Frinvinfos> findByFullReportId(Integer fullReportId);

}
