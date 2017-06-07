package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.facade.front.cn.dao.FullReportDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dell on 2017/2/27.
 */
@Repository("fullReportDao")
public class FullReportDaoImpl extends BaseDaoImpl<FullReport> implements FullReportDao{

    @Override
    public FullReport findById(Integer id) {
        FullReport result = getById(id);
        return result;
    }

    @Override
    public FullReport findByName(String name) {
        Map<String,Object> params = new HashMap<>();
        params.put("nameCN",name);
        FullReport result = getBy(params);
        return result;
    }
}
