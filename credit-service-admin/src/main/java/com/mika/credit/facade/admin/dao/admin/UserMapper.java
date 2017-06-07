package com.mika.credit.facade.admin.dao.admin;

import com.mika.credit.facade.admin.model.Resource;
import com.mika.credit.facade.admin.model.User;
import com.mika.credit.facade.admin.model.UserGroupLink;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by credit on 2017/3/17.
 */
public interface UserMapper {
    List<User> queryList(User user);
    User findByUsername(@Param("username") String username);
    User queryById(String id);
    List<User> queryAll();
    int save(User user);
    int update(User user);
    int deleteById(String id);
    int delete(User user);
    int updateByIdSelective(User user);    //判断是否为空才更新

    /**
     * 根据user表中的id查询用户和组信息
     */
    User selectUserGroup(String id);

    /**
     * 保存用户和组之间的关系信息
     */
    int saveRelativity(UserGroupLink userGroupLink);

    int selectCountByCorp(String id);    //根据Corp的id查找对应所有员工的总数量

    int selectCountByDept(String id);    //根据Dept的id查找对应所有员工的总数量

    /**
     * 根据user表中的name查询用户和组信息
     */
    User selectUserGroupByName(String name);

    /**
     * 根据user表中的username查询所拥有的权限信息
     */
    List<Resource> selectUserSourceByName(String name);

}
