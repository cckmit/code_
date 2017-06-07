package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MainSuppliers", propOrder = {
	"mainSupplier"
})

public class MainSuppliers implements Serializable {

	@XmlElement(name = "MainSupplier")
	protected List<MainSupplier> mainSupplier;
	public List<MainSupplier> getMainSupplier() {
		if (mainSupplier == null) {
			mainSupplier = new ArrayList<MainSupplier>();
		}
		return mainSupplier;
	}
}
