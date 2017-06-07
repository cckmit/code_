package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;
import com.mika.credit.common.util.DateUtil;


/**
 * 注册信息
 * @author ZhuJun，ShenYi
 * Created on 2014-03-14
 */
public class RegistrationInfos  extends BaseEntity {
	/**
	 * ID编号
	 */
	private Integer id;
	/**
	 *公司中文名称
	 */
	private String nameCN;
	/**
	 *公司英文名称  nameCN nameEN 不存入数据库  safe接口使用
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
	 *邮编
	 */
	private String zip;
	/**
	 *科氏号码
	 */
	private String crefoNo;
	/**
	 *企业性质		cpid
	 */
	private Integer companyPropertiesId;
	/**
	 *企业类型		ctid
	 */
	private Integer companyTypesId;
	/**
	 *企业竞争力		cid		competition_id		competitionId
	 */
	private Integer competitionId;
	/**
	 *工商注册号
	 */
	private String reg;
	/**
	 *国税号	centraltax
	 */
	private String centralTax;
	/**
	 *地税号  landtax
	 */
	private String landTax;
	/**
	 *组织结构代码
	 */
	private String org;
	/**
	 *注册机构中文
	 */
	private String registrationCN;
	/**
	 *注册机构英文
	 */
	private String registrationEN;
	/**
	 *中国行业代码
	 */
	private String chnCode;
	/**
	 *美国行业代码
	 */
	private String usCode;
	/**
	 *欧盟行业代码
	 */
	private String euCode;
	/**
	 *国际行业代码
	 */
	private String intCode;
	/**
	 *成立日期//开业日期
	 */
	private String establishDate;
	/**
	 *有效期限CN
	 */
	private String deadline;
	/**
	 *有效期限EN
	 */
	private String deadlineEN;
	/**
	 *注册货币	rcid
	 */
	private Integer regCurrencyId;
	/**
	 *注册货币
	 */
	private String regCurrency;
	/**
	 *注册货币
	 */
	private String regCurrencyEN;
	/**
	 *注册资金
	 */
	private String regCapital;
	/**
	 *注册资金EN
	 */
	private String regCapitalEN;
	/**
	 *增加给财务计算的字段  名字暂时给这个
	 */
	private String regCapitalnote;
	/**
	 *增加给财务计算的字段
	 */
	private String paidCapitalnote;
	/**
	 *注册汇率
	 */
	private String regRate;
	/**
	 *换算后的注册资金
	 */
	private Double regRealCapital;
	/**
	 *实收货币	 pcid
	 */
	private Integer paidCurrencyId;
	/**
	 *实收货币
	 */
	private String paidCurrency;
	/**
	 *实收货币
	 */
	private String paidCurrencyEN;
	/**
	 *实收资本
	 */
	private String paidCapital;
	/**
	 *实收汇率
	 */
	private String paidRate;
	/**
	 *换算后的实收资本
	 */
	private Double paidRealCapital;
	/**
	 *公司状态  csid
	 */
	private Integer companyStatusId;
	/**
	 *是否上市，退市
	 */
	private String isMarket;
	/**
	 *上市地址	  mcid
	 */
	private Integer marketCitiesId;
	/**
	 *上市日期
	 */
	private String marketDate;
	/**
	 *退市日期
	 */
	private String delistDate;
	/**
	 *股票代码
	 */
	private String marketCode;
	/**
	 *中文法定代表人
	 */
	private String legalNameCN;
	/**
	 *英文法定代表人
	 */
	private String legalNameEN;
	/**
	 *中文职位
	 */
	private String legalPositionCN;
	/**
	 *英文职位
	 */
	private String legalPositionEN;
	/**
	 *经营范围中文
	 */
	private String businessScopeCN;
	/**
	 *经验范围英文
	 */
	private String businessScopeEN;
	/**
	 *删除标识
	 */
	private String delFlag;
	/**
	 *省份编号
	 */
	private Integer regProvinceCode;
	/**
	 *城市编号
	 */
	private Integer regCityCode;
	/**
	 *地区编号
	 */
	private Integer regDistrictCode;
	/**
	 *征信代码  creditcode
	 */
	private String creditCode;
	/**
	 *关联企业信息的唯一标识
	 */
	private Integer fullReportId;
	/**
	 *中国行业代码  接口使用  不存入数据库
	 */
	private String chinaIndustrycode;
	/**
	 *企业性质  接口使用 不存入数据库
	 */
	private String entOwnership;
	/**
	 *企业性质EN  接口使用 不存入数据库
	 */
	private String entOwnershipEN;
	/**
	 *上市地址  接口使用 不存入数据库
	 */
	private String marketAddress;
	/**
	 *上市地址EN  接口使用 不存入数据库
	 */
	private String marketAddressEN;
	/**
	 *企业状态中文
	 */
	private String companyStatus;
	/**
	 *企业状态EN
	 */
	private String companyStatusEN;
	/**
	 *企业类型
	 */
	private String companyType;
	/**
	 *企业类型EN
	 */
	private String companyTypeEN;
	/**
	 *企业竞争力
	 */
	private String competitiveness;
	/**
	 *企业竞争力EN
	 */
	private String competitivenessEN;
	/**
	 *更新时间
	 */
	private String updateTime;



	public RegistrationInfos() {
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

	public Integer getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(Integer provinceCode) {
		this.provinceCode = provinceCode;
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

	public Integer getCityCode() {
		return cityCode;
	}

	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
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

	public Integer getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(Integer districtCode) {
		this.districtCode = districtCode;
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

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCrefoNo() {
		return crefoNo;
	}

	public void setCrefoNo(String crefoNo) {
		this.crefoNo = crefoNo;
	}

	public String getReg() {
		return reg;
	}

	public void setReg(String reg) {
		this.reg = reg;
	}


	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public String getRegistrationCN() {
		return registrationCN;
	}

	public void setRegistrationCN(String registrationCN) {
		this.registrationCN = registrationCN;
	}

	public String getRegistrationEN() {
		return registrationEN;
	}

	public void setRegistrationEN(String registrationEN) {
		this.registrationEN = registrationEN;
	}

	public String getChnCode() {
		return chnCode;
	}

	public void setChnCode(String chnCode) {
		this.chnCode = chnCode;
	}

	public String getUsCode() {
		return usCode;
	}

	public void setUsCode(String usCode) {
		this.usCode = usCode;
	}

	public String getEuCode() {
		return euCode;
	}

	public void setEuCode(String euCode) {
		this.euCode = euCode;
	}

	public String getIntCode() {
		return intCode;
	}

	public void setIntCode(String intCode) {
		this.intCode = intCode;
	}

	public String getEstablishDate() {
		return establishDate;
	}

	public void setEstablishDate(String establishDate) {
		this.establishDate = establishDate;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getDeadlineEN() {
		return deadlineEN;
	}

	public void setDeadlineEN(String deadlineEN) {
		this.deadlineEN = deadlineEN;
	}


	public String getRegCurrency() {
		return regCurrency;
	}

	public void setRegCurrency(String regCurrency) {
		this.regCurrency = regCurrency;
	}

	public String getRegCapital() {
		return regCapital;
	}

	public void setRegCapital(String regCapital) {
		this.regCapital = regCapital;
	}

	public String getRegCapitalnote() {
		return regCapitalnote;
	}

	public void setRegCapitalnote(String regCapitalnote) {
		this.regCapitalnote = regCapitalnote;
	}

	public String getPaidCapitalnote() {
		return paidCapitalnote;
	}

	public void setPaidCapitalnote(String paidCapitalnote) {
		this.paidCapitalnote = paidCapitalnote;
	}

	public String getRegRate() {
		return regRate;
	}

	public void setRegRate(String regRate) {
		this.regRate = regRate;
	}

	public Double getRegRealCapital() {
		return regRealCapital;
	}

	public void setRegRealCapital(Double regRealCapital) {
		this.regRealCapital = regRealCapital;
	}


	public String getPaidCurrency() {
		return paidCurrency;
	}

	public void setPaidCurrency(String paidCurrency) {
		this.paidCurrency = paidCurrency;
	}

	public String getPaidCapital() {
		return paidCapital;
	}

	public void setPaidCapital(String paidCapital) {
		this.paidCapital = paidCapital;
	}

	public String getPaidRate() {
		return paidRate;
	}

	public void setPaidRate(String paidRate) {
		this.paidRate = paidRate;
	}

	public Double getPaidRealCapital() {
		return paidRealCapital;
	}

	public void setPaidRealCapital(Double paidRealCapital) {
		this.paidRealCapital = paidRealCapital;
	}

	public String getIsMarket() {
		return isMarket;
	}

	public void setIsMarket(String isMarket) {
		this.isMarket = isMarket;
	}

	public String getMarketDate() {
		return marketDate;
	}

	public void setMarketDate(String marketDate) {
		this.marketDate = marketDate;
	}

	public String getDelistDate() {
		return delistDate;
	}

	public void setDelistDate(String delistDate) {
		this.delistDate = delistDate;
	}

	public String getMarketCode() {
		return marketCode;
	}

	public void setMarketCode(String marketCode) {
		this.marketCode = marketCode;
	}

	public String getLegalNameCN() {
		return legalNameCN;
	}

	public void setLegalNameCN(String legalNameCN) {
		this.legalNameCN = legalNameCN;
	}

	public String getLegalNameEN() {
		return legalNameEN;
	}

	public void setLegalNameEN(String legalNameEN) {
		this.legalNameEN = legalNameEN;
	}

	public String getLegalPositionCN() {
		return legalPositionCN;
	}

	public void setLegalPositionCN(String legalPositionCN) {
		this.legalPositionCN = legalPositionCN;
	}

	public String getLegalPositionEN() {
		return legalPositionEN;
	}

	public void setLegalPositionEN(String legalPositionEN) {
		this.legalPositionEN = legalPositionEN;
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

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public Integer getRegProvinceCode() {
		return regProvinceCode;
	}

	public void setRegProvinceCode(Integer regProvinceCode) {
		this.regProvinceCode = regProvinceCode;
	}

	public Integer getRegCityCode() {
		return regCityCode;
	}

	public void setRegCityCode(Integer regCityCode) {
		this.regCityCode = regCityCode;
	}

	public Integer getRegDistrictCode() {
		return regDistrictCode;
	}

	public void setRegDistrictCode(Integer regDistrictCode) {
		this.regDistrictCode = regDistrictCode;
	}

	public Integer getCompanyPropertiesId() {
		return companyPropertiesId;
	}

	public void setCompanyPropertiesId(Integer companyPropertiesId) {
		this.companyPropertiesId = companyPropertiesId;
	}

	public Integer getCompanyTypesId() {
		return companyTypesId;
	}

	public void setCompanyTypesId(Integer companyTypesId) {
		this.companyTypesId = companyTypesId;
	}

	public Integer getCompetitionId() {
		return competitionId;
	}

	public void setCompetitionId(Integer competitionId) {
		this.competitionId = competitionId;
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

	public Integer getRegCurrencyId() {
		return regCurrencyId;
	}

	public void setRegCurrencyId(Integer regCurrencyId) {
		this.regCurrencyId = regCurrencyId;
	}

	public Integer getPaidCurrencyId() {
		return paidCurrencyId;
	}

	public void setPaidCurrencyId(Integer paidCurrencyId) {
		this.paidCurrencyId = paidCurrencyId;
	}

	public Integer getCompanyStatusId() {
		return companyStatusId;
	}

	public void setCompanyStatusId(Integer companyStatusId) {
		this.companyStatusId = companyStatusId;
	}

	public Integer getMarketCitiesId() {
		return marketCitiesId;
	}

	public void setMarketCitiesId(Integer marketCitiesId) {
		this.marketCitiesId = marketCitiesId;
	}

	public String getCreditCode() {
		return creditCode;
	}

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}

	public Integer getFullReportId() {
		return fullReportId;
	}

	public void setFullReportId(Integer fullReportId) {
		this.fullReportId = fullReportId;
	}

	public String getChinaIndustrycode() {
		return chinaIndustrycode;
	}

	public void setChinaIndustrycode(String chinaIndustrycode) {
		this.chinaIndustrycode = chinaIndustrycode;
	}

	public String getEntOwnership() {
		return entOwnership;
	}

	public void setEntOwnership(String entOwnership) {
		this.entOwnership = entOwnership;
	}

	public String getMarketAddress() {
		return marketAddress;
	}

	public void setMarketAddress(String marketAddress) {
		this.marketAddress = marketAddress;
	}


	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public String getCompanyTypeEN() {
		return companyTypeEN;
	}

	public void setCompanyTypeEN(String companyTypeEN) {
		this.companyTypeEN = companyTypeEN;
	}

	public String getCompetitiveness() {
		return competitiveness;
	}

	public void setCompetitiveness(String competitiveness) {
		this.competitiveness = competitiveness;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getRegCurrencyEN() {
		return regCurrencyEN;
	}

	public void setRegCurrencyEN(String regCurrencyEN) {
		this.regCurrencyEN = regCurrencyEN;
	}

	public String getPaidCurrencyEN() {
		return paidCurrencyEN;
	}

	public void setPaidCurrencyEN(String paidCurrencyEN) {
		this.paidCurrencyEN = paidCurrencyEN;
	}

	public String getEntOwnershipEN() {
		return entOwnershipEN;
	}

	public void setEntOwnershipEN(String entOwnershipEN) {
		this.entOwnershipEN = entOwnershipEN;
	}

	public String getMarketAddressEN() {
		return marketAddressEN;
	}

	public void setMarketAddressEN(String marketAddressEN) {
		this.marketAddressEN = marketAddressEN;
	}

	public String getCompanyStatus() {
		return companyStatus;
	}

	public void setCompanyStatus(String companyStatus) {
		this.companyStatus = companyStatus;
	}

	public String getCompanyStatusEN() {
		return companyStatusEN;
	}

	public void setCompanyStatusEN(String companyStatusEN) {
		this.companyStatusEN = companyStatusEN;
	}

	public String getCompetitivenessEN() {
		return competitivenessEN;
	}

	public void setCompetitivenessEN(String competitivenessEN) {
		this.competitivenessEN = competitivenessEN;
	}

	public String getRegCapitalEN() {
		return regCapitalEN;
	}

	public void setRegCapitalEN(String regCapitalEN) {
		this.regCapitalEN = regCapitalEN;
	}
}
