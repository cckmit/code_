package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GazetteFillingOfAccount", propOrder = {
	"datePublished",
	"type",
	"financialYear",
	"dateFiled"
})

public class GazetteFillingOfAccount implements Serializable {

	@XmlElement(name = "DatePublished")
	protected String datePublished;
	public String getDatePublished() {return datePublished;}
	public void setDatePublished(String value) {this.datePublished =  value;}

	@XmlElement(name = "Type")
	protected String type;
	public String getType() {return type;}
	public void setType(String value) {this.type =  value;}

	@XmlElement(name = "FinancialYear")
	protected String financialYear;
	public String getFinancialYear() {return financialYear;}
	public void setFinancialYear(String value) {this.financialYear =  value;}

	@XmlElement(name = "DateFiled")
	protected String dateFiled;
	public String getDateFiled() {return dateFiled;}
	public void setDateFiled(String value) {this.dateFiled =  value;}

}
