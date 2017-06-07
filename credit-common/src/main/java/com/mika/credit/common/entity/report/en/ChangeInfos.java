package com.mika.credit.common.entity.report.en;

import com.mika.credit.common.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ChangeInfos")
public class ChangeInfos extends BaseEntity implements Serializable {

	/**
	 * 注册变更表
	 * @author Nancy
	 * @date 2016-09-26
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Basic
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="previousName", columnDefinition="varchar(50)")
	private String previousName;//曾用名

	@Column(name="nameChangeDate", columnDefinition="varchar(50)")
	private String nameChangeDate;//名字变更日期

	@Column(name="previousForm", columnDefinition="varchar(50)")
	private String previousForm;//变更前性质

	@Column(name="previousCommonCode", columnDefinition="varchar(50)")
	private String previousCommonCode;//变更前性质

	@Column(name="previousProviderCode", columnDefinition="varchar(50)")
	private String previousProviderCode;//变更前性质

	@Column(name="formChangeDate", columnDefinition="varchar(50)")
	private String formChangeDate;//性质变更日期

	@Column(name="previousAddress", columnDefinition="text")
	private String previousAddress;//地址变更
	
	@Column(name="changeType", columnDefinition="int(2)")
	private Integer changeType;//变更类型1：曾用名 2：性质变更 3：地址变更


	@Column(name="changeDate", columnDefinition="varchar(20)")
	private String changeDate;//
	
	@Column(name="crefoNo", columnDefinition="varchar(50)")
	private String crefoNo;//公司内部科氏码
	
	@Column(name="updateTime", columnDefinition="varchar(50)")
	private String updateTime;//更新时间
	
	@Column(name="delFlag", columnDefinition="varchar(2)")
	private String delFlag;//删除标志 1：正常


	private Integer fullReportId;//关联企业信息的唯一标识

	public Integer getFullReportId() {
		return fullReportId;
	}

	public void setFullReportId(Integer fullReportId) {
		this.fullReportId = fullReportId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPreviousName() {
		return previousName;
	}

	public void setPreviousName(String previousName) {
		this.previousName = previousName;
	}

	public String getNameChangeDate() {
		return nameChangeDate;
	}

	public void setNameChangeDate(String nameChangeDate) {
		this.nameChangeDate = nameChangeDate;
	}

	public String getPreviousForm() {
		return previousForm;
	}

	public void setPreviousForm(String previousForm) {
		this.previousForm = previousForm;
	}

	public String getPreviousCommonCode() {
		return previousCommonCode;
	}

	public void setPreviousCommonCode(String previousCommonCode) {
		this.previousCommonCode = previousCommonCode;
	}

	public String getPreviousProviderCode() {
		return previousProviderCode;
	}

	public void setPreviousProviderCode(String previousProviderCode) {
		this.previousProviderCode = previousProviderCode;
	}

	public String getFormChangeDate() {
		return formChangeDate;
	}

	public void setFormChangeDate(String formChangeDate) {
		this.formChangeDate = formChangeDate;
	}

	public String getPreviousAddress() {
		return previousAddress;
	}

	public void setPreviousAddress(String previousAddress) {
		this.previousAddress = previousAddress;
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

	public Integer getChangeType() {
		return changeType;
	}

	public void setChangeType(Integer changeType) {
		this.changeType = changeType;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
	}
}
