package com.mika.credit.facade.gugu.dao;

import com.mika.credit.facade.gugu.model.Order;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    List<Order> selectByPrimaryKeySelective(Order order);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}