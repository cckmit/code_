package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;

import java.util.Date;

/**
 * 韩信数据
 * @author ZhuJun，ShenYi.
 */
public class HanXin extends BaseEntity {
    private Integer id;
    private String number;
    private String url;
    private String requestJson;
    private String responseJson;
    private String other;
    private String ip;
    private Date createTime;
    private Date requestTime;
    private Date updateTime;
    /**
     * 关联企业信息的唯一标识
     */
    private Integer fullReportId;


    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRequestJson() {
        return requestJson;
    }

    public void setRequestJson(String requestJson) {
        this.requestJson = requestJson;
    }

    public String getResponseJson() {
        return responseJson;
    }

    public void setResponseJson(String responseJson) {
        this.responseJson = responseJson;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getFullReportId() {
        return fullReportId;
    }

    public void setFullReportId(Integer fullReportId) {
        this.fullReportId = fullReportId;
    }
}
