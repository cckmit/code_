package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.FinancialRatios;

import java.util.List;

/**
 * 财务分析
 * Created by michael on 2017/2/17.
 */
public interface FinancialRatiosDao extends BaseDao<FinancialRatios> {
    FinancialRatios findById(Integer id);

    List<FinancialRatios> findByFullReportId(Integer fullReportId);
}
