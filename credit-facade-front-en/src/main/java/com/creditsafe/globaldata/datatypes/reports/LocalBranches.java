package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LocalBranches", propOrder = {
	"localBranch"
})

public class LocalBranches implements Serializable {

	@XmlElement(name = "LocalBranch")
	protected List<LocalBranch> localBranch;
	public List<LocalBranch> getLocalBranch() {
		if (localBranch == null) {
			localBranch = new ArrayList<LocalBranch>();
		}
		return localBranch;
	}
}
