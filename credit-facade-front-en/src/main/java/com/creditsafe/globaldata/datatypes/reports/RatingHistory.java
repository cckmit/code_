package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RatingHistory", propOrder = {
	"event"
})

public class RatingHistory implements Serializable {

	@XmlElement(name = "Event")
	protected List<Event> event;
	public List<Event> getEvent() {
		if (event == null) {
			event = new ArrayList<Event>();
		}
		return event;
	}
}
