package com.creditsafe.globaldata.datatypes.reports;

import com.creditsafe.globaldata.datatypes.AddressData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UCCDetail", propOrder = {
	"filedDate",
	"filingType",
	"filingNumber",
	"jurisdiction",
	"securedPartyName",
	"securedPartyAddress",
	"collateral"
})

public class UCCDetail implements Serializable {

	@XmlElement(name = "FiledDate")
	protected String filedDate;
	public String getFiledDate() {return filedDate;}
	public void setFiledDate(String value) {this.filedDate =  value;}

	@XmlElement(name = "FilingType")
	protected String filingType;
	public String getFilingType() {return filingType;}
	public void setFilingType(String value) {this.filingType =  value;}

	@XmlElement(name = "FilingNumber")
	protected String filingNumber;
	public String getFilingNumber() {return filingNumber;}
	public void setFilingNumber(String value) {this.filingNumber =  value;}

	@XmlElement(name = "Jurisdiction")
	protected String jurisdiction;
	public String getJurisdiction() {return jurisdiction;}
	public void setJurisdiction(String value) {this.jurisdiction =  value;}

	@XmlElement(name = "SecuredPartyName")
	protected String securedPartyName;
	public String getSecuredPartyName() {return securedPartyName;}
	public void setSecuredPartyName(String value) {this.securedPartyName =  value;}

	@XmlElement(name = "SecuredPartyAddress")
	protected AddressData securedPartyAddress;
	public AddressData getSecuredPartyAddress() {return securedPartyAddress;}
	public void setSecuredPartyAddress(AddressData value) {this.securedPartyAddress =  value;}

	@XmlElement(name = "Collateral")
	protected String collateral;
	public String getCollateral() {return collateral;}
	public void setCollateral(String value) {this.collateral =  value;}

}
