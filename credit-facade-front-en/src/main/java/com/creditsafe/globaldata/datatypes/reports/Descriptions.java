package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Descriptions", propOrder = {
	"description"
})

public class Descriptions implements Serializable {

	@XmlElement(name = "Description")
	protected List<String> description;
	public List<String> getDescription() {
		if (description == null) {
			description = new ArrayList<String>();
		}
		return description;
	}
}
