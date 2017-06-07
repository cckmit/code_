package com.mika.credit.facade.front.en.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.en.OtherInfos;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OtherInfosDao extends BaseDao<OtherInfos> {

    OtherInfos findById(Integer id);

    List<OtherInfos> findByFullReportId(Integer fullReportId);
//    int deleteByPrimaryKey(Integer otherid);
//
//    int insert(OtherInfos record);
//
//    int insertSelective(OtherInfos record);
//
//    OtherInfos selectByPrimaryKey(Integer otherid);
//
//    int updateByPrimaryKeySelective(OtherInfos record);
//
//    int updateByPrimaryKey(OtherInfos record);
}