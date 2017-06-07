package com.mika.credit.facade.front.cn.service.impl;

import com.mika.credit.common.entity.report.cn.FinancialFigures;
import com.mika.credit.facade.front.cn.dao.FinancialFiguresDao;
import com.mika.credit.facade.front.cn.service.FinancialFiguresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2017/2/17.
 */
@Service("financialFiguresService")
public class FinancialFiguresServiceImpl implements FinancialFiguresService {

    @Autowired
    FinancialFiguresDao financialFiguresDao;

    @Override
    public FinancialFigures findById(Integer id) {
        return financialFiguresDao.findById(id);
    }

    @Override
    public List<FinancialFigures> findByFullReportId(Integer fullReportId) {
        return financialFiguresDao.findByFullReportId(fullReportId);
    }
}
