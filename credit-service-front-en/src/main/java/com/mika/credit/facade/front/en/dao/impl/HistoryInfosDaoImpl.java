package com.mika.credit.facade.front.en.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.en.HistoryInfos;
import com.mika.credit.facade.front.en.dao.HistoryInfosDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/3/3.
 */
@Repository("historyInfosDao")
public class HistoryInfosDaoImpl extends BaseDaoImpl<HistoryInfos> implements HistoryInfosDao {
    @Override
    public HistoryInfos findById(Integer id) {
        HistoryInfos result =  getById(id);
        return null;
    }

    @Override
    public List<HistoryInfos> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<HistoryInfos> result = listBy(params);
        return result;
    }
}
