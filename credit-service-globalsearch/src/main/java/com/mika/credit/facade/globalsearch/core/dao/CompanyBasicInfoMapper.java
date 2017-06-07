package com.mika.credit.facade.globalsearch.core.dao;

import com.mika.credit.facade.globalsearch.core.model.CompanyBasicInfo;

public interface CompanyBasicInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CompanyBasicInfo record);

    int insertSelective(CompanyBasicInfo record);

    CompanyBasicInfo selectByPrimaryKey(Long id);

    CompanyBasicInfo selectByCompanyName(String name);

    int updateByPrimaryKeySelective(CompanyBasicInfo record);

    int updateByPrimaryKey(CompanyBasicInfo record);
}