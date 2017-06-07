package com.mika.credit.web.admin.controller.core;

import com.alibaba.fastjson.JSON;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.admin.model.Group;
import com.mika.credit.facade.admin.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by dell on 2017/4/28.
 */
@Controller
public class GroupController {

    @Autowired
    private GroupService groupService;

    @RequestMapping(value = "/core/groupList",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String groupList() {
        BootGrid<Group> grid = groupService.getGroups();
        return JSON.toJSONString(grid);
    }

    @RequestMapping(value = "/core/groupSave",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String groupSave(BootGrid<Group> grid, @RequestBody Group group) {
        if(groupService.margeGroup(group).getCode()){
            grid = groupService.getGroups();
            grid.setResult(true);
        }else{
            grid.setResult(false);
        }
        return JSON.toJSONString(grid);
    }

    @RequestMapping(value = "/core/groupDel",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String groupDel(BootGrid<Group> grid, String id) {
        if(groupService.removeGroup(id).getCode()){
            grid = groupService.getGroups();
            grid.setResult(true);
        }else{
            grid.setResult(false);
        }
        return JSON.toJSONString(grid);
    }

    @RequestMapping(value = "/core/getGroup",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String getGroup(Group group) {
        ResponseResult<Group> result = groupService.selectGroupResource(group);
        return JSON.toJSONString(result);
    }
}
