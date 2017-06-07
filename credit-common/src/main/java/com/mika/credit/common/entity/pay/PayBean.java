package com.mika.credit.common.entity.pay;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 支付
 * Created by Gavin on 2017/2/17.
 */
public class PayBean implements Serializable{

    private static final long serialVersionUID = -1554931776763416127L;

    private Byte appName;//支付来源
    private String userCode;//用户编号
    private String orderNo;//订单编号
    private Byte orderType;//订单类型
    private String title;//标题
    private String currency;//货币类型
    private BigDecimal amount;//支付金额
    private String des;//描述

    public Byte getAppName() {
        return appName;
    }

    public void setAppName(Byte appName) {
        this.appName = appName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Byte getOrderType() {
        return orderType;
    }

    public void setOrderType(Byte orderType) {
        this.orderType = orderType;
    }

    public boolean isEmpty(){
        //TODO:完善验证字段，主要验证非空
        if(this.getAppName()!=null || !StringUtils.isEmpty(this.getUserCode()) ||!StringUtils.isEmpty(this.getOrderNo())
                || this.getOrderType()!=null || !StringUtils.isEmpty(this.getCurrency()) || !StringUtils.isEmpty(this.getTitle())
                || !StringUtils.isEmpty(this.getDes()) || this.getAmount() !=null){
            return true;
        }
        return false;
    }
}
