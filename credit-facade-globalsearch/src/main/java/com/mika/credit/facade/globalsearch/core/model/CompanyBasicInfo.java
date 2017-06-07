package com.mika.credit.facade.globalsearch.core.model;

import java.io.Serializable;

public class CompanyBasicInfo implements Serializable{
    private Long id;

    private String companyName;

    private String companyNameEn;

    private String registrationId;

    private String local;

    private String localEn;

    private String tradeName;

    private String tradeNameEn;

    private String url;

    private String productIntroduction;

    private String productIntroductionEn;

    private String productIntroductionLink;

    private String servicesIntroduction;

    private String servicesIntroductionEn;

    private String servicesIntroductionLink;

    private String mainAddress;

    private String mainAddressEn;

    private String zip;

    private String email;

    private String telphone;

    private String aboutUs;

    private String aboutUsEn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyNameEn() {
        return companyNameEn;
    }

    public void setCompanyNameEn(String companyNameEn) {
        this.companyNameEn = companyNameEn == null ? null : companyNameEn.trim();
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId == null ? null : registrationId.trim();
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local == null ? null : local.trim();
    }

    public String getLocalEn() {
        return localEn;
    }

    public void setLocalEn(String localEn) {
        this.localEn = localEn == null ? null : localEn.trim();
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName == null ? null : tradeName.trim();
    }

    public String getTradeNameEn() {
        return tradeNameEn;
    }

    public void setTradeNameEn(String tradeNameEn) {
        this.tradeNameEn = tradeNameEn == null ? null : tradeNameEn.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getProductIntroduction() {
        return productIntroduction;
    }

    public void setProductIntroduction(String productIntroduction) {
        this.productIntroduction = productIntroduction == null ? null : productIntroduction.trim();
    }

    public String getProductIntroductionEn() {
        return productIntroductionEn;
    }

    public void setProductIntroductionEn(String productIntroductionEn) {
        this.productIntroductionEn = productIntroductionEn == null ? null : productIntroductionEn.trim();
    }

    public String getProductIntroductionLink() {
        return productIntroductionLink;
    }

    public void setProductIntroductionLink(String productIntroductionLink) {
        this.productIntroductionLink = productIntroductionLink == null ? null : productIntroductionLink.trim();
    }

    public String getServicesIntroduction() {
        return servicesIntroduction;
    }

    public void setServicesIntroduction(String servicesIntroduction) {
        this.servicesIntroduction = servicesIntroduction == null ? null : servicesIntroduction.trim();
    }

    public String getServicesIntroductionEn() {
        return servicesIntroductionEn;
    }

    public void setServicesIntroductionEn(String servicesIntroductionEn) {
        this.servicesIntroductionEn = servicesIntroductionEn == null ? null : servicesIntroductionEn.trim();
    }

    public String getServicesIntroductionLink() {
        return servicesIntroductionLink;
    }

    public void setServicesIntroductionLink(String servicesIntroductionLink) {
        this.servicesIntroductionLink = servicesIntroductionLink == null ? null : servicesIntroductionLink.trim();
    }

    public String getMainAddress() {
        return mainAddress;
    }

    public void setMainAddress(String mainAddress) {
        this.mainAddress = mainAddress == null ? null : mainAddress.trim();
    }

    public String getMainAddressEn() {
        return mainAddressEn;
    }

    public void setMainAddressEn(String mainAddressEn) {
        this.mainAddressEn = mainAddressEn == null ? null : mainAddressEn.trim();
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip == null ? null : zip.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    public String getAboutUs() {
        return aboutUs;
    }

    public void setAboutUs(String aboutUs) {
        this.aboutUs = aboutUs == null ? null : aboutUs.trim();
    }

    public String getAboutUsEn() {
        return aboutUsEn;
    }

    public void setAboutUsEn(String aboutUsEn) {
        this.aboutUsEn = aboutUsEn == null ? null : aboutUsEn.trim();
    }
}