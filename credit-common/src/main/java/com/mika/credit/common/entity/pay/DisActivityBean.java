package com.mika.credit.common.entity.pay;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 优惠活动
 * Created by dong jian hua on 2017/3/6.
 */
public class DisActivityBean implements Serializable{

    private static final long serialVersionUID = 5505257304685616415L;

    private BigDecimal amount;  //充值金额
    private BigDecimal rewardAmount;   //奖励金额
    private Date createTime;  //创建时间
    private Long customerId;   //客户ID
    private Byte status;  //充值状态

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getRewardAmount() {
        return rewardAmount;
    }

    public void setRewardAmount(BigDecimal rewardAmount) {
        this.rewardAmount = rewardAmount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public boolean isValid(){
        //TODO:完善验证字段，主要验证非空
        if(this.getAmount() !=null || this.getRewardAmount() !=null
                || this.getCustomerId() !=null || this.getCreateTime()!=null || this.getStatus() !=null){
            return true;
        }
        return false;
    }
}
