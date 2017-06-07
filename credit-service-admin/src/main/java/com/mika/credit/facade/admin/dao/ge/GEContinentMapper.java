package com.mika.credit.facade.admin.dao.ge;


import com.mika.credit.facade.admin.model.Continent;

import java.util.List;

public interface GEContinentMapper {
//    @Cacheable(value = "annotationCache")
    List<Continent> selectAll();

    int deleteByPrimaryKey(Integer id);

    int insert(Continent record);

    int insertSelective(Continent record);

    Continent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Continent record);

    int updateByPrimaryKey(Continent record);
}