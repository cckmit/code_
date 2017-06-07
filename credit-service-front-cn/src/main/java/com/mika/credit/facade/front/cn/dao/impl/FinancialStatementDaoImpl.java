package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.FinancialStatement;
import com.mika.credit.facade.front.cn.dao.FinancialStatementDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by michael on 2017/2/27.
 */
@Repository("financialStatementDao")
public class FinancialStatementDaoImpl extends BaseDaoImpl<FinancialStatement> implements FinancialStatementDao {
    @Override
    public FinancialStatement findById(Integer id) {
        FinancialStatement result = getById(id);
        return result;
    }

    @Override
    public List<FinancialStatement> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<FinancialStatement> result = listBy(params);
        return result;
    }
}
