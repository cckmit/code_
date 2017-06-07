package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompanyAdministrationForm", propOrder = {
	"administrationType",
	"minimumNumberofDirectors",
	"maximumNumberofDirectors"
})

public class CompanyAdministrationForm implements Serializable {

	@XmlElement(name = "AdministrationType")
	protected String administrationType;
	public String getAdministrationType() {return administrationType;}
	public void setAdministrationType(String value) {this.administrationType =  value;}

	@XmlElement(name = "MinimumNumberofDirectors")
	protected String minimumNumberofDirectors;
	public String getMinimumNumberofDirectors() {return minimumNumberofDirectors;}
	public void setMinimumNumberofDirectors(String value) {this.minimumNumberofDirectors =  value;}

	@XmlElement(name = "MaximumNumberofDirectors")
	protected String maximumNumberofDirectors;
	public String getMaximumNumberofDirectors() {return maximumNumberofDirectors;}
	public void setMaximumNumberofDirectors(String value) {this.maximumNumberofDirectors =  value;}

}
