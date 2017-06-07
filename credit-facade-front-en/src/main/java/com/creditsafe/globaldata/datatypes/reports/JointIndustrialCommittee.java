package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JointIndustrialCommittee", propOrder = {
	"entry"
})

public class JointIndustrialCommittee implements Serializable {

	@XmlElement(name = "Entry")
	protected Entry entry;
	public Entry getEntry() {return entry;}
	public void setEntry(Entry value) {this.entry =  value;}

}
