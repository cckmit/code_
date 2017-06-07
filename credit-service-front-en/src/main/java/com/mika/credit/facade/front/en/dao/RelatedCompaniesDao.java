package com.mika.credit.facade.front.en.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.en.RelatedCompanies;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RelatedCompaniesDao extends BaseDao<RelatedCompanies> {

    RelatedCompanies findById(Integer id);

    List<RelatedCompanies> findByFullReportId(Integer fullReportId);
//    int deleteByPrimaryKey(Integer relatedid);
//
//    int insert(RelatedCompanies record);
//
//    int insertSelective(RelatedCompanies record);
//
//    RelatedCompanies selectByPrimaryKey(Integer relatedid);
//
//    int updateByPrimaryKeySelective(RelatedCompanies record);
//
//    int updateByPrimaryKeyWithBLOBs(RelatedCompanies record);
//
//    int updateByPrimaryKey(RelatedCompanies record);
}