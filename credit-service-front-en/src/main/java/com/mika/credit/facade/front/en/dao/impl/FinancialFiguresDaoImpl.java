package com.mika.credit.facade.front.en.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.en.FinancialFigures;
import com.mika.credit.facade.front.en.dao.FinancialFiguresDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/3/3.
 */
@Repository("financialFiguresDao")
public class FinancialFiguresDaoImpl extends BaseDaoImpl<FinancialFigures> implements FinancialFiguresDao {
    @Override
    public FinancialFigures findById(Integer id) {
        FinancialFigures result = getById(id);
        return null;
    }

    @Override
    public List<FinancialFigures> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<FinancialFigures> result = listBy(params);
        return result;
    }
}
