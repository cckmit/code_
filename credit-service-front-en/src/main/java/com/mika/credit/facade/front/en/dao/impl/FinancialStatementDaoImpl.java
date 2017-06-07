package com.mika.credit.facade.front.en.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.en.FinancialStatement;
import com.mika.credit.facade.front.en.dao.FinancialStatementDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/3/3.
 */
@Repository("financialStatementDao")
public class FinancialStatementDaoImpl extends BaseDaoImpl<FinancialStatement> implements FinancialStatementDao {
    @Override
    public FinancialStatement findById(Integer id) {
        FinancialStatement result = getById(id);
        return null;
    }

    @Override
    public List<FinancialStatement> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<FinancialStatement> result = listBy(params);
        return result;
    }
}
