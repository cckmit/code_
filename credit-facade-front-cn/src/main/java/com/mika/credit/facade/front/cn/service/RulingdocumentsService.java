package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.report.cn.Rulingdocuments;

import java.util.List;

/**
 * 裁判文书
 */
public interface RulingdocumentsService {

    /**
     *
     * @param
     * @return
     */

    Rulingdocuments findById(Integer id);

    List<Rulingdocuments> findByFullReportId(Integer fullReportId);

}
