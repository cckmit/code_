package com.mika.credit.facade.front.en.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.en.RegistrationInfos;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RegistrationInfosDao extends BaseDao<RegistrationInfos> {

    RegistrationInfos findById(Integer id);

    List<RegistrationInfos> findByFullReportId(Integer fullReportId);
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(RegistrationInfos record);
//
//    int insertSelective(RegistrationInfos record);
//
//    RegistrationInfos selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(RegistrationInfos record);
//
//    int updateByPrimaryKey(RegistrationInfos record);
}