package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegisteredRoles", propOrder = {
	"registeredRole"
})

public class RegisteredRoles implements Serializable {

	@XmlElement(name = "RegisteredRole")
	protected List<RegisteredRole> registeredRole;
	public List<RegisteredRole> getRegisteredRole() {
		if (registeredRole == null) {
			registeredRole = new ArrayList<RegisteredRole>();
		}
		return registeredRole;
	}
}
