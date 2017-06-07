package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Activities", propOrder = {
	"activity"
})

public class Activities implements Serializable {

	@XmlElement(name = "Activity")
	protected List<Activity> activity;
	public List<Activity> getActivity() {
		if (activity == null) {
			activity = new ArrayList<Activity>();
		}
		return activity;
	}
}
