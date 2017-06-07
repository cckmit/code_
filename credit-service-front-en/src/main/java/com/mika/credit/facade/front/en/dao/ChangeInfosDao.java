package com.mika.credit.facade.front.en.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.en.ChangeInfos;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ChangeInfosDao extends BaseDao<ChangeInfos> {


    ChangeInfos findById(Integer id);

    List<ChangeInfos> findByFullReportId(Integer fullReportId);
//    int deleteByPrimaryKey(Integer changeid);
//
//    int insert(ChangeInfos record);
//
//    int insertSelective(ChangeInfos record);
//
//    ChangeInfos selectByPrimaryKey(Integer changeid);
//
//    int updateByPrimaryKeySelective(ChangeInfos record);
//
//    int updateByPrimaryKeyWithBLOBs(ChangeInfos record);
//
//    int updateByPrimaryKey(ChangeInfos record);
}