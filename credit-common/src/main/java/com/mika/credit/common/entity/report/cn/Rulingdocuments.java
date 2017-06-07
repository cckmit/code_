package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;
import com.mika.credit.common.util.DateUtil;


/**
 * 裁判文书
 * @author ZhuJun，ShenYi.
 * Created on 2015-11-1.
 */
public class Rulingdocuments extends BaseEntity {
	/**
	 * ID编号
	 */
	private Integer id;
	/**
	 *文书标题
	 */
	private String titleCN;
	/**
	 *文书标题
	 */
	private String titleEN;
	/**
	 *案号CN
	 */
	private String docketNoCN;
	/**
	 *案号EN
	 */
	private String docketNoEN;
	/**
	 *执行法院名称   entCourtNameCN
	 */
	private String courtNameCN;
	/**
	 *执行法院名称   entCourtNameEN
	 */
	private String courtNameEN;
	/**
	 *公告时间
	 */
	private String sortTime;
	/**
	 *案件类型		casetypeCN
	 */
	private String caseTypeCN;
	/**
	 *案件类型英文		casetypeEN
	 */
	private String caseTypeEN;
	/**
	 *原告
	 */
	private String plaintiffCN;
	/**
	 *原告
	 */
	private String plaintiffEN;
	/**
	 *被告
	 */
	private String defendantCN;
	/**
	 *被告
	 */
	private String defendantEN;
	/**
	 *案件状态
	 */
	private String caseStatusCN;
	/**
	 *案件状态
	 */
	private String caseStatusEN;
	/**
	 *执行标的
	 */
	private String amount;
	/**
	 *执行标的货币单位		cid
	 */
	private String currencyId;
	/**
	 *执行标的货币单位
	 */
	private String currencyUnit;
	/**
	 *执行标的货币单位
	 */
	private String currencyUnitEN;
	/**
	 *中文备注
	 */
	private String noteCN;
	/**
	 *英文备注
	 */
	private String noteEN;
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
	 *裁判文书id
	 */
	private String cpwsId;
	/**
	 *文书内容
	 */
	private String content;
	/**
	 *案由编码
	 */
	private String caseCauseId;
	/**
	 *审判员
	 */
	private String judge;
	/**
	 *判决结果
	 */
	private String judgeResult;
	/**
	 *案由
	 */
	private String caseCause;
	/**
	 *案由编码类型 anyouType
	 */
	private String caseCauseType;
	/**
	 *依据
	 */
	private String reason;
	/**
	 *法院等级
	 */
	private String courtRank;
	/**
	 *审理程序
	 */
	private String trialProcedure;
	/**
	 *更新时间
	 */
	private String updateTime;
	/**
	 *执行标的货币单位
	 */
	private String performingMonetaryUnit ;
	/**
	 *关联企业信息的唯一标识
	 */
	private Integer fullReportId;

	public Rulingdocuments() {
		this.updateTime = DateUtil.getCurrentDate();
	}

	/*@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)*/

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitleCN() {
		return titleCN;
	}

	public void setTitleCN(String titleCN) {
		this.titleCN = titleCN;
	}

	public String getTitleEN() {
		return titleEN;
	}

	public void setTitleEN(String titleEN) {
		this.titleEN = titleEN;
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


	public String getPlaintiffCN() {
		return plaintiffCN;
	}

	public void setPlaintiffCN(String plaintiffCN) {
		this.plaintiffCN = plaintiffCN;
	}

	public String getPlaintiffEN() {
		return plaintiffEN;
	}

	public void setPlaintiffEN(String plaintiffEN) {
		this.plaintiffEN = plaintiffEN;
	}

	public String getDefendantCN() {
		return defendantCN;
	}

	public void setDefendantCN(String defendantCN) {
		this.defendantCN = defendantCN;
	}

	public String getDefendantEN() {
		return defendantEN;
	}

	public void setDefendantEN(String defendantEN) {
		this.defendantEN = defendantEN;
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

	public String getCpwsId() {
		return cpwsId;
	}

	public void setCpwsId(String cpwsId) {
		this.cpwsId = cpwsId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getJudge() {
		return judge;
	}

	public void setJudge(String judge) {
		this.judge = judge;
	}

	public String getJudgeResult() {
		return judgeResult;
	}

	public void setJudgeResult(String judgeResult) {
		this.judgeResult = judgeResult;
	}

	public String getCaseCause() {
		return caseCause;
	}

	public void setCaseCause(String caseCause) {
		this.caseCause = caseCause;
	}

	public String getCourtNameCN() {
		return courtNameCN;
	}

	public void setCourtNameCN(String courtNameCN) {
		this.courtNameCN = courtNameCN;
	}

	public String getCourtNameEN() {
		return courtNameEN;
	}

	public void setCourtNameEN(String courtNameEN) {
		this.courtNameEN = courtNameEN;
	}

	public String getSortTime() {
		return sortTime;
	}

	public void setSortTime(String sortTime) {
		this.sortTime = sortTime;
	}

	public String getCaseTypeCN() {
		return caseTypeCN;
	}

	public void setCaseTypeCN(String caseTypeCN) {
		this.caseTypeCN = caseTypeCN;
	}

	public String getCaseTypeEN() {
		return caseTypeEN;
	}

	public void setCaseTypeEN(String caseTypeEN) {
		this.caseTypeEN = caseTypeEN;
	}

	public String getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}

	public String getCaseCauseId() {
		return caseCauseId;
	}

	public void setCaseCauseId(String caseCauseId) {
		this.caseCauseId = caseCauseId;
	}

	public String getCaseCauseType() {
		return caseCauseType;
	}

	public void setCaseCauseType(String caseCauseType) {
		this.caseCauseType = caseCauseType;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getCourtRank() {
		return courtRank;
	}

	public void setCourtRank(String courtRank) {
		this.courtRank = courtRank;
	}

	public String getTrialProcedure() {
		return trialProcedure;
	}

	public void setTrialProcedure(String trialProcedure) {
		this.trialProcedure = trialProcedure;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getPerformingMonetaryUnit() {
		return performingMonetaryUnit;
	}

	public void setPerformingMonetaryUnit(String performingMonetaryUnit) {
		this.performingMonetaryUnit = performingMonetaryUnit;
	}

	public Integer getFullReportId() {
		return fullReportId;
	}

	public void setFullReportId(Integer fullReportId) {
		this.fullReportId = fullReportId;
	}

	public String getCurrencyUnit() {
		return currencyUnit;
	}

	public void setCurrencyUnit(String currencyUnit) {
		this.currencyUnit = currencyUnit;
	}

	public String getCurrencyUnitEN() {
		return currencyUnitEN;
	}

	public void setCurrencyUnitEN(String currencyUnitEN) {
		this.currencyUnitEN = currencyUnitEN;
	}
}