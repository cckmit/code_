package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PreferentialRight", propOrder = {
	"preferentialStatus",
	"typeOfPreferentialRight",
	"effectiveDate",
	"preferentialTypeCode",
	"preferentialTypeText",
	"registrationNumber",
	"registrationDate",
	"expiryDate",
	"creditor",
	"amount",
	"amountCovered",
	"court"
})

public class PreferentialRight implements Serializable {

	@XmlElement(name = "PreferentialStatus")
	protected String preferentialStatus;
	public String getPreferentialStatus() {return preferentialStatus;}
	public void setPreferentialStatus(String value) {this.preferentialStatus =  value;}

	@XmlElement(name = "TypeOfPreferentialRight")
	protected String typeOfPreferentialRight;
	public String getTypeOfPreferentialRight() {return typeOfPreferentialRight;}
	public void setTypeOfPreferentialRight(String value) {this.typeOfPreferentialRight =  value;}

	@XmlElement(name = "EffectiveDate")
	protected String effectiveDate;
	public String getEffectiveDate() {return effectiveDate;}
	public void setEffectiveDate(String value) {this.effectiveDate =  value;}

	@XmlElement(name = "PreferentialTypeCode")
	protected String preferentialTypeCode;
	public String getPreferentialTypeCode() {return preferentialTypeCode;}
	public void setPreferentialTypeCode(String value) {this.preferentialTypeCode =  value;}

	@XmlElement(name = "PreferentialTypeText")
	protected String preferentialTypeText;
	public String getPreferentialTypeText() {return preferentialTypeText;}
	public void setPreferentialTypeText(String value) {this.preferentialTypeText =  value;}

	@XmlElement(name = "RegistrationNumber")
	protected String registrationNumber;
	public String getRegistrationNumber() {return registrationNumber;}
	public void setRegistrationNumber(String value) {this.registrationNumber =  value;}

	@XmlElement(name = "RegistrationDate")
	protected String registrationDate;
	public String getRegistrationDate() {return registrationDate;}
	public void setRegistrationDate(String value) {this.registrationDate =  value;}

	@XmlElement(name = "ExpiryDate")
	protected String expiryDate;
	public String getExpiryDate() {return expiryDate;}
	public void setExpiryDate(String value) {this.expiryDate =  value;}

	@XmlElement(name = "Creditor")
	protected String creditor;
	public String getCreditor() {return creditor;}
	public void setCreditor(String value) {this.creditor =  value;}

	@XmlElement(name = "Amount")
	protected String amount;
	public String getAmount() {return amount;}
	public void setAmount(String value) {this.amount =  value;}

	@XmlElement(name = "AmountCovered")
	protected String amountCovered;
	public String getAmountCovered() {return amountCovered;}
	public void setAmountCovered(String value) {this.amountCovered =  value;}

	@XmlElement(name = "Court")
	protected String court;
	public String getCourt() {return court;}
	public void setCourt(String value) {this.court =  value;}

}
