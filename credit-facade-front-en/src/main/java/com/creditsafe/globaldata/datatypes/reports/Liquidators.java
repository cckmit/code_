package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Liquidators", propOrder = {
	"liquidator"
})

public class Liquidators implements Serializable {

	@XmlElement(name = "Liquidator")
	protected List<String> liquidator;
	public List<String> getLiquidator() {
		if (liquidator == null) {
			liquidator = new ArrayList<String>();
		}
		return liquidator;
	}
}
