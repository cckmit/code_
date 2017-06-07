package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompanyCertificate", propOrder = {
	"type",
	"category",
	"issuer"
})

public class CompanyCertificate implements Serializable {

	@XmlElement(name = "Type")
	protected String type;
	public String getType() {return type;}
	public void setType(String value) {this.type =  value;}

	@XmlElement(name = "Category")
	protected String category;
	public String getCategory() {return category;}
	public void setCategory(String value) {this.category =  value;}

	@XmlElement(name = "Issuer")
	protected String issuer;
	public String getIssuer() {return issuer;}
	public void setIssuer(String value) {this.issuer =  value;}

}
