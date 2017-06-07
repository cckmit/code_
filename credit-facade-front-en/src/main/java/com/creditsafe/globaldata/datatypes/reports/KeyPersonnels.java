package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KeyPersonnels", propOrder = {
	"keyPersonnel"
})

public class KeyPersonnels implements Serializable {

	@XmlElement(name = "KeyPersonnel")
	protected List<KeyPersonnel> keyPersonnel;
	public List<KeyPersonnel> getKeyPersonnel() {
		if (keyPersonnel == null) {
			keyPersonnel = new ArrayList<KeyPersonnel>();
		}
		return keyPersonnel;
	}
}
