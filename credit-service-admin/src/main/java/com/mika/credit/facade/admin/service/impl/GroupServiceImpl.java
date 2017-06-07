package com.mika.credit.facade.admin.service.impl;

import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.StringUtil;
import com.mika.credit.common.util.UtilGenerateID;
import com.mika.credit.facade.admin.dao.admin.GroupMapper;
import com.mika.credit.facade.admin.dao.admin.ResourceMapper;
import com.mika.credit.facade.admin.model.Group;
import com.mika.credit.facade.admin.model.Resource;
import com.mika.credit.facade.admin.model.ResourceGroupLink;
import com.mika.credit.facade.admin.model.UserGroupLink;
import com.mika.credit.facade.admin.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2017/4/6.
 */
@Service("groupService")
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public BootGrid<Group> getGroups() {
        BootGrid<Group> result = new BootGrid<Group>();
        result.setRows(groupMapper.queryAll());
        result.setTotal(groupMapper.queryAll().size());
        result.setResult(true);
        return result;
    }

    @Override
    public ResponseResult<Group> removeGroup(String id) {
        ResponseResult<Group> result = new ResponseResult<Group>();
        if (groupMapper.deleteById(id) > 0) {
            Group group = new Group();
            group.setId(id);
            ResourceGroupLink resourceGroupLink = new ResourceGroupLink();
            resourceGroupLink.setGroup(group);
            groupMapper.deleteGroupResource(resourceGroupLink);//删除组和资源之间的关系
            UserGroupLink userGroupLink = new UserGroupLink();
            userGroupLink.setGroup(group);
            groupMapper.deleteGroupUser(userGroupLink);//删除组和用户之间的关系
            result.setCode(true);
            result.setMsg("组删除成功！");
        } else {
            result.setCode(false);
            result.setMsg("组删除失败！");
        }
        return result;
    }

    @Override
    public ResponseResult<Group> addGroupResource(Group group) {
        ResponseResult<Group> result = new ResponseResult<Group>();
        if (StringUtil.isNotNull(group) && StringUtil.isNotNull(group.getCode()) && StringUtil.isNotNull(group.getName())) {
            if(groupMapper.queryList(group).size()>0){
                result.setCode(false);
                result.setMsg("该组已存在，添加失败！");
            }else {
                group.setId(UtilGenerateID.generateID("GRO"));
                group.setEnable(true);
                if (groupMapper.save(group) > 0) {
                    List<Resource> resources = group.getResources();//得到组对象下的资源列表
                    if (StringUtil.isNotNull(resources)) {
                        for (Resource resource : resources) {  //遍历传入的每个资源，并建立资源和组之间的关系
                            ResourceGroupLink resourceGroupLink = new ResourceGroupLink();
                            resourceGroupLink.setGroup(group);
                            resourceGroupLink.setResource(resource);
                            resourceMapper.saveRelativity(resourceGroupLink);
                        }
                    }
                    result.setCode(true);
                    result.setMsg("组添加成功！");
                } else {
                    result.setCode(false);
                    result.setMsg("组添加失败！");
                }
            }
        } else {
            result.setCode(false);
            result.setMsg("组信息为空！");
        }
        return result;
    }

    @Override
    public ResponseResult<Group> updateGroupResource(Group group) {
        ResponseResult<Group> result = new ResponseResult<Group>();
        if (StringUtil.isNotNull(group)) {
            if (groupMapper.updateByIdSelective(group) > 0) {
                List<Resource> resources = group.getResources();//得到组对象下的资源列表
                if (StringUtil.isNotNull(resources)) {
                    ResourceGroupLink resourceGroupLink1 = new ResourceGroupLink();
                    resourceGroupLink1.setGroup(group);
                    groupMapper.deleteGroupResource(resourceGroupLink1);//删除组和资源的所有关系，在进行重新建立
                    for (Resource resource : resources) {  //遍历传入的每个资源，并建立资源和组之间的关系
                        ResourceGroupLink resourceGroupLink = new ResourceGroupLink();
                        resourceGroupLink.setGroup(group);
                        resourceGroupLink.setResource(resource);
                        resourceMapper.saveRelativity(resourceGroupLink);
                    }
                }
                result.setCode(true);
                result.setMsg("组修改成功！");
            } else {
                result.setCode(false);
                result.setMsg("组修改失败！");
            }
        } else {
            result.setCode(false);
            result.setMsg("组信息为空！");
        }
        return result;
    }

    @Override
    public ResponseResult<Group> margeGroup(Group group) {
        ResponseResult<Group> result = new ResponseResult<Group>();
        if(StringUtil.isNotNull(group)) {
            if (StringUtil.isNotNull(group.getId())) {
                result=updateGroupResource(group);  //调用当前更新方法
            } else {
                result=addGroupResource(group);
            }
        }
        return result;
    }

    @Override
    public ResponseResult<Group> selectGroupResource(Group group) {
        ResponseResult<Group> result = new ResponseResult<Group>();
        Group groupResult=groupMapper.selectGroupResource(group);//得到两者之间的对象
        if(group != null){
            result.setCode(true);
            result.setContent(groupResult);
            result.setMsg("查找成功！");
        }
        else{
            result.setCode(false);
            result.setMsg("查找失败！");
        }
        return result;
    }
}
