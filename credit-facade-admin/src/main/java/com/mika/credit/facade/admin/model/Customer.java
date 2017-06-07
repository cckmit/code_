package com.mika.credit.facade.admin.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 客户
 * @author dhl007
 */
public class Customer implements Serializable {
    /**
     * 客户id
     */
    private Integer id;

    /**
     * 部门id
     */
    private String deptId;

    /**
     * 公司id
     */
    private String corpId;

    /**
     *工号/登陆名
     */
    private String code;

    /**
     *密码
     */
    private String passwd;

    /**
     *姓名
     */
    private String name;

    /**
     *
     */
    private String theme;

    /**
     *身份证号
     */
    private String idcard;

    /**
     *家庭电话
     */
    private String phone;

    /**
     *地址
     */
    private String addr;

    /**
     *邮箱
     */
    private String email;

    /**
     *创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     *登陆次数
     */
    private Integer loginCount;

    /**
     *上次登陆时间
     */
    private Date lastTime;

    /**
     *是否启用
     */
    private String enable;

    /**
     *创建人
     */
    private String createBy;

    /**
     *性别 男/女/无
     */
    private String sex;

    /**
     *出生年月
     */
    private Date birthday;

    /**
     *手机
     */
    private String mobile;

    /**
     *其它联系方式
     */
    private String otherContact;

    /**
     *紧急联系人
     */
    private String sosPerson;

    /**
     *紧急联系人手机
     */
    private String sosMobile;

    /**
     *户籍
     */
    private String bornPlace;

    /**
     *客户等级
     */
    private Integer levelId;

    /**
     *余额
     */
    private float balance;

    /**
     *公司名称
     */
    private String companyName;

    /**
     *公司地址
     */
    private String companyAddress;

    /**
     *公司电话
     */
    private String companyPhone;

    /**
     *职位
     */
    private String position;

    /**
     *审核状态
     */
    private String checkStatus;

    /**
     *附件,使用json格式存储
     */
    private String companyAttach;

    /**
     *公司简要说明
     */
    private String companyDesc;

    /**
     *是否审计
     */
    private String isAudit;

    /**
     *提交认证时间
     */
    private Date authSubTime;

    /**
     *认证结束时间
     */
    private Date authEndTime;

    /**
     *认证失败原因
     */
    private String failReason;

    /**
     *审核状态选项
     */
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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