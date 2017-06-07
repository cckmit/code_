package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.AssetsAnnual;
import com.mika.credit.facade.front.cn.dao.AssetsAnnualDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by michael on 2017/2/27.
 */
@Repository("assetsAnnualDao")
public class AssetsAnnualDaoImpl extends BaseDaoImpl<AssetsAnnual> implements AssetsAnnualDao {
    @Override
    public AssetsAnnual findById(Integer id) {
        AssetsAnnual result = getById(id);
        return result;
    }

    @Override
    public List<AssetsAnnual> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<AssetsAnnual> result = listBy(params);
        return result;
    }
}
