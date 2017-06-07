package com.mika.credit.facade.front.en.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.en.HistoryInfos;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface HistoryInfosDao extends BaseDao<HistoryInfos> {

    HistoryInfos findById(Integer id);

    List<HistoryInfos> findByFullReportId(Integer fullReportId);
//    int deleteByPrimaryKey(Integer historyid);
//
//    int insert(HistoryInfos record);
//
//    int insertSelective(HistoryInfos record);
//
//    HistoryInfos selectByPrimaryKey(Integer historyid);
//
//    int updateByPrimaryKeySelective(HistoryInfos record);
//
//    int updateByPrimaryKeyWithBLOBs(HistoryInfos record);
//
//    int updateByPrimaryKey(HistoryInfos record);
}