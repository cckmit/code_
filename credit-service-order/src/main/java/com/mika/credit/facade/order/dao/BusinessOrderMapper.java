package com.mika.credit.facade.order.dao;

import com.mika.credit.facade.order.entity.BusinessOrder;
import com.mika.credit.facade.order.entity.BusinessOrderQuery;

import java.util.List;

public interface BusinessOrderMapper {
    int deleteByPrimaryKey(Long id);

    int delete(BusinessOrder record);

    int insert(BusinessOrder record);

    int insertSelective(BusinessOrder record);

    BusinessOrder selectByPrimaryKey(Long id);

    BusinessOrder selectByNO(String no);

    List<BusinessOrder> selectByQuery(BusinessOrderQuery businessOrderQuery);

    int updateByPrimaryKeySelective(BusinessOrder record);

    int updateByPrimaryKey(BusinessOrder record);

    int updateURLByPrimaryKey(BusinessOrder record);

    int updateURLByNO(BusinessOrder record);

    //BusinessOrder findOrderByEntryId(BigInteger entryId);

    //List<BusinessOrder> findOrderListByEntryId(BigInteger entryId);

    Integer updateStatus(BusinessOrder record);

    //Integer updateEntryId(BusinessOrder record);

    //BigInteger findLastEntryId(@Param(value = "status") Byte status);

}