package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TurnoverRange", propOrder = {
	"year",
	"range"
})

public class TurnoverRange implements Serializable {

	@XmlElement(name = "Year")
	protected String year;
	public String getYear() {return year;}
	public void setYear(String value) {this.year =  value;}

	@XmlElement(name = "Range")
	protected String range;
	public String getRange() {return range;}
	public void setRange(String value) {this.range =  value;}

}
