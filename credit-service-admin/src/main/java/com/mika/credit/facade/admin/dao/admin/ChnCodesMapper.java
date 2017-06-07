package com.mika.credit.facade.admin.dao.admin;


import com.mika.credit.facade.admin.model.ChnCodes;

import java.util.List;

/**
 * Created by michael on 2017/5/15.
 */
public interface ChnCodesMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(ChnCodes record);

    int insertSelective(ChnCodes record);

    List<ChnCodes> selectByPrimaryKey(ChnCodes record);

    int updateByPrimaryKeySelective(ChnCodes record);

    int updateByPrimaryKeyWithBLOBs(ChnCodes record);

    int updateByPrimaryKey(ChnCodes record);

}