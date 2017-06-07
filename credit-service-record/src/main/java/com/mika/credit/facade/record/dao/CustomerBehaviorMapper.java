package com.mika.credit.facade.record.dao;

import com.mika.credit.facade.record.model.CustomerBehavior;
import com.mika.credit.facade.record.model.CustomerBehaviorQuery;

import java.util.List;

public interface CustomerBehaviorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CustomerBehavior customerBehavior);

    int insertSelective(CustomerBehavior customerBehavior);

    CustomerBehavior selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CustomerBehavior customerBehavior);

    int updateByPrimaryKey(CustomerBehavior customerBehavior);

    List<CustomerBehavior> selectByPrimaryKeySelective(CustomerBehavior customerBehavior);

    List<CustomerBehaviorQuery> selectByPrimaryKeySelectiveQuery(CustomerBehaviorQuery customerBehaviorQuery);

    int selectCountSelective(CustomerBehaviorQuery customerBehaviorQuery);

}