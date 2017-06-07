package com.mika.credit.web.admin.controller.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.admin.model.Corp;
import com.mika.credit.facade.admin.model.CorpType;
import com.mika.credit.facade.admin.model.Dept;
import com.mika.credit.facade.admin.service.CorpService;
import com.mika.credit.facade.admin.service.DeptService;
import com.mika.credit.facade.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by dell on 2017/4/7.
 */
@Controller
public class CorpController {

    @Autowired
    private CorpService corpService;

    @Autowired
    private DeptService deptService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/core/corpTypeList",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String corpTypeList() {
        BootGrid<CorpType> grid = corpService.getCorpTypes();
        return JSON.toJSONString(grid);
    }

    @RequestMapping(value = "/core/corpTypeSave",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String corpTypeSave(BootGrid<CorpType> bootGrid, CorpType corpType) {
        if(corpService.margeCorpType(corpType).getCode()){
            bootGrid=corpService.getCorpTypes();
            bootGrid.setResult(true);
        }else{
            bootGrid.setResult(false);
        }
        return JSON.toJSONString(bootGrid);
    }

    @RequestMapping(value = "/core/corpTypeDel",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String corpTypeDel(BootGrid<CorpType> grid, String id) {
        //校验是否有下属条目，如果有，不允许删除
        int count = corpService.selectCountByType(id);
        if(count > 0){
            grid.setResult(false);
            grid.setResultDes("该分类下还包含" + count + "个机构，不允许删除！");
            return JSON.toJSONString(grid);
        }
        if(corpService.removeCorpTypes(id).getCode()){
            grid = corpService.getCorpTypes();
            grid.setResult(true);
        }else{
            grid.setResult(false);
        }
        return JSON.toJSONString(grid);
    }

    @RequestMapping(value = "/core/corpList",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String corpList(Corp corp, BootGrid<Corp> grid){
        BootGrid<Corp> result= corpService.getCorps(grid,corp);
        return JSON.toJSONString(result);
    }

    @RequestMapping(value = "/core/corpSave",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String managerHelpSave(Corp corp) {
        ResponseResult<Corp> result=corpService.margeCorp(corp);
        return JSON.toJSONString(result);
    }

    @RequestMapping(value = "/core/corpDel",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String corpDel(BootGrid<Corp> grid, Corp corp) {
        //校验是否有下属条目，如果有，不允许删除
        String id=corp.getId();
        int count = deptService.selectCountByCorp(id);
        if(count > 0){
            grid.setResult(false);
            grid.setResultDes("该机构下还包含" + count + "个部门，不允许删除！");
            return JSON.toJSONString(grid);
        }
        if(corpService.removeCorp(id).getCode()){
            BootGrid<Corp> bootGrid=new BootGrid<Corp>();
            Corp corp1=new Corp();
            CorpType corpType=new CorpType();
            corpType.setId(corp.getCorpType().getId());
            corp1.setCorpType(corpType);
            grid = corpService.getCorps(bootGrid,corp1);
            grid.setResult(true);
        }else{
            grid.setResult(false);
        }
        return JSON.toJSONString(grid);

//        ResponseResult<Corp> result=corpService.removeCorp(id);
//        return JSON.toJSONString(result);
    }

    @RequestMapping(value = "/core/getCorp",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String managerGetHelp(String id) {
        ResponseResult<Corp> result = corpService.getCorpById(id);
        return JSON.toJSONString(result);
    }

    @RequestMapping(value = "/core/deptList",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String deptList(Dept dept, BootGrid<Dept> grid){
        BootGrid<Dept> result= deptService.getDepts(grid,dept);
        return JSON.toJSONString(result);
    }

    @RequestMapping(value = "/core/deptSave",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String deptSave(Dept dept) {
        ResponseResult<Dept> result=deptService.margeDept(dept);
        return JSON.toJSONString(result);
    }

    @RequestMapping(value = "/core/deptDel",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String deptDel(Dept dept) {
        ResponseResult<Dept> result=new ResponseResult<Dept>();
        //校验是否有下属条目，如果有，不允许删除
        String id=dept.getId();
        int count = userService.selectCountByDept(id);
        if(count > 0){
            result.setCode(false);
            result.setMsg("该部门下还包含" + count + "个用户，不允许删除！");
            return JSON.toJSONString(result);
        }
        result=deptService.removeDept(id);
        return JSON.toJSONString(result);
    }

    @RequestMapping(value = "/core/getDept",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String getDept(String id) {
        ResponseResult<Dept> result = deptService.getDeptById(id);
        return JSON.toJSONString(result, SerializerFeature.DisableCircularReferenceDetect);
    }

}
