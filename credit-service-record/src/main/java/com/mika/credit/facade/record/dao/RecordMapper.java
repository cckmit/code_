package com.mika.credit.facade.record.dao;

import com.mika.credit.facade.record.model.Record;
import com.mika.credit.facade.record.model.RecordQuery;

import java.util.List;

public interface RecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Record record);

    int insertSelective(Record record);

    Record selectByPrimaryKey(Integer id);

    List<Record> selectByPrimaryKeySelective(Record Record);

    List<RecordQuery> selectByPrimaryKeySelectiveQuery(RecordQuery Record);

    int selectCountSelective(RecordQuery record);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);
}