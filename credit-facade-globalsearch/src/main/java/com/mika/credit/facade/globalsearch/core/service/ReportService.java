package com.mika.credit.facade.globalsearch.core.service;

import com.mika.credit.facade.globalsearch.core.model.CreditServices;
import com.mika.credit.facade.globalsearch.core.model.Order;

import java.io.UnsupportedEncodingException;

/**
 * Created by mike on 2016/9/2.
 */
public interface ReportService {
    //发送报告
    boolean sendReportEmail(String email, String content, String[] fileNames) throws UnsupportedEncodingException;
    //发送收据/凭证
    boolean sendOrderConfirmEmail(String email, String[] fileNames, Order order) throws UnsupportedEncodingException;

    //发送信用申请
    boolean sendCreditEmail(String[] fileNames, CreditServices creditServices) throws UnsupportedEncodingException;

}
