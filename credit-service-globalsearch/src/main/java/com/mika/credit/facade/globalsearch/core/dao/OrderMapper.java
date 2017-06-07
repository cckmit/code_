package com.mika.credit.facade.globalsearch.core.dao;

import com.mika.credit.facade.globalsearch.core.model.Order;
import com.mika.credit.facade.globalsearch.core.model.OrderQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> selectSelective(OrderQuery o);

    int selectCountSelective(OrderQuery o);

    int updateStatusById(@Param("statusId") Integer statusId, @Param("orderId") Integer orderId);

    List<Order> selectAll();

    Order selectByOrderNo(String orderNo);

}