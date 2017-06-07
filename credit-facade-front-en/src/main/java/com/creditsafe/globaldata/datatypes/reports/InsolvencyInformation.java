package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsolvencyInformation", propOrder = {
	"insolvencyEvents"
})

public class InsolvencyInformation implements Serializable {

	@XmlElement(name = "InsolvencyEvents")
	protected InsolvencyEvents insolvencyEvents;
	public InsolvencyEvents getInsolvencyEvents() {return insolvencyEvents;}
	public void setInsolvencyEvents(InsolvencyEvents value) {this.insolvencyEvents =  value;}

}
