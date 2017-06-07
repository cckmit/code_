package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OverduePaymentsSummary", propOrder = {
	"tenPlusDaysOverduePaymentsCounts",
	"tenPlusDaysOverduePaymentsAmounts",
	"negativeCreditRecordsFinancialInstitutionsCounts",
	"negativeCreditRecordsFinancialInstitutionsAmounts",
	"negativeCreditRecordsNonFinancialInstitutionsCounts",
	"negativeCreditRecordsNonFinancialInstitutionsAmounts",
	"details"
})

public class OverduePaymentsSummary implements Serializable {

	@XmlElement(name = "TenPlusDaysOverduePaymentsCounts")
	protected String tenPlusDaysOverduePaymentsCounts;
	public String getTenPlusDaysOverduePaymentsCounts() {return tenPlusDaysOverduePaymentsCounts;}
	public void setTenPlusDaysOverduePaymentsCounts(String value) {this.tenPlusDaysOverduePaymentsCounts =  value;}

	@XmlElement(name = "TenPlusDaysOverduePaymentsAmounts")
	protected String tenPlusDaysOverduePaymentsAmounts;
	public String getTenPlusDaysOverduePaymentsAmounts() {return tenPlusDaysOverduePaymentsAmounts;}
	public void setTenPlusDaysOverduePaymentsAmounts(String value) {this.tenPlusDaysOverduePaymentsAmounts =  value;}

	@XmlElement(name = "NegativeCreditRecordsFinancialInstitutionsCounts")
	protected String negativeCreditRecordsFinancialInstitutionsCounts;
	public String getNegativeCreditRecordsFinancialInstitutionsCounts() {return negativeCreditRecordsFinancialInstitutionsCounts;}
	public void setNegativeCreditRecordsFinancialInstitutionsCounts(String value) {this.negativeCreditRecordsFinancialInstitutionsCounts =  value;}

	@XmlElement(name = "NegativeCreditRecordsFinancialInstitutionsAmounts")
	protected String negativeCreditRecordsFinancialInstitutionsAmounts;
	public String getNegativeCreditRecordsFinancialInstitutionsAmounts() {return negativeCreditRecordsFinancialInstitutionsAmounts;}
	public void setNegativeCreditRecordsFinancialInstitutionsAmounts(String value) {this.negativeCreditRecordsFinancialInstitutionsAmounts =  value;}

	@XmlElement(name = "NegativeCreditRecordsNonFinancialInstitutionsCounts")
	protected String negativeCreditRecordsNonFinancialInstitutionsCounts;
	public String getNegativeCreditRecordsNonFinancialInstitutionsCounts() {return negativeCreditRecordsNonFinancialInstitutionsCounts;}
	public void setNegativeCreditRecordsNonFinancialInstitutionsCounts(String value) {this.negativeCreditRecordsNonFinancialInstitutionsCounts =  value;}

	@XmlElement(name = "NegativeCreditRecordsNonFinancialInstitutionsAmounts")
	protected String negativeCreditRecordsNonFinancialInstitutionsAmounts;
	public String getNegativeCreditRecordsNonFinancialInstitutionsAmounts() {return negativeCreditRecordsNonFinancialInstitutionsAmounts;}
	public void setNegativeCreditRecordsNonFinancialInstitutionsAmounts(String value) {this.negativeCreditRecordsNonFinancialInstitutionsAmounts =  value;}

	@XmlElement(name = "Details")
	protected Details details;
	public Details getDetails() {return details;}
	public void setDetails(Details value) {this.details =  value;}

}
