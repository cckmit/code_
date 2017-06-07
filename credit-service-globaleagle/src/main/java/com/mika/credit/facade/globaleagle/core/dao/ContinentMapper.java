package com.mika.credit.facade.globaleagle.core.dao;

import com.mika.credit.facade.globaleagle.core.model.Continent;

import java.util.List;

public interface ContinentMapper {
//    @Cacheable(value = "annotationCache")
    List<Continent> selectAll();

    int deleteByPrimaryKey(Integer id);

    int insert(Continent record);

    int insertSelective(Continent record);

    Continent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Continent record);

    int updateByPrimaryKey(Continent record);
}