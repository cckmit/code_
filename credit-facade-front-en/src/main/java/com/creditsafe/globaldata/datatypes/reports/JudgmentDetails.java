package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JudgmentDetails", propOrder = {
	"judgmentDetail"
})

public class JudgmentDetails implements Serializable {

	@XmlElement(name = "JudgmentDetail")
	protected List<JudgmentDetail> judgmentDetail;

	public List<JudgmentDetail> getJudgmentDetail() {
		if (judgmentDetail == null) {
			judgmentDetail = new ArrayList<JudgmentDetail>();
		}
		return judgmentDetail;
	}
}
