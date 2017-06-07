package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;
import com.mika.credit.common.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 企业基本信息
 * @author ZhuJun，ShenYi.
 * Created on 2014-03-14.
 */
public class BasicInfos extends BaseEntity {
    /**
     *ID编号
     */
    private Integer id;
    /**
     *公司中文名称
     */
    private String nameCN;
    /**
     *公司英文名称
     */
    private String nameEN;
    /**
     *国家中文名称
     */
    private String countryCN;
    /**
     *国家英文名称
     */
    private String countryEN;
    /**
     *省份中文名称
     */
    private String provinceCN;
    /**
     *省份英文名称
     */
    private String provinceEN;
    /**
     *省级编号
     */
    private Integer provinceCode;
    /**
     *城市中文名称
     */
    private String cityCN;
    /**
     *城市英文名称
     */
    private String cityEN;
    /**
     *城市编号
     */
    private Integer cityCode;
    /**
     *地区中文名称
     */
    private String districtCN;
    /**
     *地区英文名称
     */
    private String districtEN;
    /**
     *地区编号
     */
    private Integer districtCode;
    /**
     *街道中文名称
     */
    private String streetCN;
    /**
     *街道英文名称
     */
    private String streetEN;
    /**
     *大楼中文名称
     */
    private String buildingCN;
    /**
     *大楼英文名称
     */
    private String buildingEN;
    /**
     *科氏号码
     */
    private String crefoNo;
    /**
     *报告等级
     */
    private String level;
    /**
     *国税号
     */
    private String centralTax;
    /**
     *地税号
     */
    private String landTax;
    /**
     *组织机构号
     */
    private String org;
    /**
     *注册号
     */
    private String reg;
    /**
     *电话
     */
    private String tel;
    /**
     *传真
     */
    private String fax;
    /**
     *注册邮编
     */
    private String zip;
    /**
     *经营邮编
     */
    private String manageZip;
    /**
     *邮箱
     */
    private String email;
    /**
     *网站
     */
    private String website;
    /**
     *更新时间
     */
    private String updateTime;
    /**
     *地区编号
     */
    private String areaCode;
    /**
     *地址记录
     */
    private String addressRecordCN;
    /**
     *英文地址记录
     */
    private String addressRecordEN;
    /**
     *电话记录
     */
    private String telRecord;
    /**
     *删除标识
     */
    private String delFlag;

    //其他报告模块零碎
    /**
     *媒体是否存在
     */
    private String isMedia;
    /**
     *历史背景中文
     */
    private String backgroundCN;
    /**
     *历史背景英文
     */
    private String backgroundEN;
    /**
     *诉讼是否存在
     */
    private Integer litigationId;
    /**
     *诉讼记录
     */
    private String litigationInfoCN;
    /**
     *英文诉讼记录
     */
    private String litigationInfoEN;
    /**
     *破产记录
     */
    private String bankRuptcyCN;
    /**
     *破产记录
     */
    private String bankRuptcyEN;
    /**
     *是否有财务
     */
    private String isFinancial;
    /**
     *输出财务
     */
    private String outFinancial;
    /**
     *财务附件
     */
    private String attachFinancial;
    /**
     *是否有行业
     */
    private String isIndustry;
    //private String versionIndustry;//输出版本
    /**
     *行业输出版本 0，公司。1，国标
     */
    private String outIndustry;
    /**
     *行业输出code
     */
    private String outIndustryCode;
    /**
     *更新类型
     */
    private Integer updateType;
    /**
     *在索引使用
     */
    private String flag;
    /**
     *最新财务年份
     */
    private String newFinancialYear;
    /**
     *格兰德订单号
     */
    private String gldorderNumber;
    /**
     *财务是否只有大数 1 是 0 不是
     */
    private String isFinancialNumber;
    /**
     *征信代码
     */
    private String creditCode;
    /**
     * 最后年检年度  导入数据使用  不存入数据库
     */
    private String ancheYear;
    /**
     *企业状态  全球鹰索引使用  不存入数据库
     */
    private String enterpriseStatus;
    /**
     *企业状态  全球鹰索引使用  不存入数据库
     */
    private String enterpriseStatusCN;
    /**
     *企业状态  全球鹰索引使用  不存入数据库
     */
    private String enterpriseStatusEN;
    /**
     *经营现状中文
     */
    private String businessScopeCN;
    /**
     *经营现状英文
     */
    private String businessScopeEN;
    /**
     *索引状态
     */
    private String indexStatus;
    /**
     *报告等级  全球鹰索引使用
     */
    private int levels;
    /**
     *是否更新，用于更新格兰德数据 不存入数据库  false不更新  true更新
     */
    private boolean isUpdate;
    /**
     *关联企业信息的唯一标识
     */
    private Integer fullReportId;

    //内部使用
    private List<String> attachList = new ArrayList<String>();


    public BasicInfos() {
        this.updateTime = DateUtil.getCurrentDate();
    }

    public BasicInfos(Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFullReportId() {
        return fullReportId;
    }

    public void setFullReportId(Integer fullReportId) {
        this.fullReportId = fullReportId;
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

    public String getCrefoNo() {
        return crefoNo;
    }

    public void setCrefoNo(String crefoNo) {
        this.crefoNo = crefoNo;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }


    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getIsMedia() {
        return isMedia;
    }

    public void setIsMedia(String isMedia) {
        this.isMedia = isMedia;
    }

    public String getBackgroundCN() {
        return backgroundCN;
    }

    public void setBackgroundCN(String backgroundCN) {
        this.backgroundCN = backgroundCN;
    }

    public String getBackgroundEN() {
        return backgroundEN;
    }

    public void setBackgroundEN(String backgroundEN) {
        this.backgroundEN = backgroundEN;
    }

    public String getLitigationInfoCN() {
        return litigationInfoCN;
    }

    public void setLitigationInfoCN(String litigationInfoCN) {
        this.litigationInfoCN = litigationInfoCN;
    }

    public String getLitigationInfoEN() {
        return litigationInfoEN;
    }

    public void setLitigationInfoEN(String litigationInfoEN) {
        this.litigationInfoEN = litigationInfoEN;
    }


    public String getIsFinancial() {
        return isFinancial;
    }

    public void setIsFinancial(String isFinancial) {
        this.isFinancial = isFinancial;
    }

    public String getOutFinancial() {
        return outFinancial;
    }

    public void setOutFinancial(String outFinancial) {
        this.outFinancial = outFinancial;
    }


    public String getAttachFinancial() {
        return attachFinancial;
    }

    public void setAttachFinancial(String attachFinancial) {
        this.attachFinancial = attachFinancial;
    }

    public String getIsIndustry() {
        return isIndustry;
    }

    public void setIsIndustry(String isIndustry) {
        this.isIndustry = isIndustry;
    }


    public String getOutIndustry() {
        return outIndustry;
    }

    public void setOutIndustry(String outIndustry) {
        this.outIndustry = outIndustry;
    }


    public Integer getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(Integer provinceCode) {
        this.provinceCode = provinceCode;
    }


    public Integer getCityCode() {
        return cityCode;
    }

    public void setCityCode(Integer cityCode) {
        this.cityCode = cityCode;
    }


    public Integer getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(Integer districtCode) {
        this.districtCode = districtCode;
    }

    public String getFlag() {
        return flag = "1";
    }

    public void setFlag(String flag) {
        this.flag = "1";
    }


    public String getOutIndustryCode() {
        return outIndustryCode;
    }

    public void setOutIndustryCode(String outIndustryCode) {
        this.outIndustryCode = outIndustryCode;
    }

    public String getGldorderNumber() {
        return gldorderNumber;
    }

    public void setGldorderNumber(String gldorderNumber) {
        this.gldorderNumber = gldorderNumber;
    }


    public String getIsFinancialNumber() {
        return isFinancialNumber;
    }

    public void setIsFinancialNumber(String isFinancialNumber) {
        this.isFinancialNumber = isFinancialNumber;
    }

    public String getCentralTax() {
        return centralTax;
    }

    public void setCentralTax(String centralTax) {
        this.centralTax = centralTax;
    }

    public String getLandTax() {
        return landTax;
    }

    public void setLandTax(String landTax) {
        this.landTax = landTax;
    }

    public String getManageZip() {
        return manageZip;
    }

    public void setManageZip(String manageZip) {
        this.manageZip = manageZip;
    }

    public String getAddressRecordCN() {
        return addressRecordCN;
    }

    public void setAddressRecordCN(String addressRecordCN) {
        this.addressRecordCN = addressRecordCN;
    }

    public String getAddressRecordEN() {
        return addressRecordEN;
    }

    public void setAddressRecordEN(String addressRecordEN) {
        this.addressRecordEN = addressRecordEN;
    }

    public String getTelRecord() {
        return telRecord;
    }

    public void setTelRecord(String telRecord) {
        this.telRecord = telRecord;
    }

    public Integer getLitigationId() {
        return litigationId;
    }

    public void setLitigationId(Integer litigationId) {
        this.litigationId = litigationId;
    }

    public String getBankRuptcyCN() {
        return bankRuptcyCN;
    }

    public void setBankRuptcyCN(String bankRuptcyCN) {
        this.bankRuptcyCN = bankRuptcyCN;
    }

    public String getBankRuptcyEN() {
        return bankRuptcyEN;
    }

    public void setBankRuptcyEN(String bankRuptcyEN) {
        this.bankRuptcyEN = bankRuptcyEN;
    }

    public Integer getUpdateType() {
        return updateType;
    }

    public void setUpdateType(Integer updateType) {
        this.updateType = updateType;
    }

    public String getNewFinancialYear() {
        return newFinancialYear;
    }

    public void setNewFinancialYear(String newFinancialYear) {
        this.newFinancialYear = newFinancialYear;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getAncheYear() {
        return ancheYear;
    }

    public void setAncheYear(String ancheYear) {
        this.ancheYear = ancheYear;
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus;
    }

    public String getEnterpriseStatusCN() {
        return enterpriseStatusCN;
    }

    public void setEnterpriseStatusCN(String enterpriseStatusCN) {
        this.enterpriseStatusCN = enterpriseStatusCN;
    }

    public String getEnterpriseStatusEN() {
        return enterpriseStatusEN;
    }

    public void setEnterpriseStatusEN(String enterpriseStatusEN) {
        this.enterpriseStatusEN = enterpriseStatusEN;
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

    public String getIndexStatus() {
        return indexStatus;
    }

    public void setIndexStatus(String indexStatus) {
        this.indexStatus = indexStatus;
    }

    public int getLevels() {
        return levels;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }

    public boolean isUpdate() {
        return isUpdate;
    }

    public void setUpdate(boolean update) {
        isUpdate = update;
    }

    public List<String> getAttachList() {
        return attachList;
    }

    public void setAttachList(List<String> attachList) {
        this.attachList = attachList;
    }
}
