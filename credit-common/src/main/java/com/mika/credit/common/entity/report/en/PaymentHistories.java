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
@Table(name="PaymentHistories")
public class PaymentHistories extends BaseEntity implements Serializable {

	/**
	 * 支付款记录
	 * @author Nancy
	 * @date 2016-09-27
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Basic
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;//ID编号
	
	@Column(name="term", columnDefinition="varchar(500)")
	private String term;//支付条款
	
	@Column(name="payHistory", columnDefinition="text")
	private String payHistory;//支付历史

	@Column(name="payInfo", columnDefinition="text")
	private String payInfo;//支付信息

	private Integer fullReportId;//fullReportId

	public Integer getFullReportId() {
		return fullReportId;
	}

	public void setFullReportId(Integer fullReportId) {
		this.fullReportId = fullReportId;
	}

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

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getPayHistory() {
		return payHistory;
	}

	public void setPayHistory(String payHistory) {
		this.payHistory = payHistory;
	}

	public String getPayInfo() {
		return payInfo;
	}

	public void setPayInfo(String payInfo) {
		this.payInfo = payInfo;
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

	

}
