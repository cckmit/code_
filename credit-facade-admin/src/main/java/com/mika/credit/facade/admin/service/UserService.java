package com.mika.credit.facade.admin.service;

import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.admin.model.Group;
import com.mika.credit.facade.admin.model.Resource;
import com.mika.credit.facade.admin.model.User;

import java.util.List;
import java.util.Set;

/**
 * Created by Gavin on 2017/3/3.
 */
public interface UserService {
    /**
     * 管理员登录
     * 登录信息
     * @return 登录结果
     */
//    ResponseResult<User> getLoginInfo(User user);
    User findByUsername(String name);  //通过username查找，返回user
    BootGrid<User> getUsers(BootGrid<User> grid, User user);   //根据条件查找用户
    ResponseResult<User> removeUserGroup(String id);     //根据id删除用户
    ResponseResult<User> addUserGroup(User user);      //添加用户
    ResponseResult<User> updateUserGroup(User user);      //更新用户
    ResponseResult<User> margeUser(User user);    //合并用户（有就修改，无就添加）
    ResponseResult<User> getUserByIdGroup(String id);        //通过id查找用户
    int selectCountByCorp(String id);    //通过机构id查找对应用户的总数量
    int selectCountByDept(String id);    //通过部门id查找对应用户的总数量
    List<Group> findGroups(String name);   //通过username查找所拥有的角色
    Set<String> findRoleNames(String name);      //通过username查找所有角色名并封装
    List<Resource> findResources(String name);//通过username查找所拥有的权限（资源）
    Set<String> findPermissionNames(String name);      //通过username查找所有perms并封装

    ResponseResult<List> findResourceMenus(String name);      //通过username查找当前用户所拥有的菜单类型资源
}
