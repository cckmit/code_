package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;

/**
 * 年报提供担保信息
 * @author ZhuJun，ShenYi.
 */
public class GuaranteeAnnual extends BaseEntity {
	/**
	 * ID编号
	 */
	private Integer id;
	/**
	 * 债权人
	 */
	private String creditor;
	/**
	 * 债务人
	 */
	private String debtor;
	/**
	 *主债权种类
	 */
	private String creditorType;
	/**
	 *主债权数额
	 */
	private String creditorAmount;
	/**
	 *履行债务的期限
	 */
	private String deadline;
	/**
	 *保证的期间
	 */
	private String period;
	/**
	 *保证的方式
	 */
	private String manner;
	/**
	 *保证担保的范围
	 */
	private String range;
	/**
	 *年报年度
	 */
	private String year;
	/**
	 *科氏号码
	 */
	private String crefoNo;
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

	public String getCreditor() {
		return creditor;
	}

	public void setCreditor(String creditor) {
		this.creditor = creditor;
	}

	public String getDebtor() {
		return debtor;
	}

	public void setDebtor(String debtor) {
		this.debtor = debtor;
	}

	public String getCreditorType() {
		return creditorType;
	}

	public void setCreditorType(String creditorType) {
		this.creditorType = creditorType;
	}

	public String getCreditorAmount() {
		return creditorAmount;
	}

	public void setCreditorAmount(String creditorAmount) {
		this.creditorAmount = creditorAmount;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getManner() {
		return manner;
	}

	public void setManner(String manner) {
		this.manner = manner;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCrefoNo() {
		return crefoNo;
	}

	public void setCrefoNo(String crefoNo) {
		this.crefoNo = crefoNo;
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
}
