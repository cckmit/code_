package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;
import com.mika.credit.common.util.DateUtil;

/**
 * 法人对外投资信息
 * @author ZhuJun，ShenYi.
 * Created on  2015-10-21.
 */

public class Frinvinfos  extends BaseEntity {
	/**
	 * ID编号
	 */
	private Integer id;
	/**
	 *法定代表人姓名CN
	 */
	private String nameCN;
	/**
	 *法定代表人姓名EN
	 */
	private String nameEN;
	/**
	 *企业（机构）名称CN
	 */
	private String enterpriseNameCN;
	/**
	 *企业（机构）名称EN
	 */
	private String enterpriseNameEN;
	/**
	 *注册号
	 */
	private String regNo;
	/**
	 *企业（机构）类型
	 */
	private String enterpriseType;
	/**
	 *企业（机构）类型CN
	 */
	private String enterpriseTypeCN;
	/**
	 *企业（机构）类型EN
	 */
	private String enterpriseTypeEN;
	/**
	 *注册资本（万元）
	 */
	private String regCapital;
	/**
	 *注册资本币种
	 */
	private String regCapitalCurrency;
	/**
	 *注册资本币种CN
	 */
	private String regCapitalCurrencyCN;
	/**
	 *注册资本币种EN
	 */
	private String regCapitalCurrencyEN;
	/**
	 *企业状态
	 */
	private String enterpriseStatus;
	/**
	 *企业状态CN
	 */
	private String enterpriseStatusCN;
	/**
	 *企业状态EN
	 */
	private String enterpriseStatusEN;
	/**
	 *注销日期
	 */
	private String cancelDate;
	/**
	 *吊销日期
	 */
	private String revDate;
	/**
	 *登记机关CN
	 */
	private String regOrgCN;
	/**
	 *登记机关EN
	 */
	private String regOrgEN;
	/**
	 *认缴出资额（万元）
	 */
	private String subconam;
	/**
	 *认缴出资币种
	 */
	private String currency;
	/**
	 *出资方式
	 */
	private String confrom;
	/**
	 *出资比例
	 */
	private String fundedRatio;
	/**
	 *开业日期
	 */
	private String esDate;
	/**
	 *中文地址
	 */
	private String addressCN;
	/**
	 *英文地址
	 */
	private String addressEN;
	/**
	 *删除标识
	 */
	private String delFlag;
	/**
	 *科氏号码
	 */
	private String crefoNo;
	/**
	 *系统已存在公司的crefoNo
	 */
	private String comCrefoNo;
	/**
	 *更新时间
	 */
	private String updateTime;
	/**
	 *关联企业信息的唯一标识
	 */
	private Integer fullReportId;

	// Constructors

	/** default constructor */
	public Frinvinfos() {
		this.updateTime = DateUtil.getCurrentDate();
	}

	/** minimal constructor */
	public Frinvinfos(String crefoNo) {
		this.crefoNo = crefoNo;
	}

	/** full constructor */
	public Frinvinfos(String nameCN, String nameEN, String enterpriseNameCN,
			String enterpriseNameEN, String regNo, String enterpriseType, String regCapital,
			String regCapitalCurrency, String enterpriseStatus, String cancelDate, String revDate,
			String regOrgCN, String regOrgEN, String subconam, String currency,
			String confrom, String fundedRatio, String esDate, String delFlag,
			String crefoNo) {
		this.nameCN = nameCN;
		this.nameEN = nameEN;
		this.enterpriseNameCN = enterpriseNameCN;
		this.enterpriseNameEN = enterpriseNameEN;
		this.regNo = regNo;
		this.enterpriseType = enterpriseType;
		this.regCapital = regCapital;
		this.regCapitalCurrency = regCapitalCurrency;
		this.enterpriseStatus = enterpriseStatus;
		this.cancelDate = cancelDate;
		this.revDate = revDate;
		this.regOrgCN = regOrgCN;
		this.regOrgEN = regOrgEN;
		this.subconam = subconam;
		this.currency = currency;
		this.confrom = confrom;
		this.fundedRatio = fundedRatio;
		this.esDate = esDate;
		this.delFlag = delFlag;
		this.crefoNo = crefoNo;
	}

	

	public Integer getId() {
		return this.id;
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



	public String getRegOrgCN() {
		return regOrgCN;
	}

	public void setRegOrgCN(String regOrgCN) {
		this.regOrgCN = regOrgCN;
	}

	public String getRegOrgEN() {
		return regOrgEN;
	}

	public void setRegOrgEN(String regOrgEN) {
		this.regOrgEN = regOrgEN;
	}

	public String getRegNo() {
		return this.regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getEnterpriseNameCN() {
		return enterpriseNameCN;
	}

	public void setEnterpriseNameCN(String enterpriseNameCN) {
		this.enterpriseNameCN = enterpriseNameCN;
	}

	public String getEnterpriseNameEN() {
		return enterpriseNameEN;
	}

	public void setEnterpriseNameEN(String enterpriseNameEN) {
		this.enterpriseNameEN = enterpriseNameEN;
	}

	public String getEnterpriseType() {
		return enterpriseType;
	}

	public void setEnterpriseType(String enterpriseType) {
		this.enterpriseType = enterpriseType;
	}

	public String getRegCapital() {
		return regCapital;
	}

	public void setRegCapital(String regCapital) {
		this.regCapital = regCapital;
	}

	public String getRegCapitalCurrency() {
		return regCapitalCurrency;
	}

	public void setRegCapitalCurrency(String regCapitalCurrency) {
		this.regCapitalCurrency = regCapitalCurrency;
	}

	public String getEnterpriseStatus() {
		return enterpriseStatus;
	}

	public void setEnterpriseStatus(String enterpriseStatus) {
		this.enterpriseStatus = enterpriseStatus;
	}

	public String getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(String cancelDate) {
		this.cancelDate = cancelDate;
	}

	public String getRevDate() {
		return this.revDate;
	}

	public void setRevDate(String revDate) {
		this.revDate = revDate;
	}



	public String getSubconam() {
		return this.subconam;
	}

	public void setSubconam(String subconam) {
		this.subconam = subconam;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getConfrom() {
		return this.confrom;
	}

	public void setConfrom(String confrom) {
		this.confrom = confrom;
	}

	public String getFundedRatio() {
		return this.fundedRatio;
	}

	public void setFundedRatio(String fundedRatio) {
		this.fundedRatio = fundedRatio;
	}

	public String getEsDate() {
		return this.esDate;
	}

	public void setEsDate(String esDate) {
		this.esDate = esDate;
	}

	public String getDelFlag() {
		return this.delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getCrefoNo() {
		return this.crefoNo;
	}

	public void setCrefoNo(String crefoNo) {
		this.crefoNo = crefoNo;
	}

	public String getAddressCN() {
		return addressCN;
	}

	public void setAddressCN(String addressCN) {
		this.addressCN = addressCN;
	}

	public String getAddressEN() {
		return addressEN;
	}

	public void setAddressEN(String addressEN) {
		this.addressEN = addressEN;
	}

	public String getComCrefoNo() {
		return comCrefoNo;
	}

	public void setComCrefoNo(String comCrefoNo) {
		this.comCrefoNo = comCrefoNo;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getEnterpriseTypeEN() {
		return enterpriseTypeEN;
	}

	public void setEnterpriseTypeEN(String enterpriseTypeEN) {
		this.enterpriseTypeEN = enterpriseTypeEN;
	}

	public String getRegCapitalCurrencyCN() {
		return regCapitalCurrencyCN;
	}

	public void setRegCapitalCurrencyCN(String regCapitalCurrencyCN) {
		this.regCapitalCurrencyCN = regCapitalCurrencyCN;
	}

	public String getRegCapitalCurrencyEN() {
		return regCapitalCurrencyEN;
	}

	public void setRegCapitalCurrencyEN(String regCapitalCurrencyEN) {
		this.regCapitalCurrencyEN = regCapitalCurrencyEN;
	}

	public String getEnterpriseTypeCN() {
		return enterpriseTypeCN;
	}

	public void setEnterpriseTypeCN(String enterpriseTypeCN) {
		this.enterpriseTypeCN = enterpriseTypeCN;
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
}