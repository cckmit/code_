package com.mika.credit.facade.gugu.dao;

import com.mika.credit.facade.gugu.model.PublicizeFlag;

import java.util.List;

public interface PublicizeFlagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PublicizeFlag record);

    int insertSelective(PublicizeFlag record);

    PublicizeFlag selectByPrimaryKey(Integer id);

    List<PublicizeFlag> selectByPrimaryKeySelective(PublicizeFlag publicizeFlag);

    int updateByPrimaryKeySelective(PublicizeFlag record);

    int updateByPrimaryKey(PublicizeFlag record);
}