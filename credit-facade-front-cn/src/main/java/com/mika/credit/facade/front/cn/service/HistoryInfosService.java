package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.report.cn.HistoryInfos;

import java.util.List;

/**
 * 历史背景沿革
 */
public interface HistoryInfosService {

    /**
     *
     * @param
     * @return
     */


    HistoryInfos findById(Integer id);

    List<HistoryInfos> findByFullReportId(Integer fullReportId);

}
