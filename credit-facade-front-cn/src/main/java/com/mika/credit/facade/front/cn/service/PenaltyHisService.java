package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.report.cn.PenaltyHis;

import java.util.List;

/**
 *
 */
public interface PenaltyHisService {

    /**
     *
     * @param
     * @return
     */

    PenaltyHis findById(Integer id);

    List<PenaltyHis> findByFullReportId(Integer fullReportId);

}
