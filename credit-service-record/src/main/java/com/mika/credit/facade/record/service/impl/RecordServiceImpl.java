package com.mika.credit.facade.record.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.StringUtil;
import com.mika.credit.facade.record.dao.RecordMapper;
import com.mika.credit.facade.record.model.Record;
import com.mika.credit.facade.record.model.RecordQuery;
import com.mika.credit.facade.record.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mike on 2017/5/25.
 */
@Service("recordService")
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordMapper recordMapper;

    @Override
    public ResponseResult<Record> saveRecord(Record record) {
        ResponseResult<Record> recordResponseResult = new ResponseResult<>();
        if (StringUtil.isNotNull(record) && StringUtil.isNotNull(record.getNameCn())) {
            if (record.getId() == null || record.getId() == 0) {
                record.setId(null);
                recordMapper.insertSelective(record);
                recordResponseResult.setCode(true);
                recordResponseResult.setContent(record);
                recordResponseResult.setMsg("新增记录成功！");

            } else {
                recordMapper.updateByPrimaryKeySelective(record);
                recordResponseResult.setCode(true);
                recordResponseResult.setContent(record);
                recordResponseResult.setMsg("更新记录成功！");

            }
        } else {
            recordResponseResult.setCode(false);
            recordResponseResult.setMsg("记录不能为空或者公司名不能为空！");
        }
        return recordResponseResult;
    }

    @Override
    public ResponseResult<Record> delRecord(Record record) {
        ResponseResult<Record> recordResponseResult = new ResponseResult<>();
        if (StringUtil.isNotNull(record)&&StringUtil.isNotNull(record.getId())){
            recordMapper.deleteByPrimaryKey(record.getId());
            recordResponseResult.setCode(true);
            recordResponseResult.setMsg("删除成功！");
        }else {
            recordResponseResult.setCode(false);
            recordResponseResult.setMsg("删除失败，记录或记录Id不能为空！");
        }
        return recordResponseResult;
    }

    @Override
    public BootGrid<RecordQuery> selSecRecord(RecordQuery recordQuery) {
        BootGrid<RecordQuery> result = new BootGrid<>();
        Page<RecordQuery> page = PageHelper.startPage(result.getCurrent(), result.getRowCount());
        result.setTotal(recordMapper.selectCountSelective(recordQuery));
        result.setRows(recordMapper.selectByPrimaryKeySelectiveQuery(recordQuery));
        result.setResult(true);
        return result;
    }

    @Override
    public ResponseResult<Record> selByIdRecord(Integer recordId) {
        ResponseResult<Record> recordResponseResult = new ResponseResult<>();
        Record record = recordMapper.selectByPrimaryKey(recordId);
        if (StringUtil.isNotNull(record)){
            recordResponseResult.setCode(true);
            recordResponseResult.setContent(record);
        }else {
            recordResponseResult.setCode(false);
            recordResponseResult.setMsg("未查询到该数据！");
        }
        return recordResponseResult;
    }
}
