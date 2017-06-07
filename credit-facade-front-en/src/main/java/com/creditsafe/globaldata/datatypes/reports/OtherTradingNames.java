package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OtherTradingNames", propOrder = {
	"otherTradingName"
})

public class OtherTradingNames implements Serializable {

	@XmlElement(name = "OtherTradingName")
	protected List<String> otherTradingName;
	public List<String> getOtherTradingName() {
		if (otherTradingName == null) {
			otherTradingName = new ArrayList<String>();
		}
		return otherTradingName;
	}
}
