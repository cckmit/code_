package com.mika.credit.facade.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.StringUtil;
import com.mika.credit.common.util.UtilGenerateID;
import com.mika.credit.facade.admin.dao.admin.DeptMapper;
import com.mika.credit.facade.admin.model.Dept;
import com.mika.credit.facade.admin.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dell on 2017/4/6.
 */
@Service("deptService")
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    public BootGrid<Dept> getDepts(BootGrid<Dept> grid, Dept dept) {
        PageHelper.startPage(grid.getCurrent(), grid.getRowCount());
        grid.setRows(deptMapper.queryList(dept));
        grid.setTotal(deptMapper.queryList(dept).size());
        grid.setResult(true);
        return grid;
    }

    public ResponseResult<Dept> removeDept(String id) {
        ResponseResult<Dept> result = new ResponseResult<Dept>();
        if(deptMapper.deleteById(id)>0){
            result.setCode(true);
            result.setMsg("部门删除成功！");
        }
        else{
            result.setCode(false);
            result.setMsg("部门删除失败！");
        }
        return result;
    }

    @Override
    public ResponseResult<Dept> updateDept(Dept dept) {
        ResponseResult<Dept> result = new ResponseResult<Dept>();
        if (StringUtil.isNotNull(dept)) {
                if(deptMapper.updateByIdSelective(dept)>0){
                    result.setCode(true);
                    result.setMsg("部门更新成功！");
                }
                else{
                    result.setCode(false);
                    result.setMsg("部门更新失败！");
                }
        } else {
            result.setCode(false);
            result.setMsg("部门不能为空！");
        }
        return result;
    }

    public ResponseResult<Dept> addDept(Dept dept) {
        ResponseResult<Dept> result = new ResponseResult<Dept>();
        if (StringUtil.isNotNull(dept)) {
            if (deptMapper.queryList(dept).size() > 0) {
                result.setCode(false);
                result.setMsg("该部门已存在，添加失败！");
            } else {
                dept.setId(UtilGenerateID.generateID("DEP"));
        if(deptMapper.save(dept)>0){
            result.setCode(true);
            result.setMsg("部门添加成功！");
        }
        else{
            result.setCode(false);
            result.setMsg("部门添加失败！");
        }
            }
        } else {
            result.setCode(false);
            result.setMsg("部门不能为空！");
        }
        return result;
    }

    public ResponseResult<Dept> margeDept(Dept dept) {
        ResponseResult<Dept> result = new ResponseResult<Dept>();
        if(dept != null){
            if(dept.getId() != null && !"".equals(dept.getId())){
                result=updateDept(dept);
            }else{
               result=addDept(dept);
            }
        }
        return result;
    }

    public ResponseResult<Dept> getDeptById(String id) {
        ResponseResult<Dept> result = new ResponseResult<Dept>();
        Dept dept=deptMapper.queryById(id);
        if(dept != null){
            result.setCode(true);
            result.setContent(dept);
            result.setMsg("查找成功！");
        }
        else{
            result.setCode(false);
            result.setMsg("查找失败！");
        }
        return result;
    }

    public int selectCountByCorp(String id) {
        return deptMapper.selectCountByCorp(id);
    }
}
