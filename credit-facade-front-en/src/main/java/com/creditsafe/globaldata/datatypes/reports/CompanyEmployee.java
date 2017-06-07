package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompanyEmployee", propOrder = {
	"latestEmployeeInformationDate",
	"employeeInformationYear",
	"q1NumberSEworkers",
	"q1NumberEmployedWorkers",
	"q1TotalNumberofWorkers",
	"q2NumberSEworkers",
	"q2NumberEmployedWorkers",
	"q2TotalNumberofWorkers",
	"q3NumberSEworkers",
	"q3NumberEmployedWorkers",
	"q3TotalNumberofWorkers",
	"q4NumberSEworkers",
	"q4NumberEmployedWorkers",
	"q4TotalNumberofWorkers",
	"averageNumberSEworkers",
	"averageNumberEmployedWorkers",
	"averageTotalNumberofWorkers"
})

public class CompanyEmployee implements Serializable {

	@XmlElement(name = "LatestEmployeeInformationDate")
	protected String latestEmployeeInformationDate;
	public String getLatestEmployeeInformationDate() {return latestEmployeeInformationDate;}
	public void setLatestEmployeeInformationDate(String value) {this.latestEmployeeInformationDate =  value;}

	@XmlElement(name = "EmployeeInformationYear")
	protected String employeeInformationYear;
	public String getEmployeeInformationYear() {return employeeInformationYear;}
	public void setEmployeeInformationYear(String value) {this.employeeInformationYear =  value;}

	@XmlElement(name = "Q1NumberSEworkers")
	protected String q1NumberSEworkers;
	public String getQ1NumberSEworkers() {return q1NumberSEworkers;}
	public void setQ1NumberSEworkers(String value) {this.q1NumberSEworkers =  value;}

	@XmlElement(name = "Q1NumberEmployedWorkers")
	protected String q1NumberEmployedWorkers;
	public String getQ1NumberEmployedWorkers() {return q1NumberEmployedWorkers;}
	public void setQ1NumberEmployedWorkers(String value) {this.q1NumberEmployedWorkers =  value;}

	@XmlElement(name = "Q1TotalNumberofWorkers")
	protected String q1TotalNumberofWorkers;
	public String getQ1TotalNumberofWorkers() {return q1TotalNumberofWorkers;}
	public void setQ1TotalNumberofWorkers(String value) {this.q1TotalNumberofWorkers =  value;}

	@XmlElement(name = "Q2NumberSEworkers")
	protected String q2NumberSEworkers;
	public String getQ2NumberSEworkers() {return q2NumberSEworkers;}
	public void setQ2NumberSEworkers(String value) {this.q2NumberSEworkers =  value;}

	@XmlElement(name = "Q2NumberEmployedWorkers")
	protected String q2NumberEmployedWorkers;
	public String getQ2NumberEmployedWorkers() {return q2NumberEmployedWorkers;}
	public void setQ2NumberEmployedWorkers(String value) {this.q2NumberEmployedWorkers =  value;}

	@XmlElement(name = "Q2TotalNumberofWorkers")
	protected String q2TotalNumberofWorkers;
	public String getQ2TotalNumberofWorkers() {return q2TotalNumberofWorkers;}
	public void setQ2TotalNumberofWorkers(String value) {this.q2TotalNumberofWorkers =  value;}

	@XmlElement(name = "Q3NumberSEworkers")
	protected String q3NumberSEworkers;
	public String getQ3NumberSEworkers() {return q3NumberSEworkers;}
	public void setQ3NumberSEworkers(String value) {this.q3NumberSEworkers =  value;}

	@XmlElement(name = "Q3NumberEmployedWorkers")
	protected String q3NumberEmployedWorkers;
	public String getQ3NumberEmployedWorkers() {return q3NumberEmployedWorkers;}
	public void setQ3NumberEmployedWorkers(String value) {this.q3NumberEmployedWorkers =  value;}

	@XmlElement(name = "Q3TotalNumberofWorkers")
	protected String q3TotalNumberofWorkers;
	public String getQ3TotalNumberofWorkers() {return q3TotalNumberofWorkers;}
	public void setQ3TotalNumberofWorkers(String value) {this.q3TotalNumberofWorkers =  value;}

	@XmlElement(name = "Q4NumberSEworkers")
	protected String q4NumberSEworkers;
	public String getQ4NumberSEworkers() {return q4NumberSEworkers;}
	public void setQ4NumberSEworkers(String value) {this.q4NumberSEworkers =  value;}

	@XmlElement(name = "Q4NumberEmployedWorkers")
	protected String q4NumberEmployedWorkers;
	public String getQ4NumberEmployedWorkers() {return q4NumberEmployedWorkers;}
	public void setQ4NumberEmployedWorkers(String value) {this.q4NumberEmployedWorkers =  value;}

	@XmlElement(name = "Q4TotalNumberofWorkers")
	protected String q4TotalNumberofWorkers;
	public String getQ4TotalNumberofWorkers() {return q4TotalNumberofWorkers;}
	public void setQ4TotalNumberofWorkers(String value) {this.q4TotalNumberofWorkers =  value;}

	@XmlElement(name = "AverageNumberSEworkers")
	protected String averageNumberSEworkers;
	public String getAverageNumberSEworkers() {return averageNumberSEworkers;}
	public void setAverageNumberSEworkers(String value) {this.averageNumberSEworkers =  value;}

	@XmlElement(name = "AverageNumberEmployedWorkers")
	protected String averageNumberEmployedWorkers;
	public String getAverageNumberEmployedWorkers() {return averageNumberEmployedWorkers;}
	public void setAverageNumberEmployedWorkers(String value) {this.averageNumberEmployedWorkers =  value;}

	@XmlElement(name = "AverageTotalNumberofWorkers")
	protected String averageTotalNumberofWorkers;
	public String getAverageTotalNumberofWorkers() {return averageTotalNumberofWorkers;}
	public void setAverageTotalNumberofWorkers(String value) {this.averageTotalNumberofWorkers =  value;}

}
