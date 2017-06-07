package com.mika.credit.facade.globalsearch.core.model;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {
    private int id;

    private String deptId;

    private String corpId;

    private String code;

    private String passwd;

    private String name;

    private String theme;

    private String idcard;

    private String phone;

    private String addr;

    private String email;

    private Date createTime;

    private Integer loginCount;

    private Date lastTime;

    private String enable;

    private String createBy;

    private String sex;

    private Date birthday;

    private String mobile;

    private String otherContact;

    private String sosPerson;

    private String sosMobile;

    private String bornPlace;

    private Integer levelId;

    private float balance;

    private String companyName;

    private String companyAddress;

    private String companyPhone;

    private String position;

    private String checkStatus;

    private String companyAttach;

    private String companyDesc;

    private String isAudit;

    private Date authSubTime;

    private Date authEndTime;

    private String failReason;

    private String checkStatusOption;

    public String getCheckStatusOption() {
        return checkStatusOption;
    }

    public void setCheckStatusOption(String checkStatusOption) {
        this.checkStatusOption = checkStatusOption;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id ;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId == null ? null : corpId.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme == null ? null : theme.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getOtherContact() {
        return otherContact;
    }

    public void setOtherContact(String otherContact) {
        this.otherContact = otherContact == null ? null : otherContact.trim();
    }

    public String getSosPerson() {
        return sosPerson;
    }

    public void setSosPerson(String sosPerson) {
        this.sosPerson = sosPerson == null ? null : sosPerson.trim();
    }

    public String getSosMobile() {
        return sosMobile;
    }

    public void setSosMobile(String sosMobile) {
        this.sosMobile = sosMobile == null ? null : sosMobile.trim();
    }

    public String getBornPlace() {
        return bornPlace;
    }

    public void setBornPlace(String bornPlace) {
        this.bornPlace = bornPlace == null ? null : bornPlace.trim();
    }

    public String getCompanyAttach() {
        return companyAttach;
    }

    public void setCompanyAttach(String companyAttach) {
        this.companyAttach = companyAttach;
    }

    public String getCompanyDesc() {
        return companyDesc;
    }

    public void setCompanyDesc(String companyDesc) {
        this.companyDesc = companyDesc;
    }

    public String getIsAudit() {
        return isAudit;
    }

    public void setIsAudit(String isAudit) {
        this.isAudit = isAudit;
    }

    public Date getAuthSubTime() {
        return authSubTime;
    }

    public void setAuthSubTime(Date authSubTime) {
        this.authSubTime = authSubTime;
    }

    public Date getAuthEndTime() {
        return authEndTime;
    }

    public void setAuthEndTime(Date authEndTime) {
        this.authEndTime = authEndTime;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }
}