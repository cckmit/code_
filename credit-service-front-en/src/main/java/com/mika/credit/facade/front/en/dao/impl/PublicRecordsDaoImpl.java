package com.mika.credit.facade.front.en.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.en.PublicRecords;
import com.mika.credit.facade.front.en.dao.PublicRecordsDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/3/3.
 */
@Repository("publicRecordsDao")
public class PublicRecordsDaoImpl extends BaseDaoImpl<PublicRecords> implements PublicRecordsDao {
    @Override
    public PublicRecords findById(Integer id) {
        PublicRecords result = getById(id);
        return null;
    }

    @Override
    public List<PublicRecords> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<PublicRecords> result = listBy(params);
        return result;
    }
}
