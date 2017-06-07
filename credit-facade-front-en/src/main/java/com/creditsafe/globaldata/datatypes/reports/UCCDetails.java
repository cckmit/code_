package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UCCDetails", propOrder = {
	"uccDetail"
})

public class UCCDetails implements Serializable {

	@XmlElement(name = "UCCDetail")
	protected List<UCCDetail> uccDetail;
	public List<UCCDetail> getUccDetail() {
		if (uccDetail == null) {
			uccDetail = new ArrayList<UCCDetail>();
		}
		return uccDetail;
	}
}
