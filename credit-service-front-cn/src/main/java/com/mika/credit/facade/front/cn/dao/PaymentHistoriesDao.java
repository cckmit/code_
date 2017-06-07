package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.PaymentHistories;

import java.util.List;

/**
 * 支付款记录
 * Created by jack on 2017/2/17.
 */
public interface PaymentHistoriesDao extends BaseDao<PaymentHistories> {
    PaymentHistories findById(Integer id);



    List<PaymentHistories> findByFullReportId(Integer fullReportId);
}
