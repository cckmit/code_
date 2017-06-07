package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;
import com.mika.credit.common.util.DateUtil;

/**
 * 开庭公告
 * @author ZhuJun，ShenYi.
 * Created on 2016-1-26.
 */
public class Ktgg extends BaseEntity {
	/**
	 * ID编号
	 */
	private Integer id;
	/**
	 * 开庭公告id
	 */
	private String ktggId;
	/**
	 *开庭日期
	 */
	private String sortTime;
	/**
	 *内容
	 */
	private String body;
	/**
	 *内容 英文
	 */
	private String bodyEN;
	/**
	 *原告EN
	 */
	private String plaintiffCN;
	/**
	 *原告EN
	 */
	private String plaintiffEN;
	/**
	 *组织者
	 */
	private String organizer;
	/**
	 *法庭名称CN
	 */
	private String courtroomCN;
	/**
	 *法庭名称EN
	 */
	private String courtroomEN;
	/**
	 *相关当事人
	 */
	private String relatedParty;
	/**
	 *法院名称CN
	 */
	private String courthouseCN;
	/**
	 *法院名称EN
	 */
	private String courthouseEN;
	/**
	 *当事人
	 */
	private String parties;
	/**
	 *标题
	 */
	private String title;
	/**
	 *案由CN
	 */
	private String caseCauseCN;
	/**
	 *案由EN
	 */
	private String caseCauseEN;
	/**
	 *法官CN
	 */
	private String chiefJusticeCN;
	/**
	 *法官EN
	 */
	private String chiefJusticeEN;
	/**
	 *案号CN
	 */
	private String docketNoCN;
	/**
	 *案号EN
	 */
	private String docketNoEN;
	/**
	 *被告CN
	 */
	private String defendantCN;
	/**
	 *被告EN
	 */
	private String defendantEN;
	/**
	 *关联企业信息的唯一标识
	 */
	private Integer fullReportId;
	/**
	 *科氏号码
	 */
	private String crefoNo;
	/**
	 *删除标识
	 */
	private String delFlag;
	/**
	 *工商导入选中
	 */
	private String childCheck;
	/**
	 *中文备注
	 */
	private String noteCN;
	/**
	 *英文备注
	 */
	private String noteEN;
	/**
	 *更新时间
	 */
	private String updateTime;

	



	public Ktgg() {
		this.updateTime = DateUtil.getCurrentDate();
	}	

//	@Id
//	@Basic
//	@Column(name="id")
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
/*	@GenericGenerator(name = "generator", strategy = "increment")
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

	public String getKtggId() {
		return ktggId;
	}

	public void setKtggId(String ktggId) {
		this.ktggId = ktggId;
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

	public String getOrganizer() {
		return organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

	public String getCourtroomCN() {
		return courtroomCN;
	}

	public void setCourtroomCN(String courtroomCN) {
		this.courtroomCN = courtroomCN;
	}

	public String getCourtroomEN() {
		return courtroomEN;
	}

	public void setCourtroomEN(String courtroomEN) {
		this.courtroomEN = courtroomEN;
	}

	public String getRelatedParty() {
		return relatedParty;
	}

	public void setRelatedParty(String relatedParty) {
		this.relatedParty = relatedParty;
	}

	public String getCourthouseCN() {
		return courthouseCN;
	}

	public void setCourthouseCN(String courthouseCN) {
		this.courthouseCN = courthouseCN;
	}

	public String getCourthouseEN() {
		return courthouseEN;
	}

	public void setCourthouseEN(String courthouseEN) {
		this.courthouseEN = courthouseEN;
	}

	public String getParties() {
		return parties;
	}

	public void setParties(String parties) {
		this.parties = parties;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCaseCauseCN() {
		return caseCauseCN;
	}

	public void setCaseCauseCN(String caseCauseCN) {
		this.caseCauseCN = caseCauseCN;
	}

	public String getCaseCauseEN() {
		return caseCauseEN;
	}

	public void setCaseCauseEN(String caseCauseEN) {
		this.caseCauseEN = caseCauseEN;
	}

	public String getChiefJusticeCN() {
		return chiefJusticeCN;
	}

	public void setChiefJusticeCN(String chiefJusticeCN) {
		this.chiefJusticeCN = chiefJusticeCN;
	}

	public String getChiefJusticeEN() {
		return chiefJusticeEN;
	}

	public void setChiefJusticeEN(String chiefJusticeEN) {
		this.chiefJusticeEN = chiefJusticeEN;
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

	public Integer getFullReportId() {
		return fullReportId;
	}

	public void setFullReportId(Integer fullReportId) {
		this.fullReportId = fullReportId;
	}

	public String getCrefoNo() {
		return crefoNo;
	}

	public void setCrefoNo(String crefoNo) {
		this.crefoNo = crefoNo;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getChildCheck() {
		return childCheck;
	}

	public void setChildCheck(String childCheck) {
		this.childCheck = childCheck;
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

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getBodyEN() {
		return bodyEN;
	}

	public void setBodyEN(String bodyEN) {
		this.bodyEN = bodyEN;
	}
}
