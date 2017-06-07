package com.mika.credit.facade.front.en.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.en.Identification;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IdentificationDao extends BaseDao<Identification> {

    Identification findById(Integer id);

    List<Identification> findByFullReportId(Integer fullReportId);
//    int deleteByPrimaryKey(Integer identificationid);
//
//    int insert(Identification record);
//
//    int insertSelective(Identification record);
//
//    Identification selectByPrimaryKey(Integer identificationid);
//
//    int updateByPrimaryKeySelective(Identification record);
//
//    int updateByPrimaryKeyWithBLOBs(Identification record);
//
//    int updateByPrimaryKey(Identification record);
}