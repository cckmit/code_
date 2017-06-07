package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;


/**
 * 法人其他任职信息
 * @author ZhuJun，ShenYi
 * Created on  2015-10-21.
 */
public class Frpositioninfos extends BaseEntity {

	private static final long serialVersionUID = 1L;
	/**
	 *ID编号
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
	 *注册资本币种
	 */
	private String regCapitalCurrencyCN;
	/**
	 *注册资本币种
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
	 *职务CN
	 */
	private String positionCN;
	/**
	 *职务EN
	 */
	private String positionEN;
	/**
	 *职务
	 */
	private String position;
	/**
	 *是否法定代表人
	 */
	private String lerepslgn;
	/**
	 *开业日期
	 */
	private String esDate;
	/**
	 *删除标识
	 */
	private String delFlag;
	/**
	 *科氏号码
	 */
	private String crefoNo;
	/**
	 *中文地址
	 */
	private String addressCN;
	/**
	 *英文地址
	 */
	private String addressEN;
	/**
	 *系统已存在公司的crefoNo
	 */
	private String comCrefoNo;
	/**
	 *关联企业信息的唯一标识
	 */
	private Integer fullReportId;
	/**
	 *更新时间
	 */
	private String updateTime;
	/**
	 *贡献率CN
	 */
	private String fundedRatioCN;
	/**
	 *贡献率EN
	 */
	private String fundedRatioEN;
	// Constructors

	/** default constructor */
	public Frpositioninfos() {
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

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
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
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}



	public String getRevDate() {
		return revDate;
	}

	public void setRevDate(String revDate) {
		this.revDate = revDate;
	}



	public String getPositionCN() {
		return positionCN;
	}

	public void setPositionCN(String positionCN) {
		this.positionCN = positionCN;
	}

	public String getPositionEN() {
		return positionEN;
	}

	public void setPositionEN(String positionEN) {
		this.positionEN = positionEN;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getLerepslgn() {
		return lerepslgn;
	}

	public void setLerepslgn(String lerepslgn) {
		this.lerepslgn = lerepslgn;
	}

	public String getEsDate() {
		return esDate;
	}

	public void setEsDate(String esDate) {
		this.esDate = esDate;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getCrefoNo() {
		return crefoNo;
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

	public Integer getFullReportId() {
		return fullReportId;
	}

	public void setFullReportId(Integer fullReportId) {
		this.fullReportId = fullReportId;
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

	public String getFundedRatioCN() {
		return fundedRatioCN;
	}

	public void setFundedRatioCN(String fundedRatioCN) {
		this.fundedRatioCN = fundedRatioCN;
	}

	public String getFundedRatioEN() {
		return fundedRatioEN;
	}

	public void setFundedRatioEN(String fundedRatioEN) {
		this.fundedRatioEN = fundedRatioEN;
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