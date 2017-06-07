package com.mika.credit.facade.front.cn.service.impl;

import com.mika.credit.common.entity.report.cn.FinancialStatement;
import com.mika.credit.facade.front.cn.dao.FinancialStatementDao;
import com.mika.credit.facade.front.cn.service.FinancialStatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2017/2/17.
 */
@Service("financialStatementService")
public class FinancialStatementServiceImpl implements FinancialStatementService {

    @Autowired
    FinancialStatementDao financialStatementDao;

    @Override
    public FinancialStatement findById(Integer id) {
        return financialStatementDao.findById(id);
    }

    @Override
    public List<FinancialStatement> findByFullReportId(Integer id) {
        return financialStatementDao.findByFullReportId(id);
    }
}
