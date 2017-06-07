package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProfessionalProfile", propOrder = {
	"fullName",
	"gender",
	"professionalTitle",
	"field",
	"yearOfRegistration",
	"professionalNumber",
	"school",
	"state",
	"level"
})

public class ProfessionalProfile implements Serializable {

	@XmlElement(name = "FullName")
	protected String fullName;
	public String getFullName() {return fullName;}
	public void setFullName(String value) {this.fullName =  value;}

	@XmlElement(name = "Gender")
	protected String gender;
	public String getGender() {return gender;}
	public void setGender(String value) {this.gender =  value;}

	@XmlElement(name = "ProfessionalTitle")
	protected String professionalTitle;
	public String getProfessionalTitle() {return professionalTitle;}
	public void setProfessionalTitle(String value) {this.professionalTitle =  value;}

	@XmlElement(name = "Field")
	protected String field;
	public String getField() {return field;}
	public void setField(String value) {this.field =  value;}

	@XmlElement(name = "YearOfRegistration")
	protected String yearOfRegistration;
	public String getYearOfRegistration() {return yearOfRegistration;}
	public void setYearOfRegistration(String value) {this.yearOfRegistration =  value;}

	@XmlElement(name = "ProfessionalNumber")
	protected String professionalNumber;
	public String getProfessionalNumber() {return professionalNumber;}
	public void setProfessionalNumber(String value) {this.professionalNumber =  value;}

	@XmlElement(name = "School")
	protected String school;
	public String getSchool() {return school;}
	public void setSchool(String value) {this.school =  value;}

	@XmlElement(name = "State")
	protected String state;
	public String getState() {return state;}
	public void setState(String value) {this.state =  value;}

	@XmlElement(name = "Level")
	protected String level;
	public String getLevel() {return level;}
	public void setLevel(String value) {this.level =  value;}

}
