package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;

/**
 * 海关信息
 * @author ZhuJun，ShenYi.
 */
public class CustomHouse extends BaseEntity{
	/**
	 *ID编号
	 */
	private Integer id;
	/**
	 *海关编码
	 */
	private String code;
	/**
	 *管理类别
	 */
	private String mid;
	/**
	 *报关类别
	 */
	private String cid;
	/**
	 *报关类别
	 */
	private String cidEN;
	/**
	 *注册有效期限
	 */
	private String regData;
	/**
	 *备注CN
	 */
	private String noteCN;
	/**
	 *备注EN
	 */
	private String noteEN;
	/**
	 *科氏号码
	 */
	private String crefoNo;
	/**
	 *删除标识
	 */
	private String delFlag;
	/**
	 *供应商编号
	 */
	private String supplierNum;
	/**
	 *管理类别
	 */
	private String managementCategoriesCN;
	/**
	 *英文管理类别
	 */
	private String managementCategoriesEN;
	/**
	 *报关类别
	 */
	private String customsCollectionsCN;
	/**
	 *英文报关类别
	 */
	private String customsCollectionsEN;
	/**
	 *更新时间
	 */
	private String updateTime;
	/**
	 *关联企业信息的唯一标识
	 */
	private Integer fullReportId;
	

	
	
	
	
	public CustomHouse() {
		super();
	}
	
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getRegData() {
		return regData;
	}

	public void setRegData(String regData) {
		this.regData = regData;
	}


	public String getCrefoNo() {
		return crefoNo;
	}
	public void setCrefoNo(String crefoNo) {
		this.crefoNo = crefoNo;
	}

	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getSupplierNum() {
		return supplierNum;
	}
	public void setSupplierNum(String supplierNum) {
		this.supplierNum = supplierNum;
	}

	public String getManagementCategoriesCN() {
		return managementCategoriesCN;
	}

	public void setManagementCategoriesCN(String managementCategoriesCN) {
		this.managementCategoriesCN = managementCategoriesCN;
	}

	public String getManagementCategoriesEN() {
		return managementCategoriesEN;
	}

	public void setManagementCategoriesEN(String managementCategoriesEN) {
		this.managementCategoriesEN = managementCategoriesEN;
	}

	public String getCustomsCollectionsCN() {
		return customsCollectionsCN;
	}

	public void setCustomsCollectionsCN(String customsCollectionsCN) {
		this.customsCollectionsCN = customsCollectionsCN;
	}

	public String getCustomsCollectionsEN() {
		return customsCollectionsEN;
	}

	public void setCustomsCollectionsEN(String customsCollectionsEN) {
		this.customsCollectionsEN = customsCollectionsEN;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getFullReportId() {
		return fullReportId;
	}

	public void setFullReportId(Integer fullReportId) {
		this.fullReportId = fullReportId;
	}

	public String getCidEN() {
		return cidEN;
	}

	public void setCidEN(String cidEN) {
		this.cidEN = cidEN;
	}

	public String getNoteCN() {
		return noteCN;
	}

	public void setNoteCN(String noteCN) {
		this.noteCN = noteCN;
	}

	public String getNoteEN() {
		return noteEN;
	}

	public void setNoteEN(String noteEN) {
		this.noteEN = noteEN;
	}
}
