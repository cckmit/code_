package com.mika.credit.common.entity.report.cn;


import com.mika.credit.common.entity.BaseEntity;
import com.mika.credit.common.util.DateUtil;
/**
 * 执行公告
 * @author ZhuJun，ShenYi.
 * Created on  2015-11-1.
 */
public class Executive  extends BaseEntity {
	/**
	 * ID编号
	 */
	private Integer id;
	/**
	 *立案时间
	 */
	private String sortTime;
	/**
	 *内容
	 */
	private String body;
	/**
	 *内容EN
	 */
	private String bodyEN;
	/**
	 *标题
	 */
	private String title;
	/**
	 *执行状态
	 */
	private String status;
	/**
	 *申请人
	 */
	private String applyName;
	/**
	 *组织机构代码
	 */
	private String organizerCode;
	/**
	 *企业（机构）名称EN
	 */
	private String entNameCN;
	/**
	 *企业（机构）名称EN
	 */
	private String entNameEN;
	/**
	 *被执行人姓名CN
	 */
	private String enforceNameCN;
	/**
	 *被执行人姓名EN
	 */
	private String enforceNameEN;
	/**
	 *执行法院名称CN
	 */
	private String enterpriseCourtNameCN;
	//private String entCourtNameCN;
	/**
	 *执行法院名称EN
	 */
	private String enterpriseCourtNameEN;
	//private String entCourtNameEN;
	/**
	 *案号CN
	 */
	private String docketNoCN;
	/**
	 *案号EN
	 */
	private String docketNoEN;
	/**
	 *案件状态CN
	 */
	private String caseStatusCN;
	/**
	 *案件状态EN
	 */
	private String caseStatusEN;
	/**
	 *
	 */
	private String amount;//执行标的
	/**
	 *执行标的货币单位
	 */
	private String currencyId;
	/**
	 *删除标识
	 */
	private String delFlag;
	/**
	 *科氏号码
	 */
	private String crefoNo;
	/**
	 *工商导入选中
	 */
	private String childCheck;
	/**
	 *执行公告id
	 */
	private String zxggId;
	/**
	 *更新时间
	 */
	private String updateTime;
	/**
	 *执行标的货币单位
	 */
	private String currencyUnitCN;
	/**
	 *执行标的货币单位
	 */
	private String currencyUnitEN;
	/**
	 *关联企业信息的唯一标识
	 */
	private Integer fullReportId;


	private  String enterpriseNameCN;

	private  String enterpriseNameEN;


	public Executive() {
		this.updateTime = DateUtil.getCurrentDate();
	}

	
	/*@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)*/

	public String getEntNameCN() {
		return entNameCN;
	}

	public void setEntNameCN(String entNameCN) {
		this.entNameCN = entNameCN;
	}

	public String getEntNameEN() {
		return entNameEN;
	}

	public void setEntNameEN(String entNameEN) {
		this.entNameEN = entNameEN;
	}

	public String getEnforceNameCN() {
		return enforceNameCN;
	}

	public void setEnforceNameCN(String enforceNameCN) {
		this.enforceNameCN = enforceNameCN;
	}

	public String getEnforceNameEN() {
		return enforceNameEN;
	}

	public void setEnforceNameEN(String enforceNameEN) {
		this.enforceNameEN = enforceNameEN;
	}

	//public String getEntCourtNameCN() {
	//	return entCourtNameCN;
	//}
    //
	//public void setEntCourtNameCN(String entCourtNameCN) {
	//	this.entCourtNameCN = entCourtNameCN;
	//}
    //
	//public String getEntCourtNameEN() {
	//	return entCourtNameEN;
	//}
    //
	//public void setEntCourtNameEN(String entCourtNameEN) {
	//	this.entCourtNameEN = entCourtNameEN;
	//}


	public String getEnterpriseCourtNameCN() {
		return enterpriseCourtNameCN;
	}

	public void setEnterpriseCourtNameCN(String enterpriseCourtNameCN) {
		this.enterpriseCourtNameCN = enterpriseCourtNameCN;
	}

	public String getEnterpriseCourtNameEN() {
		return enterpriseCourtNameEN;
	}

	public void setEnterpriseCourtNameEN(String enterpriseCourtNameEN) {
		this.enterpriseCourtNameEN = enterpriseCourtNameEN;
	}

	public String getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getSortTime() {
		return sortTime;
	}

	public void setSortTime(String sortTime) {
		this.sortTime = sortTime;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getApplyName() {
		return applyName;
	}

	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}

	public String getOrganizerCode() {
		return organizerCode;
	}

	public void setOrganizerCode(String organizerCode) {
		this.organizerCode = organizerCode;
	}

	public String getBodyEN() {
		return bodyEN;
	}

	public void setBodyEN(String bodyEN) {
		this.bodyEN = bodyEN;
	}

	public String getDocketNoCN() {
		return docketNoCN;
	}

	public void setDocketNoCN(String docketNoCN) {
		this.docketNoCN = docketNoCN;
	}

	public String getDocketNoEN() {
		return docketNoEN;
	}

	public void setDocketNoEN(String docketNoEN) {
		this.docketNoEN = docketNoEN;
	}

	public String getCaseStatusCN() {
		return caseStatusCN;
	}

	public void setCaseStatusCN(String caseStatusCN) {
		this.caseStatusCN = caseStatusCN;
	}

	public String getCaseStatusEN() {
		return caseStatusEN;
	}

	public void setCaseStatusEN(String caseStatusEN) {
		this.caseStatusEN = caseStatusEN;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
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

	public String getChildCheck() {
		return childCheck;
	}

	public void setChildCheck(String childCheck) {
		this.childCheck = childCheck;
	}

	public String getZxggId() {
		return zxggId;
	}

	public void setZxggId(String zxggId) {
		this.zxggId = zxggId;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getCurrencyUnitCN() {
		return currencyUnitCN;
	}

	public void setCurrencyUnitCN(String currencyUnitCN) {
		this.currencyUnitCN = currencyUnitCN;
	}

	public String getCurrencyUnitEN() {
		return currencyUnitEN;
	}

	public void setCurrencyUnitEN(String currencyUnitEN) {
		this.currencyUnitEN = currencyUnitEN;
	}

	public Integer getFullReportId() {
		return fullReportId;
	}

	public void setFullReportId(Integer fullReportId) {
		this.fullReportId = fullReportId;
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
}