package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;
import com.mika.credit.common.util.DateUtil;

/**
 * 注册变更表
 * @author ZhuJun，ShenYi.
 * Created on 2014-03-14.
 */
public class ChangeInfos extends BaseEntity {
	/**
	 * ID编号
	 */
	private Integer id;
	/**
	 *中文变更前
	 */
	private String beforeCN;
	/**
	 *英文变更前
	 */
	private String beforeEN;
	/**
	 *中文变更后
	 */
	private String afterCN;
	/**
	 *英文变更后
	 */
	private String afterEN;
	/**
	 *变更日期
	 */
	private String changeDate;
	/**
	 *科氏号码
	 */
	private String crefoNo;
	/**
	 *删除标识
	 */
	private String delFlag;
	/**
	 *企业类型
	 */
	private Integer companyTypeId;
	/**
	 *变更类型  接口使用  不存入数据库
	 */
	private String changeType;
	/**
	 *变更类型EN  接口使用  不存入数据库
	 */
	private String changeTypeEN;
	/**
	 *更新时间
	 */
	private String updateTime;
	/**
	 *关联企业信息的唯一标识
	 */
	private Integer fullReportId;

	public Integer getCompanyTypeId() {
		return companyTypeId;
	}

	public void setCompanyTypeId(Integer companyTypeId) {
		this.companyTypeId = companyTypeId;
	}

	public ChangeInfos() {
		this.updateTime = DateUtil.getCurrentDate();
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getBeforeCN() {
		return beforeCN;
	}

	public void setBeforeCN(String beforeCN) {
		this.beforeCN = beforeCN;
	}

	public String getBeforeEN() {
		return beforeEN;
	}

	public void setBeforeEN(String beforeEN) {
		this.beforeEN = beforeEN;
	}

	public String getAfterCN() {
		return afterCN;
	}

	public void setAfterCN(String afterCN) {
		this.afterCN = afterCN;
	}

	public String getAfterEN() {
		return afterEN;
	}

	public void setAfterEN(String afterEN) {
		this.afterEN = afterEN;
	}

	public String getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
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



	public String getChangeType() {
		return changeType;
	}

	public void setChangeType(String changeType) {
		this.changeType = changeType;
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

	public String getChangeTypeEN() {
		return changeTypeEN;
	}

	public void setChangeTypeEN(String changeTypeEN) {
		this.changeTypeEN = changeTypeEN;
	}
}
