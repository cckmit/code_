package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Bankruptcy", propOrder = {
	"hasBankruptcy",
	"hasBankruptcyExactNameAndAddressMatch",
	"hasBankruptcyExactAddressMatch",
	"hasBankruptcyExactNameMatch"
})

public class Bankruptcy implements Serializable {

	@XmlElement(name = "HasBankruptcy")
	protected String hasBankruptcy;
	public String getHasBankruptcy() {return hasBankruptcy;}
	public void setHasBankruptcy(String value) {this.hasBankruptcy =  value;}

	@XmlElement(name = "HasBankruptcyExactNameAndAddressMatch")
	protected String hasBankruptcyExactNameAndAddressMatch;
	public String getHasBankruptcyExactNameAndAddressMatch() {return hasBankruptcyExactNameAndAddressMatch;}
	public void setHasBankruptcyExactNameAndAddressMatch(String value) {this.hasBankruptcyExactNameAndAddressMatch =  value;}

	@XmlElement(name = "HasBankruptcyExactAddressMatch")
	protected String hasBankruptcyExactAddressMatch;
	public String getHasBankruptcyExactAddressMatch() {return hasBankruptcyExactAddressMatch;}
	public void setHasBankruptcyExactAddressMatch(String value) {this.hasBankruptcyExactAddressMatch =  value;}

	@XmlElement(name = "HasBankruptcyExactNameMatch")
	protected String hasBankruptcyExactNameMatch;
	public String getHasBankruptcyExactNameMatch() {return hasBankruptcyExactNameMatch;}
	public void setHasBankruptcyExactNameMatch(String value) {this.hasBankruptcyExactNameMatch =  value;}

}
