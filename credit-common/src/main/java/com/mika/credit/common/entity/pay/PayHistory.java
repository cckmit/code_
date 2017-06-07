package com.mika.credit.common.entity.pay;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 支付历史
 * Created by Gavin on 2017/2/17.
 */
public class PayHistory implements Serializable{
    private static final long serialVersionUID = -8738853145315565610L;
    private Long id;
    private Byte appName;//支付来源
    /**
     * 购买帐号
     */
    private String userCode;//用户编号
    private String orderNo;//订单编号
    private Byte orderType;//订单类型
    private String title;//标题
    private String currency;//货币类型
    private BigDecimal amount;//金额
    private String des;//描述
    private Date createTime;//创建时间
    private Date payTime;//支付时间
    private String codeUrl;//二维码连接
    private Date expireTime;//到期时间
    private Byte payStatus;//支付状态(1,成功0,失败)
    private WXPayBackBean wxPayBackBean;


    /**
     * 支付方式：0-账号余额 1-支付宝 2-微信
     */
    private Byte payMethod;
    /**
     * 支付帐号
     */
    private String payAccount;

    public PayHistory() {
    }

   public PayHistory(AlipayBean alipayBean) {
        this.appName = alipayBean.getAppName();
        this.userCode = alipayBean.getUserCode();
        this.orderNo = alipayBean.getOrderNo();
        this.title = alipayBean.getTitle();
        this.orderType = alipayBean.getOrderType();
        this.currency = alipayBean.getCurrency();
        this.des = alipayBean.getDes();
        this.createTime = new Date();
        this.payMethod = 1;
        this.amount = alipayBean.getAmount();
    }

    public PayHistory(WXPayBean wxPayBean) {
        this.appName = wxPayBean.getAppName();
        this.userCode = wxPayBean.getUserCode();
        this.orderNo = wxPayBean.getOrderNo();
        this.orderType = wxPayBean.getOrderType();
        this.title = wxPayBean.getTitle();
        this.currency = wxPayBean.getCurrency();
        this.amount = wxPayBean.getAmount();
        this.des = wxPayBean.getDes();
        this.createTime = new Date();
        this.payMethod = 2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Byte getOrderType() {
        return orderType;
    }

    public void setOrderType(Byte orderType) {
        this.orderType = orderType;
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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Byte getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Byte payMethod) {
        this.payMethod = payMethod;
    }

    public String getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Byte getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Byte payStatus) {
        this.payStatus = payStatus;
    }

    public WXPayBackBean getWxPayBackBean() {
        return wxPayBackBean;
    }

    public void setWxPayBackBean(WXPayBackBean wxPayBackBean) {
        this.wxPayBackBean = wxPayBackBean;
    }
}
