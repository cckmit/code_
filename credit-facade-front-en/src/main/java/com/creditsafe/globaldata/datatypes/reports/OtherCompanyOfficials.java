package com.creditsafe.globaldata.datatypes.reports;

import com.creditsafe.globaldata.datatypes.AddressData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OtherCompanyOfficials", propOrder = {
	"name",
	"position",
	"address"
})

public class OtherCompanyOfficials implements Serializable {

	@XmlElement(name = "Name")
	protected String name;
	public String getName() {return name;}
	public void setName(String value) {this.name =  value;}

	@XmlElement(name = "Position")
	protected String position;
	public String getPosition() {return position;}
	public void setPosition(String value) {this.position =  value;}

	@XmlElement(name = "Address")
	protected AddressData address;
	public AddressData getAddress() {return address;}
	public void setAddress(AddressData value) {this.address =  value;}

}
