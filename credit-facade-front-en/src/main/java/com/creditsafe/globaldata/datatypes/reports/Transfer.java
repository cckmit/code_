package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Transfer", propOrder = {
	"proceedingsDate",
	"chamberofCommerceRegistered",
	"transferNumber",
	"filedDate",
	"protocolDate",
	"transferSubject",
	"companiesInvolved"
})

public class Transfer implements Serializable {

	@XmlElement(name = "ProceedingsDate")
	protected String proceedingsDate;
	public String getProceedingsDate() {return proceedingsDate;}
	public void setProceedingsDate(String value) {this.proceedingsDate =  value;}

	@XmlElement(name = "ChamberofCommerceRegistered")
	protected String chamberofCommerceRegistered;
	public String getChamberofCommerceRegistered() {return chamberofCommerceRegistered;}
	public void setChamberofCommerceRegistered(String value) {this.chamberofCommerceRegistered =  value;}

	@XmlElement(name = "TransferNumber")
	protected String transferNumber;
	public String getTransferNumber() {return transferNumber;}
	public void setTransferNumber(String value) {this.transferNumber =  value;}

	@XmlElement(name = "FiledDate")
	protected String filedDate;
	public String getFiledDate() {return filedDate;}
	public void setFiledDate(String value) {this.filedDate =  value;}

	@XmlElement(name = "ProtocolDate")
	protected String protocolDate;
	public String getProtocolDate() {return protocolDate;}
	public void setProtocolDate(String value) {this.protocolDate =  value;}

	@XmlElement(name = "TransferSubject")
	protected String transferSubject;
	public String getTransferSubject() {return transferSubject;}
	public void setTransferSubject(String value) {this.transferSubject =  value;}

	@XmlElement(name = "CompaniesInvolved")
	protected CompaniesInvolved companiesInvolved;
	public CompaniesInvolved getCompaniesInvolved() {return companiesInvolved;}
	public void setCompaniesInvolved(CompaniesInvolved value) {this.companiesInvolved =  value;}

}
