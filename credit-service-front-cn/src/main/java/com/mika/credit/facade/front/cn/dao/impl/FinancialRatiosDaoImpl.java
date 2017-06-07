package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.FinancialRatios;
import com.mika.credit.facade.front.cn.dao.FinancialRatiosDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by michael on 2017/2/27.
 */
@Repository("financialRatiosDao")
public class FinancialRatiosDaoImpl extends BaseDaoImpl<FinancialRatios> implements FinancialRatiosDao {
    @Override
    public FinancialRatios findById(Integer id) {
        FinancialRatios result = getById(id);
        return result;
    }

    @Override
    public List<FinancialRatios> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<FinancialRatios> result = listBy(params);
        return result;
    }
}
