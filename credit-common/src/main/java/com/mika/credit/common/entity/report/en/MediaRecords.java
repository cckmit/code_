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
@Table(name="MediaRecords")
public class MediaRecords extends BaseEntity implements Serializable {

	/**
	 * 媒体记录表
	 * @author Nancy
	 * @date 2014-03-14
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;//ID编号
	private String date;//日期
	private String detailCN ;//中文信息
	private String detailEN;//英文信息
	private String mtid;//媒体类型
	private String delFlag;
	private String crefoNo;
	
	private String supplierNum;//订单号
	
	private String osid;//状态


	
	@Id
	@Basic
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="date")
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Column(name="detailCN")
	public String getDetailCN() {
		return detailCN;
	}
	public void setDetailCN(String detailCN) {
		this.detailCN = detailCN;
	}
	
	@Column(name="detailEN")
	public String getDetailEN() {
		return detailEN;
	}
	public void setDetailEN(String detailEN) {
		this.detailEN = detailEN;
	}
	
	@Column(name="mtid")
	public String getMtid() {
		return mtid;
	}
	public void setMtid(String mtid) {
		this.mtid = mtid;
	}

	private Integer fullReportId;//fullReportId

	public Integer getFullReportId() {
		return fullReportId;
	}

	public void setFullReportId(Integer fullReportId) {
		this.fullReportId = fullReportId;
	}

	@Column(name="crefoNo")
	public String getCrefoNo() {
		return crefoNo;
	}
	public void setCrefoNo(String crefoNo) {
		this.crefoNo = crefoNo;
	}
	
	@Column(name="delFlag")
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	
	@Column(name="supplierNum")
	public String getSupplierNum() {
		return supplierNum;
	}
	public void setSupplierNum(String supplierNum) {
		this.supplierNum = supplierNum;
	}
	
	@Column(name="osid")
	public String getOsid() {
		return osid;
	}
	public void setOsid(String osid) {
		this.osid = osid;
	}

}
