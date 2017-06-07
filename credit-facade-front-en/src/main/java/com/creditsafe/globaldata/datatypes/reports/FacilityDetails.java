package com.creditsafe.globaldata.datatypes.reports;

import com.creditsafe.globaldata.datatypes.AddressData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FacilityDetails", propOrder = {
	"description",
	"situation",
	"address",
	"activityIncidents",
	"levelofActivity",
	"levelofCompetition",
	"knownintheArea",
	"stockLevel"
})

public class FacilityDetails implements Serializable {

	@XmlElement(name = "Description")
	protected String description;
	public String getDescription() {return description;}
	public void setDescription(String value) {this.description =  value;}

	@XmlElement(name = "Situation")
	protected String situation;
	public String getSituation() {return situation;}
	public void setSituation(String value) {this.situation =  value;}

	@XmlElement(name = "Address")
	protected AddressData address;
	public AddressData getAddress() {return address;}
	public void setAddress(AddressData value) {this.address =  value;}

	@XmlElement(name = "ActivityIncidents")
	protected String activityIncidents;
	public String getActivityIncidents() {return activityIncidents;}
	public void setActivityIncidents(String value) {this.activityIncidents =  value;}

	@XmlElement(name = "LevelofActivity")
	protected String levelofActivity;
	public String getLevelofActivity() {return levelofActivity;}
	public void setLevelofActivity(String value) {this.levelofActivity =  value;}

	@XmlElement(name = "LevelofCompetition")
	protected String levelofCompetition;
	public String getLevelofCompetition() {return levelofCompetition;}
	public void setLevelofCompetition(String value) {this.levelofCompetition =  value;}

	@XmlElement(name = "KnownintheArea")
	protected String knownintheArea;
	public String getKnownintheArea() {return knownintheArea;}
	public void setKnownintheArea(String value) {this.knownintheArea =  value;}

	@XmlElement(name = "StockLevel")
	protected String stockLevel;
	public String getStockLevel() {return stockLevel;}
	public void setStockLevel(String value) {this.stockLevel =  value;}

}
