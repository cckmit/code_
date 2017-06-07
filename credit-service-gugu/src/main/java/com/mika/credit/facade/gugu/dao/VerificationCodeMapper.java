package com.mika.credit.facade.gugu.dao;

import com.mika.credit.facade.gugu.model.VerificationCode;

import java.util.List;

public interface VerificationCodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VerificationCode record);

    int insertSelective(VerificationCode record);

    VerificationCode selectByPrimaryKey(Integer id);

    List<VerificationCode> selectByPrimaryKeySelective(VerificationCode verificationCode);

    int updateByPrimaryKeySelective(VerificationCode record);

    int updateByPrimaryKey(VerificationCode record);
}