package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DBT", propOrder = {
	"companyDBT",
	"industryDBT"
})

public class DBT implements Serializable {

	@XmlElement(name = "CompanyDBT")
	protected String companyDBT;
	public String getCompanyDBT() {return companyDBT;}
	public void setCompanyDBT(String value) {this.companyDBT =  value;}

	@XmlElement(name = "IndustryDBT")
	protected String industryDBT;
	public String getIndustryDBT() {return industryDBT;}
	public void setIndustryDBT(String value) {this.industryDBT =  value;}

}
