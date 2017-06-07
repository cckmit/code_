package com.mika.credit.common.entity.report.en;

import com.mika.credit.common.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="FinancialStatement")
public class FinancialStatement extends BaseEntity implements Serializable {

	/**
	 * @author Nancy
	 * @2014-03-17
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Basic
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;//ID编号
	
	@Column(name="", columnDefinition="varchar(20)")
	private String year;//年份
	
	@Column(name="", columnDefinition="varchar(20)")
	private String weeks;

	private Integer fullReportId;//fullReportId

	public Integer getFullReportId() {
		return fullReportId;
	}

	public void setFullReportId(Integer fullReportId) {
		this.fullReportId = fullReportId;
	}

	@Column(name="currency", columnDefinition="varchar(20)")
	private String currency;//货币
	
	@Column(name="consolidatedAccounts", columnDefinition="varchar(20)")
	private String consolidatedAccounts;//账户是否合并
	
	@Column(name="advisors", columnDefinition="varchar(20)")
	private String advisors;//顾问
	
	@Column(name="auditorName", columnDefinition="varchar(20)")
	private String auditorName;//审核人
	
	@Column(name="solicitorName", columnDefinition="varchar(20)")
	private String solicitorName;//律师


	
	
	
	/**
	 * 损益表
	 */
	
	@Column(name="revenue", columnDefinition="varchar(20)")
	private String revenue;//

	@Column(name="operatingCosts", columnDefinition="varchar(20)")
	private String operatingCosts;//

	@Column(name="operatingProfit", columnDefinition="varchar(20)")
	private String operatingProfit;//

	@Column(name="wagesAndSalaries", columnDefinition="varchar(20)")
	private String wagesAndSalaries;//

	@Column(name="pensionCosts", columnDefinition="varchar(20)")
	private String pensionCosts;//

	@Column(name="depreciation", columnDefinition="varchar(20)")
	private String depreciation;//

	@Column(name="amortisation", columnDefinition="varchar(20)")
	private String amortisation;//

	@Column(name="financialIncome", columnDefinition="varchar(20)")
	private String financialIncome;//

	@Column(name="financialExpenses", columnDefinition="varchar(20)")
	private String financialExpenses;//

	@Column(name="extraordinaryIncome", columnDefinition="varchar(20)")
	private String extraordinaryIncome;//

	@Column(name="extraordinaryCosts", columnDefinition="varchar(20)")
	private String extraordinaryCosts;//

	@Column(name="profitBeforeTax", columnDefinition="varchar(20)")
	private String profitBeforeTax;//

	@Column(name="tax", columnDefinition="varchar(20)")
	private String tax;//
	
	@Column(name="profitAfterTax", columnDefinition="varchar(20)")
	private String profitAfterTax;//

	@Column(name="dividends", columnDefinition="varchar(20)")
	private String dividends;//

	@Column(name="minorityInterests", columnDefinition="varchar(20)")
	private String minorityInterests;//

	@Column(name="otherAppropriations", columnDefinition="varchar(20)")
	private String otherAppropriations;//
	
	@Column(name="retainedProfit", columnDefinition="varchar(20)")
	private String retainedProfit;//
	
	/**
	 * 资产负债表
	 */
	@Column(name="landAndBuildings", columnDefinition="varchar(20)")
	private String landAndBuildings;//

	@Column(name="plantAndMachinery", columnDefinition="varchar(20)")
	private String plantAndMachinery;//

	@Column(name="otherTangibleAssets", columnDefinition="varchar(20)")
	private String otherTangibleAssets;//

	@Column(name="totalTangibleAssets", columnDefinition="varchar(20)")
	private String totalTangibleAssets;//
	
	@Column(name="goodwill", columnDefinition="varchar(20)")
	private String goodwill;//

	@Column(name="otherIntangibleAssets", columnDefinition="varchar(20)")
	private String otherIntangibleAssets;//

	@Column(name="totalIntangibleAssets", columnDefinition="varchar(20)")
	private String totalIntangibleAssets;//

	@Column(name="investments", columnDefinition="varchar(20)")
	private String investments;//
	@Column(name="loansToGroup", columnDefinition="varchar(20)")
	private String loansToGroup;//

	@Column(name="otherLoans", columnDefinition="varchar(20)")
	private String otherLoans;//

	@Column(name="miscellaneousFixedAssets", columnDefinition="varchar(20)")
	private String miscellaneousFixedAssets;//

	@Column(name="totalOtherFixedAssets", columnDefinition="varchar(20)")
	private String totalOtherFixedAssets;//
	
	@Column(name="totalFixedAssets", columnDefinition="varchar(20)")
	private String totalFixedAssets;//

	@Column(name="rawMaterials", columnDefinition="varchar(20)")
	private String rawMaterials;//

	@Column(name="workInProgress", columnDefinition="varchar(20)")
	private String workInProgress;//

	@Column(name="finishedGoods", columnDefinition="varchar(20)")
		private String finishedGoods;//
	
	@Column(name="otherInventories", columnDefinition="varchar(20)")
	private String otherInventories;//

	@Column(name="totalInventories", columnDefinition="varchar(20)")
	private String totalInventories;//

	@Column(name="tradeReceivables", columnDefinition="varchar(20)")
	private String tradeReceivables;//

	@Column(name="groupReceivables", columnDefinition="varchar(20)")
	private String groupReceivables;//

	@Column(name="receivablesDueAfter1Year", columnDefinition="varchar(20)")
	private String receivablesDueAfter1Year;//

	@Column(name="miscellaneousReceivables", columnDefinition="varchar(20)")
	private String miscellaneousReceivables;//

	@Column(name="totalReceivables", columnDefinition="varchar(20)")
	private String totalReceivables;//

	@Column(name="cash", columnDefinition="varchar(20)")
	private String cash;//
	

	@Column(name="otherCurrentAssets", columnDefinition="varchar(20)")
	private String otherCurrentAssets;//

	@Column(name="totalCurrentAssets", columnDefinition="varchar(20)")
	private String totalCurrentAssets;//

	@Column(name="totalAssets", columnDefinition="varchar(20)")
	private String totalAssets;//

	@Column(name="tradePayables", columnDefinition="varchar(20)")
	private String tradePayables;//
	

	@Column(name="bankLiabilities", columnDefinition="varchar(20)")
	private String bankLiabilities;//

	@Column(name="otherLoansOrFinance", columnDefinition="varchar(20)")
	private String otherLoansOrFinance;//

	@Column(name="groupPayables", columnDefinition="varchar(20)")
	private String groupPayables;//

	@Column(name="miscellaneousLiabilities", columnDefinition="varchar(20)")
	private String miscellaneousLiabilities;//
	

	@Column(name="totalCurrentLiabilities", columnDefinition="varchar(20)")
	private String totalCurrentLiabilities;//

	@Column(name="tradePayablesDueAfter1Year", columnDefinition="varchar(20)")
	private String tradePayablesDueAfter1Year;//

	@Column(name="bankLiabilitiesDueAfter1Year", columnDefinition="varchar(20)")
	private String bankLiabilitiesDueAfter1Year;//

	@Column(name="otherLoansOrFinanceDueAfter1Year", columnDefinition="varchar(20)")
	private String otherLoansOrFinanceDueAfter1Year;//
	

	@Column(name="groupPayablesDueAfter1Year", columnDefinition="varchar(20)")
	private String groupPayablesDueAfter1Year;//

	@Column(name="miscellaneousLiabilitiesDueAfter1Year", columnDefinition="varchar(20)")
	private String miscellaneousLiabilitiesDueAfter1Year;//

	@Column(name="totalLongTermLiabilities", columnDefinition="varchar(20)")
	private String totalLongTermLiabilities;//

	@Column(name="totalLiabilities", columnDefinition="varchar(20)")
	private String totalLiabilities;//
	
	@Column(name="calledUpShareCapital", columnDefinition="varchar(20)")
	private String calledUpShareCapital;//

	@Column(name="sharePremium", columnDefinition="varchar(20)")
	private String sharePremium;//

	@Column(name="revenueReserves", columnDefinition="varchar(20)")
	private String revenueReserves;//

	@Column(name="otherReserves", columnDefinition="varchar(20)")
	private String otherReserves;//
	

	@Column(name="totalShareholdersEquity", columnDefinition="varchar(20)")
	private String totalShareholdersEquity;//
	
	/**
	 * 其他财务
	 */
	
	@Column(name="contingentLiabilities", columnDefinition="varchar(20)")
	private String contingentLiabilities;//

	@Column(name="workingCapital", columnDefinition="varchar(20)")
	private String workingCapital;//

	@Column(name="netWorth", columnDefinition="varchar(20)")
	private String netWorth;//
	
	/**
	 * 评级
	 */
	@Column(name="currCommonValue", columnDefinition="varchar(20)")
	private String currCommonValue;//

	@Column(name="currCommonDescription", columnDefinition="text")
		private String currCommonDescription;//

	@Column(name="currCreditLimit", columnDefinition="varchar(20)")
	private String currCreditLimit;//

	@Column(name="currProviderValue", columnDefinition="varchar(20)")
	private String currProviderValue;//

	@Column(name="currContractLimit", columnDefinition="varchar(20)")
	private String currContractLimit;//

	@Column(name="preCommonValue", columnDefinition="varchar(20)")
	private String preCommonValue;//

	@Column(name="preCommonDescription", columnDefinition="text")
	private String preCommonDescription;//

	@Column(name="preCreditLimit", columnDefinition="varchar(20)")
	private String preCreditLimit;//

	@Column(name="preProviderValue", columnDefinition="varchar(20)")
	private String preProviderValue;//

	@Column(name="dateOfLatestRatingChange", columnDefinition="varchar(20)")
	private String dateOfLatestRatingChange;//

	@Column(name="localCreditRating", columnDefinition="text")
	private String localCreditRating;//
	
	
	@Column(name="crefoNo", columnDefinition="varchar(50)")
	private String crefoNo;//公司内部科氏码
	
	@Column(name="updateTime", columnDefinition="varchar(50)")
	private String updateTime;//更新时间
	
	@Column(name="delFlag", columnDefinition="varchar(2)")
	private String delFlag;//删除标志 1：正常

	private String isFinancial;


	public FinancialStatement(){}


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


	public String getWeeks() {
		return weeks;
	}


	public void setWeeks(String weeks) {
		this.weeks = weeks;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public String getConsolidatedAccounts() {
		return consolidatedAccounts;
	}


	public void setConsolidatedAccounts(String consolidatedAccounts) {
		this.consolidatedAccounts = consolidatedAccounts;
	}


	public String getAdvisors() {
		return advisors;
	}


	public void setAdvisors(String advisors) {
		this.advisors = advisors;
	}


	public String getAuditorName() {
		return auditorName;
	}


	public void setAuditorName(String auditorName) {
		this.auditorName = auditorName;
	}


	public String getSolicitorName() {
		return solicitorName;
	}


	public void setSolicitorName(String solicitorName) {
		this.solicitorName = solicitorName;
	}


	public String getRevenue() {
		return revenue;
	}


	public void setRevenue(String revenue) {
		this.revenue = revenue;
	}


	public String getOperatingCosts() {
		return operatingCosts;
	}


	public void setOperatingCosts(String operatingCosts) {
		this.operatingCosts = operatingCosts;
	}


	public String getOperatingProfit() {
		return operatingProfit;
	}


	public void setOperatingProfit(String operatingProfit) {
		this.operatingProfit = operatingProfit;
	}


	public String getWagesAndSalaries() {
		return wagesAndSalaries;
	}


	public void setWagesAndSalaries(String wagesAndSalaries) {
		this.wagesAndSalaries = wagesAndSalaries;
	}


	public String getPensionCosts() {
		return pensionCosts;
	}


	public void setPensionCosts(String pensionCosts) {
		this.pensionCosts = pensionCosts;
	}


	public String getDepreciation() {
		return depreciation;
	}


	public void setDepreciation(String depreciation) {
		this.depreciation = depreciation;
	}


	public String getAmortisation() {
		return amortisation;
	}


	public void setAmortisation(String amortisation) {
		this.amortisation = amortisation;
	}


	public String getFinancialIncome() {
		return financialIncome;
	}


	public void setFinancialIncome(String financialIncome) {
		this.financialIncome = financialIncome;
	}


	public String getFinancialExpenses() {
		return financialExpenses;
	}


	public void setFinancialExpenses(String financialExpenses) {
		this.financialExpenses = financialExpenses;
	}


	public String getExtraordinaryIncome() {
		return extraordinaryIncome;
	}


	public void setExtraordinaryIncome(String extraordinaryIncome) {
		this.extraordinaryIncome = extraordinaryIncome;
	}


	public String getExtraordinaryCosts() {
		return extraordinaryCosts;
	}


	public void setExtraordinaryCosts(String extraordinaryCosts) {
		this.extraordinaryCosts = extraordinaryCosts;
	}


	public String getProfitBeforeTax() {
		return profitBeforeTax;
	}


	public void setProfitBeforeTax(String profitBeforeTax) {
		this.profitBeforeTax = profitBeforeTax;
	}


	public String getTax() {
		return tax;
	}


	public void setTax(String tax) {
		this.tax = tax;
	}


	public String getProfitAfterTax() {
		return profitAfterTax;
	}


	public void setProfitAfterTax(String profitAfterTax) {
		this.profitAfterTax = profitAfterTax;
	}


	public String getDividends() {
		return dividends;
	}


	public void setDividends(String dividends) {
		this.dividends = dividends;
	}


	public String getMinorityInterests() {
		return minorityInterests;
	}


	public void setMinorityInterests(String minorityInterests) {
		this.minorityInterests = minorityInterests;
	}


	public String getOtherAppropriations() {
		return otherAppropriations;
	}


	public void setOtherAppropriations(String otherAppropriations) {
		this.otherAppropriations = otherAppropriations;
	}


	public String getRetainedProfit() {
		return retainedProfit;
	}


	public void setRetainedProfit(String retainedProfit) {
		this.retainedProfit = retainedProfit;
	}


	public String getLandAndBuildings() {
		return landAndBuildings;
	}


	public void setLandAndBuildings(String landAndBuildings) {
		this.landAndBuildings = landAndBuildings;
	}


	public String getPlantAndMachinery() {
		return plantAndMachinery;
	}


	public void setPlantAndMachinery(String plantAndMachinery) {
		this.plantAndMachinery = plantAndMachinery;
	}


	public String getOtherTangibleAssets() {
		return otherTangibleAssets;
	}


	public void setOtherTangibleAssets(String otherTangibleAssets) {
		this.otherTangibleAssets = otherTangibleAssets;
	}


	public String getTotalTangibleAssets() {
		return totalTangibleAssets;
	}


	public void setTotalTangibleAssets(String totalTangibleAssets) {
		this.totalTangibleAssets = totalTangibleAssets;
	}


	public String getGoodwill() {
		return goodwill;
	}


	public void setGoodwill(String goodwill) {
		this.goodwill = goodwill;
	}


	public String getOtherIntangibleAssets() {
		return otherIntangibleAssets;
	}


	public void setOtherIntangibleAssets(String otherIntangibleAssets) {
		this.otherIntangibleAssets = otherIntangibleAssets;
	}


	public String getTotalIntangibleAssets() {
		return totalIntangibleAssets;
	}


	public void setTotalIntangibleAssets(String totalIntangibleAssets) {
		this.totalIntangibleAssets = totalIntangibleAssets;
	}


	public String getInvestments() {
		return investments;
	}


	public void setInvestments(String investments) {
		this.investments = investments;
	}


	public String getLoansToGroup() {
		return loansToGroup;
	}


	public void setLoansToGroup(String loansToGroup) {
		this.loansToGroup = loansToGroup;
	}


	public String getOtherLoans() {
		return otherLoans;
	}


	public void setOtherLoans(String otherLoans) {
		this.otherLoans = otherLoans;
	}


	public String getMiscellaneousFixedAssets() {
		return miscellaneousFixedAssets;
	}


	public void setMiscellaneousFixedAssets(String miscellaneousFixedAssets) {
		this.miscellaneousFixedAssets = miscellaneousFixedAssets;
	}


	public String getTotalOtherFixedAssets() {
		return totalOtherFixedAssets;
	}


	public void setTotalOtherFixedAssets(String totalOtherFixedAssets) {
		this.totalOtherFixedAssets = totalOtherFixedAssets;
	}


	public String getTotalFixedAssets() {
		return totalFixedAssets;
	}


	public void setTotalFixedAssets(String totalFixedAssets) {
		this.totalFixedAssets = totalFixedAssets;
	}


	public String getRawMaterials() {
		return rawMaterials;
	}


	public void setRawMaterials(String rawMaterials) {
		this.rawMaterials = rawMaterials;
	}


	public String getWorkInProgress() {
		return workInProgress;
	}


	public void setWorkInProgress(String workInProgress) {
		this.workInProgress = workInProgress;
	}


	public String getFinishedGoods() {
		return finishedGoods;
	}


	public void setFinishedGoods(String finishedGoods) {
		this.finishedGoods = finishedGoods;
	}


	public String getOtherInventories() {
		return otherInventories;
	}


	public void setOtherInventories(String otherInventories) {
		this.otherInventories = otherInventories;
	}


	public String getTotalInventories() {
		return totalInventories;
	}


	public void setTotalInventories(String totalInventories) {
		this.totalInventories = totalInventories;
	}


	public String getTradeReceivables() {
		return tradeReceivables;
	}


	public void setTradeReceivables(String tradeReceivables) {
		this.tradeReceivables = tradeReceivables;
	}


	public String getGroupReceivables() {
		return groupReceivables;
	}


	public void setGroupReceivables(String groupReceivables) {
		this.groupReceivables = groupReceivables;
	}


	public String getReceivablesDueAfter1Year() {
		return receivablesDueAfter1Year;
	}


	public void setReceivablesDueAfter1Year(String receivablesDueAfter1Year) {
		this.receivablesDueAfter1Year = receivablesDueAfter1Year;
	}


	public String getMiscellaneousReceivables() {
		return miscellaneousReceivables;
	}


	public void setMiscellaneousReceivables(String miscellaneousReceivables) {
		this.miscellaneousReceivables = miscellaneousReceivables;
	}


	public String getTotalReceivables() {
		return totalReceivables;
	}


	public void setTotalReceivables(String totalReceivables) {
		this.totalReceivables = totalReceivables;
	}


	public String getCash() {
		return cash;
	}


	public void setCash(String cash) {
		this.cash = cash;
	}


	public String getOtherCurrentAssets() {
		return otherCurrentAssets;
	}


	public void setOtherCurrentAssets(String otherCurrentAssets) {
		this.otherCurrentAssets = otherCurrentAssets;
	}


	public String getTotalCurrentAssets() {
		return totalCurrentAssets;
	}


	public void setTotalCurrentAssets(String totalCurrentAssets) {
		this.totalCurrentAssets = totalCurrentAssets;
	}


	public String getTotalAssets() {
		return totalAssets;
	}


	public void setTotalAssets(String totalAssets) {
		this.totalAssets = totalAssets;
	}


	public String getTradePayables() {
		return tradePayables;
	}


	public void setTradePayables(String tradePayables) {
		this.tradePayables = tradePayables;
	}


	public String getBankLiabilities() {
		return bankLiabilities;
	}


	public void setBankLiabilities(String bankLiabilities) {
		this.bankLiabilities = bankLiabilities;
	}


	public String getOtherLoansOrFinance() {
		return otherLoansOrFinance;
	}


	public void setOtherLoansOrFinance(String otherLoansOrFinance) {
		this.otherLoansOrFinance = otherLoansOrFinance;
	}


	public String getGroupPayables() {
		return groupPayables;
	}


	public void setGroupPayables(String groupPayables) {
		this.groupPayables = groupPayables;
	}


	public String getMiscellaneousLiabilities() {
		return miscellaneousLiabilities;
	}


	public void setMiscellaneousLiabilities(String miscellaneousLiabilities) {
		this.miscellaneousLiabilities = miscellaneousLiabilities;
	}


	public String getTotalCurrentLiabilities() {
		return totalCurrentLiabilities;
	}


	public void setTotalCurrentLiabilities(String totalCurrentLiabilities) {
		this.totalCurrentLiabilities = totalCurrentLiabilities;
	}


	public String getTradePayablesDueAfter1Year() {
		return tradePayablesDueAfter1Year;
	}


	public void setTradePayablesDueAfter1Year(String tradePayablesDueAfter1Year) {
		this.tradePayablesDueAfter1Year = tradePayablesDueAfter1Year;
	}


	public String getBankLiabilitiesDueAfter1Year() {
		return bankLiabilitiesDueAfter1Year;
	}


	public void setBankLiabilitiesDueAfter1Year(String bankLiabilitiesDueAfter1Year) {
		this.bankLiabilitiesDueAfter1Year = bankLiabilitiesDueAfter1Year;
	}


	public String getOtherLoansOrFinanceDueAfter1Year() {
		return otherLoansOrFinanceDueAfter1Year;
	}


	public void setOtherLoansOrFinanceDueAfter1Year(
			String otherLoansOrFinanceDueAfter1Year) {
		this.otherLoansOrFinanceDueAfter1Year = otherLoansOrFinanceDueAfter1Year;
	}


	public String getGroupPayablesDueAfter1Year() {
		return groupPayablesDueAfter1Year;
	}


	public void setGroupPayablesDueAfter1Year(String groupPayablesDueAfter1Year) {
		this.groupPayablesDueAfter1Year = groupPayablesDueAfter1Year;
	}


	public String getMiscellaneousLiabilitiesDueAfter1Year() {
		return miscellaneousLiabilitiesDueAfter1Year;
	}


	public void setMiscellaneousLiabilitiesDueAfter1Year(
			String miscellaneousLiabilitiesDueAfter1Year) {
		this.miscellaneousLiabilitiesDueAfter1Year = miscellaneousLiabilitiesDueAfter1Year;
	}


	public String getTotalLongTermLiabilities() {
		return totalLongTermLiabilities;
	}


	public void setTotalLongTermLiabilities(String totalLongTermLiabilities) {
		this.totalLongTermLiabilities = totalLongTermLiabilities;
	}


	public String getTotalLiabilities() {
		return totalLiabilities;
	}


	public void setTotalLiabilities(String totalLiabilities) {
		this.totalLiabilities = totalLiabilities;
	}


	public String getCalledUpShareCapital() {
		return calledUpShareCapital;
	}


	public void setCalledUpShareCapital(String calledUpShareCapital) {
		this.calledUpShareCapital = calledUpShareCapital;
	}


	public String getSharePremium() {
		return sharePremium;
	}


	public void setSharePremium(String sharePremium) {
		this.sharePremium = sharePremium;
	}


	public String getRevenueReserves() {
		return revenueReserves;
	}


	public void setRevenueReserves(String revenueReserves) {
		this.revenueReserves = revenueReserves;
	}


	public String getOtherReserves() {
		return otherReserves;
	}


	public void setOtherReserves(String otherReserves) {
		this.otherReserves = otherReserves;
	}


	public String getTotalShareholdersEquity() {
		return totalShareholdersEquity;
	}


	public void setTotalShareholdersEquity(String totalShareholdersEquity) {
		this.totalShareholdersEquity = totalShareholdersEquity;
	}


	public String getContingentLiabilities() {
		return contingentLiabilities;
	}


	public void setContingentLiabilities(String contingentLiabilities) {
		this.contingentLiabilities = contingentLiabilities;
	}


	public String getWorkingCapital() {
		return workingCapital;
	}


	public void setWorkingCapital(String workingCapital) {
		this.workingCapital = workingCapital;
	}


	public String getNetWorth() {
		return netWorth;
	}


	public void setNetWorth(String netWorth) {
		this.netWorth = netWorth;
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


	public String getDelFlag() {
		return delFlag;
	}


	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}


	public String getCurrCommonValue() {
		return currCommonValue;
	}


	public void setCurrCommonValue(String currCommonValue) {
		this.currCommonValue = currCommonValue;
	}


	public String getCurrCommonDescription() {
		return currCommonDescription;
	}


	public void setCurrCommonDescription(String currCommonDescription) {
		this.currCommonDescription = currCommonDescription;
	}


	public String getCurrCreditLimit() {
		return currCreditLimit;
	}


	public void setCurrCreditLimit(String currCreditLimit) {
		this.currCreditLimit = currCreditLimit;
	}


	public String getCurrProviderValue() {
		return currProviderValue;
	}


	public void setCurrProviderValue(String currProviderValue) {
		this.currProviderValue = currProviderValue;
	}


	public String getCurrContractLimit() {
		return currContractLimit;
	}


	public void setCurrContractLimit(String currContractLimit) {
		this.currContractLimit = currContractLimit;
	}


	public String getPreCommonValue() {
		return preCommonValue;
	}


	public void setPreCommonValue(String preCommonValue) {
		this.preCommonValue = preCommonValue;
	}


	public String getPreCommonDescription() {
		return preCommonDescription;
	}


	public void setPreCommonDescription(String preCommonDescription) {
		this.preCommonDescription = preCommonDescription;
	}


	public String getPreCreditLimit() {
		return preCreditLimit;
	}


	public void setPreCreditLimit(String preCreditLimit) {
		this.preCreditLimit = preCreditLimit;
	}


	public String getPreProviderValue() {
		return preProviderValue;
	}


	public void setPreProviderValue(String preProviderValue) {
		this.preProviderValue = preProviderValue;
	}


	public String getDateOfLatestRatingChange() {
		return dateOfLatestRatingChange;
	}


	public void setDateOfLatestRatingChange(String dateOfLatestRatingChange) {
		this.dateOfLatestRatingChange = dateOfLatestRatingChange;
	}


	public String getLocalCreditRating() {
		return localCreditRating;
	}


	public void setLocalCreditRating(String localCreditRating) {
		this.localCreditRating = localCreditRating;
	}


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getIsFinancial() {
		return isFinancial;
	}

	public void setIsFinancial(String isFinancial) {
		this.isFinancial = isFinancial;
	}
}
