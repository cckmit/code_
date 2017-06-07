package com.mika.credit.facade.gugu.dao;

import com.mika.credit.facade.gugu.model.BusinessCard;

import java.util.List;

public interface BusinessCardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BusinessCard record);

    int insertSelective(BusinessCard record);

    BusinessCard selectByPrimaryKey(Integer id);

    List<BusinessCard> selectByPrimaryKeySelective(BusinessCard businessCard);

    int updateByPrimaryKeySelective(BusinessCard record);

    int updateByPrimaryKey(BusinessCard record);
}