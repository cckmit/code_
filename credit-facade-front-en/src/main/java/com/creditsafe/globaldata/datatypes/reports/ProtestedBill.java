package com.creditsafe.globaldata.datatypes.reports;

import com.creditsafe.globaldata.datatypes.AddressData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProtestedBill", propOrder = {
	"caseNumber",
	"taxCode",
	"name",
	"address",
	"amountOfProtesti",
	"currency",
	"notificationDate",
	"registrationDate",
	"draweeName",
	"draweeAddress",
	"billAmount",
	"billCurrency",
	"maturityOfBillInMonths",
	"paymentDate",
	"nameOfDrawer",
	"cityOfDrawer"
})

public class ProtestedBill implements Serializable {

	@XmlElement(name = "CaseNumber")
	protected String caseNumber;
	public String getCaseNumber() {return caseNumber;}
	public void setCaseNumber(String value) {this.caseNumber =  value;}

	@XmlElement(name = "TaxCode")
	protected String taxCode;
	public String getTaxCode() {return taxCode;}
	public void setTaxCode(String value) {this.taxCode =  value;}

	@XmlElement(name = "Name")
	protected String name;
	public String getName() {return name;}
	public void setName(String value) {this.name =  value;}

	@XmlElement(name = "Address")
	protected AddressData address;
	public AddressData getAddress() {return address;}
	public void setAddress(AddressData value) {this.address =  value;}

	@XmlElement(name = "AmountOfProtesti")
	protected String amountOfProtesti;
	public String getAmountOfProtesti() {return amountOfProtesti;}
	public void setAmountOfProtesti(String value) {this.amountOfProtesti =  value;}

	@XmlElement(name = "Currency")
	protected String currency;
	public String getCurrency() {return currency;}
	public void setCurrency(String value) {this.currency =  value;}

	@XmlElement(name = "NotificationDate")
	protected String notificationDate;
	public String getNotificationDate() {return notificationDate;}
	public void setNotificationDate(String value) {this.notificationDate =  value;}

	@XmlElement(name = "RegistrationDate")
	protected String registrationDate;
	public String getRegistrationDate() {return registrationDate;}
	public void setRegistrationDate(String value) {this.registrationDate =  value;}

	@XmlElement(name = "DraweeName")
	protected String draweeName;
	public String getDraweeName() {return draweeName;}
	public void setDraweeName(String value) {this.draweeName =  value;}

	@XmlElement(name = "DraweeAddress")
	protected String draweeAddress;
	public String getDraweeAddress() {return draweeAddress;}
	public void setDraweeAddress(String value) {this.draweeAddress =  value;}

	@XmlElement(name = "BillAmount")
	protected String billAmount;
	public String getBillAmount() {return billAmount;}
	public void setBillAmount(String value) {this.billAmount =  value;}

	@XmlElement(name = "BillCurrency")
	protected String billCurrency;
	public String getBillCurrency() {return billCurrency;}
	public void setBillCurrency(String value) {this.billCurrency =  value;}

	@XmlElement(name = "MaturityOfBillInMonths")
	protected String maturityOfBillInMonths;
	public String getMaturityOfBillInMonths() {return maturityOfBillInMonths;}
	public void setMaturityOfBillInMonths(String value) {this.maturityOfBillInMonths =  value;}

	@XmlElement(name = "PaymentDate")
	protected String paymentDate;
	public String getPaymentDate() {return paymentDate;}
	public void setPaymentDate(String value) {this.paymentDate =  value;}

	@XmlElement(name = "NameOfDrawer")
	protected String nameOfDrawer;
	public String getNameOfDrawer() {return nameOfDrawer;}
	public void setNameOfDrawer(String value) {this.nameOfDrawer =  value;}

	@XmlElement(name = "CityOfDrawer")
	protected String cityOfDrawer;
	public String getCityOfDrawer() {return cityOfDrawer;}
	public void setCityOfDrawer(String value) {this.cityOfDrawer =  value;}

}
