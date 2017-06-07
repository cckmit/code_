package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BankruptcyDetails", propOrder = {
	"bankruptcyDetail"
})

public class BankruptcyDetails implements Serializable {

	@XmlElement(name = "BankruptcyDetail")
	protected List<BankruptcyDetail> bankruptcyDetail;
	public List<BankruptcyDetail> getBankruptcyDetail() {
		if (bankruptcyDetail == null) {
			bankruptcyDetail = new ArrayList<BankruptcyDetail>();
		}
		return bankruptcyDetail;
	}
}
