package com.mika.credit.facade.gugu.dao;

import com.mika.credit.facade.gugu.model.CountryCode;

import java.util.List;

public interface CountryCodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CountryCode record);

    int insertSelective(CountryCode record);

    CountryCode selectByPrimaryKey(Integer id);

    List<CountryCode> selectByPrimaryKeySelective(CountryCode countryCode);


    int updateByPrimaryKeySelective(CountryCode record);

    int updateByPrimaryKey(CountryCode record);
}