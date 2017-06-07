package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IndustryComparison", propOrder = {
	"activityCode",
	"activityDescription",
	"industryAverageCreditRating",
	"industryAverageCreditLimit",
	"industryAverageDaySalesOutstanding",
	"industryAveragePaymentExpectationDays"
})

public class IndustryComparison implements Serializable {

	@XmlElement(name = "ActivityCode")
	protected String activityCode;
	public String getActivityCode() {return activityCode;}
	public void setActivityCode(String value) {this.activityCode =  value;}

	@XmlElement(name = "ActivityDescription")
	protected String activityDescription;
	public String getActivityDescription() {return activityDescription;}
	public void setActivityDescription(String value) {this.activityDescription =  value;}

	@XmlElement(name = "IndustryAverageCreditRating")
	protected String industryAverageCreditRating;
	public String getIndustryAverageCreditRating() {return industryAverageCreditRating;}
	public void setIndustryAverageCreditRating(String value) {this.industryAverageCreditRating =  value;}

	@XmlElement(name = "IndustryAverageCreditLimit")
	protected String industryAverageCreditLimit;
	public String getIndustryAverageCreditLimit() {return industryAverageCreditLimit;}
	public void setIndustryAverageCreditLimit(String value) {this.industryAverageCreditLimit =  value;}

	@XmlElement(name = "IndustryAverageDaySalesOutstanding")
	protected String industryAverageDaySalesOutstanding;
	public String getIndustryAverageDaySalesOutstanding() {return industryAverageDaySalesOutstanding;}
	public void setIndustryAverageDaySalesOutstanding(String value) {this.industryAverageDaySalesOutstanding =  value;}

	@XmlElement(name = "IndustryAveragePaymentExpectationDays")
	protected String industryAveragePaymentExpectationDays;
	public String getIndustryAveragePaymentExpectationDays() {return industryAveragePaymentExpectationDays;}
	public void setIndustryAveragePaymentExpectationDays(String value) {this.industryAveragePaymentExpectationDays =  value;}

}
