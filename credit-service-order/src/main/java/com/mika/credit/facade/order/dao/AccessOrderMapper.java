package com.mika.credit.facade.order.dao;

import com.mika.credit.facade.order.entity.AccessOrder;
import com.mika.credit.facade.order.entity.AccessOrderQuery;

import java.util.List;


public interface AccessOrderMapper {
    int deleteByPrimaryKey(Long id);

    int delete(AccessOrder record);

    int insert(AccessOrder record);

    int insertSelective(AccessOrder record);

    AccessOrder selectByPrimaryKey(Long id);

    AccessOrder selectByNo(String no);

    List<AccessOrder> select(AccessOrderQuery record);

    int updateByPrimaryKeySelective(AccessOrder record);

    int updateByPrimaryKey(AccessOrder record);

    int updateFinish(AccessOrder record);

    int updateCrefoNo(AccessOrder record);

    int updateDbTarget(AccessOrder record);
}