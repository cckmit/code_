package com.mika.credit.facade.admin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.UtilEncode;
import com.mika.credit.facade.admin.dao.ge.GEManagerMapper;
import com.mika.credit.facade.admin.model.Manager;
import com.mika.credit.facade.admin.service.ManagerManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("managerManagerService")
public class ManagerManagerServiceImpl implements ManagerManagerService {


    @Autowired
    private GEManagerMapper managerMapper;

    /**
     * 管理员登陆
     *
     * @param manager
     * @return
     */
    @Override
    public ResponseResult<Manager> getLoginInfo(Manager manager) {
        ResponseResult<Manager> result = new ResponseResult<>();
        //账户密码加密
        manager.setPasswd(UtilEncode.encodeMD5(manager.getPasswd()));
        List<Manager> managers = managerMapper.selectSelective(manager);
        Manager managerResult = null;
        if (managers.size() > 0) {
            managerResult = managers.get(0);
        }
        if (managerResult != null) {
            managerResult.setLoginCount(managerResult.getLoginCount()+1);
            managerResult.setLastTime(new Date()) ;
            managerMapper.updateByPrimaryKeySelective(managerResult);
            result.setCode(true);
            result.setMsg("登录成功！");
            result.setContent(managerResult);
            return result;
        } else {
            result.setCode(false);
            result.setMsg("登录名或密码错误；登录失败！");
            return result;
        }
    }

    /**
     * 添加
     *
     * @param manager
     * @return
     */
    @Override
    public ResponseResult<Manager> add(Manager manager) {
        ResponseResult<Manager> result = new ResponseResult<>();
        manager.setPasswd(UtilEncode.encodeMD5(manager.getPasswd()));
        Manager manager1 = new Manager();
        manager1.setCode(manager.getCode());
        manager1.setPasswd(manager.getPasswd());
        List<Manager> managers = managerMapper.selectSelective(manager1);
        for (int i = 0; i < managers.size(); i++) {
            if (manager.getCode().equals(managers.get(i).getCode())) {
                result.setCode(false);
                result.setMsg("用户名已经存在");
                return result;
            }
        }
        manager.setLoginCount(0);
        int add = managerMapper.addManger(manager);
        if (add > 0) {
            result.setCode(true);
            result.setMsg("添加成功");
            return result;
        }else {
            result.setCode(false);
            result.setMsg("添加失败");
            return result;
        }
    }

    /**
     * 修改
     * @param manager
     * @return
     */

        @Override
        public ResponseResult<Manager> modifyManager (Manager manager){
            ResponseResult<Manager> result = new ResponseResult<>();
            int changedSel = managerMapper.updateByPrimaryKeySelective(manager);

            if (changedSel > 0) {
                result.setCode(true);
                result.setMsg("修改成功");
                ;
            } else {
                result.setCode(false);
                result.setMsg("修改失败");
            }
            return result;
        }

    /**
     * 删除
     * @param id
     * @return
     */
        @Override
        public ResponseResult<Manager> del ( int id){
            ResponseResult<Manager> result = new ResponseResult<>();
            if (managerMapper.delManager(id) > 0) {
                result.setCode(true);
                result.setMsg("删除成功");
            } else {
                result.setCode(false);
                result.setMsg("删除失败");
            }
            return result;
        }

    /**
     * 分页查询
     * @param grid
     * @param manager
     * @return
     */
        @Override
        public BootGrid<Manager> getManager (BootGrid < Manager > grid, Manager manager){
            Page<Manager> page = PageHelper.startPage(grid.getCurrent(), grid.getRowCount());
            grid.setRows(managerMapper.selectSelective(manager));
            grid.setTotal(managerMapper.selectCountSelective(manager));
            //grid.setTotal((int)(page.getTotal()));
            grid.setResult(true);
            return grid;
        }

    /**
     * 根据ID查询
     * @param id
     * @return
     */
        @Override
        public ResponseResult<Manager> queryById ( int id){
            ResponseResult<Manager> result = new ResponseResult<>();
            Manager manager = managerMapper.queryById(id);
            if (manager != null) {
                result.setCode(true);
                result.setMsg("查询成功");
                result.setContent(manager);
                return result;
            } else {
                result.setCode(false);
                result.setMsg("查询失败");
                return result;
            }
        }

}

