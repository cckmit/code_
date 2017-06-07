package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrusteeData", propOrder = {
	"name",
	"code",
	"city",
	"telephoneNumber",
	"emailAddress",
	"surname",
	"forename",
	"title"
})

public class TrusteeData implements Serializable {

	@XmlElement(name = "Name")
	protected String name;
	public String getName() {return name;}
	public void setName(String value) {this.name =  value;}

	@XmlElement(name = "Code")
	protected String code;
	public String getCode() {return code;}
	public void setCode(String value) {this.code =  value;}

	@XmlElement(name = "City")
	protected String city;
	public String getCity() {return city;}
	public void setCity(String value) {this.city =  value;}

	@XmlElement(name = "TelephoneNumber")
	protected String telephoneNumber;
	public String getTelephoneNumber() {return telephoneNumber;}
	public void setTelephoneNumber(String value) {this.telephoneNumber =  value;}

	@XmlElement(name = "EmailAddress")
	protected String emailAddress;
	public String getEmailAddress() {return emailAddress;}
	public void setEmailAddress(String value) {this.emailAddress =  value;}

	@XmlElement(name = "Surname")
	protected String surname;
	public String getSurname() {return surname;}
	public void setSurname(String value) {this.surname =  value;}

	@XmlElement(name = "Forename")
	protected String forename;
	public String getForename() {return forename;}
	public void setForename(String value) {this.forename =  value;}

	@XmlElement(name = "Title")
	protected String title;
	public String getTitle() {return title;}
	public void setTitle(String value) {this.title =  value;}

}
