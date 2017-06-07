package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WorkforceInformation", propOrder = {
	"numberofPartners",
	"numberofDirectors",
	"accountsController",
	"companyAdministrationForms",
	"companyEmployees"
})

public class WorkforceInformation implements Serializable {

	@XmlElement(name = "NumberofPartners")
	protected String numberofPartners;
	public String getNumberofPartners() {return numberofPartners;}
	public void setNumberofPartners(String value) {this.numberofPartners =  value;}

	@XmlElement(name = "NumberofDirectors")
	protected String numberofDirectors;
	public String getNumberofDirectors() {return numberofDirectors;}
	public void setNumberofDirectors(String value) {this.numberofDirectors =  value;}

	@XmlElement(name = "AccountsController")
	protected String accountsController;
	public String getAccountsController() {return accountsController;}
	public void setAccountsController(String value) {this.accountsController =  value;}

	@XmlElement(name = "CompanyAdministrationForms")
	protected CompanyAdministrationForms companyAdministrationForms;
	public CompanyAdministrationForms getCompanyAdministrationForms() {return companyAdministrationForms;}
	public void setCompanyAdministrationForms(CompanyAdministrationForms value) {this.companyAdministrationForms =  value;}

	@XmlElement(name = "CompanyEmployees")
	protected CompanyEmployees companyEmployees;
	public CompanyEmployees getCompanyEmployees() {return companyEmployees;}
	public void setCompanyEmployees(CompanyEmployees value) {this.companyEmployees =  value;}

}
