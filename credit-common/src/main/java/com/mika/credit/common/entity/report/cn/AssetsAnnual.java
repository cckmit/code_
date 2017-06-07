package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;
import com.mika.credit.common.util.DateUtil;

/**
 * 年报资产信息
 * @author ZhuJun，ShenYi.
 */
public class AssetsAnnual extends BaseEntity {
	/**
	 * ID编号
	 */
	private Integer id;
	/**
	 * 资产总额
	 */
	private String totalAssets;
	/**
	 * 所有者权益合计
	 */
	private String totalShareholdersEquity;
	/**
	 *营业总收入
	 */
	private String operatingProfit;
	/**
	 *利润总额
	 */
	private String profitBeforeTax;
	/**
	 *营业总收入中主营业务收入
	 */
	private String turnover;
	/**
	 *净利润
	 */
	private String netIncome;
	/**
	 *纳税总额
	 */
	private String incomeTax;
	/**
	 *负债总额
	 */
	private String totalLiabilities;
	/**
	 *年报年度
	 */
	private String year;
	/**
	 *科室号码
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


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTotalAssets() {
		return totalAssets;
	}
	public void setTotalAssets(String totalAssets) {
		this.totalAssets = totalAssets;
	}

	public Integer getFullReportId() {
		return fullReportId;
	}
	public void setFullReportId(Integer fullReportId) {
		this.fullReportId = fullReportId;
	}

	public String getTotalShareholdersEquity() {
		return totalShareholdersEquity;
	}
	public void setTotalShareholdersEquity(String totalShareholdersEquity) {
		this.totalShareholdersEquity = totalShareholdersEquity;
	}
	public String getOperatingProfit() {
		return operatingProfit;
	}
	public void setOperatingProfit(String operatingProfit) {
		this.operatingProfit = operatingProfit;
	}
	public String getProfitBeforeTax() {
		return profitBeforeTax;
	}
	public void setProfitBeforeTax(String profitBeforeTax) {
		this.profitBeforeTax = profitBeforeTax;
	}
	public String getTurnover() {
		return turnover;
	}
	public void setTurnover(String turnover) {
		this.turnover = turnover;
	}
	public String getNetIncome() {
		return netIncome;
	}
	public void setNetIncome(String netIncome) {
		this.netIncome = netIncome;
	}
	public String getIncomeTax() {
		return incomeTax;
	}
	public void setIncomeTax(String incomeTax) {
		this.incomeTax = incomeTax;
	}

	public String getTotalLiabilities() {
		return totalLiabilities;
	}

	public void setTotalLiabilities(String totalLiabilities) {
		this.totalLiabilities = totalLiabilities;
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

	public AssetsAnnual() {
		this.updateTime = DateUtil.getCurrentDate();
	}


}
