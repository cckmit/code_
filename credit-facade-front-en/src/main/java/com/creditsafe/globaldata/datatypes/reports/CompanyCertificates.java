package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompanyCertificates", propOrder = {
	"companyCertificate"
})

public class CompanyCertificates implements Serializable {

	@XmlElement(name = "CompanyCertificate")
	protected List<CompanyCertificate> companyCertificate;
	public List<CompanyCertificate> getCompanyCertificate() {
		if (companyCertificate == null) {
			companyCertificate = new ArrayList<CompanyCertificate>();
		}
		return companyCertificate;
	}
}
