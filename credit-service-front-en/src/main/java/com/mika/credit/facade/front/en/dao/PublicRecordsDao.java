package com.mika.credit.facade.front.en.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.en.PublicRecords;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PublicRecordsDao extends BaseDao<PublicRecords> {

    PublicRecords findById(Integer id);

    List<PublicRecords> findByFullReportId(Integer fullReportId);
//    int deleteByPrimaryKey(Integer publicid);
//
//    int insert(PublicRecords record);
//
//    int insertSelective(PublicRecords record);
//
//    PublicRecords selectByPrimaryKey(Integer publicid);
//
//    int updateByPrimaryKeySelective(PublicRecords record);
//
//    int updateByPrimaryKeyWithBLOBs(PublicRecords record);
//
//    int updateByPrimaryKey(PublicRecords record);
}