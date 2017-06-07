package com.mika.credit.facade.admin.dao.admin;

import com.mika.credit.facade.admin.model.HelpCate;

import java.util.List;

public interface HelpCateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HelpCate record);

    int insertSelective(HelpCate record);

    HelpCate selectByPrimaryKey(Integer id);

    List<HelpCate> selectSelective(HelpCate helpCate);

    int updateByPrimaryKeySelective(HelpCate record);

    int updateByPrimaryKey(HelpCate record);
}