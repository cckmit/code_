package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegisteredContractor", propOrder = {
	"registrationNumber",
	"contractorDescription",
	"strikingOffDate"
})

public class RegisteredContractor implements Serializable {

	@XmlElement(name = "RegistrationNumber")
	protected String registrationNumber;
	public String getRegistrationNumber() {return registrationNumber;}
	public void setRegistrationNumber(String value) {this.registrationNumber =  value;}

	@XmlElement(name = "ContractorDescription")
	protected String contractorDescription;
	public String getContractorDescription() {return contractorDescription;}
	public void setContractorDescription(String value) {this.contractorDescription =  value;}

	@XmlElement(name = "StrikingOffDate")
	protected String strikingOffDate;
	public String getStrikingOffDate() {return strikingOffDate;}
	public void setStrikingOffDate(String value) {this.strikingOffDate =  value;}

}
