package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.Entinvinfos;
import com.mika.credit.facade.front.cn.dao.EntinvinfosDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by michael on 2017/2/27.
 */
@Repository("entinvinfosDao")
public class EntinvinfosDaoImpl extends BaseDaoImpl<Entinvinfos> implements EntinvinfosDao {


    @Override
    public Entinvinfos findById(Integer id) {
        Entinvinfos result = getById(id);
        return result;
    }

    @Override
    public List<Entinvinfos> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<Entinvinfos> result = listBy(params);
        return result;
    }
}
