package com.mika.credit.facade.record.service;

import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.record.model.Record;
import com.mika.credit.facade.record.model.RecordQuery;

/**
 * Created by Mike on 2017/5/25.
 */
public interface RecordService {
    /**
     *  根据id判断是否新增/修改
     * @param record
     * @return
     */
    ResponseResult<Record> saveRecord(Record record);

    /**
     * 删除
     * @param record
     * @return
     */
    ResponseResult<Record> delRecord(Record record);

    /**
     * 按条件查询/分页
     * @param record
     * @return
     */
    BootGrid<RecordQuery> selSecRecord(RecordQuery record);

    /**
     * 根据Id查
     * @param recordId
     * @return
     */
    ResponseResult<Record> selByIdRecord(Integer recordId);


}
