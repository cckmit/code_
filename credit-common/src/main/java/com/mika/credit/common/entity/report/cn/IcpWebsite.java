package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;
import com.mika.credit.common.util.DateUtil;

/**
 * 网站
 * @author ZhuJun，ShenYi.
 */
public class IcpWebsite extends BaseEntity {
	/**
	 * ID编号
	 */
	private Integer id;
	/**
	 * 网址
	 */
	private String website;
	/**
	 *注册国别
	 */
	private String registerDifferentCountry;
	/**
	 *网站状态
	 */
	private String websiteStatus;
	/**
	 *网站名称
	 */
	private String websiteName;
	/**
	 *主办单位名称
	 */
	private String organizerName;
	/**
	 *主办单位性质
	 */
	private String organizerNature;
	/**
	 *网站种类
	 */
	private String websiteSpecies;
	/**
	 *许可证号
	 */
	private String licenseKey;
	/**
	 *许可证号
	 */
	private String licenseKeyEN;
	/**
	 *注册人姓名
	 */
	private String registerName;
	/**
	 *联系电话
	 */
	private String contactTel;
	/**
	 *联系地址
	 */
	private String contactAdd;
	/**
	 *注册邮箱
	 */
	private String registerEmail;
	/**
	 *域名年龄
	 */
	private String domainAge;
	/**
	 *注册时间
	 */
	private String registrationTime;
	/**
	 *到期时间
	 */
	private String maturityTime;
	/**
	 *其他信息
	 */
	private String otherInfo;
	/**
	 *信息来源
	 */
	private String infoSource;
	/**
	 *链接
	 */
	private String link;
	/**
	 *获取日期
	 */
	private String getDate;
	/**
	 *更新日期
	 */
	private String updDate;
	/**
	 *科室号码
	 */
	private String crefoNo;
	/**
	 *更新时间
	 */
	private String updateTime;
	/**
	 *关联企业信息的唯一标识
	 */
	private Integer fullReportId;

	public IcpWebsite() {
		this.updateTime = DateUtil.getCurrentDate();
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getRegisterDifferentCountry() {
		return registerDifferentCountry;
	}

	public void setRegisterDifferentCountry(String registerDifferentCountry) {
		this.registerDifferentCountry = registerDifferentCountry;
	}

	public String getWebsiteStatus() {
		return websiteStatus;
	}

	public void setWebsiteStatus(String websiteStatus) {
		this.websiteStatus = websiteStatus;
	}

	public String getWebsiteName() {
		return websiteName;
	}

	public void setWebsiteName(String websiteName) {
		this.websiteName = websiteName;
	}

	public String getOrganizerName() {
		return organizerName;
	}

	public void setOrganizerName(String organizerName) {
		this.organizerName = organizerName;
	}

	public String getOrganizerNature() {
		return organizerNature;
	}

	public void setOrganizerNature(String organizerNature) {
		this.organizerNature = organizerNature;
	}

	public String getWebsiteSpecies() {
		return websiteSpecies;
	}

	public void setWebsiteSpecies(String websiteSpecies) {
		this.websiteSpecies = websiteSpecies;
	}

	public String getLicenseKey() {
		return licenseKey;
	}

	public void setLicenseKey(String licenseKey) {
		this.licenseKey = licenseKey;
	}

	public String getRegisterName() {
		return registerName;
	}

	public void setRegisterName(String registerName) {
		this.registerName = registerName;
	}

	public String getContactTel() {
		return contactTel;
	}

	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	public String getContactAdd() {
		return contactAdd;
	}

	public void setContactAdd(String contactAdd) {
		this.contactAdd = contactAdd;
	}

	public String getRegisterEmail() {
		return registerEmail;
	}

	public void setRegisterEmail(String registerEmail) {
		this.registerEmail = registerEmail;
	}

	public String getDomainAge() {
		return domainAge;
	}

	public void setDomainAge(String domainAge) {
		this.domainAge = domainAge;
	}

	public String getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(String registrationTime) {
		this.registrationTime = registrationTime;
	}

	public String getMaturityTime() {
		return maturityTime;
	}

	public void setMaturityTime(String maturityTime) {
		this.maturityTime = maturityTime;
	}

	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	public String getInfoSource() {
		return infoSource;
	}

	public void setInfoSource(String infoSource) {
		this.infoSource = infoSource;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getGetDate() {
		return getDate;
	}

	public void setGetDate(String getDate) {
		this.getDate = getDate;
	}

	public String getUpdDate() {
		return updDate;
	}

	public void setUpdDate(String updDate) {
		this.updDate = updDate;
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

	public Integer getFullReportId() {
		return fullReportId;
	}

	public void setFullReportId(Integer fullReportId) {
		this.fullReportId = fullReportId;
	}

	public String getLicenseKeyEN() {
		return licenseKeyEN;
	}

	public void setLicenseKeyEN(String licenseKeyEN) {
		this.licenseKeyEN = licenseKeyEN;
	}
}
