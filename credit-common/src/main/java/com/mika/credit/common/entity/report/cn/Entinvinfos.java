package com.mika.credit.common.entity.report.cn;



import com.mika.credit.common.entity.BaseEntity;
import com.mika.credit.common.util.DateUtil;

/**
 * 企业对外投资信息
 * @author ZhuJun，ShenYi.
 * Created on  2015-10-21.
 */
public class Entinvinfos extends BaseEntity {
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
	 *企业（机构）类型
	 */
	private String enterpriseTypeCN;
	/**
	 *企业（机构）类型EN
	 */
	private String enterpriseTypeEN;
	/**
	 *注册资本（万元）
	 */
	private String regCap;
	/**
	 *注册资本币种
	 */
	private String regCapCur;
	/**
	 *注册资本币种
	 */
	private String regCapCurCN;
	/**
	 *注册资本币种
	 */
	private String regCapCurEN;
	/**
	 *企业状态CN
	 */
	private String enterpriseStatus;
	/**
	 *企业状态EN
	 */
	private String enterpriseStatusEN;
	/**
	 *注销日期
	 */
	private String canDate;
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
	 *企业状态
	 */
	private String entStatus;
	/**
	 *关联企业信息的唯一标识
	 */
	private Integer fullReportId;

	// Constructors

	/** default constructor */
	public Entinvinfos() {
		this.updateTime = DateUtil.getCurrentDate();
	}

	/** minimal constructor */
	public Entinvinfos(String crefoNo) {
		this.crefoNo = crefoNo;
	}

	/** full constructor */
	public Entinvinfos(String nameCN, String nameEN, String enterpriseNameCN,
			String enterpriseNameEN, String regNo, String enterpriseType, String regCap,
			String regCapCur, String enterpriseStatus, String canDate, String revDate,
			String regOrgCN, String regOrgEN, String subconam, String currency,
			String confrom, String fundedRatio, String esDate, String delFlag,
			String crefoNo) {
		this.nameCN = nameCN;
		this.nameEN = nameEN;
		this.enterpriseNameCN = enterpriseNameCN;
		this.enterpriseNameEN = enterpriseNameEN;
		this.regNo = regNo;
		this.regCap = regCap;
		this.regCapCur = regCapCur;
		this.enterpriseStatus = enterpriseStatus;
		this.canDate = canDate;
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

	// Property accessors


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

	public String getEnterpriseStatus() {
		return enterpriseStatus;
	}

	public void setEnterpriseStatus(String enterpriseStatus) {
		this.enterpriseStatus = enterpriseStatus;
	}


	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}



	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	//todo：字段有问题
	public String getEntType() {
		return enterpriseType;
	}

	public void setEntType(String entType) {
		this.enterpriseType = entType;
	}

	public String getRegCap() {
		return regCap;
	}

	public void setRegCap(String regCap) {
		this.regCap = regCap;
	}

	public String getRegCapCur() {
		return regCapCur;
	}

	public void setRegCapCur(String regCapCur) {
		this.regCapCur = regCapCur;
	}



	public String getCanDate() {
		return canDate;
	}

	public void setCanDate(String canDate) {
		this.canDate = canDate;
	}

	public String getRevDate() {
		return revDate;
	}

	public void setRevDate(String revDate) {
		this.revDate = revDate;
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

	public String getSubconam() {
		return subconam;
	}

	public void setSubconam(String subconam) {
		this.subconam = subconam;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getConfrom() {
		return confrom;
	}

	public void setConfrom(String confrom) {
		this.confrom = confrom;
	}

	public String getFundedRatio() {
		return fundedRatio;
	}

	public void setFundedRatio(String fundedRatio) {
		this.fundedRatio = fundedRatio;
	}

	public String getEsDate() {
		return esDate;
	}

	public void setEsDate(String esDate) {
		this.esDate = esDate;
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


	public Integer getFullReportId() {
		return fullReportId;
	}

	public void setFullReportId(Integer fullReportId) {
		this.fullReportId = fullReportId;
	}

	public String getEnterpriseType() {
		return enterpriseType;
	}

	public void setEnterpriseType(String enterpriseType) {
		this.enterpriseType = enterpriseType;
	}

	public String getEnterpriseTypeEN() {
		return enterpriseTypeEN;
	}

	public void setEnterpriseTypeEN(String enterpriseTypeEN) {
		this.enterpriseTypeEN = enterpriseTypeEN;
	}

	public String getEnterpriseTypeCN() {
		return enterpriseTypeCN;
	}

	public void setEnterpriseTypeCN(String enterpriseTypeCN) {
		this.enterpriseTypeCN = enterpriseTypeCN;
	}

	public String getRegCapCurCN() {
		return regCapCurCN;
	}

	public void setRegCapCurCN(String regCapCurCN) {
		this.regCapCurCN = regCapCurCN;
	}

	public String getRegCapCurEN() {
		return regCapCurEN;
	}

	public void setRegCapCurEN(String regCapCurEN) {
		this.regCapCurEN = regCapCurEN;
	}

	public String getEntStatus() {
		return entStatus;
	}

	public void setEntStatus(String entStatus) {
		this.entStatus = entStatus;
	}

	public String getEnterpriseStatusEN() {
		return enterpriseStatusEN;
	}

	public void setEnterpriseStatusEN(String enterpriseStatusEN) {
		this.enterpriseStatusEN = enterpriseStatusEN;
	}
}