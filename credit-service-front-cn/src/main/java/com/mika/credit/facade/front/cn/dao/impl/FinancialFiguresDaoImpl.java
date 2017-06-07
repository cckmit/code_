package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.FinancialFigures;
import com.mika.credit.facade.front.cn.dao.FinancialFiguresDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by michael on 2017/2/27.
 */
@Repository("financialFiguresDao")
public class FinancialFiguresDaoImpl extends BaseDaoImpl<FinancialFigures> implements FinancialFiguresDao{
    @Override
    public FinancialFigures findById(Integer id) {
        Map<String,Object> params = new HashMap<>();
        params.put("id",id);
        FinancialFigures result = getBy(params);
        return result;
    }

    @Override
    public List<FinancialFigures> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<FinancialFigures> result = listBy(params);
        return result;
    }
}
