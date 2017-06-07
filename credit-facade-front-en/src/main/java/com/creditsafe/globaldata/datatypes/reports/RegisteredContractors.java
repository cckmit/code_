package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegisteredContractors", propOrder = {
	"registeredContractor"
})

public class RegisteredContractors implements Serializable {

	@XmlElement(name = "RegisteredContractor")
	protected List<RegisteredContractor> registeredContractor;
	public List<RegisteredContractor> getRegisteredContractor() {
		if (registeredContractor == null) {
			registeredContractor = new ArrayList<RegisteredContractor>();
		}
		return registeredContractor;
	}
}
