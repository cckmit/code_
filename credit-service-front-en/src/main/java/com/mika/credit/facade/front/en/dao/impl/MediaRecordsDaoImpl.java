package com.mika.credit.facade.front.en.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.en.MediaRecords;
import com.mika.credit.facade.front.en.dao.MediaRecordsDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/3/3.
 */
@Repository("mediaRecordsDao")
public class MediaRecordsDaoImpl extends BaseDaoImpl<MediaRecords> implements MediaRecordsDao {
    @Override
    public MediaRecords findById(Integer id) {
        MediaRecords result =  getById(id);
        return null;
    }

    @Override
    public List<MediaRecords> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<MediaRecords> result = listBy(params);
        return result;
    }
}
