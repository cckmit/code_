package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NSSODetails", propOrder = {
	"nssoDetail"
})

public class NSSODetails implements Serializable {

	@XmlElement(name = "NSSODetail")
	protected List<NSSODetail> nssoDetail;
	public List<NSSODetail> getNssoDetail() {
		if (nssoDetail == null) {
			nssoDetail = new ArrayList<NSSODetail>();
		}
		return nssoDetail;
	}
}
