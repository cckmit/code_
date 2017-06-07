package com.mika.credit.facade.front.cn.service.impl;

import com.mika.credit.common.entity.report.cn.PaymentHistories;
import com.mika.credit.facade.front.cn.dao.PaymentHistoriesDao;
import com.mika.credit.facade.front.cn.service.PaymentHistoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2017/2/17.
 */
@Service("PaymentHistoriesService")
public class PaymentHistoriesServiceImpl implements PaymentHistoriesService {
    @Autowired
    PaymentHistoriesDao paymentHistoriesDao;


    @Override
    public PaymentHistories findById(Integer id) {
        return paymentHistoriesDao.findById(id);
    }

    @Override
    public List<PaymentHistories> findByFullReportId(Integer fullReportId) {
        return paymentHistoriesDao.findByFullReportId(fullReportId);
    }
}
