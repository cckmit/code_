package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Entry", propOrder = {
	"jicCode",
	"description",
	"month",
	"dbtValue",
	"dbtTrend",
	"balance"
})

public class Entry implements Serializable {

	@XmlElement(name = "JicCode")
	protected String jicCode;
	public String getJicCode() {return jicCode;}
	public void setJicCode(String value) {this.jicCode =  value;}

	@XmlElement(name = "Description")
	protected String description;
	public String getDescription() {return description;}
	public void setDescription(String value) {this.description =  value;}

	@XmlElement(name = "Month")
	protected String month;
	public String getMonth() {return month;}
	public void setMonth(String value) {this.month =  value;}

	@XmlElement(name = "DBTValue")
	protected String dbtValue;
	public String getDbtValue() {return dbtValue;}
	public void setDbtValue(String value) {this.dbtValue =  value;}

	@XmlElement(name = "DBTTrend")
	protected String dbtTrend;
	public String getDbtTrend() {return dbtTrend;}
	public void setDbtTrend(String value) {this.dbtTrend =  value;}

	@XmlElement(name = "Balance")
	protected String balance;
	public String getBalance() {return balance;}
	public void setBalance(String value) {this.balance =  value;}

}
