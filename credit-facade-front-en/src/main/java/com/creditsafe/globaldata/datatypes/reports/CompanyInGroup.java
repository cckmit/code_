package com.creditsafe.globaldata.datatypes.reports;

import com.mika.credit.common.util.StringUtil;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompanyInGroup", propOrder = {
	"companyName",
	"registeredNumber",
	"latestAnnualAccounts",
	"level",
	"status",
	"companyRatingBanding"
})

public class CompanyInGroup implements Serializable {

	@XmlElement(name = "CompanyName")
	protected String companyName;
	public String getCompanyName() {return companyName;}
	public void setCompanyName(String value) {this.companyName =  value;}

	@XmlElement(name = "RegisteredNumber")
	protected String registeredNumber;
	public String getRegisteredNumber() {return registeredNumber;}
	public void setRegisteredNumber(String value) {this.registeredNumber =  value;}

	@XmlElement(name = "LatestAnnualAccounts")
	protected String latestAnnualAccounts;
	public String getLatestAnnualAccounts() {return latestAnnualAccounts;}
	public void setLatestAnnualAccounts(String value) {
		if (StringUtil.isNotNull(value)){
			this.latestAnnualAccounts =  value.substring(0,10);
		}else {
			this.latestAnnualAccounts =  value;
		}
		}

	@XmlElement(name = "Level")
	protected String level;
	public String getLevel() {return level;}
	public void setLevel(String value) {this.level =  value;}

	@XmlElement(name = "Status")
	protected String status;
	public String getStatus() {return status;}
	public void setStatus(String value) {this.status =  value;}

	@XmlElement(name = "CompanyRatingBanding")
	protected String companyRatingBanding;
	public String getCompanyRatingBanding() {return companyRatingBanding;}
	public void setCompanyRatingBanding(String value) {this.companyRatingBanding =  value;}

	@XmlAttribute(name = "Id")
	protected String id;
	public String getId() {return id;}
	public void setId(String value) {this.id =  value;}

	@XmlAttribute(name = "Country")
	protected String country;
	public String getCountry() {return country;}
	public void setCountry(String value) {this.country =  value;}

	@XmlAttribute(name = "SafeNumber")
	protected String safeNumber;
	public String getSafeNumber() {return safeNumber;}
	public void setSafeNumber(String value) {this.safeNumber =  value;}

}
