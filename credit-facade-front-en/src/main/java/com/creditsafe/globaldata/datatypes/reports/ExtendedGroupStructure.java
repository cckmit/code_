package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtendedGroupStructure", propOrder = {
	"groupStructure"
})

public class ExtendedGroupStructure implements Serializable {

	@XmlElement(name = "GroupStructure")
	protected GroupStructure groupStructure;
	public GroupStructure getGroupStructure() {return groupStructure;}
	public void setGroupStructure(GroupStructure value) {this.groupStructure =  value;}

}
