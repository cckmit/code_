package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentRemarks", propOrder = {
	"paymentRemark"
})

public class PaymentRemarks implements Serializable {

	@XmlElement(name = "PaymentRemark")
	protected List<PaymentRemark> paymentRemark;
	public List<PaymentRemark> getPaymentRemark() {
		if (paymentRemark == null) {
			paymentRemark = new ArrayList<PaymentRemark>();
		}
		return paymentRemark;
	}
}
