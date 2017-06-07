package com.mika.credit.facade.globalsearch.core.dao;

import com.mika.credit.facade.globalsearch.core.model.Collection;

import java.util.List;

public interface CollectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Collection record);

    int insertSelective(Collection record);

    Collection selectByPrimaryKey(Integer id);

    Collection getCollectionByCustomerId(Collection collection);

    int updateByPrimaryKeySelective(Collection record);

    int delByCidAndCname(Collection collection);

    List<Collection> selectSelective(Collection collection);

    int selectCountSelective(Collection collection);

    int updateByPrimaryKey(Collection record);
}