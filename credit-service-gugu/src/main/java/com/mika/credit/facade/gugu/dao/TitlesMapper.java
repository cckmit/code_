package com.mika.credit.facade.gugu.dao;

import com.mika.credit.facade.gugu.model.Titles;

import java.util.List;

public interface TitlesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Titles record);

    int insertSelective(Titles record);

    Titles selectByPrimaryKey(Integer id);

    List<Titles> selectByPrimaryKeySelective(Titles titles);

    int updateByPrimaryKeySelective(Titles record);

    int updateByPrimaryKey(Titles record);
}