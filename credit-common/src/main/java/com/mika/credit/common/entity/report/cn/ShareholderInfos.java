package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;
import com.mika.credit.common.util.DateUtil;

/**
 * 股东信息
 * @author ZhuJun，ShenYi.
 * Created on 2014-03-14.
 */
public class ShareholderInfos extends BaseEntity {
	/**
	 * ID编号
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
	 *股东类型 0：个人       1：中国企业	2：外国企业	3:  其他
	 */
	private String type;
	/**
	 *股东类型 0：个人       1：中国企业	2：外国企业	3:  其他
	 */
	private String typeCN;
	/**
	 *股东类型 0：个人       1：中国企业	2：外国企业	3:  其他
	 */
	private String typeEN;
	/**
	 *科氏号码
	 */
	private String crefoNo;
	/**
	 *系统已存在公司的crefoNo
	 */
	private String comCrefoNo;
	/**
	 *中文备注
	 */
	private String noteCN;
	/**
	 *英文备注
	 */
	private String noteEN;
	/**
	 *股份
	 */
	private String shares;
	/**
	 *输出版是否显示
	 */
	private String flag;
	/**
	 *删除标识
	 */
	private String delFlag;
	/**
	 *个人身份证
	 */
	private String idCard;
	/**
	 *地址，个人需要CN
	 */
	private String addressCN;
	/**
	 *地址，个人需要EN
	 */
	private String addressEN;
	/**
	 *国家中文名称
	 */
	private String countryCN;
	/**
	 *国家英文名称
	 */
	private String countryEN;
	/**
	 *关联企业信息的唯一标识
	 */
	private Integer fullReportId;
	/**
	 *实缴出资额（万元）
	 */
	private String subconam;
	/**
	 *实缴出资币种
	 */
	private String currency;
	/**
	 *实缴出资币种EN
	 */
	private String currencyEN;
	/**
	 *出资方式	confrom
	 */
	private String contributionFrom;
	/**
	 *出资日期（实缴日期）   condate
	 */
	private String contributionDate;
	//页面需求，用于显示公司信息，数据库不需对应
	/**
	 *注册号
	 */
	private String reg;
	/**
	 *成立日期,注册日期（认缴日期）
	 */
	private String establishDate;
	/**
	 *企业性质		cpid
	 */
	private Integer companyPropertiesId;
	/**
	 *公司状态			csid
	 */
	private Integer companyStatusId;
	/**
	 *注册货币			rcid
	 */
	private Integer registerId;
	/**
	 *股东出资货币		scid
	 */
	private Integer contributionId;
	/**
	 *注册资金
	 */
	private String regCapital;
	/**
	 *经营范围中文
	 */
	private String businessScopeCN;
	/**
	 *经营范围英文
	 */
	private String businessScopeEN;
	/**
	 *企业状态   接口使用 不存入数据库
	 */
	private String entstatus;

	/**
	 *企业状态   接口使用 不存入数据库
	 */
	private String entstatusEN;
	/**
	 *企业性质   接口使用 不存入数据库
	 */
	private String enterprisenature;
	/**
	 *企业性质   接口使用 不存入数据库
	 */
	private String enterprisenatureEN;
	/**
	 *注册货币  接口使用 不存入数据库
	 */
	private String regCurrency;
	/**
	 *注册货币  接口使用 不存入数据库
	 */
	private String regCurrencyEN;
	/**
	 *股东出资货币
	 */
	private String capitalContribution;
	/**
	 *股东出资货币英文
	 */
	private String capitalContributionEN;
	/**
	 *更新时间
	 */
	private String updateTime;

	public ShareholderInfos() {
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getNoteCN() {
		return noteCN;
	}

	public void setNoteCN(String noteCN) {
		this.noteCN = noteCN;
	}

	public String getNoteEN() {
		return noteEN;
	}

	public void setNoteEN(String noteEN) {
		this.noteEN = noteEN;
	}

	public String getShares() {
		return shares;
	}

	public void setShares(String shares) {
		this.shares = shares;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
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

	public Integer getFullReportId() {
		return fullReportId;
	}

	public void setFullReportId(Integer fullReportId) {
		this.fullReportId = fullReportId;
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



	public String getReg() {
		return reg;
	}

	public void setReg(String reg) {
		this.reg = reg;
	}

	public String getEstablishDate() {
		return establishDate;
	}

	public void setEstablishDate(String establishDate) {
		this.establishDate = establishDate;
	}


	public String getRegCapital() {
		return regCapital;
	}

	public void setRegCapital(String regCapital) {
		this.regCapital = regCapital;
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

	public String getEntstatus() {
		return entstatus;
	}

	public void setEntstatus(String entstatus) {
		this.entstatus = entstatus;
	}

	public String getEnterprisenature() {
		return enterprisenature;
	}

	public void setEnterprisenature(String enterprisenature) {
		this.enterprisenature = enterprisenature;
	}

	public String getRegCurrency() {
		return regCurrency;
	}

	public void setRegCurrency(String regCurrency) {
		this.regCurrency = regCurrency;
	}

	public String getCapitalContribution() {
		return capitalContribution;
	}

	public void setCapitalContribution(String capitalContribution) {
		this.capitalContribution = capitalContribution;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getContributionFrom() {
		return contributionFrom;
	}

	public void setContributionFrom(String contributionFrom) {
		this.contributionFrom = contributionFrom;
	}

	public String getContributionDate() {
		return contributionDate;
	}

	public void setContributionDate(String contributionDate) {
		this.contributionDate = contributionDate;
	}

	public Integer getCompanyPropertiesId() {
		return companyPropertiesId;
	}

	public void setCompanyPropertiesId(Integer companyPropertiesId) {
		this.companyPropertiesId = companyPropertiesId;
	}

	public Integer getCompanyStatusId() {
		return companyStatusId;
	}

	public void setCompanyStatusId(Integer companyStatusId) {
		this.companyStatusId = companyStatusId;
	}

	public Integer getRegisterId() {
		return registerId;
	}

	public void setRegisterId(Integer registerId) {
		this.registerId = registerId;
	}

	public Integer getContributionId() {
		return contributionId;
	}

	public void setContributionId(Integer contributionId) {
		this.contributionId = contributionId;
	}


	public String getTypeCN() {
		return typeCN;
	}

	public void setTypeCN(String typeCN) {
		this.typeCN = typeCN;
	}

	public String getTypeEN() {
		return typeEN;
	}

	public void setTypeEN(String typeEN) {
		this.typeEN = typeEN;
	}

	public String getEntstatusEN() {
		return entstatusEN;
	}

	public void setEntstatusEN(String entstatusEN) {
		this.entstatusEN = entstatusEN;
	}

	public String getEnterprisenatureEN() {
		return enterprisenatureEN;
	}

	public void setEnterprisenatureEN(String enterprisenatureEN) {
		this.enterprisenatureEN = enterprisenatureEN;
	}

	public String getRegCurrencyEN() {
		return regCurrencyEN;
	}

	public void setRegCurrencyEN(String regCurrencyEN) {
		this.regCurrencyEN = regCurrencyEN;
	}

	public String getCapitalContributionEN() {
		return capitalContributionEN;
	}

	public void setCapitalContributionEN(String capitalContributionEN) {
		this.capitalContributionEN = capitalContributionEN;
	}

	public String getCurrencyEN() {
		return currencyEN;
	}

	public void setCurrencyEN(String currencyEN) {
		this.currencyEN = currencyEN;
	}
}
