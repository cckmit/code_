package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdditionalInformation", propOrder = {
	"negativeInformation",
	"misc",
	"companyHistory",
	"companyCertificates",
	"industryComparison",
	"extendedGroupStructure",
	"statusHistory",
	"additionalFinancials",
	"professionalProfile",
	"keyPersonnels",
	"commercialVehicles",
	"commentaries",
	"transfers",
	"mergers",
	"localBranches",
	"workforceInformation",
	"auditors",
	"capitalFigures",
	"registeredRoles",
	"activities",
	"paymentExpectationsSummary",
	"industryQuartileAnalysis",
	"lettersOfLiablilityInformation403",
	"kvkFilings",
	"otherTradingNames",
	"realEstate",
	"registeredContractors",
	"jointIndustrialCommittee",
	"companySignificantEvents",
	"paymentData",
	"ratingHistory",
	"auditorComments",
	"announcements",
	"voluntaryPledge",
	"otherCompanyOfficials",
	"gazetteFillingOfAccounts",
	"gazetteRegisteredDeeds",
	"mainSuppliers",
	"importAndExport",
	"facilityDetails",
	"imageAccounts",
	"beneficialOwnerships",
	"turnoverRanges",
	"establishmentHistory",
	"mortgageInformation",
	"otherCorporateRecords",
	"dbt",
	"primaryCorporateRecord"
})

public class AdditionalInformation implements Serializable {

	@XmlElement(name = "NegativeInformation")
	protected NegativeInformation negativeInformation;
	public NegativeInformation getNegativeInformation() {return negativeInformation;}
	public void setNegativeInformation(NegativeInformation value) {this.negativeInformation =  value;}

	@XmlElement(name = "Misc")
	protected Misc misc;
	public Misc getMisc() {return misc;}
	public void setMisc(Misc value) {this.misc =  value;}

	@XmlElement(name = "CompanyHistory")
	protected CompanyHistory companyHistory;
	public CompanyHistory getCompanyHistory() {return companyHistory;}
	public void setCompanyHistory(CompanyHistory value) {this.companyHistory =  value;}

	@XmlElement(name = "CompanyCertificates")
	protected CompanyCertificates companyCertificates;
	public CompanyCertificates getCompanyCertificates() {return companyCertificates;}
	public void setCompanyCertificates(CompanyCertificates value) {this.companyCertificates =  value;}

	@XmlElement(name = "IndustryComparison")
	protected IndustryComparison industryComparison;
	public IndustryComparison getIndustryComparison() {return industryComparison;}
	public void setIndustryComparison(IndustryComparison value) {this.industryComparison =  value;}

	@XmlElement(name = "ExtendedGroupStructure")
	protected ExtendedGroupStructure extendedGroupStructure;
	public ExtendedGroupStructure getExtendedGroupStructure() {return extendedGroupStructure;}
	public void setExtendedGroupStructure(ExtendedGroupStructure value) {this.extendedGroupStructure =  value;}

	@XmlElement(name = "StatusHistory")
	protected StatusHistory statusHistory;
	public StatusHistory getStatusHistory() {return statusHistory;}
	public void setStatusHistory(StatusHistory value) {this.statusHistory =  value;}

	@XmlElement(name = "AdditionalFinancials")
	protected AdditionalFinancials additionalFinancials;
	public AdditionalFinancials getAdditionalFinancials() {return additionalFinancials;}
	public void setAdditionalFinancials(AdditionalFinancials value) {this.additionalFinancials =  value;}

	@XmlElement(name = "ProfessionalProfile")
	protected ProfessionalProfile professionalProfile;
	public ProfessionalProfile getProfessionalProfile() {return professionalProfile;}
	public void setProfessionalProfile(ProfessionalProfile value) {this.professionalProfile =  value;}

	@XmlElement(name = "KeyPersonnels")
	protected KeyPersonnels keyPersonnels;
	public KeyPersonnels getKeyPersonnels() {return keyPersonnels;}
	public void setKeyPersonnels(KeyPersonnels value) {this.keyPersonnels =  value;}

	@XmlElement(name = "CommercialVehicles")
	protected CommercialVehicles commercialVehicles;
	public CommercialVehicles getCommercialVehicles() {return commercialVehicles;}
	public void setCommercialVehicles(CommercialVehicles value) {this.commercialVehicles =  value;}

	@XmlElement(name = "Commentaries")
	protected Commentaries commentaries;
	public Commentaries getCommentaries() {return commentaries;}
	public void setCommentaries(Commentaries value) {this.commentaries =  value;}

	@XmlElement(name = "Transfers")
	protected Transfers transfers;
	public Transfers getTransfers() {return transfers;}
	public void setTransfers(Transfers value) {this.transfers =  value;}

	@XmlElement(name = "Mergers")
	protected Mergers mergers;
	public Mergers getMergers() {return mergers;}
	public void setMergers(Mergers value) {this.mergers =  value;}

	@XmlElement(name = "LocalBranches")
	protected LocalBranches localBranches;
	public LocalBranches getLocalBranches() {return localBranches;}
	public void setLocalBranches(LocalBranches value) {this.localBranches =  value;}

	@XmlElement(name = "WorkforceInformation")
	protected WorkforceInformation workforceInformation;
	public WorkforceInformation getWorkforceInformation() {return workforceInformation;}
	public void setWorkforceInformation(WorkforceInformation value) {this.workforceInformation =  value;}

	@XmlElement(name = "Auditors")
	protected Auditors auditors;
	public Auditors getAuditors() {return auditors;}
	public void setAuditors(Auditors value) {this.auditors =  value;}

	@XmlElement(name = "CapitalFigures")
	protected CapitalFigures capitalFigures;
	public CapitalFigures getCapitalFigures() {return capitalFigures;}
	public void setCapitalFigures(CapitalFigures value) {this.capitalFigures =  value;}

	@XmlElement(name = "RegisteredRoles")
	protected RegisteredRoles registeredRoles;
	public RegisteredRoles getRegisteredRoles() {return registeredRoles;}
	public void setRegisteredRoles(RegisteredRoles value) {this.registeredRoles =  value;}

	@XmlElement(name = "Activities")
	protected Activities activities;
	public Activities getActivities() {return activities;}
	public void setActivities(Activities value) {this.activities =  value;}

	@XmlElement(name = "PaymentExpectationsSummary")
	protected PaymentExpectationsSummary paymentExpectationsSummary;
	public PaymentExpectationsSummary getPaymentExpectationsSummary() {return paymentExpectationsSummary;}
	public void setPaymentExpectationsSummary(PaymentExpectationsSummary value) {this.paymentExpectationsSummary =  value;}

	@XmlElement(name = "IndustryQuartileAnalysis")
	protected IndustryQuartileAnalysis industryQuartileAnalysis;
	public IndustryQuartileAnalysis getIndustryQuartileAnalysis() {return industryQuartileAnalysis;}
	public void setIndustryQuartileAnalysis(IndustryQuartileAnalysis value) {this.industryQuartileAnalysis =  value;}

	@XmlElement(name = "LettersOfLiablilityInformation403")
	protected LettersOfLiablilityInformation403 lettersOfLiablilityInformation403;
	public LettersOfLiablilityInformation403 getLettersOfLiablilityInformation403() {return lettersOfLiablilityInformation403;}
	public void setLettersOfLiablilityInformation403(LettersOfLiablilityInformation403 value) {this.lettersOfLiablilityInformation403 =  value;}

	@XmlElement(name = "KVKFilings")
	protected KVKFilings kvkFilings;
	public KVKFilings getKvkFilings() {return kvkFilings;}
	public void setKvkFilings(KVKFilings value) {this.kvkFilings =  value;}

	@XmlElement(name = "OtherTradingNames")
	protected OtherTradingNames otherTradingNames;
	public OtherTradingNames getOtherTradingNames() {return otherTradingNames;}
	public void setOtherTradingNames(OtherTradingNames value) {this.otherTradingNames =  value;}

	@XmlElement(name = "RealEstate")
	protected RealEstate realEstate;
	public RealEstate getRealEstate() {return realEstate;}
	public void setRealEstate(RealEstate value) {this.realEstate =  value;}

	@XmlElement(name = "RegisteredContractors")
	protected RegisteredContractors registeredContractors;
	public RegisteredContractors getRegisteredContractors() {return registeredContractors;}
	public void setRegisteredContractors(RegisteredContractors value) {this.registeredContractors =  value;}

	@XmlElement(name = "JointIndustrialCommittee")
	protected JointIndustrialCommittee jointIndustrialCommittee;
	public JointIndustrialCommittee getJointIndustrialCommittee() {return jointIndustrialCommittee;}
	public void setJointIndustrialCommittee(JointIndustrialCommittee value) {this.jointIndustrialCommittee =  value;}

	@XmlElement(name = "CompanySignificantEvents")
	protected CompanySignificantEvents companySignificantEvents;
	public CompanySignificantEvents getCompanySignificantEvents() {return companySignificantEvents;}
	public void setCompanySignificantEvents(CompanySignificantEvents value) {this.companySignificantEvents =  value;}

	@XmlElement(name = "PaymentData")
	protected PaymentData paymentData;
	public PaymentData getPaymentData() {return paymentData;}
	public void setPaymentData(PaymentData value) {this.paymentData =  value;}

	@XmlElement(name = "RatingHistory")
	protected RatingHistory ratingHistory;
	public RatingHistory getRatingHistory() {return ratingHistory;}
	public void setRatingHistory(RatingHistory value) {this.ratingHistory =  value;}

	@XmlElement(name = "AuditorComments")
	protected AuditorComments auditorComments;
	public AuditorComments getAuditorComments() {return auditorComments;}
	public void setAuditorComments(AuditorComments value) {this.auditorComments =  value;}

	@XmlElement(name = "Announcements")
	protected Announcements announcements;
	public Announcements getAnnouncements() {return announcements;}
	public void setAnnouncements(Announcements value) {this.announcements =  value;}

	@XmlElement(name = "VoluntaryPledge")
	protected VoluntaryPledge voluntaryPledge;
	public VoluntaryPledge getVoluntaryPledge() {return voluntaryPledge;}
	public void setVoluntaryPledge(VoluntaryPledge value) {this.voluntaryPledge =  value;}

	@XmlElement(name = "OtherCompanyOfficials")
	protected OtherCompanyOfficials otherCompanyOfficials;
	public OtherCompanyOfficials getOtherCompanyOfficials() {return otherCompanyOfficials;}
	public void setOtherCompanyOfficials(OtherCompanyOfficials value) {this.otherCompanyOfficials =  value;}

	@XmlElement(name = "GazetteFillingOfAccounts")
	protected GazetteFillingOfAccounts gazetteFillingOfAccounts;
	public GazetteFillingOfAccounts getGazetteFillingOfAccounts() {return gazetteFillingOfAccounts;}
	public void setGazetteFillingOfAccounts(GazetteFillingOfAccounts value) {this.gazetteFillingOfAccounts =  value;}

	@XmlElement(name = "GazetteRegisteredDeeds")
	protected GazetteRegisteredDeeds gazetteRegisteredDeeds;
	public GazetteRegisteredDeeds getGazetteRegisteredDeeds() {return gazetteRegisteredDeeds;}
	public void setGazetteRegisteredDeeds(GazetteRegisteredDeeds value) {this.gazetteRegisteredDeeds =  value;}

	@XmlElement(name = "MainSuppliers")
	protected MainSuppliers mainSuppliers;
	public MainSuppliers getMainSuppliers() {return mainSuppliers;}
	public void setMainSuppliers(MainSuppliers value) {this.mainSuppliers =  value;}

	@XmlElement(name = "ImportAndExport")
	protected ImportAndExport importAndExport;
	public ImportAndExport getImportAndExport() {return importAndExport;}
	public void setImportAndExport(ImportAndExport value) {this.importAndExport =  value;}

	@XmlElement(name = "FacilityDetails")
	protected FacilityDetails facilityDetails;
	public FacilityDetails getFacilityDetails() {return facilityDetails;}
	public void setFacilityDetails(FacilityDetails value) {this.facilityDetails =  value;}

	@XmlElement(name = "ImageAccounts")
	protected ImageAccounts imageAccounts;
	public ImageAccounts getImageAccounts() {return imageAccounts;}
	public void setImageAccounts(ImageAccounts value) {this.imageAccounts =  value;}

	@XmlElement(name = "BeneficialOwnerships")
	protected BeneficialOwnerships beneficialOwnerships;
	public BeneficialOwnerships getBeneficialOwnerships() {return beneficialOwnerships;}
	public void setBeneficialOwnerships(BeneficialOwnerships value) {this.beneficialOwnerships =  value;}

	@XmlElement(name = "TurnoverRanges")
	protected TurnoverRanges turnoverRanges;
	public TurnoverRanges getTurnoverRanges() {return turnoverRanges;}
	public void setTurnoverRanges(TurnoverRanges value) {this.turnoverRanges =  value;}

	@XmlElement(name = "EstablishmentHistory")
	protected EstablishmentHistory establishmentHistory;
	public EstablishmentHistory getEstablishmentHistory() {return establishmentHistory;}
	public void setEstablishmentHistory(EstablishmentHistory value) {this.establishmentHistory =  value;}

	@XmlElement(name = "MortgageInformation")
	protected MortgageInformation mortgageInformation;
	public MortgageInformation getMortgageInformation() {return mortgageInformation;}
	public void setMortgageInformation(MortgageInformation value) {this.mortgageInformation =  value;}

	@XmlElement(name = "OtherCorporateRecords")
	protected OtherCorporateRecords otherCorporateRecords;
	public OtherCorporateRecords getOtherCorporateRecords() {return otherCorporateRecords;}
	public void setOtherCorporateRecords(OtherCorporateRecords value) {this.otherCorporateRecords =  value;}

	@XmlElement(name = "DBT")
	protected DBT dbt;
	public DBT getDbt() {return dbt;}
	public void setDbt(DBT value) {this.dbt =  value;}

	@XmlElement(name = "PrimaryCorporateRecord")
	protected PrimaryCorporateRecord primaryCorporateRecord;
	public PrimaryCorporateRecord getPrimaryCorporateRecord() {return primaryCorporateRecord;}
	public void setPrimaryCorporateRecord(PrimaryCorporateRecord value) {this.primaryCorporateRecord =  value;}

}
