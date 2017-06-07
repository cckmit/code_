package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BeneficialOwnerships", propOrder = {
	"owner"
})

public class BeneficialOwnerships implements Serializable {

	@XmlElement(name = "Owner")
	protected List<Owner> owner;
	public List<Owner> getOwner() {
		if (owner == null) {
			owner = new ArrayList<Owner>();
		}
		return owner;
	}
}
