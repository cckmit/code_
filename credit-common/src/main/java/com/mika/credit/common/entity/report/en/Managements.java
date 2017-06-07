package com.mika.credit.common.entity.report.en;

import com.mika.credit.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="Managements")
public class Managements extends BaseEntity implements Serializable {

	/**
	 * 管理层信息
	 * @author Nancy
	 * @date 2016-09-24
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;//ID编号
	
	@Column(name="name", columnDefinition="varchar(500)")
	private String name;//中文名称
	
	@Column(name="gender", columnDefinition="varchar(500)")
	private String gender;//性别
	
	@Column(name="birthDate", columnDefinition="varchar(500)")
	private String birthDate;//出生日期

	private Integer fullReportId;//fullReportId

	public Integer getFullReportId() {
		return fullReportId;
	}

	public void setFullReportId(Integer fullReportId) {
		this.fullReportId = fullReportId;
	}

	@Column(name="address", columnDefinition="varchar(500)")
	private String address;//地址

	@Column(name="houseNumber", columnDefinition="varchar(500)")
	private String houseNumber;//地址

	@Column(name="street", columnDefinition="varchar(10)")
	private String street;//地址

	@Column(name="city", columnDefinition="varchar(100)")
	private String city;//地址

	@Column(name="province", columnDefinition="varchar(100)")
	private String province;//地址	

	private String postCode;//邮编

	@Column(name="position", columnDefinition="varchar(50)")
	private String position;// 职位
	
	@Column(name="appointmentDate", columnDefinition="varchar(50)")
	private String appointmentDate;//	任职日期

	@Column(name="commonCode", columnDefinition="varchar(50)")
	private String commonCode;//	全球职位代码

	@Column(name="providerCode", columnDefinition="varchar(50)")
	private String providerCode;//	当地职位代码
	
	@Column(name="manageType", columnDefinition="varchar(50)")
	private String manageType; //1:当前管理员 2：旧管理员

	@Column(name="crefoNo", columnDefinition="varchar(50)")
	private String crefoNo;//公司内部科氏码
	
	@Column(name="updateTime", columnDefinition="varchar(50)")
	private String updateTime;//更新时间
	
	@Column(name="delFlag", columnDefinition="varchar(2)")
	private String delFlag;//删除标志 1：正常
	
	@Column(name="manageNote", columnDefinition="Text")
	private String manageNote;//备注
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getAddress() {
		return address;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getCommonCode() {
		return commonCode;
	}
	public void setCommonCode(String commonCode) {
		this.commonCode = commonCode;
	}
	public String getProviderCode() {
		return providerCode;
	}
	public void setProviderCode(String providerCode) {
		this.providerCode = providerCode;
	}
	public String getManageType() {
		return manageType;
	}
	public void setManageType(String manageType) {
		this.manageType = manageType;
	}
	public String getCrefoNo() {
		return crefoNo;
	}
	public void setCrefoNo(String crefoNo) {
		this.crefoNo = crefoNo;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	public String getManageNote() {
		return manageNote;
	}
	public void setManageNote(String manageNote) {
		this.manageNote = manageNote;
	}
	
	
	
	
	
	
}
