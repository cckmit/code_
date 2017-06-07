package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.report.cn.SharePledgeHis;

import java.util.List;

/**
 *
 */
public interface SharePledgeHisService {

    /**
     *
     * @param
     * @return
     */
    SharePledgeHis findById(Integer id);

    List<SharePledgeHis> findByFullReportId(Integer fullReportId);

}
