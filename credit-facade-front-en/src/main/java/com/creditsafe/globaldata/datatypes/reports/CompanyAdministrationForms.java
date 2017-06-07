package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompanyAdministrationForms", propOrder = {
	"companyAdministrationForm"
})

public class CompanyAdministrationForms implements Serializable {

	@XmlElement(name = "CompanyAdministrationForm")
	protected List<CompanyAdministrationForm> companyAdministrationForm;
	public List<CompanyAdministrationForm> getCompanyAdministrationForm() {
		if (companyAdministrationForm == null) {
			companyAdministrationForm = new ArrayList<CompanyAdministrationForm>();
		}
		return companyAdministrationForm;
	}
}
