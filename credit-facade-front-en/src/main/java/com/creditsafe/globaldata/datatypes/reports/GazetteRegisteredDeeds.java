package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GazetteRegisteredDeeds", propOrder = {
	"gazetteRegisteredDeed"
})

public class GazetteRegisteredDeeds implements Serializable {

	@XmlElement(name = "GazetteRegisteredDeed")
	protected List<GazetteRegisteredDeed> gazetteRegisteredDeed;
	public List<GazetteRegisteredDeed> getGazetteRegisteredDeed() {
		if (gazetteRegisteredDeed == null) {
			gazetteRegisteredDeed = new ArrayList<GazetteRegisteredDeed>();
		}
		return gazetteRegisteredDeed;
	}
}
