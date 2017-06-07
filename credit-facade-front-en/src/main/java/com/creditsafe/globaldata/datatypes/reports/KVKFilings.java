package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KVKFilings", propOrder = {
	"kvkFiling"
})

public class KVKFilings implements Serializable {

	@XmlElement(name = "KVKFiling")
	protected List<KVKFiling> kvkFiling;
	public List<KVKFiling> getKvkFiling() {
		if (kvkFiling == null) {
			kvkFiling = new ArrayList<KVKFiling>();
		}
		return kvkFiling;
	}
}
