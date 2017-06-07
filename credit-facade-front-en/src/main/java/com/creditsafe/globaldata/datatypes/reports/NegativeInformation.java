package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NegativeInformation", propOrder = {
	"debtBalance",
	"recordOfNonPayment",
	"latestPublicClaim",
	"latestPrivateClaim",
	"overduePaymentsSummary",
	"litigationDetailsDefendant",
	"litigationDetailsPlaintiff",
	"countyCourtJudgements",
	"insolvencyEvents",
	"concursosEvents",
	"federalLitigation",
	"stateLitigation",
	"protestedBills",
	"insolvencyInformation",
	"companyFailures",
	"courtData",
	"negativeInformationSummary",
	"officialRemarks",
	"nssoDetails",
	"companyLegalEvents",
	"paymentRemarks",
	"incidents",
	"bankruptcy",
	"directorEvents",
	"judgements",
	"preferentialRights",
	"bankruptcyData",
	"legalFilingSummary",
	"uccDetails",
	"bankruptcyDetails",
	"taxLienDetails",
	"judgmentDetails"
})

public class NegativeInformation implements Serializable {

	@XmlElement(name = "DebtBalance")
	protected DebtBalance debtBalance;
	public DebtBalance getDebtBalance() {return debtBalance;}
	public void setDebtBalance(DebtBalance value) {this.debtBalance =  value;}

	@XmlElement(name = "RecordOfNonPayment")
	protected RecordOfNonPayment recordOfNonPayment;
	public RecordOfNonPayment getRecordOfNonPayment() {return recordOfNonPayment;}
	public void setRecordOfNonPayment(RecordOfNonPayment value) {this.recordOfNonPayment =  value;}

	@XmlElement(name = "LatestPublicClaim")
	protected LatestPublicClaim latestPublicClaim;
	public LatestPublicClaim getLatestPublicClaim() {return latestPublicClaim;}
	public void setLatestPublicClaim(LatestPublicClaim value) {this.latestPublicClaim =  value;}

	@XmlElement(name = "LatestPrivateClaim")
	protected LatestPrivateClaim latestPrivateClaim;
	public LatestPrivateClaim getLatestPrivateClaim() {return latestPrivateClaim;}
	public void setLatestPrivateClaim(LatestPrivateClaim value) {this.latestPrivateClaim =  value;}

	@XmlElement(name = "OverduePaymentsSummary")
	protected OverduePaymentsSummary overduePaymentsSummary;
	public OverduePaymentsSummary getOverduePaymentsSummary() {return overduePaymentsSummary;}
	public void setOverduePaymentsSummary(OverduePaymentsSummary value) {this.overduePaymentsSummary =  value;}

	@XmlElement(name = "LitigationDetailsDefendant")
	protected LitigationDetailsDefendant litigationDetailsDefendant;
	public LitigationDetailsDefendant getLitigationDetailsDefendant() {return litigationDetailsDefendant;}
	public void setLitigationDetailsDefendant(LitigationDetailsDefendant value) {this.litigationDetailsDefendant =  value;}

	@XmlElement(name = "LitigationDetailsPlaintiff")
	protected LitigationDetailsPlaintiff litigationDetailsPlaintiff;
	public LitigationDetailsPlaintiff getLitigationDetailsPlaintiff() {return litigationDetailsPlaintiff;}
	public void setLitigationDetailsPlaintiff(LitigationDetailsPlaintiff value) {this.litigationDetailsPlaintiff =  value;}

	@XmlElement(name = "CountyCourtJudgements")
	protected CountyCourtJudgements countyCourtJudgements;
	public CountyCourtJudgements getCountyCourtJudgements() {return countyCourtJudgements;}
	public void setCountyCourtJudgements(CountyCourtJudgements value) {this.countyCourtJudgements =  value;}

	@XmlElement(name = "InsolvencyEvents")
	protected InsolvencyEvents insolvencyEvents;
	public InsolvencyEvents getInsolvencyEvents() {return insolvencyEvents;}
	public void setInsolvencyEvents(InsolvencyEvents value) {this.insolvencyEvents =  value;}

	@XmlElement(name = "ConcursosEvents")
	protected ConcursosEvents concursosEvents;
	public ConcursosEvents getConcursosEvents() {return concursosEvents;}
	public void setConcursosEvents(ConcursosEvents value) {this.concursosEvents =  value;}

	@XmlElement(name = "FederalLitigation")
	protected FederalLitigation federalLitigation;
	public FederalLitigation getFederalLitigation() {return federalLitigation;}
	public void setFederalLitigation(FederalLitigation value) {this.federalLitigation =  value;}

	@XmlElement(name = "StateLitigation")
	protected StateLitigation stateLitigation;
	public StateLitigation getStateLitigation() {return stateLitigation;}
	public void setStateLitigation(StateLitigation value) {this.stateLitigation =  value;}

	@XmlElement(name = "ProtestedBills")
	protected ProtestedBills protestedBills;
	public ProtestedBills getProtestedBills() {return protestedBills;}
	public void setProtestedBills(ProtestedBills value) {this.protestedBills =  value;}

	@XmlElement(name = "InsolvencyInformation")
	protected InsolvencyInformation insolvencyInformation;
	public InsolvencyInformation getInsolvencyInformation() {return insolvencyInformation;}
	public void setInsolvencyInformation(InsolvencyInformation value) {this.insolvencyInformation =  value;}

	@XmlElement(name = "CompanyFailures")
	protected CompanyFailures companyFailures;
	public CompanyFailures getCompanyFailures() {return companyFailures;}
	public void setCompanyFailures(CompanyFailures value) {this.companyFailures =  value;}

	@XmlElement(name = "CourtData")
	protected List<CourtData> courtData;
	public List<CourtData> getCourtData() {
		if (courtData == null) {
			courtData = new ArrayList<CourtData>();
		}
		return courtData;
	}
	@XmlElement(name = "NegativeInformationSummary")
	protected NegativeInformationSummary negativeInformationSummary;
	public NegativeInformationSummary getNegativeInformationSummary() {return negativeInformationSummary;}
	public void setNegativeInformationSummary(NegativeInformationSummary value) {this.negativeInformationSummary =  value;}

	@XmlElement(name = "OfficialRemarks")
	protected OfficialRemarks officialRemarks;
	public OfficialRemarks getOfficialRemarks() {return officialRemarks;}
	public void setOfficialRemarks(OfficialRemarks value) {this.officialRemarks =  value;}

	@XmlElement(name = "NSSODetails")
	protected NSSODetails nssoDetails;
	public NSSODetails getNssoDetails() {return nssoDetails;}
	public void setNssoDetails(NSSODetails value) {this.nssoDetails =  value;}

	@XmlElement(name = "CompanyLegalEvents")
	protected CompanyLegalEvents companyLegalEvents;
	public CompanyLegalEvents getCompanyLegalEvents() {return companyLegalEvents;}
	public void setCompanyLegalEvents(CompanyLegalEvents value) {this.companyLegalEvents =  value;}

	@XmlElement(name = "PaymentRemarks")
	protected PaymentRemarks paymentRemarks;
	public PaymentRemarks getPaymentRemarks() {return paymentRemarks;}
	public void setPaymentRemarks(PaymentRemarks value) {this.paymentRemarks =  value;}

	@XmlElement(name = "Incidents")
	protected Incidents incidents;
	public Incidents getIncidents() {return incidents;}
	public void setIncidents(Incidents value) {this.incidents =  value;}

	@XmlElement(name = "Bankruptcy")
	protected Bankruptcy bankruptcy;
	public Bankruptcy getBankruptcy() {return bankruptcy;}
	public void setBankruptcy(Bankruptcy value) {this.bankruptcy =  value;}

	@XmlElement(name = "DirectorEvents")
	protected DirectorEvents directorEvents;
	public DirectorEvents getDirectorEvents() {return directorEvents;}
	public void setDirectorEvents(DirectorEvents value) {this.directorEvents =  value;}

	@XmlElement(name = "Judgements")
	protected Judgements judgements;
	public Judgements getJudgements() {return judgements;}
	public void setJudgements(Judgements value) {this.judgements =  value;}

	@XmlElement(name = "PreferentialRights")
	protected PreferentialRights preferentialRights;
	public PreferentialRights getPreferentialRights() {return preferentialRights;}
	public void setPreferentialRights(PreferentialRights value) {this.preferentialRights =  value;}

	@XmlElement(name = "BankruptcyData")
	protected BankruptcyData bankruptcyData;
	public BankruptcyData getBankruptcyData() {return bankruptcyData;}
	public void setBankruptcyData(BankruptcyData value) {this.bankruptcyData =  value;}

	@XmlElement(name = "LegalFilingSummary")
	protected LegalFilingSummary legalFilingSummary;
	public LegalFilingSummary getLegalFilingSummary() {return legalFilingSummary;}
	public void setLegalFilingSummary(LegalFilingSummary value) {this.legalFilingSummary =  value;}

	@XmlElement(name = "UCCDetails")
	protected UCCDetails uccDetails;
	public UCCDetails getUccDetails() {return uccDetails;}
	public void setUccDetails(UCCDetails value) {this.uccDetails =  value;}

	@XmlElement(name = "BankruptcyDetails")
	protected BankruptcyDetails bankruptcyDetails;
	public BankruptcyDetails getBankruptcyDetails() {return bankruptcyDetails;}
	public void setBankruptcyDetails(BankruptcyDetails value) {this.bankruptcyDetails =  value;}

	@XmlElement(name = "TaxLienDetails")
	protected TaxLienDetails taxLienDetails;
	public TaxLienDetails getTaxLienDetails() {return taxLienDetails;}
	public void setTaxLienDetails(TaxLienDetails value) {this.taxLienDetails =  value;}

	@XmlElement(name = "JudgmentDetails")
	protected JudgmentDetails judgmentDetails;
	public JudgmentDetails getJudgmentDetails() {return judgmentDetails;}
	public void setJudgmentDetails(JudgmentDetails value) {this.judgmentDetails =  value;}

}
