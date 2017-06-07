package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProtestedBills", propOrder = {
	"protestedBill"
})

public class ProtestedBills implements Serializable {

	@XmlElement(name = "ProtestedBill")
	protected List<ProtestedBill> protestedBill;
	public List<ProtestedBill> getProtestedBill() {
		if (protestedBill == null) {
			protestedBill = new ArrayList<ProtestedBill>();
		}
		return protestedBill;
	}
}
