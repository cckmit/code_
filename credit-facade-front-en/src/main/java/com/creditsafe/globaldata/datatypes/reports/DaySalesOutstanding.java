package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DaySalesOutstanding", propOrder = {
	"daySalesOutstandingLower",
	"daySalesOutstandingMedian",
	"daySalesOutstandingUpper"
})

public class DaySalesOutstanding implements Serializable {

	@XmlElement(name = "DaySalesOutstandingLower")
	protected String daySalesOutstandingLower;
	public String getDaySalesOutstandingLower() {return daySalesOutstandingLower;}
	public void setDaySalesOutstandingLower(String value) {this.daySalesOutstandingLower =  value;}

	@XmlElement(name = "DaySalesOutstandingMedian")
	protected String daySalesOutstandingMedian;
	public String getDaySalesOutstandingMedian() {return daySalesOutstandingMedian;}
	public void setDaySalesOutstandingMedian(String value) {this.daySalesOutstandingMedian =  value;}

	@XmlElement(name = "DaySalesOutstandingUpper")
	protected String daySalesOutstandingUpper;
	public String getDaySalesOutstandingUpper() {return daySalesOutstandingUpper;}
	public void setDaySalesOutstandingUpper(String value) {this.daySalesOutstandingUpper =  value;}

}
