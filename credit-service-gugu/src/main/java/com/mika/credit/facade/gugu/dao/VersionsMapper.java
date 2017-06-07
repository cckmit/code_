package com.mika.credit.facade.gugu.dao;

import com.mika.credit.facade.gugu.model.Versions;

import java.util.List;

public interface VersionsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Versions record);

    int insertSelective(Versions record);

    Versions selectByPrimaryKey(Integer id);

    List<Versions> selectByPrimaryKeySelective(Versions versions);

    int updateByPrimaryKeySelective(Versions record);

    int updateByPrimaryKey(Versions record);
}