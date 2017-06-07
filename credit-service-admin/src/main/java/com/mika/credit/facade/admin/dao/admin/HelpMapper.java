package com.mika.credit.facade.admin.dao.admin;

import com.mika.credit.facade.admin.model.Help;

import java.util.List;

public interface HelpMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Help record);

    int insertSelective(Help record);

    Help selectByPrimaryKey(Integer id);

    List<Help> selectSelective(Help help);

    int updateByPrimaryKeySelective(Help record);

    int updateByPrimaryKeyWithBLOBs(Help record);

    int updateByPrimaryKey(Help record);

    int selectCountByCate(Integer id);
}