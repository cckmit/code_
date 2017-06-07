package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.Managements;
import com.mika.credit.facade.front.cn.dao.ManagementsDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/2/28.
 */
@Repository("managementsDao")
public class ManagementsDaoImpl extends BaseDaoImpl<Managements> implements ManagementsDao {
    @Override
    public Managements findById(Integer id) {
        Managements result = getById(id);
        return result;
    }

    @Override
    public List<Managements> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<Managements> result = listBy(params);
        return result;
    }
}
