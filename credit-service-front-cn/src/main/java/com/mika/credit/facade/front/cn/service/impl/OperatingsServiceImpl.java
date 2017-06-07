package com.mika.credit.facade.front.cn.service.impl;

import com.mika.credit.common.entity.report.cn.Operatings;
import com.mika.credit.facade.front.cn.dao.OperatingsDao;
import com.mika.credit.facade.front.cn.service.OperatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2017/2/17.
 */
@Service("operatingsService")
public class OperatingsServiceImpl implements OperatingsService {
    @Autowired
    OperatingsDao operatingsDao;


    @Override
    public Operatings findById(Integer id) {
        return operatingsDao.findById(id);
    }

    @Override
    public List<Operatings> findByFullReportId(Integer fullReportId) {
        return operatingsDao.findByFullReportId(fullReportId);
    }
}
