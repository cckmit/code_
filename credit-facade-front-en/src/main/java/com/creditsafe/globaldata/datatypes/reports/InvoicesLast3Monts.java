package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InvoicesLast3Monts", propOrder = {
	"paidP1",
	"paidP2",
	"paidP3",
	"paidP4",
	"paidInTerms",
	"totalPaid"
})

public class InvoicesLast3Monts implements Serializable {

	@XmlElement(name = "paidP1")
	protected String paidP1;
	public String getPaidP1() {return paidP1;}
	public void setPaidP1(String value) {this.paidP1 =  value;}

	@XmlElement(name = "paidP2")
	protected String paidP2;
	public String getPaidP2() {return paidP2;}
	public void setPaidP2(String value) {this.paidP2 =  value;}

	@XmlElement(name = "paidP3")
	protected String paidP3;
	public String getPaidP3() {return paidP3;}
	public void setPaidP3(String value) {this.paidP3 =  value;}

	@XmlElement(name = "paidP4")
	protected String paidP4;
	public String getPaidP4() {return paidP4;}
	public void setPaidP4(String value) {this.paidP4 =  value;}

	@XmlElement(name = "paidInTerms")
	protected String paidInTerms;
	public String getPaidInTerms() {return paidInTerms;}
	public void setPaidInTerms(String value) {this.paidInTerms =  value;}

	@XmlElement(name = "totalPaid")
	protected String totalPaid;
	public String getTotalPaid() {return totalPaid;}
	public void setTotalPaid(String value) {this.totalPaid =  value;}

}
