package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MortgageDetails", propOrder = {
	"mortgageDetail"
})

public class MortgageDetails implements Serializable {

	@XmlElement(name = "MortgageDetail")
	protected List<MortgageDetail> mortgageDetail;
	public List<MortgageDetail> getMortgageDetail() {
		if (mortgageDetail == null) {
			mortgageDetail = new ArrayList<MortgageDetail>();
		}
		return mortgageDetail;
	}
}
