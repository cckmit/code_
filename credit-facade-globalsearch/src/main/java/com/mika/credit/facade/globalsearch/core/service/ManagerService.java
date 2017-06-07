package com.mika.credit.facade.globalsearch.core.service;

import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.globalsearch.core.model.Manager;


public interface ManagerService {
     ResponseResult<Manager> getLoginInfo(Manager manager);
     
     boolean confirmCustomerRecharge(float cBalance, int customerId);
}
