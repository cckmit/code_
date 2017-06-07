package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FinancialItems", propOrder = {
	"yearEndDate",
	"costOfSales",
	"grossProfit",
	"badDebts",
	"totalBonds",
	"netCashFlowFromOperations",
	"netIncreaseInLongTermBorrowings",
	"netIncreaseInShortTermBorrowings",
	"netIncreaseInBonds",
	"netCashFromFinancing",
	"netIncreaseInCashAndCashEquivalents",
	"otherOperatingIncome",
	"auditing",
	"judgement",
	"commentary",
	"changeInStock",
	"auditFees",
	"otherOperatingExpenses",
	"extraordinaryNetResult",
	"investmentProperty",
	"contractWorkInProgress",
	"revaluationReserve",
	"minorityInterests",
	"exports",
	"extraordinaryResults",
	"changeInWorkingProgress",
	"cashOfStocks",
	"changeInStocks",
	"taxOnOrdinaryResult",
	"netProfitBeforeMinority",
	"transferAndAllocations",
	"capitalEmployed",
	"auditorRenumeration",
	"generalManagerSalary",
	"researchAndDevelopment",
	"concessions",
	"longTermPensionCommitments",
	"ownShares",
	"cashCoefficient",
	"economicReturnPercantage",
	"financialReturnPercantage",
	"ebitdaOrSalesPercantage",
	"workingCapitalRotation",
	"assetsRotation",
	"liabilitiesDueAfterOneYear",
	"accumulatedAmortisationOfIntangibles",
	"advancePaymentsReceivedForCurrentOrders",
	"translationLoss",
	"totalStateDebt",
	"totalStateDebtLessThan1Year",
	"totalStateDebtBetween1And5Years",
	"totalStateDebGreaterThan5Years",
	"convertibleBonds",
	"convertibleBondsLessThan1Year",
	"convertibleBondsBetween1And5Years",
	"otherBonds",
	"otherBondsLessThan1Year",
	"otherBondsBetween1And5Years",
	"borrowingAndDebtsLessThan1YearAtOrigin",
	"borrowingAndDebtsLessThan1YearAtOriginLessThan1Year",
	"borrowingAndDebtsLessThan1YearAtOriginBetween1And5Years",
	"borrowingAndDebtsGreaterThan1YearAtOrigin",
	"borrowingAndDebtsGreaterThan1YearAtOriginLessThan1Year",
	"borrowingAndDebtsGreaterThan1YearAtOriginBetween1And5Years",
	"loansAndVariousLiabilities",
	"loansAndVariousLiabilitiesLessThan1Year",
	"loansAndVariousLiabilitiesBetween1And5Years",
	"supplierAndAssociatedAccounts",
	"supplierAndAssociatedAccountsLessThan1Year",
	"supplierAndAssociatedAccountsBetween1And5Years",
	"personnelAndAssociatedAccounts",
	"personnelAndAssociatedAccountsLessThan1Year",
	"personnelAndAssociatedAccountsBetween1And5Years",
	"socialSecurityAndOtherSocialOrganizations",
	"socialSecurityAndOtherSocialOrganizationsLessThan1Year",
	"socialSecurityAndOtherSocialOrganizationsBetween1And5Years",
	"taxOnProfits",
	"taxOnProfitsLessThan1Year",
	"taxOnProfitsBetween1And5Years",
	"vat",
	"vatLessThan1Year",
	"vatBetween1And5Years",
	"backedObligations",
	"backedObligationsLessThan1Year",
	"backedObligationsBetween1And5Years",
	"otherTaxesAndAssimilated",
	"otherTaxesAndAssimilatedLessThan1Year",
	"otherTaxesAndAssimilatedBetween1And5Years",
	"assetsAndLiabilitiesAssociatedAccounts",
	"assetsAndLiabilitiesAssociatedAccountsLessThan1Year",
	"assetsAndLiabilitiesAssociatedAccountsBetween1And5Years",
	"assetsAndLiabilitiesAssociatedAccountsGreaterThan5Years",
	"groupsAndAssociates",
	"groupsAndAssociatesLessThan1Year",
	"groupsAndAssociatesBetween1And5Years",
	"groupsAndAssociatesGreaterThan5Years",
	"otherLiabilities",
	"otherLiabilitiesLessThan1Year",
	"otherLiabilitiesBetween1And5Years",
	"debtRepresentativeOfBorrowedSecurities",
	"debtRepresentativeOfBorrowedSecuritiesLessThan1Year",
	"debtRepresentativeOfBorrowedSecuritiesBetween1And5Years",
	"productsInAdvance",
	"productsInAdvanceLessThan1Year",
	"productsInAdvanceBetween1And5Years",
	"rawMaterialsAmortisation",
	"wipGoodsAmortisation",
	"wipServicesGross",
	"wipServicesAmortisation",
	"finishedProductsAmortisation",
	"goodsForResaleAmortisation",
	"advancePaymentsGross",
	"advancePaymentsAmortisation",
	"tradeReceivableAmortisation",
	"otherDebtorsAmortisation",
	"capitalSubscribedGross",
	"capitalSubscribedAmortisation",
	"investmentSecruritiesGross",
	"investmentSecritiesAmortisation",
	"cashAmortisation",
	"prepaidExpensesGross",
	"prepaidExpensesAmortisation",
	"totalProvisionsForRisksAndCharges",
	"fixedAssetLiabilities",
	"otherDebts",
	"translationloss",
	"netTurnover",
	"stockedProduction",
	"selfConstructedAssets",
	"purchaseOfGoodsForResale",
	"changeInStocksOfGoodsForResale",
	"purchaseOfRawMaterials",
	"changeInStocksOfRawMaterials",
	"otherExternalPurchasesAndCharges",
	"operatingResult",
	"extraordinaryResult",
	"operatingGrants",
	"taxDutyAndSimilarPayments",
	"payroll",
	"socialSecurityCosts",
	"interestAndSimilarCharges",
	"preTaxNetOperatingIncome",
	"profitorLoss",
	"totalShareholdersEquity",
	"totalOtherCapitalResources",
	"convertibleDebentures",
	"otherDebentures",
	"bankLoansAndLiabilities",
	"currentBankFacilities",
	"extraordinaryChargesFromCapitalTransactions",
	"extraordinaryReservesandProvisions",
	"extraordinaryIncomeFromCapitalTransactions",
	"releasedExtraordinaryProvisions",
	"financialReservesAndProvisions",
	"releasedFinancialProvisions",
	"depreciationOfFixedAssets",
	"amortisationofFixedAssets",
	"depreciationAmortisationofCurrentAssets",
	"provisionsForRisksandCharges",
	"releaseOfReservesandProvisions",
	"transferredCharges",
	"grandTotalPassive",
	"cashAndCashEquivalentsGross",
	"effectsBroughtToTheDiscountAndUnmatured",
	"sundryLoansAndFinancialLiabilities",
	"totalFixedAssetsGross",
	"totalFixedAssetsAmortisation",
	"totalCurrentAssetsGross",
	"totalCurrentAssetsAmortisation",
	"totalAssetsGross",
	"deferredIncome",
	"totalLiabilitiesEC",
	"saleofGoodsforResale",
	"saleofGoodsProduced",
	"saleofServices",
	"otherIncome",
	"otherCharges",
	"totalFinancialIncome",
	"totalFinancialCharge",
	"totalExtraordinaryIncome",
	"totalExtraordinaryCharges",
	"totalTaxOnProfits",
	"averageNumberofEmployees",
	"tradingMargin",
	"grossOperatingSurplus",
	"ratios",
	"rawMaterialsGross",
	"wipGoodsGross",
	"finishedProductsGross",
	"goodsForResaleGross",
	"tradeReceivableGross",
	"extraordinaryOperatingCharges",
	"extraordinaryOperatingIncome",
	"employeeProfitSharingTotal",
	"taxandSociaLSecurityLiabilities",
	"nonDeclaredDistributedCapital",
	"deferedCharges",
	"premiumsOnRedemptionOfBonds",
	"currencyDifferentialGain",
	"amountVATCollected",
	"totalVatOnGoodsAndServices",
	"profitOrLossForThePeriod",
	"export",
	"directorsEmoluments",
	"shortTermHPFinanceLeaseLiabilities",
	"longTermHPFinanceLeaseLiabilities"
})

public class FinancialItems implements Serializable {

	@XmlElement(name = "YearEndDate")
	protected String yearEndDate;
	public String getYearEndDate() {return yearEndDate;}
	public void setYearEndDate(String value) {this.yearEndDate =  value;}

	@XmlElement(name = "CostOfSales")
	protected String costOfSales;
	public String getCostOfSales() {return costOfSales;}
	public void setCostOfSales(String value) {this.costOfSales =  value;}

	@XmlElement(name = "GrossProfit")
	protected String grossProfit;
	public String getGrossProfit() {return grossProfit;}
	public void setGrossProfit(String value) {this.grossProfit =  value;}

	@XmlElement(name = "BadDebts")
	protected String badDebts;
	public String getBadDebts() {return badDebts;}
	public void setBadDebts(String value) {this.badDebts =  value;}

	@XmlElement(name = "TotalBonds")
	protected String totalBonds;
	public String getTotalBonds() {return totalBonds;}
	public void setTotalBonds(String value) {this.totalBonds =  value;}

	@XmlElement(name = "NetCashFlowFromOperations")
	protected String netCashFlowFromOperations;
	public String getNetCashFlowFromOperations() {return netCashFlowFromOperations;}
	public void setNetCashFlowFromOperations(String value) {this.netCashFlowFromOperations =  value;}

	@XmlElement(name = "NetIncreaseInLongTermBorrowings")
	protected String netIncreaseInLongTermBorrowings;
	public String getNetIncreaseInLongTermBorrowings() {return netIncreaseInLongTermBorrowings;}
	public void setNetIncreaseInLongTermBorrowings(String value) {this.netIncreaseInLongTermBorrowings =  value;}

	@XmlElement(name = "NetIncreaseInShortTermBorrowings")
	protected String netIncreaseInShortTermBorrowings;
	public String getNetIncreaseInShortTermBorrowings() {return netIncreaseInShortTermBorrowings;}
	public void setNetIncreaseInShortTermBorrowings(String value) {this.netIncreaseInShortTermBorrowings =  value;}

	@XmlElement(name = "NetIncreaseInBonds")
	protected String netIncreaseInBonds;
	public String getNetIncreaseInBonds() {return netIncreaseInBonds;}
	public void setNetIncreaseInBonds(String value) {this.netIncreaseInBonds =  value;}

	@XmlElement(name = "NetCashFromFinancing")
	protected String netCashFromFinancing;
	public String getNetCashFromFinancing() {return netCashFromFinancing;}
	public void setNetCashFromFinancing(String value) {this.netCashFromFinancing =  value;}

	@XmlElement(name = "NetIncreaseInCashAndCashEquivalents")
	protected String netIncreaseInCashAndCashEquivalents;
	public String getNetIncreaseInCashAndCashEquivalents() {return netIncreaseInCashAndCashEquivalents;}
	public void setNetIncreaseInCashAndCashEquivalents(String value) {this.netIncreaseInCashAndCashEquivalents =  value;}

	@XmlElement(name = "OtherOperatingIncome")
	protected String otherOperatingIncome;
	public String getOtherOperatingIncome() {return otherOperatingIncome;}
	public void setOtherOperatingIncome(String value) {this.otherOperatingIncome =  value;}

	@XmlElement(name = "Auditing")
	protected String auditing;
	public String getAuditing() {return auditing;}
	public void setAuditing(String value) {this.auditing =  value;}

	@XmlElement(name = "Judgement")
	protected String judgement;
	public String getJudgement() {return judgement;}
	public void setJudgement(String value) {this.judgement =  value;}

	@XmlElement(name = "Commentary")
	protected String commentary;
	public String getCommentary() {return commentary;}
	public void setCommentary(String value) {this.commentary =  value;}

	@XmlElement(name = "ChangeInStock")
	protected String changeInStock;
	public String getChangeInStock() {return changeInStock;}
	public void setChangeInStock(String value) {this.changeInStock =  value;}

	@XmlElement(name = "AuditFees")
	protected String auditFees;
	public String getAuditFees() {return auditFees;}
	public void setAuditFees(String value) {this.auditFees =  value;}

	@XmlElement(name = "OtherOperatingExpenses")
	protected String otherOperatingExpenses;
	public String getOtherOperatingExpenses() {return otherOperatingExpenses;}
	public void setOtherOperatingExpenses(String value) {this.otherOperatingExpenses =  value;}

	@XmlElement(name = "ExtraordinaryNetResult")
	protected String extraordinaryNetResult;
	public String getExtraordinaryNetResult() {return extraordinaryNetResult;}
	public void setExtraordinaryNetResult(String value) {this.extraordinaryNetResult =  value;}

	@XmlElement(name = "InvestmentProperty")
	protected String investmentProperty;
	public String getInvestmentProperty() {return investmentProperty;}
	public void setInvestmentProperty(String value) {this.investmentProperty =  value;}

	@XmlElement(name = "ContractWorkInProgress")
	protected String contractWorkInProgress;
	public String getContractWorkInProgress() {return contractWorkInProgress;}
	public void setContractWorkInProgress(String value) {this.contractWorkInProgress =  value;}

	@XmlElement(name = "RevaluationReserve")
	protected String revaluationReserve;
	public String getRevaluationReserve() {return revaluationReserve;}
	public void setRevaluationReserve(String value) {this.revaluationReserve =  value;}

	@XmlElement(name = "MinorityInterests")
	protected String minorityInterests;
	public String getMinorityInterests() {return minorityInterests;}
	public void setMinorityInterests(String value) {this.minorityInterests =  value;}

	@XmlElement(name = "Exports")
	protected String exports;
	public String getExports() {return exports;}
	public void setExports(String value) {this.exports =  value;}

	@XmlElement(name = "ExtraordinaryResults")
	protected String extraordinaryResults;
	public String getExtraordinaryResults() {return extraordinaryResults;}
	public void setExtraordinaryResults(String value) {this.extraordinaryResults =  value;}

	@XmlElement(name = "ChangeInWorkingProgress")
	protected String changeInWorkingProgress;
	public String getChangeInWorkingProgress() {return changeInWorkingProgress;}
	public void setChangeInWorkingProgress(String value) {this.changeInWorkingProgress =  value;}

	@XmlElement(name = "CashOfStocks")
	protected String cashOfStocks;
	public String getCashOfStocks() {return cashOfStocks;}
	public void setCashOfStocks(String value) {this.cashOfStocks =  value;}

	@XmlElement(name = "ChangeInStocks")
	protected String changeInStocks;
	public String getChangeInStocks() {return changeInStocks;}
	public void setChangeInStocks(String value) {this.changeInStocks =  value;}

	@XmlElement(name = "TaxOnOrdinaryResult")
	protected String taxOnOrdinaryResult;
	public String getTaxOnOrdinaryResult() {return taxOnOrdinaryResult;}
	public void setTaxOnOrdinaryResult(String value) {this.taxOnOrdinaryResult =  value;}

	@XmlElement(name = "NetProfitBeforeMinority")
	protected String netProfitBeforeMinority;
	public String getNetProfitBeforeMinority() {return netProfitBeforeMinority;}
	public void setNetProfitBeforeMinority(String value) {this.netProfitBeforeMinority =  value;}

	@XmlElement(name = "TransferAndAllocations")
	protected String transferAndAllocations;
	public String getTransferAndAllocations() {return transferAndAllocations;}
	public void setTransferAndAllocations(String value) {this.transferAndAllocations =  value;}

	@XmlElement(name = "CapitalEmployed")
	protected String capitalEmployed;
	public String getCapitalEmployed() {return capitalEmployed;}
	public void setCapitalEmployed(String value) {this.capitalEmployed =  value;}

	@XmlElement(name = "AuditorRenumeration")
	protected String auditorRenumeration;
	public String getAuditorRenumeration() {return auditorRenumeration;}
	public void setAuditorRenumeration(String value) {this.auditorRenumeration =  value;}

	@XmlElement(name = "GeneralManagerSalary")
	protected String generalManagerSalary;
	public String getGeneralManagerSalary() {return generalManagerSalary;}
	public void setGeneralManagerSalary(String value) {this.generalManagerSalary =  value;}

	@XmlElement(name = "ResearchAndDevelopment")
	protected String researchAndDevelopment;
	public String getResearchAndDevelopment() {return researchAndDevelopment;}
	public void setResearchAndDevelopment(String value) {this.researchAndDevelopment =  value;}

	@XmlElement(name = "Concessions")
	protected String concessions;
	public String getConcessions() {return concessions;}
	public void setConcessions(String value) {this.concessions =  value;}

	@XmlElement(name = "LongTermPensionCommitments")
	protected String longTermPensionCommitments;
	public String getLongTermPensionCommitments() {return longTermPensionCommitments;}
	public void setLongTermPensionCommitments(String value) {this.longTermPensionCommitments =  value;}

	@XmlElement(name = "OwnShares")
	protected String ownShares;
	public String getOwnShares() {return ownShares;}
	public void setOwnShares(String value) {this.ownShares =  value;}

	@XmlElement(name = "CashCoefficient")
	protected String cashCoefficient;
	public String getCashCoefficient() {return cashCoefficient;}
	public void setCashCoefficient(String value) {this.cashCoefficient =  value;}

	@XmlElement(name = "EconomicReturnPercantage")
	protected String economicReturnPercantage;
	public String getEconomicReturnPercantage() {return economicReturnPercantage;}
	public void setEconomicReturnPercantage(String value) {this.economicReturnPercantage =  value;}

	@XmlElement(name = "FinancialReturnPercantage")
	protected String financialReturnPercantage;
	public String getFinancialReturnPercantage() {return financialReturnPercantage;}
	public void setFinancialReturnPercantage(String value) {this.financialReturnPercantage =  value;}

	@XmlElement(name = "EBITDAOrSalesPercantage")
	protected String ebitdaOrSalesPercantage;
	public String getEbitdaOrSalesPercantage() {return ebitdaOrSalesPercantage;}
	public void setEbitdaOrSalesPercantage(String value) {this.ebitdaOrSalesPercantage =  value;}

	@XmlElement(name = "WorkingCapitalRotation")
	protected String workingCapitalRotation;
	public String getWorkingCapitalRotation() {return workingCapitalRotation;}
	public void setWorkingCapitalRotation(String value) {this.workingCapitalRotation =  value;}

	@XmlElement(name = "AssetsRotation")
	protected String assetsRotation;
	public String getAssetsRotation() {return assetsRotation;}
	public void setAssetsRotation(String value) {this.assetsRotation =  value;}

	@XmlElement(name = "LiabilitiesDueAfterOneYear")
	protected String liabilitiesDueAfterOneYear;
	public String getLiabilitiesDueAfterOneYear() {return liabilitiesDueAfterOneYear;}
	public void setLiabilitiesDueAfterOneYear(String value) {this.liabilitiesDueAfterOneYear =  value;}

	@XmlElement(name = "AccumulatedAmortisationOfIntangibles")
	protected String accumulatedAmortisationOfIntangibles;
	public String getAccumulatedAmortisationOfIntangibles() {return accumulatedAmortisationOfIntangibles;}
	public void setAccumulatedAmortisationOfIntangibles(String value) {this.accumulatedAmortisationOfIntangibles =  value;}

	@XmlElement(name = "AdvancePaymentsReceivedForCurrentOrders")
	protected String advancePaymentsReceivedForCurrentOrders;
	public String getAdvancePaymentsReceivedForCurrentOrders() {return advancePaymentsReceivedForCurrentOrders;}
	public void setAdvancePaymentsReceivedForCurrentOrders(String value) {this.advancePaymentsReceivedForCurrentOrders =  value;}

	@XmlElement(name = "TranslationLoss")
	protected String translationLoss;
	public String getTranslationLoss() {return translationLoss;}
	public void setTranslationLoss(String value) {this.translationLoss =  value;}

	@XmlElement(name = "TotalStateDebt")
	protected String totalStateDebt;
	public String getTotalStateDebt() {return totalStateDebt;}
	public void setTotalStateDebt(String value) {this.totalStateDebt =  value;}

	@XmlElement(name = "TotalStateDebtLessThan1Year")
	protected String totalStateDebtLessThan1Year;
	public String getTotalStateDebtLessThan1Year() {return totalStateDebtLessThan1Year;}
	public void setTotalStateDebtLessThan1Year(String value) {this.totalStateDebtLessThan1Year =  value;}

	@XmlElement(name = "TotalStateDebtBetween1And5Years")
	protected String totalStateDebtBetween1And5Years;
	public String getTotalStateDebtBetween1And5Years() {return totalStateDebtBetween1And5Years;}
	public void setTotalStateDebtBetween1And5Years(String value) {this.totalStateDebtBetween1And5Years =  value;}

	@XmlElement(name = "TotalStateDebGreaterThan5Years")
	protected String totalStateDebGreaterThan5Years;
	public String getTotalStateDebGreaterThan5Years() {return totalStateDebGreaterThan5Years;}
	public void setTotalStateDebGreaterThan5Years(String value) {this.totalStateDebGreaterThan5Years =  value;}

	@XmlElement(name = "ConvertibleBonds")
	protected String convertibleBonds;
	public String getConvertibleBonds() {return convertibleBonds;}
	public void setConvertibleBonds(String value) {this.convertibleBonds =  value;}

	@XmlElement(name = "ConvertibleBondsLessThan1Year")
	protected String convertibleBondsLessThan1Year;
	public String getConvertibleBondsLessThan1Year() {return convertibleBondsLessThan1Year;}
	public void setConvertibleBondsLessThan1Year(String value) {this.convertibleBondsLessThan1Year =  value;}

	@XmlElement(name = "ConvertibleBondsBetween1And5Years")
	protected String convertibleBondsBetween1And5Years;
	public String getConvertibleBondsBetween1And5Years() {return convertibleBondsBetween1And5Years;}
	public void setConvertibleBondsBetween1And5Years(String value) {this.convertibleBondsBetween1And5Years =  value;}

	@XmlElement(name = "OtherBonds")
	protected String otherBonds;
	public String getOtherBonds() {return otherBonds;}
	public void setOtherBonds(String value) {this.otherBonds =  value;}

	@XmlElement(name = "OtherBondsLessThan1Year")
	protected String otherBondsLessThan1Year;
	public String getOtherBondsLessThan1Year() {return otherBondsLessThan1Year;}
	public void setOtherBondsLessThan1Year(String value) {this.otherBondsLessThan1Year =  value;}

	@XmlElement(name = "OtherBondsBetween1And5Years")
	protected String otherBondsBetween1And5Years;
	public String getOtherBondsBetween1And5Years() {return otherBondsBetween1And5Years;}
	public void setOtherBondsBetween1And5Years(String value) {this.otherBondsBetween1And5Years =  value;}

	@XmlElement(name = "BorrowingAndDebtsLessThan1YearAtOrigin")
	protected String borrowingAndDebtsLessThan1YearAtOrigin;
	public String getBorrowingAndDebtsLessThan1YearAtOrigin() {return borrowingAndDebtsLessThan1YearAtOrigin;}
	public void setBorrowingAndDebtsLessThan1YearAtOrigin(String value) {this.borrowingAndDebtsLessThan1YearAtOrigin =  value;}

	@XmlElement(name = "BorrowingAndDebtsLessThan1YearAtOriginLessThan1Year")
	protected String borrowingAndDebtsLessThan1YearAtOriginLessThan1Year;
	public String getBorrowingAndDebtsLessThan1YearAtOriginLessThan1Year() {return borrowingAndDebtsLessThan1YearAtOriginLessThan1Year;}
	public void setBorrowingAndDebtsLessThan1YearAtOriginLessThan1Year(String value) {this.borrowingAndDebtsLessThan1YearAtOriginLessThan1Year =  value;}

	@XmlElement(name = "BorrowingAndDebtsLessThan1YearAtOriginBetween1And5Years")
	protected String borrowingAndDebtsLessThan1YearAtOriginBetween1And5Years;
	public String getBorrowingAndDebtsLessThan1YearAtOriginBetween1And5Years() {return borrowingAndDebtsLessThan1YearAtOriginBetween1And5Years;}
	public void setBorrowingAndDebtsLessThan1YearAtOriginBetween1And5Years(String value) {this.borrowingAndDebtsLessThan1YearAtOriginBetween1And5Years =  value;}

	@XmlElement(name = "BorrowingAndDebtsGreaterThan1YearAtOrigin")
	protected String borrowingAndDebtsGreaterThan1YearAtOrigin;
	public String getBorrowingAndDebtsGreaterThan1YearAtOrigin() {return borrowingAndDebtsGreaterThan1YearAtOrigin;}
	public void setBorrowingAndDebtsGreaterThan1YearAtOrigin(String value) {this.borrowingAndDebtsGreaterThan1YearAtOrigin =  value;}

	@XmlElement(name = "BorrowingAndDebtsGreaterThan1YearAtOriginLessThan1Year")
	protected String borrowingAndDebtsGreaterThan1YearAtOriginLessThan1Year;
	public String getBorrowingAndDebtsGreaterThan1YearAtOriginLessThan1Year() {return borrowingAndDebtsGreaterThan1YearAtOriginLessThan1Year;}
	public void setBorrowingAndDebtsGreaterThan1YearAtOriginLessThan1Year(String value) {this.borrowingAndDebtsGreaterThan1YearAtOriginLessThan1Year =  value;}

	@XmlElement(name = "BorrowingAndDebtsGreaterThan1YearAtOriginBetween1And5Years")
	protected String borrowingAndDebtsGreaterThan1YearAtOriginBetween1And5Years;
	public String getBorrowingAndDebtsGreaterThan1YearAtOriginBetween1And5Years() {return borrowingAndDebtsGreaterThan1YearAtOriginBetween1And5Years;}
	public void setBorrowingAndDebtsGreaterThan1YearAtOriginBetween1And5Years(String value) {this.borrowingAndDebtsGreaterThan1YearAtOriginBetween1And5Years =  value;}

	@XmlElement(name = "LoansAndVariousLiabilities")
	protected String loansAndVariousLiabilities;
	public String getLoansAndVariousLiabilities() {return loansAndVariousLiabilities;}
	public void setLoansAndVariousLiabilities(String value) {this.loansAndVariousLiabilities =  value;}

	@XmlElement(name = "LoansAndVariousLiabilitiesLessThan1Year")
	protected String loansAndVariousLiabilitiesLessThan1Year;
	public String getLoansAndVariousLiabilitiesLessThan1Year() {return loansAndVariousLiabilitiesLessThan1Year;}
	public void setLoansAndVariousLiabilitiesLessThan1Year(String value) {this.loansAndVariousLiabilitiesLessThan1Year =  value;}

	@XmlElement(name = "LoansAndVariousLiabilitiesBetween1And5Years")
	protected String loansAndVariousLiabilitiesBetween1And5Years;
	public String getLoansAndVariousLiabilitiesBetween1And5Years() {return loansAndVariousLiabilitiesBetween1And5Years;}
	public void setLoansAndVariousLiabilitiesBetween1And5Years(String value) {this.loansAndVariousLiabilitiesBetween1And5Years =  value;}

	@XmlElement(name = "SupplierAndAssociatedAccounts")
	protected String supplierAndAssociatedAccounts;
	public String getSupplierAndAssociatedAccounts() {return supplierAndAssociatedAccounts;}
	public void setSupplierAndAssociatedAccounts(String value) {this.supplierAndAssociatedAccounts =  value;}

	@XmlElement(name = "SupplierAndAssociatedAccountsLessThan1Year")
	protected String supplierAndAssociatedAccountsLessThan1Year;
	public String getSupplierAndAssociatedAccountsLessThan1Year() {return supplierAndAssociatedAccountsLessThan1Year;}
	public void setSupplierAndAssociatedAccountsLessThan1Year(String value) {this.supplierAndAssociatedAccountsLessThan1Year =  value;}

	@XmlElement(name = "SupplierAndAssociatedAccountsBetween1And5Years")
	protected String supplierAndAssociatedAccountsBetween1And5Years;
	public String getSupplierAndAssociatedAccountsBetween1And5Years() {return supplierAndAssociatedAccountsBetween1And5Years;}
	public void setSupplierAndAssociatedAccountsBetween1And5Years(String value) {this.supplierAndAssociatedAccountsBetween1And5Years =  value;}

	@XmlElement(name = "PersonnelAndAssociatedAccounts")
	protected String personnelAndAssociatedAccounts;
	public String getPersonnelAndAssociatedAccounts() {return personnelAndAssociatedAccounts;}
	public void setPersonnelAndAssociatedAccounts(String value) {this.personnelAndAssociatedAccounts =  value;}

	@XmlElement(name = "PersonnelAndAssociatedAccountsLessThan1Year")
	protected String personnelAndAssociatedAccountsLessThan1Year;
	public String getPersonnelAndAssociatedAccountsLessThan1Year() {return personnelAndAssociatedAccountsLessThan1Year;}
	public void setPersonnelAndAssociatedAccountsLessThan1Year(String value) {this.personnelAndAssociatedAccountsLessThan1Year =  value;}

	@XmlElement(name = "PersonnelAndAssociatedAccountsBetween1And5Years")
	protected String personnelAndAssociatedAccountsBetween1And5Years;
	public String getPersonnelAndAssociatedAccountsBetween1And5Years() {return personnelAndAssociatedAccountsBetween1And5Years;}
	public void setPersonnelAndAssociatedAccountsBetween1And5Years(String value) {this.personnelAndAssociatedAccountsBetween1And5Years =  value;}

	@XmlElement(name = "SocialSecurityAndOtherSocialOrganizations")
	protected String socialSecurityAndOtherSocialOrganizations;
	public String getSocialSecurityAndOtherSocialOrganizations() {return socialSecurityAndOtherSocialOrganizations;}
	public void setSocialSecurityAndOtherSocialOrganizations(String value) {this.socialSecurityAndOtherSocialOrganizations =  value;}

	@XmlElement(name = "SocialSecurityAndOtherSocialOrganizationsLessThan1Year")
	protected String socialSecurityAndOtherSocialOrganizationsLessThan1Year;
	public String getSocialSecurityAndOtherSocialOrganizationsLessThan1Year() {return socialSecurityAndOtherSocialOrganizationsLessThan1Year;}
	public void setSocialSecurityAndOtherSocialOrganizationsLessThan1Year(String value) {this.socialSecurityAndOtherSocialOrganizationsLessThan1Year =  value;}

	@XmlElement(name = "SocialSecurityAndOtherSocialOrganizationsBetween1And5Years")
	protected String socialSecurityAndOtherSocialOrganizationsBetween1And5Years;
	public String getSocialSecurityAndOtherSocialOrganizationsBetween1And5Years() {return socialSecurityAndOtherSocialOrganizationsBetween1And5Years;}
	public void setSocialSecurityAndOtherSocialOrganizationsBetween1And5Years(String value) {this.socialSecurityAndOtherSocialOrganizationsBetween1And5Years =  value;}

	@XmlElement(name = "TaxOnProfits")
	protected String taxOnProfits;
	public String getTaxOnProfits() {return taxOnProfits;}
	public void setTaxOnProfits(String value) {this.taxOnProfits =  value;}

	@XmlElement(name = "TaxOnProfitsLessThan1Year")
	protected String taxOnProfitsLessThan1Year;
	public String getTaxOnProfitsLessThan1Year() {return taxOnProfitsLessThan1Year;}
	public void setTaxOnProfitsLessThan1Year(String value) {this.taxOnProfitsLessThan1Year =  value;}

	@XmlElement(name = "TaxOnProfitsBetween1And5Years")
	protected String taxOnProfitsBetween1And5Years;
	public String getTaxOnProfitsBetween1And5Years() {return taxOnProfitsBetween1And5Years;}
	public void setTaxOnProfitsBetween1And5Years(String value) {this.taxOnProfitsBetween1And5Years =  value;}

	@XmlElement(name = "Vat")
	protected String vat;
	public String getVat() {return vat;}
	public void setVat(String value) {this.vat =  value;}

	@XmlElement(name = "VatLessThan1Year")
	protected String vatLessThan1Year;
	public String getVatLessThan1Year() {return vatLessThan1Year;}
	public void setVatLessThan1Year(String value) {this.vatLessThan1Year =  value;}

	@XmlElement(name = "VatBetween1And5Years")
	protected String vatBetween1And5Years;
	public String getVatBetween1And5Years() {return vatBetween1And5Years;}
	public void setVatBetween1And5Years(String value) {this.vatBetween1And5Years =  value;}

	@XmlElement(name = "BackedObligations")
	protected String backedObligations;
	public String getBackedObligations() {return backedObligations;}
	public void setBackedObligations(String value) {this.backedObligations =  value;}

	@XmlElement(name = "BackedObligationsLessThan1Year")
	protected String backedObligationsLessThan1Year;
	public String getBackedObligationsLessThan1Year() {return backedObligationsLessThan1Year;}
	public void setBackedObligationsLessThan1Year(String value) {this.backedObligationsLessThan1Year =  value;}

	@XmlElement(name = "BackedObligationsBetween1And5Years")
	protected String backedObligationsBetween1And5Years;
	public String getBackedObligationsBetween1And5Years() {return backedObligationsBetween1And5Years;}
	public void setBackedObligationsBetween1And5Years(String value) {this.backedObligationsBetween1And5Years =  value;}

	@XmlElement(name = "OtherTaxesAndAssimilated")
	protected String otherTaxesAndAssimilated;
	public String getOtherTaxesAndAssimilated() {return otherTaxesAndAssimilated;}
	public void setOtherTaxesAndAssimilated(String value) {this.otherTaxesAndAssimilated =  value;}

	@XmlElement(name = "OtherTaxesAndAssimilatedLessThan1Year")
	protected String otherTaxesAndAssimilatedLessThan1Year;
	public String getOtherTaxesAndAssimilatedLessThan1Year() {return otherTaxesAndAssimilatedLessThan1Year;}
	public void setOtherTaxesAndAssimilatedLessThan1Year(String value) {this.otherTaxesAndAssimilatedLessThan1Year =  value;}

	@XmlElement(name = "OtherTaxesAndAssimilatedBetween1And5Years")
	protected String otherTaxesAndAssimilatedBetween1And5Years;
	public String getOtherTaxesAndAssimilatedBetween1And5Years() {return otherTaxesAndAssimilatedBetween1And5Years;}
	public void setOtherTaxesAndAssimilatedBetween1And5Years(String value) {this.otherTaxesAndAssimilatedBetween1And5Years =  value;}

	@XmlElement(name = "AssetsAndLiabilitiesAssociatedAccounts")
	protected String assetsAndLiabilitiesAssociatedAccounts;
	public String getAssetsAndLiabilitiesAssociatedAccounts() {return assetsAndLiabilitiesAssociatedAccounts;}
	public void setAssetsAndLiabilitiesAssociatedAccounts(String value) {this.assetsAndLiabilitiesAssociatedAccounts =  value;}

	@XmlElement(name = "AssetsAndLiabilitiesAssociatedAccountsLessThan1Year")
	protected String assetsAndLiabilitiesAssociatedAccountsLessThan1Year;
	public String getAssetsAndLiabilitiesAssociatedAccountsLessThan1Year() {return assetsAndLiabilitiesAssociatedAccountsLessThan1Year;}
	public void setAssetsAndLiabilitiesAssociatedAccountsLessThan1Year(String value) {this.assetsAndLiabilitiesAssociatedAccountsLessThan1Year =  value;}

	@XmlElement(name = "AssetsAndLiabilitiesAssociatedAccountsBetween1And5Years")
	protected String assetsAndLiabilitiesAssociatedAccountsBetween1And5Years;
	public String getAssetsAndLiabilitiesAssociatedAccountsBetween1And5Years() {return assetsAndLiabilitiesAssociatedAccountsBetween1And5Years;}
	public void setAssetsAndLiabilitiesAssociatedAccountsBetween1And5Years(String value) {this.assetsAndLiabilitiesAssociatedAccountsBetween1And5Years =  value;}

	@XmlElement(name = "AssetsAndLiabilitiesAssociatedAccountsGreaterThan5Years")
	protected String assetsAndLiabilitiesAssociatedAccountsGreaterThan5Years;
	public String getAssetsAndLiabilitiesAssociatedAccountsGreaterThan5Years() {return assetsAndLiabilitiesAssociatedAccountsGreaterThan5Years;}
	public void setAssetsAndLiabilitiesAssociatedAccountsGreaterThan5Years(String value) {this.assetsAndLiabilitiesAssociatedAccountsGreaterThan5Years =  value;}

	@XmlElement(name = "GroupsAndAssociates")
	protected String groupsAndAssociates;
	public String getGroupsAndAssociates() {return groupsAndAssociates;}
	public void setGroupsAndAssociates(String value) {this.groupsAndAssociates =  value;}

	@XmlElement(name = "GroupsAndAssociatesLessThan1Year")
	protected String groupsAndAssociatesLessThan1Year;
	public String getGroupsAndAssociatesLessThan1Year() {return groupsAndAssociatesLessThan1Year;}
	public void setGroupsAndAssociatesLessThan1Year(String value) {this.groupsAndAssociatesLessThan1Year =  value;}

	@XmlElement(name = "GroupsAndAssociatesBetween1And5Years")
	protected String groupsAndAssociatesBetween1And5Years;
	public String getGroupsAndAssociatesBetween1And5Years() {return groupsAndAssociatesBetween1And5Years;}
	public void setGroupsAndAssociatesBetween1And5Years(String value) {this.groupsAndAssociatesBetween1And5Years =  value;}

	@XmlElement(name = "GroupsAndAssociatesGreaterThan5Years")
	protected String groupsAndAssociatesGreaterThan5Years;
	public String getGroupsAndAssociatesGreaterThan5Years() {return groupsAndAssociatesGreaterThan5Years;}
	public void setGroupsAndAssociatesGreaterThan5Years(String value) {this.groupsAndAssociatesGreaterThan5Years =  value;}

	@XmlElement(name = "OtherLiabilities")
	protected String otherLiabilities;
	public String getOtherLiabilities() {return otherLiabilities;}
	public void setOtherLiabilities(String value) {this.otherLiabilities =  value;}

	@XmlElement(name = "OtherLiabilitiesLessThan1Year")
	protected String otherLiabilitiesLessThan1Year;
	public String getOtherLiabilitiesLessThan1Year() {return otherLiabilitiesLessThan1Year;}
	public void setOtherLiabilitiesLessThan1Year(String value) {this.otherLiabilitiesLessThan1Year =  value;}

	@XmlElement(name = "OtherLiabilitiesBetween1And5Years")
	protected String otherLiabilitiesBetween1And5Years;
	public String getOtherLiabilitiesBetween1And5Years() {return otherLiabilitiesBetween1And5Years;}
	public void setOtherLiabilitiesBetween1And5Years(String value) {this.otherLiabilitiesBetween1And5Years =  value;}

	@XmlElement(name = "DebtRepresentativeOfBorrowedSecurities")
	protected String debtRepresentativeOfBorrowedSecurities;
	public String getDebtRepresentativeOfBorrowedSecurities() {return debtRepresentativeOfBorrowedSecurities;}
	public void setDebtRepresentativeOfBorrowedSecurities(String value) {this.debtRepresentativeOfBorrowedSecurities =  value;}

	@XmlElement(name = "DebtRepresentativeOfBorrowedSecuritiesLessThan1Year")
	protected String debtRepresentativeOfBorrowedSecuritiesLessThan1Year;
	public String getDebtRepresentativeOfBorrowedSecuritiesLessThan1Year() {return debtRepresentativeOfBorrowedSecuritiesLessThan1Year;}
	public void setDebtRepresentativeOfBorrowedSecuritiesLessThan1Year(String value) {this.debtRepresentativeOfBorrowedSecuritiesLessThan1Year =  value;}

	@XmlElement(name = "DebtRepresentativeOfBorrowedSecuritiesBetween1And5Years")
	protected String debtRepresentativeOfBorrowedSecuritiesBetween1And5Years;
	public String getDebtRepresentativeOfBorrowedSecuritiesBetween1And5Years() {return debtRepresentativeOfBorrowedSecuritiesBetween1And5Years;}
	public void setDebtRepresentativeOfBorrowedSecuritiesBetween1And5Years(String value) {this.debtRepresentativeOfBorrowedSecuritiesBetween1And5Years =  value;}

	@XmlElement(name = "ProductsInAdvance")
	protected String productsInAdvance;
	public String getProductsInAdvance() {return productsInAdvance;}
	public void setProductsInAdvance(String value) {this.productsInAdvance =  value;}

	@XmlElement(name = "ProductsInAdvanceLessThan1Year")
	protected String productsInAdvanceLessThan1Year;
	public String getProductsInAdvanceLessThan1Year() {return productsInAdvanceLessThan1Year;}
	public void setProductsInAdvanceLessThan1Year(String value) {this.productsInAdvanceLessThan1Year =  value;}

	@XmlElement(name = "ProductsInAdvanceBetween1And5Years")
	protected String productsInAdvanceBetween1And5Years;
	public String getProductsInAdvanceBetween1And5Years() {return productsInAdvanceBetween1And5Years;}
	public void setProductsInAdvanceBetween1And5Years(String value) {this.productsInAdvanceBetween1And5Years =  value;}

	@XmlElement(name = "RawMaterialsAmortisation")
	protected String rawMaterialsAmortisation;
	public String getRawMaterialsAmortisation() {return rawMaterialsAmortisation;}
	public void setRawMaterialsAmortisation(String value) {this.rawMaterialsAmortisation =  value;}

	@XmlElement(name = "WIPGoodsAmortisation")
	protected String wipGoodsAmortisation;
	public String getWipGoodsAmortisation() {return wipGoodsAmortisation;}
	public void setWipGoodsAmortisation(String value) {this.wipGoodsAmortisation =  value;}

	@XmlElement(name = "WIPServicesGross")
	protected String wipServicesGross;
	public String getWipServicesGross() {return wipServicesGross;}
	public void setWipServicesGross(String value) {this.wipServicesGross =  value;}

	@XmlElement(name = "WIPServicesAmortisation")
	protected String wipServicesAmortisation;
	public String getWipServicesAmortisation() {return wipServicesAmortisation;}
	public void setWipServicesAmortisation(String value) {this.wipServicesAmortisation =  value;}

	@XmlElement(name = "FinishedProductsAmortisation")
	protected String finishedProductsAmortisation;
	public String getFinishedProductsAmortisation() {return finishedProductsAmortisation;}
	public void setFinishedProductsAmortisation(String value) {this.finishedProductsAmortisation =  value;}

	@XmlElement(name = "GoodsForResaleAmortisation")
	protected String goodsForResaleAmortisation;
	public String getGoodsForResaleAmortisation() {return goodsForResaleAmortisation;}
	public void setGoodsForResaleAmortisation(String value) {this.goodsForResaleAmortisation =  value;}

	@XmlElement(name = "AdvancePaymentsGross")
	protected String advancePaymentsGross;
	public String getAdvancePaymentsGross() {return advancePaymentsGross;}
	public void setAdvancePaymentsGross(String value) {this.advancePaymentsGross =  value;}

	@XmlElement(name = "AdvancePaymentsAmortisation")
	protected String advancePaymentsAmortisation;
	public String getAdvancePaymentsAmortisation() {return advancePaymentsAmortisation;}
	public void setAdvancePaymentsAmortisation(String value) {this.advancePaymentsAmortisation =  value;}

	@XmlElement(name = "TradeReceivableAmortisation")
	protected String tradeReceivableAmortisation;
	public String getTradeReceivableAmortisation() {return tradeReceivableAmortisation;}
	public void setTradeReceivableAmortisation(String value) {this.tradeReceivableAmortisation =  value;}

	@XmlElement(name = "OtherDebtorsAmortisation")
	protected String otherDebtorsAmortisation;
	public String getOtherDebtorsAmortisation() {return otherDebtorsAmortisation;}
	public void setOtherDebtorsAmortisation(String value) {this.otherDebtorsAmortisation =  value;}

	@XmlElement(name = "CapitalSubscribedGross")
	protected String capitalSubscribedGross;
	public String getCapitalSubscribedGross() {return capitalSubscribedGross;}
	public void setCapitalSubscribedGross(String value) {this.capitalSubscribedGross =  value;}

	@XmlElement(name = "CapitalSubscribedAmortisation")
	protected String capitalSubscribedAmortisation;
	public String getCapitalSubscribedAmortisation() {return capitalSubscribedAmortisation;}
	public void setCapitalSubscribedAmortisation(String value) {this.capitalSubscribedAmortisation =  value;}

	@XmlElement(name = "InvestmentSecruritiesGross")
	protected String investmentSecruritiesGross;
	public String getInvestmentSecruritiesGross() {return investmentSecruritiesGross;}
	public void setInvestmentSecruritiesGross(String value) {this.investmentSecruritiesGross =  value;}

	@XmlElement(name = "InvestmentSecritiesAmortisation")
	protected String investmentSecritiesAmortisation;
	public String getInvestmentSecritiesAmortisation() {return investmentSecritiesAmortisation;}
	public void setInvestmentSecritiesAmortisation(String value) {this.investmentSecritiesAmortisation =  value;}

	@XmlElement(name = "CashAmortisation")
	protected String cashAmortisation;
	public String getCashAmortisation() {return cashAmortisation;}
	public void setCashAmortisation(String value) {this.cashAmortisation =  value;}

	@XmlElement(name = "PrepaidExpensesGross")
	protected String prepaidExpensesGross;
	public String getPrepaidExpensesGross() {return prepaidExpensesGross;}
	public void setPrepaidExpensesGross(String value) {this.prepaidExpensesGross =  value;}

	@XmlElement(name = "PrepaidExpensesAmortisation")
	protected String prepaidExpensesAmortisation;
	public String getPrepaidExpensesAmortisation() {return prepaidExpensesAmortisation;}
	public void setPrepaidExpensesAmortisation(String value) {this.prepaidExpensesAmortisation =  value;}

	@XmlElement(name = "TotalProvisionsForRisksAndCharges")
	protected String totalProvisionsForRisksAndCharges;
	public String getTotalProvisionsForRisksAndCharges() {return totalProvisionsForRisksAndCharges;}
	public void setTotalProvisionsForRisksAndCharges(String value) {this.totalProvisionsForRisksAndCharges =  value;}

	@XmlElement(name = "FixedAssetLiabilities")
	protected String fixedAssetLiabilities;
	public String getFixedAssetLiabilities() {return fixedAssetLiabilities;}
	public void setFixedAssetLiabilities(String value) {this.fixedAssetLiabilities =  value;}

	@XmlElement(name = "OtherDebts")
	protected String otherDebts;
	public String getOtherDebts() {return otherDebts;}
	public void setOtherDebts(String value) {this.otherDebts =  value;}

	@XmlElement(name = "Translationloss")
	protected String translationloss;
	public String getTranslationloss() {return translationloss;}
	public void setTranslationloss(String value) {this.translationloss =  value;}

	@XmlElement(name = "NetTurnover")
	protected String netTurnover;
	public String getNetTurnover() {return netTurnover;}
	public void setNetTurnover(String value) {this.netTurnover =  value;}

	@XmlElement(name = "StockedProduction")
	protected String stockedProduction;
	public String getStockedProduction() {return stockedProduction;}
	public void setStockedProduction(String value) {this.stockedProduction =  value;}

	@XmlElement(name = "SelfConstructedAssets")
	protected String selfConstructedAssets;
	public String getSelfConstructedAssets() {return selfConstructedAssets;}
	public void setSelfConstructedAssets(String value) {this.selfConstructedAssets =  value;}

	@XmlElement(name = "PurchaseOfGoodsForResale")
	protected String purchaseOfGoodsForResale;
	public String getPurchaseOfGoodsForResale() {return purchaseOfGoodsForResale;}
	public void setPurchaseOfGoodsForResale(String value) {this.purchaseOfGoodsForResale =  value;}

	@XmlElement(name = "ChangeInStocksOfGoodsForResale")
	protected String changeInStocksOfGoodsForResale;
	public String getChangeInStocksOfGoodsForResale() {return changeInStocksOfGoodsForResale;}
	public void setChangeInStocksOfGoodsForResale(String value) {this.changeInStocksOfGoodsForResale =  value;}

	@XmlElement(name = "PurchaseOfRawMaterials")
	protected String purchaseOfRawMaterials;
	public String getPurchaseOfRawMaterials() {return purchaseOfRawMaterials;}
	public void setPurchaseOfRawMaterials(String value) {this.purchaseOfRawMaterials =  value;}

	@XmlElement(name = "ChangeInStocksOfRawMaterials")
	protected String changeInStocksOfRawMaterials;
	public String getChangeInStocksOfRawMaterials() {return changeInStocksOfRawMaterials;}
	public void setChangeInStocksOfRawMaterials(String value) {this.changeInStocksOfRawMaterials =  value;}

	@XmlElement(name = "OtherExternalPurchasesAndCharges")
	protected String otherExternalPurchasesAndCharges;
	public String getOtherExternalPurchasesAndCharges() {return otherExternalPurchasesAndCharges;}
	public void setOtherExternalPurchasesAndCharges(String value) {this.otherExternalPurchasesAndCharges =  value;}

	@XmlElement(name = "OperatingResult")
	protected String operatingResult;
	public String getOperatingResult() {return operatingResult;}
	public void setOperatingResult(String value) {this.operatingResult =  value;}

	@XmlElement(name = "ExtraordinaryResult")
	protected String extraordinaryResult;
	public String getExtraordinaryResult() {return extraordinaryResult;}
	public void setExtraordinaryResult(String value) {this.extraordinaryResult =  value;}

	@XmlElement(name = "OperatingGrants")
	protected String operatingGrants;
	public String getOperatingGrants() {return operatingGrants;}
	public void setOperatingGrants(String value) {this.operatingGrants =  value;}

	@XmlElement(name = "TaxDutyAndSimilarPayments")
	protected String taxDutyAndSimilarPayments;
	public String getTaxDutyAndSimilarPayments() {return taxDutyAndSimilarPayments;}
	public void setTaxDutyAndSimilarPayments(String value) {this.taxDutyAndSimilarPayments =  value;}

	@XmlElement(name = "Payroll")
	protected String payroll;
	public String getPayroll() {return payroll;}
	public void setPayroll(String value) {this.payroll =  value;}

	@XmlElement(name = "SocialSecurityCosts")
	protected String socialSecurityCosts;
	public String getSocialSecurityCosts() {return socialSecurityCosts;}
	public void setSocialSecurityCosts(String value) {this.socialSecurityCosts =  value;}

	@XmlElement(name = "InterestAndSimilarCharges")
	protected String interestAndSimilarCharges;
	public String getInterestAndSimilarCharges() {return interestAndSimilarCharges;}
	public void setInterestAndSimilarCharges(String value) {this.interestAndSimilarCharges =  value;}

	@XmlElement(name = "PreTaxNetOperatingIncome")
	protected String preTaxNetOperatingIncome;
	public String getPreTaxNetOperatingIncome() {return preTaxNetOperatingIncome;}
	public void setPreTaxNetOperatingIncome(String value) {this.preTaxNetOperatingIncome =  value;}

	@XmlElement(name = "ProfitorLoss")
	protected String profitorLoss;
	public String getProfitorLoss() {return profitorLoss;}
	public void setProfitorLoss(String value) {this.profitorLoss =  value;}

	@XmlElement(name = "TotalShareholdersEquity")
	protected String totalShareholdersEquity;
	public String getTotalShareholdersEquity() {return totalShareholdersEquity;}
	public void setTotalShareholdersEquity(String value) {this.totalShareholdersEquity =  value;}

	@XmlElement(name = "TotalOtherCapitalResources")
	protected String totalOtherCapitalResources;
	public String getTotalOtherCapitalResources() {return totalOtherCapitalResources;}
	public void setTotalOtherCapitalResources(String value) {this.totalOtherCapitalResources =  value;}

	@XmlElement(name = "ConvertibleDebentures")
	protected String convertibleDebentures;
	public String getConvertibleDebentures() {return convertibleDebentures;}
	public void setConvertibleDebentures(String value) {this.convertibleDebentures =  value;}

	@XmlElement(name = "OtherDebentures")
	protected String otherDebentures;
	public String getOtherDebentures() {return otherDebentures;}
	public void setOtherDebentures(String value) {this.otherDebentures =  value;}

	@XmlElement(name = "BankLoansAndLiabilities")
	protected String bankLoansAndLiabilities;
	public String getBankLoansAndLiabilities() {return bankLoansAndLiabilities;}
	public void setBankLoansAndLiabilities(String value) {this.bankLoansAndLiabilities =  value;}

	@XmlElement(name = "CurrentBankFacilities")
	protected String currentBankFacilities;
	public String getCurrentBankFacilities() {return currentBankFacilities;}
	public void setCurrentBankFacilities(String value) {this.currentBankFacilities =  value;}

	@XmlElement(name = "ExtraordinaryChargesFromCapitalTransactions")
	protected String extraordinaryChargesFromCapitalTransactions;
	public String getExtraordinaryChargesFromCapitalTransactions() {return extraordinaryChargesFromCapitalTransactions;}
	public void setExtraordinaryChargesFromCapitalTransactions(String value) {this.extraordinaryChargesFromCapitalTransactions =  value;}

	@XmlElement(name = "ExtraordinaryReservesandProvisions")
	protected String extraordinaryReservesandProvisions;
	public String getExtraordinaryReservesandProvisions() {return extraordinaryReservesandProvisions;}
	public void setExtraordinaryReservesandProvisions(String value) {this.extraordinaryReservesandProvisions =  value;}

	@XmlElement(name = "ExtraordinaryIncomeFromCapitalTransactions")
	protected String extraordinaryIncomeFromCapitalTransactions;
	public String getExtraordinaryIncomeFromCapitalTransactions() {return extraordinaryIncomeFromCapitalTransactions;}
	public void setExtraordinaryIncomeFromCapitalTransactions(String value) {this.extraordinaryIncomeFromCapitalTransactions =  value;}

	@XmlElement(name = "ReleasedExtraordinaryProvisions")
	protected String releasedExtraordinaryProvisions;
	public String getReleasedExtraordinaryProvisions() {return releasedExtraordinaryProvisions;}
	public void setReleasedExtraordinaryProvisions(String value) {this.releasedExtraordinaryProvisions =  value;}

	@XmlElement(name = "FinancialReservesAndProvisions")
	protected String financialReservesAndProvisions;
	public String getFinancialReservesAndProvisions() {return financialReservesAndProvisions;}
	public void setFinancialReservesAndProvisions(String value) {this.financialReservesAndProvisions =  value;}

	@XmlElement(name = "ReleasedFinancialProvisions")
	protected String releasedFinancialProvisions;
	public String getReleasedFinancialProvisions() {return releasedFinancialProvisions;}
	public void setReleasedFinancialProvisions(String value) {this.releasedFinancialProvisions =  value;}

	@XmlElement(name = "DepreciationOfFixedAssets")
	protected String depreciationOfFixedAssets;
	public String getDepreciationOfFixedAssets() {return depreciationOfFixedAssets;}
	public void setDepreciationOfFixedAssets(String value) {this.depreciationOfFixedAssets =  value;}

	@XmlElement(name = "AmortisationofFixedAssets")
	protected String amortisationofFixedAssets;
	public String getAmortisationofFixedAssets() {return amortisationofFixedAssets;}
	public void setAmortisationofFixedAssets(String value) {this.amortisationofFixedAssets =  value;}

	@XmlElement(name = "DepreciationAmortisationofCurrentAssets")
	protected String depreciationAmortisationofCurrentAssets;
	public String getDepreciationAmortisationofCurrentAssets() {return depreciationAmortisationofCurrentAssets;}
	public void setDepreciationAmortisationofCurrentAssets(String value) {this.depreciationAmortisationofCurrentAssets =  value;}

	@XmlElement(name = "ProvisionsForRisksandCharges")
	protected String provisionsForRisksandCharges;
	public String getProvisionsForRisksandCharges() {return provisionsForRisksandCharges;}
	public void setProvisionsForRisksandCharges(String value) {this.provisionsForRisksandCharges =  value;}

	@XmlElement(name = "ReleaseOfReservesandProvisions")
	protected String releaseOfReservesandProvisions;
	public String getReleaseOfReservesandProvisions() {return releaseOfReservesandProvisions;}
	public void setReleaseOfReservesandProvisions(String value) {this.releaseOfReservesandProvisions =  value;}

	@XmlElement(name = "TransferredCharges")
	protected String transferredCharges;
	public String getTransferredCharges() {return transferredCharges;}
	public void setTransferredCharges(String value) {this.transferredCharges =  value;}

	@XmlElement(name = "GrandTotalPassive")
	protected String grandTotalPassive;
	public String getGrandTotalPassive() {return grandTotalPassive;}
	public void setGrandTotalPassive(String value) {this.grandTotalPassive =  value;}

	@XmlElement(name = "CashAndCashEquivalentsGross")
	protected String cashAndCashEquivalentsGross;
	public String getCashAndCashEquivalentsGross() {return cashAndCashEquivalentsGross;}
	public void setCashAndCashEquivalentsGross(String value) {this.cashAndCashEquivalentsGross =  value;}

	@XmlElement(name = "EffectsBroughtToTheDiscountAndUnmatured")
	protected String effectsBroughtToTheDiscountAndUnmatured;
	public String getEffectsBroughtToTheDiscountAndUnmatured() {return effectsBroughtToTheDiscountAndUnmatured;}
	public void setEffectsBroughtToTheDiscountAndUnmatured(String value) {this.effectsBroughtToTheDiscountAndUnmatured =  value;}

	@XmlElement(name = "SundryLoansAndFinancialLiabilities")
	protected String sundryLoansAndFinancialLiabilities;
	public String getSundryLoansAndFinancialLiabilities() {return sundryLoansAndFinancialLiabilities;}
	public void setSundryLoansAndFinancialLiabilities(String value) {this.sundryLoansAndFinancialLiabilities =  value;}

	@XmlElement(name = "TotalFixedAssetsGross")
	protected String totalFixedAssetsGross;
	public String getTotalFixedAssetsGross() {return totalFixedAssetsGross;}
	public void setTotalFixedAssetsGross(String value) {this.totalFixedAssetsGross =  value;}

	@XmlElement(name = "TotalFixedAssetsAmortisation")
	protected String totalFixedAssetsAmortisation;
	public String getTotalFixedAssetsAmortisation() {return totalFixedAssetsAmortisation;}
	public void setTotalFixedAssetsAmortisation(String value) {this.totalFixedAssetsAmortisation =  value;}

	@XmlElement(name = "TotalCurrentAssetsGross")
	protected String totalCurrentAssetsGross;
	public String getTotalCurrentAssetsGross() {return totalCurrentAssetsGross;}
	public void setTotalCurrentAssetsGross(String value) {this.totalCurrentAssetsGross =  value;}

	@XmlElement(name = "TotalCurrentAssetsAmortisation")
	protected String totalCurrentAssetsAmortisation;
	public String getTotalCurrentAssetsAmortisation() {return totalCurrentAssetsAmortisation;}
	public void setTotalCurrentAssetsAmortisation(String value) {this.totalCurrentAssetsAmortisation =  value;}

	@XmlElement(name = "TotalAssetsGross")
	protected String totalAssetsGross;
	public String getTotalAssetsGross() {return totalAssetsGross;}
	public void setTotalAssetsGross(String value) {this.totalAssetsGross =  value;}

	@XmlElement(name = "DeferredIncome")
	protected String deferredIncome;
	public String getDeferredIncome() {return deferredIncome;}
	public void setDeferredIncome(String value) {this.deferredIncome =  value;}

	@XmlElement(name = "TotalLiabilitiesEC")
	protected String totalLiabilitiesEC;
	public String getTotalLiabilitiesEC() {return totalLiabilitiesEC;}
	public void setTotalLiabilitiesEC(String value) {this.totalLiabilitiesEC =  value;}

	@XmlElement(name = "SaleofGoodsforResale")
	protected String saleofGoodsforResale;
	public String getSaleofGoodsforResale() {return saleofGoodsforResale;}
	public void setSaleofGoodsforResale(String value) {this.saleofGoodsforResale =  value;}

	@XmlElement(name = "SaleofGoodsProduced")
	protected String saleofGoodsProduced;
	public String getSaleofGoodsProduced() {return saleofGoodsProduced;}
	public void setSaleofGoodsProduced(String value) {this.saleofGoodsProduced =  value;}

	@XmlElement(name = "SaleofServices")
	protected String saleofServices;
	public String getSaleofServices() {return saleofServices;}
	public void setSaleofServices(String value) {this.saleofServices =  value;}

	@XmlElement(name = "OtherIncome")
	protected String otherIncome;
	public String getOtherIncome() {return otherIncome;}
	public void setOtherIncome(String value) {this.otherIncome =  value;}

	@XmlElement(name = "OtherCharges")
	protected String otherCharges;
	public String getOtherCharges() {return otherCharges;}
	public void setOtherCharges(String value) {this.otherCharges =  value;}

	@XmlElement(name = "TotalFinancialIncome")
	protected String totalFinancialIncome;
	public String getTotalFinancialIncome() {return totalFinancialIncome;}
	public void setTotalFinancialIncome(String value) {this.totalFinancialIncome =  value;}

	@XmlElement(name = "TotalFinancialCharge")
	protected String totalFinancialCharge;
	public String getTotalFinancialCharge() {return totalFinancialCharge;}
	public void setTotalFinancialCharge(String value) {this.totalFinancialCharge =  value;}

	@XmlElement(name = "TotalExtraordinaryIncome")
	protected String totalExtraordinaryIncome;
	public String getTotalExtraordinaryIncome() {return totalExtraordinaryIncome;}
	public void setTotalExtraordinaryIncome(String value) {this.totalExtraordinaryIncome =  value;}

	@XmlElement(name = "TotalExtraordinaryCharges")
	protected String totalExtraordinaryCharges;
	public String getTotalExtraordinaryCharges() {return totalExtraordinaryCharges;}
	public void setTotalExtraordinaryCharges(String value) {this.totalExtraordinaryCharges =  value;}

	@XmlElement(name = "TotalTaxOnProfits")
	protected String totalTaxOnProfits;
	public String getTotalTaxOnProfits() {return totalTaxOnProfits;}
	public void setTotalTaxOnProfits(String value) {this.totalTaxOnProfits =  value;}

	@XmlElement(name = "AverageNumberofEmployees")
	protected String averageNumberofEmployees;
	public String getAverageNumberofEmployees() {return averageNumberofEmployees;}
	public void setAverageNumberofEmployees(String value) {this.averageNumberofEmployees =  value;}

	@XmlElement(name = "TradingMargin")
	protected String tradingMargin;
	public String getTradingMargin() {return tradingMargin;}
	public void setTradingMargin(String value) {this.tradingMargin =  value;}

	@XmlElement(name = "GrossOperatingSurplus")
	protected String grossOperatingSurplus;
	public String getGrossOperatingSurplus() {return grossOperatingSurplus;}
	public void setGrossOperatingSurplus(String value) {this.grossOperatingSurplus =  value;}

	@XmlElement(name = "Ratios")
	protected Ratios ratios;
	public Ratios getRatios() {return ratios;}
	public void setRatios(Ratios value) {this.ratios =  value;}

	@XmlElement(name = "RawMaterialsGross")
	protected String rawMaterialsGross;
	public String getRawMaterialsGross() {return rawMaterialsGross;}
	public void setRawMaterialsGross(String value) {this.rawMaterialsGross =  value;}

	@XmlElement(name = "WIPGoodsGross")
	protected String wipGoodsGross;
	public String getWipGoodsGross() {return wipGoodsGross;}
	public void setWipGoodsGross(String value) {this.wipGoodsGross =  value;}

	@XmlElement(name = "FinishedProductsGross")
	protected String finishedProductsGross;
	public String getFinishedProductsGross() {return finishedProductsGross;}
	public void setFinishedProductsGross(String value) {this.finishedProductsGross =  value;}

	@XmlElement(name = "GoodsForResaleGross")
	protected String goodsForResaleGross;
	public String getGoodsForResaleGross() {return goodsForResaleGross;}
	public void setGoodsForResaleGross(String value) {this.goodsForResaleGross =  value;}

	@XmlElement(name = "TradeReceivableGross")
	protected String tradeReceivableGross;
	public String getTradeReceivableGross() {return tradeReceivableGross;}
	public void setTradeReceivableGross(String value) {this.tradeReceivableGross =  value;}

	@XmlElement(name = "ExtraordinaryOperatingCharges")
	protected String extraordinaryOperatingCharges;
	public String getExtraordinaryOperatingCharges() {return extraordinaryOperatingCharges;}
	public void setExtraordinaryOperatingCharges(String value) {this.extraordinaryOperatingCharges =  value;}

	@XmlElement(name = "ExtraordinaryOperatingIncome")
	protected String extraordinaryOperatingIncome;
	public String getExtraordinaryOperatingIncome() {return extraordinaryOperatingIncome;}
	public void setExtraordinaryOperatingIncome(String value) {this.extraordinaryOperatingIncome =  value;}

	@XmlElement(name = "EmployeeProfitSharingTotal")
	protected String employeeProfitSharingTotal;
	public String getEmployeeProfitSharingTotal() {return employeeProfitSharingTotal;}
	public void setEmployeeProfitSharingTotal(String value) {this.employeeProfitSharingTotal =  value;}

	@XmlElement(name = "TaxandSociaLSecurityLiabilities")
	protected String taxandSociaLSecurityLiabilities;
	public String getTaxandSociaLSecurityLiabilities() {return taxandSociaLSecurityLiabilities;}
	public void setTaxandSociaLSecurityLiabilities(String value) {this.taxandSociaLSecurityLiabilities =  value;}

	@XmlElement(name = "NonDeclaredDistributedCapital")
	protected String nonDeclaredDistributedCapital;
	public String getNonDeclaredDistributedCapital() {return nonDeclaredDistributedCapital;}
	public void setNonDeclaredDistributedCapital(String value) {this.nonDeclaredDistributedCapital =  value;}

	@XmlElement(name = "DeferedCharges")
	protected String deferedCharges;
	public String getDeferedCharges() {return deferedCharges;}
	public void setDeferedCharges(String value) {this.deferedCharges =  value;}

	@XmlElement(name = "PremiumsOnRedemptionOfBonds")
	protected String premiumsOnRedemptionOfBonds;
	public String getPremiumsOnRedemptionOfBonds() {return premiumsOnRedemptionOfBonds;}
	public void setPremiumsOnRedemptionOfBonds(String value) {this.premiumsOnRedemptionOfBonds =  value;}

	@XmlElement(name = "CurrencyDifferentialGain")
	protected String currencyDifferentialGain;
	public String getCurrencyDifferentialGain() {return currencyDifferentialGain;}
	public void setCurrencyDifferentialGain(String value) {this.currencyDifferentialGain =  value;}

	@XmlElement(name = "AmountVATCollected")
	protected String amountVATCollected;
	public String getAmountVATCollected() {return amountVATCollected;}
	public void setAmountVATCollected(String value) {this.amountVATCollected =  value;}

	@XmlElement(name = "TotalVatOnGoodsAndServices")
	protected String totalVatOnGoodsAndServices;
	public String getTotalVatOnGoodsAndServices() {return totalVatOnGoodsAndServices;}
	public void setTotalVatOnGoodsAndServices(String value) {this.totalVatOnGoodsAndServices =  value;}

	@XmlElement(name = "ProfitOrLossForThePeriod")
	protected String profitOrLossForThePeriod;
	public String getProfitOrLossForThePeriod() {return profitOrLossForThePeriod;}
	public void setProfitOrLossForThePeriod(String value) {this.profitOrLossForThePeriod =  value;}

	@XmlElement(name = "Export")
	protected String export;
	public String getExport() {return export;}
	public void setExport(String value) {this.export =  value;}

	@XmlElement(name = "DirectorsEmoluments")
	protected String directorsEmoluments;
	public String getDirectorsEmoluments() {return directorsEmoluments;}
	public void setDirectorsEmoluments(String value) {this.directorsEmoluments =  value;}

	@XmlElement(name = "ShortTermHPFinanceLeaseLiabilities")
	protected String shortTermHPFinanceLeaseLiabilities;
	public String getShortTermHPFinanceLeaseLiabilities() {return shortTermHPFinanceLeaseLiabilities;}
	public void setShortTermHPFinanceLeaseLiabilities(String value) {this.shortTermHPFinanceLeaseLiabilities =  value;}

	@XmlElement(name = "LongTermHPFinanceLeaseLiabilities")
	protected String longTermHPFinanceLeaseLiabilities;
	public String getLongTermHPFinanceLeaseLiabilities() {return longTermHPFinanceLeaseLiabilities;}
	public void setLongTermHPFinanceLeaseLiabilities(String value) {this.longTermHPFinanceLeaseLiabilities =  value;}

}
