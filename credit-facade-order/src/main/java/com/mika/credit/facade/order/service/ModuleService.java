package com.mika.credit.facade.order.service;

import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.order.Module;

/**
 * 产品模块服务
 *
 * @author zj001
 */
public interface ModuleService {

    /**
     * 分页查询模块
     * @param grid 分页条件
     * @param example 查询条件
     * @return 分页查询模块结果
     */
    BootGrid<Module> findModules(BootGrid<Module> grid, Module example);

    /**
     * 保存模块
     * @param record 需要保存的模块
     * @return 保存模块结果
     */
    ResponseResult<Module> saveModule(Module record);

    /**
     * 修改模块
     * @param record 需要修改的模块
     * @return 修改模块结果
     */
    ResponseResult<Module> updateModule(Module record);

    /**
     * 删除模块
     * @param record 需要删除的模块
     * @return 删除模块结果
     */
    ResponseResult<Module> deleteModule(Module record);

    /**
     * 根据id删除模块
     * @param moduleId 模块id
     * @return 删除模块结果
     */
    ResponseResult<Module> deleteModule(Integer moduleId);

}
