package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BankruptcyData", propOrder = {
	"bankruptcy"
})

public class BankruptcyData implements Serializable {

	@XmlElement(name = "Bankruptcy")
	protected Bankruptcy bankruptcy;
	public Bankruptcy getBankruptcy() {return bankruptcy;}
	public void setBankruptcy(Bankruptcy value) {this.bankruptcy =  value;}

}
