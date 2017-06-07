package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompanySignificantEvent", propOrder = {
	"eventDate",
	"eventDescription",
	"eventDetails"
})

public class CompanySignificantEvent implements Serializable {

	@XmlElement(name = "EventDate")
	protected String eventDate;
	public String getEventDate() {return eventDate;}
	public void setEventDate(String value) {this.eventDate =  value;}

	@XmlElement(name = "EventDescription")
	protected String eventDescription;
	public String getEventDescription() {return eventDescription;}
	public void setEventDescription(String value) {this.eventDescription =  value;}

	@XmlElement(name = "EventDetails")
	protected String eventDetails;
	public String getEventDetails() {return eventDetails;}
	public void setEventDetails(String value) {this.eventDetails =  value;}

}
