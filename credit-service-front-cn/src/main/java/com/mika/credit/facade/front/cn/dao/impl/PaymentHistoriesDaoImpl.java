package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.PaymentHistories;
import com.mika.credit.facade.front.cn.dao.PaymentHistoriesDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/2/28.
 */
@Repository("paymentHistoriesDao")
public class PaymentHistoriesDaoImpl extends BaseDaoImpl<PaymentHistories> implements PaymentHistoriesDao {
    @Override
    public PaymentHistories findById(Integer id) {
        PaymentHistories result = getById(id);
        return result;
    }

    @Override
    public List<PaymentHistories> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<PaymentHistories> result = listBy(params);
        return result;
    }
}
