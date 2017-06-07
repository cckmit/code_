package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RealEstate", propOrder = {
	"value"
})

public class RealEstate implements Serializable {

	@XmlElement(name = "Value")
	protected String value;
	public String getValue() {return value;}
	public void setValue(String value) {this.value =  value;}

}
