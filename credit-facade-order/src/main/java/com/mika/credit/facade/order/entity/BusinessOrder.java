package com.mika.credit.facade.order.entity;


import com.mika.credit.facade.coredb.en.entity.FullReportEN;

import java.io.Serializable;
import java.util.Date;

public class BusinessOrder implements Serializable {
    private static final long serialVersionUID = -2470121075947142309L;
    /**
     * 订单id
     */
    private Long id;
    /**
     * 订单号
     */
    private String no;
    /**
     * entryId 由bignet自身维护entryId
     */
    //private BigInteger entryId;
    /**
     * 订单来源
     */
    private Byte source;
    /**
     * 订单状态
     */
    private Byte status;
    /**
     * 订单主题
     */
    private String subject;
    /**
     * 产品id
     */
    private Integer productId;
    /**
     * 国家代码
     */
    private String countryCode;
    /**
     * 企业唯一标识
     */
    private String crefoNo;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 完成时间
     */
    private Date finishTime;
    /**
     * 数据保存路径
     */
    private String pathData;
    /**
     * 制作期限
     */
    private Integer expectHour;
    /**
     * 备注
     */
    private String remark;
    /**
     * 下单原因
     */
    private String legitimateInterestCode;
    /**
     * 报告数据
     */
    private FullReportEN fullReportData;

    /**
     * 是否允许过期订单
     */
    private Boolean permitOutdatedReport;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //public BigInteger getEntryId() {
    //    return entryId;
    //}
    //
    //public void setEntryId(BigInteger entryId) {
    //    this.entryId = entryId;
    //}

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode == null ? null : countryCode.trim();
    }

    public Byte getSource() {
        return source;
    }

    public void setSource(Byte source) {
        this.source = source;
    }

    public String getCrefoNo() {
        return crefoNo;
    }

    public void setCrefoNo(String crefoNo) {
        this.crefoNo = crefoNo == null ? null : crefoNo.trim();
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

    public String getPathData() {
        return pathData;
    }

    public void setPathData(String pathData) {
        this.pathData = pathData == null ? null : pathData.trim();
    }

    public Integer getExpectHour() {
        return expectHour;
    }

    public void setExpectHour(Integer expectHour) {
        this.expectHour = expectHour;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public FullReportEN getFullReportData() {
        return fullReportData;
    }

    public void setFullReportData(FullReportEN fullReportData) {
        this.fullReportData = fullReportData;
    }

    public String getLegitimateInterestCode() {
        return legitimateInterestCode;
    }

    public void setLegitimateInterestCode(String legitimateInterestCode) {
        this.legitimateInterestCode = legitimateInterestCode;
    }

    public Boolean getPermitOutdatedReport() {
        return permitOutdatedReport;
    }

    public void setPermitOutdatedReport(Boolean permitOutdatedReport) {
        this.permitOutdatedReport = permitOutdatedReport;
    }
}