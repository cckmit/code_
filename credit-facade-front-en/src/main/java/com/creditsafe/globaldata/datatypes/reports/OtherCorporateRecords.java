package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OtherCorporateRecords", propOrder = {
	"corporateRecord"
})

public class OtherCorporateRecords implements Serializable {

	@XmlElement(name = "CorporateRecord")
	protected List<CorporateRecord> corporateRecord;
	public List<CorporateRecord> getCorporateRecord() {
		if (corporateRecord == null) {
			corporateRecord = new ArrayList<CorporateRecord>();
		}
		return corporateRecord;
	}
}
