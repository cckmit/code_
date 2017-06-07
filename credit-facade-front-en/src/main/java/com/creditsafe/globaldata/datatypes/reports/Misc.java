package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Misc", propOrder = {
	"registeredForFTax",
	"registeredForVat",
	"registeredForEmployeeTax",
	"revenueRange",
	"faxNumber",
	"contactPerson",
	"taxCode",
	"companyTypeCode",
	"chamberOfCommerce",
	"registerStatus",
	"businessStatus",
	"incorporationDate",
	"closureDate",
	"otherInformation",
	"socialDescription",
	"companyPowers",
	"powerCategory",
	"negativeRating",
	"dateofLegalForm",
	"ceasedTradingDate",
	"exporter",
	"importer",
	"rsinNumber",
	"liableForVat",
	"numberOfEmployees",
	"signatures",
	"sektorKode",
	"companySize",
	"tradeName",
	"statusConfirmed",
	"turnoverRange",
	"city",
	"commercialRegisterCity",
	"commercialRegisterZip",
	"financialsQuality",
	"deCurrentRating",
	"dePreviousRating",
	"premiseType",
	"soho",
	"companyType",
	"complementaryCompany",
	"businessPurpose",
	"sizeOfUrbanArea",
	"reasonForFormation",
	"reasonForClosure",
	"reactivationDate",
	"financialAccountsType",
	"statusCode",
	"officeType",
	"numberOfBranches",
	"acronym",
	"numberOfEmployeesAtAddress",
	"previousSiret",
	"numberOfEmployeesAtCompany",
	"firstReportedDate",
	"primaryNAICSCode",
	"primaryNAICSCodeDescription",
	"yearsInBusiness",
	"addressType",
	"locationType",
	"salesRange"
})

public class Misc implements Serializable {

	@XmlElement(name = "RegisteredForFTax")
	protected String registeredForFTax;
	public String getRegisteredForFTax() {return registeredForFTax;}
	public void setRegisteredForFTax(String value) {this.registeredForFTax =  value;}

	@XmlElement(name = "RegisteredForVat")
	protected String registeredForVat;
	public String getRegisteredForVat() {return registeredForVat;}
	public void setRegisteredForVat(String value) {this.registeredForVat =  value;}

	@XmlElement(name = "RegisteredForEmployeeTax")
	protected String registeredForEmployeeTax;
	public String getRegisteredForEmployeeTax() {return registeredForEmployeeTax;}
	public void setRegisteredForEmployeeTax(String value) {this.registeredForEmployeeTax =  value;}

	@XmlElement(name = "RevenueRange")
	protected String revenueRange;
	public String getRevenueRange() {return revenueRange;}
	public void setRevenueRange(String value) {this.revenueRange =  value;}

	@XmlElement(name = "FaxNumber")
	protected String faxNumber;
	public String getFaxNumber() {return faxNumber;}
	public void setFaxNumber(String value) {this.faxNumber =  value;}

	@XmlElement(name = "ContactPerson")
	protected String contactPerson;
	public String getContactPerson() {return contactPerson;}
	public void setContactPerson(String value) {this.contactPerson =  value;}

	@XmlElement(name = "TaxCode")
	protected String taxCode;
	public String getTaxCode() {return taxCode;}
	public void setTaxCode(String value) {this.taxCode =  value;}

	@XmlElement(name = "CompanyTypeCode")
	protected String companyTypeCode;
	public String getCompanyTypeCode() {return companyTypeCode;}
	public void setCompanyTypeCode(String value) {this.companyTypeCode =  value;}

	@XmlElement(name = "ChamberOfCommerce")
	protected String chamberOfCommerce;
	public String getChamberOfCommerce() {return chamberOfCommerce;}
	public void setChamberOfCommerce(String value) {this.chamberOfCommerce =  value;}

	@XmlElement(name = "RegisterStatus")
	protected String registerStatus;
	public String getRegisterStatus() {return registerStatus;}
	public void setRegisterStatus(String value) {this.registerStatus =  value;}

	@XmlElement(name = "BusinessStatus")
	protected String businessStatus;
	public String getBusinessStatus() {return businessStatus;}
	public void setBusinessStatus(String value) {this.businessStatus =  value;}

	@XmlElement(name = "IncorporationDate")
	protected String incorporationDate;
	public String getIncorporationDate() {return incorporationDate;}
	public void setIncorporationDate(String value) {this.incorporationDate =  value;}

	@XmlElement(name = "ClosureDate")
	protected String closureDate;
	public String getClosureDate() {return closureDate;}
	public void setClosureDate(String value) {this.closureDate =  value;}

	@XmlElement(name = "OtherInformation")
	protected String otherInformation;
	public String getOtherInformation() {return otherInformation;}
	public void setOtherInformation(String value) {this.otherInformation =  value;}

	@XmlElement(name = "SocialDescription")
	protected String socialDescription;
	public String getSocialDescription() {return socialDescription;}
	public void setSocialDescription(String value) {this.socialDescription =  value;}

	@XmlElement(name = "CompanyPowers")
	protected String companyPowers;
	public String getCompanyPowers() {return companyPowers;}
	public void setCompanyPowers(String value) {this.companyPowers =  value;}

	@XmlElement(name = "PowerCategory")
	protected String powerCategory;
	public String getPowerCategory() {return powerCategory;}
	public void setPowerCategory(String value) {this.powerCategory =  value;}

	@XmlElement(name = "NegativeRating")
	protected String negativeRating;
	public String getNegativeRating() {return negativeRating;}
	public void setNegativeRating(String value) {this.negativeRating =  value;}

	@XmlElement(name = "DateofLegalForm")
	protected String dateofLegalForm;
	public String getDateofLegalForm() {return dateofLegalForm;}
	public void setDateofLegalForm(String value) {this.dateofLegalForm =  value;}

	@XmlElement(name = "CeasedTradingDate")
	protected String ceasedTradingDate;
	public String getCeasedTradingDate() {return ceasedTradingDate;}
	public void setCeasedTradingDate(String value) {this.ceasedTradingDate =  value;}

	@XmlElement(name = "Exporter")
	protected String exporter;
	public String getExporter() {return exporter;}
	public void setExporter(String value) {this.exporter =  value;}

	@XmlElement(name = "Importer")
	protected String importer;
	public String getImporter() {return importer;}
	public void setImporter(String value) {this.importer =  value;}

	@XmlElement(name = "RSINNumber")
	protected String rsinNumber;
	public String getRsinNumber() {return rsinNumber;}
	public void setRsinNumber(String value) {this.rsinNumber =  value;}

	@XmlElement(name = "LiableForVat")
	protected String liableForVat;
	public String getLiableForVat() {return liableForVat;}
	public void setLiableForVat(String value) {this.liableForVat =  value;}

	@XmlElement(name = "NumberOfEmployees")
	protected String numberOfEmployees;
	public String getNumberOfEmployees() {return numberOfEmployees;}
	public void setNumberOfEmployees(String value) {this.numberOfEmployees =  value;}

	@XmlElement(name = "Signatures")
	protected String signatures;
	public String getSignatures() {return signatures;}
	public void setSignatures(String value) {this.signatures =  value;}

	@XmlElement(name = "SektorKode")
	protected String sektorKode;
	public String getSektorKode() {return sektorKode;}
	public void setSektorKode(String value) {this.sektorKode =  value;}

	@XmlElement(name = "CompanySize")
	protected String companySize;
	public String getCompanySize() {return companySize;}
	public void setCompanySize(String value) {this.companySize =  value;}

	@XmlElement(name = "TradeName")
	protected String tradeName;
	public String getTradeName() {return tradeName;}
	public void setTradeName(String value) {this.tradeName =  value;}

	@XmlElement(name = "StatusConfirmed")
	protected String statusConfirmed;
	public String getStatusConfirmed() {return statusConfirmed;}
	public void setStatusConfirmed(String value) {this.statusConfirmed =  value;}

	@XmlElement(name = "TurnoverRange")
	protected String turnoverRange;
	public String getTurnoverRange() {return turnoverRange;}
	public void setTurnoverRange(String value) {this.turnoverRange =  value;}

	@XmlElement(name = "City")
	protected String city;
	public String getCity() {return city;}
	public void setCity(String value) {this.city =  value;}

	@XmlElement(name = "CommercialRegisterCity")
	protected String commercialRegisterCity;
	public String getCommercialRegisterCity() {return commercialRegisterCity;}
	public void setCommercialRegisterCity(String value) {this.commercialRegisterCity =  value;}

	@XmlElement(name = "CommercialRegisterZip")
	protected String commercialRegisterZip;
	public String getCommercialRegisterZip() {return commercialRegisterZip;}
	public void setCommercialRegisterZip(String value) {this.commercialRegisterZip =  value;}

	@XmlElement(name = "FinancialsQuality")
	protected String financialsQuality;
	public String getFinancialsQuality() {return financialsQuality;}
	public void setFinancialsQuality(String value) {this.financialsQuality =  value;}

	@XmlElement(name = "DECurrentRating")
	protected String deCurrentRating;
	public String getDeCurrentRating() {return deCurrentRating;}
	public void setDeCurrentRating(String value) {this.deCurrentRating =  value;}

	@XmlElement(name = "DEPreviousRating")
	protected String dePreviousRating;
	public String getDePreviousRating() {return dePreviousRating;}
	public void setDePreviousRating(String value) {this.dePreviousRating =  value;}

	@XmlElement(name = "PremiseType")
	protected String premiseType;
	public String getPremiseType() {return premiseType;}
	public void setPremiseType(String value) {this.premiseType =  value;}

	@XmlElement(name = "SOHO")
	protected String soho;
	public String getSoho() {return soho;}
	public void setSoho(String value) {this.soho =  value;}

	@XmlElement(name = "CompanyType")
	protected String companyType;
	public String getCompanyType() {return companyType;}
	public void setCompanyType(String value) {this.companyType =  value;}

	@XmlElement(name = "ComplementaryCompany")
	protected String complementaryCompany;
	public String getComplementaryCompany() {return complementaryCompany;}
	public void setComplementaryCompany(String value) {this.complementaryCompany =  value;}

	@XmlElement(name = "BusinessPurpose")
	protected String businessPurpose;
	public String getBusinessPurpose() {return businessPurpose;}
	public void setBusinessPurpose(String value) {this.businessPurpose =  value;}

	@XmlElement(name = "SizeOfUrbanArea")
	protected String sizeOfUrbanArea;
	public String getSizeOfUrbanArea() {return sizeOfUrbanArea;}
	public void setSizeOfUrbanArea(String value) {this.sizeOfUrbanArea =  value;}

	@XmlElement(name = "ReasonForFormation")
	protected String reasonForFormation;
	public String getReasonForFormation() {return reasonForFormation;}
	public void setReasonForFormation(String value) {this.reasonForFormation =  value;}

	@XmlElement(name = "ReasonForClosure")
	protected String reasonForClosure;
	public String getReasonForClosure() {return reasonForClosure;}
	public void setReasonForClosure(String value) {this.reasonForClosure =  value;}

	@XmlElement(name = "ReactivationDate")
	protected String reactivationDate;
	public String getReactivationDate() {return reactivationDate;}
	public void setReactivationDate(String value) {this.reactivationDate =  value;}

	@XmlElement(name = "FinancialAccountsType")
	protected String financialAccountsType;
	public String getFinancialAccountsType() {return financialAccountsType;}
	public void setFinancialAccountsType(String value) {this.financialAccountsType =  value;}

	@XmlElement(name = "StatusCode")
	protected String statusCode;
	public String getStatusCode() {return statusCode;}
	public void setStatusCode(String value) {this.statusCode =  value;}

	@XmlElement(name = "OfficeType")
	protected String officeType;
	public String getOfficeType() {return officeType;}
	public void setOfficeType(String value) {this.officeType =  value;}

	@XmlElement(name = "NumberOfBranches")
	protected String numberOfBranches;
	public String getNumberOfBranches() {return numberOfBranches;}
	public void setNumberOfBranches(String value) {this.numberOfBranches =  value;}

	@XmlElement(name = "Acronym")
	protected String acronym;
	public String getAcronym() {return acronym;}
	public void setAcronym(String value) {this.acronym =  value;}

	@XmlElement(name = "NumberOfEmployeesAtAddress")
	protected String numberOfEmployeesAtAddress;
	public String getNumberOfEmployeesAtAddress() {return numberOfEmployeesAtAddress;}
	public void setNumberOfEmployeesAtAddress(String value) {this.numberOfEmployeesAtAddress =  value;}

	@XmlElement(name = "PreviousSiret")
	protected String previousSiret;
	public String getPreviousSiret() {return previousSiret;}
	public void setPreviousSiret(String value) {this.previousSiret =  value;}

	@XmlElement(name = "NumberOfEmployeesAtCompany")
	protected String numberOfEmployeesAtCompany;
	public String getNumberOfEmployeesAtCompany() {return numberOfEmployeesAtCompany;}
	public void setNumberOfEmployeesAtCompany(String value) {this.numberOfEmployeesAtCompany =  value;}

	@XmlElement(name = "FirstReportedDate")
	protected String firstReportedDate;
	public String getFirstReportedDate() {return firstReportedDate;}
	public void setFirstReportedDate(String value) {this.firstReportedDate =  value;}

	@XmlElement(name = "PrimaryNAICSCode")
	protected String primaryNAICSCode;
	public String getPrimaryNAICSCode() {return primaryNAICSCode;}
	public void setPrimaryNAICSCode(String value) {this.primaryNAICSCode =  value;}

	@XmlElement(name = "PrimaryNAICSCodeDescription")
	protected String primaryNAICSCodeDescription;
	public String getPrimaryNAICSCodeDescription() {return primaryNAICSCodeDescription;}
	public void setPrimaryNAICSCodeDescription(String value) {this.primaryNAICSCodeDescription =  value;}

	@XmlElement(name = "YearsInBusiness")
	protected String yearsInBusiness;
	public String getYearsInBusiness() {return yearsInBusiness;}
	public void setYearsInBusiness(String value) {this.yearsInBusiness =  value;}

	@XmlElement(name = "AddressType")
	protected String addressType;
	public String getAddressType() {return addressType;}
	public void setAddressType(String value) {this.addressType =  value;}

	@XmlElement(name = "LocationType")
	protected String locationType;
	public String getLocationType() {return locationType;}
	public void setLocationType(String value) {this.locationType =  value;}

	@XmlElement(name = "SalesRange")
	protected String salesRange;
	public String getSalesRange() {return salesRange;}
	public void setSalesRange(String value) {this.salesRange =  value;}

}
