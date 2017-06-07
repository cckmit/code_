package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentExpectationsSummary", propOrder = {
	"suspensionOfPaymentsMora",
	"paymentExpectationDays",
	"daySalesOutstanding",
	"industryAveragePaymentExpectationDays",
	"industryAverageDaySalesOutstanding"
})

public class PaymentExpectationsSummary implements Serializable {

	@XmlElement(name = "SuspensionOfPaymentsMora")
	protected String suspensionOfPaymentsMora;
	public String getSuspensionOfPaymentsMora() {return suspensionOfPaymentsMora;}
	public void setSuspensionOfPaymentsMora(String value) {this.suspensionOfPaymentsMora =  value;}

	@XmlElement(name = "PaymentExpectationDays")
	protected String paymentExpectationDays;
	public String getPaymentExpectationDays() {return paymentExpectationDays;}
	public void setPaymentExpectationDays(String value) {this.paymentExpectationDays =  value;}

	@XmlElement(name = "DaySalesOutstanding")
	protected String daySalesOutstanding;
	public String getDaySalesOutstanding() {return daySalesOutstanding;}
	public void setDaySalesOutstanding(String value) {this.daySalesOutstanding =  value;}

	@XmlElement(name = "IndustryAveragePaymentExpectationDays")
	protected String industryAveragePaymentExpectationDays;
	public String getIndustryAveragePaymentExpectationDays() {return industryAveragePaymentExpectationDays;}
	public void setIndustryAveragePaymentExpectationDays(String value) {this.industryAveragePaymentExpectationDays =  value;}

	@XmlElement(name = "IndustryAverageDaySalesOutstanding")
	protected String industryAverageDaySalesOutstanding;
	public String getIndustryAverageDaySalesOutstanding() {return industryAverageDaySalesOutstanding;}
	public void setIndustryAverageDaySalesOutstanding(String value) {this.industryAverageDaySalesOutstanding =  value;}

}
