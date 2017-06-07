package com.mika.credit.web.admin.controller.basic;

import com.alibaba.fastjson.JSON;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.StringUtil;
import com.mika.credit.facade.admin.model.Help;
import com.mika.credit.facade.admin.model.HelpCate;
import com.mika.credit.facade.admin.service.HelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2016/9/19.
 */
@Controller
public class HelpController {
    @Autowired
    private HelpService helpService;

    @RequestMapping(value = "/basic/helpCateList",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String helpCateList(HelpCate helpCate) {
        BootGrid<HelpCate> grid = helpService.getHelpCates(helpCate);
        return JSON.toJSONString(grid);
    }

    @RequestMapping(value = "/basic/getHelpCate",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String getHelpCate(Integer id) {
        ResponseResult<HelpCate> result=new ResponseResult<>();
        HelpCate helpCate = helpService.getHelpCateById(id);
        if(helpCate!=null){
            result.setCode(true);
            result.setContent(helpCate);
        }else{
            result.setCode(false);
        }
        return JSON.toJSONString(result);
    }

    @RequestMapping(value = "/basic/helpCateSave",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String helpCateSave( HelpCate helpCate) {
        ResponseResult<HelpCate> result=new ResponseResult<>();
        if(helpService.mergeHelpCate(helpCate) > 0){
            result.setCode(true);
        }else{
            result.setCode(true);
        }
        return JSON.toJSONString(result);
    }

    @RequestMapping(value = "/basic/helpCateDel",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String helpCateDel(BootGrid<HelpCate> grid, HelpCate helpCate) {
        //校验是否有下属条目，如果有，不允许删除
        if(StringUtil.isNotNull(helpCate) && StringUtil.isNotNull(helpCate.getId())) {
            int id=helpCate.getId();
            int count = helpService.selectCountByCate(id);
            if (count > 0) {
                grid.setResult(false);
                grid.setResultDes("该分类下还包含" + count + "个条目，不允许删除！");
                return JSON.toJSONString(grid);
            }
            if (helpService.removeHelpCate(id) > 0) {
                HelpCate helpCate1 = new HelpCate();
                helpCate1.setSource(helpCate.getSource());
                grid = helpService.getHelpCates(helpCate1);
                grid.setResult(true);
            } else {
                grid.setResult(false);
            }
        }else{
            grid.setResult(false);
        }
        return JSON.toJSONString(grid);
    }

    @RequestMapping(value = "/basic/helpList",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String managerHelpList(Help condition, BootGrid<Help> grid){
        BootGrid<Help> result= helpService.getHelps(condition, grid);
        return JSON.toJSONString(result);
    }

    @RequestMapping(value = "/helpList",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String helpList(Help condition, BootGrid<Help> grid){
        return  managerHelpList(condition, grid);
    }

    @RequestMapping(value = "/basic/helpSave",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String managerHelpSave(Help help, BootGrid<Help> grid) {
        if(helpService.mergeHelp(help) > 0){
            grid.setResult(true);
        }else{
            grid.setResult(false);
        }
        return JSON.toJSONString(grid);
    }

    @RequestMapping(value = "/basic/helpDel",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String helpDel(BootGrid<HelpCate> grid, Integer id) {
        if(helpService.removeHelp(id) > 0){
            grid.setResult(true);
        }else{
            grid.setResult(false);
        }
        return JSON.toJSONString(grid);
    }

    @RequestMapping(value = "/basic/getHelp",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String managerGetHelp(Integer id) {
        ResponseResult<Help> result=new ResponseResult<>();
        Help help = helpService.getHelpById(id);
        if(help!=null){
            result.setCode(true);
            result.setContent(help);
        }else{
            result.setCode(false);
        }
        return JSON.toJSONString(result);
    }
    @RequestMapping(value = "/getHelp",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String getHelp(Integer id) {
        return managerGetHelp(id);
    }
}