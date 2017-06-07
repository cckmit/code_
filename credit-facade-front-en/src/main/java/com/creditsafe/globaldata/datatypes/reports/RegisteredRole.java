package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegisteredRole", propOrder = {
	"roleDescription",
	"roleNumber",
	"roleRegistrationRequestDate",
	"province"
})

public class RegisteredRole implements Serializable {

	@XmlElement(name = "RoleDescription")
	protected String roleDescription;
	public String getRoleDescription() {return roleDescription;}
	public void setRoleDescription(String value) {this.roleDescription =  value;}

	@XmlElement(name = "RoleNumber")
	protected String roleNumber;
	public String getRoleNumber() {return roleNumber;}
	public void setRoleNumber(String value) {this.roleNumber =  value;}

	@XmlElement(name = "RoleRegistrationRequestDate")
	protected String roleRegistrationRequestDate;
	public String getRoleRegistrationRequestDate() {return roleRegistrationRequestDate;}
	public void setRoleRegistrationRequestDate(String value) {this.roleRegistrationRequestDate =  value;}

	@XmlElement(name = "Province")
	protected String province;
	public String getProvince() {return province;}
	public void setProvince(String value) {this.province =  value;}

}
