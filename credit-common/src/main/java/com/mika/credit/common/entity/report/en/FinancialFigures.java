package com.mika.credit.common.entity.report.en;

import com.mika.credit.common.entity.BaseEntity;

public class FinancialFigures extends BaseEntity {
    private Integer id;

    private String auditorCommentCN;   //中文审计评价

    private String auditorCommentEN; //英文审计评价

    private String auditorNameCN;//中文审计单位

    private String auditorNameEN;//英文审计单位

    private String crefoNo;

    private String delFlag;

    private String internalUse; //内部使用

    private String isFinancial;

    private Integer isid;

    private String noteCN;

    private Integer fullReportId;//fullReportId

    public Integer getFullReportId() {
        return fullReportId;
    }

    public void setFullReportId(Integer fullReportId) {
        this.fullReportId = fullReportId;
    }

    private String noteEN;

    private String osid;

    private String supplierNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuditorCommentCN() {
        return auditorCommentCN;
    }

    public void setAuditorCommentCN(String auditorCommentCN) {
        this.auditorCommentCN = auditorCommentCN;
    }

    public String getAuditorCommentEN() {
        return auditorCommentEN;
    }

    public void setAuditorCommentEN(String auditorCommentEN) {
        this.auditorCommentEN = auditorCommentEN;
    }

    public String getAuditorNameCN() {
        return auditorNameCN;
    }

    public void setAuditorNameCN(String auditorNameCN) {
        this.auditorNameCN = auditorNameCN;
    }

    public String getAuditorNameEN() {
        return auditorNameEN;
    }

    public void setAuditorNameEN(String auditorNameEN) {
        this.auditorNameEN = auditorNameEN;
    }

    public String getCrefoNo() {
        return crefoNo;
    }

    public void setCrefoNo(String crefoNo) {
        this.crefoNo = crefoNo;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getInternalUse() {
        return internalUse;
    }

    public void setInternalUse(String internalUse) {
        this.internalUse = internalUse;
    }

    public String getIsFinancial() {
        return isFinancial;
    }

    public void setIsFinancial(String isFinancial) {
        this.isFinancial = isFinancial;
    }

    public Integer getIsid() {
        return isid;
    }

    public void setIsid(Integer isid) {
        this.isid = isid;
    }

    public String getNoteCN() {
        return noteCN;
    }

    public void setNoteCN(String noteCN) {
        this.noteCN = noteCN;
    }

    public String getNoteEN() {
        return noteEN;
    }

    public void setNoteEN(String noteEN) {
        this.noteEN = noteEN;
    }

    public String getOsid() {
        return osid;
    }

    public void setOsid(String osid) {
        this.osid = osid;
    }

    public String getSupplierNum() {
        return supplierNum;
    }

    public void setSupplierNum(String supplierNum) {
        this.supplierNum = supplierNum;
    }
}