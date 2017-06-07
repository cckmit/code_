package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DebtBalance", propOrder = {
	"currency",
	"numberOfPrivateClaims",
	"balanceOfPrivateClaims",
	"numberOfPublicClaims",
	"balanceOfPublicClaims",
	"totalBalance"
})

public class DebtBalance implements Serializable {

	@XmlElement(name = "Currency")
	protected String currency;
	public String getCurrency() {return currency;}
	public void setCurrency(String value) {this.currency =  value;}

	@XmlElement(name = "NumberOfPrivateClaims")
	protected String numberOfPrivateClaims;
	public String getNumberOfPrivateClaims() {return numberOfPrivateClaims;}
	public void setNumberOfPrivateClaims(String value) {this.numberOfPrivateClaims =  value;}

	@XmlElement(name = "BalanceOfPrivateClaims")
	protected String balanceOfPrivateClaims;
	public String getBalanceOfPrivateClaims() {return balanceOfPrivateClaims;}
	public void setBalanceOfPrivateClaims(String value) {this.balanceOfPrivateClaims =  value;}

	@XmlElement(name = "NumberOfPublicClaims")
	protected String numberOfPublicClaims;
	public String getNumberOfPublicClaims() {return numberOfPublicClaims;}
	public void setNumberOfPublicClaims(String value) {this.numberOfPublicClaims =  value;}

	@XmlElement(name = "BalanceOfPublicClaims")
	protected String balanceOfPublicClaims;
	public String getBalanceOfPublicClaims() {return balanceOfPublicClaims;}
	public void setBalanceOfPublicClaims(String value) {this.balanceOfPublicClaims =  value;}

	@XmlElement(name = "TotalBalance")
	protected String totalBalance;
	public String getTotalBalance() {return totalBalance;}
	public void setTotalBalance(String value) {this.totalBalance =  value;}

}
