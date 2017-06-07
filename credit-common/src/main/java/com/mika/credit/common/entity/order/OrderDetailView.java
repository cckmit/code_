package com.mika.credit.common.entity.order;

import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单视图
 *
 * @author zj001
 */
public class OrderDetailView extends OrderDetail{

    private static final long serialVersionUID = -6486430570256922687L;
    /**
     * 订单编号
     */
    private String orderNo;
    /**
     * 订单类型
     */
    private Byte type;// TODO:(待完善)
    /**
     * 订单来源,1：全球鹰 2：全搜 3：估估 4：CPM
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
    private Byte orderStatus;
    /**
     * 订单状态中文名
     */
    private String orderStatusNameCN;
    /**
     * 订单状态英文名
     */
    private String orderStatusNameEN;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 支付时间
     */
    private Date payTime;//支付时间
    /**
     * 订单更新时间
     */
    private Date orderUpdateTime;
    /**
     * 订单预计交付时间
     */
    private Date orderExpectTime;
    /**
     * 订单完成时间，业务中，需在预计交付时间前
     */
    private Date orderFinishTime;
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
     * 订单备注
     */
    private String orderRemark;
    /**
     * 产品类型
     */
    private Byte productType;
    /**
     * 产品名称
     */
    private String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOrderStatusNameCN() {
        return OrderStatusEnum.getNameCN(this.orderStatus);
    }
    public String getOrderStatusNameEN() {
        return OrderStatusEnum.getNameEN(this.orderStatus);
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


    public Orders getOrders(){
        Orders orders = new Orders();
        BeanUtils.copyProperties(this,orders);
        orders.setId(this.getOrderId());
        orders.setNo(this.getOrderNo());
        orders.setStatus(this.getOrderStatus());
        orders.setUpdateTime(this.getOrderUpdateTime());
        orders.setExpectTime(this.getExpectTime());
        orders.setFinishTime(this.getOrderFinishTime());
        orders.setRemark(this.getOrderRemark());
        return orders;
    }

    public OrderDetail getOrderDetail(){
        OrderDetail orderDetail = new OrderDetail();
        BeanUtils.copyProperties(this,orderDetail);
        return orderDetail;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getProductType() {
        return productType;
    }

    public void setProductType(Byte productType) {
        this.productType = productType;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Byte getSource() {
        return source;
    }

    public void setSource(Byte source) {
        this.source = source;
    }

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
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

    public Date getOrderUpdateTime() {
        return orderUpdateTime;
    }

    public void setOrderUpdateTime(Date orderUpdateTime) {
        this.orderUpdateTime = orderUpdateTime;
    }

    public Date getOrderExpectTime() {
        return orderExpectTime;
    }

    public void setOrderExpectTime(Date orderExpectTime) {
        this.orderExpectTime = orderExpectTime;
    }

    public Date getOrderFinishTime() {
        return orderFinishTime;
    }

    public void setOrderFinishTime(Date orderFinishTime) {
        this.orderFinishTime = orderFinishTime;
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
        this.customerName = customerName;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
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
        this.createUserName = createUserName;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }
}