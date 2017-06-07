package com.mika.credit.facade.front.en.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.en.MediaRecords;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MediaRecordsDao extends BaseDao<MediaRecords> {

    MediaRecords findById(Integer id);

    List<MediaRecords> findByFullReportId(Integer fullReportId);
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(MediaRecords record);
//
//    int insertSelective(MediaRecords record);
//
//    MediaRecords selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(MediaRecords record);
//
//    int updateByPrimaryKey(MediaRecords record);
}