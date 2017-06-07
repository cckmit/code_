package com.mika.credit.common.entity.report.en;

import com.mika.credit.common.entity.BaseEntity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PublicRecords")
public class PublicRecords extends BaseEntity implements Serializable {

	/**
	 * 公共记录表
	 * @author Nancy
	 * @date 2016-09-29
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Basic
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;//ID编号
	
	@Column(name="filedDate", columnDefinition="varchar(50)")
	private String filedDate;//

	@Column(name="filingType", columnDefinition="varchar(50)")
	private String filingType;//

	@Column(name="filedBy", columnDefinition="varchar(50)")
	private String filedBy;//

	@Column(name="status", columnDefinition="varchar(50)")
	private String status;//

	private Integer fullReportId;//fullReportId

	public Integer getFullReportId() {
		return fullReportId;
	}

	public void setFullReportId(Integer fullReportId) {
		this.fullReportId = fullReportId;
	}

	@Column(name="amount", columnDefinition="varchar(50)")
	private String amount;//

	@Column(name="flingNumber", columnDefinition="varchar(50)")
	private String flingNumber;//

	@Column(name="jurisdiction", columnDefinition="varchar(500)")
	private String jurisdiction;//
	
	@Column(name="crefoNo", columnDefinition="varchar(50)")
	private String crefoNo;//公司内部科氏码
	
	@Column(name="updateTime", columnDefinition="varchar(50)")
	private String updateTime;//更新时间
	
	@Column(name="delFlag", columnDefinition="varchar(2)")
	private String delFlag;//删除标志 1：正常

	
	@Column(name="publicNote", columnDefinition="Text")
	private String publicNote;//




	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getFiledDate() {
		return filedDate;
	}

	public void setFiledDate(String filedDate) {
		this.filedDate = filedDate;
	}

	public String getFilingType() {
		return filingType;
	}

	public void setFilingType(String filingType) {
		this.filingType = filingType;
	}

	public String getFiledBy() {
		return filedBy;
	}

	public void setFiledBy(String filedBy) {
		this.filedBy = filedBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getFlingNumber() {
		return flingNumber;
	}

	public void setFlingNumber(String flingNumber) {
		this.flingNumber = flingNumber;
	}

	public String getJurisdiction() {
		return jurisdiction;
	}

	public void setJurisdiction(String jurisdiction) {
		this.jurisdiction = jurisdiction;
	}

	public String getPublicNote() {
		return publicNote;
	}

	public void setPublicNote(String publicNote) {
		this.publicNote = publicNote;
	}
	
	
	
	
	

}
