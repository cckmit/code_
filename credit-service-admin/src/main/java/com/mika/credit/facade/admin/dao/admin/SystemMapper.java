package com.mika.credit.facade.admin.dao.admin;

import com.mika.credit.facade.admin.model.System;

import java.util.List;

/**
 * Created by dell on 2017/4/1.
 */
public interface SystemMapper {
    int insertSelective(System system);
    List<System> querySelective(System system);

    List<System> queryAll();   //查询所有
    System queryById(String id);  //通过id查询
    int save(System system);     //添加
    int update(System system);    //更新
    int updateByIdSelective(System system);    //条件更新
    int deleteById(String id);     //通过id删除
    int delete(System system);     //条件删除
}
