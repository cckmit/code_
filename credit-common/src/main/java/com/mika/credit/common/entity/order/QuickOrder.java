package com.mika.credit.common.entity.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 快速订单
 *
 * @author zj001
 */
public class QuickOrder implements Serializable {

    private static final long serialVersionUID = -4506163957834503642L;
    /**
     * 快速订单id
     */
    private Long id;//id
    /**
     * 对应订单编号
     */
    private String orderNo;
    /**
     * 快速订单编号
     */
    private String no;
    /**
     * 订单来源 1：全球鹰 2：全搜 3：CPM 4：估估
     */
    private Byte source;
    /**
     * 订单来源中文名
     */
    private String sourceNameCN;//订单来源 1：全球鹰 2：全搜 3：估估 4：CPM
    /**
     * 订单来源英文名
     */
    private String sourceNameEN;//订单来源 1：全球鹰 2：全搜 3：估估 4：CPM
    /**
     * 订单状态:1 待支付 3 确认中 4 制作中  8 完成  0 取消
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
     * 产品Id(必须)
     */
    private Integer productId;
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
     * 完成时间
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
     * 订购企业所属洲或地区(必须)
     */
    private String companyArea;
    /**
     * 订购企业所属国家(必须)
     */
    private String companyCountry;
    /**
     * 企业名称(必须)
     */
    private String companyName;
    /**
     * 企业地址
     */
    private String companyAddress;
    /**
     * 企业电话
     */
    private String companyPhone;
    /**
     * 企业网站
     */
    private String companyWebsite;
    /**
     * 公司信息图片地址
     */
    private String imgUrl;
    /**
     * 其他信息
     */
    private String otherInfo;
    /**
     * 备注
     */
    private String remark;

    public String getStatusNameCN() {
        return QuickOrderStatusEnum.getNameCN(this.status);
    }

    public String getStatusNameEN() {
        return QuickOrderStatusEnum.getNameEN(this.status);
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo == null ? null : customerNo.trim();
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
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

    public String getCompanyArea() {
        return companyArea;
    }

    public void setCompanyArea(String companyArea) {
        this.companyArea = companyArea == null ? null : companyArea.trim();
    }

    public String getCompanyCountry() {
        return companyCountry;
    }

    public void setCompanyCountry(String companyCountry) {
        this.companyCountry = companyCountry == null ? null : companyCountry.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress == null ? null : companyAddress.trim();
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone == null ? null : companyPhone.trim();
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite == null ? null : companyWebsite.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo == null ? null : otherInfo.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}