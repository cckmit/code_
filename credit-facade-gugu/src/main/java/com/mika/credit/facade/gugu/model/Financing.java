package com.mika.credit.facade.gugu.model;

import java.util.Date;

public class Financing {
    private Integer id;

    private String showPhotoPath;

    private String status;

    private String userName;

    private String position;

    private String companyName;

    private String tel;

    private String mobileNum;

    private String serviceType;

    private String enterpriseType;

    private String repaymentIndex;

    private String verificationScore;

    private Date createTime;

    private Date updateTime;

    private String delFlag;

    private String introduction;

    private Float financingAmount;

    private String idCard;

    private String financingNote;

    private Integer businessCardId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShowPhotoPath() {
        return showPhotoPath;
    }

    public void setShowPhotoPath(String showPhotoPath) {
        this.showPhotoPath = showPhotoPath == null ? null : showPhotoPath.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum == null ? null : mobileNum.trim();
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType == null ? null : serviceType.trim();
    }

    public String getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(String enterpriseType) {
        this.enterpriseType = enterpriseType == null ? null : enterpriseType.trim();
    }

    public String getRepaymentIndex() {
        return repaymentIndex;
    }

    public void setRepaymentIndex(String repaymentIndex) {
        this.repaymentIndex = repaymentIndex == null ? null : repaymentIndex.trim();
    }

    public String getVerificationScore() {
        return verificationScore;
    }

    public void setVerificationScore(String verificationScore) {
        this.verificationScore = verificationScore == null ? null : verificationScore.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public Float getFinancingAmount() {
        return financingAmount;
    }

    public void setFinancingAmount(Float financingAmount) {
        this.financingAmount = financingAmount;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getFinancingNote() {
        return financingNote;
    }

    public void setFinancingNote(String financingNote) {
        this.financingNote = financingNote == null ? null : financingNote.trim();
    }

    public Integer getBusinessCardId() {
        return businessCardId;
    }

    public void setBusinessCardId(Integer businessCardId) {
        this.businessCardId = businessCardId;
    }
}