package com.creditsafe.globaldata.datatypes.reports;

import com.creditsafe.globaldata.datatypes.AddressData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompanyInvolved", propOrder = {
	"transfereeOrTransferor",
	"taxCode",
	"name",
	"documentName",
	"registeredDate",
	"address"
})

public class CompanyInvolved implements Serializable {

	@XmlElement(name = "TransfereeOrTransferor")
	protected String transfereeOrTransferor;
	public String getTransfereeOrTransferor() {return transfereeOrTransferor;}
	public void setTransfereeOrTransferor(String value) {this.transfereeOrTransferor =  value;}

	@XmlElement(name = "TaxCode")
	protected String taxCode;
	public String getTaxCode() {return taxCode;}
	public void setTaxCode(String value) {this.taxCode =  value;}

	@XmlElement(name = "Name")
	protected String name;
	public String getName() {return name;}
	public void setName(String value) {this.name =  value;}

	@XmlElement(name = "DocumentName")
	protected String documentName;
	public String getDocumentName() {return documentName;}
	public void setDocumentName(String value) {this.documentName =  value;}

	@XmlElement(name = "RegisteredDate")
	protected String registeredDate;
	public String getRegisteredDate() {return registeredDate;}
	public void setRegisteredDate(String value) {this.registeredDate =  value;}

	@XmlElement(name = "Address")
	protected AddressData address;
	public AddressData getAddress() {return address;}
	public void setAddress(AddressData value) {this.address =  value;}

}
