package com.mika.credit.common.entity.report.en;

import com.mika.credit.common.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name="BasicInfos")
public class BasicInfos extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	/**
	 * 基本信息(经营基本信息+注册基本信息)
	 * @author Nancy
	 * @date 2016-09-21
	 */
	
	private Integer id;//ID编号
	
	private String crefoNo;//公司内部科氏码
	
	private String updateTime;//更新时间

	private String delFlag;//删除标志 1：正常

	private String businessComName;//公司贸易名

	private String regAddress;//公司注册地址

	private String regHouseNumber;//公司注册地址

	private String regStreet;//公司注册地址

	private String regCity;//注册地址城市

	private Integer fullReportId;//fullReportId

	public Integer getFullReportId() {
		return fullReportId;
	}

	public void setFullReportId(Integer fullReportId) {
		this.fullReportId = fullReportId;
	}

	private String regProvince;//公司注册地址省份

	private String regPostalCode;//公司注册地址邮编

	private String regCountry;//公司注册地址国家

	private String contactTel;//联系电话

	private String contactAddress;//联系地址

	private String contactHouseNumber;//联系地址

	private String contactStreet;//联系地址

	private String contactCity;//联系地址城市

	private String contatctProvince;//联系地址省份
	
	private String contatctCountry;//联系地址国家

	private String contatctPostalCode;//联系地址邮编
	
	private String contatctFax;//联系地址传真

	private String locationStatus;//当地描述

	private String regTel;//地址电话

	private String email;//邮箱

	private String website;//网址

	private String otherAddress;//其他地址

	private String otherHouseNumber;//其他地址

	private String otherStreet;//其他地址

	private String otherCity;//其他地址城市

	private String otherProvice;//其他地址省份

	private String otherPostalCode;//其他地址邮编

	private String otherCountry;//其他地址国家

	private String otherTel;//其他地址电话

	private String regComName;//注册公司名

	private String regForm;//公司属性

	private String regGlobalForm;//

	private String regLocalForm;//

	private String regType;//公司类型

	private String regCode;//注册代码

	private String regDate;//注册日期
	
	private String regCapital;//注册资本
	
	private String deadline;//有效期限
	
	private String vatCode;//税号

	private String vatDate;//建税日期

	private String registry;//工商局

	private String companyStatusCode;//公司状态代码

	private String companyStatusText;//公司状态
	
	private String note;//备注
	
	private String countryCode;//国家代码
	
	private String listedStockExchange;//上市
	
	
	private String shareNum;//股权
	
	private String location;//
	
	
	private String locationDec;//
	
	
	private String regOtherInformation;//注册其他信息
	
	private String regOtherID;
	
	public BasicInfos(){
		
	}
	
	public BasicInfos(Integer id, String crefoNo){
		this.id = id;
		this.crefoNo = crefoNo;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanyStatusCode() {
		return companyStatusCode;
	}

	public void setCompanyStatusCode(String companyStatusCode) {
		this.companyStatusCode = companyStatusCode;
	}

	public String getCompanyStatusText() {
		return companyStatusText;
	}

	public void setCompanyStatusText(String companyStatusText) {
		this.companyStatusText = companyStatusText;
	}

	public String getBusinessComName() {
		return businessComName;
	}


	public void setBusinessComName(String businessComName) {
		this.businessComName = businessComName;
	}


	public String getRegAddress() {
		return regAddress;
	}


	public void setRegAddress(String regAddress) {
		this.regAddress = regAddress;
	}


	public String getRegHouseNumber() {
		return regHouseNumber;
	}


	public void setRegHouseNumber(String regHouseNumber) {
		this.regHouseNumber = regHouseNumber;
	}


	public String getRegStreet() {
		return regStreet;
	}


	public void setRegStreet(String regStreet) {
		this.regStreet = regStreet;
	}


	public String getRegCity() {
		return regCity;
	}


	public void setRegCity(String regCity) {
		this.regCity = regCity;
	}


	public String getRegProvince() {
		return regProvince;
	}


	public void setRegProvince(String regProvince) {
		this.regProvince = regProvince;
	}


	public String getRegPostalCode() {
		return regPostalCode;
	}


	public void setRegPostalCode(String regPostalCode) {
		this.regPostalCode = regPostalCode;
	}


	public String getRegCountry() {
		return regCountry;
	}


	public void setRegCountry(String regCountry) {
		this.regCountry = regCountry;
	}


	public String getContactTel() {
		return contactTel;
	}


	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}


	public String getContactAddress() {
		return contactAddress;
	}


	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}


	public String getContactHouseNumber() {
		return contactHouseNumber;
	}


	public void setContactHouseNumber(String contactHouseNumber) {
		this.contactHouseNumber = contactHouseNumber;
	}


	public String getContactStreet() {
		return contactStreet;
	}


	public void setContactStreet(String contactStreet) {
		this.contactStreet = contactStreet;
	}


	public String getContactCity() {
		return contactCity;
	}


	public void setContactCity(String contactCity) {
		this.contactCity = contactCity;
	}


	public String getContatctProvince() {
		return contatctProvince;
	}


	public void setContatctProvince(String contatctProvince) {
		this.contatctProvince = contatctProvince;
	}


	public String getContatctPostalCode() {
		return contatctPostalCode;
	}


	public void setContatctPostalCode(String contatctPostalCode) {
		this.contatctPostalCode = contatctPostalCode;
	}


	


	public String getLocationStatus() {
		return locationStatus;
	}

	public void setLocationStatus(String locationStatus) {
		this.locationStatus = locationStatus;
	}

	public String getRegTel() {
		return regTel;
	}


	public void setRegTel(String regTel) {
		this.regTel = regTel;
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


	public String getOtherAddress() {
		return otherAddress;
	}


	public void setOtherAddress(String otherAddress) {
		this.otherAddress = otherAddress;
	}


	public String getOtherHouseNumber() {
		return otherHouseNumber;
	}


	public void setOtherHouseNumber(String otherHouseNumber) {
		this.otherHouseNumber = otherHouseNumber;
	}


	public String getOtherStreet() {
		return otherStreet;
	}


	public void setOtherStreet(String otherStreet) {
		this.otherStreet = otherStreet;
	}


	public String getOtherCity() {
		return otherCity;
	}


	public void setOtherCity(String otherCity) {
		this.otherCity = otherCity;
	}


	public String getOtherProvice() {
		return otherProvice;
	}


	public void setOtherProvice(String otherProvice) {
		this.otherProvice = otherProvice;
	}


	public String getOtherPostalCode() {
		return otherPostalCode;
	}


	public void setOtherPostalCode(String otherPostalCode) {
		this.otherPostalCode = otherPostalCode;
	}


	public String getOtherCountry() {
		return otherCountry;
	}


	public void setOtherCountry(String otherCountry) {
		this.otherCountry = otherCountry;
	}


	public String getOtherTel() {
		return otherTel;
	}


	public void setOtherTel(String otherTel) {
		this.otherTel = otherTel;
	}


	public String getRegComName() {
		return regComName;
	}


	public void setRegComName(String regComName) {
		this.regComName = regComName;
	}


	public String getRegForm() {
		return regForm;
	}


	public void setRegForm(String regForm) {
		this.regForm = regForm;
	}


	public String getRegGlobalForm() {
		return regGlobalForm;
	}


	public void setRegGlobalForm(String regGlobalForm) {
		this.regGlobalForm = regGlobalForm;
	}


	public String getRegLocalForm() {
		return regLocalForm;
	}


	public void setRegLocalForm(String regLocalForm) {
		this.regLocalForm = regLocalForm;
	}


	public String getRegType() {
		return regType;
	}


	public void setRegType(String regType) {
		this.regType = regType;
	}


	public String getRegCode() {
		return regCode;
	}


	public void setRegCode(String regCode) {
		this.regCode = regCode;
	}


	public String getRegDate() {
		return regDate;
	}


	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}


	public String getVatCode() {
		return vatCode;
	}


	public void setVatCode(String vatCode) {
		this.vatCode = vatCode;
	}


	public String getVatDate() {
		return vatDate;
	}


	public void setVatDate(String vatDate) {
		this.vatDate = vatDate;
	}


	public String getRegistry() {
		return registry;
	}


	public void setRegistry(String registry) {
		this.registry = registry;
	}



	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public String getCrefoNo() {
		return crefoNo;
	}


	public void setCrefoNo(String crefoNo) {
		this.crefoNo = crefoNo;
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

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getListedStockExchange() {
		return listedStockExchange;
	}

	public void setListedStockExchange(String listedStockExchange) {
		this.listedStockExchange = listedStockExchange;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getRegCapital() {
		return regCapital;
	}

	public void setRegCapital(String regCapital) {
		this.regCapital = regCapital;
	}

	public String getShareNum() {
		return shareNum;
	}

	public void setShareNum(String shareNum) {
		this.shareNum = shareNum;
	}

	

	public String getLocationDec() {
		return locationDec;
	}

	public void setLocationDec(String locationDec) {
		this.locationDec = locationDec;
	}

	public String getContatctCountry() {
		return contatctCountry;
	}

	public void setContatctCountry(String contatctCountry) {
		this.contatctCountry = contatctCountry;
	}

	public String getContatctFax() {
		return contatctFax;
	}

	public void setContatctFax(String contatctFax) {
		this.contatctFax = contatctFax;
	}

	public String getRegOtherInformation() {
		return regOtherInformation;
	}

	public void setRegOtherInformation(String regOtherInformation) {
		this.regOtherInformation = regOtherInformation;
	}

	public String getRegOtherID() {
		return regOtherID;
	}

	public void setRegOtherID(String regOtherID) {
		this.regOtherID = regOtherID;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
