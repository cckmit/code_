package com.mika.credit.facade.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.StringUtil;
import com.mika.credit.common.util.UtilGenerateID;
import com.mika.credit.facade.admin.dao.admin.GroupMapper;
import com.mika.credit.facade.admin.dao.admin.ResourceMapper;
import com.mika.credit.facade.admin.model.Resource;
import com.mika.credit.facade.admin.model.ResourceGroupLink;
import com.mika.credit.facade.admin.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by credit on 2017/3/15.
 */
@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private GroupMapper groupMapper;

    @Override
    public BootGrid<Resource> getResources(BootGrid<Resource> grid, Resource resource) {
        PageHelper.startPage(grid.getCurrent(), grid.getRowCount());
        grid.setRows(resourceMapper.querySelective(resource));
        grid.setTotal(resourceMapper.querySelective(resource).size());
        grid.setResult(true);
        return grid;
    }

    @Override
    public ResponseResult<Resource> removeResourceGroup(String id) {
        ResponseResult<Resource> result = new ResponseResult<Resource>();
        if (resourceMapper.deleteById(id) > 0) {
            Resource resource = new Resource();
            resource.setId(id);
            ResourceGroupLink resourceGroupLink = new ResourceGroupLink();
            resourceGroupLink.setResource(resource);
            groupMapper.deleteGroupResource(resourceGroupLink);   //删除资源和组之间所有的关系
            result.setCode(true);
            result.setMsg("资源删除成功！");
        } else {
            result.setCode(false);
            result.setMsg("资源删除失败！");
        }
        return result;
    }

    @Override
    public ResponseResult<Resource> updateResource(Resource resource) {
        ResponseResult<Resource> result = new ResponseResult<Resource>();
        if (StringUtil.isNotNull(resource)) {
            if (resourceMapper.updateByIdSelective(resource) > 0) {
                result.setCode(true);
                result.setMsg("资源更新成功！");
            } else {
                result.setCode(false);
                result.setMsg("资源更新失败！");
            }
        } else {
            result.setCode(false);
            result.setMsg("资源不能为空！");
        }
        return result;
    }

    @Override
    public ResponseResult<Resource> addResource(Resource resource) {
        ResponseResult<Resource> result = new ResponseResult<Resource>();
        if (StringUtil.isNotNull(resource)) {
            if (resourceMapper.querySelective(resource).size() > 0) {
                result.setCode(false);
                result.setMsg("该资源已存在，添加失败！");
            } else {
                resource.setId(UtilGenerateID.generateID("RES"));
                resource.setSYS(false);
                resource.setEnable(true);
                if (resourceMapper.save(resource) > 0) {
                    result.setCode(true);
                    result.setMsg("资源添加成功！");
                } else {
                    result.setCode(false);
                    result.setMsg("资源添加失败！");
                }
            }
        } else {
            result.setCode(false);
            result.setMsg("资源不能为空！");
        }
        return result;
    }

    @Override
    public ResponseResult<Resource> margeResource(Resource resource) {
        ResponseResult<Resource> result = new ResponseResult<Resource>();
        if (resource != null) {
            if (resource.getId() != null && !"".equals(resource.getId())) {
                result = updateResource(resource);
            } else {
                result = addResource(resource);
            }
        }
        return result;
    }

    @Override
    public ResponseResult<Resource> getResourceById(String id) {
        ResponseResult<Resource> result = new ResponseResult<Resource>();
        Resource resource = resourceMapper.queryById(id);
        if (resource != null) {
            result.setCode(true);
            result.setContent(resource);
            result.setMsg("查找成功！");
        } else {
            result.setCode(false);
            result.setMsg("查找失败！");
        }
        return result;
    }

    @Override
    public int selectCountByCategory(String id) {
        return resourceMapper.selectCountByCategory(id);
    }
}
