package com.mika.credit.facade.verify.dao;

import com.mika.credit.facade.verify.model.MobilephoneName;

import java.util.List;

public interface MobilephoneNameMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MobilephoneName record);

    int insertSelective(MobilephoneName record);

    MobilephoneName selectByPrimaryKey(Integer id);

    List<MobilephoneName> selectSeletive(MobilephoneName mobilephoneName);

    int updateByPrimaryKeySelective(MobilephoneName record);

    int updateByPrimaryKey(MobilephoneName record);
}