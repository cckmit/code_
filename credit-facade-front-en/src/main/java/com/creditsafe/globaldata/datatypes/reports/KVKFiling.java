package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KVKFiling", propOrder = {
	"filingDate",
	"filedEvent"
})

public class KVKFiling implements Serializable {

	@XmlElement(name = "FilingDate")
	protected String filingDate;
	public String getFilingDate() {return filingDate;}
	public void setFilingDate(String value) {this.filingDate =  value;}

	@XmlElement(name = "FiledEvent")
	protected String filedEvent;
	public String getFiledEvent() {return filedEvent;}
	public void setFiledEvent(String value) {this.filedEvent =  value;}

}
