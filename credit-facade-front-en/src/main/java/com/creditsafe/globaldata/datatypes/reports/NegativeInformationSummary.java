package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NegativeInformationSummary", propOrder = {
	"typeofInfo",
	"date"
})

public class NegativeInformationSummary implements Serializable {

	@XmlElement(name = "TypeofInfo")
	protected String typeofInfo;
	public String getTypeofInfo() {return typeofInfo;}
	public void setTypeofInfo(String value) {this.typeofInfo =  value;}

	@XmlElement(name = "Date")
	protected String date;
	public String getDate() {return date;}
	public void setDate(String value) {this.date =  value;}

}
