package com.mika.credit.facade.front.en.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.en.FinancialStatement;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface FinancialStatementDao extends BaseDao<FinancialStatement> {

    FinancialStatement findById(Integer id);

    List<FinancialStatement> findByFullReportId(Integer fullReportId);

//    int deleteByPrimaryKey(Integer financialid);
//
//    int insert(FinancialStatement record);
//
//    int insertSelective(FinancialStatement record);
//
//    FinancialStatement selectByPrimaryKey(Integer financialid);
//
//    int updateByPrimaryKeySelective(FinancialStatement record);
//
//    int updateByPrimaryKeyWithBLOBs(FinancialStatement record);
//
//    int updateByPrimaryKey(FinancialStatement record);
}