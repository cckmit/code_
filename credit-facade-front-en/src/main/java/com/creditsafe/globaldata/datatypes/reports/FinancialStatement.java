package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FinancialStatement", propOrder = {
	"yearEndDate",
	"auditedAccounts",
	"auditorComments",
	"financialYear",
	"accountsType",
	"ebit",
	"ebitda",
	"operatingMargin",
	"returnOnEquityCapital",
	"netProfitMargin",
	"debtToCapital"
})

public class FinancialStatement implements Serializable {

	@XmlElement(name = "YearEndDate")
	protected String yearEndDate;
	public String getYearEndDate() {return yearEndDate;}
	public void setYearEndDate(String value) {this.yearEndDate =  value;}

	@XmlElement(name = "AuditedAccounts")
	protected String auditedAccounts;
	public String getAuditedAccounts() {return auditedAccounts;}
	public void setAuditedAccounts(String value) {this.auditedAccounts =  value;}

	@XmlElement(name = "AuditorComments")
	protected String auditorComments;
	public String getAuditorComments() {return auditorComments;}
	public void setAuditorComments(String value) {this.auditorComments =  value;}

	@XmlElement(name = "FinancialYear")
	protected String financialYear;
	public String getFinancialYear() {return financialYear;}
	public void setFinancialYear(String value) {this.financialYear =  value;}

	@XmlElement(name = "AccountsType")
	protected String accountsType;
	public String getAccountsType() {return accountsType;}
	public void setAccountsType(String value) {this.accountsType =  value;}

	@XmlElement(name = "EBIT")
	protected String ebit;
	public String getEbit() {return ebit;}
	public void setEbit(String value) {this.ebit =  value;}

	@XmlElement(name = "EBITDA")
	protected String ebitda;
	public String getEbitda() {return ebitda;}
	public void setEbitda(String value) {this.ebitda =  value;}

	@XmlElement(name = "OperatingMargin")
	protected String operatingMargin;
	public String getOperatingMargin() {return operatingMargin;}
	public void setOperatingMargin(String value) {this.operatingMargin =  value;}

	@XmlElement(name = "ReturnOnEquityCapital")
	protected String returnOnEquityCapital;
	public String getReturnOnEquityCapital() {return returnOnEquityCapital;}
	public void setReturnOnEquityCapital(String value) {this.returnOnEquityCapital =  value;}

	@XmlElement(name = "NetProfitMargin")
	protected String netProfitMargin;
	public String getNetProfitMargin() {return netProfitMargin;}
	public void setNetProfitMargin(String value) {this.netProfitMargin =  value;}

	@XmlElement(name = "DebtToCapital")
	protected String debtToCapital;
	public String getDebtToCapital() {return debtToCapital;}
	public void setDebtToCapital(String value) {this.debtToCapital =  value;}

}
