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
@Table(name="Operatings")
public class Operatings extends BaseEntity implements Serializable {

	/**
	 * 经营现状表
	 * @author Nancy
	 * @date 2016-09-26
	 */
	private static final long serialVersionUID = 1L;
	
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
	
	@Column(name="activityCode", columnDefinition="varchar(50)")
	private String activityCode;//主营代码

	private Integer fullReportId;//fullReportId

	public Integer getFullReportId() {
		return fullReportId;
	}

	public void setFullReportId(Integer fullReportId) {
		this.fullReportId = fullReportId;
	}

	@Column(name="activityDescription", columnDefinition="text")
	private String activityDescription;//主营描述

	@Column(name="businessOverview", columnDefinition="text")
	private String businessOverview;//业务概况

	@Column(name="brands", columnDefinition="text")
	private String brands;//品牌

	@Column(name="employeeInfo", columnDefinition="varchar(50)")
	private String employeeInfo;//员工信息

	@Column(name="year", columnDefinition="varchar(50)")
	private String year;//记录年限

	@Column(name="employeeNum", columnDefinition="varchar(50)")
	private String employeeNum;//员工人数

	@Column(name="operationsArea", columnDefinition="text")
	private String operationsArea;//经营地区

	@Column(name="importArea", columnDefinition="varchar(500)")
	private String importArea;//进口地区

	@Column(name="exportArea", columnDefinition="varchar(500)")
	private String exportArea;//出口地区

	@Column(name="competitors", columnDefinition="text")
	private String competitors;//竞争者
	
	
	
	
	@Column(name="salesAre", columnDefinition="text")
	private String salesAre;//
	
	@Column(name="clients", columnDefinition="text")
	private String clients;//
	
	@Column(name="suppliers", columnDefinition="text")
	private String suppliers;//
	
	@Column(name="tradeReferences", columnDefinition="text")
	private String tradeReferences;//
	
	@Column(name="termsPayment", columnDefinition="text")
	private String termsPayment;//
	
	@Column(name="commentsStaff", columnDefinition="text")
	private String commentsStaff;//
	
	@Column(name="otherComment", columnDefinition="text")
	private String otherComment;//
	
	@Column(name="mainBusiness", columnDefinition="text")
	private String mainBusiness;//




	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getActivityCode() {
		return activityCode;
	}

	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	public String getActivityDescription() {
		return activityDescription;
	}

	public void setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
	}

	public String getBusinessOverview() {
		return businessOverview;
	}

	public void setBusinessOverview(String businessOverview) {
		this.businessOverview = businessOverview;
	}

	public String getBrands() {
		return brands;
	}

	public void setBrands(String brands) {
		this.brands = brands;
	}

	public String getEmployeeInfo() {
		return employeeInfo;
	}

	public void setEmployeeInfo(String employeeInfo) {
		this.employeeInfo = employeeInfo;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getEmployeeNum() {
		return employeeNum;
	}

	public void setEmployeeNum(String employeeNum) {
		this.employeeNum = employeeNum;
	}

	public String getOperationsArea() {
		return operationsArea;
	}

	public void setOperationsArea(String operationsArea) {
		this.operationsArea = operationsArea;
	}

	public String getImportArea() {
		return importArea;
	}

	public void setImportArea(String importArea) {
		this.importArea = importArea;
	}

	public String getExportArea() {
		return exportArea;
	}

	public void setExportArea(String exportArea) {
		this.exportArea = exportArea;
	}

	public String getCompetitors() {
		return competitors;
	}

	public void setCompetitors(String competitors) {
		this.competitors = competitors;
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

	public String getSalesAre() {
		return salesAre;
	}

	public void setSalesAre(String salesAre) {
		this.salesAre = salesAre;
	}

	public String getClients() {
		return clients;
	}

	public void setClients(String clients) {
		this.clients = clients;
	}

	public String getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(String suppliers) {
		this.suppliers = suppliers;
	}

	public String getTradeReferences() {
		return tradeReferences;
	}

	public void setTradeReferences(String tradeReferences) {
		this.tradeReferences = tradeReferences;
	}

	public String getTermsPayment() {
		return termsPayment;
	}

	public void setTermsPayment(String termsPayment) {
		this.termsPayment = termsPayment;
	}

	public String getCommentsStaff() {
		return commentsStaff;
	}

	public void setCommentsStaff(String commentsStaff) {
		this.commentsStaff = commentsStaff;
	}

	public String getOtherComment() {
		return otherComment;
	}

	public void setOtherComment(String otherComment) {
		this.otherComment = otherComment;
	}

	public String getMainBusiness() {
		return mainBusiness;
	}

	public void setMainBusiness(String mainBusiness) {
		this.mainBusiness = mainBusiness;
	}
	
	
}
