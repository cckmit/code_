package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.Executive;
import com.mika.credit.facade.front.cn.dao.ExecutiveDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by michael on 2017/2/27.
 */
@Repository("executiveDao")
public class ExecutiveDaoImpl extends BaseDaoImpl<Executive> implements ExecutiveDao {
    @Override
    public Executive findById(Integer id) {
        Executive result = getById(id);
        return result;
    }

    @Override
    public List<Executive> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<Executive> result = listBy(params);
        return result;
    }
}
