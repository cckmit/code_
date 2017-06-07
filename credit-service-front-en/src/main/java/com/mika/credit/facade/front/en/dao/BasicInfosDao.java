package com.mika.credit.facade.front.en.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.en.BasicInfos;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BasicInfosDao extends BaseDao<BasicInfos> {

    BasicInfos findById(Integer id);

    List<BasicInfos> findByFullReportId(Integer fullReportId);
//    int deleteByPrimaryKey(Integer basicid);
//
//    int insert(BasicInfos record);
//
//    int insertSelective(BasicInfos record);
//
//    BasicInfos selectByPrimaryKey(Integer basicid);
//
//    int updateByPrimaryKeySelective(BasicInfos record);
//
//    int updateByPrimaryKeyWithBLOBs(BasicInfos record);
//
//    int updateByPrimaryKey(BasicInfos record);
}