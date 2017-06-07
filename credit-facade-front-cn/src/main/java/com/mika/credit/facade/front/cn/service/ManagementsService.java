package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.report.cn.Managements;

import java.util.List;

/**
 * 管理层信息
 */
public interface ManagementsService {

    /**
     *
     * @param
     * @return
     */

    Managements findById(Integer id);

    List<Managements> findByFullReportId(Integer fullReportId);

}
