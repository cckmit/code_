package com.creditsafe.globaldata.datatypes.reports;

import com.creditsafe.globaldata.datatypes.AddressData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LocalBranch", propOrder = {
	"cciaAandNREA",
	"openingDate",
	"telephoneNumber",
	"faxNumber",
	"branchStatus",
	"branchNumber",
	"address",
	"branchType",
	"companyActivityDescription",
	"activities"
})

public class LocalBranch implements Serializable {

	@XmlElement(name = "CCIAAandNREA")
	protected String cciaAandNREA;
	public String getCciaAandNREA() {return cciaAandNREA;}
	public void setCciaAandNREA(String value) {this.cciaAandNREA =  value;}

	@XmlElement(name = "OpeningDate")
	protected String openingDate;
	public String getOpeningDate() {return openingDate;}
	public void setOpeningDate(String value) {this.openingDate =  value;}

	@XmlElement(name = "TelephoneNumber")
	protected String telephoneNumber;
	public String getTelephoneNumber() {return telephoneNumber;}
	public void setTelephoneNumber(String value) {this.telephoneNumber =  value;}

	@XmlElement(name = "FaxNumber")
	protected String faxNumber;
	public String getFaxNumber() {return faxNumber;}
	public void setFaxNumber(String value) {this.faxNumber =  value;}

	@XmlElement(name = "BranchStatus")
	protected String branchStatus;
	public String getBranchStatus() {return branchStatus;}
	public void setBranchStatus(String value) {this.branchStatus =  value;}

	@XmlElement(name = "BranchNumber")
	protected String branchNumber;
	public String getBranchNumber() {return branchNumber;}
	public void setBranchNumber(String value) {this.branchNumber =  value;}

	@XmlElement(name = "Address")
	protected AddressData address;
	public AddressData getAddress() {return address;}
	public void setAddress(AddressData value) {this.address =  value;}

	@XmlElement(name = "BranchType")
	protected String branchType;
	public String getBranchType() {return branchType;}
	public void setBranchType(String value) {this.branchType =  value;}

	@XmlElement(name = "CompanyActivityDescription")
	protected String companyActivityDescription;
	public String getCompanyActivityDescription() {return companyActivityDescription;}
	public void setCompanyActivityDescription(String value) {this.companyActivityDescription =  value;}

	@XmlElement(name = "Activities")
	protected Activities activities;
	public Activities getActivities() {return activities;}
	public void setActivities(Activities value) {this.activities =  value;}

}
