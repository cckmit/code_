package com.mika.credit.facade.front.en.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.en.UCCs;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UCCsDao extends BaseDao<UCCs> {

    UCCs findById(Integer id);

    List<UCCs> findByFullReportId(Integer fullReportId);
//    int deleteByPrimaryKey(Integer uccid);
//
//    int insert(UCCs record);
//
//    int insertSelective(UCCs record);
//
//    UCCs selectByPrimaryKey(Integer uccid);
//
//    int updateByPrimaryKeySelective(UCCs record);
//
//    int updateByPrimaryKeyWithBLOBs(UCCs record);
//
//    int updateByPrimaryKey(UCCs record);
}