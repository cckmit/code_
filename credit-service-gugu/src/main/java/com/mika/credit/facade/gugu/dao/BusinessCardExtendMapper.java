package com.mika.credit.facade.gugu.dao;

import com.mika.credit.facade.gugu.model.BusinessCardExtend;

import java.util.List;

public interface BusinessCardExtendMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteSelective(BusinessCardExtend businessCardExtend);

    int insert(BusinessCardExtend record);

    int insertSelective(BusinessCardExtend record);

    BusinessCardExtend selectByPrimaryKey(Integer id);

    List<BusinessCardExtend> selectByPrimaryKeySelective(BusinessCardExtend businessCardExtend);

    int updateByPrimaryKeySelective(BusinessCardExtend record);

    int updateByPrimaryKey(BusinessCardExtend record);
}