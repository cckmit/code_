package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Mergers", propOrder = {
	"merger"
})

public class Mergers implements Serializable {

	@XmlElement(name = "Merger")
	protected List<Merger> merger;
	public List<Merger> getMerger() {
		if (merger == null) {
			merger = new ArrayList<Merger>();
		}
		return merger;
	}
}
