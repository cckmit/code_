package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.report.cn.MediaRecords;

import java.util.List;

/**
 * 媒体记录表
 */
public interface MediaRecordsService {

    /**
     *
     * @param
     * @return
     */


    MediaRecords findById(Integer id);

    List<MediaRecords> findByFullReportId(Integer fullReportId);

}
