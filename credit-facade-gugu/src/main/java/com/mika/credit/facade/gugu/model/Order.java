package com.mika.credit.facade.gugu.model;

import java.util.Date;

public class Order {
    private Integer id;

    private Integer userId;

    private String userName;

    private String realName;

    private String orderNum;

    private Date orderDate;

    private Date finishDate;

    private String orderStatus;

    private String crefoNo;

    private String subjectName;

    private String subjectTel;

    private String subjectAdd;

    private String subjectZip;

    private String subjectNote;

    private String fileType;

    private String fileName;

    private String reg;

    private String remark;

    private String sourceFlag;

    private Double basePrice;

    private Double money;

    private String monitorFlag;

    private String monitorPeriod;

    private Double monitorPrice;

    private Integer cpmOrderId;

    private Integer cpmCustomerId;

    private String isView;

    private String referenceNum;

    private Integer cpmReportTypeId;

    private String delFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public String getCrefoNo() {
        return crefoNo;
    }

    public void setCrefoNo(String crefoNo) {
        this.crefoNo = crefoNo == null ? null : crefoNo.trim();
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName == null ? null : subjectName.trim();
    }

    public String getSubjectTel() {
        return subjectTel;
    }

    public void setSubjectTel(String subjectTel) {
        this.subjectTel = subjectTel == null ? null : subjectTel.trim();
    }

    public String getSubjectAdd() {
        return subjectAdd;
    }

    public void setSubjectAdd(String subjectAdd) {
        this.subjectAdd = subjectAdd == null ? null : subjectAdd.trim();
    }

    public String getSubjectZip() {
        return subjectZip;
    }

    public void setSubjectZip(String subjectZip) {
        this.subjectZip = subjectZip == null ? null : subjectZip.trim();
    }

    public String getSubjectNote() {
        return subjectNote;
    }

    public void setSubjectNote(String subjectNote) {
        this.subjectNote = subjectNote == null ? null : subjectNote.trim();
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg == null ? null : reg.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getSourceFlag() {
        return sourceFlag;
    }

    public void setSourceFlag(String sourceFlag) {
        this.sourceFlag = sourceFlag == null ? null : sourceFlag.trim();
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getMonitorFlag() {
        return monitorFlag;
    }

    public void setMonitorFlag(String monitorFlag) {
        this.monitorFlag = monitorFlag == null ? null : monitorFlag.trim();
    }

    public String getMonitorPeriod() {
        return monitorPeriod;
    }

    public void setMonitorPeriod(String monitorPeriod) {
        this.monitorPeriod = monitorPeriod == null ? null : monitorPeriod.trim();
    }

    public Double getMonitorPrice() {
        return monitorPrice;
    }

    public void setMonitorPrice(Double monitorPrice) {
        this.monitorPrice = monitorPrice;
    }

    public Integer getCpmOrderId() {
        return cpmOrderId;
    }

    public void setCpmOrderId(Integer cpmOrderId) {
        this.cpmOrderId = cpmOrderId;
    }

    public Integer getCpmCustomerId() {
        return cpmCustomerId;
    }

    public void setCpmCustomerId(Integer cpmCustomerId) {
        this.cpmCustomerId = cpmCustomerId;
    }

    public String getIsView() {
        return isView;
    }

    public void setIsView(String isView) {
        this.isView = isView == null ? null : isView.trim();
    }

    public String getReferenceNum() {
        return referenceNum;
    }

    public void setReferenceNum(String referenceNum) {
        this.referenceNum = referenceNum == null ? null : referenceNum.trim();
    }

    public Integer getCpmReportTypeId() {
        return cpmReportTypeId;
    }

    public void setCpmReportTypeId(Integer cpmReportTypeId) {
        this.cpmReportTypeId = cpmReportTypeId;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}