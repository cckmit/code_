package com.mika.credit.facade.admin.dao.admin;


import com.mika.credit.facade.admin.model.Resource;
import com.mika.credit.facade.admin.model.ResourceGroupLink;

import java.util.List;

/**
 * Created by credit on 2017/3/15.
 */
public interface ResourceMapper {
    Resource queryById(String id);
    List<Resource> queryAll();
    List<Resource> querySelective(Resource resource);
    int save(Resource resource);
    int update(Resource resource);
    int updateByIdSelective(Resource resource);
    int deleteById(String id);
    int delete(Resource resource);

    /**
     * 根据user表中的id查询用户和组信息
     */
    Resource selectResourceGroup(String id);

    /**
     * 保存用户和组之间的关系信息
     */
    int saveRelativity(ResourceGroupLink resourceGroupLink);

    int selectCountByCategory(String id);
}
