package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompanySignificantEvents", propOrder = {
	"companySignificantEvent"
})

public class CompanySignificantEvents implements Serializable {

	@XmlElement(name = "CompanySignificantEvent")
	protected List<CompanySignificantEvent> companySignificantEvent;
	public List<CompanySignificantEvent> getCompanySignificantEvent() {
		if (companySignificantEvent == null) {
			companySignificantEvent = new ArrayList<CompanySignificantEvent>();
		}
		return companySignificantEvent;
	}
}
