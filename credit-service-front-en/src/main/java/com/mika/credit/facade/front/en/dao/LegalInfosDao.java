package com.mika.credit.facade.front.en.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.en.LegalInfos;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface LegalInfosDao extends BaseDao<LegalInfos> {

    LegalInfos findById(Integer id);

    List<LegalInfos> findByFullReportId(Integer fullReportId);
//    int deleteByPrimaryKey(Integer legalid);
//
//    int insert(LegalInfos record);
//
//    int insertSelective(LegalInfos record);
//
//    LegalInfos selectByPrimaryKey(Integer legalid);
//
//    int updateByPrimaryKeySelective(LegalInfos record);
//
//    int updateByPrimaryKeyWithBLOBs(LegalInfos record);
//
//    int updateByPrimaryKey(LegalInfos record);
}