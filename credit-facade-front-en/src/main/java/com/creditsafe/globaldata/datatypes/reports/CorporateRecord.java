package com.creditsafe.globaldata.datatypes.reports;

import com.creditsafe.globaldata.datatypes.AddressData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CorporateRecord", propOrder = {
	"businessLegalName",
	"sosCharterNumber",
	"status",
	"incorporatedState",
	"foreignOrDomestic",
	"profitOrNonProfit",
	"primaryAddress",
	"agentName",
	"agentAddress"
})

public class CorporateRecord implements Serializable {

	@XmlElement(name = "BusinessLegalName")
	protected String businessLegalName;
	public String getBusinessLegalName() {return businessLegalName;}
	public void setBusinessLegalName(String value) {this.businessLegalName =  value;}

	@XmlElement(name = "SOSCharterNumber")
	protected String sosCharterNumber;
	public String getSosCharterNumber() {return sosCharterNumber;}
	public void setSosCharterNumber(String value) {this.sosCharterNumber =  value;}

	@XmlElement(name = "Status")
	protected String status;
	public String getStatus() {return status;}
	public void setStatus(String value) {this.status =  value;}

	@XmlElement(name = "IncorporatedState")
	protected String incorporatedState;
	public String getIncorporatedState() {return incorporatedState;}
	public void setIncorporatedState(String value) {this.incorporatedState =  value;}

	@XmlElement(name = "ForeignOrDomestic")
	protected String foreignOrDomestic;
	public String getForeignOrDomestic() {return foreignOrDomestic;}
	public void setForeignOrDomestic(String value) {this.foreignOrDomestic =  value;}

	@XmlElement(name = "ProfitOrNonProfit")
	protected String profitOrNonProfit;
	public String getProfitOrNonProfit() {return profitOrNonProfit;}
	public void setProfitOrNonProfit(String value) {this.profitOrNonProfit =  value;}

	@XmlElement(name = "PrimaryAddress")
	protected AddressData primaryAddress;
	public AddressData getPrimaryAddress() {return primaryAddress;}
	public void setPrimaryAddress(AddressData value) {this.primaryAddress =  value;}

	@XmlElement(name = "AgentName")
	protected String agentName;
	public String getAgentName() {return agentName;}
	public void setAgentName(String value) {this.agentName =  value;}

	@XmlElement(name = "AgentAddress")
	protected AddressData agentAddress;
	public AddressData getAgentAddress() {return agentAddress;}
	public void setAgentAddress(AddressData value) {this.agentAddress =  value;}

}
