package com.mika.credit.common.entity.report.en;


import com.mika.credit.common.entity.BaseEntity;
import com.mika.credit.common.entity.report.en.BankInfos;
import com.mika.credit.common.entity.report.en.BasicInfos;
import com.mika.credit.common.entity.report.en.ChangeInfos;
import com.mika.credit.common.entity.report.en.FinancialFigures;
import com.mika.credit.common.entity.report.en.FinancialStatement;
import com.mika.credit.common.entity.report.en.HistoryInfos;
import com.mika.credit.common.entity.report.en.Managements;
import com.mika.credit.common.entity.report.en.MediaRecords;
import com.mika.credit.common.entity.report.en.Operatings;
import com.mika.credit.common.entity.report.en.OtherInfos;
import com.mika.credit.common.entity.report.en.PaymentHistories;
import com.mika.credit.common.entity.report.en.RegistrationInfos;
import com.mika.credit.common.entity.report.en.RelatedCompanies;
import com.mika.credit.common.entity.report.en.ShareholderInfos;
import com.mika.credit.common.entity.report.en.TradeReferences;
import com.mika.credit.common.util.Page;

import java.util.List;

/**
 * Created by dell on 2017/2/19.
 */
public class FullReport extends BaseEntity {

    private Integer id;
    private String name;//企业名称
    private String companyNo;//公司编号
    private String updateTime;//更新时间
    //银行信息
    private List<BankInfos> bankInfosList ;
    //基本信息(经营基本信息+注册基本信息)
    private List<BasicInfos> basicInfo;
    //注册变更表
    private List<ChangeInfos> changeInfosList;
    //财务说明
    private List<FinancialFigures> financialFiguresList;
    ///财务数据
    private List<FinancialStatement> financialStatementList;
    //历史背景沿革
    private List<HistoryInfos> historyInfosList;
    //标识，用来标记特殊的标签
    private List<Identification> identificationList;
    //诉讼记录表
    private List<LegalInfos> legalInfos;
    //管理层信息
    private List<Managements> managementsList;
    //媒体记录表
    private List<MediaRecords> mediaRecordsList;
    //经营现状表
    private List<Operatings> operatingsList;
    //其他信息
    private List<OtherInfos> otherInfosList;
    //支付款记录
    private List<PaymentHistories> paymentHistoriesList;
    //公共记录表
    private List<PublicRecords> publicRecordsList;
    //注册信息
    private List<RegistrationInfos> registrationInfosList;
    //关联公司
    private List<RelatedCompanies> relatedCompaniesList;
    //股东信息
    private List<ShareholderInfos> shareholderInfosList;
    //外贸信息
    private List<TradeReferences> tradeReferencesList;
    //Ucc表
    private List<UCCs> uCCsList;


    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public List<BankInfos> getBankInfosList() {
        return bankInfosList;
    }

    public void setBankInfosList(List<BankInfos> bankInfosList) {
        this.bankInfosList = bankInfosList;
    }

    public List<BasicInfos> getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(List<BasicInfos> basicInfo) {
        this.basicInfo = basicInfo;
    }

    public List<ChangeInfos> getChangeInfosList() {
        return changeInfosList;
    }

    public void setChangeInfosList(List<ChangeInfos> changeInfosList) {
        this.changeInfosList = changeInfosList;
    }

    public List<FinancialFigures> getFinancialFiguresList() {
        return financialFiguresList;
    }

    public void setFinancialFiguresList(List<FinancialFigures> financialFiguresList) {
        this.financialFiguresList = financialFiguresList;
    }

    public List<FinancialStatement> getFinancialStatementList() {
        return financialStatementList;
    }

    public void setFinancialStatementList(List<FinancialStatement> financialStatementList) {
        this.financialStatementList = financialStatementList;
    }

    public List<HistoryInfos> getHistoryInfosList() {
        return historyInfosList;
    }

    public void setHistoryInfosList(List<HistoryInfos> historyInfosList) {
        this.historyInfosList = historyInfosList;
    }

    public List<Identification> getIdentificationList() {
        return identificationList;
    }

    public void setIdentificationList(List<Identification> identificationList) {
        this.identificationList = identificationList;
    }

    public List<LegalInfos> getLegalInfos() {
        return legalInfos;
    }

    public void setLegalInfos(List<LegalInfos> legalInfos) {
        this.legalInfos = legalInfos;
    }

    public List<Managements> getManagementsList() {
        return managementsList;
    }

    public void setManagementsList(List<Managements> managementsList) {
        this.managementsList = managementsList;
    }

    public List<MediaRecords> getMediaRecordsList() {
        return mediaRecordsList;
    }

    public void setMediaRecordsList(List<MediaRecords> mediaRecordsList) {
        this.mediaRecordsList = mediaRecordsList;
    }

    public List<Operatings> getOperatingsList() {
        return operatingsList;
    }

    public void setOperatingsList(List<Operatings> operatingsList) {
        this.operatingsList = operatingsList;
    }

    public List<OtherInfos> getOtherInfosList() {
        return otherInfosList;
    }

    public void setOtherInfosList(List<OtherInfos> otherInfosList) {
        this.otherInfosList = otherInfosList;
    }

    public List<PaymentHistories> getPaymentHistoriesList() {
        return paymentHistoriesList;
    }

    public void setPaymentHistoriesList(List<PaymentHistories> paymentHistoriesList) {
        this.paymentHistoriesList = paymentHistoriesList;
    }

    public List<PublicRecords> getPublicRecordsList() {
        return publicRecordsList;
    }

    public void setPublicRecordsList(List<PublicRecords> publicRecordsList) {
        this.publicRecordsList = publicRecordsList;
    }

    public List<RegistrationInfos> getRegistrationInfosList() {
        return registrationInfosList;
    }

    public void setRegistrationInfosList(List<RegistrationInfos> registrationInfosList) {
        this.registrationInfosList = registrationInfosList;
    }

    public List<RelatedCompanies> getRelatedCompaniesList() {
        return relatedCompaniesList;
    }

    public void setRelatedCompaniesList(List<RelatedCompanies> relatedCompaniesList) {
        this.relatedCompaniesList = relatedCompaniesList;
    }

    public List<ShareholderInfos> getShareholderInfosList() {
        return shareholderInfosList;
    }

    public void setShareholderInfosList(List<ShareholderInfos> shareholderInfosList) {
        this.shareholderInfosList = shareholderInfosList;
    }

    public List<TradeReferences> getTradeReferencesList() {
        return tradeReferencesList;
    }

    public void setTradeReferencesList(List<TradeReferences> tradeReferencesList) {
        this.tradeReferencesList = tradeReferencesList;
    }

    public List<UCCs> getuCCsList() {
        return uCCsList;
    }

    public void setuCCsList(List<UCCs> uCCsList) {
        this.uCCsList = uCCsList;
    }

}
