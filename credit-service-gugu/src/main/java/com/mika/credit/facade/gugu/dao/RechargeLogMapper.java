package com.mika.credit.facade.gugu.dao;

import com.mika.credit.facade.gugu.model.RechargeLog;

import java.util.List;

public interface RechargeLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RechargeLog record);

    int insertSelective(RechargeLog record);

    RechargeLog selectByPrimaryKey(Integer id);

    List<RechargeLog> selectByPrimaryKeySelective(RechargeLog rechargeLog);

    int selectByPrimaryKeyCount(RechargeLog rechargeLog);

    int updateByPrimaryKeySelective(RechargeLog record);

    int updateByPrimaryKey(RechargeLog record);
}