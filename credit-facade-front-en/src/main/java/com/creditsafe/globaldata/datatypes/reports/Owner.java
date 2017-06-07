package com.creditsafe.globaldata.datatypes.reports;

import com.creditsafe.globaldata.datatypes.AddressData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Owner", propOrder = {
	"name",
	"address",
	"country",
	"sharePercent"
})

public class Owner implements Serializable {

	@XmlElement(name = "Name")
	protected String name;
	public String getName() {return name;}
	public void setName(String value) {this.name =  value;}

	@XmlElement(name = "Address")
	protected AddressData address;
	public AddressData getAddress() {return address;}
	public void setAddress(AddressData value) {this.address =  value;}

	@XmlElement(name = "Country")
	protected String country;
	public String getCountry() {return country;}
	public void setCountry(String value) {this.country =  value;}

	@XmlElement(name = "SharePercent")
	protected String sharePercent;
	public String getSharePercent() {return sharePercent;}
	public void setSharePercent(String value) {this.sharePercent =  value;}

}
