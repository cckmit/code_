package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;
import com.mika.credit.common.util.DateUtil;

/**
 * 经营现状表
 * @author ZhuJun，ShenYi
 * Created on 2014-03-14
 */
public class Operatings  extends BaseEntity {
	/**
	 * ID编号
	 */
	private Integer id;
	/**
	 * 中文主营描述
	 */
	private String mainDiscriptionCN;
	/**
	 *英文主营描述
	 */
	private String mainDiscriptionEN;
	/**
	 *中文主要产品
	 */
	private String mainProductCN;
	/**
	 *英文主要产品
	 */
	private String mainProductEN;

	public Operatings() {
		this.updateTime = DateUtil.getCurrentDate();
	}

	/**
	 *中文主要专利
	 */
	private String mainPatentCN;
	/**
	 *英文主要专利
	 */
	private String mainPatentEN;
	/**
	 *中文主要商标
	 */
	private String mainBrandCN;
	/**
	 *英文主要商标
	 */
	private String mainBrandEN;
	/**
	 *中文产能规模
	 */
	private String productionCN;
	/**
	 *英文产能规模
	 */
	private String productionEN;
	/**
	 *中文业务1
	 */
	private String activityOneCN;
	/**
	 *中文业务2
	 */
	private String activityTwoCN;
	/**
	 *中文业务3
	 */
	private String activityThreeCN;
	/**
	 *英文业务1
	 */
	private String activityOneEN;
	/**
	 *英文业务2
	 */
	private String activityTwoEN;
	/**
	 *英文业务3
	 */
	private String activityThreeEN;
	/**
	 *中文来自目标公司
	 */
	private String infoCN;
	/**
	 *英文来自目标公司
	 */
	private String infoEN;
	/**
	 *中文国内采购
	 */
	private String purchaseDomesticCN;
	/**
	 *英文国内采购
	 */
	private String purchaseDomesticEN;
	/**
	 *中文国外采购
	 */
	private String purchaseInternationlCN;
	/**
	 *英文国外采购
	 */
	private String purchaseInternationlEN;
	/**
	 *中文国内销售
	 */
	private String saleDomesticCN;
	/**
	 *英文国内销售
	 */
	private String saleDomesticEN;
	/**
	 *中文国际销售
	 */
	private String saleInternationlCN;
	/**
	 *英文国际销售
	 */
	private String saleInternationlEN;
	/**
	 *进口百分比
	 */
	private String imports;
	/**
	 *中文进口地区
	 */
	private String importAreaCN;
	/**
	 *英文进口地区
	 */
	private String importAreaEN;
	/**
	 *出口百分百
	 */
	private String exports;
	/**
	 *中文出口地区
	 */
	private String exportAreaCN;
	/**
	 *英文出口地区
	 */
	private String exportAreaEN;
	/**
	 *
	 */
//	private String customerNum;//海关编号
//	private String clearanceTypeCN;//中文报关类别
//	private String clearanceTypeEN;//英文报关类别
//	private String ccid;//企业管理类别
//	private String regExpirationDate;//注册有效日期
//	private String commentCN;//中文海关评论
//	private String commentEN;//英文海关评论
	/**
	 *中文采购方式
	 */
	private String purchaseTermCN;
	/**
	 *英文采购方式
	 */
	private String purchaseTermEN;
	/**
	 *中文销售方法
	 */
	private String saleTermCN;
	/**
	 *英文销售方法
	 */
	private String saleTermEN;
	/**
	 *中文行业认证
	 */
	private String certificationCN;
	/**
	 *英文行业认证
	 */
	private String certificationEN;
	/**
	 *企业大小
	 */
	private Integer companySizeId;
	/**
	 *企业大小CN
	 */
	private String companySizeCN;
	/**
	 *企业大小EN
	 */
	private String companySizeEN;
	/**
	 *经营企业状态
	 */
	private Integer operationalStatusId;
	/**
	 *中文场地描述
	 */
	private String premiseCN;
	/**
	 *英文场地描述
	 */
	private String premiseEN;
	/**
	 *占地面积
	 */
	private String size;
	/**
	 *地理位置
	 */
	private Integer locationTypeId;
	/**
	 *所有制  0:租用  1:自有  2:无偿使用  3:未知
	 */
	private Integer ownershipId;
	/**
	 *中文当地描述
	 */
	private String locationCN;
	/**
	 *英文当地描述
	 */
	private String locationEN;
//	private String crefoNo;
	/**
	 *删除标识
	 */
	private String delFlag;
	/**
	 *年份
	 */
	private String year;
	/**
	 *员工人数
	 */
	private String employee;
	/**
	 *来自目标公司网站
	 */
	private String discriptionWeb;
	/**
	 *行业认证CN
	 */
	private String industryCertificationCN;
	/**
	 *代理权CN
	 */
	private String dealershipCN;
	/**
	 *行业认证EN
	 */
	private String industryCertificationEN;
	/**
	 *代理权EN
	 */
	private String dealershipEN;
//	private String propertyCN;//产权中文
//	private Integer prid;//产权币种
//	private Integer gdpid;//gdp币种
//	private String gdpLevel;//gdp级别
//	private String propertyEN;//产权英文
//	private String localGDPCN;//当地GDP中文
//	private String localGDPEN;//当地GDP英文
	/**
	 *企业管理类别
	 */
	private String companyTypes;
	/**
	 *经营企业状态
	 */
	private String companyStatus;
	/**
	 *经营企业状态EN
	 */
	private String companyStatusEN;
	/**
	 *地理位置
	 */
	private String position;
	/**
	 *地理位置EN
	 */
	private String positionEN;
//	private String currencyProperty;//产权币种
//	private String gdpProperty;//gdp币种
	/**
	 *企业规模  接口使用 不存入数据库
	 */
	private String enterprisescale;
	/**
	 *地点类型  接口使用 不存入数据库
	 */
	private String locationType;
	/**
	 *地点类型EN  接口使用 不存入数据库
	 */
	private String locationTypeEN;
	/**
	 *所有权  接口使用 不存入数据库    0:租用  1:自有  2:无偿使用  3:未知
	 */
	private String ownership;
	/**
	 *所有权EN  接口使用 不存入数据库    0:租用  1:自有  2:无偿使用  3:未知
	 */
	private String ownershipEN;
	/**
	 *更新时间
	 */
	private String updateTime;
	/**
	 *关联企业信息的唯一标识
	 */
	private Integer fullReportId;


	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCompanySizeId() {
		return companySizeId;
	}

	public void setCompanySizeId(Integer companySizeId) {
		this.companySizeId = companySizeId;
	}

	public Integer getOperationalStatusId() {
		return operationalStatusId;
	}

	public void setOperationalStatusId(Integer operationalStatusId) {
		this.operationalStatusId = operationalStatusId;
	}

	public Integer getLocationTypeId() {
		return locationTypeId;
	}

	public void setLocationTypeId(Integer locationTypeId) {
		this.locationTypeId = locationTypeId;
	}

	public Integer getOwnershipId() {
		return ownershipId;
	}

	public void setOwnershipId(Integer ownershipId) {
		this.ownershipId = ownershipId;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getMainDiscriptionCN() {
		return mainDiscriptionCN;
	}

	public void setMainDiscriptionCN(String mainDiscriptionCN) {
		this.mainDiscriptionCN = mainDiscriptionCN;
	}

	public String getMainDiscriptionEN() {
		return mainDiscriptionEN;
	}

	public void setMainDiscriptionEN(String mainDiscriptionEN) {
		this.mainDiscriptionEN = mainDiscriptionEN;
	}

	public String getMainProductCN() {
		return mainProductCN;
	}

	public void setMainProductCN(String mainProductCN) {
		this.mainProductCN = mainProductCN;
	}

	public String getMainProductEN() {
		return mainProductEN;
	}

	public void setMainProductEN(String mainProductEN) {
		this.mainProductEN = mainProductEN;
	}

	public String getMainPatentCN() {
		return mainPatentCN;
	}

	public void setMainPatentCN(String mainPatentCN) {
		this.mainPatentCN = mainPatentCN;
	}

	public String getMainPatentEN() {
		return mainPatentEN;
	}

	public void setMainPatentEN(String mainPatentEN) {
		this.mainPatentEN = mainPatentEN;
	}

	public String getMainBrandCN() {
		return mainBrandCN;
	}

	public void setMainBrandCN(String mainBrandCN) {
		this.mainBrandCN = mainBrandCN;
	}

	public String getMainBrandEN() {
		return mainBrandEN;
	}

	public void setMainBrandEN(String mainBrandEN) {
		this.mainBrandEN = mainBrandEN;
	}

	public String getProductionCN() {
		return productionCN;
	}

	public void setProductionCN(String productionCN) {
		this.productionCN = productionCN;
	}

	public String getProductionEN() {
		return productionEN;
	}

	public void setProductionEN(String productionEN) {
		this.productionEN = productionEN;
	}

	public String getActivityOneCN() {
		return activityOneCN;
	}

	public void setActivityOneCN(String activityOneCN) {
		this.activityOneCN = activityOneCN;
	}

	public String getActivityTwoCN() {
		return activityTwoCN;
	}

	public void setActivityTwoCN(String activityTwoCN) {
		this.activityTwoCN = activityTwoCN;
	}

	public String getActivityThreeCN() {
		return activityThreeCN;
	}

	public void setActivityThreeCN(String activityThreeCN) {
		this.activityThreeCN = activityThreeCN;
	}

	public String getActivityOneEN() {
		return activityOneEN;
	}

	public void setActivityOneEN(String activityOneEN) {
		this.activityOneEN = activityOneEN;
	}

	public String getActivityTwoEN() {
		return activityTwoEN;
	}

	public void setActivityTwoEN(String activityTwoEN) {
		this.activityTwoEN = activityTwoEN;
	}

	public String getActivityThreeEN() {
		return activityThreeEN;
	}

	public void setActivityThreeEN(String activityThreeEN) {
		this.activityThreeEN = activityThreeEN;
	}

	public String getInfoCN() {
		return infoCN;
	}

	public void setInfoCN(String infoCN) {
		this.infoCN = infoCN;
	}

	public String getInfoEN() {
		return infoEN;
	}

	public void setInfoEN(String infoEN) {
		this.infoEN = infoEN;
	}

	public String getPurchaseDomesticCN() {
		return purchaseDomesticCN;
	}

	public void setPurchaseDomesticCN(String purchaseDomesticCN) {
		this.purchaseDomesticCN = purchaseDomesticCN;
	}

	public String getPurchaseDomesticEN() {
		return purchaseDomesticEN;
	}

	public void setPurchaseDomesticEN(String purchaseDomesticEN) {
		this.purchaseDomesticEN = purchaseDomesticEN;
	}

	public String getPurchaseInternationlCN() {
		return purchaseInternationlCN;
	}

	public void setPurchaseInternationlCN(String purchaseInternationlCN) {
		this.purchaseInternationlCN = purchaseInternationlCN;
	}

	public String getPurchaseInternationlEN() {
		return purchaseInternationlEN;
	}

	public void setPurchaseInternationlEN(String purchaseInternationlEN) {
		this.purchaseInternationlEN = purchaseInternationlEN;
	}

	public String getSaleDomesticCN() {
		return saleDomesticCN;
	}

	public void setSaleDomesticCN(String saleDomesticCN) {
		this.saleDomesticCN = saleDomesticCN;
	}

	public String getSaleDomesticEN() {
		return saleDomesticEN;
	}

	public void setSaleDomesticEN(String saleDomesticEN) {
		this.saleDomesticEN = saleDomesticEN;
	}

	public String getSaleInternationlCN() {
		return saleInternationlCN;
	}

	public void setSaleInternationlCN(String saleInternationlCN) {
		this.saleInternationlCN = saleInternationlCN;
	}

	public String getSaleInternationlEN() {
		return saleInternationlEN;
	}

	public void setSaleInternationlEN(String saleInternationlEN) {
		this.saleInternationlEN = saleInternationlEN;
	}

	public String getImports() {
		return imports;
	}

	public void setImports(String imports) {
		this.imports = imports;
	}

	public String getImportAreaCN() {
		return importAreaCN;
	}

	public void setImportAreaCN(String importAreaCN) {
		this.importAreaCN = importAreaCN;
	}

	public String getImportAreaEN() {
		return importAreaEN;
	}

	public void setImportAreaEN(String importAreaEN) {
		this.importAreaEN = importAreaEN;
	}

	public String getExports() {
		return exports;
	}

	public void setExports(String exports) {
		this.exports = exports;
	}

	public String getExportAreaCN() {
		return exportAreaCN;
	}

	public void setExportAreaCN(String exportAreaCN) {
		this.exportAreaCN = exportAreaCN;
	}

	public String getExportAreaEN() {
		return exportAreaEN;
	}

	public void setExportAreaEN(String exportAreaEN) {
		this.exportAreaEN = exportAreaEN;
	}

//	public String getCustomerNum() {
//		return customerNum;
//	}
//
//	public void setCustomerNum(String customerNum) {
//		this.customerNum = customerNum;
//	}
//
//	public String getClearanceTypeCN() {
//		return clearanceTypeCN;
//	}
//
//	public void setClearanceTypeCN(String clearanceTypeCN) {
//		this.clearanceTypeCN = clearanceTypeCN;
//	}
//
//	public String getClearanceTypeEN() {
//		return clearanceTypeEN;
//	}
//
//	public void setClearanceTypeEN(String clearanceTypeEN) {
//		this.clearanceTypeEN = clearanceTypeEN;
//	}

//	public String getCcid() {
//		return ccid;
//	}
//
//	public void setCcid(String ccid) {
//		this.ccid = ccid;
//	}

//	public String getRegExpirationDate() {
//		return regExpirationDate;
//	}
//
//	public void setRegExpirationDate(String regExpirationDate) {
//		this.regExpirationDate = regExpirationDate;
//	}
//
//	public String getCommentCN() {
//		return commentCN;
//	}
//
//	public void setCommentCN(String commentCN) {
//		this.commentCN = commentCN;
//	}
//
//	public String getCommentEN() {
//		return commentEN;
//	}
//
//	public void setCommentEN(String commentEN) {
//		this.commentEN = commentEN;
//	}

	public String getPurchaseTermCN() {
		return purchaseTermCN;
	}

	public void setPurchaseTermCN(String purchaseTermCN) {
		this.purchaseTermCN = purchaseTermCN;
	}

	public String getPurchaseTermEN() {
		return purchaseTermEN;
	}

	public void setPurchaseTermEN(String purchaseTermEN) {
		this.purchaseTermEN = purchaseTermEN;
	}

	public String getSaleTermCN() {
		return saleTermCN;
	}

	public void setSaleTermCN(String saleTermCN) {
		this.saleTermCN = saleTermCN;
	}

	public String getSaleTermEN() {
		return saleTermEN;
	}

	public void setSaleTermEN(String saleTermEN) {
		this.saleTermEN = saleTermEN;
	}

	public String getCertificationCN() {
		return certificationCN;
	}

	public void setCertificationCN(String certificationCN) {
		this.certificationCN = certificationCN;
	}

	public String getCertificationEN() {
		return certificationEN;
	}

	public void setCertificationEN(String certificationEN) {
		this.certificationEN = certificationEN;
	}

//	public Integer getCsid() {
//		return csid;
//	}
//
//	public void setCsid(Integer csid) {
//		this.csid = csid;
//	}

//	public Integer getPsid() {
//		return psid;
//	}
//
//	public void setPsid(Integer psid) {
//		this.psid = psid;
//	}

	public String getPremiseCN() {
		return premiseCN;
	}

	public void setPremiseCN(String premiseCN) {
		this.premiseCN = premiseCN;
	}

	public String getPremiseEN() {
		return premiseEN;
	}

	public void setPremiseEN(String premiseEN) {
		this.premiseEN = premiseEN;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

//	public Integer getLtid() {
//		return ltid;
//	}
//
//	public void setLtid(Integer ltid) {
//		this.ltid = ltid;
//	}
//
//	public Integer getOid() {
//		return oid;
//	}
//
//	public void setOid(Integer oid) {
//		this.oid = oid;
//	}

	public String getLocationCN() {
		return locationCN;
	}

	public void setLocationCN(String locationCN) {
		this.locationCN = locationCN;
	}

	public String getLocationEN() {
		return locationEN;
	}

	public void setLocationEN(String locationEN) {
		this.locationEN = locationEN;
	}

//	public String getCrefoNo() {
//		return crefoNo;
//	}
//
//	public void setCrefoNo(String crefoNo) {
//		this.crefoNo = crefoNo;
//	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public String getDiscription_web() {
		return discriptionWeb;
	}

	public void setDiscription_web(String discription_web) {
		this.discriptionWeb = discription_web;
	}

	public String getIndustryCertificationCN() {
		return industryCertificationCN;
	}

	public void setIndustryCertificationCN(String industryCertificationCN) {
		this.industryCertificationCN = industryCertificationCN;
	}

	public String getDealershipCN() {
		return dealershipCN;
	}

	public void setDealershipCN(String dealershipCN) {
		this.dealershipCN = dealershipCN;
	}

	public String getIndustryCertificationEN() {
		return industryCertificationEN;
	}

	public void setIndustryCertificationEN(String industryCertificationEN) {
		this.industryCertificationEN = industryCertificationEN;
	}

	public String getDealershipEN() {
		return dealershipEN;
	}

	public void setDealershipEN(String dealershipEN) {
		this.dealershipEN = dealershipEN;
	}

//	public String getPropertyCN() {
//		return propertyCN;
//	}
//
//	public void setPropertyCN(String propertyCN) {
//		this.propertyCN = propertyCN;
//	}
//
//	public Integer getPrid() {
//		return prid;
//	}
//
//	public void setPrid(Integer prid) {
//		this.prid = prid;
//	}
//
//	public Integer getGdpid() {
//		return gdpid;
//	}
//
//	public void setGdpid(Integer gdpid) {
//		this.gdpid = gdpid;
//	}
//
//	public String getGdpLevel() {
//		return gdpLevel;
//	}
//
//	public void setGdpLevel(String gdpLevel) {
//		this.gdpLevel = gdpLevel;
//	}
//
//	public String getPropertyEN() {
//		return propertyEN;
//	}
//
//	public void setPropertyEN(String propertyEN) {
//		this.propertyEN = propertyEN;
//	}
//
//	public String getLocalGDPCN() {
//		return localGDPCN;
//	}
//
//	public void setLocalGDPCN(String localGDPCN) {
//		this.localGDPCN = localGDPCN;
//	}
//
//	public String getLocalGDPEN() {
//		return localGDPEN;
//	}
//
//	public void setLocalGDPEN(String localGDPEN) {
//		this.localGDPEN = localGDPEN;
//	}

	public String getCompanyTypes() {
		return companyTypes;
	}

	public void setCompanyTypes(String companyTypes) {
		this.companyTypes = companyTypes;
	}

	public String getCompanyStatus() {
		return companyStatus;
	}

	public void setCompanyStatus(String companyStatus) {
		this.companyStatus = companyStatus;
	}

//	public String getPosition() {
//		return Position;
//	}
//
//	public void setPosition(String position) {
//		Position = position;
//	}
//
//	public String getCurrencyProperty() {
//		return currencyProperty;
//	}
//
//	public void setCurrencyProperty(String currencyProperty) {
//		this.currencyProperty = currencyProperty;
//	}
//
//	public String getGdpProperty() {
//		return gdpProperty;
//	}
//
//	public void setGdpProperty(String gdpProperty) {
//		this.gdpProperty = gdpProperty;
//	}


	public String getEnterprisescale() {
		return enterprisescale;
	}

	public void setEnterprisescale(String enterprisescale) {
		this.enterprisescale = enterprisescale;
	}

	public String getDiscriptionWeb() {
		return discriptionWeb;
	}

	public void setDiscriptionWeb(String discriptionWeb) {
		this.discriptionWeb = discriptionWeb;
	}

	public String getPositionEN() {
		return positionEN;
	}

	public void setPositionEN(String positionEN) {
		this.positionEN = positionEN;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	public String getLocationTypeEN() {
		return locationTypeEN;
	}

	public void setLocationTypeEN(String locationTypeEN) {
		this.locationTypeEN = locationTypeEN;
	}

	public String getOwnershipEN() {
		return ownershipEN;
	}

	public void setOwnershipEN(String ownershipEN) {
		this.ownershipEN = ownershipEN;
	}

	public String getOwnership() {
		return ownership;
	}

	public void setOwnership(String ownership) {
		this.ownership = ownership;
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

	public String getCompanySizeCN() {
		return companySizeCN;
	}

	public void setCompanySizeCN(String companySizeCN) {
		this.companySizeCN = companySizeCN;
	}

	public String getCompanySizeEN() {
		return companySizeEN;
	}

	public void setCompanySizeEN(String companySizeEN) {
		this.companySizeEN = companySizeEN;
	}

	public String getCompanyStatusEN() {
		return companyStatusEN;
	}

	public void setCompanyStatusEN(String companyStatusEN) {
		this.companyStatusEN = companyStatusEN;
	}
}
