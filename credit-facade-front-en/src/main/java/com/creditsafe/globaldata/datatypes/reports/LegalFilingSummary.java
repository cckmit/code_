package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LegalFilingSummary", propOrder = {
	"bankruptcy",
	"taxLienFilings",
	"judgmentFilings",
	"sum",
	"uccFilings",
	"cautionaryUCCFilings"
})

public class LegalFilingSummary implements Serializable {

	@XmlElement(name = "Bankruptcy")
	protected String bankruptcy;
	public String getBankruptcy() {return bankruptcy;}
	public void setBankruptcy(String value) {this.bankruptcy =  value;}

	@XmlElement(name = "TaxLienFilings")
	protected String taxLienFilings;
	public String getTaxLienFilings() {return taxLienFilings;}
	public void setTaxLienFilings(String value) {this.taxLienFilings =  value;}

	@XmlElement(name = "JudgmentFilings")
	protected String judgmentFilings;
	public String getJudgmentFilings() {return judgmentFilings;}
	public void setJudgmentFilings(String value) {this.judgmentFilings =  value;}

	@XmlElement(name = "Sum")
	protected String sum;
	public String getSum() {return sum;}
	public void setSum(String value) {this.sum =  value;}

	@XmlElement(name = "UCCFilings")
	protected String uccFilings;
	public String getUccFilings() {return uccFilings;}
	public void setUccFilings(String value) {this.uccFilings =  value;}

	@XmlElement(name = "CautionaryUCCFilings")
	protected String cautionaryUCCFilings;
	public String getCautionaryUCCFilings() {return cautionaryUCCFilings;}
	public void setCautionaryUCCFilings(String value) {this.cautionaryUCCFilings =  value;}

}
