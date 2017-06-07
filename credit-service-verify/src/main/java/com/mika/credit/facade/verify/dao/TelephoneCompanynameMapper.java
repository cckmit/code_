package com.mika.credit.facade.verify.dao;

import com.mika.credit.facade.verify.model.TelephoneCompanyname;

import java.util.List;

public interface TelephoneCompanynameMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TelephoneCompanyname record);

    int insertSelective(TelephoneCompanyname record);

    TelephoneCompanyname selectByPrimaryKey(Integer id);

    List<TelephoneCompanyname> selectSeletive(TelephoneCompanyname telephoneCompanyname);

    int updateByPrimaryKeySelective(TelephoneCompanyname record);

    int updateByPrimaryKey(TelephoneCompanyname record);
}