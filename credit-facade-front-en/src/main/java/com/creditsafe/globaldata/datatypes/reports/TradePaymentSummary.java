package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradePaymentSummary", propOrder = {
	"totalTradesNumber",
	"continuousTradesNumber"
})

public class TradePaymentSummary implements Serializable {

	@XmlElement(name = "TotalTradesNumber")
	protected String totalTradesNumber;
	public String getTotalTradesNumber() {return totalTradesNumber;}
	public void setTotalTradesNumber(String value) {this.totalTradesNumber =  value;}

	@XmlElement(name = "ContinuousTradesNumber")
	protected String continuousTradesNumber;
	public String getContinuousTradesNumber() {return continuousTradesNumber;}
	public void setContinuousTradesNumber(String value) {this.continuousTradesNumber =  value;}

}
