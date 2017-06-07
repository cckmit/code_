package com.mika.credit.facade.admin.service;

import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.admin.model.Category;
import com.mika.credit.facade.admin.model.System;

/**
 * Created by dell on 2017/4/6.
 */
public interface CategoryService {
    BootGrid<System> getSystems();      //查找所有系统
    ResponseResult<System> removeSystems(String id);   //删除系统
    ResponseResult<System> addSystem(System system);   //添加系统
    ResponseResult<System> updateSystem(System system);   //更新系统
    ResponseResult<System> margeSystem(System system);   //合并系统（有就修改，无就添加）
    BootGrid<Category> getCategorysAll();   //查找所有类别
    BootGrid<Category> getCategorys(BootGrid<Category> grid, Category category);   //根据条件查找类别
    ResponseResult<Category> removeCategory(String id);     //根据id删除类别
    ResponseResult<Category> addCategory(Category category);      //添加类别
    ResponseResult<Category> updateCategory(Category category);      //更新类别
    ResponseResult<Category> margeCategory(Category category);    //合并类别（有就修改，无就添加）
    int selectCountBySystem(String id);    //通过机构类别id查找对应corp的总数量
    ResponseResult<Category> getCategoryById(String id);        //通过id查找Corp
}
