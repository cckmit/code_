package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.Ajlc;
import com.mika.credit.facade.front.cn.dao.AjlcDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by michael on 2017/2/27.
 */
@Repository("ajlcDao")
public class AjlcDaoImpl extends BaseDaoImpl<Ajlc> implements AjlcDao {
    @Override
    public Ajlc findById(Integer id) {
        Ajlc result = getById(id);
        return result;
    }

    @Override
    public List<Ajlc> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<Ajlc> result = listBy(params);
        return result;
    }
}
