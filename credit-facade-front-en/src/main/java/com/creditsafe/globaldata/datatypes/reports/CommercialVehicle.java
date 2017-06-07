package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommercialVehicle", propOrder = {
	"certification",
	"classZZ",
	"fuel",
	"make",
	"poweredOrTrailer",
	"shortClass",
	"tag",
	"year"
})

public class CommercialVehicle implements Serializable {

	@XmlElement(name = "Certification")
	protected String certification;
	public String getCertification() {return certification;}
	public void setCertification(String value) {this.certification =  value;}

	@XmlElement(name = "Class")
	protected String classZZ;
	public String getClassZZ() {return classZZ;}
	public void setClassZZ(String value) {this.classZZ =  value;}

	@XmlElement(name = "Fuel")
	protected String fuel;
	public String getFuel() {return fuel;}
	public void setFuel(String value) {this.fuel =  value;}

	@XmlElement(name = "Make")
	protected String make;
	public String getMake() {return make;}
	public void setMake(String value) {this.make =  value;}

	@XmlElement(name = "PoweredOrTrailer")
	protected String poweredOrTrailer;
	public String getPoweredOrTrailer() {return poweredOrTrailer;}
	public void setPoweredOrTrailer(String value) {this.poweredOrTrailer =  value;}

	@XmlElement(name = "ShortClass")
	protected String shortClass;
	public String getShortClass() {return shortClass;}
	public void setShortClass(String value) {this.shortClass =  value;}

	@XmlElement(name = "Tag")
	protected String tag;
	public String getTag() {return tag;}
	public void setTag(String value) {this.tag =  value;}

	@XmlElement(name = "Year")
	protected String year;
	public String getYear() {return year;}
	public void setYear(String value) {this.year =  value;}

}
