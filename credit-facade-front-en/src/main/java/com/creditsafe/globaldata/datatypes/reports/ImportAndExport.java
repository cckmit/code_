package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImportAndExport", propOrder = {
	"year",
	"exports",
	"imports"
})

public class ImportAndExport implements Serializable {

	@XmlElement(name = "Year")
	protected String year;
	public String getYear() {return year;}
	public void setYear(String value) {this.year =  value;}

	@XmlElement(name = "Exports")
	protected String exports;
	public String getExports() {return exports;}
	public void setExports(String value) {this.exports =  value;}

	@XmlElement(name = "Imports")
	protected String imports;
	public String getImports() {return imports;}
	public void setImports(String value) {this.imports =  value;}

}
