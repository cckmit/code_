package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.Bgt;
import com.mika.credit.facade.front.cn.dao.BgtDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by michael on 2017/2/27.
 */
@Repository("bgtDao")
public class BgtDaoImpl extends BaseDaoImpl<Bgt> implements BgtDao {


    @Override
    public Bgt findById(Integer id) {
        Bgt result = getById(id);
        return result;
    }

    @Override
    public List<Bgt> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<Bgt> result = listBy(params);
        return result;
    }
}
