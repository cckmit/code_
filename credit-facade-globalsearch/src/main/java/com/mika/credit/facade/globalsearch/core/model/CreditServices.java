package com.mika.credit.facade.globalsearch.core.model;

import java.io.Serializable;

public class CreditServices implements Serializable {

    private String creditChoose;

    private String name;

    private String phone;

    private String email;

    private String comment;

    private String continent;

    private String country;

    private String companyName;

    private String companyPhone;

    private String companyWebsite;

    private String companyEmail;

    private String companyAddOther;

    private Boolean isOrderReport;

    public String getCreditChoose() {
        return creditChoose;
    }

    public void setCreditChoose(String creditChoose) {
        this.creditChoose = creditChoose;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyAddOther() {
        return companyAddOther;
    }

    public void setCompanyAddOther(String companyAddOther) {
        this.companyAddOther = companyAddOther;
    }

    public Boolean getOrderReport() {
        return isOrderReport;
    }

    public void setOrderReport(Boolean orderReport) {
        isOrderReport = orderReport;
    }
}