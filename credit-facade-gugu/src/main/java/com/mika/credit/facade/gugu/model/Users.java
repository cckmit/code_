package com.mika.credit.facade.gugu.model;

public class Users {
    private Integer id;

    private String address;

    private String areaCode;

    private String delFlag;

    private String email;

    private String mobileNum;

    private String orderMail;

    private String photoPath;

    private String position;

    private String pwd;

    private String realName;

    private String reportMail;

    private String statementMail;

    private String tel;

    private String userName;

    private String website;

    private String qrCodePath;

    private String phoneToken;

    private String showPhotoPath;

    private String showQrCodePath;

    private Float balance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum == null ? null : mobileNum.trim();
    }

    public String getOrderMail() {
        return orderMail;
    }

    public void setOrderMail(String orderMail) {
        this.orderMail = orderMail == null ? null : orderMail.trim();
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath == null ? null : photoPath.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getReportMail() {
        return reportMail;
    }

    public void setReportMail(String reportMail) {
        this.reportMail = reportMail == null ? null : reportMail.trim();
    }

    public String getStatementMail() {
        return statementMail;
    }

    public void setStatementMail(String statementMail) {
        this.statementMail = statementMail == null ? null : statementMail.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    public String getQrCodePath() {
        return qrCodePath;
    }

    public void setQrCodePath(String qrCodePath) {
        this.qrCodePath = qrCodePath == null ? null : qrCodePath.trim();
    }

    public String getPhoneToken() {
        return phoneToken;
    }

    public void setPhoneToken(String phoneToken) {
        this.phoneToken = phoneToken == null ? null : phoneToken.trim();
    }

    public String getShowPhotoPath() {
        return showPhotoPath;
    }

    public void setShowPhotoPath(String showPhotoPath) {
        this.showPhotoPath = showPhotoPath == null ? null : showPhotoPath.trim();
    }

    public String getShowQrCodePath() {
        return showQrCodePath;
    }

    public void setShowQrCodePath(String showQrCodePath) {
        this.showQrCodePath = showQrCodePath == null ? null : showQrCodePath.trim();
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }
}