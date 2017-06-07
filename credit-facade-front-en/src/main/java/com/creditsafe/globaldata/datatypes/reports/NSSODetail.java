package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NSSODetail", propOrder = {
	"businessNumber",
	"nameOfDefendant",
	"legalFormOfDefendant",
	"dateOfSummons",
	"labourCourt"
})

public class NSSODetail implements Serializable {

	@XmlElement(name = "BusinessNumber")
	protected String businessNumber;
	public String getBusinessNumber() {return businessNumber;}
	public void setBusinessNumber(String value) {this.businessNumber =  value;}

	@XmlElement(name = "NameOfDefendant")
	protected String nameOfDefendant;
	public String getNameOfDefendant() {return nameOfDefendant;}
	public void setNameOfDefendant(String value) {this.nameOfDefendant =  value;}

	@XmlElement(name = "LegalFormOfDefendant")
	protected String legalFormOfDefendant;
	public String getLegalFormOfDefendant() {return legalFormOfDefendant;}
	public void setLegalFormOfDefendant(String value) {this.legalFormOfDefendant =  value;}

	@XmlElement(name = "DateOfSummons")
	protected String dateOfSummons;
	public String getDateOfSummons() {return dateOfSummons;}
	public void setDateOfSummons(String value) {this.dateOfSummons =  value;}

	@XmlElement(name = "LabourCourt")
	protected String labourCourt;
	public String getLabourCourt() {return labourCourt;}
	public void setLabourCourt(String value) {this.labourCourt =  value;}

}
