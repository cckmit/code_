package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MainSupplier", propOrder = {
	"companyName",
	"province"
})

public class MainSupplier implements Serializable {

	@XmlElement(name = "CompanyName")
	protected String companyName;
	public String getCompanyName() {return companyName;}
	public void setCompanyName(String value) {this.companyName =  value;}

	@XmlElement(name = "Province")
	protected String province;
	public String getProvince() {return province;}
	public void setProvince(String value) {this.province =  value;}

}
