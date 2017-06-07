package com.mika.credit.facade.admin.service;

import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.admin.model.Dept;

/**
 * Created by dell on 2017/4/6.
 */
public interface DeptService {
    BootGrid<Dept> getDepts(BootGrid<Dept> grid, Dept dept);   //根据条件查找部门
    ResponseResult<Dept> removeDept(String id);     //根据id删除部门
    ResponseResult<Dept> addDept(Dept dept);      //添加部门
    ResponseResult<Dept> updateDept(Dept dept);      //更新部门

    ResponseResult<Dept> margeDept(Dept dept);    //合并部门（有就修改，无就添加）
    ResponseResult<Dept> getDeptById(String id);        //通过id查找部门
    int selectCountByCorp(String id);    //通过机构id查找对应部门的总数量
}
