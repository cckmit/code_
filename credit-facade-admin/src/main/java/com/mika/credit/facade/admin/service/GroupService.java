package com.mika.credit.facade.admin.service;

import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.admin.model.Group;

/**
 * Created by dell on 2017/4/6.
 */
public interface GroupService {
    BootGrid<Group> getGroups();   //查询所有组信息
    ResponseResult<Group> removeGroup(String id);     //根据id删除组；并解除组和资源，组和用户的关系
    ResponseResult<Group> addGroupResource(Group group);      //添加组
    ResponseResult<Group> updateGroupResource(Group group);      //更新组，并更新组和资源的关系
    ResponseResult<Group> margeGroup(Group group);    //合并组（有就修改，无就添加）
    ResponseResult<Group> selectGroupResource(Group group);        //通过id查找Group，包含Resource列表
}
