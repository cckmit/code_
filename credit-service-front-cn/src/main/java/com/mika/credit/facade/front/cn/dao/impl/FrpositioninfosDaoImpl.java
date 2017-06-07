package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.Frpositioninfos;
import com.mika.credit.facade.front.cn.dao.FrpositioninfosDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by michael on 2017/2/27.
 */
@Repository("frpositioninfosDao")
public class FrpositioninfosDaoImpl extends BaseDaoImpl<Frpositioninfos> implements FrpositioninfosDao {
    @Override
    public Frpositioninfos findById(Integer id) {
        Frpositioninfos result = getById(id);
        return result;
    }

    @Override
    public List<Frpositioninfos> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<Frpositioninfos> result = listBy(params);
        return result;
    }
}
