package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.MediaRecords;

import java.util.List;

/**
 * 媒体记录表
 * Created by jack on 2017/2/17.
 */
public interface MediaRecordsDao extends BaseDao<MediaRecords> {
    MediaRecords findById(Integer id);



    List<MediaRecords> findByFullReportId(Integer fullReportId);
}
