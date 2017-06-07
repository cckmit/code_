package com.mika.credit.facade.order.dao;


import com.mika.credit.common.entity.order.Module;

import java.util.List;

/**
 * Created by dell on 2017/3/2.
 */
public interface ModuleMapper {
    int save(Module record);
    int delete(Module example);
    int update(Module record);
    int deleteById(Object id);
    int deleteBatch(Object[] ids);
    Module queryById(Object id);
    List<Module> queryList(Module example);
    int queryTotal(Module example);
}
