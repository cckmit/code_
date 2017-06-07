package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradeLine", propOrder = {
	"number",
	"balance",
	"current",
	"range1to30",
	"range31to60",
	"range61to90",
	"range91plus"
})

public class TradeLine implements Serializable {

	@XmlElement(name = "Number")
	protected String number;
	public String getNumber() {return number;}
	public void setNumber(String value) {this.number =  value;}

	@XmlElement(name = "Balance")
	protected String balance;
	public String getBalance() {return balance;}
	public void setBalance(String value) {this.balance =  value;}

	@XmlElement(name = "Current")
	protected String current;
	public String getCurrent() {return current;}
	public void setCurrent(String value) {this.current =  value;}

	@XmlElement(name = "Range1to30")
	protected String range1to30;
	public String getRange1to30() {return range1to30;}
	public void setRange1to30(String value) {this.range1to30 =  value;}

	@XmlElement(name = "Range31to60")
	protected String range31to60;
	public String getRange31to60() {return range31to60;}
	public void setRange31to60(String value) {this.range31to60 =  value;}

	@XmlElement(name = "Range61to90")
	protected String range61to90;
	public String getRange61to90() {return range61to90;}
	public void setRange61to90(String value) {this.range61to90 =  value;}

	@XmlElement(name = "Range91plus")
	protected String range91plus;
	public String getRange91plus() {return range91plus;}
	public void setRange91plus(String value) {this.range91plus =  value;}

}
