package com.mika.credit.facade.globalsearch.core.dao;

import com.mika.credit.facade.globalsearch.core.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerMapper {
    int deleteByPrimaryKey(int id);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(int id);

    Customer selectByEmail(String email);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    List<Customer> selectSelective(Customer record);

    int selectCountSelective(Customer record);

    int updatePasswordByEmail(Customer record);
    
    int updateCheckStatusById(Customer customer);
}