package com.mika.credit.facade.front.en.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.en.BankInfos;

import java.util.List;

public interface BankInfosDao extends BaseDao<BankInfos>{
    BankInfos findById(Integer id);

    List<BankInfos> findByFullReportId(Integer fullReportId);
//    int deleteByPrimaryKey(Integer bankid);
//
//    int insert(BankInfos record);
//
//    int insertSelective(BankInfos record);
//
//    BankInfos selectByPrimaryKey(Integer bankid);
//
//    int updateByPrimaryKeySelective(BankInfos record);
//
//    int updateByPrimaryKey(BankInfos record);
}