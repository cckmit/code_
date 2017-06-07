package com.mika.credit.facade.globalsearch.core.dao;

import com.mika.credit.facade.globalsearch.core.model.CompanyInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CompanyInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CompanyInfo record);

    int insertSelective(CompanyInfo record);

    CompanyInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CompanyInfo record);

    int updateByPrimaryKey(CompanyInfo record);

    List<CompanyInfo> selectSelective(CompanyInfo record);
}