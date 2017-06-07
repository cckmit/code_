package com.mika.credit.facade.gugu.dao;

import com.mika.credit.facade.gugu.model.ScanningCardExtend;

import java.util.List;

public interface ScanningCardExtendMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteSelective(ScanningCardExtend scanningCardExtend);

    int insert(ScanningCardExtend record);

    int insertSelective(ScanningCardExtend record);

    ScanningCardExtend selectByPrimaryKey(Integer id);

    List<ScanningCardExtend> selectByPrimaryKeySelective(ScanningCardExtend scanningCardExtend);

    int updateByPrimaryKeySelective(ScanningCardExtend record);

    int updateByPrimaryKey(ScanningCardExtend record);
}