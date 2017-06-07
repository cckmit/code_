package com.mika.credit.facade.gugu.dao;

import com.mika.credit.facade.gugu.model.Financing;

import java.util.List;

public interface FinancingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Financing record);

    int insertSelective(Financing record);

    Financing selectByPrimaryKey(Integer id);

    List<Financing> selectSelective(Financing financing);

    int updateByPrimaryKeySelective(Financing record);

    int updateByPrimaryKey(Financing record);
}