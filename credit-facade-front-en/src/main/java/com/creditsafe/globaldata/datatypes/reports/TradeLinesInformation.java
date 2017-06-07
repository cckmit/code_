package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradeLinesInformation", propOrder = {
	"continuous",
	"combined",
	"total"
})

public class TradeLinesInformation implements Serializable {

	@XmlElement(name = "Continuous")
	protected TradeLine continuous;
	public TradeLine getContinuous() {return continuous;}
	public void setContinuous(TradeLine value) {this.continuous =  value;}

	@XmlElement(name = "Combined")
	protected TradeLine combined;
	public TradeLine getCombined() {return combined;}
	public void setCombined(TradeLine value) {this.combined =  value;}

	@XmlElement(name = "Total")
	protected TradeLine total;
	public TradeLine getTotal() {return total;}
	public void setTotal(TradeLine value) {this.total =  value;}

}
