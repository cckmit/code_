package com.mika.credit.facade.gugu.dao;

import com.mika.credit.facade.gugu.model.Publicize;

import java.util.List;

public interface PublicizeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Publicize record);

    int insertSelective(Publicize record);

    Publicize selectByPrimaryKey(Integer id);

    List<Publicize> selectByPrimaryKeySelective(Publicize publicize);

    int updateByPrimaryKeySelective(Publicize record);

    int updateByPrimaryKey(Publicize record);
}