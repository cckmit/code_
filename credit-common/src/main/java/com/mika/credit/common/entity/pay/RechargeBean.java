package com.mika.credit.common.entity.pay;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 充值
 * Created by dong jian hua on 2017/3/3.
 */
public class RechargeBean implements Serializable{
    private static final long serialVersionUID = 2772323971530783243L;
    private Long id;
    private BigDecimal amount;//充值金额,
    private String currency;// 货币
    private Byte payMethod;//充值方式,
    private Byte status;//状态,
    private Date createTime;//创建时间,
    private Date finishTime; //完成时间,
    private Long customerId;//客户id,
    private String customerName;//客户名称
    private Long managerId; //管理员id,
    private String managerName;//管理员名称
    private BigDecimal rewardAmount;//奖励金额
    private String no;//充值编号
    private Byte appName;//来源


    public RechargeBean() {
    }

    public RechargeBean(DisActivityBean disActivityBean) {
        this.amount = disActivityBean.getAmount();
        this.rewardAmount = disActivityBean.getRewardAmount();
        this.createTime = new Date();
        this.customerId = disActivityBean.getCustomerId();
        this.status = disActivityBean.getStatus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Byte getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Byte payMethod) {
        this.payMethod = payMethod;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public BigDecimal getRewardAmount() {
        return rewardAmount;
    }

    public void setRewardAmount(BigDecimal rewardAmount) {
        this.rewardAmount = rewardAmount;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Byte getAppName() {
        return appName;
    }

    public void setAppName(Byte appName) {
        this.appName = appName;
    }

    public boolean isValid(){
        //TODO:完善验证字段，主要验证非空
        if(this.getAmount()!=null || StringUtils.isEmpty(this.getCurrency()) || this.getPayMethod()!=null
                || this.getStatus()!=null || this.getCreateTime() !=null || this.getFinishTime()!=null
                || this.getCustomerId()!=null || !StringUtils.isEmpty(this.getCustomerName())
                || this.getManagerId()!=null || !StringUtils.isEmpty(this.getManagerName())
                || this.getRewardAmount()!=null || !StringUtils.isEmpty(this.getNo()) || this.getAppName()!=null){
            return true;
        }
        return false;
    }
}
