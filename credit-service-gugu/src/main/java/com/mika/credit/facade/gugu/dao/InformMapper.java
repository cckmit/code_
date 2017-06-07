package com.mika.credit.facade.gugu.dao;

import com.mika.credit.facade.gugu.model.Inform;

import java.util.List;

public interface InformMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Inform record);

    int insertSelective(Inform record);

    Inform selectByPrimaryKey(Integer id);

    List<Inform> selectByPrimaryKeySelective(Inform inform);

    int updateByPrimaryKeySelective(Inform record);

    int updateByPrimaryKey(Inform record);
}