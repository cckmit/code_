package com.mika.credit.common.entity.index;

import java.io.Serializable;

/**
 * Created by Gavin on 2017/2/8.
 */
public class BaseSearchResult implements Serializable{
    private static final long serialVersionUID = -9102719587166554376L;
    private String crefoNo;
    private String nameCN = "";
    private String nameEN = "";
    private String nameUsed = "";
    private String provinceCN = "";
    private String provinceEN = "";
    private String cityCN = "";
    private String cityEN = "";
    private String legelName = "";
    private String reg = "";//注册号
    private String stockCode = "";//股票代码
    private String creditCode = "";//统一征信码
    private Integer status = 0;//状态编码
    private String statusNameEN = "";//根据dataMapping，从status映射
    private String statusNameCN = "";//根据dataMapping，从status映射
    private String remark = "";
    private String updateTime;
    private String financialYear;

    private Integer a;
    private Integer v;
    private String productLabel;


    private String website;
    private String introduction;
    private String exIm;
    private String scale;
    //-----------------------------------
    /**
     * 类似crefoNo,企业唯一标识
     */
    private String identificationNumber;
    /**
     * 类似crefoNo,企业唯一标识
     */
    private String globalIdentificationNumber;
    /**
     * 所在街道(中文)
     */
    private String streetCN;
    /**
     * 所在街道(英文)
     */
    private String streetEN;
    /**
     * 邮编
     */
    private String postcode;
    /**
     * 地区(中文)
     */
    private String areaCN;
    /**
     * 地区(英文)
     */
    private String areaEN;
    /**
     * 所属国家代码
     */
    private String countryCode;
    /**
     * 电话地区编码
     */
    private String phoneAreaCode;
    /**
     * 电话国家编码
     */
    private String phoneCountryCode;
    /**
     * 电话号码
     */
    private String phoneNumber;

    /**
     * Tax number 税号
     */
    private String TAX;
    /**
     * VAT(value added tax) number 增值税号
     */
    private String VAT;
    /**
     * registration number 注册号
     */
    private String RGD;
    /**
     * SIREN number
     * French business identification number
     */
    private String RCS;
    /**
     * ICO number
     */
    private String ICO;
    /**
     * statistics number 统计数量
     */
    private String STA;
    /**
     * chamber of commerce number 商会编号
     */
    private String CHA;
    /**
     * isin number 国际证券识别编码
     */
    private String ISI;
    /**
     * legal entity identifier 全球法人机构识别编码
     */
    private String LEI;
    /**
     * 地址
     */
    private String address;

    private String recordTypeCode;


    public String getRecordTypeCode() {
        return recordTypeCode;
    }

    public void setRecordTypeCode(String recordTypeCode) {
        this.recordTypeCode = recordTypeCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneAreaCode() {
        return phoneAreaCode;
    }

    public void setPhoneAreaCode(String phoneAreaCode) {
        this.phoneAreaCode = phoneAreaCode;
    }

    public String getPhoneCountryCode() {
        return phoneCountryCode;
    }

    public void setPhoneCountryCode(String phoneCountryCode) {
        this.phoneCountryCode = phoneCountryCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public String getProductLabel() {
        return productLabel;
    }

    public void setProductLabel(String productLabel) {
        this.productLabel = productLabel;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getExIm() {
        return exIm;
    }

    public void setExIm(String exIm) {
        this.exIm = exIm;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }


    public String getCrefoNo() {
        return crefoNo;
    }

    public void setCrefoNo(String crefoNo) {
        this.crefoNo = crefoNo;
    }

    public String getNameCN() {
        return nameCN;
    }

    public void setNameCN(String nameCN) {
        this.nameCN = nameCN;
    }

    public String getNameEN() {
        return nameEN;
    }

    public void setNameEN(String nameEN) {
        this.nameEN = nameEN;
    }

    public String getNameUsed() {
        return nameUsed;
    }

    public void setNameUsed(String nameUsed) {
        this.nameUsed = nameUsed;
    }

    public String getProvinceCN() {
        return provinceCN;
    }

    public void setProvinceCN(String provinceCN) {
        this.provinceCN = provinceCN;
    }

    public String getProvinceEN() {
        return provinceEN;
    }

    public void setProvinceEN(String provinceEN) {
        this.provinceEN = provinceEN;
    }

    public String getCityCN() {
        return cityCN;
    }

    public void setCityCN(String cityCN) {
        this.cityCN = cityCN;
    }

    public String getCityEN() {
        return cityEN;
    }

    public void setCityEN(String cityEN) {
        this.cityEN = cityEN;
    }

    public String getLegelName() {
        return legelName;
    }

    public void setLegelName(String legelName) {
        this.legelName = legelName;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusNameEN() {
        return DataMapping.status.get(status);
    }

    public void setStatusNameEN(String statusNameEN) {
        this.statusNameEN = statusNameEN;
    }

    public String getStatusNameCN() {
        return DataMapping.statusCN.get(status);
    }

    public void setStatusNameCN(String statusNameCN) {
        this.statusNameCN = statusNameCN;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getFinancialYear() {
        return financialYear;
    }

    public void setFinancialYear(String financialYear) {
        this.financialYear = financialYear;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getGlobalIdentificationNumber() {
        return globalIdentificationNumber;
    }

    public void setGlobalIdentificationNumber(String globalIdentificationNumber) {
        this.globalIdentificationNumber = globalIdentificationNumber;
    }


    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getStreetCN() {
        return streetCN;
    }

    public void setStreetCN(String streetCN) {
        this.streetCN = streetCN;
    }

    public String getStreetEN() {
        return streetEN;
    }

    public void setStreetEN(String streetEN) {
        this.streetEN = streetEN;
    }

    public String getAreaCN() {
        return areaCN;
    }

    public void setAreaCN(String areaCN) {
        this.areaCN = areaCN;
    }

    public String getAreaEN() {
        return areaEN;
    }

    public void setAreaEN(String areaEN) {
        this.areaEN = areaEN;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getTAX() {
        return TAX;
    }

    public void setTAX(String TAX) {
        this.TAX = TAX;
    }

    public String getVAT() {
        return VAT;
    }

    public void setVAT(String VAT) {
        this.VAT = VAT;
    }

    public String getRGD() {
        return RGD;
    }

    public void setRGD(String RGD) {
        this.RGD = RGD;
    }

    public String getRCS() {
        return RCS;
    }

    public void setRCS(String RCS) {
        this.RCS = RCS;
    }

    public String getICO() {
        return ICO;
    }

    public void setICO(String ICO) {
        this.ICO = ICO;
    }

    public String getSTA() {
        return STA;
    }

    public void setSTA(String STA) {
        this.STA = STA;
    }

    public String getCHA() {
        return CHA;
    }

    public void setCHA(String CHA) {
        this.CHA = CHA;
    }

    public String getISI() {
        return ISI;
    }

    public void setISI(String ISI) {
        this.ISI = ISI;
    }

    public String getLEI() {
        return LEI;
    }

    public void setLEI(String LEI) {
        this.LEI = LEI;
    }
}
