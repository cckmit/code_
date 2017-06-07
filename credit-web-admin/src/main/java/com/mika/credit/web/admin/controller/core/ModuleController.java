package com.mika.credit.web.admin.controller.core;

import com.alibaba.fastjson.JSON;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.order.Module;
import com.mika.credit.facade.order.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by dell on 2017/3/21.
 */
@Controller
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    /**
     * 后台模块信息列表 AJAX
     * @return
     */
    @RequestMapping(value = "/core/moduleList" ,method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String moduleList(Module module, BootGrid<Module> grid) {
        //Customer customer = new Customer();
        BootGrid<Module> result = moduleService.findModules(grid,module);
        result.setResult(true);
        return JSON.toJSONString(result);
    }

    /**
     * 删除模块 AJAX
     * @return
     */
    @RequestMapping(value = "/core/delModule" ,method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String delModule(@RequestBody Module module) {
        System.out.printf("del：-----"+module.getId());
        ResponseResult<Module> result=moduleService.deleteModule(module.getId());     //把Integer类型转成Long类型
        return JSON.toJSONString(result);
    }

    /**
     * 新增模块 AJAX
     * @return
     */
    @RequestMapping(value = "/core/addModule" ,method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String addModule(@RequestBody Module module) {
        ResponseResult<Module> result=moduleService.saveModule(module);
        return JSON.toJSONString(result);
    }

    /**
     * 修改模块 AJAX
     * @return
     */
    @RequestMapping(value = "/core/upModule" ,method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String upModule(@RequestBody Module module) {
        ResponseResult<Module> result=moduleService.updateModule(module);
        return JSON.toJSONString(result);

    }

}
