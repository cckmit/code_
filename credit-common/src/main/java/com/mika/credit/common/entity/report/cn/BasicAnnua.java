package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;
import com.mika.credit.common.util.DateUtil;

/**
 * 年报基本信息
 * @author zhujun.
 */
public class BasicAnnua extends BaseEntity {
//	private String creditcode;//统一社会信用代码
	/**
	 *ID编号
	 */
	private Integer id;
	/**
	 *注册号
	 */
	private String reg;
	/**
	 *企业名称
	 */
	private String name;
	/**
	 *企业联系电话企业联系电话
	 */
	private String tel;
	/**
	 *邮政编码
	 */
	private String zip;
	/**
	 *企业通信地址
	 */
	private String address;
	/**
	 *电子邮箱
	 */
	private String email;
	/**
	 *有限责任公司本年度是否发生股东股权转让
	 */
	private String equityTransfer;
	/**
	 *企业经营状态
	 */
	private String enterpriseStatus;
	/**
	 *是否有网站或网店
	 */
	private String isWebsite;
	/**
	 *企业是否有对外投资设立企业信息
	 */
	private String isInvestment;
	/**
	 *从业人数
	 */
	private String employee;
	/**
	 *年报年度
	 */
	private String year;
	/**
	 *科室号码
	 */
	private String crefoNo;
	/**
	 *是否有对外担保信息
	 */
	private String isGuaranteeInfo;
	/**
	 *隶属关系
	 */
	private String affiliation;
	/**
	 *经营者姓名
	 */
	private String operateName;
	/**
	 *资金数额
	 */
	private String fundsMoney;
	/**
	 *更新时间
	 */
	private String updateTime;
	/**
	 *关联企业信息的唯一标识
	 */
	private Integer fullReportId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getReg() {
		return reg;
	}
	public void setReg(String reg) {
		this.reg = reg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Integer getFullReportId() {
		return fullReportId;
	}
	public void setFullReportId(Integer fullReportId) {
		this.fullReportId = fullReportId;
	}

	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEquityTransfer() {
		return equityTransfer;
	}
	public void setEquityTransfer(String equityTransfer) {
		this.equityTransfer = equityTransfer;
	}

	public String getEnterpriseStatus() {
		return enterpriseStatus;
	}

	public void setEnterpriseStatus(String enterpriseStatus) {
		this.enterpriseStatus = enterpriseStatus;
	}

	public String getIsWebsite() {
		return isWebsite;
	}

	public void setIsWebsite(String isWebsite) {
		this.isWebsite = isWebsite;
	}

	public String getIsInvestment() {
		return isInvestment;
	}

	public void setIsInvestment(String isInvestment) {
		this.isInvestment = isInvestment;
	}

	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getCrefoNo() {
		return crefoNo;
	}

	public void setCrefoNo(String crefoNo) {
		this.crefoNo = crefoNo;
	}
	public String getIsGuaranteeInfo() {
		return isGuaranteeInfo;
	}

	public void setIsGuaranteeInfo(String isGuaranteeInfo) {
		this.isGuaranteeInfo = isGuaranteeInfo;
	}
	public String getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}
	public String getOperateName() {
		return operateName;
	}

	public void setOperateName(String operateName) {
		this.operateName = operateName;
	}
	public String getFundsMoney() {
		return fundsMoney;
	}

	public void setFundsMoney(String fundsMoney) {
		this.fundsMoney = fundsMoney;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public BasicAnnua() {
		this.updateTime = DateUtil.getCurrentDate();
	}




}
