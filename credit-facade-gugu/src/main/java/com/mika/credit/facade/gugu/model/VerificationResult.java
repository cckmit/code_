package com.mika.credit.facade.gugu.model;

import java.io.Serializable;
import java.util.Date;

public class VerificationResult implements Serializable{
    private static final long serialVersionUID = 8203047813341840929L;
    private Integer id;

    private Integer cardId;

    private String companyStatusResult;

    private String companyAddressTelAddressResult;

    private String companyNameTelNameResult;

    private String cardNameMobileName;

    private String companyNameIcpNameResult;

    private String otherInfoResult;

    private Integer totalScore;

    private String delFlag;

    private Integer userId;

    private String personNameCompanyName;

    /**
     *更新时间
     */
    private Date updateTime;

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

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

    public String getCompanyStatusResult() {
        return companyStatusResult;
    }

    public void setCompanyStatusResult(String companyStatusResult) {
        this.companyStatusResult = companyStatusResult == null ? null : companyStatusResult.trim();
    }

    public String getCompanyAddressTelAddressResult() {
        return companyAddressTelAddressResult;
    }

    public void setCompanyAddressTelAddressResult(String companyAddressTelAddressResult) {
        this.companyAddressTelAddressResult = companyAddressTelAddressResult == null ? null : companyAddressTelAddressResult.trim();
    }

    public String getCompanyNameTelNameResult() {
        return companyNameTelNameResult;
    }

    public void setCompanyNameTelNameResult(String companyNameTelNameResult) {
        this.companyNameTelNameResult = companyNameTelNameResult == null ? null : companyNameTelNameResult.trim();
    }

    public String getCardNameMobileName() {
        return cardNameMobileName;
    }

    public void setCardNameMobileName(String cardNameMobileName) {
        this.cardNameMobileName = cardNameMobileName == null ? null : cardNameMobileName.trim();
    }

    public String getCompanyNameIcpNameResult() {
        return companyNameIcpNameResult;
    }

    public void setCompanyNameIcpNameResult(String companyNameIcpNameResult) {
        this.companyNameIcpNameResult = companyNameIcpNameResult == null ? null : companyNameIcpNameResult.trim();
    }

    public String getOtherInfoResult() {
        return otherInfoResult;
    }

    public void setOtherInfoResult(String otherInfoResult) {
        this.otherInfoResult = otherInfoResult == null ? null : otherInfoResult.trim();
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPersonNameCompanyName() {
        return personNameCompanyName;
    }

    public void setPersonNameCompanyName(String personNameCompanyName) {
        this.personNameCompanyName = personNameCompanyName;
    }
}