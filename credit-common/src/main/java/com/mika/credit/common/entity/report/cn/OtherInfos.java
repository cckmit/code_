package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;

public class OtherInfos extends BaseEntity {

	/**
	 * 其他信息
	 * @author ZhuJun，ShenYi
	 * Created on 204-03-17
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ID编号
	 */
	private Integer id;
	/**
	 * 中文名称
	 */
	private String nameCN;
	/**
	 *英文名称
	 */
	private String nameEN;
	/**
	 *中文信息详细
	 */
	private String detailsCN;
	/**
	 *英文信息详细
	 */
	private String detailsEN;
	/**
	 *科氏号码
	 */
	private String crefoNo;
	/**
	 *删除标识
	 */
	private String delFlag;
	/**
	 *关联企业信息的唯一标识
	 */
	private Integer fullReportId;
	/**
	 *更新时间
	 */
	private String updateTime;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameCN() {
		return nameCN;
	}

	public void setNameCN(String nameCN) {
		this.nameCN = nameCN;
	}

	public String getNameEN() {
		return nameEN;
	}

	public void setNameEN(String nameEN) {
		this.nameEN = nameEN;
	}

	public String getDetailsCN() {
		return detailsCN;
	}

	public void setDetailsCN(String detailsCN) {
		this.detailsCN = detailsCN;
	}

	public String getDetailsEN() {
		return detailsEN;
	}

	public void setDetailsEN(String detailsEN) {
		this.detailsEN = detailsEN;
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

	public Integer getFullReportId() {
		return fullReportId;
	}

	public void setFullReportId(Integer fullReportId) {
		this.fullReportId = fullReportId;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
}
