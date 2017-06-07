package com.mika.credit.facade.admin.dao.admin;


import com.mika.credit.facade.admin.model.Group;
import com.mika.credit.facade.admin.model.ResourceGroupLink;
import com.mika.credit.facade.admin.model.UserGroupLink;

import java.util.List;

/**
 * Created by credit on 2017/3/16.
 */
public interface GroupMapper extends BaseMapper<Group> {
    List<Group> queryList(Group group);    //条件查询
    Group queryById(String id);       //通过id查询
    List<Group> queryAll(Group group);    //查询所有
    int save(Group group);
    int update(Group group);
    int updateByIdSelective(Group group);
    int deleteById(String id);
    int delete(Group group);

    /**
     * 根据Group表中的id或name查询组信息和组内用户信息
     * @param group Group条件
     * @return 查询结果
     */
    Group selectGroupUser(Group group);

    /**
     * 删除组与组内成员之间的对应关系
     * @param userGroupLink UserGroupLink条件
     * @return 删除结果
     */
    int deleteGroupUser(UserGroupLink userGroupLink);

    /**
     * 根据Group表中的id或name查询组信息和组内资源信息
     * @param group Group条件
     * @return 查询结果
     */
    Group selectGroupResource(Group group);

    /**
     * 删除组与组内资源之间的对应关系
     * @param resourceGroupLink ResourceGroupLink条件
     * @return 删除结果
     */
    int deleteGroupResource(ResourceGroupLink resourceGroupLink);
}
