package com.mika.credit.facade.gugu.dao;

import com.mika.credit.facade.gugu.model.ShareRecord;

import java.util.List;

public interface ShareRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShareRecord record);

    int insertSelective(ShareRecord record);

    ShareRecord selectByPrimaryKey(Integer id);

    List<ShareRecord> selectByPrimaryKeySelective(ShareRecord shareRecord);

    int updateByPrimaryKeySelective(ShareRecord record);

    int updateByPrimaryKey(ShareRecord record);
}