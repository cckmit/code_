package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KeyPersonnel", propOrder = {
	"forename",
	"familyName",
	"lastName"
})

public class KeyPersonnel implements Serializable {

	@XmlElement(name = "Forename")
	protected String forename;
	public String getForename() {return forename;}
	public void setForename(String value) {this.forename =  value;}

	@XmlElement(name = "FamilyName")
	protected String familyName;
	public String getFamilyName() {return familyName;}
	public void setFamilyName(String value) {this.familyName =  value;}

	@XmlElement(name = "LastName")
	protected String lastName;
	public String getLastName() {return lastName;}
	public void setLastName(String value) {this.lastName =  value;}

}
