package com.mika.credit.facade.pdf.service;


import com.mika.credit.common.entity.order.OrderDetailView;
import com.mika.credit.common.entity.report.cn.FullReport;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * geratePdf by zhu jun on 2017/1/24.
 */
public interface PDFService {
    //生成PDF String country, String reportDate, String customerId, String type, String companyName, String orderId, String countryId, String email, String caller
    //ByteArrayOutputStream generateCnPdf(com.mika.credit.common.entity.report.cn.FullReport fullReportCn, OrderDetailView orderDetailView) throws IOException;
    String generateEnPdf(String fullReportString, OrderDetailView orderDetailView) throws IOException;

    //生成CPM的PDF
    ByteArrayOutputStream generatePdfCpm(String code,String crefoNo,String hOrderCode,String clientCode,String clientOrderCode)  throws IOException;

    //生成WORD
    ByteArrayOutputStream generateWordCpm(String code,String crefoNo,String hOrderCode,String clientCode,String clientOrderCode)  throws IOException;

    //生成中文PDF
    String enerateGlobaHawkPdfCN(String code ,FullReport fullReportCn,OrderDetailView orderDetailView ) throws Exception;

    String generateTxt(String jsonData);

}