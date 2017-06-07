package com.mika.credit.facade.gugu.dao;

import com.mika.credit.facade.gugu.model.IconRecord;

import java.util.List;

public interface IconRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IconRecord record);

    int insertSelective(IconRecord record);

    IconRecord selectByPrimaryKey(Integer id);

    List<IconRecord> selectByPrimaryKeySelective(IconRecord iconRecord);

    int updateByPrimaryKeySelective(IconRecord record);

    int updateByPrimaryKey(IconRecord record);
}