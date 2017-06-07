package com.mika.credit.facade.gugu.dao;

import com.mika.credit.facade.gugu.model.CityCode;

import java.util.List;

public interface CityCodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CityCode record);

    int insertSelective(CityCode record);

    CityCode selectByPrimaryKey(Integer id);

    List<CityCode> selectByPrimaryKeySelective(CityCode cityCode);


    int updateByPrimaryKeySelective(CityCode record);

    int updateByPrimaryKey(CityCode record);
}