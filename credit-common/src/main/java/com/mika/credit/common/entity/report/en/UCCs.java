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
@Table(name="uccs")
public class UCCs extends BaseEntity implements Serializable {

	/**
	 * Ucc表
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

	

	@Column(name="flingNumber", columnDefinition="varchar(50)")
	private String flingNumber;//

	@Column(name="securedParty", columnDefinition="varchar(500)")
	private String securedParty;//
	
	@Column(name="crefoNo", columnDefinition="varchar(50)")
	private String crefoNo;//公司内部科氏码



	@Column(name="uccNote", columnDefinition="Text")
	private String uccNote;//公司内部科氏码
	
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

	public String getFiledDate() {
		return filedDate;
	}

	public void setFiledDate(String filedDate) {
		this.filedDate = filedDate;
	}

	public String getFlingNumber() {
		return flingNumber;
	}

	public void setFlingNumber(String flingNumber) {
		this.flingNumber = flingNumber;
	}

	public String getSecuredParty() {
		return securedParty;
	}

	public void setSecuredParty(String securedParty) {
		this.securedParty = securedParty;
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

	public String getUccNote() {
		return uccNote;
	}

	public void setUccNote(String uccNote) {
		this.uccNote = uccNote;
	}

	

	

	
	
	
	
	

}
