package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IndustryQuartileAnalysis", propOrder = {
	"paymentExpectationDays",
	"daySalesOutstanding"
})

public class IndustryQuartileAnalysis implements Serializable {

	@XmlElement(name = "PaymentExpectationDays")
	protected PaymentExpectationDays paymentExpectationDays;
	public PaymentExpectationDays getPaymentExpectationDays() {return paymentExpectationDays;}
	public void setPaymentExpectationDays(PaymentExpectationDays value) {this.paymentExpectationDays =  value;}

	@XmlElement(name = "DaySalesOutstanding")
	protected DaySalesOutstanding daySalesOutstanding;
	public DaySalesOutstanding getDaySalesOutstanding() {return daySalesOutstanding;}
	public void setDaySalesOutstanding(DaySalesOutstanding value) {this.daySalesOutstanding =  value;}

}
