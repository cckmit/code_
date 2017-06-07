package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LitigationDetailsPlaintiff", propOrder = {
	"ongoingCasesNumberOfRecords",
	"litigationAmountOngoingCases",
	"closedCasesLostNumberOfRecords",
	"closedCasesLostAmount",
	"closedCasesPartiallyLostNumberOfRecords",
	"closedCasesPartiallyLostAmount",
	"closedCasesWonNumberOfRecords",
	"closedCasesWonAmount",
	"closedCasesOthersNumberOfRecords",
	"closedCasesOthersAmount"
})

public class LitigationDetailsPlaintiff implements Serializable {

	@XmlElement(name = "OngoingCasesNumberOfRecords")
	protected String ongoingCasesNumberOfRecords;
	public String getOngoingCasesNumberOfRecords() {return ongoingCasesNumberOfRecords;}
	public void setOngoingCasesNumberOfRecords(String value) {this.ongoingCasesNumberOfRecords =  value;}

	@XmlElement(name = "LitigationAmountOngoingCases")
	protected String litigationAmountOngoingCases;
	public String getLitigationAmountOngoingCases() {return litigationAmountOngoingCases;}
	public void setLitigationAmountOngoingCases(String value) {this.litigationAmountOngoingCases =  value;}

	@XmlElement(name = "ClosedCasesLostNumberOfRecords")
	protected String closedCasesLostNumberOfRecords;
	public String getClosedCasesLostNumberOfRecords() {return closedCasesLostNumberOfRecords;}
	public void setClosedCasesLostNumberOfRecords(String value) {this.closedCasesLostNumberOfRecords =  value;}

	@XmlElement(name = "ClosedCasesLostAmount")
	protected String closedCasesLostAmount;
	public String getClosedCasesLostAmount() {return closedCasesLostAmount;}
	public void setClosedCasesLostAmount(String value) {this.closedCasesLostAmount =  value;}

	@XmlElement(name = "ClosedCasesPartiallyLostNumberOfRecords")
	protected String closedCasesPartiallyLostNumberOfRecords;
	public String getClosedCasesPartiallyLostNumberOfRecords() {return closedCasesPartiallyLostNumberOfRecords;}
	public void setClosedCasesPartiallyLostNumberOfRecords(String value) {this.closedCasesPartiallyLostNumberOfRecords =  value;}

	@XmlElement(name = "ClosedCasesPartiallyLostAmount")
	protected String closedCasesPartiallyLostAmount;
	public String getClosedCasesPartiallyLostAmount() {return closedCasesPartiallyLostAmount;}
	public void setClosedCasesPartiallyLostAmount(String value) {this.closedCasesPartiallyLostAmount =  value;}

	@XmlElement(name = "ClosedCasesWonNumberOfRecords")
	protected String closedCasesWonNumberOfRecords;
	public String getClosedCasesWonNumberOfRecords() {return closedCasesWonNumberOfRecords;}
	public void setClosedCasesWonNumberOfRecords(String value) {this.closedCasesWonNumberOfRecords =  value;}

	@XmlElement(name = "ClosedCasesWonAmount")
	protected String closedCasesWonAmount;
	public String getClosedCasesWonAmount() {return closedCasesWonAmount;}
	public void setClosedCasesWonAmount(String value) {this.closedCasesWonAmount =  value;}

	@XmlElement(name = "ClosedCasesOthersNumberOfRecords")
	protected String closedCasesOthersNumberOfRecords;
	public String getClosedCasesOthersNumberOfRecords() {return closedCasesOthersNumberOfRecords;}
	public void setClosedCasesOthersNumberOfRecords(String value) {this.closedCasesOthersNumberOfRecords =  value;}

	@XmlElement(name = "ClosedCasesOthersAmount")
	protected String closedCasesOthersAmount;
	public String getClosedCasesOthersAmount() {return closedCasesOthersAmount;}
	public void setClosedCasesOthersAmount(String value) {this.closedCasesOthersAmount =  value;}

	@XmlAttribute(name = "Currency")
	protected String currency;
	public String getCurrency() {return currency;}
	public void setCurrency(String value) {this.currency =  value;}

	@XmlAttribute(name = "Multiplier")
	protected String multiplier;
	public String getMultiplier() {return multiplier;}
	public void setMultiplier(String value) {this.multiplier =  value;}

}
