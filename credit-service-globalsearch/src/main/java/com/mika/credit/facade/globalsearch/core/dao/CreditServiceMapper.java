package com.mika.credit.facade.globalsearch.core.dao;

import com.mika.credit.facade.globalsearch.core.model.CreditService;

import java.util.List;

public interface CreditServiceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CreditService record);

    int insertSelective(CreditService record);

    CreditService selectByPrimaryKey(Integer id);

    List<CreditService> selectSelective(CreditService record);

    int selectCountSelective(CreditService record);

    int updateByPrimaryKeySelective(CreditService record);

    int updateByPrimaryKey(CreditService record);
}