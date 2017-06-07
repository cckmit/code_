package com.mika.credit.facade.gugu.model;

import java.util.Date;

public class Inform {
    private Integer id;

    private Integer userId;

    private Integer orderId;

    private Integer monitorId;

    private String crefoNo;

    private String subjectCompany;

    private String content;

    private Integer informTypeId;

    private String informTypeName;

    private Date updateTime;

    private String isView;

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

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getMonitorId() {
        return monitorId;
    }

    public void setMonitorId(Integer monitorId) {
        this.monitorId = monitorId;
    }

    public String getCrefoNo() {
        return crefoNo;
    }

    public void setCrefoNo(String crefoNo) {
        this.crefoNo = crefoNo == null ? null : crefoNo.trim();
    }

    public String getSubjectCompany() {
        return subjectCompany;
    }

    public void setSubjectCompany(String subjectCompany) {
        this.subjectCompany = subjectCompany == null ? null : subjectCompany.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getInformTypeId() {
        return informTypeId;
    }

    public void setInformTypeId(Integer informTypeId) {
        this.informTypeId = informTypeId;
    }

    public String getInformTypeName() {
        return informTypeName;
    }

    public void setInformTypeName(String informTypeName) {
        this.informTypeName = informTypeName == null ? null : informTypeName.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getIsView() {
        return isView;
    }

    public void setIsView(String isView) {
        this.isView = isView == null ? null : isView.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}