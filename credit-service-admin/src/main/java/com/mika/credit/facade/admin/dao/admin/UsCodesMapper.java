package com.mika.credit.facade.admin.dao.admin;

import com.mika.credit.facade.admin.model.UsCodes;

public interface UsCodesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UsCodes record);

    int insertSelective(UsCodes record);

    UsCodes selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UsCodes record);

    int updateByPrimaryKey(UsCodes record);
}