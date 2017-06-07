package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GroupStructure", propOrder = {
	"companyInGroup"
})

public class GroupStructure implements Serializable {

	@XmlElement(name = "CompanyInGroup")
	protected List<CompanyInGroup> companyInGroup;
	public List<CompanyInGroup> getCompanyInGroup() {
		if (companyInGroup == null) {
			companyInGroup = new ArrayList<CompanyInGroup>();
		}
		return companyInGroup;
	}
}
