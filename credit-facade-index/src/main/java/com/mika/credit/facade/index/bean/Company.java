package com.mika.credit.facade.index.bean;

import java.io.Serializable;

/**
 * Created by Gavin on 2017/2/8.
 */
public class Company implements Serializable{
    private Long crefoNo = 0L;
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
    private String chnCode;//中国行业代码

    private String highLightNameCN;//高亮公司中文名
    private String highLightNameEN;//高亮公司英文名
    private String highLightProductLabel;//高亮产品标签
    private String highLightReg;//高亮注册号

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


    public Long getCrefoNo() {
        return crefoNo;
    }

    public void setCrefoNo(Long crefoNo) {
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

    public String getChnCode() {
        return chnCode;
    }

    public void setChnCode(String chnCode) {
        this.chnCode = chnCode;
    }

    public String getHighLightNameCN() {
        return highLightNameCN;
    }

    public void setHighLightNameCN(String highLightNameCN) {
        this.highLightNameCN = highLightNameCN;
    }

    public String getHighLightNameEN() {
        return highLightNameEN;
    }

    public void setHighLightNameEN(String highLightNameEN) {
        this.highLightNameEN = highLightNameEN;
    }

    public String getHighLightProductLabel() {
        return highLightProductLabel;
    }

    public void setHighLightProductLabel(String highLightProductLabel) {
        this.highLightProductLabel = highLightProductLabel;
    }

    public String getHighLightReg() {
        return highLightReg;
    }

    public void setHighLightReg(String highLightReg) {
        this.highLightReg = highLightReg;
    }
}
