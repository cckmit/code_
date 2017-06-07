package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LatestPrivateClaim", propOrder = {
	"date",
	"amount",
	"currency",
	"creditor",
	"comments"
})

public class LatestPrivateClaim implements Serializable {

	@XmlElement(name = "Date")
	protected String date;
	public String getDate() {return date;}
	public void setDate(String value) {this.date =  value;}

	@XmlElement(name = "Amount")
	protected String amount;
	public String getAmount() {return amount;}
	public void setAmount(String value) {this.amount =  value;}

	@XmlElement(name = "Currency")
	protected String currency;
	public String getCurrency() {return currency;}
	public void setCurrency(String value) {this.currency =  value;}

	@XmlElement(name = "Creditor")
	protected String creditor;
	public String getCreditor() {return creditor;}
	public void setCreditor(String value) {this.creditor =  value;}

	@XmlElement(name = "Comments")
	protected String comments;
	public String getComments() {return comments;}
	public void setComments(String value) {this.comments =  value;}

}
