package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommercialVehicles", propOrder = {
	"commercialVehicle"
})

public class CommercialVehicles implements Serializable {

	@XmlElement(name = "CommercialVehicle")
	protected List<CommercialVehicle> commercialVehicle;
	public List<CommercialVehicle> getCommercialVehicle() {
		if (commercialVehicle == null) {
			commercialVehicle = new ArrayList<CommercialVehicle>();
		}
		return commercialVehicle;
	}
}
