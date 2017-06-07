package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompanyLegalEvents", propOrder = {
	"companyLegalEvent"
})

public class CompanyLegalEvents implements Serializable {

	@XmlElement(name = "CompanyLegalEvent")
	protected List<CompanyLegalEvent> companyLegalEvent;
	public List<CompanyLegalEvent> getCompanyLegalEvent() {
		if (companyLegalEvent == null) {
			companyLegalEvent = new ArrayList<CompanyLegalEvent>();
		}
		return companyLegalEvent;
	}
}
