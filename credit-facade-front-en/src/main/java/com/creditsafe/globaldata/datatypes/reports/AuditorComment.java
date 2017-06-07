package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuditorComment", propOrder = {
	"dateofAccounts",
	"comments"
})

public class AuditorComment implements Serializable {

	@XmlElement(name = "DateofAccounts")
	protected String dateofAccounts;
	public String getDateofAccounts() {return dateofAccounts;}
	public void setDateofAccounts(String value) {this.dateofAccounts =  value;}

	@XmlElement(name = "Comments")
	protected String comments;
	public String getComments() {return comments;}
	public void setComments(String value) {this.comments =  value;}

}
