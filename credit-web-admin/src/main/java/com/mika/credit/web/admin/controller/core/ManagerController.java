package com.mika.credit.web.admin.controller.core;

import com.alibaba.fastjson.JSON;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.UtilEncode;
import com.mika.credit.facade.admin.model.Manager;
import com.mika.credit.facade.admin.service.ManagerManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/2/27.
 */
@Controller
public class ManagerController {
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    @Autowired
    private ManagerManagerService managerManagerService;
    /**
     *用户管理 AJAX
     * @return
     */
    @RequestMapping(value = "/core/managerList" ,method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String getManagerList(BootGrid<Manager> grid, Manager manager) {
        BootGrid<Manager> result = managerManagerService.getManager(grid,manager);
        return JSON.toJSONString(result);
    }
    /**
     *id查询
     * @return
     */
    @RequestMapping(value = "/core/getManagerById",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String getManagerByID(@RequestBody Manager manager) {
        ResponseResult<Manager> result =managerManagerService.queryById(manager.getId());
        return JSON.toJSONString(result);
    }
    /**
     * 重置密码
     * @return
     */
    @RequestMapping(value = "/core/updManagerPwd",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String updManagerPwd(@RequestBody Manager manager) {
        manager.setPasswd(UtilEncode.encodeMD5("888888"));
        ResponseResult<Manager> result = managerManagerService.modifyManager(manager);
        if(result.getCode()){
            result.setMsg("重置密码成功！密码为：888888");
        }else{
            result.setMsg("重置密码失败！");
        }
        return JSON.toJSONString(result);
    }
    /**
     * 修改客户信息
     * @return
     */
    @RequestMapping(value = "/core/modifyManager",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String modifyManager(@RequestBody Manager manager) {
        ResponseResult<Manager> result = managerManagerService.modifyManager(manager);
        return JSON.toJSONString(result);
    }
    /**
     * 删除客户
     */
    @RequestMapping(value = "/core/delManager",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String delManager(@RequestBody Manager manager) {
        ResponseResult<Manager> result = null;
        result = managerManagerService.del(manager.getId());
        return JSON.toJSONString(result);
    }

    /**
     * 添加
     */

    @RequestMapping(value = "/core/addManager",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String addManager(@RequestBody Manager manager) {
        ResponseResult<Manager> result = new ResponseResult<>();
        if(manager.getPasswd()==null || manager.getPasswd().equals("") || manager.getCode()==null || manager.getCode().equals("")){
            result.setCode(false);
            result.setMsg("不能为空");;
            return JSON.toJSONString(result);
        }else {
            manager.setCreateTime(new Date());
            result=managerManagerService.add(manager);
            return JSON.toJSONString(result);
        }
    }
}
