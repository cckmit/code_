package com.mika.credit.facade.front.en.service.impl;

import com.alibaba.fastjson.JSON;
import com.creditsafe.globaldata.datatypes.reports.LtdCompanyFullReport;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.report.en.BasicInfos;
import com.mika.credit.common.entity.report.en.FullReport;
import com.mika.credit.facade.front.en.dao.*;
import com.mika.credit.facade.front.en.dao.impl.JsonReportDaoImpl;
import com.mika.credit.facade.front.en.entity.JsonReport;
import com.mika.credit.facade.front.en.parse.ParseENService;
import com.mika.credit.facade.front.en.service.FullReportServiceEN;
import com.mika.credit.facade.front.en.service.OnlineReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

/**
 * Created by dell on 2017/2/17.
 */
@Service("fullReportServiceEN")
public class FullReportServiceENImpl implements FullReportServiceEN {

    @Autowired
    FullReportDao fullReportDao;

    @Autowired
    ParseENService parseENService;

    @Autowired
    OnlineReportService onlineReportService;

    @Autowired
    BankInfosDao bankInfosDao;

    @Autowired
    BasicInfosDao basicInfosDao;

    @Autowired
    ChangeInfosDao changeInfosDao;

    @Autowired
    FinancialFiguresDao financialFiguresDao;

    @Autowired
    FinancialStatementDao financialStatementDao;

    @Autowired
    HistoryInfosDao historyInfosDao;

    @Autowired
    IdentificationDao identificationDao;

    @Autowired
    LegalInfosDao legalInfosDao;

    @Autowired
    ManagementsDao managementsDao;

    @Autowired
    MediaRecordsDao mediaRecordsDao;

    @Autowired
    OperatingsDao operatingsDao;

    @Autowired
    OtherInfosDao otherInfosDao;

    @Autowired
    PaymentHistoriesDao paymentHistoriesDao;

    @Autowired
    PublicRecordsDao publicRecordsDao;

    @Autowired
    RegistrationInfosDao registrationInfosDao;

    @Autowired
    RelatedCompaniesDao relatedCompaniesDao;

    @Autowired
    ShareholderInfosDao shareholderInfosDao;

    @Autowired
    TradeReferencesDao tradeReferencesDao;

    @Autowired
    UCCsDao ucCsDao;


    @Autowired
    JsonReportDao jsonReportDao;


    @Override
    public FullReport getFullReport(FullReport report) {
        //确保传入值非空
        if (report == null) {
            return null;
        }
        if (report.getCompanyNo() == null || report.getCompanyNo().equals("")) {
            return null;
        }
        //先判断数据库有没有这条记录
        FullReport fullReport = fullReportDao.findByCompanyNo(report.getCompanyNo());
        if (null != fullReport && null != fullReport.getId()) {
            //获取全部数据
            report = getAllFullReport(report);
        } else {
            //没有记录  拿接口数据  解析 保存数据库
            //插入fullreport
            fullReportDao.insert(report);
            FullReport fullbasicReport = fullReportDao.findByCompanyNo(report.getCompanyNo());

            //safe接口拿数据
            ResponseResult<LtdCompanyFullReport> ltdCompanyFullReport = null;
            try {
                ltdCompanyFullReport = onlineReportService.requestOnlineReport(report.getCompanyNo(), "Full", "EN");
            } catch (RemoteException e) {
                e.printStackTrace();
                ltdCompanyFullReport = null;
            }
            //解析数据
            if (ltdCompanyFullReport != null) {
//                try {
                report = parseENService.parseDate(ltdCompanyFullReport.getContent(), fullbasicReport.getId());
                //数据存库
                saveSafeDate(report);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    report = null;
//                }
            } else {
                report = null;
            }

        }

        return report;
    }

    public void saveSafeDate(FullReport fullReport) {
        bankInfosDao.insert(fullReport.getBankInfosList());
        basicInfosDao.insert(fullReport.getBasicInfo());
        changeInfosDao.insert(fullReport.getChangeInfosList());
        financialFiguresDao.insert(fullReport.getFinancialFiguresList());
        financialStatementDao.insert(fullReport.getFinancialStatementList());
        historyInfosDao.insert(fullReport.getHistoryInfosList());
        identificationDao.insert(fullReport.getIdentificationList());
        legalInfosDao.insert(fullReport.getLegalInfos());
        managementsDao.insert(fullReport.getManagementsList());
        mediaRecordsDao.insert(fullReport.getMediaRecordsList());
        operatingsDao.insert(fullReport.getOperatingsList());
        otherInfosDao.insert(fullReport.getOtherInfosList());
        paymentHistoriesDao.insert(fullReport.getPaymentHistoriesList());
        publicRecordsDao.insert(fullReport.getPublicRecordsList());
        registrationInfosDao.insert(fullReport.getRegistrationInfosList());
        relatedCompaniesDao.insert(fullReport.getRelatedCompaniesList());
        shareholderInfosDao.insert(fullReport.getShareholderInfosList());
        tradeReferencesDao.insert(fullReport.getTradeReferencesList());
        ucCsDao.insert(fullReport.getuCCsList());

    }

    public FullReport getAllFullReport(FullReport fullReport) {
        fullReport.setBankInfosList(bankInfosDao.findByFullReportId(fullReport.getId()));
        fullReport.setBasicInfo(basicInfosDao.findByFullReportId(fullReport.getId()));
        fullReport.setChangeInfosList(changeInfosDao.findByFullReportId(fullReport.getId()));
        fullReport.setFinancialFiguresList(financialFiguresDao.findByFullReportId(fullReport.getId()));
        fullReport.setFinancialStatementList(financialStatementDao.findByFullReportId(fullReport.getId()));
        fullReport.setHistoryInfosList(historyInfosDao.findByFullReportId(fullReport.getId()));
        fullReport.setIdentificationList(identificationDao.findByFullReportId(fullReport.getId()));
        fullReport.setLegalInfos(legalInfosDao.findByFullReportId(fullReport.getId()));
        fullReport.setManagementsList(managementsDao.findByFullReportId(fullReport.getId()));
        fullReport.setMediaRecordsList(mediaRecordsDao.findByFullReportId(fullReport.getId()));
        fullReport.setOperatingsList(operatingsDao.findByFullReportId(fullReport.getId()));
        fullReport.setOtherInfosList(otherInfosDao.findByFullReportId(fullReport.getId()));
        fullReport.setPaymentHistoriesList(paymentHistoriesDao.findByFullReportId(fullReport.getId()));
        fullReport.setPublicRecordsList(publicRecordsDao.findByFullReportId(fullReport.getId()));
        fullReport.setRegistrationInfosList(registrationInfosDao.findByFullReportId(fullReport.getId()));
        fullReport.setRelatedCompaniesList(relatedCompaniesDao.findByFullReportId(fullReport.getId()));
        fullReport.setShareholderInfosList(shareholderInfosDao.findByFullReportId(fullReport.getId()));
        fullReport.setTradeReferencesList(tradeReferencesDao.findByFullReportId(fullReport.getId()));
        fullReport.setuCCsList(ucCsDao.findByFullReportId(fullReport.getId()));
        return fullReport;
    }

    @Override
    public String getSafeReport(FullReport report) {
        ResponseResult<LtdCompanyFullReport> ltdCompanyFullReport = null;
        JsonReport result = new JsonReport();
        //确保传入值非空
        if (report == null) {
            return null;
        }
        if (report.getCompanyNo() == null || report.getCompanyNo().equals("")) {
            return null;
        }
        String safeDataString = null;
        //先判断数据库有没有这条记录
        List<JsonReport> jsonReport = jsonReportDao.selectByCompanyId(report.getCompanyNo());
        if (jsonReport.size()>0) {
            Date createTime = jsonReport.get(0).getCreateTime();
            Date now = new Date();
            long weekTime = 7 * 24 * 60 * 60 * 1000;
            //判断小于7天
            if (createTime != null && now.getTime() - createTime.getTime() < weekTime) {
                //获取全部数据
                safeDataString = jsonReport.get(0).getResponseJson();
            }else{
                try {
                    jsonReport.get(0).setRequestTime(new Date());
                    ltdCompanyFullReport = onlineReportService.requestOnlineReport(report.getCompanyNo(), "Full", "EN");
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return null;
                }
                if (ltdCompanyFullReport != null || ltdCompanyFullReport.getCode()) {
                    safeDataString = JSON.toJSONString(ltdCompanyFullReport.getContent());
                    jsonReport.get(0).setUpdateTime(new Date());
                    jsonReport.get(0).setResponseJson(safeDataString);
                    //保存数据
                    jsonReportDao.update(jsonReport.get(0));
                }
            }

        } else {
            //没有记录 拿接口数据 保存数据库

            //safe接口拿数据

            try {
                result.setRequestTime(new Date());
                ltdCompanyFullReport = onlineReportService.requestOnlineReport(report.getCompanyNo(), "Full", "EN");
            } catch (RemoteException e) {
                e.printStackTrace();
                return null;
            }
            if (ltdCompanyFullReport != null || ltdCompanyFullReport.getCode()) {
                safeDataString = JSON.toJSONString(ltdCompanyFullReport.getContent());
                //保存数据
                result.setCompanyId(report.getCompanyNo());
                result.setReportType("Full");
                result.setLanguage("EN");
                result.setResponseJson(safeDataString);
                result.setCreateTime(new Date());
                jsonReportDao.insert(result);
            }
        }
        return safeDataString;
    }

}
