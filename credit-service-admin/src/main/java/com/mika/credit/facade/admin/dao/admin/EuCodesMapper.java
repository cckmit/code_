package com.mika.credit.facade.admin.dao.admin;

import com.mika.credit.facade.admin.model.EuCodes;

public interface EuCodesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EuCodes record);

    int insertSelective(EuCodes record);

    EuCodes selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EuCodes record);

    int updateByPrimaryKey(EuCodes record);
}