package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommonRating", propOrder = {
	"commonValue",
	"commonDescription"
})

public class CommonRating implements Serializable {

	@XmlElement(name = "CommonValue")
	protected String commonValue;
	public String getCommonValue() {return commonValue;}
	public void setCommonValue(String value) {this.commonValue =  value;}

	@XmlElement(name = "CommonDescription")
	protected String commonDescription;
	public String getCommonDescription() {return commonDescription;}
	public void setCommonDescription(String value) {this.commonDescription =  value;}

}
