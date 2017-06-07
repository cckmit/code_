package com.mika.credit.facade.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.StringUtil;
import com.mika.credit.common.util.UtilGenerateID;
import com.mika.credit.facade.admin.dao.admin.CategoryMapper;
import com.mika.credit.facade.admin.dao.admin.SystemMapper;
import com.mika.credit.facade.admin.model.Category;
import com.mika.credit.facade.admin.model.System;
import com.mika.credit.facade.admin.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by credit on 2017/3/15.
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private SystemMapper systemMapper;

    @Override
    public BootGrid<System> getSystems() {
        BootGrid<System> result = new BootGrid<System>();
        result.setRows(systemMapper.queryAll());
        result.setTotal(systemMapper.queryAll().size());
        result.setResult(true);
        return result;
    }

    @Override
    public ResponseResult<System> removeSystems(String id) {
        ResponseResult<System> result = new ResponseResult<System>();
        if (systemMapper.deleteById(id) > 0) {
            result.setCode(true);
            result.setMsg("系统删除成功！");
        } else {
            result.setCode(false);
            result.setMsg("系统删除失败！");
        }
        return result;
    }

    @Override
    public ResponseResult<System> updateSystem(System system) {
        ResponseResult<System> result = new ResponseResult<System>();
        if (StringUtil.isNotNull(system)) {
            if (systemMapper.updateByIdSelective(system) > 0) {
                result.setCode(true);
                result.setMsg("系统更新成功！");
            } else {
                result.setCode(false);
                result.setMsg("系统更新失败！");
            }
        } else {
            result.setCode(false);
            result.setMsg("系统不能为空！");
        }
        return result;
    }

    @Override
    public ResponseResult<System> addSystem(System system) {
        ResponseResult<System> result = new ResponseResult<System>();
        if (StringUtil.isNotNull(system)) {
            if (systemMapper.querySelective(system).size() > 0) {
                result.setCode(false);
                result.setMsg("该系统已存在，添加失败！");
            } else {
                system.setId(UtilGenerateID.generateID("SYS"));
                if (systemMapper.save(system) > 0) {
                    result.setCode(true);
                    result.setMsg("系统添加成功！");
                } else {
                    result.setCode(false);
                    result.setMsg("系统添加失败！");
                }
          }
        } else {
            result.setCode(false);
            result.setMsg("系统不能为空！");
        }
        return result;
    }

    @Override
    public BootGrid<Category> getCategorysAll() {
        BootGrid<Category> result = new BootGrid<Category>();
        result.setRows(categoryMapper.queryAll());
        result.setTotal(categoryMapper.queryAll().size());
        result.setResult(true);
        return result;
    }

    @Override
    public ResponseResult<System> margeSystem(System system) {
        ResponseResult<System> result = new ResponseResult<System>();
        if (system != null) {
            if (system.getId() != null && !"".equals(system.getId())) {
                result=updateSystem(system);
            } else {
                result=addSystem(system);
            }
        }
        return result;
    }

    @Override
    public BootGrid<Category> getCategorys(BootGrid<Category> grid, Category category) {
        PageHelper.startPage(grid.getCurrent(), grid.getRowCount());
        grid.setRows(categoryMapper.querySelective(category));
        grid.setTotal(categoryMapper.querySelective(category).size());
        grid.setResult(true);
        return grid;
    }

    @Override
    public ResponseResult<Category> removeCategory(String id) {
        ResponseResult<Category> result = new ResponseResult<Category>();
        if (categoryMapper.deleteById(id) > 0) {
            result.setCode(true);
            result.setMsg("类别删除成功！");
        } else {
            result.setCode(false);
            result.setMsg("类别删除失败！");
        }
        return result;
    }

    @Override
    public ResponseResult<Category> updateCategory(Category category) {
        ResponseResult<Category> result = new ResponseResult<Category>();
        if (StringUtil.isNotNull(category)) {
            if (categoryMapper.updateByIdSelective(category) > 0) {
                result.setCode(true);
                result.setMsg("类别更新成功！");
            } else {
                result.setCode(false);
                result.setMsg("类别更新失败！");
            }
        } else {
            result.setCode(false);
            result.setMsg("类别不能为空！");
        }
        return result;
    }

    @Override
    public ResponseResult<Category> addCategory(Category category) {
        ResponseResult<Category> result = new ResponseResult<Category>();
        if (StringUtil.isNotNull(category)) {
            if (categoryMapper.querySelective(category).size() > 0) {
                result.setCode(false);
                result.setMsg("该类别已存在，添加失败！");
            } else {
                category.setId(UtilGenerateID.generateID("CAT"));
        if (categoryMapper.save(category) > 0) {
            result.setCode(true);
            result.setMsg("类别添加成功！");
        } else {
            result.setCode(false);
            result.setMsg("类别添加失败！");
        }
            }
        } else {
            result.setCode(false);
            result.setMsg("类别不能为空！");
        }
        return result;
    }

    @Override
    public ResponseResult<Category> margeCategory(Category category) {
        ResponseResult<Category> result = new ResponseResult<Category>();
        if (category != null) {
            if (category.getId() != null && !"".equals(category.getId())) {
                result=updateCategory(category);
            } else {
               result=addCategory(category);
            }
        }
        return result;
    }

    @Override
    public int selectCountBySystem(String id) {
        return categoryMapper.selectCountBySystem(id);
    }

    @Override
    public ResponseResult<Category> getCategoryById(String id) {
        ResponseResult<Category> result = new ResponseResult<Category>();
        Category category = categoryMapper.queryById(id);
        if (category != null) {
            result.setCode(true);
            result.setContent(category);
            result.setMsg("查找成功！");
        } else {
            result.setCode(false);
            result.setMsg("查找失败！");
        }
        return result;
    }
}
