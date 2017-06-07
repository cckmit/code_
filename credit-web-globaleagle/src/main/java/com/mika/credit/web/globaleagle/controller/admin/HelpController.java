package com.mika.credit.web.globaleagle.controller.admin;

import com.alibaba.fastjson.JSON;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.facade.admin.model.Help;
import com.mika.credit.facade.admin.model.HelpCate;
import com.mika.credit.facade.admin.service.HelpService;
import org.apache.log4j.Logger;
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
    private static Logger logger = Logger.getLogger(HelpController.class);
    @Autowired
    private HelpService helpService;

    @RequestMapping(value = "/manager/helpCateList",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String managerHelpCateList() {
        logger.info("查询帮助类别，来源为1方法开始...");
        HelpCate helpCate = new HelpCate();
        helpCate.setSource((byte) 1);
        BootGrid<HelpCate> grid = helpService.getHelpCates(helpCate);
        return JSON.toJSONString(grid);
    }

    @RequestMapping(value = "/manager/helpCateSave",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String managerHelpCateSave(BootGrid<HelpCate> grid, HelpCate helpCate) {
        logger.info("来源为1,合并帮助类别信息方法开始...");
        helpCate.setSource((byte) 1);
        if(helpService.mergeHelpCate(helpCate) > 0){
            HelpCate helpCateAll = new HelpCate();
            helpCateAll.setSource((byte) 1);
            grid = helpService.getHelpCates(helpCateAll);
            grid.setResult(true);
        }else{
            grid.setResult(false);
        }
        return JSON.toJSONString(grid);
    }

    @RequestMapping(value = "/manager/helpCateDel",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String managerHelpCateDel(BootGrid<HelpCate> grid, Integer id) {
        logger.info("来源为1，删除帮助类别方法开始...");
        //校验是否有下属条目，如果有，不允许删除
        int count = helpService.selectCountByCate(id);
        if(count > 0){
            grid.setResult(false);
            grid.setResultDes("该分类下还包含" + count + "个条目，不允许删除！");
            return JSON.toJSONString(grid);
        }
        if(helpService.removeHelpCate(id) > 0){
            HelpCate helpCateAll = new HelpCate();
            helpCateAll.setSource((byte) 1);
            grid = helpService.getHelpCates(helpCateAll);
            grid.setResult(true);
        }else{
            grid.setResult(false);
        }
        return JSON.toJSONString(grid);
    }

    @RequestMapping(value = "/manager/helpList",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String managerHelpList(Help condition, BootGrid<Help> grid){
        logger.info("来源为1,查询帮助内容方法开始...");
        condition.setSource((byte) 1);
        grid = helpService.getHelps(condition, grid);
        return JSON.toJSONString(grid);
    }

    @RequestMapping(value = "/helpList",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String helpList(Help condition, BootGrid<Help> grid){
        condition.setSource((byte) 1);
        return  managerHelpList(condition, grid);
    }

    @RequestMapping(value = "/manager/helpSave",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String managerHelpSave(Help help, BootGrid<Help> grid) {
        logger.info("合并帮助信息方法开始...");
        if(helpService.mergeHelp(help) > 0){
            helpService.getHelps(help, grid);
            grid.setResult(true);
        }else{
            grid.setResult(false);
        }
        return JSON.toJSONString(grid);
    }

    @RequestMapping(value = "/manager/helpDel",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String managerHelpDel(BootGrid<HelpCate> grid, Integer id) {
        logger.info("删除帮助方法开始...");
        if(helpService.removeHelp(id) > 0){
            grid.setResult(true);
        }else{
            grid.setResult(false);
        }
        return JSON.toJSONString(grid);
    }

    @RequestMapping(value = "/manager/getHelp",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String managerGetHelp(Integer id) {
        logger.info("通过id查询帮助方法开始...");
        Help help = helpService.getHelpById(id);
        return JSON.toJSONString(help);
    }
    @RequestMapping(value = "/getHelp",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String getHelp(Integer id) {
        return managerGetHelp(id);
    }



}