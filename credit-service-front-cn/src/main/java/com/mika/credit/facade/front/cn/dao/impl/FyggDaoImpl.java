package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.Fygg;
import com.mika.credit.facade.front.cn.dao.FyggDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/2/27.
 */
@Repository("fyggDao")
public class FyggDaoImpl extends BaseDaoImpl<Fygg> implements FyggDao {
    @Override
    public Fygg findById(Integer id) {
        Fygg result = getById(id);
        return result;
    }

    @Override
    public List<Fygg> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<Fygg> result = listBy(params);
        return result;
    }
}
