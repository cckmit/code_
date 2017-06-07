package com.mika.credit.common.entity.report.en;

import com.mika.credit.common.entity.BaseEntity;

public class RegistrationInfos extends BaseEntity {
    private Integer id;

    private String buildingCN;//大楼中文名称

    private String buildingEN;//大楼英文名称

    private String businessScopeCN;//经营范围中文

    private String businessScopeEN;//经验范围英文

    private String chnCode;//中国行业代码

    private Integer cid;//企业竞争力

    private String cityCN;//城市中文名称

    private String cityEN;//城市英文名称

    private String countryCN;//城市中文名称

    private String countryEN;//城市英文名称

    private Integer cpid;////企业性质

    private String crefoNo;//

    private Integer fullReportId;//fullReportId

    public Integer getFullReportId() {
        return fullReportId;
    }

    public void setFullReportId(Integer fullReportId) {
        this.fullReportId = fullReportId;
    }

    private Integer csid;//公司状态

    private Integer ctid;//企业类型

    private String deadline;//有效期限

    private String delFlag;

    private String districtCN;//地区中文名称

    private String districtEN;//地区英文名称

    private String establishDate;//成立日期//开业日期

    private String euCode;//欧盟行业代码

    private String intCode;//国际行业代码

    private String isMarket;//是否上市，退市

    private String legalNameCN;//中文法定代表人

    private String legalNameEN;//英文法定代表人

    private String legalPositionCN;//中文职位

    private String legalPositionEN;//英文职位

    private String marketCode;//股票代码

    private String marketDate;//上市日期

    private Integer mcid;//上市地址

    private String paidCapital;//实收资本

    private String paidCurrency;//实收货币

    private String provinceCN;//省份中文名称

    private String provinceEN;//省份英文名称

    private String reg;//工商注册号

    private String regCapital;//注册资金

    private String regCurrency;//注册货币

    private String registrationCN;//注册机构中文

    private String registrationEN;//注册机构英文

    private String streetCN;//街道中文名称

    private String streetEN;//街道英文名称

    private String tax;//税号

    private String usCode;//美国行业代码

    private String zip;//邮编




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }



    public Integer getCpid() {
        return cpid;
    }

    public void setCpid(Integer cpid) {
        this.cpid = cpid;
    }


    public Integer getCsid() {
        return csid;
    }

    public void setCsid(Integer csid) {
        this.csid = csid;
    }

    public Integer getCtid() {
        return ctid;
    }

    public void setCtid(Integer ctid) {
        this.ctid = ctid;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline == null ? null : deadline.trim();
    }




    public Integer getMcid() {
        return mcid;
    }

    public void setMcid(Integer mcid) {
        this.mcid = mcid;
    }


    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg == null ? null : reg.trim();
    }

    public String getBuildingCN() {
        return buildingCN;
    }

    public void setBuildingCN(String buildingCN) {
        this.buildingCN = buildingCN;
    }

    public String getBuildingEN() {
        return buildingEN;
    }

    public void setBuildingEN(String buildingEN) {
        this.buildingEN = buildingEN;
    }

    public String getBusinessScopeCN() {
        return businessScopeCN;
    }

    public void setBusinessScopeCN(String businessScopeCN) {
        this.businessScopeCN = businessScopeCN;
    }

    public String getBusinessScopeEN() {
        return businessScopeEN;
    }

    public void setBusinessScopeEN(String businessScopeEN) {
        this.businessScopeEN = businessScopeEN;
    }

    public String getChnCode() {
        return chnCode;
    }

    public void setChnCode(String chnCode) {
        this.chnCode = chnCode;
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

    public String getCountryCN() {
        return countryCN;
    }

    public void setCountryCN(String countryCN) {
        this.countryCN = countryCN;
    }

    public String getCountryEN() {
        return countryEN;
    }

    public void setCountryEN(String countryEN) {
        this.countryEN = countryEN;
    }

    public String getCrefoNo() {
        return crefoNo;
    }

    public void setCrefoNo(String crefoNo) {
        this.crefoNo = crefoNo;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDistrictCN() {
        return districtCN;
    }

    public void setDistrictCN(String districtCN) {
        this.districtCN = districtCN;
    }

    public String getDistrictEN() {
        return districtEN;
    }

    public void setDistrictEN(String districtEN) {
        this.districtEN = districtEN;
    }

    public String getEstablishDate() {
        return establishDate;
    }

    public void setEstablishDate(String establishDate) {
        this.establishDate = establishDate;
    }

    public String getEuCode() {
        return euCode;
    }

    public void setEuCode(String euCode) {
        this.euCode = euCode;
    }

    public String getIntCode() {
        return intCode;
    }

    public void setIntCode(String intCode) {
        this.intCode = intCode;
    }

    public String getIsMarket() {
        return isMarket;
    }

    public void setIsMarket(String isMarket) {
        this.isMarket = isMarket;
    }

    public String getLegalNameCN() {
        return legalNameCN;
    }

    public void setLegalNameCN(String legalNameCN) {
        this.legalNameCN = legalNameCN;
    }

    public String getLegalNameEN() {
        return legalNameEN;
    }

    public void setLegalNameEN(String legalNameEN) {
        this.legalNameEN = legalNameEN;
    }

    public String getLegalPositionCN() {
        return legalPositionCN;
    }

    public void setLegalPositionCN(String legalPositionCN) {
        this.legalPositionCN = legalPositionCN;
    }

    public String getLegalPositionEN() {
        return legalPositionEN;
    }

    public void setLegalPositionEN(String legalPositionEN) {
        this.legalPositionEN = legalPositionEN;
    }

    public String getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public String getMarketDate() {
        return marketDate;
    }

    public void setMarketDate(String marketDate) {
        this.marketDate = marketDate;
    }

    public String getPaidCapital() {
        return paidCapital;
    }

    public void setPaidCapital(String paidCapital) {
        this.paidCapital = paidCapital;
    }

    public String getPaidCurrency() {
        return paidCurrency;
    }

    public void setPaidCurrency(String paidCurrency) {
        this.paidCurrency = paidCurrency;
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

    public String getRegCapital() {
        return regCapital;
    }

    public void setRegCapital(String regCapital) {
        this.regCapital = regCapital;
    }

    public String getRegCurrency() {
        return regCurrency;
    }

    public void setRegCurrency(String regCurrency) {
        this.regCurrency = regCurrency;
    }

    public String getRegistrationCN() {
        return registrationCN;
    }

    public void setRegistrationCN(String registrationCN) {
        this.registrationCN = registrationCN;
    }

    public String getRegistrationEN() {
        return registrationEN;
    }

    public void setRegistrationEN(String registrationEN) {
        this.registrationEN = registrationEN;
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

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getUsCode() {
        return usCode;
    }

    public void setUsCode(String usCode) {
        this.usCode = usCode;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip == null ? null : zip.trim();
    }
}