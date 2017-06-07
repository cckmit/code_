package com.creditsafe.globaldata.datatypes.reports;

import com.mika.credit.common.util.StringUtil;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CountyCourtJudgement", propOrder = {
	"date",
	"court",
	"amount",
	"caseNumber",
	"status",
	"datePaid",
	"incomingRecordDetails"
})

public class CountyCourtJudgement implements Serializable {

	@XmlElement(name = "Date")
	protected String date;
	public String getDate() {return date;}
	public void setDate(String value) {
		if (StringUtil.isNotNull(value)){
			this.date =  value.substring(0,10);
		}else {
			this.date =  value;
		}
	}

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

	@XmlElement(name = "DatePaid")
	protected String datePaid;
	public String getDatePaid() {return datePaid;}
	public void setDatePaid(String value) {this.datePaid =  value;}

	@XmlElement(name = "IncomingRecordDetails")
	protected String incomingRecordDetails;
	public String getIncomingRecordDetails() {return incomingRecordDetails;}
	public void setIncomingRecordDetails(String value) {this.incomingRecordDetails =  value;}

}
