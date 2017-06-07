package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.FinancialFigures;

import java.util.List;

/**
 * Created by michael on 2017/2/17.
 */
public interface FinancialFiguresDao extends BaseDao<FinancialFigures> {
    FinancialFigures findById(Integer id);

    List<FinancialFigures> findByFullReportId(Integer fullReportId);
}
