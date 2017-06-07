package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;

public class ShareCapital extends BaseEntity {
    private Integer id;

    private String crefoNo;

    private String subscribedCapitalDate;

    private String subscribedCapitalValue;

    private String subscribedCapitalCurrencyCode;

    private String paidupCapitalDate;

    private String paidupCapitalValue;

    private String paidupCapitalCurrencyCode;

    private String nominalShareCapitalDate;

    private String nominalShareCapitalValue;

    private String nominalShareCapitalCurrencyCode;

    private String amountPerShareDate;

    private String amountPerValue;

    private String amountPerCurrencyCode;

    private String totalNumberOfSharesDate;

    private String totalNumberOfSharesValue;

    private String totalNumberOfSharesCurrencyCode;

    private String updateTime;

    private String delFlag;

    private Integer fullReportId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCrefoNo() {
        return crefoNo;
    }

    public void setCrefoNo(String crefoNo) {
        this.crefoNo = crefoNo == null ? null : crefoNo.trim();
    }

    public String getSubscribedCapitalDate() {
        return subscribedCapitalDate;
    }

    public void setSubscribedCapitalDate(String subscribedCapitalDate) {
        this.subscribedCapitalDate = subscribedCapitalDate == null ? null : subscribedCapitalDate.trim();
    }

    public String getSubscribedCapitalValue() {
        return subscribedCapitalValue;
    }

    public void setSubscribedCapitalValue(String subscribedCapitalValue) {
        this.subscribedCapitalValue = subscribedCapitalValue == null ? null : subscribedCapitalValue.trim();
    }

    public String getSubscribedCapitalCurrencyCode() {
        return subscribedCapitalCurrencyCode;
    }

    public void setSubscribedCapitalCurrencyCode(String subscribedCapitalCurrencyCode) {
        this.subscribedCapitalCurrencyCode = subscribedCapitalCurrencyCode == null ? null : subscribedCapitalCurrencyCode.trim();
    }

    public String getPaidupCapitalDate() {
        return paidupCapitalDate;
    }

    public void setPaidupCapitalDate(String paidupCapitalDate) {
        this.paidupCapitalDate = paidupCapitalDate == null ? null : paidupCapitalDate.trim();
    }

    public String getPaidupCapitalValue() {
        return paidupCapitalValue;
    }

    public void setPaidupCapitalValue(String paidupCapitalValue) {
        this.paidupCapitalValue = paidupCapitalValue == null ? null : paidupCapitalValue.trim();
    }

    public String getPaidupCapitalCurrencyCode() {
        return paidupCapitalCurrencyCode;
    }

    public void setPaidupCapitalCurrencyCode(String paidupCapitalCurrencyCode) {
        this.paidupCapitalCurrencyCode = paidupCapitalCurrencyCode == null ? null : paidupCapitalCurrencyCode.trim();
    }

    public String getNominalShareCapitalDate() {
        return nominalShareCapitalDate;
    }

    public void setNominalShareCapitalDate(String nominalShareCapitalDate) {
        this.nominalShareCapitalDate = nominalShareCapitalDate == null ? null : nominalShareCapitalDate.trim();
    }

    public String getNominalShareCapitalValue() {
        return nominalShareCapitalValue;
    }

    public void setNominalShareCapitalValue(String nominalShareCapitalValue) {
        this.nominalShareCapitalValue = nominalShareCapitalValue == null ? null : nominalShareCapitalValue.trim();
    }

    public String getNominalShareCapitalCurrencyCode() {
        return nominalShareCapitalCurrencyCode;
    }

    public void setNominalShareCapitalCurrencyCode(String nominalShareCapitalCurrencyCode) {
        this.nominalShareCapitalCurrencyCode = nominalShareCapitalCurrencyCode == null ? null : nominalShareCapitalCurrencyCode.trim();
    }

    public String getAmountPerShareDate() {
        return amountPerShareDate;
    }

    public void setAmountPerShareDate(String amountPerShareDate) {
        this.amountPerShareDate = amountPerShareDate == null ? null : amountPerShareDate.trim();
    }

    public String getAmountPerValue() {
        return amountPerValue;
    }

    public void setAmountPerValue(String amountPerValue) {
        this.amountPerValue = amountPerValue == null ? null : amountPerValue.trim();
    }

    public String getAmountPerCurrencyCode() {
        return amountPerCurrencyCode;
    }

    public void setAmountPerCurrencyCode(String amountPerCurrencyCode) {
        this.amountPerCurrencyCode = amountPerCurrencyCode == null ? null : amountPerCurrencyCode.trim();
    }

    public String getTotalNumberOfSharesDate() {
        return totalNumberOfSharesDate;
    }

    public void setTotalNumberOfSharesDate(String totalNumberOfSharesDate) {
        this.totalNumberOfSharesDate = totalNumberOfSharesDate == null ? null : totalNumberOfSharesDate.trim();
    }

    public String getTotalNumberOfSharesValue() {
        return totalNumberOfSharesValue;
    }

    public void setTotalNumberOfSharesValue(String totalNumberOfSharesValue) {
        this.totalNumberOfSharesValue = totalNumberOfSharesValue == null ? null : totalNumberOfSharesValue.trim();
    }

    public String getTotalNumberOfSharesCurrencyCode() {
        return totalNumberOfSharesCurrencyCode;
    }

    public void setTotalNumberOfSharesCurrencyCode(String totalNumberOfSharesCurrencyCode) {
        this.totalNumberOfSharesCurrencyCode = totalNumberOfSharesCurrencyCode == null ? null : totalNumberOfSharesCurrencyCode.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public Integer getFullReportId() {
        return fullReportId;
    }

    public void setFullReportId(Integer fullReportId) {
        this.fullReportId = fullReportId;
    }
}