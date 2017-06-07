package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Registered", propOrder = {
	"exact",
	"possible"
})

public class Registered implements Serializable {

	@XmlElement(name = "Exact")
	protected Exact exact;
	public Exact getExact() {return exact;}
	public void setExact(Exact value) {this.exact =  value;}

	@XmlElement(name = "Possible")
	protected Possible possible;
	public Possible getPossible() {return possible;}
	public void setPossible(Possible value) {this.possible =  value;}

}
