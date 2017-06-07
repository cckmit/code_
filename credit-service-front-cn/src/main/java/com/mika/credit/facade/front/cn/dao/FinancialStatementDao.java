package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.FinancialStatement;

import java.util.List;

/**
 * Created by michael on 2017/2/17.
 */
public interface FinancialStatementDao extends BaseDao<FinancialStatement> {
    FinancialStatement findById(Integer id);

    List<FinancialStatement> findByFullReportId(Integer id);
}
