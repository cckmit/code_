package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BankruptcyDetail", propOrder = {
	"filedDate",
	"filingType",
	"status",
	"caseZZ",
	"court"
})

public class BankruptcyDetail implements Serializable {

	@XmlElement(name = "FiledDate")
	protected String filedDate;
	public String getFiledDate() {return filedDate;}
	public void setFiledDate(String value) {this.filedDate =  value;}

	@XmlElement(name = "FilingType")
	protected String filingType;
	public String getFilingType() {return filingType;}
	public void setFilingType(String value) {this.filingType =  value;}

	@XmlElement(name = "Status")
	protected String status;
	public String getStatus() {return status;}
	public void setStatus(String value) {this.status =  value;}

	@XmlElement(name = "Case")
	protected String caseZZ;
	public String getCaseZZ() {return caseZZ;}
	public void setCaseZZ(String value) {this.caseZZ =  value;}

	@XmlElement(name = "Court")
	protected String court;
	public String getCourt() {return court;}
	public void setCourt(String value) {this.court =  value;}

}
