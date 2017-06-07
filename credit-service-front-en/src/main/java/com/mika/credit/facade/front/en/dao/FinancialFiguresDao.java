package com.mika.credit.facade.front.en.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.en.FinancialFigures;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface FinancialFiguresDao extends BaseDao<FinancialFigures> {

    FinancialFigures findById(Integer id);

    List<FinancialFigures> findByFullReportId(Integer fullReportId);

//    int deleteByPrimaryKey(Integer id);
//
//    int insert(FinancialFigures record);
//
//    int insertSelective(FinancialFigures record);
//
//    FinancialFigures selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(FinancialFigures record);
//
//    int updateByPrimaryKey(FinancialFigures record);
}