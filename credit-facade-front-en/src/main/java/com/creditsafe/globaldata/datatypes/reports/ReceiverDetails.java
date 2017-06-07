package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReceiverDetails", propOrder = {
	"address"
})

public class ReceiverDetails implements Serializable {

	@XmlElement(name = "Address")
	protected String address;
	public String getAddress() {return address;}
	public void setAddress(String value) {this.address =  value;}

}
