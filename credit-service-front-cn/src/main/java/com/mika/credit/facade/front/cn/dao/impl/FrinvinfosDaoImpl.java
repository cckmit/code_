package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.Frinvinfos;
import com.mika.credit.facade.front.cn.dao.FrinvinfosDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by michael on 2017/2/27.
 */
@Repository("frinvinfosDao")
public class FrinvinfosDaoImpl extends BaseDaoImpl<Frinvinfos> implements FrinvinfosDao {
    @Override
    public Frinvinfos findById(Integer id) {
        Frinvinfos result = getById(id);
        return result;
    }

    @Override
    public List<Frinvinfos> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<Frinvinfos> result = listBy(params);
        return result;
    }
}
