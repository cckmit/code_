package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.Sxgg;
import com.mika.credit.facade.front.cn.dao.SxggDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/2/27.
 */
@Repository("sxggDao")
public class SxggDaoImpl extends BaseDaoImpl<Sxgg> implements SxggDao {
    @Override
    public List<Sxgg> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<Sxgg> result = listBy(params);
        return result;
    }

    @Override
    public Sxgg findById(Integer id) {
        Sxgg result =  getById(id);
        return result;
    }
}
