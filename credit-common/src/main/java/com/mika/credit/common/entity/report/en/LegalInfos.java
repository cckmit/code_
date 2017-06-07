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
@Table(name="LegalInfos")
public class LegalInfos extends BaseEntity implements Serializable {

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
	
	@Column(name="bankruptcy", columnDefinition="varchar(50)")
	private String bankruptcy;//

	@Column(name="taxLienFilings", columnDefinition="varchar(50)")
	private String taxLienFilings;//

	private Integer fullReportId;//fullReportId

	public Integer getFullReportId() {
		return fullReportId;
	}

	public void setFullReportId(Integer fullReportId) {
		this.fullReportId = fullReportId;
	}

	@Column(name="judgmentFilings", columnDefinition="varchar(50)")
	private String judgmentFilings;//

	@Column(name="sum", columnDefinition="varchar(50)")
	private String sum;//

	@Column(name="uCCFilings", columnDefinition="varchar(50)")
	private String uCCFilings;//

	@Column(name="cautionaryUCCFilings", columnDefinition="varchar(50)")
	private String cautionaryUCCFilings;//

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

	public String getBankruptcy() {
		return bankruptcy;
	}

	public void setBankruptcy(String bankruptcy) {
		this.bankruptcy = bankruptcy;
	}

	public String getTaxLienFilings() {
		return taxLienFilings;
	}

	public void setTaxLienFilings(String taxLienFilings) {
		this.taxLienFilings = taxLienFilings;
	}

	public String getJudgmentFilings() {
		return judgmentFilings;
	}

	public void setJudgmentFilings(String judgmentFilings) {
		this.judgmentFilings = judgmentFilings;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	public String getuCCFilings() {
		return uCCFilings;
	}

	public void setuCCFilings(String uCCFilings) {
		this.uCCFilings = uCCFilings;
	}

	public String getCautionaryUCCFilings() {
		return cautionaryUCCFilings;
	}

	public void setCautionaryUCCFilings(String cautionaryUCCFilings) {
		this.cautionaryUCCFilings = cautionaryUCCFilings;
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
