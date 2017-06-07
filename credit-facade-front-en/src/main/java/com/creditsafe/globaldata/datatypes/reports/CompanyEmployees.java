package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompanyEmployees", propOrder = {
	"companyEmployees"
})

public class CompanyEmployees implements Serializable {

	@XmlElement(name = "CompanyEmployees")
	protected List<CompanyEmployee> companyEmployees;
	public List<CompanyEmployee> getCompanyEmployees() {
		if (companyEmployees == null) {
			companyEmployees = new ArrayList<CompanyEmployee>();
		}
		return companyEmployees;
	}
}
