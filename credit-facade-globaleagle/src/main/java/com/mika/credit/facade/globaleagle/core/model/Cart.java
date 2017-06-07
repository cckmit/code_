package com.mika.credit.facade.globaleagle.core.model;

import java.io.Serializable;
import java.util.Date;

public class Cart implements Serializable {
    private Integer id;

    private String companyName;

    private String companyNo;

    private String orderLevel;

    private String currency;

    private Float onlinePrice;

    private Float onlineExpressPrice;

    private Integer onlineNormailDeliveryDays;

    private Integer onlineExpressDeliveryDays;

    private Float onlineFullPrice;

    private Float onlineFullExpressPrice;

    private Integer onlineFullNormailDeliveryDays;

    private Integer onlineFullExpressDeliveryDays;

    private Float offlinePrice;

    private Float offlineExpressPrice;

    private Integer offlineNormailDeliveryDays;

    private Integer offlineExpressDeliveryDays;

    private Float totalPrice;

    private Date createDate;

    private Date updateDate;

    private Integer customerId;

    private Integer companyInfoId;

    private Integer countryId;

    private String isCustomOrder;
    
    private String countryName;
    
    private String uploadPicPath;

    private String crefoNo;

    private String isChinaOrder;

    public Float getOnlineFullPrice() {
        return onlineFullPrice;
    }

    public void setOnlineFullPrice(Float onlineFullPrice) {
        this.onlineFullPrice = onlineFullPrice;
    }

    public Float getOnlineFullExpressPrice() {
        return onlineFullExpressPrice;
    }

    public void setOnlineFullExpressPrice(Float onlineFullExpressPrice) {
        this.onlineFullExpressPrice = onlineFullExpressPrice;
    }

    public Integer getOnlineFullNormailDeliveryDays() {
        return onlineFullNormailDeliveryDays;
    }

    public void setOnlineFullNormailDeliveryDays(Integer onlineFullNormailDeliveryDays) {
        this.onlineFullNormailDeliveryDays = onlineFullNormailDeliveryDays;
    }

    public Integer getOnlineFullExpressDeliveryDays() {
        return onlineFullExpressDeliveryDays;
    }

    public void setOnlineFullExpressDeliveryDays(Integer onlineFullExpressDeliveryDays) {
        this.onlineFullExpressDeliveryDays = onlineFullExpressDeliveryDays;
    }

    public String getIsChinaOrder() {
        return isChinaOrder;
    }

    public void setIsChinaOrder(String isChinaOrder) {
        this.isChinaOrder = isChinaOrder;
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

    public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo == null ? null : companyNo.trim();
    }

    public String getOrderLevel() {
        return orderLevel;
    }

    public void setOrderLevel(String orderLevel) {
        this.orderLevel = orderLevel == null ? null : orderLevel.trim();
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

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCompanyInfoId() {
        return companyInfoId;
    }

    public void setCompanyInfoId(Integer companyInfoId) {
        this.companyInfoId = companyInfoId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getIsCustomOrder() {
        return isCustomOrder;
    }

    public void setIsCustomOrder(String isCustomOrder) {
        this.isCustomOrder = isCustomOrder == null ? null : isCustomOrder.trim();
    }
}