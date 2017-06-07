package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Judgements", propOrder = {
	"judgement"
})

public class Judgements implements Serializable {

	@XmlElement(name = "Judgement")
	protected List<Judgement> judgement;
	public List<Judgement> getJudgement() {
		if (judgement == null) {
			judgement = new ArrayList<Judgement>();
		}
		return judgement;
	}
}
