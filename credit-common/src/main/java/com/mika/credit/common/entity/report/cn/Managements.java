package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;
import com.mika.credit.common.util.DateUtil;

/**
 * 管理层信息
 * @author ZhuJun，ShenYi
 * Created on 2014-03-14
 */
public class Managements  extends BaseEntity {
	/**
	 * ID编号
	 */
	private Integer id;
	/**
	 * 中文名称
	 */
	private String nameCN;
	/**
	 * 英文名称
	 */
	private String nameEN;
	/**
	 *性别  0 男 1 女  2 未知
	 */
	private String gender;
	/**
	 *出生日期
	 */
	private String birthDate;
	/**
	 *年龄
	 */
	private String age;
	/**
	 *职位
	 */
	private Integer postId;
	/**
	 *职能
	 */
	private Integer dutyId;
	/**
	 *职能CN
	 */
	private String dutyCN;
	/**
	 *职能EN
	 */
	private String dutyEN;
	/**
	 *证件号
	 */
	private String cardID;
	/**
	 *教育
	 */
	private Integer educationId;
	/**
	 *中文国籍
	 */
	private String countryCN;
	/**
	 *英文国籍
	 */
	private String countryEN;
	/**
	 *管理多少年
	 */
	private String manageYears;
	/**
	 *工作多少年
	 */
	private String workYears;
	/**
	 *中文工作经验
	 */
	private String experienceCN;
	/**
	 *英文工作经验
	 */
	private String experienceEN;
	/**
	 *中文备注
	 */
	private String noteCN;
	/**
	 *英文备注
	 */
	private String noteEN;
	/**
	 *科氏号码
	 */
	private String crefoNo;
	/**
	 *删除标识
	 */
	private String delFlag;
	/**
	 *职位CN
	 */
	private String position;
	/**
	 *职位EN
	 */
	private String positionEN;
	/**
	 *职能
	 */
	private String function;
	/**
	 *教育CN
	 */
	private String educationCN;
	/**
	 *教育EN
	 */
	private String educationEN;
	/**
	 *更新时间
	 */
	private String updateTime;
	/**
	 *性别  0 男 1 女  2 未知
	 */
	private String sex;
	/**
	 *关联一标识
	 */
	private Integer fullReportId;

	private String carduty_id;

	public Managements() {
		this.updateTime = DateUtil.getCurrentDate();
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameCN() {
		return nameCN;
	}

	public void setNameCN(String nameCN) {
		this.nameCN = nameCN;
	}

	public String getNameEN() {
		return nameEN;
	}

	public void setNameEN(String nameEN) {
		this.nameEN = nameEN;
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public Integer getDutyId() {
		return dutyId;
	}

	public void setDutyId(Integer dutyId) {
		this.dutyId = dutyId;
	}

	public Integer getEducationId() {
		return educationId;
	}

	public void setEducationId(Integer educationId) {
		this.educationId = educationId;
	}

	public String getCardID() {
		return cardID;
	}

	public void setCardID(String cardID) {
		this.cardID = cardID;
	}


	public String getCountryCN() {
		return countryCN;
	}

	public void setCountryCN(String countryCN) {
		this.countryCN = countryCN;
	}

	public String getCountryEN() {
		return countryEN;
	}

	public void setCountryEN(String countryEN) {
		this.countryEN = countryEN;
	}

	public String getManageYears() {
		return manageYears;
	}

	public void setManageYears(String manageYears) {
		this.manageYears = manageYears;
	}

	public String getWorkYears() {
		return workYears;
	}

	public void setWorkYears(String workYears) {
		this.workYears = workYears;
	}

	public String getExperienceCN() {
		return experienceCN;
	}

	public void setExperienceCN(String experienceCN) {
		this.experienceCN = experienceCN;
	}

	public String getExperienceEN() {
		return experienceEN;
	}

	public void setExperienceEN(String experienceEN) {
		this.experienceEN = experienceEN;
	}

	public String getNoteCN() {
		return noteCN;
	}

	public void setNoteCN(String noteCN) {
		this.noteCN = noteCN;
	}

	public String getNoteEN() {
		return noteEN;
	}

	public void setNoteEN(String noteEN) {
		this.noteEN = noteEN;
	}

	public String getCrefoNo() {
		return crefoNo;
	}

	public void setCrefoNo(String crefoNo) {
		this.crefoNo = crefoNo;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getDutyCN() {
		return dutyCN;
	}

	public void setDutyCN(String dutyCN) {
		this.dutyCN = dutyCN;
	}

	public String getDutyEN() {
		return dutyEN;
	}

	public void setDutyEN(String dutyEN) {
		this.dutyEN = dutyEN;
	}

	public String getEducationCN() {
		return educationCN;
	}

	public void setEducationCN(String educationCN) {
		this.educationCN = educationCN;
	}

	public String getEducationEN() {
		return educationEN;
	}

	public void setEducationEN(String educationEN) {
		this.educationEN = educationEN;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getFullReportId() {
		return fullReportId;
	}

	public void setFullReportId(Integer fullReportId) {
		this.fullReportId = fullReportId;
	}

	public String getCarduty_id() {
		return carduty_id;
	}

	public void setCarduty_id(String carduty_id) {
		this.carduty_id = carduty_id;
	}

	public String getPositionEN() {
		return positionEN;
	}

	public void setPositionEN(String positionEN) {
		this.positionEN = positionEN;
	}
}
