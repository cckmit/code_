package com.mika.credit.facade.front.cn.service.impl;

import com.mika.credit.common.entity.report.cn.FinancialRatios;
import com.mika.credit.facade.front.cn.dao.FinancialRatiosDao;
import com.mika.credit.facade.front.cn.service.FinancialRatiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2017/2/17.
 */
@Service("financialRatiosService")
public class FinancialRatiosServiceImpl implements FinancialRatiosService {

    @Autowired
    FinancialRatiosDao financialRatiosDao;

    @Override
    public FinancialRatios findById(Integer id) {
        return financialRatiosDao.findById(id);
    }

    @Override
    public List<FinancialRatios> findByFullReportId(Integer fullReportId) {
        return financialRatiosDao.findByFullReportId(fullReportId);
    }
}
