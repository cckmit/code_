package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentData", propOrder = {
	"paymentsOnFile",
	"paymentsOnTime",
	"paymentsPaidLate",
	"totalInvoiceValues",
	"averageInvoiceValues",
	"paymentsStillOwing",
	"totalBalanceStillOwing",
	"highestInvoiceValueOutstanding",
	"numberofPaymentsStillOwingLate",
	"totalBalanceStillOwingLate",
	"highestInvoiceValueOutstandingLate",
	"numberofPaymentsSentLegal",
	"dbt",
	"industryDbt",
	"paymentTrend",
	"averageMonthlyBalance",
	"balance",
	"balanceP1",
	"balanceP2",
	"balanceP3",
	"balanceP4",
	"balanceWithinTerms",
	"annualDbtWithTrend",
	"lastSixMonthsBalance",
	"totalNoofInvoicesAvailable",
	"totalNoofInvoicesPaidBefore30DaysDue",
	"totalNoofInvoicesPaidAfter30DaysDue",
	"totalNoofInvoicesOwingBefore30DaysDue",
	"totalNoofInvoicesOwingAfter30DaysDue",
	"invoicesBetween3And12Monts",
	"invoicesLast3Monts",
	"recentHighBalance",
	"totalTradeLines",
	"totalTradeLinesOutstanding",
	"tradePaymentSummary",
	"tradeLinesInformation"
})

public class PaymentData implements Serializable {

	@XmlElement(name = "PaymentsOnFile")
	protected String paymentsOnFile;
	public String getPaymentsOnFile() {return paymentsOnFile;}
	public void setPaymentsOnFile(String value) {this.paymentsOnFile =  value;}

	@XmlElement(name = "PaymentsOnTime")
	protected String paymentsOnTime;
	public String getPaymentsOnTime() {return paymentsOnTime;}
	public void setPaymentsOnTime(String value) {this.paymentsOnTime =  value;}

	@XmlElement(name = "PaymentsPaidLate")
	protected String paymentsPaidLate;
	public String getPaymentsPaidLate() {return paymentsPaidLate;}
	public void setPaymentsPaidLate(String value) {this.paymentsPaidLate =  value;}

	@XmlElement(name = "TotalInvoiceValues")
	protected String totalInvoiceValues;
	public String getTotalInvoiceValues() {return totalInvoiceValues;}
	public void setTotalInvoiceValues(String value) {this.totalInvoiceValues =  value;}

	@XmlElement(name = "AverageInvoiceValues")
	protected String averageInvoiceValues;
	public String getAverageInvoiceValues() {return averageInvoiceValues;}
	public void setAverageInvoiceValues(String value) {this.averageInvoiceValues =  value;}

	@XmlElement(name = "PaymentsStillOwing")
	protected String paymentsStillOwing;
	public String getPaymentsStillOwing() {return paymentsStillOwing;}
	public void setPaymentsStillOwing(String value) {this.paymentsStillOwing =  value;}

	@XmlElement(name = "TotalBalanceStillOwing")
	protected String totalBalanceStillOwing;
	public String getTotalBalanceStillOwing() {return totalBalanceStillOwing;}
	public void setTotalBalanceStillOwing(String value) {this.totalBalanceStillOwing =  value;}

	@XmlElement(name = "HighestInvoiceValueOutstanding")
	protected String highestInvoiceValueOutstanding;
	public String getHighestInvoiceValueOutstanding() {return highestInvoiceValueOutstanding;}
	public void setHighestInvoiceValueOutstanding(String value) {this.highestInvoiceValueOutstanding =  value;}

	@XmlElement(name = "NumberofPaymentsStillOwingLate")
	protected String numberofPaymentsStillOwingLate;
	public String getNumberofPaymentsStillOwingLate() {return numberofPaymentsStillOwingLate;}
	public void setNumberofPaymentsStillOwingLate(String value) {this.numberofPaymentsStillOwingLate =  value;}

	@XmlElement(name = "TotalBalanceStillOwingLate")
	protected String totalBalanceStillOwingLate;
	public String getTotalBalanceStillOwingLate() {return totalBalanceStillOwingLate;}
	public void setTotalBalanceStillOwingLate(String value) {this.totalBalanceStillOwingLate =  value;}

	@XmlElement(name = "HighestInvoiceValueOutstandingLate")
	protected String highestInvoiceValueOutstandingLate;
	public String getHighestInvoiceValueOutstandingLate() {return highestInvoiceValueOutstandingLate;}
	public void setHighestInvoiceValueOutstandingLate(String value) {this.highestInvoiceValueOutstandingLate =  value;}

	@XmlElement(name = "NumberofPaymentsSentLegal")
	protected String numberofPaymentsSentLegal;
	public String getNumberofPaymentsSentLegal() {return numberofPaymentsSentLegal;}
	public void setNumberofPaymentsSentLegal(String value) {this.numberofPaymentsSentLegal =  value;}

	@XmlElement(name = "Dbt")
	protected String dbt;
	public String getDbt() {return dbt;}
	public void setDbt(String value) {this.dbt =  value;}

	@XmlElement(name = "IndustryDbt")
	protected String industryDbt;
	public String getIndustryDbt() {return industryDbt;}
	public void setIndustryDbt(String value) {this.industryDbt =  value;}

	@XmlElement(name = "PaymentTrend")
	protected String paymentTrend;
	public String getPaymentTrend() {return paymentTrend;}
	public void setPaymentTrend(String value) {this.paymentTrend =  value;}

	@XmlElement(name = "AverageMonthlyBalance")
	protected String averageMonthlyBalance;
	public String getAverageMonthlyBalance() {return averageMonthlyBalance;}
	public void setAverageMonthlyBalance(String value) {this.averageMonthlyBalance =  value;}

	@XmlElement(name = "Balance")
	protected String balance;
	public String getBalance() {return balance;}
	public void setBalance(String value) {this.balance =  value;}

	@XmlElement(name = "BalanceP1")
	protected String balanceP1;
	public String getBalanceP1() {return balanceP1;}
	public void setBalanceP1(String value) {this.balanceP1 =  value;}

	@XmlElement(name = "BalanceP2")
	protected String balanceP2;
	public String getBalanceP2() {return balanceP2;}
	public void setBalanceP2(String value) {this.balanceP2 =  value;}

	@XmlElement(name = "BalanceP3")
	protected String balanceP3;
	public String getBalanceP3() {return balanceP3;}
	public void setBalanceP3(String value) {this.balanceP3 =  value;}

	@XmlElement(name = "BalanceP4")
	protected String balanceP4;
	public String getBalanceP4() {return balanceP4;}
	public void setBalanceP4(String value) {this.balanceP4 =  value;}

	@XmlElement(name = "BalanceWithinTerms")
	protected String balanceWithinTerms;
	public String getBalanceWithinTerms() {return balanceWithinTerms;}
	public void setBalanceWithinTerms(String value) {this.balanceWithinTerms =  value;}

	@XmlElement(name = "AnnualDbtWithTrend")
	protected AnnualDbtWithTrend annualDbtWithTrend;
	public AnnualDbtWithTrend getAnnualDbtWithTrend() {return annualDbtWithTrend;}
	public void setAnnualDbtWithTrend(AnnualDbtWithTrend value) {this.annualDbtWithTrend =  value;}

	@XmlElement(name = "LastSixMonthsBalance")
	protected LastSixMonthsBalance lastSixMonthsBalance;
	public LastSixMonthsBalance getLastSixMonthsBalance() {return lastSixMonthsBalance;}
	public void setLastSixMonthsBalance(LastSixMonthsBalance value) {this.lastSixMonthsBalance =  value;}

	@XmlElement(name = "TotalNoofInvoicesAvailable")
	protected String totalNoofInvoicesAvailable;
	public String getTotalNoofInvoicesAvailable() {return totalNoofInvoicesAvailable;}
	public void setTotalNoofInvoicesAvailable(String value) {this.totalNoofInvoicesAvailable =  value;}

	@XmlElement(name = "TotalNoofInvoicesPaidBefore30DaysDue")
	protected String totalNoofInvoicesPaidBefore30DaysDue;
	public String getTotalNoofInvoicesPaidBefore30DaysDue() {return totalNoofInvoicesPaidBefore30DaysDue;}
	public void setTotalNoofInvoicesPaidBefore30DaysDue(String value) {this.totalNoofInvoicesPaidBefore30DaysDue =  value;}

	@XmlElement(name = "TotalNoofInvoicesPaidAfter30DaysDue")
	protected String totalNoofInvoicesPaidAfter30DaysDue;
	public String getTotalNoofInvoicesPaidAfter30DaysDue() {return totalNoofInvoicesPaidAfter30DaysDue;}
	public void setTotalNoofInvoicesPaidAfter30DaysDue(String value) {this.totalNoofInvoicesPaidAfter30DaysDue =  value;}

	@XmlElement(name = "TotalNoofInvoicesOwingBefore30DaysDue")
	protected String totalNoofInvoicesOwingBefore30DaysDue;
	public String getTotalNoofInvoicesOwingBefore30DaysDue() {return totalNoofInvoicesOwingBefore30DaysDue;}
	public void setTotalNoofInvoicesOwingBefore30DaysDue(String value) {this.totalNoofInvoicesOwingBefore30DaysDue =  value;}

	@XmlElement(name = "TotalNoofInvoicesOwingAfter30DaysDue")
	protected String totalNoofInvoicesOwingAfter30DaysDue;
	public String getTotalNoofInvoicesOwingAfter30DaysDue() {return totalNoofInvoicesOwingAfter30DaysDue;}
	public void setTotalNoofInvoicesOwingAfter30DaysDue(String value) {this.totalNoofInvoicesOwingAfter30DaysDue =  value;}

	@XmlElement(name = "InvoicesBetween3And12Monts")
	protected InvoicesBetween3And12Monts invoicesBetween3And12Monts;
	public InvoicesBetween3And12Monts getInvoicesBetween3And12Monts() {return invoicesBetween3And12Monts;}
	public void setInvoicesBetween3And12Monts(InvoicesBetween3And12Monts value) {this.invoicesBetween3And12Monts =  value;}

	@XmlElement(name = "InvoicesLast3Monts")
	protected InvoicesLast3Monts invoicesLast3Monts;
	public InvoicesLast3Monts getInvoicesLast3Monts() {return invoicesLast3Monts;}
	public void setInvoicesLast3Monts(InvoicesLast3Monts value) {this.invoicesLast3Monts =  value;}

	@XmlElement(name = "RecentHighBalance")
	protected String recentHighBalance;
	public String getRecentHighBalance() {return recentHighBalance;}
	public void setRecentHighBalance(String value) {this.recentHighBalance =  value;}

	@XmlElement(name = "TotalTradeLines")
	protected String totalTradeLines;
	public String getTotalTradeLines() {return totalTradeLines;}
	public void setTotalTradeLines(String value) {this.totalTradeLines =  value;}

	@XmlElement(name = "TotalTradeLinesOutstanding")
	protected String totalTradeLinesOutstanding;
	public String getTotalTradeLinesOutstanding() {return totalTradeLinesOutstanding;}
	public void setTotalTradeLinesOutstanding(String value) {this.totalTradeLinesOutstanding =  value;}

	@XmlElement(name = "TradePaymentSummary")
	protected TradePaymentSummary tradePaymentSummary;
	public TradePaymentSummary getTradePaymentSummary() {return tradePaymentSummary;}
	public void setTradePaymentSummary(TradePaymentSummary value) {this.tradePaymentSummary =  value;}

	@XmlElement(name = "TradeLinesInformation")
	protected TradeLinesInformation tradeLinesInformation;
	public TradeLinesInformation getTradeLinesInformation() {return tradeLinesInformation;}
	public void setTradeLinesInformation(TradeLinesInformation value) {this.tradeLinesInformation =  value;}

}
