package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VoluntaryPledge", propOrder = {
	"date",
	"type",
	"source",
	"refNr",
	"amount",
	"nameOfCreditor"
})

public class VoluntaryPledge implements Serializable {

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

	@XmlElement(name = "RefNr")
	protected String refNr;
	public String getRefNr() {return refNr;}
	public void setRefNr(String value) {this.refNr =  value;}

	@XmlElement(name = "Amount")
	protected String amount;
	public String getAmount() {return amount;}
	public void setAmount(String value) {this.amount =  value;}

	@XmlElement(name = "NameOfCreditor")
	protected String nameOfCreditor;
	public String getNameOfCreditor() {return nameOfCreditor;}
	public void setNameOfCreditor(String value) {this.nameOfCreditor =  value;}

}
