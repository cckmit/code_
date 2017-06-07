package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;

/**
 * 企业公示股东及出资
 * @author ZhuJun，ShenYi.
 */
public class EnterpriseShareholder extends BaseEntity {

    /**
     * ID编号
     */
    private Integer id;
    /**
     * 中文股东名称
     */
    private String shareNameCN;
    /**
     *股份  出资比例
     */
    private String share;
    /**
     *实缴出资方式
     */
    private String paidInCapital;
    /**
     *实缴出资额
     */
    private String paidInCapitalContribution;
    /**
     *实缴出资日期
     */
    private String paidInDate;
    /**
     *认缴出资日期
     */
    private String subscriptionDate;
    /**
     *认缴出资方式
     */
    private String subscribedInvestmentMethod;
    /**
     *认缴出资额
     */
    private String subscribedCapitalContribution;
    /**
     *更新时间
     */
    private String updateTime;
    /**
     *关联企业信息的唯一标识
     */
    private Integer fullReportId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShareNameCN() {
        return shareNameCN;
    }

    public void setShareNameCN(String shareNameCN) {
        this.shareNameCN = shareNameCN;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public String getPaidInCapital() {
        return paidInCapital;
    }

    public void setPaidInCapital(String paidInCapital) {
        this.paidInCapital = paidInCapital;
    }

    public String getPaidInCapitalContribution() {
        return paidInCapitalContribution;
    }

    public void setPaidInCapitalContribution(String paidInCapitalContribution) {
        this.paidInCapitalContribution = paidInCapitalContribution;
    }

    public String getPaidInDate() {
        return paidInDate;
    }

    public void setPaidInDate(String paidInDate) {
        this.paidInDate = paidInDate;
    }

    public String getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(String subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public String getSubscribedInvestmentMethod() {
        return subscribedInvestmentMethod;
    }

    public void setSubscribedInvestmentMethod(String subscribedInvestmentMethod) {
        this.subscribedInvestmentMethod = subscribedInvestmentMethod;
    }

    public String getSubscribedCapitalContribution() {
        return subscribedCapitalContribution;
    }

    public void setSubscribedCapitalContribution(String subscribedCapitalContribution) {
        this.subscribedCapitalContribution = subscribedCapitalContribution;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getFullReportId() {
        return fullReportId;
    }

    public void setFullReportId(Integer fullReportId) {
        this.fullReportId = fullReportId;
    }
}
