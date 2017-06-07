package com.creditsafe.globaldata.datatypes.reports;

import com.mika.credit.common.util.StringUtil;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Event", propOrder = {
	"date",
	"description",
	"applicant",
	"bankruptcyTrustee",
	"companyName",
	"simpleValue",
	"street",
	"city",
	"postalCode",
	"courtName",
	"additionalText",
	"publishedDate",
	"courtDetails",
	"courtLocalName",
	"adverseParty",
	"defendantName",
	"nature",
	"defendantRFC",
	"location",
	"status",
	"insolventParty",
	"creditor",
	"registar",
	"docket",
	"referee",
	"caption",
	"subject",
	"plaintiff",
	"defendant",
	"registrationDate",
	"legalEventType",
	"rcssNumber",
	"judgementData",
	"judgementNumber",
	"failureDescription",
	"address",
	"insertDate",
	"htmlUrl",
	"pdfUrl",
	"memoriaL_ID",
	"previousValue",
	"currentValue",
	"typeofInfo",
	"source",
	"text",
	"rating",
	"type",
	"statusDate",
	"statusDescription",
	"referenceNumberoftheCourt",
	"recordCreatedOn",
	"insolvencyRepresentatives",
	"dateofInsolvency",
	"trusteeData",
	"entityName",
	"localRating",
	"description1",
	"description2",
	"commonRating"
})

public class Event implements Serializable {

	@XmlElement(name = "Date")
	protected String date;
	public String getDate() {return date;}
	public void setDate(String value) {
		if (StringUtil.isNotNull(value)){
			this.date =  value.substring(0,10);
		}else{
			this.date =  value;
		}
	}

	@XmlElement(name = "Description")
	protected String description;
	public String getDescription() {return description;}
	public void setDescription(String value) {this.description =  value;}

	@XmlElement(name = "Applicant")
	protected String applicant;
	public String getApplicant() {return applicant;}
	public void setApplicant(String value) {this.applicant =  value;}

	@XmlElement(name = "BankruptcyTrustee")
	protected String bankruptcyTrustee;
	public String getBankruptcyTrustee() {return bankruptcyTrustee;}
	public void setBankruptcyTrustee(String value) {this.bankruptcyTrustee =  value;}

	@XmlElement(name = "CompanyName")
	protected String companyName;
	public String getCompanyName() {return companyName;}
	public void setCompanyName(String value) {this.companyName =  value;}

	@XmlElement(name = "SimpleValue")
	protected String simpleValue;
	public String getSimpleValue() {return simpleValue;}
	public void setSimpleValue(String value) {this.simpleValue =  value;}

	@XmlElement(name = "Street")
	protected String street;
	public String getStreet() {return street;}
	public void setStreet(String value) {this.street =  value;}

	@XmlElement(name = "City")
	protected String city;
	public String getCity() {return city;}
	public void setCity(String value) {this.city =  value;}

	@XmlElement(name = "PostalCode")
	protected String postalCode;
	public String getPostalCode() {return postalCode;}
	public void setPostalCode(String value) {this.postalCode =  value;}

	@XmlElement(name = "CourtName")
	protected String courtName;
	public String getCourtName() {return courtName;}
	public void setCourtName(String value) {this.courtName =  value;}

	@XmlElement(name = "AdditionalText")
	protected String additionalText;
	public String getAdditionalText() {return additionalText;}
	public void setAdditionalText(String value) {this.additionalText =  value;}

	@XmlElement(name = "PublishedDate")
	protected String publishedDate;
	public String getPublishedDate() {return publishedDate;}
	public void setPublishedDate(String value) {this.publishedDate =  value;}

	@XmlElement(name = "CourtDetails")
	protected String courtDetails;
	public String getCourtDetails() {return courtDetails;}
	public void setCourtDetails(String value) {this.courtDetails =  value;}

	@XmlElement(name = "CourtLocalName")
	protected String courtLocalName;
	public String getCourtLocalName() {return courtLocalName;}
	public void setCourtLocalName(String value) {this.courtLocalName =  value;}

	@XmlElement(name = "AdverseParty")
	protected String adverseParty;
	public String getAdverseParty() {return adverseParty;}
	public void setAdverseParty(String value) {this.adverseParty =  value;}

	@XmlElement(name = "DefendantName")
	protected String defendantName;
	public String getDefendantName() {return defendantName;}
	public void setDefendantName(String value) {this.defendantName =  value;}

	@XmlElement(name = "Nature")
	protected String nature;
	public String getNature() {return nature;}
	public void setNature(String value) {this.nature =  value;}

	@XmlElement(name = "DefendantRFC")
	protected String defendantRFC;
	public String getDefendantRFC() {return defendantRFC;}
	public void setDefendantRFC(String value) {this.defendantRFC =  value;}

	@XmlElement(name = "Location")
	protected String location;
	public String getLocation() {return location;}
	public void setLocation(String value) {this.location =  value;}

	@XmlElement(name = "Status")
	protected String status;
	public String getStatus() {return status;}
	public void setStatus(String value) {this.status =  value;}

	@XmlElement(name = "InsolventParty")
	protected String insolventParty;
	public String getInsolventParty() {return insolventParty;}
	public void setInsolventParty(String value) {this.insolventParty =  value;}

	@XmlElement(name = "Creditor")
	protected String creditor;
	public String getCreditor() {return creditor;}
	public void setCreditor(String value) {this.creditor =  value;}

	@XmlElement(name = "Registar")
	protected String registar;
	public String getRegistar() {return registar;}
	public void setRegistar(String value) {this.registar =  value;}

	@XmlElement(name = "Docket")
	protected String docket;
	public String getDocket() {return docket;}
	public void setDocket(String value) {this.docket =  value;}

	@XmlElement(name = "Referee")
	protected String referee;
	public String getReferee() {return referee;}
	public void setReferee(String value) {this.referee =  value;}

	@XmlElement(name = "Caption")
	protected String caption;
	public String getCaption() {return caption;}
	public void setCaption(String value) {this.caption =  value;}

	@XmlElement(name = "Subject")
	protected String subject;
	public String getSubject() {return subject;}
	public void setSubject(String value) {this.subject =  value;}

	@XmlElement(name = "Plaintiff")
	protected String plaintiff;
	public String getPlaintiff() {return plaintiff;}
	public void setPlaintiff(String value) {this.plaintiff =  value;}

	@XmlElement(name = "Defendant")
	protected String defendant;
	public String getDefendant() {return defendant;}
	public void setDefendant(String value) {this.defendant =  value;}

	@XmlElement(name = "RegistrationDate")
	protected String registrationDate;
	public String getRegistrationDate() {return registrationDate;}
	public void setRegistrationDate(String value) {this.registrationDate =  value;}

	@XmlElement(name = "LegalEventType")
	protected String legalEventType;
	public String getLegalEventType() {return legalEventType;}
	public void setLegalEventType(String value) {this.legalEventType =  value;}

	@XmlElement(name = "RCSSNumber")
	protected String rcssNumber;
	public String getRcssNumber() {return rcssNumber;}
	public void setRcssNumber(String value) {this.rcssNumber =  value;}

	@XmlElement(name = "JudgementData")
	protected String judgementData;
	public String getJudgementData() {return judgementData;}
	public void setJudgementData(String value) {this.judgementData =  value;}

	@XmlElement(name = "JudgementNumber")
	protected String judgementNumber;
	public String getJudgementNumber() {return judgementNumber;}
	public void setJudgementNumber(String value) {this.judgementNumber =  value;}

	@XmlElement(name = "FailureDescription")
	protected String failureDescription;
	public String getFailureDescription() {return failureDescription;}
	public void setFailureDescription(String value) {this.failureDescription =  value;}

	@XmlElement(name = "Address")
	protected String address;
	public String getAddress() {return address;}
	public void setAddress(String value) {this.address =  value;}

	@XmlElement(name = "InsertDate")
	protected String insertDate;
	public String getInsertDate() {return insertDate;}
	public void setInsertDate(String value) {this.insertDate =  value;}

	@XmlElement(name = "HTMLUrl")
	protected String htmlUrl;
	public String getHtmlUrl() {return htmlUrl;}
	public void setHtmlUrl(String value) {this.htmlUrl =  value;}

	@XmlElement(name = "PDFUrl")
	protected String pdfUrl;
	public String getPdfUrl() {return pdfUrl;}
	public void setPdfUrl(String value) {this.pdfUrl =  value;}

	@XmlElement(name = "MEMORIAL_ID")
	protected String memoriaL_ID;
	public String getMemoriaL_ID() {return memoriaL_ID;}
	public void setMemoriaL_ID(String value) {this.memoriaL_ID =  value;}

	@XmlElement(name = "PreviousValue")
	protected String previousValue;
	public String getPreviousValue() {return previousValue;}
	public void setPreviousValue(String value) {this.previousValue =  value;}

	@XmlElement(name = "CurrentValue")
	protected String currentValue;
	public String getCurrentValue() {return currentValue;}
	public void setCurrentValue(String value) {this.currentValue =  value;}

	@XmlElement(name = "TypeofInfo")
	protected String typeofInfo;
	public String getTypeofInfo() {return typeofInfo;}
	public void setTypeofInfo(String value) {this.typeofInfo =  value;}

	@XmlElement(name = "Source")
	protected String source;
	public String getSource() {return source;}
	public void setSource(String value) {this.source =  value;}

	@XmlElement(name = "Text")
	protected String text;
	public String getText() {return text;}
	public void setText(String value) {this.text =  value;}

	@XmlElement(name = "Rating")
	protected String rating;
	public String getRating() {return rating;}
	public void setRating(String value) {this.rating =  value;}

	@XmlElement(name = "Type")
	protected String type;
	public String getType() {return type;}
	public void setType(String value) {this.type =  value;}

	@XmlElement(name = "StatusDate")
	protected String statusDate;
	public String getStatusDate() {return statusDate;}
	public void setStatusDate(String value) {this.statusDate =  value;}

	@XmlElement(name = "StatusDescription")
	protected String statusDescription;
	public String getStatusDescription() {return statusDescription;}
	public void setStatusDescription(String value) {this.statusDescription =  value;}

	@XmlElement(name = "ReferenceNumberoftheCourt")
	protected String referenceNumberoftheCourt;
	public String getReferenceNumberoftheCourt() {return referenceNumberoftheCourt;}
	public void setReferenceNumberoftheCourt(String value) {this.referenceNumberoftheCourt =  value;}

	@XmlElement(name = "RecordCreatedOn")
	protected String recordCreatedOn;
	public String getRecordCreatedOn() {return recordCreatedOn;}
	public void setRecordCreatedOn(String value) {this.recordCreatedOn =  value;}

	@XmlElement(name = "InsolvencyRepresentatives")
	protected InsolvencyRepresentatives insolvencyRepresentatives;
	public InsolvencyRepresentatives getInsolvencyRepresentatives() {return insolvencyRepresentatives;}
	public void setInsolvencyRepresentatives(InsolvencyRepresentatives value) {this.insolvencyRepresentatives =  value;}

	@XmlElement(name = "DateofInsolvency")
	protected String dateofInsolvency;
	public String getDateofInsolvency() {return dateofInsolvency;}
	public void setDateofInsolvency(String value) {this.dateofInsolvency =  value;}

	@XmlElement(name = "TrusteeData")
	protected TrusteeData trusteeData;
	public TrusteeData getTrusteeData() {return trusteeData;}
	public void setTrusteeData(TrusteeData value) {this.trusteeData =  value;}

	@XmlElement(name = "EntityName")
	protected String entityName;
	public String getEntityName() {return entityName;}
	public void setEntityName(String value) {this.entityName =  value;}

	@XmlElement(name = "LocalRating")
	protected String localRating;
	public String getLocalRating() {return localRating;}
	public void setLocalRating(String value) {this.localRating =  value;}

	@XmlElement(name = "Description1")
	protected String description1;
	public String getDescription1() {return description1;}
	public void setDescription1(String value) {this.description1 =  value;}

	@XmlElement(name = "Description2")
	protected String description2;
	public String getDescription2() {return description2;}
	public void setDescription2(String value) {this.description2 =  value;}

	@XmlElement(name = "CommonRating")
	protected CommonRating commonRating;
	public CommonRating getCommonRating() {return commonRating;}
	public void setCommonRating(CommonRating value) {this.commonRating =  value;}

}
