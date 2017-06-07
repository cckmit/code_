package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuditorComments", propOrder = {
	"auditorComment"
})

public class AuditorComments implements Serializable {

	@XmlElement(name = "AuditorComment")
	protected List<AuditorComment> auditorComment;
	public List<AuditorComment> getAuditorComment() {
		if (auditorComment == null) {
			auditorComment = new ArrayList<AuditorComment>();
		}
		return auditorComment;
	}
}
