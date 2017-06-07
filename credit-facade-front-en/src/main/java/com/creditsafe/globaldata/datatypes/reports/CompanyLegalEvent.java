package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompanyLegalEvent", propOrder = {
	"legalEventType",
	"legalEventSubType",
	"eventDate",
	"secondaryEventDate",
	"courtType",
	"courtName",
	"thirdPartyName",
	"thirdPartyAddress",
	"thirdPartyType"
})

public class CompanyLegalEvent implements Serializable {

	@XmlElement(name = "LegalEventType")
	protected String legalEventType;
	public String getLegalEventType() {return legalEventType;}
	public void setLegalEventType(String value) {this.legalEventType =  value;}

	@XmlElement(name = "LegalEventSubType")
	protected String legalEventSubType;
	public String getLegalEventSubType() {return legalEventSubType;}
	public void setLegalEventSubType(String value) {this.legalEventSubType =  value;}

	@XmlElement(name = "EventDate")
	protected String eventDate;
	public String getEventDate() {return eventDate;}
	public void setEventDate(String value) {this.eventDate =  value;}

	@XmlElement(name = "SecondaryEventDate")
	protected String secondaryEventDate;
	public String getSecondaryEventDate() {return secondaryEventDate;}
	public void setSecondaryEventDate(String value) {this.secondaryEventDate =  value;}

	@XmlElement(name = "CourtType")
	protected String courtType;
	public String getCourtType() {return courtType;}
	public void setCourtType(String value) {this.courtType =  value;}

	@XmlElement(name = "CourtName")
	protected String courtName;
	public String getCourtName() {return courtName;}
	public void setCourtName(String value) {this.courtName =  value;}

	@XmlElement(name = "ThirdPartyName")
	protected String thirdPartyName;
	public String getThirdPartyName() {return thirdPartyName;}
	public void setThirdPartyName(String value) {this.thirdPartyName =  value;}

	@XmlElement(name = "ThirdPartyAddress")
	protected String thirdPartyAddress;
	public String getThirdPartyAddress() {return thirdPartyAddress;}
	public void setThirdPartyAddress(String value) {this.thirdPartyAddress =  value;}

	@XmlElement(name = "ThirdPartyType")
	protected String thirdPartyType;
	public String getThirdPartyType() {return thirdPartyType;}
	public void setThirdPartyType(String value) {this.thirdPartyType =  value;}

}
