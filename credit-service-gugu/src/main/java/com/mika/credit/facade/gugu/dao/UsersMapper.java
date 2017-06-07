package com.mika.credit.facade.gugu.dao;

import com.mika.credit.facade.gugu.model.Users;

import java.util.List;

public interface UsersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);

    List<Users> selectByPrimaryKeySelective(Users users);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}