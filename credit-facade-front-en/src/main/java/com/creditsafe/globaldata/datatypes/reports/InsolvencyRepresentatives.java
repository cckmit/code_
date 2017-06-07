package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsolvencyRepresentatives", propOrder = {
	"insolvencyRepresentative"
})

public class InsolvencyRepresentatives implements Serializable {

	@XmlElement(name = "InsolvencyRepresentative")
	protected List<String> insolvencyRepresentative;
	public List<String> getInsolvencyRepresentative() {
		if (insolvencyRepresentative == null) {
			insolvencyRepresentative = new ArrayList<String>();
		}
		return insolvencyRepresentative;
	}
}
