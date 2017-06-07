package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Facts", propOrder = {
	"courtAction",
	"dateOfBankruptcy"
})

public class Facts implements Serializable {

	@XmlElement(name = "CourtAction")
	protected String courtAction;
	public String getCourtAction() {return courtAction;}
	public void setCourtAction(String value) {this.courtAction =  value;}

	@XmlElement(name = "DateOfBankruptcy")
	protected String dateOfBankruptcy;
	public String getDateOfBankruptcy() {return dateOfBankruptcy;}
	public void setDateOfBankruptcy(String value) {this.dateOfBankruptcy =  value;}

}
