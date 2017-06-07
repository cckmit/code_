package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ratios", propOrder = {
	"needForWorkingCapital"
})

public class Ratios implements Serializable {

	@XmlElement(name = "NeedForWorkingCapital")
	protected String needForWorkingCapital;
	public String getNeedForWorkingCapital() {return needForWorkingCapital;}
	public void setNeedForWorkingCapital(String value) {this.needForWorkingCapital =  value;}

}
