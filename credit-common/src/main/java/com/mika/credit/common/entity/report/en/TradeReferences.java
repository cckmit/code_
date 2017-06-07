package com.mika.credit.common.entity.report.en;

import com.mika.credit.common.entity.BaseEntity;

public class TradeReferences extends BaseEntity {
    private Integer id;

    private String companyCrefoNo;

    private String cooperationDate;//合作日期

    private Integer cpid;

    private String crefoNo;

    private Integer csid;

    private String delFlag;

    private String establishDate;//创办日期

    private String flag;

    private String nameCN;

    private String nameEN;

    private String noteCN;

    private String noteEN;

    private String osid;

    private String reg;

    private String supplierNum;//供应商编号

    private String tel;



    private Integer fullReportId;//关联企业信息的唯一标识

    public Integer getFullReportId() {
        return fullReportId;
    }

    public void setFullReportId(Integer fullReportId) {
        this.fullReportId = fullReportId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public Integer getCpid() {
        return cpid;
    }

    public void setCpid(Integer cpid) {
        this.cpid = cpid;
    }


    public Integer getCsid() {
        return csid;
    }

    public void setCsid(Integer csid) {
        this.csid = csid;
    }


    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }



    public String getOsid() {
        return osid;
    }

    public void setOsid(String osid) {
        this.osid = osid == null ? null : osid.trim();
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg == null ? null : reg.trim();
    }


    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getCompanyCrefoNo() {
        return companyCrefoNo;
    }

    public void setCompanyCrefoNo(String companyCrefoNo) {
        this.companyCrefoNo = companyCrefoNo;
    }

    public String getCooperationDate() {
        return cooperationDate;
    }

    public void setCooperationDate(String cooperationDate) {
        this.cooperationDate = cooperationDate;
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

    public String getEstablishDate() {
        return establishDate;
    }

    public void setEstablishDate(String establishDate) {
        this.establishDate = establishDate;
    }

    public String getNameCN() {
        return nameCN;
    }

    public void setNameCN(String nameCN) {
        this.nameCN = nameCN;
    }

    public String getNameEN() {
        return nameEN;
    }

    public void setNameEN(String nameEN) {
        this.nameEN = nameEN;
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

    public String getSupplierNum() {
        return supplierNum;
    }

    public void setSupplierNum(String supplierNum) {
        this.supplierNum = supplierNum;
    }
}