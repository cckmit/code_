package com.mika.credit.facade.admin.service;

import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.admin.model.Resource;

/**
 * Created by dell on 2017/4/6.
 */
public interface ResourceService {
    BootGrid<Resource> getResources(BootGrid<Resource> grid, Resource resource);   //根据条件查找资源
    ResponseResult<Resource> removeResourceGroup(String id);     //根据id删除资源
    ResponseResult<Resource> addResource(Resource resource);      //添加资源
    ResponseResult<Resource> updateResource(Resource resource);      //更新资源
    ResponseResult<Resource> margeResource(Resource resource);    //合并资源（有就修改，无就添加）
    ResponseResult<Resource> getResourceById(String id);        //通过id查找资源
    int selectCountByCategory(String id);    //通过类别id查找对应资源的总数量
}
