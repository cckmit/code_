package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MortgageSummary", propOrder = {
	"outstanding",
	"satisfied"
})

public class MortgageSummary implements Serializable {

	@XmlElement(name = "Outstanding")
	protected String outstanding;
	public String getOutstanding() {return outstanding;}
	public void setOutstanding(String value) {this.outstanding =  value;}

	@XmlElement(name = "Satisfied")
	protected String satisfied;
	public String getSatisfied() {return satisfied;}
	public void setSatisfied(String value) {this.satisfied =  value;}

}
