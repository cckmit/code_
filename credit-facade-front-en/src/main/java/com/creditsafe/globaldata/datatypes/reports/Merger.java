package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Merger", propOrder = {
	"mergerOrDemerger",
	"eventType",
	"registeredDate",
	"amendedDate",
	"proceedingsDate",
	"enforcementDate",
	"companiesInvolved"
})

public class Merger implements Serializable {

	@XmlElement(name = "MergerOrDemerger")
	protected String mergerOrDemerger;
	public String getMergerOrDemerger() {return mergerOrDemerger;}
	public void setMergerOrDemerger(String value) {this.mergerOrDemerger =  value;}

	@XmlElement(name = "EventType")
	protected String eventType;
	public String getEventType() {return eventType;}
	public void setEventType(String value) {this.eventType =  value;}

	@XmlElement(name = "RegisteredDate")
	protected String registeredDate;
	public String getRegisteredDate() {return registeredDate;}
	public void setRegisteredDate(String value) {this.registeredDate =  value;}

	@XmlElement(name = "AmendedDate")
	protected String amendedDate;
	public String getAmendedDate() {return amendedDate;}
	public void setAmendedDate(String value) {this.amendedDate =  value;}

	@XmlElement(name = "ProceedingsDate")
	protected String proceedingsDate;
	public String getProceedingsDate() {return proceedingsDate;}
	public void setProceedingsDate(String value) {this.proceedingsDate =  value;}

	@XmlElement(name = "EnforcementDate")
	protected String enforcementDate;
	public String getEnforcementDate() {return enforcementDate;}
	public void setEnforcementDate(String value) {this.enforcementDate =  value;}

	@XmlElement(name = "CompaniesInvolved")
	protected CompaniesInvolved companiesInvolved;
	public CompaniesInvolved getCompaniesInvolved() {return companiesInvolved;}
	public void setCompaniesInvolved(CompaniesInvolved value) {this.companiesInvolved =  value;}

}
