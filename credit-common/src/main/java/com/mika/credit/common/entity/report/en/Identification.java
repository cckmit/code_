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
@Table(name="Identification")
public class Identification extends BaseEntity implements Serializable {

	/**
	 * 标识，用来标记特殊的标签
	 */
	private static final long serialVersionUID = 8366953289681950439L;

	@Id
	@Basic
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;//ID编号
	
	
	@Column(name="crefoNo", columnDefinition="varchar(50)")
	private String crefoNo;//公司内部科氏码
	
	@Column(name="updateTime", columnDefinition="varchar(50)")
	private String updateTime;//更新时间
	
	@Column(name="delFlag", columnDefinition="varchar(2)")
	private String delFlag;//删除标志 1：正常


	@Column(name="isFinancial", columnDefinition="varchar(2)")
	private Integer isFinancial;//财务是否存在
	
	@Column(name="financialContent", columnDefinition="text")
	private String financialContent;
	
	@Column(name="commentsDataSupplied", columnDefinition="text")
	private String commentsDataSupplied;
	
	@Column(name="interviewed", columnDefinition="text")
	private String interviewed;
	
	@Column(name="position", columnDefinition="text")
	private String position;
	
	@Column(name="comments", columnDefinition="text")
	private String comments;
	
	@Column(name="attachPath", columnDefinition="500")
	private String attachPath;


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

	public Integer getIsFinancial() {
		return isFinancial;
	}

	public void setIsFinancial(Integer isFinancial) {
		this.isFinancial = isFinancial;
	}

	public String getFinancialContent() {
		return financialContent;
	}

	public void setFinancialContent(String financialContent) {
		this.financialContent = financialContent;
	}

	public String getCommentsDataSupplied() {
		return commentsDataSupplied;
	}

	public void setCommentsDataSupplied(String commentsDataSupplied) {
		this.commentsDataSupplied = commentsDataSupplied;
	}

	public String getInterviewed() {
		return interviewed;
	}

	public void setInterviewed(String interviewed) {
		this.interviewed = interviewed;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getAttachPath() {
		return attachPath;
	}

	public void setAttachPath(String attachPath) {
		this.attachPath = attachPath;
	}
	
	
	
	
	
}
