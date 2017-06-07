package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaxLienDetails", propOrder = {
	"taxLienDetail"
})

public class TaxLienDetails implements Serializable {

	@XmlElement(name = "TaxLienDetail")
	protected List<TaxLienDetail> taxLienDetail;
	public List<TaxLienDetail> getTaxLienDetail() {
		if (taxLienDetail == null) {
			taxLienDetail = new ArrayList<TaxLienDetail>();
		}
		return taxLienDetail;
	}
}
