package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Auditors", propOrder = {
	"auditorsBoardValidityStartDate",
	"auditorsBoardValidityEndDate",
	"numberofPeriodsBoardRemainsinOffice",
	"auditorsBoardTerm",
	"numberofStatutoryAuditors",
	"auditor",
	"minNumberofMembersInBoard",
	"maxNumberofMembersInBoard",
	"numberofMembersInTheBoardinOffice"
})

public class Auditors implements Serializable {

	@XmlElement(name = "AuditorsBoardValidityStartDate")
	protected String auditorsBoardValidityStartDate;
	public String getAuditorsBoardValidityStartDate() {return auditorsBoardValidityStartDate;}
	public void setAuditorsBoardValidityStartDate(String value) {this.auditorsBoardValidityStartDate =  value;}

	@XmlElement(name = "AuditorsBoardValidityEndDate")
	protected String auditorsBoardValidityEndDate;
	public String getAuditorsBoardValidityEndDate() {return auditorsBoardValidityEndDate;}
	public void setAuditorsBoardValidityEndDate(String value) {this.auditorsBoardValidityEndDate =  value;}

	@XmlElement(name = "NumberofPeriodsBoardRemainsinOffice")
	protected String numberofPeriodsBoardRemainsinOffice;
	public String getNumberofPeriodsBoardRemainsinOffice() {return numberofPeriodsBoardRemainsinOffice;}
	public void setNumberofPeriodsBoardRemainsinOffice(String value) {this.numberofPeriodsBoardRemainsinOffice =  value;}

	@XmlElement(name = "AuditorsBoardTerm")
	protected String auditorsBoardTerm;
	public String getAuditorsBoardTerm() {return auditorsBoardTerm;}
	public void setAuditorsBoardTerm(String value) {this.auditorsBoardTerm =  value;}

	@XmlElement(name = "NumberofStatutoryAuditors")
	protected String numberofStatutoryAuditors;
	public String getNumberofStatutoryAuditors() {return numberofStatutoryAuditors;}
	public void setNumberofStatutoryAuditors(String value) {this.numberofStatutoryAuditors =  value;}

	@XmlElement(name = "Auditor")
	protected String auditor;
	public String getAuditor() {return auditor;}
	public void setAuditor(String value) {this.auditor =  value;}

	@XmlElement(name = "MinNumberofMembersInBoard")
	protected String minNumberofMembersInBoard;
	public String getMinNumberofMembersInBoard() {return minNumberofMembersInBoard;}
	public void setMinNumberofMembersInBoard(String value) {this.minNumberofMembersInBoard =  value;}

	@XmlElement(name = "MaxNumberofMembersInBoard")
	protected String maxNumberofMembersInBoard;
	public String getMaxNumberofMembersInBoard() {return maxNumberofMembersInBoard;}
	public void setMaxNumberofMembersInBoard(String value) {this.maxNumberofMembersInBoard =  value;}

	@XmlElement(name = "NumberofMembersInTheBoardinOffice")
	protected String numberofMembersInTheBoardinOffice;
	public String getNumberofMembersInTheBoardinOffice() {return numberofMembersInTheBoardinOffice;}
	public void setNumberofMembersInTheBoardinOffice(String value) {this.numberofMembersInTheBoardinOffice =  value;}

}
