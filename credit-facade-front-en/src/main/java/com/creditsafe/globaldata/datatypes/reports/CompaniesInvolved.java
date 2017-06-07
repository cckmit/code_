package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompaniesInvolved", propOrder = {
	"companyInvolved"
})

public class CompaniesInvolved implements Serializable {

	@XmlElement(name = "CompanyInvolved")
	protected List<CompanyInvolved> companyInvolved;
	public List<CompanyInvolved> getCompanyInvolved() {
		if (companyInvolved == null) {
			companyInvolved = new ArrayList<CompanyInvolved>();
		}
		return companyInvolved;
	}
}
