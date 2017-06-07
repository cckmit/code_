package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentExpectationDays", propOrder = {
	"paymentExpectationsLower",
	"paymentExpectationsMedian",
	"paymentExpectationsUpper"
})

public class PaymentExpectationDays implements Serializable {

	@XmlElement(name = "PaymentExpectationsLower")
	protected String paymentExpectationsLower;
	public String getPaymentExpectationsLower() {return paymentExpectationsLower;}
	public void setPaymentExpectationsLower(String value) {this.paymentExpectationsLower =  value;}

	@XmlElement(name = "PaymentExpectationsMedian")
	protected String paymentExpectationsMedian;
	public String getPaymentExpectationsMedian() {return paymentExpectationsMedian;}
	public void setPaymentExpectationsMedian(String value) {this.paymentExpectationsMedian =  value;}

	@XmlElement(name = "PaymentExpectationsUpper")
	protected String paymentExpectationsUpper;
	public String getPaymentExpectationsUpper() {return paymentExpectationsUpper;}
	public void setPaymentExpectationsUpper(String value) {this.paymentExpectationsUpper =  value;}

}
