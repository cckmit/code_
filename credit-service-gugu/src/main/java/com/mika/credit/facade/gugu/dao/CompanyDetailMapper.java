package com.mika.credit.facade.gugu.dao;

import com.mika.credit.facade.gugu.model.CompanyDetail;

import java.util.List;

public interface CompanyDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CompanyDetail record);

    int insertSelective(CompanyDetail record);

    CompanyDetail selectByPrimaryKey(Integer id);

    List<CompanyDetail> selectByPrimaryKeySelective(CompanyDetail companyDetail);

    int updateByPrimaryKeySelective(CompanyDetail record);

    int updateByPrimaryKey(CompanyDetail record);
}