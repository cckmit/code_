package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Commentaries", propOrder = {
	"commentary"
})

public class Commentaries implements Serializable {

	@XmlElement(name = "Commentary")
	protected List<Commentary> commentary;
	public List<Commentary> getCommentary() {
		if (commentary == null) {
			commentary = new ArrayList<Commentary>();
		}
		return commentary;
	}
}
