package com.mika.credit.facade.gugu.model;

import java.io.Serializable;
import java.util.Date;

public class CreditCertification implements Serializable{
    private static final long serialVersionUID = 317517070186323873L;
    private Integer id;

    private Integer cardId;

    private Integer orderId;

    private Integer userId;

    private String crefoNo;

    private Date updateTime;

    private String repaymentIndex;

    private String creditRiskEvaluation;

    private String credits;

    private String creditRiskScore;

    private String establishDate;

    private String establishDateScore;

    private String companyProperty;

    private String companyPropertyScore;

    private String employeeNum;

    private String employeeNumScore;

    private String companyStatus;

    private String companyStatusScore;

    private String mainBusiness;

    private String mainBusinessScore;

    private String industry;

    private String industryScore;

    private String litigationRecord;

    private String litigationRecordScore;

    private String regCapital;

    private String regCapitalScore;

    private String paidCapital;

    private String paidCapitalScore;

    private String returnOnEquity;

    private String returnOnEquityScore;

    private String profitMargin;

    private String profitMarginScore;

    private String profitMarginScope;

    private String currentRatio;

    private String currentRatioScore;

    private String currentRatioScope;

    private String quickRatio;

    private String quickRatioScore;

    private String quickRatioScope;

    private String debtRatio;

    private String debtRatioScore;

    private String debtRatioScope;

    private String salesGrowthRate;

    private String salesGrowthRateScore;

    private String salesGrowthRateScope;

    private String companySize;

    private String paidCurrency;

    private String regCurrency;

    private String delFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCrefoNo() {
        return crefoNo;
    }

    public void setCrefoNo(String crefoNo) {
        this.crefoNo = crefoNo == null ? null : crefoNo.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRepaymentIndex() {
        return repaymentIndex;
    }

    public void setRepaymentIndex(String repaymentIndex) {
        this.repaymentIndex = repaymentIndex == null ? null : repaymentIndex.trim();
    }

    public String getEstablishDate() {
        return establishDate;
    }

    public void setEstablishDate(String establishDate) {
        this.establishDate = establishDate;
    }

    public String getCreditRiskEvaluation() {
        return creditRiskEvaluation;
    }

    public void setCreditRiskEvaluation(String creditRiskEvaluation) {
        this.creditRiskEvaluation = creditRiskEvaluation == null ? null : creditRiskEvaluation.trim();
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits == null ? null : credits.trim();
    }

    public String getCreditRiskScore() {
        return creditRiskScore;
    }

    public void setCreditRiskScore(String creditRiskScore) {
        this.creditRiskScore = creditRiskScore == null ? null : creditRiskScore.trim();
    }


    public String getEstablishDateScore() {
        return establishDateScore;
    }

    public void setEstablishDateScore(String establishDateScore) {
        this.establishDateScore = establishDateScore == null ? null : establishDateScore.trim();
    }

    public String getCompanyProperty() {
        return companyProperty;
    }

    public void setCompanyProperty(String companyProperty) {
        this.companyProperty = companyProperty == null ? null : companyProperty.trim();
    }

    public String getCompanyPropertyScore() {
        return companyPropertyScore;
    }

    public void setCompanyPropertyScore(String companyPropertyScore) {
        this.companyPropertyScore = companyPropertyScore == null ? null : companyPropertyScore.trim();
    }

    public String getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(String employeeNum) {
        this.employeeNum = employeeNum == null ? null : employeeNum.trim();
    }

    public String getEmployeeNumScore() {
        return employeeNumScore;
    }

    public void setEmployeeNumScore(String employeeNumScore) {
        this.employeeNumScore = employeeNumScore == null ? null : employeeNumScore.trim();
    }

    public String getCompanyStatus() {
        return companyStatus;
    }

    public void setCompanyStatus(String companyStatus) {
        this.companyStatus = companyStatus == null ? null : companyStatus.trim();
    }

    public String getCompanyStatusScore() {
        return companyStatusScore;
    }

    public void setCompanyStatusScore(String companyStatusScore) {
        this.companyStatusScore = companyStatusScore == null ? null : companyStatusScore.trim();
    }

    public String getMainBusiness() {
        return mainBusiness;
    }

    public void setMainBusiness(String mainBusiness) {
        this.mainBusiness = mainBusiness == null ? null : mainBusiness.trim();
    }

    public String getMainBusinessScore() {
        return mainBusinessScore;
    }

    public void setMainBusinessScore(String mainBusinessScore) {
        this.mainBusinessScore = mainBusinessScore == null ? null : mainBusinessScore.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public String getIndustryScore() {
        return industryScore;
    }

    public void setIndustryScore(String industryScore) {
        this.industryScore = industryScore == null ? null : industryScore.trim();
    }

    public String getLitigationRecord() {
        return litigationRecord;
    }

    public void setLitigationRecord(String litigationRecord) {
        this.litigationRecord = litigationRecord == null ? null : litigationRecord.trim();
    }

    public String getLitigationRecordScore() {
        return litigationRecordScore;
    }

    public void setLitigationRecordScore(String litigationRecordScore) {
        this.litigationRecordScore = litigationRecordScore == null ? null : litigationRecordScore.trim();
    }

    public String getRegCapital() {
        return regCapital;
    }

    public void setRegCapital(String regCapital) {
        this.regCapital = regCapital == null ? null : regCapital.trim();
    }

    public String getRegCapitalScore() {
        return regCapitalScore;
    }

    public void setRegCapitalScore(String regCapitalScore) {
        this.regCapitalScore = regCapitalScore == null ? null : regCapitalScore.trim();
    }

    public String getPaidCapital() {
        return paidCapital;
    }

    public void setPaidCapital(String paidCapital) {
        this.paidCapital = paidCapital == null ? null : paidCapital.trim();
    }

    public String getPaidCapitalScore() {
        return paidCapitalScore;
    }

    public void setPaidCapitalScore(String paidCapitalScore) {
        this.paidCapitalScore = paidCapitalScore == null ? null : paidCapitalScore.trim();
    }

    public String getReturnOnEquity() {
        return returnOnEquity;
    }

    public void setReturnOnEquity(String returnOnEquity) {
        this.returnOnEquity = returnOnEquity == null ? null : returnOnEquity.trim();
    }

    public String getReturnOnEquityScore() {
        return returnOnEquityScore;
    }

    public void setReturnOnEquityScore(String returnOnEquityScore) {
        this.returnOnEquityScore = returnOnEquityScore == null ? null : returnOnEquityScore.trim();
    }

    public String getProfitMargin() {
        return profitMargin;
    }

    public void setProfitMargin(String profitMargin) {
        this.profitMargin = profitMargin == null ? null : profitMargin.trim();
    }

    public String getProfitMarginScore() {
        return profitMarginScore;
    }

    public void setProfitMarginScore(String profitMarginScore) {
        this.profitMarginScore = profitMarginScore == null ? null : profitMarginScore.trim();
    }

    public String getProfitMarginScope() {
        return profitMarginScope;
    }

    public void setProfitMarginScope(String profitMarginScope) {
        this.profitMarginScope = profitMarginScope == null ? null : profitMarginScope.trim();
    }

    public String getCurrentRatio() {
        return currentRatio;
    }

    public void setCurrentRatio(String currentRatio) {
        this.currentRatio = currentRatio == null ? null : currentRatio.trim();
    }

    public String getCurrentRatioScore() {
        return currentRatioScore;
    }

    public void setCurrentRatioScore(String currentRatioScore) {
        this.currentRatioScore = currentRatioScore == null ? null : currentRatioScore.trim();
    }

    public String getCurrentRatioScope() {
        return currentRatioScope;
    }

    public void setCurrentRatioScope(String currentRatioScope) {
        this.currentRatioScope = currentRatioScope == null ? null : currentRatioScope.trim();
    }

    public String getQuickRatio() {
        return quickRatio;
    }

    public void setQuickRatio(String quickRatio) {
        this.quickRatio = quickRatio == null ? null : quickRatio.trim();
    }

    public String getQuickRatioScore() {
        return quickRatioScore;
    }

    public void setQuickRatioScore(String quickRatioScore) {
        this.quickRatioScore = quickRatioScore == null ? null : quickRatioScore.trim();
    }

    public String getQuickRatioScope() {
        return quickRatioScope;
    }

    public void setQuickRatioScope(String quickRatioScope) {
        this.quickRatioScope = quickRatioScope == null ? null : quickRatioScope.trim();
    }

    public String getDebtRatio() {
        return debtRatio;
    }

    public void setDebtRatio(String debtRatio) {
        this.debtRatio = debtRatio == null ? null : debtRatio.trim();
    }

    public String getDebtRatioScore() {
        return debtRatioScore;
    }

    public void setDebtRatioScore(String debtRatioScore) {
        this.debtRatioScore = debtRatioScore == null ? null : debtRatioScore.trim();
    }

    public String getDebtRatioScope() {
        return debtRatioScope;
    }

    public void setDebtRatioScope(String debtRatioScope) {
        this.debtRatioScope = debtRatioScope == null ? null : debtRatioScope.trim();
    }

    public String getSalesGrowthRate() {
        return salesGrowthRate;
    }

    public void setSalesGrowthRate(String salesGrowthRate) {
        this.salesGrowthRate = salesGrowthRate == null ? null : salesGrowthRate.trim();
    }

    public String getSalesGrowthRateScore() {
        return salesGrowthRateScore;
    }

    public void setSalesGrowthRateScore(String salesGrowthRateScore) {
        this.salesGrowthRateScore = salesGrowthRateScore == null ? null : salesGrowthRateScore.trim();
    }

    public String getSalesGrowthRateScope() {
        return salesGrowthRateScope;
    }

    public void setSalesGrowthRateScope(String salesGrowthRateScope) {
        this.salesGrowthRateScope = salesGrowthRateScope == null ? null : salesGrowthRateScope.trim();
    }

    public String getCompanySize() {
        return companySize;
    }

    public void setCompanySize(String companySize) {
        this.companySize = companySize == null ? null : companySize.trim();
    }

    public String getPaidCurrency() {
        return paidCurrency;
    }

    public void setPaidCurrency(String paidCurrency) {
        this.paidCurrency = paidCurrency == null ? null : paidCurrency.trim();
    }

    public String getRegCurrency() {
        return regCurrency;
    }

    public void setRegCurrency(String regCurrency) {
        this.regCurrency = regCurrency == null ? null : regCurrency.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}