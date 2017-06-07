package com.mika.credit.facade.front.en.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.en.PaymentHistories;
import com.mika.credit.facade.front.en.dao.PaymentHistoriesDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/3/3.
 */
@Repository("paymentHistoriesDao")
public class PaymentHistoriesDaoImpl extends BaseDaoImpl<PaymentHistories> implements PaymentHistoriesDao {
    @Override
    public PaymentHistories findById(Integer id) {
        PaymentHistories result = getById(id);
        return null;
    }

    @Override
    public List<PaymentHistories> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<PaymentHistories> result = listBy(params);
        return result;
    }
}
