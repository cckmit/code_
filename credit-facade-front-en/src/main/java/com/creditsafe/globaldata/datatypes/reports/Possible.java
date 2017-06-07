package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Possible", propOrder = {
	"countyCourtJudgement"
})

public class Possible implements Serializable {

	@XmlElement(name = "CountyCourtJudgement")
	protected CountyCourtJudgement countyCourtJudgement;
	public CountyCourtJudgement getCountyCourtJudgement() {return countyCourtJudgement;}
	public void setCountyCourtJudgement(CountyCourtJudgement value) {this.countyCourtJudgement =  value;}

}
