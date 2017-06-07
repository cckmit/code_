package com.mika.credit.facade.admin.dao.gs;

import com.mika.credit.facade.admin.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GSCustomerMapper {
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

    String selCusEmail(Integer cusId);

}