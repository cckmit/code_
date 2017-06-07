package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Judgement", propOrder = {
	"effectiveDate",
	"typeofJudgement",
	"court",
	"details",
	"liquidators"
})

public class Judgement implements Serializable {

	@XmlElement(name = "EffectiveDate")
	protected String effectiveDate;
	public String getEffectiveDate() {return effectiveDate;}
	public void setEffectiveDate(String value) {this.effectiveDate =  value;}

	@XmlElement(name = "TypeofJudgement")
	protected String typeofJudgement;
	public String getTypeofJudgement() {return typeofJudgement;}
	public void setTypeofJudgement(String value) {this.typeofJudgement =  value;}

	@XmlElement(name = "Court")
	protected String court;
	public String getCourt() {return court;}
	public void setCourt(String value) {this.court =  value;}

	@XmlElement(name = "Details")
	protected String details;
	public String getDetails() {return details;}
	public void setDetails(String value) {this.details =  value;}

	@XmlElement(name = "Liquidators")
	protected Liquidators liquidators;
	public Liquidators getLiquidators() {return liquidators;}
	public void setLiquidators(Liquidators value) {this.liquidators =  value;}

}
