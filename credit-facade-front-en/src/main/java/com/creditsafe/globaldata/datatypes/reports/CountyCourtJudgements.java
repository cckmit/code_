package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CountyCourtJudgements", propOrder = {
	"date",
	"court",
	"amount",
	"caseNumber",
	"status",
	"defendantName",
	"defendantAddress",
	"registered",
	"unregistered"
})

public class CountyCourtJudgements implements Serializable {

	@XmlElement(name = "Date")
	protected String date;
	public String getDate() {return date;}
	public void setDate(String value) {this.date =  value;}

	@XmlElement(name = "Court")
	protected String court;
	public String getCourt() {return court;}
	public void setCourt(String value) {this.court =  value;}

	@XmlElement(name = "Amount")
	protected String amount;
	public String getAmount() {return amount;}
	public void setAmount(String value) {this.amount =  value;}

	@XmlElement(name = "CaseNumber")
	protected String caseNumber;
	public String getCaseNumber() {return caseNumber;}
	public void setCaseNumber(String value) {this.caseNumber =  value;}

	@XmlElement(name = "Status")
	protected String status;
	public String getStatus() {return status;}
	public void setStatus(String value) {this.status =  value;}

	@XmlElement(name = "DefendantName")
	protected String defendantName;
	public String getDefendantName() {return defendantName;}
	public void setDefendantName(String value) {this.defendantName =  value;}

	@XmlElement(name = "DefendantAddress")
	protected String defendantAddress;
	public String getDefendantAddress() {return defendantAddress;}
	public void setDefendantAddress(String value) {this.defendantAddress =  value;}

	@XmlElement(name = "Registered")
	protected List<Registered> registered;
	public List<Registered> getRegistered() {
		if (registered == null) {
			registered = new ArrayList<Registered>();
		}
		return registered;
	}
	@XmlElement(name = "Unregistered")
	protected List<Unregistered> unregistered;
	public List<Unregistered> getUnregistered() {
		if (unregistered == null) {
			unregistered = new ArrayList<Unregistered>();
		}
		return unregistered;
	}
}
