package com.mika.credit.facade.admin.dao.admin;


import com.mika.credit.facade.admin.model.Dept;

import java.util.List;

/**
 * Created by credit on 2017/3/16.
 */
public interface DeptMapper extends BaseMapper<Dept> {
    List<Dept> queryList(Dept dept);
    Dept queryById(String id);       //通过id查询
    List<Dept> queryAll(Dept dept);    //查询所有
    int save(Dept dept);
    int update(Dept dept);
    int updateByIdSelective(Dept dept);
    int deleteById(String id);
    int selectCountByCorp(String id);    //根据Corp的id查找对应所有部门的总数量
}
