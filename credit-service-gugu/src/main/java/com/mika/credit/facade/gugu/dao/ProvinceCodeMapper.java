package com.mika.credit.facade.gugu.dao;

import com.mika.credit.facade.gugu.model.ProvinceCode;

import java.util.List;

public interface ProvinceCodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProvinceCode record);

    int insertSelective(ProvinceCode record);

    ProvinceCode selectByPrimaryKey(Integer id);

    List<ProvinceCode> selectByPrimaryKeySelective(ProvinceCode provinceCode);

    int updateByPrimaryKeySelective(ProvinceCode record);

    int updateByPrimaryKey(ProvinceCode record);
}