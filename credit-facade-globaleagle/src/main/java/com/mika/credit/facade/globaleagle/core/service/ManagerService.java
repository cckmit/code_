package com.mika.credit.facade.globaleagle.core.service;

import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.globaleagle.core.model.Manager;

public interface ManagerService {
     public ResponseResult<Manager> getLoginInfo(Manager manager);
     
     public boolean confirmCustomerRecharge(float cBalance, int customerId);
}
