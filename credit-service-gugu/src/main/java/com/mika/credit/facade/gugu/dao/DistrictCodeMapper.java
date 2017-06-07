package com.mika.credit.facade.gugu.dao;

import com.mika.credit.facade.gugu.model.DistrictCode;

import java.util.List;

public interface DistrictCodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DistrictCode record);

    int insertSelective(DistrictCode record);

    DistrictCode selectByPrimaryKey(Integer id);

    List<DistrictCode> selectByPrimaryKeySelective(DistrictCode districtCode);

    int updateByPrimaryKeySelective(DistrictCode record);

    int updateByPrimaryKey(DistrictCode record);
}