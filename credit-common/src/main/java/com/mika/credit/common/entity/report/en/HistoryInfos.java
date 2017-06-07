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
@Table(name="HistoryInfos")
public class HistoryInfos extends BaseEntity implements Serializable {

	/**
	 * 历史背景沿革
	 * @author Nancy
	 * @date 2016-09-26
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Basic
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;//ID编号
	
	@Column(name="establishDate", columnDefinition="varchar(20)")
	private String establishDate;//成立日期
	
	@Column(name="historyDec", columnDefinition="Text")
	private String historyDec;//


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

	public String getEstablishDate() {
		return establishDate;
	}

	public void setEstablishDate(String establishDate) {
		this.establishDate = establishDate;
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

	public String getHistoryDec() {
		return historyDec;
	}

	public void setHistoryDec(String historyDec) {
		this.historyDec = historyDec;
	}
	
	
	

}
