package com.mika.credit.common.entity.report.en;

import com.mika.credit.common.entity.BaseEntity;


public class BankInfos extends BaseEntity{

	/**
	 * 银行信息
	 * @author Nancy
	 * @date 2016-09-27
	 */
	private static final long serialVersionUID = 1L;
	

	private Integer id;//ID编号
	
	private String name;//银行名称
	
	private String bankCode;//银行代码
	
	private String address;//地址

	private String houseNumber;//地址

	private String street;//地址

	private String city;//地址

	private String province;//地址

	private String postalCode;//邮编


	private String crefoNo;//公司内部科氏码
	
	private String updateTime;//更新时间
	
	private String delFlag;//删除标志 1：正常


	private Integer fullReportId;//关联企业信息的唯一标识

	public Integer getFullReportId() {
		return fullReportId;
	}

	public void setFullReportId(Integer fullReportId) {
		this.fullReportId = fullReportId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
