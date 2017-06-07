package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CapitalFigures", propOrder = {
	"capitalCurrency",
	"deliberatedShareCapital",
	"subscribedShareCapital",
	"paidInShareCapital",
	"numberofSharesintheShareCapital",
	"shareUnitValue",
	"shareUnitCurrency"
})

public class CapitalFigures implements Serializable {

	@XmlElement(name = "CapitalCurrency")
	protected String capitalCurrency;
	public String getCapitalCurrency() {return capitalCurrency;}
	public void setCapitalCurrency(String value) {this.capitalCurrency =  value;}

	@XmlElement(name = "DeliberatedShareCapital")
	protected String deliberatedShareCapital;
	public String getDeliberatedShareCapital() {return deliberatedShareCapital;}
	public void setDeliberatedShareCapital(String value) {this.deliberatedShareCapital =  value;}

	@XmlElement(name = "SubscribedShareCapital")
	protected String subscribedShareCapital;
	public String getSubscribedShareCapital() {return subscribedShareCapital;}
	public void setSubscribedShareCapital(String value) {this.subscribedShareCapital =  value;}

	@XmlElement(name = "PaidInShareCapital")
	protected String paidInShareCapital;
	public String getPaidInShareCapital() {return paidInShareCapital;}
	public void setPaidInShareCapital(String value) {this.paidInShareCapital =  value;}

	@XmlElement(name = "NumberofSharesintheShareCapital")
	protected String numberofSharesintheShareCapital;
	public String getNumberofSharesintheShareCapital() {return numberofSharesintheShareCapital;}
	public void setNumberofSharesintheShareCapital(String value) {this.numberofSharesintheShareCapital =  value;}

	@XmlElement(name = "ShareUnitValue")
	protected String shareUnitValue;
	public String getShareUnitValue() {return shareUnitValue;}
	public void setShareUnitValue(String value) {this.shareUnitValue =  value;}

	@XmlElement(name = "ShareUnitCurrency")
	protected String shareUnitCurrency;
	public String getShareUnitCurrency() {return shareUnitCurrency;}
	public void setShareUnitCurrency(String value) {this.shareUnitCurrency =  value;}

}
