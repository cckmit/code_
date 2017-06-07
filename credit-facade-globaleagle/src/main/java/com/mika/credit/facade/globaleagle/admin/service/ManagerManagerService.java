package com.mika.credit.facade.globaleagle.admin.service;

import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.globaleagle.core.model.Customer;
import com.mika.credit.facade.globaleagle.core.model.Manager;

import java.util.List;

public interface ManagerManagerService {
     ResponseResult<Manager> getLoginInfo(Manager manager);
     ResponseResult<Manager> add(Manager manager);
     ResponseResult<Manager> modifyManager(Manager manager);
     ResponseResult<Manager> del(int id);
     BootGrid<Manager> getManager(BootGrid<Manager> grid,Manager manager);
     ResponseResult<Manager> queryById(int id);
}
