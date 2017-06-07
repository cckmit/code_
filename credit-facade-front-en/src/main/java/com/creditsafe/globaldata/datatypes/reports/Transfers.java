package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Transfers", propOrder = {
	"transfer"
})

public class Transfers implements Serializable {

	@XmlElement(name = "Transfer")
	protected List<Transfer> transfer;
	public List<Transfer> getTransfer() {
		if (transfer == null) {
			transfer = new ArrayList<Transfer>();
		}
		return transfer;
	}
}
