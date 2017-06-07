package com.mika.credit.facade.gugu.dao;

import com.mika.credit.facade.gugu.model.VerificationResult;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VerificationResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VerificationResult record);

    int insertSelective(VerificationResult record);

    VerificationResult selectByPrimaryKey(Integer id);

    VerificationResult selectByPrimaryExample(Integer cardId,Integer userId);

    List<VerificationResult> selectByPrimaryKeySelective(VerificationResult verificationResult);

    int updateByPrimaryKeySelective(VerificationResult record);

    int updateByPrimaryKey(VerificationResult record);
}