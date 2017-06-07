package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Activity", propOrder = {
	"code",
	"type",
	"startDate",
	"description"
})

public class Activity implements Serializable {

	@XmlElement(name = "Code")
	protected String code;
	public String getCode() {return code;}
	public void setCode(String value) {this.code =  value;}

	@XmlElement(name = "Type")
	protected String type;
	public String getType() {return type;}
	public void setType(String value) {this.type =  value;}

	@XmlElement(name = "StartDate")
	protected String startDate;
	public String getStartDate() {return startDate;}
	public void setStartDate(String value) {this.startDate =  value;}

	@XmlElement(name = "Description")
	protected String description;
	public String getDescription() {return description;}
	public void setDescription(String value) {this.description =  value;}

	@XmlAttribute(name = "CodeType")
	protected String codeType;
	public String getCodeType() {return codeType;}
	public void setCodeType(String value) {this.codeType =  value;}

}
