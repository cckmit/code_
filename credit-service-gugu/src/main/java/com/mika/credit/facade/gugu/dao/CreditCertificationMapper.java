package com.mika.credit.facade.gugu.dao;

import com.mika.credit.facade.gugu.model.CreditCertification;

import java.util.List;

public interface CreditCertificationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CreditCertification record);

    int insertSelective(CreditCertification record);

    CreditCertification selectByPrimaryKey(Integer id);

    List<CreditCertification> selectByPrimaryKeySelective(CreditCertification creditCertification);

    int updateByPrimaryKeySelective(CreditCertification record);

    int updateByPrimaryKey(CreditCertification record);

    CreditCertification selectByPrimaryId(Integer orderId);

    List<CreditCertification> selectByPrimaryCardId(Integer cardId);
}