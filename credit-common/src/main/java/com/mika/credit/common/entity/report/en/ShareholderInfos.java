package com.mika.credit.common.entity.report.en;

import com.mika.credit.common.entity.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ShareholderInfos")
public class ShareholderInfos extends BaseEntity {
	/**
	 * 股东信息
	 * @author Nancy
	 * @date 2016-09-23
	 */
	@Id
	@Basic
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;//ID
	
	@Column(name="shareName", columnDefinition="varchar(50)")
	private String shareName;//股东名称

	@Column(name="shareNominalCapital", columnDefinition="varchar(50)")
	private String shareNominalCapital;//认缴资本

	@Column(name="shareIssuedCapital", columnDefinition="varchar(50)")
	private String shareIssuedCapital;//实缴资本

	@Column(name="sharePercent", columnDefinition="varchar(50)")
	private String sharePercent;//股权

	private Integer fullReportId;//fullReportId

	public Integer getFullReportId() {
		return fullReportId;
	}

	public void setFullReportId(Integer fullReportId) {
		this.fullReportId = fullReportId;
	}

	@Column(name="shareAddress", columnDefinition="varchar(50)")
	private String shareAddress;//股东地址
	
	@Column(name="shareNote", columnDefinition="Text")
	private String shareNote;//备注
	
	@Column(name="crefoNo", columnDefinition="varchar(50)")
	private String crefoNo;//公司内部科氏码
	
	@Column(name="updateTime", columnDefinition="varchar(50)")
	private String updateTime;//更新时间
	
	@Column(name="delFlag", columnDefinition="varchar(2)")
	private String delFlag;//删除标志 1：正常



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShareName() {
		return shareName;
	}

	public void setShareName(String shareName) {
		this.shareName = shareName;
	}

	public String getShareNominalCapital() {
		return shareNominalCapital;
	}

	public void setShareNominalCapital(String shareNominalCapital) {
		this.shareNominalCapital = shareNominalCapital;
	}

	public String getShareIssuedCapital() {
		return shareIssuedCapital;
	}

	public void setShareIssuedCapital(String shareIssuedCapital) {
		this.shareIssuedCapital = shareIssuedCapital;
	}

	public String getSharePercent() {
		return sharePercent;
	}

	public void setSharePercent(String sharePercent) {
		this.sharePercent = sharePercent;
	}

	public String getShareAddress() {
		return shareAddress;
	}

	public void setShareAddress(String shareAddress) {
		this.shareAddress = shareAddress;
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

	public String getShareNote() {
		return shareNote;
	}

	public void setShareNote(String shareNote) {
		this.shareNote = shareNote;
	}
	
	
	
	
	
	

}
