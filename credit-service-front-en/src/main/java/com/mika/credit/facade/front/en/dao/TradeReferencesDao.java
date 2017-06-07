package com.mika.credit.facade.front.en.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.en.TradeReferences;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TradeReferencesDao extends BaseDao<TradeReferences> {

    TradeReferences findById(Integer id);

    List<TradeReferences> findByFullReportId(Integer fullReportId);
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(TradeReferences record);
//
//    int insertSelective(TradeReferences record);
//
//    TradeReferences selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(TradeReferences record);
//
//    int updateByPrimaryKey(TradeReferences record);
}