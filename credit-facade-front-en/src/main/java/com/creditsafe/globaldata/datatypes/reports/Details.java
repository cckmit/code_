package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Details", propOrder = {
	"itemDate",
	"type",
	"defaultAmount"
})

public class Details implements Serializable {

	@XmlElement(name = "ItemDate")
	protected String itemDate;
	public String getItemDate() {return itemDate;}
	public void setItemDate(String value) {this.itemDate =  value;}

	@XmlElement(name = "Type")
	protected String type;
	public String getType() {return type;}
	public void setType(String value) {this.type =  value;}

	@XmlElement(name = "DefaultAmount")
	protected String defaultAmount;
	public String getDefaultAmount() {return defaultAmount;}
	public void setDefaultAmount(String value) {this.defaultAmount =  value;}

}
