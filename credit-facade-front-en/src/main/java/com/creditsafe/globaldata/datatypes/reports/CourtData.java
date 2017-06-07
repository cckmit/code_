package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CourtData", propOrder = {
	"facts",
	"receiverDetails"
})

public class CourtData implements Serializable {

	@XmlElement(name = "Facts")
	protected Facts facts;
	public Facts getFacts() {return facts;}
	public void setFacts(Facts value) {this.facts =  value;}

	@XmlElement(name = "ReceiverDetails")
	protected ReceiverDetails receiverDetails;
	public ReceiverDetails getReceiverDetails() {return receiverDetails;}
	public void setReceiverDetails(ReceiverDetails value) {this.receiverDetails =  value;}

}
