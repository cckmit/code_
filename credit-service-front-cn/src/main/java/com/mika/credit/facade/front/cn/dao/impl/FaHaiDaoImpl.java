package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.FaHai;
import com.mika.credit.facade.front.cn.dao.FaHaiDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by michael on 2017/2/27.
 */
@Repository("faHaiDao")
public class FaHaiDaoImpl extends BaseDaoImpl<FaHai> implements FaHaiDao {
    @Override
    public FaHai findById(Integer id) {
        FaHai result = getById(id);
        return result;
    }

    @Override
    public List<FaHai> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<FaHai> result = listBy(params);
        return result;
    }

    @Override
    public FaHai findByCompanyName(String companyName) {
        Map<String,Object> params = new HashMap<>();
        params.put("companyName",companyName);
        FaHai result = getBy(params);
        return result;
    }
}
