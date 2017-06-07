package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MortgageInformation", propOrder = {
	"mortgageSummary",
	"mortgageDetails"
})

public class MortgageInformation implements Serializable {

	@XmlElement(name = "MortgageSummary")
	protected MortgageSummary mortgageSummary;
	public MortgageSummary getMortgageSummary() {return mortgageSummary;}
	public void setMortgageSummary(MortgageSummary value) {this.mortgageSummary =  value;}

	@XmlElement(name = "MortgageDetails")
	protected MortgageDetails mortgageDetails;
	public MortgageDetails getMortgageDetails() {return mortgageDetails;}
	public void setMortgageDetails(MortgageDetails value) {this.mortgageDetails =  value;}

}
