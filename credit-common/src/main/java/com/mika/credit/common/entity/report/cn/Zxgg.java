package com.mika.credit.common.entity.report.cn;

/**
 * 执行公告
 * @author ZhuJun，ShenYi.
 */
public class Zxgg {
	/**
	 *内容
	 */
	private String body;
	/**
	 *立案时间
	 */
	private String sortTimeString;
	/**
	 *被执行人姓名
	 */
	private String pname;
	/**
	 *法院名称
	 */
	private String court;
	/**
	 *案号
	 */
	private String caseNo;
	/**
	 *执行标的
	 */
	private String execMoney;
	/**
	 *执行公告ID
	 */
	private String zxggId;
	/**
	 *法院公告ID
	 */
	private String fyggId;
	/**
	 *公告类型
	 */
	private String ggType;
	/**
	 *开庭公告id
	 */
	private String ktggId;
	/**
	 *案由
	 */
	private String caseCause;
	/**
	 *原告
	 */
	private String plaintiff;
	/**
	 *法庭
	 */
	private String courtroom;
	/**
	 *当事人
	 */
	private String party;
	/**
	 *被告
	 */
	private String defendant;
	/**
	 *文书标题
	 */
	private String title;
	/**
	 *裁判文书id
	 */
	private String cpwsId;
	/**
	 *判决结果
	 */
	private String judgeResult;
	/**
	 *时间戳
	 */
	private String sortTime;
	/**
	 *时间戳
	 */
	private int sortTimes;
	/**
	 *数据类型
	 */
	private String dataType;
	/**
	 *案件流程ID
	 */
	private String ajlcId;
	/**
	 *案件流程状态
	 */
	private String ajlcStatus;
	/**
	 *关联企业信息的唯一标识
	 */
	private Integer fullReportId;
	/**
	 *更新时间
	 */
	private String updateTime;
	
	public Zxgg() {
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public Zxgg(int sortTimes) {
		this.sortTimes = sortTimes;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getSortTimeString() {
		return sortTimeString;
	}
	public void setSortTimeString(String sortTimeString) {
		sortTimeString = sortTimeString.replace("年", "-");
		sortTimeString = sortTimeString.replace("月", "-");
		sortTimeString = sortTimeString.replace("日", "");
		this.sortTimeString = sortTimeString;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getCourt() {
		return court;
	}
	public void setCourt(String court) {
		this.court = court;
	}
	public String getCaseNo() {
		return caseNo;
	}
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}
	public String getExecMoney() {
		return execMoney;
	}
	public void setExecMoney(String execMoney) {
		this.execMoney = execMoney;
	}
	public String getZxggId() {
		return zxggId;
	}
	public void setZxggId(String zxggId) {
		this.zxggId = zxggId;
	}
	public String getFyggId() {
		return fyggId;
	}
	public void setFyggId(String fyggId) {
		this.fyggId = fyggId;
	}
	public String getGgType() {
		return ggType;
	}
	public void setGgType(String ggType) {
		this.ggType = ggType;
	}
	public String getKtggId() {
		return ktggId;
	}
	public void setKtggId(String ktggId) {
		this.ktggId = ktggId;
	}
	public String getCaseCause() {
		return caseCause;
	}
	public void setCaseCause(String caseCause) {
		this.caseCause = caseCause;
	}
	public String getPlaintiff() {
		return plaintiff;
	}
	public void setPlaintiff(String plaintiff) {
		this.plaintiff = plaintiff;
	}
	public String getCourtroom() {
		return courtroom;
	}
	public void setCourtroom(String courtroom) {
		this.courtroom = courtroom;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public String getDefendant() {
		return defendant;
	}
	public void setDefendant(String defendant) {
		this.defendant = defendant;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCpwsId() {
		return cpwsId;
	}
	public void setCpwsId(String cpwsId) {
		this.cpwsId = cpwsId;
	}
	public String getJudgeResult() {
		return judgeResult;
	}
	public void setJudgeResult(String judgeResult) {
		this.judgeResult = judgeResult;
	}

	
	public int getSortTimes() {
		return sortTimes;
	}

	public void setSortTimes(String str) {
		int sortTimes = 0;
		try {
			sortTimes = Integer.parseInt(str.toString().substring(0,8));
		} catch (NumberFormatException e) {}
		this.sortTimes = sortTimes;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getSortTime() {
		return sortTime;
	}

	public void setSortTime(String sortTime) {
		this.sortTime = sortTime;
	}

	public String getAjlcId() {
		return ajlcId;
	}

	public void setAjlcId(String ajlcId) {
		this.ajlcId = ajlcId;
	}

	public String getAjlcStatus() {
		return ajlcStatus;
	}

	public void setAjlcStatus(String ajlcStatus) {
		this.ajlcStatus = ajlcStatus;
	}

	public void setSortTimes(int sortTimes) {
		this.sortTimes = sortTimes;
	}

	public Integer getFullReportId() {
		return fullReportId;
	}

	public void setFullReportId(Integer fullReportId) {
		this.fullReportId = fullReportId;
	}
}
