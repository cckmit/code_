package com.mika.credit.facade.order.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.order.Module;
import com.mika.credit.common.entity.order.ProductModule;
import com.mika.credit.facade.order.dao.ModuleMapper;
import com.mika.credit.facade.order.dao.ProductModuleMapper;
import com.mika.credit.facade.order.service.ModuleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by Gavin on 2017/3/14.
 */
@Service("moduleService")
public class ModuleServiceImpl implements ModuleService {
    @Autowired
    private ModuleMapper moduleMapper;
    @Autowired
    private ProductModuleMapper productModuleMapper;

    private static Logger logger = Logger.getLogger(ModuleServiceImpl.class);

    @Override
    public BootGrid<Module> findModules(BootGrid<Module> grid, Module example) {
        logger.info("进入查询模块findModules方法");
        if (example != null && grid != null) {
            Page<Object> page = PageHelper.startPage(grid.getCurrent(), grid.getRowCount());
            List<Module> modules = moduleMapper.queryList(example);
            if (!CollectionUtils.isEmpty(modules)) {
                grid.setRows(modules);
                grid.setRowCount((int) page.getTotal());
                grid.setResult(true);
            }
        }
        logger.info("查询模块findModules方法结束,返回结果:"+ JSON.toJSONString(grid));
        return grid;
    }

    @Override
    public ResponseResult<Module> saveModule(Module record) {
        logger.info("进入保存模块saveModule方法");
        ResponseResult<Module> responseResult = new ResponseResult<>();
        if (record != null) {
            int save = moduleMapper.save(record);
            if (save > 0) {
                responseResult.setMsg("模块保存成功");
                responseResult.setCode(true);
            }
        }
        if (!responseResult.getCode()) {
            responseResult.setMsg("模块保存失败");
        }
        logger.info("保存模块saveModule方法结束,返回结果:"+ JSON.toJSONString(responseResult));
        return responseResult;
    }

    @Override
    public ResponseResult<Module> updateModule(Module record) {
        logger.info("进入更新模块updateModule方法");
        ResponseResult<Module> responseResult = new ResponseResult<>();
        if (record != null) {
            int update = moduleMapper.update(record);
            if (update > 0) {
                responseResult.setMsg("模块修改成功");
                responseResult.setCode(true);
            } else {
                responseResult.setMsg("模块修改失败");
            }

        } else {
            responseResult.setMsg("无此模块");
        }
        logger.info("更新模块updateModule方法结束,返回结果:"+ JSON.toJSONString(responseResult));
        return responseResult;
    }

    @Override
    public ResponseResult<Module> deleteModule(Module record) {
        logger.info("进入删除模块deleteModule方法");
        boolean flag = true;
        ResponseResult<Module> responseResult = new ResponseResult<>();
        if (record != null) {
            List<Module> modules = moduleMapper.queryList(record);
            if (!CollectionUtils.isEmpty(modules)) {
                for (Module module : modules) {
                    ProductModule productModule = new ProductModule();
                    productModule.setModuleId(module.getId());
                    flag &= productModuleMapper.delete(productModule) > 0;
                }
            }
            flag &= moduleMapper.delete(record) > 0;
            if (flag) {
                responseResult.setMsg("模块删除成功");
                responseResult.setCode(true);
            } else {
                responseResult.setMsg("模块删除失败");
            }

        } else {
            responseResult.setMsg("无此模块");
        }
        logger.info("删除模块deleteModule方法结束,返回结果:"+ JSON.toJSONString(responseResult));
        return responseResult;
    }

    @Override
    public ResponseResult<Module> deleteModule(Integer moduleId) {
        logger.info("进入根据模块id删除模块deleteModule方法");
        ResponseResult<Module> responseResult = new ResponseResult<>();
        if (moduleId != null) {
            int update = moduleMapper.deleteById(moduleId);
            if (update > 0) {
                responseResult.setMsg("模块删除成功");
                responseResult.setCode(true);
            } else {
                responseResult.setMsg("模块删除失败");
            }

        } else {
            responseResult.setMsg("无此模块");
        }
        logger.info("根据模块id删除模块deleteModule方法结束,返回结果:"+ JSON.toJSONString(responseResult));
        return responseResult;
    }
}
