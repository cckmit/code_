package com.mika.credit.common.entity.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单实体类
 *
 * @author zj001
 */
public class Orders implements Serializable{

    private static final long serialVersionUID = 4995750058658807135L;
    /**
     * 订单id
     */
    private Long id;
    /**
     * 订单编号
     */
    private String no;
    /**
     * 订单类型
     */
    private Byte type;//TODO:(待完善)
    /**
     * 订单来源,1：全球鹰 2：全搜 3：CPM 4：估估
     */
    private Byte source;
    /**
     * 订单来源中文名
     */
    private String sourceNameCN;
    /**
     * 订单来源英文名
     */
    private String sourceNameEN;
    /**
     * 订单状态: 1 待支付 4 制作中  8 完成  0 取消
     */
    private Byte status;
    /**
     * 订单状态中文名
     */
    private String statusNameCN;
    /**
     * 订单状态英文名
     */
    private String statusNameEN;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 支付时间
     */
    private Date payTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 预计交付时间
     */
    private Date expectTime;
    /**
     * 完成时间，业务中，需在预计交付时间前
     */
    private Date finishTime;
    /**
     * 客户id，除手工订单，系统下单均不能为空
     */
    private Integer customerId;
    /**
     * 客户名
     */
    private String customerName;
    /**
     * 客户号，客户给予
     */
    private String customerNo;
    /**
     * 客户邮件，除手工订单，系统下单均不能为空。业务发送邮件所用
     */
    private String customerEmail;
    /**
     * 操作员Id，适用于手工订单
     */
    private Integer createUserId;
    /**
     * 操作员名字
     */
    private String createUserName;
    /**
     * 应付金额
     */
    private BigDecimal amount;
    /**
     * 实付金额，典型场景：升级报告减差价
     */
    private BigDecimal amountActual;
    /**
     * 币种,取3位国际编码
     */
    private String currency;
    /**
     * 是否支付
     */
    private Boolean hasPay;
    /**
     * 支付方式 0：帐号余额 1：支付宝 2：微信
     */
    private Byte payMethod;
    /**
     * 支付方式中文名
     */
    private String payMethodNameCN;
    /**
     * 支付方式英文名
     */
    private String payMethodNameEN;
    /**
     * 明细数量
     */
    private Byte detailCount;
    /**
     * 备注
     */
    private String remark;
    /**
     * 该订单下的订单明细
     */
    private List<OrderDetail> orderDetails;

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public String getStatusNameCN() {
        return OrderStatusEnum.getNameCN(this.getStatus());
    }
    public String getStatusNameEN() {
        return OrderStatusEnum.getNameEN(this.getStatus());
    }

    public String getSourceNameCN() {
        return SourceEnum.getNameCN(this.source);
    }
    public String getSourceNameEN() {
        return SourceEnum.getNameEN(this.source);
    }


    public String getPayMethodNameCN() {
        return PayMethodEnum.getNameCN(this.payMethod);
    }

    public String getPayMethodNameEN() {
        return PayMethodEnum.getNameEN(this.payMethod);
    }

    public Byte getType() {
        return type;
    }

    public void setOrderType(Byte type) {
        this.type = type;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

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
        this.no = no == null ? null : no.trim();
    }

    public Byte getSource() {
        return source;
    }

    public void setSource(Byte source) {
        this.source = source;
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

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getExpectTime() {
        return expectTime;
    }

    public void setExpectTime(Date expectTime) {
        this.expectTime = expectTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail == null ? null : customerEmail.trim();
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmountActual() {
        return amountActual;
    }

    public void setAmountActual(BigDecimal amountActual) {
        this.amountActual = amountActual;
    }

    public Boolean getHasPay() {
        return hasPay;
    }

    public void setHasPay(Boolean hasPay) {
        this.hasPay = hasPay;
    }

    public Byte getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Byte payMethod) {
        this.payMethod = payMethod;
    }

    public Byte getDetailCount() {
        return detailCount;
    }

    public void setDetailCount(Byte detailCount) {
        this.detailCount = detailCount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}