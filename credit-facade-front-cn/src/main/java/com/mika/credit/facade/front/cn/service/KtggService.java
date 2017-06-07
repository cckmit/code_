package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.report.cn.Ktgg;

import java.util.List;

/**
 * 开庭公告
 */
public interface KtggService {

    /**
     *
     * @param
     * @return
     */


    Ktgg findById(Integer id);

    List<Ktgg> findByFullReportId(Integer fullReportId);

}
