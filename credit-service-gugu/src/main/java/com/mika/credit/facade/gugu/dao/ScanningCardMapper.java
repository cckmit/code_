package com.mika.credit.facade.gugu.dao;

import com.mika.credit.facade.gugu.model.ScanningCard;

import java.util.List;

public interface ScanningCardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ScanningCard record);

    int insertSelective(ScanningCard record);

    ScanningCard selectByPrimaryKey(Integer id);

    List<ScanningCard> selectByPrimaryKeySelective(ScanningCard scanningCard);

    int updateByPrimaryKeySelective(ScanningCard record);

    int updateByPrimaryKey(ScanningCard record);
}