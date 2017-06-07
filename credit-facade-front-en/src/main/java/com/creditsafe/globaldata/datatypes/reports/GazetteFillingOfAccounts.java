package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GazetteFillingOfAccounts", propOrder = {
	"gazetteFillingOfAccount"
})

public class GazetteFillingOfAccounts implements Serializable {

	@XmlElement(name = "GazetteFillingOfAccount")
	protected List<GazetteFillingOfAccount> gazetteFillingOfAccount;
	public List<GazetteFillingOfAccount> getGazetteFillingOfAccount() {
		if (gazetteFillingOfAccount == null) {
			gazetteFillingOfAccount = new ArrayList<GazetteFillingOfAccount>();
		}
		return gazetteFillingOfAccount;
	}
}
