package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TurnoverRanges", propOrder = {
	"turnoverRange"
})

public class TurnoverRanges implements Serializable {

	@XmlElement(name = "TurnoverRange")
	protected List<TurnoverRange> turnoverRange;
	public List<TurnoverRange> getTurnoverRange() {
		if (turnoverRange == null) {
			turnoverRange = new ArrayList<TurnoverRange>();
		}
		return turnoverRange;
	}
}
