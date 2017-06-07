package com.mika.credit.facade.front.en.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.en.Managements;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ManagementsDao extends BaseDao<Managements> {

    Managements findById(Integer id);

    List<Managements> findByFullReportId(Integer fullReportId);
//    int deleteByPrimaryKey(Integer manageid);
//
//    int insert(Managements record);
//
//    int insertSelective(Managements record);
//
//    Managements selectByPrimaryKey(Integer manageid);
//
//    int updateByPrimaryKeySelective(Managements record);
//
//    int updateByPrimaryKeyWithBLOBs(Managements record);
//
//    int updateByPrimaryKey(Managements record);
}