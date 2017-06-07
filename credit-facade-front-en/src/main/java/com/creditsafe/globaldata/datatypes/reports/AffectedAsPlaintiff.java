package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AffectedAsPlaintiff", propOrder = {
	"period",
	"bankruptcyProceedingsNumber",
	"bankruptcyProceedingsValue",
	"legalProceedingsNumber",
	"legalProceedingsValue",
	"claimsNumber",
	"claimsValue",
	"defendant",
	"totalNumber",
	"totalValue"
})

public class AffectedAsPlaintiff implements Serializable {

	@XmlElement(name = "Period")
	protected String period;
	public String getPeriod() {return period;}
	public void setPeriod(String value) {this.period =  value;}

	@XmlElement(name = "BankruptcyProceedingsNumber")
	protected String bankruptcyProceedingsNumber;
	public String getBankruptcyProceedingsNumber() {return bankruptcyProceedingsNumber;}
	public void setBankruptcyProceedingsNumber(String value) {this.bankruptcyProceedingsNumber =  value;}

	@XmlElement(name = "BankruptcyProceedingsValue")
	protected String bankruptcyProceedingsValue;
	public String getBankruptcyProceedingsValue() {return bankruptcyProceedingsValue;}
	public void setBankruptcyProceedingsValue(String value) {this.bankruptcyProceedingsValue =  value;}

	@XmlElement(name = "LegalProceedingsNumber")
	protected String legalProceedingsNumber;
	public String getLegalProceedingsNumber() {return legalProceedingsNumber;}
	public void setLegalProceedingsNumber(String value) {this.legalProceedingsNumber =  value;}

	@XmlElement(name = "LegalProceedingsValue")
	protected String legalProceedingsValue;
	public String getLegalProceedingsValue() {return legalProceedingsValue;}
	public void setLegalProceedingsValue(String value) {this.legalProceedingsValue =  value;}

	@XmlElement(name = "ClaimsNumber")
	protected String claimsNumber;
	public String getClaimsNumber() {return claimsNumber;}
	public void setClaimsNumber(String value) {this.claimsNumber =  value;}

	@XmlElement(name = "ClaimsValue")
	protected String claimsValue;
	public String getClaimsValue() {return claimsValue;}
	public void setClaimsValue(String value) {this.claimsValue =  value;}

	@XmlElement(name = "Defendant")
	protected Defendant defendant;
	public Defendant getDefendant() {return defendant;}
	public void setDefendant(Defendant value) {this.defendant =  value;}

	@XmlElement(name = "TotalNumber")
	protected String totalNumber;
	public String getTotalNumber() {return totalNumber;}
	public void setTotalNumber(String value) {this.totalNumber =  value;}

	@XmlElement(name = "TotalValue")
	protected String totalValue;
	public String getTotalValue() {return totalValue;}
	public void setTotalValue(String value) {this.totalValue =  value;}

}
