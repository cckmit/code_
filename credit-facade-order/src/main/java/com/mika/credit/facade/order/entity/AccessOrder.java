package com.mika.credit.facade.order.entity;

import java.io.Serializable;
import java.util.Date;

public class AccessOrder implements Serializable{
    private static final long serialVersionUID = -4501512632018553013L;
    private Long id;

    private String no;

    private String crefoNo;

    private Byte source;

    private Boolean isSuccess;

    private Integer productId;

    private String companyName;

    private String countryCode;

    private Date createTime;

    private Date finishTime;

    private Byte dbTarget;

    private Boolean permitOutdatedReport;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getCrefoNo() {
        return crefoNo;
    }

    public void setCrefoNo(String crefoNo) {
        this.crefoNo = crefoNo;
    }

    public Byte getSource() {
        return source;
    }

    public void setSource(Byte source) {
        this.source = source;
    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Byte getDbTarget() {
        return dbTarget;
    }

    public void setDbTarget(Byte dbTarget) {
        this.dbTarget = dbTarget;
    }

    public Boolean getPermitOutdatedReport() {
        return permitOutdatedReport;
    }

    public void setPermitOutdatedReport(Boolean permitOutdatedReport) {
        this.permitOutdatedReport = permitOutdatedReport;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}