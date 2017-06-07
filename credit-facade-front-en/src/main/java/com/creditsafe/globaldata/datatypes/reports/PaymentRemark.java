package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentRemark", propOrder = {
	"date",
	"type",
	"source",
	"status",
	"refNr",
	"amount",
	"settlementDate",
	"nameofCreditor",
	"typeofPaymentRemark"
})

public class PaymentRemark implements Serializable {

	@XmlElement(name = "Date")
	protected String date;
	public String getDate() {return date;}
	public void setDate(String value) {this.date =  value;}

	@XmlElement(name = "Type")
	protected String type;
	public String getType() {return type;}
	public void setType(String value) {this.type =  value;}

	@XmlElement(name = "Source")
	protected String source;
	public String getSource() {return source;}
	public void setSource(String value) {this.source =  value;}

	@XmlElement(name = "Status")
	protected String status;
	public String getStatus() {return status;}
	public void setStatus(String value) {this.status =  value;}

	@XmlElement(name = "RefNr")
	protected String refNr;
	public String getRefNr() {return refNr;}
	public void setRefNr(String value) {this.refNr =  value;}

	@XmlElement(name = "Amount")
	protected String amount;
	public String getAmount() {return amount;}
	public void setAmount(String value) {this.amount =  value;}

	@XmlElement(name = "SettlementDate")
	protected String settlementDate;
	public String getSettlementDate() {return settlementDate;}
	public void setSettlementDate(String value) {this.settlementDate =  value;}

	@XmlElement(name = "NameofCreditor")
	protected String nameofCreditor;
	public String getNameofCreditor() {return nameofCreditor;}
	public void setNameofCreditor(String value) {this.nameofCreditor =  value;}

	@XmlElement(name = "TypeofPaymentRemark")
	protected String typeofPaymentRemark;
	public String getTypeofPaymentRemark() {return typeofPaymentRemark;}
	public void setTypeofPaymentRemark(String value) {this.typeofPaymentRemark =  value;}

}
