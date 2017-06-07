package com.mika.credit.facade.globalsearch.core.model;

import java.io.Serializable;
import java.util.Date;

public class OrderDetail implements Serializable {
    private Integer id;

    private Date createDate;

    private Date updateDate;

    private String orderLevel;

    private String companyNo;

    private String companyName;

    private String uploadFilePath;

    private String currency;

    private Float onlinePrice;

    private Float onlineExpressPrice;

    private Integer onlineNormailDeliveryDays;

    private Integer onlineExpressDeliveryDays;

    private Float offlinePrice;

    private Float offlineExpressPrice;

    private Integer offlineNormailDeliveryDays;

    private Integer offlineExpressDeliveryDays;

    private Float totalPrice;

    private Integer countryId;

    private Integer orderId;

    private Integer customerId;

    private String customerName;

    private Integer managerId;

    private Integer orderStatusId;

    private String isCustomOrder;

    private Integer companyInfoId;

    private String isFinished;

    private String isRead;
    
    private String countryCnName;

    private String countryEnName;

    private String onlineDataJson;

    private String offlineDataJson;

    private String uploadPicPath;

    private String crefoNo;

    private String isChinaOrder;

    private String isPay;

    private String orderNo;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getIsPay() {
        return isPay;
    }

    public void setIsPay(String isPay) {
        this.isPay = isPay;
    }

    public String getIsChinaOrder() {
        return isChinaOrder;
    }

    public void setIsChinaOrder(String isChinaOrder) {
        this.isChinaOrder = isChinaOrder;
    }
    
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCrefoNo() {
        return crefoNo;
    }

    public void setCrefoNo(String crefoNo) {
        this.crefoNo = crefoNo;
    }

    public String getUploadPicPath() {
        return uploadPicPath;
    }

    public void setUploadPicPath(String uploadPicPath) {
        this.uploadPicPath = uploadPicPath;
    }

    public String getOnlineDataJson() {
        return onlineDataJson;
    }

    public void setOnlineDataJson(String onlineDataJson) {
        this.onlineDataJson = onlineDataJson;
    }

    public String getOfflineDataJson() {
        return offlineDataJson;
    }

    public void setOfflineDataJson(String offlineDataJson) {
        this.offlineDataJson = offlineDataJson;
    }

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }

    public String getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(String isFinished) {
        this.isFinished = isFinished;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getOrderLevel() {
        return orderLevel;
    }

    public void setOrderLevel(String orderLevel) {
        this.orderLevel = orderLevel == null ? null : orderLevel.trim();
    }

    public String getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo == null ? null : companyNo.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getUploadFilePath() {
        return uploadFilePath;
    }

    public void setUploadFilePath(String uploadFilePath) {
        this.uploadFilePath = uploadFilePath == null ? null : uploadFilePath.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public Float getOnlinePrice() {
        return onlinePrice;
    }

    public void setOnlinePrice(Float onlinePrice) {
        this.onlinePrice = onlinePrice;
    }

    public Float getOnlineExpressPrice() {
        return onlineExpressPrice;
    }

    public void setOnlineExpressPrice(Float onlineExpressPrice) {
        this.onlineExpressPrice = onlineExpressPrice;
    }

    public Integer getOnlineNormailDeliveryDays() {
        return onlineNormailDeliveryDays;
    }

    public void setOnlineNormailDeliveryDays(Integer onlineNormailDeliveryDays) {
        this.onlineNormailDeliveryDays = onlineNormailDeliveryDays;
    }

    public Integer getOnlineExpressDeliveryDays() {
        return onlineExpressDeliveryDays;
    }

    public void setOnlineExpressDeliveryDays(Integer onlineExpressDeliveryDays) {
        this.onlineExpressDeliveryDays = onlineExpressDeliveryDays;
    }

    public Float getOfflinePrice() {
        return offlinePrice;
    }

    public void setOfflinePrice(Float offlinePrice) {
        this.offlinePrice = offlinePrice;
    }

    public Float getOfflineExpressPrice() {
        return offlineExpressPrice;
    }

    public String getCountryCnName() {
		return countryCnName;
	}

	public void setCountryCnName(String countryCnName) {
		this.countryCnName = countryCnName;
	}

	public String getCountryEnName() {
		return countryEnName;
	}

	public void setCountryEnName(String countryEnName) {
		this.countryEnName = countryEnName;
	}

	public void setOfflineExpressPrice(Float offlineExpressPrice) {
        this.offlineExpressPrice = offlineExpressPrice;
    }

    public Integer getOfflineNormailDeliveryDays() {
        return offlineNormailDeliveryDays;
    }

    public void setOfflineNormailDeliveryDays(Integer offlineNormailDeliveryDays) {
        this.offlineNormailDeliveryDays = offlineNormailDeliveryDays;
    }

    public Integer getOfflineExpressDeliveryDays() {
        return offlineExpressDeliveryDays;
    }

    public void setOfflineExpressDeliveryDays(Integer offlineExpressDeliveryDays) {
        this.offlineExpressDeliveryDays = offlineExpressDeliveryDays;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Integer getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(Integer orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public String getIsCustomOrder() {
        return isCustomOrder;
    }

    public void setIsCustomOrder(String isCustomOrder) {
        this.isCustomOrder = isCustomOrder == null ? null : isCustomOrder.trim();
    }

    public Integer getCompanyInfoId() {
        return companyInfoId;
    }

    public void setCompanyInfoId(Integer companyInfoId) {
        this.companyInfoId = companyInfoId;
    }
}