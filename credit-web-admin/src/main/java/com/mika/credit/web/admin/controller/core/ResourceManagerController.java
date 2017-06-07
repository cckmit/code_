package com.mika.credit.web.admin.controller.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.admin.model.Category;
import com.mika.credit.facade.admin.model.Resource;
import com.mika.credit.facade.admin.model.System;
import com.mika.credit.facade.admin.service.CategoryService;
import com.mika.credit.facade.admin.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by dell on 2017/4/7.
 */
@Controller
public class ResourceManagerController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ResourceService resourceService;

    @RequestMapping(value = "/core/systemList",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String systemList() {
        BootGrid<System> grid = categoryService.getSystems();
        return JSON.toJSONString(grid);
    }

    @RequestMapping(value = "/core/systemSave",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String systemSave(BootGrid<System> bootGrid, System system) {
        if(categoryService.margeSystem(system).getCode()){
            bootGrid=categoryService.getSystems();
            bootGrid.setResult(true);
        }else{
            bootGrid.setResult(false);
        }
        return JSON.toJSONString(bootGrid);
    }

    @RequestMapping(value = "/core/systemDel",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String systemDel(BootGrid<System> grid, String id) {
        //校验是否有下属条目，如果有，不允许删除
        int count = categoryService.selectCountBySystem(id);
        if(count > 0){
            grid.setResult(false);
            grid.setResultDes("该系统下还包含" + count + "个类别，不允许删除！");
            return JSON.toJSONString(grid);
        }
        if(categoryService.removeSystems(id).getCode()){
            grid = categoryService.getSystems();
            grid.setResult(true);
        }else{
            grid.setResult(false);
            grid.setResultDes("删除失败！");
        }
        return JSON.toJSONString(grid);
    }

    @RequestMapping(value = "/core/categoryList",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String categoryList(Category category,BootGrid<Category> grid){
        BootGrid<Category> result= categoryService.getCategorys(grid,category);
        return JSON.toJSONString(result);
    }

    @RequestMapping(value = "/core/categorySave",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String categorySave(Category category) {
        ResponseResult<Category> result=categoryService.margeCategory(category);
        return JSON.toJSONString(result);
    }

    @RequestMapping(value = "/core/categoryDel",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String categoryDel(BootGrid<Category> grid, Category category) {
        //校验是否有下属条目，如果有，不允许删除
        String id=category.getId();
        int count = resourceService.selectCountByCategory(id);
        if(count > 0){
            grid.setResult(false);
            grid.setResultDes("该类别下还包含" + count + "个资源，不允许删除！");
            return JSON.toJSONString(grid);
        }
        BootGrid<Category> bootGrid=new BootGrid<Category>();  //删除成功后重新查询当前系统下的所有类别，并返回显示
        if(categoryService.removeCategory(id).getCode()){
            Category category1=new Category();
            System system=new System();
            system.setId(category.getSystem().getId());  //封装条件id
            category1.setSystem(system);
            bootGrid = categoryService.getCategorys(grid,category);
            bootGrid.setResult(true);
        }else{
            bootGrid.setResult(false);
        }
        return JSON.toJSONString(bootGrid);

    }

    @RequestMapping(value = "/core/getCategory",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String getCategory(String id) {
        ResponseResult<Category> result = categoryService.getCategoryById(id);
        return JSON.toJSONString(result);
    }


    @RequestMapping(value = "/core/resourceList",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String resourceList(Resource resource, BootGrid<Resource> grid){
        BootGrid<Resource> result= resourceService.getResources(grid,resource);
        return JSON.toJSONString(result);
    }

    @RequestMapping(value = "/core/resourceSave",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String resourceSave(Resource resource) {
        ResponseResult<Resource> result=resourceService.margeResource(resource);
        return JSON.toJSONString(result);
    }

    @RequestMapping(value = "/core/resourceDel",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String resourceDel(String id) {
        ResponseResult<Resource> result=resourceService.removeResourceGroup(id);
        return JSON.toJSONString(result);
    }

    @RequestMapping(value = "/core/getResource",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String getResource(String id) {
        ResponseResult<Resource> result = resourceService.getResourceById(id);
        return JSON.toJSONString(result, SerializerFeature.DisableCircularReferenceDetect);
    }
}
