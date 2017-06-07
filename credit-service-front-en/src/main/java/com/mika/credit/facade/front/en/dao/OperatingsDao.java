package com.mika.credit.facade.front.en.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.en.Operatings;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OperatingsDao extends BaseDao<Operatings> {

    Operatings findById(Integer id);

    List<Operatings> findByFullReportId(Integer fullReportId);

//    int deleteByPrimaryKey(Integer operatingid);
//
//    int insert(Operatings record);
//
//    int insertSelective(Operatings record);
//
//    Operatings selectByPrimaryKey(Integer operatingid);
//
//    int updateByPrimaryKeySelective(Operatings record);
//
//    int updateByPrimaryKeyWithBLOBs(Operatings record);
//
//    int updateByPrimaryKey(Operatings record);
}