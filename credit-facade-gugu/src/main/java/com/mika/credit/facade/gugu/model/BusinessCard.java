package com.mika.credit.facade.gugu.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusinessCard implements Serializable{
    private static final long serialVersionUID = 361078755088348226L;
    private Integer id;

    private String areaCode;

    private String cardAddress;

    private String cardCompany;

    private String cardEmail;

    private String cardFax;

    private String cardName;

    private String cardNote;

    private String cardPhone;

    private String cardPosition;

    private String cardTel;

    private String cardWebsite;

    private String cardZip;

    private String businessCardNo;

    private String delFlag;

    private String photoPath;

    private Date updateTime;

    private Integer userId;

    private String creditCertification;

    private String creditVerification;

    private String monitor;

    private Integer orderId;

    private Integer verificationScore;

    private Date verificationUpdateTime;

    private Integer verficationId;

    private Integer certificationId;

    private Integer monitorId;

    private String cardCommon;

    private String cardPartner;

    private String showPhotoPath;

    private String bindingCardId;

    private String updateFlag;

    private Date createDate;

    private Integer creditCertificationId;

    private String repaymentIndex;

    private String creditRiskEvaluation;

    private List<CardNote> cardNotes=new ArrayList<>();

    private List<BusinessCardExtend> businessCardExtends=new ArrayList<>();

    public List<CardNote> getCardNotes() {
        return cardNotes;
    }

    public void setCardNotes(List<CardNote> cardNotes) {
        this.cardNotes = cardNotes;
    }

    public List<BusinessCardExtend> getBusinessCardExtends() {
        return businessCardExtends;
    }

    public void setBusinessCardExtends(List<BusinessCardExtend> businessCardExtends) {
        this.businessCardExtends = businessCardExtends;
    }

    public Integer getCertificationId() {
        return certificationId;
    }

    public void setCertificationId(Integer certificationId) {
        this.certificationId = certificationId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public String getCardAddress() {
        return cardAddress;
    }

    public void setCardAddress(String cardAddress) {
        this.cardAddress = cardAddress == null ? null : cardAddress.trim();
    }

    public String getCardCompany() {
        return cardCompany;
    }

    public void setCardCompany(String cardCompany) {
        this.cardCompany = cardCompany == null ? null : cardCompany.trim();
    }

    public String getCardEmail() {
        return cardEmail;
    }

    public void setCardEmail(String cardEmail) {
        this.cardEmail = cardEmail == null ? null : cardEmail.trim();
    }

    public String getCardFax() {
        return cardFax;
    }

    public void setCardFax(String cardFax) {
        this.cardFax = cardFax == null ? null : cardFax.trim();
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName == null ? null : cardName.trim();
    }

    public String getCardNote() {
        return cardNote;
    }

    public void setCardNote(String cardNote) {
        this.cardNote = cardNote == null ? null : cardNote.trim();
    }

    public String getCardPhone() {
        return cardPhone;
    }

    public void setCardPhone(String cardPhone) {
        this.cardPhone = cardPhone == null ? null : cardPhone.trim();
    }

    public String getCardPosition() {
        return cardPosition;
    }

    public void setCardPosition(String cardPosition) {
        this.cardPosition = cardPosition == null ? null : cardPosition.trim();
    }

    public String getCardTel() {
        return cardTel;
    }

    public void setCardTel(String cardTel) {
        this.cardTel = cardTel == null ? null : cardTel.trim();
    }

    public String getCardWebsite() {
        return cardWebsite;
    }

    public void setCardWebsite(String cardWebsite) {
        this.cardWebsite = cardWebsite == null ? null : cardWebsite.trim();
    }

    public String getCardZip() {
        return cardZip;
    }

    public void setCardZip(String cardZip) {
        this.cardZip = cardZip == null ? null : cardZip.trim();
    }

    public String getBusinessCardNo() {
        return businessCardNo;
    }

    public void setBusinessCardNo(String businessCardNo) {
        this.businessCardNo = businessCardNo == null ? null : businessCardNo.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath == null ? null : photoPath.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCreditCertification() {
        return creditCertification;
    }

    public void setCreditCertification(String creditCertification) {
        this.creditCertification = creditCertification == null ? null : creditCertification.trim();
    }

    public String getCreditVerification() {
        return creditVerification;
    }

    public void setCreditVerification(String creditVerification) {
        this.creditVerification = creditVerification == null ? null : creditVerification.trim();
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor == null ? null : monitor.trim();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getVerificationScore() {
        return verificationScore;
    }

    public void setVerificationScore(Integer verificationScore) {
        this.verificationScore = verificationScore;
    }

    public Date getVerificationUpdateTime() {
        return verificationUpdateTime;
    }

    public void setVerificationUpdateTime(Date verificationUpdateTime) {
        this.verificationUpdateTime = verificationUpdateTime;
    }

    public Integer getVerficationId() {
        return verficationId;
    }

    public void setVerficationId(Integer verficationId) {
        this.verficationId = verficationId;
    }

    public Integer getMonitorId() {
        return monitorId;
    }

    public void setMonitorId(Integer monitorId) {
        this.monitorId = monitorId;
    }

    public String getCardCommon() {
        return cardCommon;
    }

    public void setCardCommon(String cardCommon) {
        this.cardCommon = cardCommon == null ? null : cardCommon.trim();
    }

    public String getCardPartner() {
        return cardPartner;
    }

    public void setCardPartner(String cardPartner) {
        this.cardPartner = cardPartner == null ? null : cardPartner.trim();
    }

    public String getShowPhotoPath() {
        return showPhotoPath;
    }

    public void setShowPhotoPath(String showPhotoPath) {
        this.showPhotoPath = showPhotoPath == null ? null : showPhotoPath.trim();
    }

    public String getBindingCardId() {
        return bindingCardId;
    }

    public void setBindingCardId(String bindingCardId) {
        this.bindingCardId = bindingCardId == null ? null : bindingCardId.trim();
    }

    public String getUpdateFlag() {
        return updateFlag;
    }

    public void setUpdateFlag(String updateFlag) {
        this.updateFlag = updateFlag == null ? null : updateFlag.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCreditCertificationId() {
        return creditCertificationId;
    }

    public void setCreditCertificationId(Integer creditCertificationId) {
        this.creditCertificationId = creditCertificationId;
    }

    public String getRepaymentIndex() {
        return repaymentIndex;
    }

    public void setRepaymentIndex(String repaymentIndex) {
        this.repaymentIndex = repaymentIndex == null ? null : repaymentIndex.trim();
    }

    public String getCreditRiskEvaluation() {
        return creditRiskEvaluation;
    }

    public void setCreditRiskEvaluation(String creditRiskEvaluation) {
        this.creditRiskEvaluation = creditRiskEvaluation == null ? null : creditRiskEvaluation.trim();
    }
}