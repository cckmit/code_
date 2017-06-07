package com.mika.credit.common.entity.report.en;

import com.mika.credit.common.entity.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RelatedCompanies")
public class RelatedCompanies extends BaseEntity {
	/**
	 * 关联公司信息
	 * @author Nancy
	 * @date 2016-09-23
	 */
	
	@Id
	@Basic
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;//ID
	
	@Column(name="safeNumber", columnDefinition="varchar(50)")
	private String safeNumber;//safe号码

	@Column(name="country", columnDefinition="varchar(50)")
	private String country;//国家

	@Column(name="name", columnDefinition="varchar(500)")
	private String name;//名称

	@Column(name="type", columnDefinition="varchar(50)")
	private String type;//类型

	private Integer fullReportId;//fullReportId

	public Integer getFullReportId() {
		return fullReportId;
	}

	public void setFullReportId(Integer fullReportId) {
		this.fullReportId = fullReportId;
	}

	@Column(name="status", columnDefinition="varchar(50)")
	private String status;//状态

	@Column(name="regCode", columnDefinition="varchar(50)")
	private String regCode;//注册号码

	@Column(name="vatCode", columnDefinition="varchar(50)")
	private String vatCode;//税号

	@Column(name="address", columnDefinition="varchar(500)")
	private String address;//地址

	@Column(name="houseNumber", columnDefinition="varchar(500)")
	private String houseNumber;//地址

	@Column(name="street", columnDefinition="varchar(100)")
	private String street;//地址

	@Column(name="city", columnDefinition="varchar(100)")
	private String city;//地址

	@Column(name="province", columnDefinition="varchar(100)")
	private String province;//地址	

	@Column(name="postalCode", columnDefinition="varchar(50)")
	private String postalCode;//邮编

	@Column(name="relatedType", columnDefinition="varchar(50)")
	private String relatedType;// 1:Parent Companies – Holding Company 2:Parent Companies – Immediate Company 3:Subsidiary Companies 4:Affiliated Companies

	
	@Column(name="relatedNote", columnDefinition="Text")
	private String relatedNote;//备注
	
	@Column(name="crefoNo", columnDefinition="varchar(50)")
	private String crefoNo;//公司内部科氏码
	
	@Column(name="updateTime", columnDefinition="varchar(50)")
	private String updateTime;//更新时间
	
	@Column(name="delFlag", columnDefinition="varchar(2)")
	private String delFlag;//删除标志 1：正常




	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSafeNumber() {
		return safeNumber;
	}

	public void setSafeNumber(String safeNumber) {
		this.safeNumber = safeNumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRegCode() {
		return regCode;
	}

	public void setRegCode(String regCode) {
		this.regCode = regCode;
	}

	public String getVatCode() {
		return vatCode;
	}

	public void setVatCode(String vatCode) {
		this.vatCode = vatCode;
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

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getRelatedType() {
		return relatedType;
	}

	public void setRelatedType(String relatedType) {
		this.relatedType = relatedType;
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

	public String getRelatedNote() {
		return relatedNote;
	}

	public void setRelatedNote(String relatedNote) {
		this.relatedNote = relatedNote;
	}
	
	
	
	
	
	
	
	

}
