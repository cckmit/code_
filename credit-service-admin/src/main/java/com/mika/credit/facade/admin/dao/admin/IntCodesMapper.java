package com.mika.credit.facade.admin.dao.admin;

import com.mika.credit.facade.admin.model.IntCodes;

public interface IntCodesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IntCodes record);

    int insertSelective(IntCodes record);

    IntCodes selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IntCodes record);

    int updateByPrimaryKey(IntCodes record);
}