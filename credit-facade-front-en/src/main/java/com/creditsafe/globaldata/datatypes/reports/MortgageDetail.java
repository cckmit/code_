package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MortgageDetail", propOrder = {
	"mortgageType",
	"dateChargeCreated",
	"dateChargeRegistered",
	"dateChargeSatisfied",
	"status",
	"personsEntitled",
	"amountSecured",
	"details"
})

public class MortgageDetail implements Serializable {

	@XmlElement(name = "MortgageType")
	protected String mortgageType;
	public String getMortgageType() {return mortgageType;}
	public void setMortgageType(String value) {this.mortgageType =  value;}

	@XmlElement(name = "DateChargeCreated")
	protected String dateChargeCreated;
	public String getDateChargeCreated() {return dateChargeCreated;}
	public void setDateChargeCreated(String value) {this.dateChargeCreated =  value;}

	@XmlElement(name = "DateChargeRegistered")
	protected String dateChargeRegistered;
	public String getDateChargeRegistered() {return dateChargeRegistered;}
	public void setDateChargeRegistered(String value) {this.dateChargeRegistered =  value;}

	@XmlElement(name = "DateChargeSatisfied")
	protected String dateChargeSatisfied;
	public String getDateChargeSatisfied() {return dateChargeSatisfied;}
	public void setDateChargeSatisfied(String value) {this.dateChargeSatisfied =  value;}

	@XmlElement(name = "Status")
	protected String status;
	public String getStatus() {return status;}
	public void setStatus(String value) {this.status =  value;}

	@XmlElement(name = "PersonsEntitled")
	protected String personsEntitled;
	public String getPersonsEntitled() {return personsEntitled;}
	public void setPersonsEntitled(String value) {this.personsEntitled =  value;}

	@XmlElement(name = "AmountSecured")
	protected String amountSecured;
	public String getAmountSecured() {return amountSecured;}
	public void setAmountSecured(String value) {this.amountSecured =  value;}

	@XmlElement(name = "Details")
	protected String details;
	public String getDetails() {return details;}
	public void setDetails(String value) {this.details =  value;}

}
