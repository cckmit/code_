package com.mika.credit.facade.globalsearch.admin.dao;

import com.mika.credit.facade.globalsearch.admin.model.GroupHasMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupHasMenuMapper {
    List<GroupHasMenu> selectByGroupId(String groupId);

    int deleteByPrimaryKey(@Param("groupId") String groupId, @Param("menuId") String menuId);

    int deleteByGroupId(String groupId);

    int insert(GroupHasMenu record);

    int insertSelective(GroupHasMenu record);

    GroupHasMenu selectByPrimaryKey(@Param("groupId") String groupId, @Param("menuId") String menuId);

    int updateByPrimaryKeySelective(GroupHasMenu record);

    int updateByPrimaryKey(GroupHasMenu record);
}