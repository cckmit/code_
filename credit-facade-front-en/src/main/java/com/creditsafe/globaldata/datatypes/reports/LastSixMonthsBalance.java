package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LastSixMonthsBalance", propOrder = {
	"entry"
})

public class LastSixMonthsBalance implements Serializable {

	@XmlElement(name = "Entry")
	protected List<Entry> entry;
	public List<Entry> getEntry() {
		if (entry == null) {
			entry = new ArrayList<Entry>();
		}
		return entry;
	}
}
