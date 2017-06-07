package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;
import com.mika.credit.common.util.DateUtil;

/**
 * 财务分析
 * @author ZhuJun，ShenYi.
 * Created on 2014-03-17.
 */
public class FinancialRatios  extends BaseEntity {
	/**
	 * ID编号
	 */
	private Integer id;
	/**
	 *年份
	 */
	private String year;
	/**
	 *来源
	 */
	private Integer fsId;

	private Integer dtid;
	/**
	 *月份
	 */
	private String month;
	/**
	 *净资产收益率
	 */
	private String returnOnEquity;
	/**
	 *资产回报率
	 */
	private String returnOnAssets;
	/**
	 *利润率
	 */
	private String profitMargin;
	/**
	 *毛利润
	 */
	private String grossMargin;
	/**
	 *资产周转率
	 */
	private String assetsTurnover;
	/**
	 *存货周转率
	 */
	private String stockTurnover;
	/**
	 *存货周转期
	 */
	private String salesPeriod;
	/**
	 *应收帐款周转期
	 */
	private String collectionPeriod;
	/**
	 *应付帐款周转期
	 */
	private String creditPeriod;
	/**
	 *流动比率
	 */
	private String currentRato;
	/**
	 *速动比率
	 */
	private String quickRatio;
	/**
	 *净资产流动率
	 */
	private String shareholdersLiquidityRato;
	/**
	 *偿付能力比率
	 */
	private String solvencyRatio;
	/**
	 *资产负债比率
	 */
	private String debtRatio;
	/**
	 *雇员平均利润
	 */
	private String profitPerEmployee;
	/**
	 *雇员平均营业收入
	 */
	private String operatingRevenuePerEmployee;
	/**
	 *雇员平均股东权益
	 */
	private String shareholderFundsPerEmployess;
	/**
	 *雇员平均总资产
	 */
	private String totalAssetsPerEmployee;
	/**
	 *销售成长率
	 */
	private String salesGrowthRate;
	/**
	 *净利润成长率
	 */
	private String netprofitGrowthRate;
	/**
	 *总资产成长率
	 */
	private String totalAssetsGrowthRate;
	/**
	 *科氏号码
	 */
	private String crefoNo;
	/**
	 *删除标识
	 */
	private String delFlag;
	//private BasicData basicData;//关联一对多的一方;
	/**
	 *关联财务id
	 */
	private Integer financialId;
	/**
	 *更新时间
	 */
	private String updateTime;
	/**
	 *来源
	 */
	private String financialSources;
	/**
	 *关联企业信息的唯一标识
	 */
	private Integer fullReportId;


	public FinancialRatios() {
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Integer getFsId() {
		return fsId;
	}

	public void setFsId(Integer fsId) {
		this.fsId = fsId;
	}

	public Integer getDtid() {
		return dtid;
	}

	public void setDtid(Integer dtid) {
		this.dtid = dtid;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getReturnOnEquity() {
		return returnOnEquity;
	}

	public void setReturnOnEquity(String returnOnEquity) {
		this.returnOnEquity = returnOnEquity;
	}

	public String getReturnOnAssets() {
		return returnOnAssets;
	}

	public void setReturnOnAssets(String returnOnAssets) {
		this.returnOnAssets = returnOnAssets;
	}

	public String getProfitMargin() {
		return profitMargin;
	}

	public void setProfitMargin(String profitMargin) {
		this.profitMargin = profitMargin;
	}

	public String getGrossMargin() {
		return grossMargin;
	}

	public void setGrossMargin(String grossMargin) {
		this.grossMargin = grossMargin;
	}

	public String getAssetsTurnover() {
		return assetsTurnover;
	}

	public void setAssetsTurnover(String assetsTurnover) {
		this.assetsTurnover = assetsTurnover;
	}

	public String getStockTurnover() {
		return stockTurnover;
	}

	public void setStockTurnover(String stockTurnover) {
		this.stockTurnover = stockTurnover;
	}

	public String getSalesPeriod() {
		return salesPeriod;
	}

	public void setSalesPeriod(String salesPeriod) {
		this.salesPeriod = salesPeriod;
	}

	public String getCollectionPeriod() {
		return collectionPeriod;
	}

	public void setCollectionPeriod(String collectionPeriod) {
		this.collectionPeriod = collectionPeriod;
	}

	public String getCreditPeriod() {
		return creditPeriod;
	}

	public void setCreditPeriod(String creditPeriod) {
		this.creditPeriod = creditPeriod;
	}

	public String getCurrentRato() {
		return currentRato;
	}

	public void setCurrentRato(String currentRato) {
		this.currentRato = currentRato;
	}

	public String getQuickRatio() {
		return quickRatio;
	}

	public void setQuickRatio(String quickRatio) {
		this.quickRatio = quickRatio;
	}

	public String getShareholdersLiquidityRato() {
		return shareholdersLiquidityRato;
	}

	public void setShareholdersLiquidityRato(String shareholdersLiquidityRato) {
		this.shareholdersLiquidityRato = shareholdersLiquidityRato;
	}

	public String getSolvencyRatio() {
		return solvencyRatio;
	}

	public void setSolvencyRatio(String solvencyRatio) {
		this.solvencyRatio = solvencyRatio;
	}

	public String getDebtRatio() {
		return debtRatio;
	}

	public void setDebtRatio(String debtRatio) {
		this.debtRatio = debtRatio;
	}

	public String getProfitPerEmployee() {
		return profitPerEmployee;
	}

	public void setProfitPerEmployee(String profitPerEmployee) {
		this.profitPerEmployee = profitPerEmployee;
	}

	public String getOperatingRevenuePerEmployee() {
		return operatingRevenuePerEmployee;
	}

	public void setOperatingRevenuePerEmployee(String operatingRevenuePerEmployee) {
		this.operatingRevenuePerEmployee = operatingRevenuePerEmployee;
	}

	public String getShareholderFundsPerEmployess() {
		return shareholderFundsPerEmployess;
	}

	public void setShareholderFundsPerEmployess(String shareholderFundsPerEmployess) {
		this.shareholderFundsPerEmployess = shareholderFundsPerEmployess;
	}

	public String getTotalAssetsPerEmployee() {
		return totalAssetsPerEmployee;
	}

	public void setTotalAssetsPerEmployee(String totalAssetsPerEmployee) {
		this.totalAssetsPerEmployee = totalAssetsPerEmployee;
	}

	public String getSalesGrowthRate() {
		return salesGrowthRate;
	}

	public void setSalesGrowthRate(String salesGrowthRate) {
		this.salesGrowthRate = salesGrowthRate;
	}

	public String getNetprofitGrowthRate() {
		return netprofitGrowthRate;
	}

	public void setNetprofitGrowthRate(String netprofitGrowthRate) {
		this.netprofitGrowthRate = netprofitGrowthRate;
	}

	public String getTotalAssetsGrowthRate() {
		return totalAssetsGrowthRate;
	}

	public void setTotalAssetsGrowthRate(String totalAssetsGrowthRate) {
		this.totalAssetsGrowthRate = totalAssetsGrowthRate;
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

	public Integer getFinancialId() {
		return financialId;
	}

	public void setFinancialId(Integer financialId) {
		this.financialId = financialId;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getFinancialSources() {
		return financialSources;
	}

	public void setFinancialSources(String financialSources) {
		this.financialSources = financialSources;
	}

	public Integer getFullReportId() {
		return fullReportId;
	}

	public void setFullReportId(Integer fullReportId) {
		this.fullReportId = fullReportId;
	}
}
