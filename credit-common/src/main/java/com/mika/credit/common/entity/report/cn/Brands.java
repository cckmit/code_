package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;
import com.mika.credit.common.util.DateUtil;

import javax.persistence.*;

/**
 * 品牌专利
 * @author ZhuJun，ShenYi.
 */
public class Brands extends BaseEntity {
	/**
	 * ID编号
	 */
	private Integer id;
	/**
	 *专利名称
	 */
	private String patentName;
	/**
	 *专利名称EN
	 */
	private String patentNameEN;
	/**
	 *申请日期
	 */
	private String applicationDate;
	/**
	 *公开(公告)日
	 */
	private String releaseDate;
	/**
	 *类型
	 */
	private String typeEN;
	/**
	 *类型EN
	 */
	private String type;
	/**
	 *申请号
	 */
	private String applicationNumber;
	/**
	 *主分类号
	 */
	private String classificationNumber;
	/**
	 *科室号码
	 */
	private String crefoNo;
	/**
	 *记录性质
	 */
	private String recordNature;
	/**
	 *信息来源
	 */
	private String infoSource;
	/**
	 *链接
	 */
	private String link;
	/**
	 *优先权
	 */
	private String priority;
	/**
	 *发明人名称
	 */
	private String inventorName;
	/**
	 *申请人
	 */
	private String applyName;
	/**
	 *案件状态
	 */
	private String caseStatus;
	/**
	 *代理信息
	 */
	private String proxyInfo;
	/**
	 *更新时间
	 */
	private String updateTime;
	/**
	 *关联企业信息的唯一标识
	 */
	private Integer fullReportId;

	public Brands() {
		this.updateTime = DateUtil.getCurrentDate();
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getPatentName() {
		return patentName;
	}
	public void setPatentName(String patentName) {
		this.patentName = patentName;
	}
	public String getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}

	public Integer getFullReportId() {
		return fullReportId;
	}
	public void setFullReportId(Integer fullReportId) {
		this.fullReportId = fullReportId;
	}

	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getApplicationNumber() {
		return applicationNumber;
	}
	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}
	public String getClassificationNumber() {
		return classificationNumber;
	}
	public void setClassificationNumber(String classificationNumber) {
		this.classificationNumber = classificationNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getCrefoNo() {
		return crefoNo;
	}

	public void setCrefoNo(String crefoNo) {
		this.crefoNo = crefoNo;
	}
	public String getRecordNature() {
		return recordNature;
	}

	public void setRecordNature(String recordNature) {
		this.recordNature = recordNature;
	}
	public String getInfoSource() {
		return infoSource;
	}

	public void setInfoSource(String infoSource) {
		this.infoSource = infoSource;
	}
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getInventorName() {
		return inventorName;
	}

	public void setInventorName(String inventorName) {
		this.inventorName = inventorName;
	}
	public String getApplyName() {
		return applyName;
	}

	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}
	public String getCaseStatus() {
		return caseStatus;
	}

	public void setCaseStatus(String caseStatus) {
		this.caseStatus = caseStatus;
	}
	public String getProxyInfo() {
		return proxyInfo;
	}

	public void setProxyInfo(String proxyInfo) {
		this.proxyInfo = proxyInfo;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getPatentNameEN() {
		return patentNameEN;
	}

	public void setPatentNameEN(String patentNameEN) {
		this.patentNameEN = patentNameEN;
	}

	public String getTypeEN() {
		return typeEN;
	}

	public void setTypeEN(String typeEN) {
		this.typeEN = typeEN;
	}
}
