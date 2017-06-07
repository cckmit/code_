package com.mika.credit.facade.globalsearch.core.dao;

import com.mika.credit.facade.globalsearch.core.model.OrderDetail;
import com.mika.credit.facade.globalsearch.core.model.OrderDetailQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);

    List<OrderDetail> selectSelective(OrderDetailQuery o);

    int selectCountSelective(OrderDetailQuery o);

    int deleteByOrderId(int orderId);

    String selectOnLineDataJsonById(Integer id);

    String selectOffLineDataJsonById(Integer id);

    int selectUnfinishedCountByOrderId(Integer orderId);

    int updateOrderStatusById(@Param("statusId") Integer statusId, @Param("id") Integer id);

    List<OrderDetail> selectSelectiveIsPayAndNoCancel(OrderDetailQuery o);
}