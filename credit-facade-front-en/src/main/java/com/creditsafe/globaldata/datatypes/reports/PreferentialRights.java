package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PreferentialRights", propOrder = {
	"preferentialRight"
})

public class PreferentialRights implements Serializable {

	@XmlElement(name = "PreferentialRight")
	protected List<PreferentialRight> preferentialRight;
	public List<PreferentialRight> getPreferentialRight() {
		if (preferentialRight == null) {
			preferentialRight = new ArrayList<PreferentialRight>();
		}
		return preferentialRight;
	}
	@XmlAttribute(name = "MonitoredStatus")
	protected String monitoredStatus;
	public String getMonitoredStatus() {return monitoredStatus;}
	public void setMonitoredStatus(String value) {this.monitoredStatus =  value;}

	@XmlAttribute(name = "DateMonitored")
	protected String dateMonitored;
	public String getDateMonitored() {return dateMonitored;}
	public void setDateMonitored(String value) {this.dateMonitored =  value;}

	@XmlAttribute(name = "NoOfActivePreferentialRights")
	protected String noOfActivePreferentialRights;
	public String getNoOfActivePreferentialRights() {return noOfActivePreferentialRights;}
	public void setNoOfActivePreferentialRights(String value) {this.noOfActivePreferentialRights =  value;}

	@XmlAttribute(name = "TotalActiveAmount")
	protected String totalActiveAmount;
	public String getTotalActiveAmount() {return totalActiveAmount;}
	public void setTotalActiveAmount(String value) {this.totalActiveAmount =  value;}

	@XmlAttribute(name = "TotalActiveAmountDue")
	protected String totalActiveAmountDue;
	public String getTotalActiveAmountDue() {return totalActiveAmountDue;}
	public void setTotalActiveAmountDue(String value) {this.totalActiveAmountDue =  value;}

}
