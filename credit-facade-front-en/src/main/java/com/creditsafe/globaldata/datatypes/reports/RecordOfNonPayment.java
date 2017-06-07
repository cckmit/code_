package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecordOfNonPayment", propOrder = {
	"numberOfDistraintOrRepossessions",
	"numberOfPublicClaims",
	"numberOfPrivateClaims",
	"numberOfApplications",
	"numberOfRevokedApplications"
})

public class RecordOfNonPayment implements Serializable {

	@XmlElement(name = "NumberOfDistraintOrRepossessions")
	protected String numberOfDistraintOrRepossessions;
	public String getNumberOfDistraintOrRepossessions() {return numberOfDistraintOrRepossessions;}
	public void setNumberOfDistraintOrRepossessions(String value) {this.numberOfDistraintOrRepossessions =  value;}

	@XmlElement(name = "NumberOfPublicClaims")
	protected String numberOfPublicClaims;
	public String getNumberOfPublicClaims() {return numberOfPublicClaims;}
	public void setNumberOfPublicClaims(String value) {this.numberOfPublicClaims =  value;}

	@XmlElement(name = "NumberOfPrivateClaims")
	protected String numberOfPrivateClaims;
	public String getNumberOfPrivateClaims() {return numberOfPrivateClaims;}
	public void setNumberOfPrivateClaims(String value) {this.numberOfPrivateClaims =  value;}

	@XmlElement(name = "NumberOfApplications")
	protected String numberOfApplications;
	public String getNumberOfApplications() {return numberOfApplications;}
	public void setNumberOfApplications(String value) {this.numberOfApplications =  value;}

	@XmlElement(name = "NumberOfRevokedApplications")
	protected String numberOfRevokedApplications;
	public String getNumberOfRevokedApplications() {return numberOfRevokedApplications;}
	public void setNumberOfRevokedApplications(String value) {this.numberOfRevokedApplications =  value;}

}
