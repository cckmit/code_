package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GazetteRegisteredDeed", propOrder = {
	"datePublished",
	"descriptions",
	"numberOfDeeds"
})

public class GazetteRegisteredDeed implements Serializable {

	@XmlElement(name = "DatePublished")
	protected String datePublished;
	public String getDatePublished() {return datePublished;}
	public void setDatePublished(String value) {this.datePublished =  value;}

	@XmlElement(name = "Descriptions")
	protected Descriptions descriptions;
	public Descriptions getDescriptions() {return descriptions;}
	public void setDescriptions(Descriptions value) {this.descriptions =  value;}

	@XmlElement(name = "NumberOfDeeds")
	protected String numberOfDeeds;
	public String getNumberOfDeeds() {return numberOfDeeds;}
	public void setNumberOfDeeds(String value) {this.numberOfDeeds =  value;}

}
