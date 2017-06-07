package com.mika.credit.facade.front.en.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.en.PaymentHistories;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PaymentHistoriesDao extends BaseDao<PaymentHistories> {

    PaymentHistories findById(Integer id);

    List<PaymentHistories> findByFullReportId(Integer fullReportId);
//    int deleteByPrimaryKey(Integer paymentid);
//
//    int insert(PaymentHistories record);
//
//    int insertSelective(PaymentHistories record);
//
//    PaymentHistories selectByPrimaryKey(Integer paymentid);
//
//    int updateByPrimaryKeySelective(PaymentHistories record);
//
//    int updateByPrimaryKeyWithBLOBs(PaymentHistories record);
//
//    int updateByPrimaryKey(PaymentHistories record);
}