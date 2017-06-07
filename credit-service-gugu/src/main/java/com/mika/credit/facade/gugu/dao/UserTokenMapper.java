package com.mika.credit.facade.gugu.dao;

import com.mika.credit.facade.gugu.model.UserToken;

import java.util.List;

public interface UserTokenMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserToken record);

    int insertSelective(UserToken record);

    UserToken selectByPrimaryKey(Integer id);

    List<UserToken> selectByPrimaryKeySelective(UserToken userToken);

    int updateByPrimaryKeySelective(UserToken record);

    int updateByPrimaryKey(UserToken record);
}