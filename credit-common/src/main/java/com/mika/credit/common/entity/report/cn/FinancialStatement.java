package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;
import com.mika.credit.common.util.DateUtil;

/**
 * 财务数据
 * @author ZhuJun，ShenYi.
 * Created on 2014-03-17.
 */
public class FinancialStatement  extends BaseEntity {
	/**
	 * ID编号
	 */
	private Integer id;
	/**
	 *年份
	 */
	private String year;
	/**
	 *月份
	 */
	private String month;
	/**
	 *员工人数
	 */
	private String employee;
	/**
	 *科氏号码
	 */
	private String crefoNo;
	/**
	 *输出财务
	 */
	private String outFinancial;
	/**
	 *输出财务
	 */
	private String outFinancials;
	/**
	 *财务信息来源
	 */
	private Integer financialSourceId;
	//private Integer dtId;
	//private BasicData basicData;//关联一对多的一方;
	/**
	 *删除标识
	 */
	private String delFlag;
	/**
	 *关联企业信息的唯一标识
	 */
	private Integer fullReportId;

	/**
	 * 资产负债表
	 */

	/**
	 * 货币资金
	 */
	private String cashAndBank;
	/**
	 *短期投资
	 */
	private String shortTermInvestment;
	/**
	 *应收票据
	 */
	private String billReceivable;
	/**
	 *应收账款
	 */
	private String accountReceivable;
	/**
	 *其他应收款
	 */
	private String otherReceivable;
	/**
	 *预付帐款
	 */
	private String advancesToSuppliers;
	/**
	 *存货
	 */
	private String inventory;
	/**
	 *待摊费用
	 */
	private String toBeAppointedExpense;
	/**
	 *其他流动资产
	 */
	private String otherCurrentAssets;
	/**
	 *流动资产合计
	 */
	private String totalCurrentAssets;
	/**
	 *长期投资合计
	 */
	private String totalLongTermInvestment;
	/**
	 *固定资产净值
	 */
	private String fixedAssetsNetValue;
	/**
	 *固定资产原价(新加)
	 */
	private String fixedAssetsAtCost;
	/**
	 *累计折价(新加)
	 */
	private String cumulativeDiscounts;
	/**
	 *在建工程
	 */
	private String projectsUnderConstruction;
	/**
	 *固定资产合计
	 */
	private String totalFixedAssets;
	/**
	 *无形资产
	 */
	private String intangibleAssets;
	/**
	 *长期待摊费用
	 */
	private String longTermToBeAppointedExpense;
	/**
	 *其他长期资产
	 */
	private String otherLongTermAssets;
	/**
	 *其他资产
	 */
	private String otherAssets;
	/**
	 *递延税款借项
	 */
	private String deferredTaxDebit;
	/**
	 *非流动资产合计
	 */
	private String totalNonCurrentAssets;
	/**
	 *财务信息来源CN
	 */
	private String financialSourceCN;
	/**
	 *财务信息来源EN
	 */
	private String financialSourceEN;
	/**
	 *资产合计
	 */
	private String totalAssets;
	
	
	
	/**
	 * 负债及股东权益
	 */

	/**
	 * 短期借款
	 */
	private String shortTermLoans;
	/**
	 *应付票据
	 */
	private String notePayable;
	/**
	 *应付帐款
	 */
	private String accountsPayable;
	/**
	 *预收帐款
	 */
	private String advancesFromClients;
	/**
	 *应付工资
	 */
	private String salariesPayable;
	/**
	 *应付福利
	 */
	private String welfarePayable;
	/**
	 *应交税金
	 */
	private String taxesPayable;
	/**
	 *其他应付款
	 */
	private String otherAccountsPayable;
	/**
	 *预提费用
	 */
	private String accruedExpenses;
	/**
	 *其他流动负债
	 */
	private String otherCurrentLiabilities;
	/**
	 *流动负债合计
	 */
	private String totalCurrentLiabilites;
	/**
	 *长期负债合计
	 */
	private String totalLongTermLiabilities;
	/**
	 *长期借款(新加)
	 */
	private String longTermLoan;
	/**
	 *长期应付款(新加)
	 */
	private String longTermPayables;
	/**
	 *
	 */
	private String deferredTaxCredit;//递延税款贷项
	/**
	 *其他负债
	 */
	private String otherLiabilities;
	/**
	 *非流动负债合计
	 */
	private String totalNonCurrentLiabilities;
	/**
	 *负债合计
	 */
	private String totalLiabilities;
	/**
	 *实收资本
	 */
	private String paidUpCapital;
	/**
	 *资本公积(新加)
	 */
	private String capitalReserve;
	/**
	 *盈余公积
	 */
	private String surplusReserve;
	/**
	 *未分配利润
	 */
	private String undistributedProfit;
	/**
	 *所有者权益合计
	 */
	private String totalShareholdersEquity;
	/**
	 *其他
	 */
	private String otherEquity;
	/**
	 *负债及所有者权益合计
	 */
	private String totalLiabilitiesEquities;
	
	/**
	 * 损益表
	 */

	/**
	 * 主营业务收入
	 */
	private String turnover;
	/**
	 * 主营业务成本
	 */
	private String costsOfGoodsSold;
	/**
	 *主营业务税金及附加
	 */
	private String salesTax;
	/**
	 *主营业务利润
	 */
	private String grossProfit;
	/**
	 *其他业务利润
	 */
	private String otherOperatingProfits;
	/**
	 *营业费用
	 */
	private String salesExpense;
	/**
	 *管理费用
	 */
	private String managementExpense;
	/**
	 *财务费用
	 */
	private String financeExpense;
	/**
	 *营业利润
	 */
	private String operatingProfit;
	/**
	 *投资利润(收益)
	 */
	private String investmentProfit;
	/**
	 *补贴收入
	 */
	private String allowanceIncomes;
	/**
	 *资产减值损失
	 */
	private String assetsDevaluation;
	/**
	 *营业外收入
	 */
	private String nonOperatingIncome;
	/**
	 *营业外支出
	 */
	private String nonOperatingExpense;
	/**
	 *利润总额
	 */
	private String profitBeforeTax;
	/**
	 *所得税
	 */
	private String incomeTax;
	/**
	 *净利润
	 */
	private String netIncome;
	/**
	 *偿还指数
	 */
	private String solvencyIndex;
	/**
	 *信用额度
	 */
	private String recommended;
	/**
	 *信用评级
	 */
	private Integer solvencyIndexId;
	
	
	//用于比较

	/**
	 * 流动资产比较
	 */
	private Long currentAssets;
	/**
	 *非流动资产比较
	 */
	private Long nonCurrentAssets;
	/**
	 *资产合计比较
	 */
	private Long assets;
	/**
	 *流动负债比较
	 */
	private Long currentLiabilites;
	/**
	 *非流动负债比较
	 */
	private Long nonCurrentLiabilities;
	/**
	 *流动负债合计比较
	 */
	private Long liabilities;
	/**
	 *所有者股东权益比较
	 */
	private Long shareholdersEquity;
	/**
	 *负债和权益合计比较
	 */
	private Long liabilitiesEquities;
	/**
	 *主营业务利润比较
	 */
	private Long gross;
	/**
	 *营业利润比较
	 */
	private Long operating;
	/**
	 *利润比较
	 */
	private Long profit;
	/**
	 *净利润比较
	 */
	private Long income;
	/**
	 *固定资产合计比较
	 */
	private Long fixedAssets;
	/**
	 *固定资产净值比较
	 */
	private Long fixedAssetsValue;
	//private Long bool;//不存入数据库 ，用来保存当前财务日期是否小于注册日期
	/**
	 *更新时间
	 */
	private String updateTime;
	
	

	
	public FinancialStatement(){
		this.updateTime = DateUtil.getCurrentDate();
	}
	
	//构造函数
	public FinancialStatement(String year){
		this.year = year;
	}
	
	
	/*@ManyToOne(cascade = CascadeType.REFRESH, optional = false,fetch = FetchType.EAGER)    
	@JoinColumn(name="fsId")
	public BasicData getBasicData() {
		return basicData;
	}
	public void setBasicData(BasicData basicData) {
		this.basicData = basicData;
	}*/

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

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public String getCrefoNo() {
		return crefoNo;
	}

	public void setCrefoNo(String crefoNo) {
		this.crefoNo = crefoNo;
	}

	public String getOutFinancial() {
		return outFinancial;
	}

	public void setOutFinancial(String outFinancial) {
		this.outFinancial = outFinancial;
	}

	public String getOutFinancials() {
		return outFinancials;
	}

	public void setOutFinancials(String outFinancials) {
		this.outFinancials = outFinancials;
	}

	public Integer getFinancialSourceId() {
		return financialSourceId;
	}

	public void setFinancialSourceId(Integer financialSourceId) {
		this.financialSourceId = financialSourceId;
	}

//	public Integer getDtId() {
//		return dtId;
//	}
//
//	public void setDtId(Integer dtId) {
//		this.dtId = dtId;
//	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public Integer getFullReportId() {
		return fullReportId;
	}

	public void setFullReportId(Integer fullReportId) {
		this.fullReportId = fullReportId;
	}

	public String getCashAndBank() {
		return cashAndBank;
	}

	public void setCashAndBank(String cashAndBank) {
		this.cashAndBank = cashAndBank;
	}

	public String getShortTermInvestment() {
		return shortTermInvestment;
	}

	public void setShortTermInvestment(String shortTermInvestment) {
		this.shortTermInvestment = shortTermInvestment;
	}

	public String getBillReceivable() {
		return billReceivable;
	}

	public void setBillReceivable(String billReceivable) {
		this.billReceivable = billReceivable;
	}

	public String getAccountReceivable() {
		return accountReceivable;
	}

	public void setAccountReceivable(String accountReceivable) {
		this.accountReceivable = accountReceivable;
	}

	public String getOtherReceivable() {
		return otherReceivable;
	}

	public void setOtherReceivable(String otherReceivable) {
		this.otherReceivable = otherReceivable;
	}

	public String getAdvancesToSuppliers() {
		return advancesToSuppliers;
	}

	public void setAdvancesToSuppliers(String advancesToSuppliers) {
		this.advancesToSuppliers = advancesToSuppliers;
	}

	public String getInventory() {
		return inventory;
	}

	public void setInventory(String inventory) {
		this.inventory = inventory;
	}

	public String getToBeAppointedExpense() {
		return toBeAppointedExpense;
	}

	public void setToBeAppointedExpense(String toBeAppointedExpense) {
		this.toBeAppointedExpense = toBeAppointedExpense;
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

	public String getTotalLongTermInvestment() {
		return totalLongTermInvestment;
	}

	public void setTotalLongTermInvestment(String totalLongTermInvestment) {
		this.totalLongTermInvestment = totalLongTermInvestment;
	}

	public String getFixedAssetsNetValue() {
		return fixedAssetsNetValue;
	}

	public void setFixedAssetsNetValue(String fixedAssetsNetValue) {
		this.fixedAssetsNetValue = fixedAssetsNetValue;
	}

	public String getFixedAssetsAtCost() {
		return fixedAssetsAtCost;
	}

	public void setFixedAssetsAtCost(String fixedAssetsAtCost) {
		this.fixedAssetsAtCost = fixedAssetsAtCost;
	}

	public String getCumulativeDiscounts() {
		return cumulativeDiscounts;
	}

	public void setCumulativeDiscounts(String cumulativeDiscounts) {
		this.cumulativeDiscounts = cumulativeDiscounts;
	}

	public String getProjectsUnderConstruction() {
		return projectsUnderConstruction;
	}

	public void setProjectsUnderConstruction(String projectsUnderConstruction) {
		this.projectsUnderConstruction = projectsUnderConstruction;
	}

	public String getTotalFixedAssets() {
		return totalFixedAssets;
	}

	public void setTotalFixedAssets(String totalFixedAssets) {
		this.totalFixedAssets = totalFixedAssets;
	}

	public String getIntangibleAssets() {
		return intangibleAssets;
	}

	public void setIntangibleAssets(String intangibleAssets) {
		this.intangibleAssets = intangibleAssets;
	}

	public String getLongTermToBeAppointedExpense() {
		return longTermToBeAppointedExpense;
	}

	public void setLongTermToBeAppointedExpense(String longTermToBeAppointedExpense) {
		this.longTermToBeAppointedExpense = longTermToBeAppointedExpense;
	}

	public String getOtherLongTermAssets() {
		return otherLongTermAssets;
	}

	public void setOtherLongTermAssets(String otherLongTermAssets) {
		this.otherLongTermAssets = otherLongTermAssets;
	}

	public String getOtherAssets() {
		return otherAssets;
	}

	public void setOtherAssets(String otherAssets) {
		this.otherAssets = otherAssets;
	}

	public String getDeferredTaxDebit() {
		return deferredTaxDebit;
	}

	public void setDeferredTaxDebit(String deferredTaxDebit) {
		this.deferredTaxDebit = deferredTaxDebit;
	}

	public String getTotalNonCurrentAssets() {
		return totalNonCurrentAssets;
	}

	public void setTotalNonCurrentAssets(String totalNonCurrentAssets) {
		this.totalNonCurrentAssets = totalNonCurrentAssets;
	}

	public String getFinancialSourceCN() {
		return financialSourceCN;
	}

	public void setFinancialSourceCN(String financialSourceCN) {
		this.financialSourceCN = financialSourceCN;
	}

	public String getTotalAssets() {
		return totalAssets;
	}

	public void setTotalAssets(String totalAssets) {
		this.totalAssets = totalAssets;
	}

	public String getShortTermLoans() {
		return shortTermLoans;
	}

	public void setShortTermLoans(String shortTermLoans) {
		this.shortTermLoans = shortTermLoans;
	}

	public String getNotePayable() {
		return notePayable;
	}

	public void setNotePayable(String notePayable) {
		this.notePayable = notePayable;
	}

	public String getAccountsPayable() {
		return accountsPayable;
	}

	public void setAccountsPayable(String accountsPayable) {
		this.accountsPayable = accountsPayable;
	}

	public String getAdvancesFromClients() {
		return advancesFromClients;
	}

	public void setAdvancesFromClients(String advancesFromClients) {
		this.advancesFromClients = advancesFromClients;
	}

	public String getSalariesPayable() {
		return salariesPayable;
	}

	public void setSalariesPayable(String salariesPayable) {
		this.salariesPayable = salariesPayable;
	}

	public String getWelfarePayable() {
		return welfarePayable;
	}

	public void setWelfarePayable(String welfarePayable) {
		this.welfarePayable = welfarePayable;
	}

	public String getTaxesPayable() {
		return taxesPayable;
	}

	public void setTaxesPayable(String taxesPayable) {
		this.taxesPayable = taxesPayable;
	}

	public String getOtherAccountsPayable() {
		return otherAccountsPayable;
	}

	public void setOtherAccountsPayable(String otherAccountsPayable) {
		this.otherAccountsPayable = otherAccountsPayable;
	}

	public String getAccruedExpenses() {
		return accruedExpenses;
	}

	public void setAccruedExpenses(String accruedExpenses) {
		this.accruedExpenses = accruedExpenses;
	}

	public String getOtherCurrentLiabilities() {
		return otherCurrentLiabilities;
	}

	public void setOtherCurrentLiabilities(String otherCurrentLiabilities) {
		this.otherCurrentLiabilities = otherCurrentLiabilities;
	}

	public String getTotalCurrentLiabilites() {
		return totalCurrentLiabilites;
	}

	public void setTotalCurrentLiabilites(String totalCurrentLiabilites) {
		this.totalCurrentLiabilites = totalCurrentLiabilites;
	}

	public String getTotalLongTermLiabilities() {
		return totalLongTermLiabilities;
	}

	public void setTotalLongTermLiabilities(String totalLongTermLiabilities) {
		this.totalLongTermLiabilities = totalLongTermLiabilities;
	}

	public String getLongTermLoan() {
		return longTermLoan;
	}

	public void setLongTermLoan(String longTermLoan) {
		this.longTermLoan = longTermLoan;
	}

	public String getLongTermPayables() {
		return longTermPayables;
	}

	public void setLongTermPayables(String longTermPayables) {
		this.longTermPayables = longTermPayables;
	}

	public String getDeferredTaxCredit() {
		return deferredTaxCredit;
	}

	public void setDeferredTaxCredit(String deferredTaxCredit) {
		this.deferredTaxCredit = deferredTaxCredit;
	}

	public String getOtherLiabilities() {
		return otherLiabilities;
	}

	public void setOtherLiabilities(String otherLiabilities) {
		this.otherLiabilities = otherLiabilities;
	}

	public String getTotalNonCurrentLiabilities() {
		return totalNonCurrentLiabilities;
	}

	public void setTotalNonCurrentLiabilities(String totalNonCurrentLiabilities) {
		this.totalNonCurrentLiabilities = totalNonCurrentLiabilities;
	}

	public String getTotalLiabilities() {
		return totalLiabilities;
	}

	public void setTotalLiabilities(String totalLiabilities) {
		this.totalLiabilities = totalLiabilities;
	}

	public String getPaidUpCapital() {
		return paidUpCapital;
	}

	public void setPaidUpCapital(String paidUpCapital) {
		this.paidUpCapital = paidUpCapital;
	}

	public String getCapitalReserve() {
		return capitalReserve;
	}

	public void setCapitalReserve(String capitalReserve) {
		this.capitalReserve = capitalReserve;
	}

	public String getSurplusReserve() {
		return surplusReserve;
	}

	public void setSurplusReserve(String surplusReserve) {
		this.surplusReserve = surplusReserve;
	}

	public String getUndistributedProfit() {
		return undistributedProfit;
	}

	public void setUndistributedProfit(String undistributedProfit) {
		this.undistributedProfit = undistributedProfit;
	}

	public String getTotalShareholdersEquity() {
		return totalShareholdersEquity;
	}

	public void setTotalShareholdersEquity(String totalShareholdersEquity) {
		this.totalShareholdersEquity = totalShareholdersEquity;
	}

	public String getOtherEquity() {
		return otherEquity;
	}

	public void setOtherEquity(String otherEquity) {
		this.otherEquity = otherEquity;
	}

	public String getTotalLiabilitiesEquities() {
		return totalLiabilitiesEquities;
	}

	public void setTotalLiabilitiesEquities(String totalLiabilitiesEquities) {
		this.totalLiabilitiesEquities = totalLiabilitiesEquities;
	}

	public String getTurnover() {
		return turnover;
	}

	public void setTurnover(String turnover) {
		this.turnover = turnover;
	}

	public String getCostsOfGoodsSold() {
		return costsOfGoodsSold;
	}

	public void setCostsOfGoodsSold(String costsOfGoodsSold) {
		this.costsOfGoodsSold = costsOfGoodsSold;
	}

	public String getSalesTax() {
		return salesTax;
	}

	public void setSalesTax(String salesTax) {
		this.salesTax = salesTax;
	}

	public String getGrossProfit() {
		return grossProfit;
	}

	public void setGrossProfit(String grossProfit) {
		this.grossProfit = grossProfit;
	}

	public String getOtherOperatingProfits() {
		return otherOperatingProfits;
	}

	public void setOtherOperatingProfits(String otherOperatingProfits) {
		this.otherOperatingProfits = otherOperatingProfits;
	}

	public String getSalesExpense() {
		return salesExpense;
	}

	public void setSalesExpense(String salesExpense) {
		this.salesExpense = salesExpense;
	}

	public String getManagementExpense() {
		return managementExpense;
	}

	public void setManagementExpense(String managementExpense) {
		this.managementExpense = managementExpense;
	}

	public String getFinanceExpense() {
		return financeExpense;
	}

	public void setFinanceExpense(String financeExpense) {
		this.financeExpense = financeExpense;
	}

	public String getOperatingProfit() {
		return operatingProfit;
	}

	public void setOperatingProfit(String operatingProfit) {
		this.operatingProfit = operatingProfit;
	}

	public String getInvestmentProfit() {
		return investmentProfit;
	}

	public void setInvestmentProfit(String investmentProfit) {
		this.investmentProfit = investmentProfit;
	}

	public String getAllowanceIncomes() {
		return allowanceIncomes;
	}

	public void setAllowanceIncomes(String allowanceIncomes) {
		this.allowanceIncomes = allowanceIncomes;
	}

	public String getAssetsDevaluation() {
		return assetsDevaluation;
	}

	public void setAssetsDevaluation(String assetsDevaluation) {
		this.assetsDevaluation = assetsDevaluation;
	}

	public String getNonOperatingIncome() {
		return nonOperatingIncome;
	}

	public void setNonOperatingIncome(String nonOperatingIncome) {
		this.nonOperatingIncome = nonOperatingIncome;
	}

	public String getNonOperatingExpense() {
		return nonOperatingExpense;
	}

	public void setNonOperatingExpense(String nonOperatingExpense) {
		this.nonOperatingExpense = nonOperatingExpense;
	}

	public String getProfitBeforeTax() {
		return profitBeforeTax;
	}

	public void setProfitBeforeTax(String profitBeforeTax) {
		this.profitBeforeTax = profitBeforeTax;
	}

	public String getIncomeTax() {
		return incomeTax;
	}

	public void setIncomeTax(String incomeTax) {
		this.incomeTax = incomeTax;
	}

	public String getNetIncome() {
		return netIncome;
	}

	public void setNetIncome(String netIncome) {
		this.netIncome = netIncome;
	}

	public String getSolvencyIndex() {
		return solvencyIndex;
	}

	public void setSolvencyIndex(String solvencyIndex) {
		this.solvencyIndex = solvencyIndex;
	}

	public String getRecommended() {
		return recommended;
	}

	public void setRecommended(String recommended) {
		this.recommended = recommended;
	}

	public Integer getSolvencyIndexId() {
		return solvencyIndexId;
	}

	public void setSolvencyIndexId(Integer solvencyIndexId) {
		this.solvencyIndexId = solvencyIndexId;
	}

	public Long getCurrentAssets() {
		return currentAssets;
	}

	public void setCurrentAssets(Long currentAssets) {
		this.currentAssets = currentAssets;
	}

	public Long getNonCurrentAssets() {
		return nonCurrentAssets;
	}

	public void setNonCurrentAssets(Long nonCurrentAssets) {
		this.nonCurrentAssets = nonCurrentAssets;
	}

	public Long getAssets() {
		return assets;
	}

	public void setAssets(Long assets) {
		this.assets = assets;
	}

	public Long getCurrentLiabilites() {
		return currentLiabilites;
	}

	public void setCurrentLiabilites(Long currentLiabilites) {
		this.currentLiabilites = currentLiabilites;
	}

	public Long getNonCurrentLiabilities() {
		return nonCurrentLiabilities;
	}

	public void setNonCurrentLiabilities(Long nonCurrentLiabilities) {
		this.nonCurrentLiabilities = nonCurrentLiabilities;
	}

	public Long getLiabilities() {
		return liabilities;
	}

	public void setLiabilities(Long liabilities) {
		this.liabilities = liabilities;
	}

	public Long getShareholdersEquity() {
		return shareholdersEquity;
	}

	public void setShareholdersEquity(Long shareholdersEquity) {
		this.shareholdersEquity = shareholdersEquity;
	}

	public Long getLiabilitiesEquities() {
		return liabilitiesEquities;
	}

	public void setLiabilitiesEquities(Long liabilitiesEquities) {
		this.liabilitiesEquities = liabilitiesEquities;
	}

	public Long getGross() {
		return gross;
	}

	public void setGross(Long gross) {
		this.gross = gross;
	}

	public Long getOperating() {
		return operating;
	}

	public void setOperating(Long operating) {
		this.operating = operating;
	}

	public Long getProfit() {
		return profit;
	}

	public void setProfit(Long profit) {
		this.profit = profit;
	}

	public Long getIncome() {
		return income;
	}

	public void setIncome(Long income) {
		this.income = income;
	}

	public Long getFixedAssets() {
		return fixedAssets;
	}

	public void setFixedAssets(Long fixedAssets) {
		this.fixedAssets = fixedAssets;
	}

	public Long getFixedAssetsValue() {
		return fixedAssetsValue;
	}

	public void setFixedAssetsValue(Long fixedAssetsValue) {
		this.fixedAssetsValue = fixedAssetsValue;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getFinancialSourceEN() {
		return financialSourceEN;
	}

	public void setFinancialSourceEN(String financialSourceEN) {
		this.financialSourceEN = financialSourceEN;
	}
}
