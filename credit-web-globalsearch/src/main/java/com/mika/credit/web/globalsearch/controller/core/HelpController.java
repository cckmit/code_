package com.mika.credit.web.globalsearch.controller.core;

import com.alibaba.fastjson.JSON;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.UtilEncode;
import com.mika.credit.facade.admin.model.Help;
import com.mika.credit.facade.admin.model.HelpCate;
import com.mika.credit.facade.admin.service.HelpService;
import com.mika.credit.facade.messagebox.model.Message;
import com.mika.credit.facade.messagebox.service.MessageboxService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/9/19.
 */
@Controller
public class HelpController {
    private static final Logger logger = Logger.getLogger(HelpController.class);
    @Autowired
    private HelpService helpService;

    @Autowired
    private MessageboxService messageboxService;

    @RequestMapping(value = "/helpCateList",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String customerHelpList(){
        logger.info("来源2，查询帮助类别开始...");
        HelpCate helpCate = new HelpCate();
        helpCate.setSource((byte) 2);
        BootGrid<HelpCate> grid = helpService.getHelpCates(helpCate);
        return JSON.toJSONString(grid);
    }

    @RequestMapping(value = "/customer/helpList",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String customerHelpList(Help condition, BootGrid<Help> grid){
        logger.info("来源2，查询帮助内容开始...");
        condition.setSource((byte) 2);
        grid = helpService.getHelps(condition, grid);
        return JSON.toJSONString(grid);
    }
    @RequestMapping(value = "/helpList",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String helpList(Help condition, BootGrid<Help> grid){
        condition.setSource((byte) 2);
        return  customerHelpList(condition, grid);
    }


    @RequestMapping(value = "/customer/helpSave",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String managerHelpSave(Help help, BootGrid<Help> grid) {
        logger.info("合并帮助信息开始...");
        if(helpService.mergeHelp(help) > 0){
            helpService.getHelps(help, grid);
            grid.setResult(true);
        }else{
            grid.setResult(false);
        }
        return JSON.toJSONString(grid);
    }

    @RequestMapping(value = "/customer/helpDel",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String managerHelpDel(BootGrid<HelpCate> grid, Integer id) {
        logger.info("合并帮助类别开始...");
        if(helpService.removeHelp(id) > 0){
            grid.setResult(true);
        }else{
            grid.setResult(false);
        }
        return JSON.toJSONString(grid);
    }

    /**
     * 根据id查help
     * @param id
     * @return
     */
    @RequestMapping(value = "/customer/getHelp")
    public String managerGetHelp(Integer id,ModelMap map) {
        logger.info("根据id查询帮助内容开始...");
        Help help = helpService.getHelpById(id);
        UtilEncode utilEncode=new UtilEncode();
        map.addAttribute("help",utilEncode.base64Decode(help.getContent()));
        return "/helpContent";
    }
    @RequestMapping(value = "/getHelp")
    public String getHelp(Integer id,ModelMap map) {
        return managerGetHelp(id,map);
    }

    /**
     * 发送站内信
     * @param message
     * @return
     */
    @RequestMapping(value = "/customer/messagebox",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String messagebox(Message message) {
        ResponseResult<String> result = messageboxService.sendMessage(message);
        return JSON.toJSONString(result);
    }
    @RequestMapping(value = "/getMessagebox",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String getMessagebox(Message message) {
        return messagebox(message);
    }

}