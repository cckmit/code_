package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Incidents", propOrder = {
	"defendant",
	"affectedAsPlaintiff"
})

public class Incidents implements Serializable {

	@XmlElement(name = "Defendant")
	protected Defendant defendant;
	public Defendant getDefendant() {return defendant;}
	public void setDefendant(Defendant value) {this.defendant =  value;}

	@XmlElement(name = "AffectedAsPlaintiff")
	protected AffectedAsPlaintiff affectedAsPlaintiff;
	public AffectedAsPlaintiff getAffectedAsPlaintiff() {return affectedAsPlaintiff;}
	public void setAffectedAsPlaintiff(AffectedAsPlaintiff value) {this.affectedAsPlaintiff =  value;}

}
