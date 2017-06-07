package com.mika.credit.facade.globalsearch.core.dao;

import com.mika.credit.facade.globalsearch.core.model.Recharge;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RechargeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Recharge record);

    int insertSelective(Recharge record);

    Recharge selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Recharge record);

    int updateByPrimaryKey(Recharge record);

    List<Recharge> selectSelective(Recharge record);

    int selectCountSelective(Recharge record);
}