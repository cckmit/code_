package com.mika.credit.facade.admin.service;

import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.admin.model.Manager;

/**
 * Manager的接口
 * @author dhl007
 */
public interface ManagerManagerService {

     /**
      * 管理员登录
      * @param manager 登录信息
      * @return 登录结果
      */
     ResponseResult<Manager> getLoginInfo(Manager manager);

     /**
      * 添加管理员
      * @param manager 管理员信息
      * @return 添加结果
      */
     ResponseResult<Manager> add(Manager manager);

     /**
      * 修改管理员信息
      * @param manager 修改信息
      * @return 修改结果
      */
     ResponseResult<Manager> modifyManager(Manager manager);

     /**
      * 删除管理员
      * @param id 管理员id
      * @return 删除结果
      */
     ResponseResult<Manager> del(int id);

     /**
      * 查找管理员
      * @param grid 分页信息
      * @param manager 查找条件
      * @return 查找结果
      */
     BootGrid<Manager> getManager(BootGrid<Manager> grid, Manager manager);

     /**
      * 通过id查找
      * @param id 管理员id
      * @return 查找结果
      */
     ResponseResult<Manager> queryById(int id);
}
