package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;
import com.mika.credit.common.util.DateUtil;


/**
 * 历史背景沿革
 * @author ZhuJun，ShenYi.
 * @date 2014-03-14.
 */
public class HistoryInfos extends BaseEntity {
	/**
	 * ID编号
	 */
	private Integer id;
	/**
	 * 日期
	 */
	private String date;
	/**
	 *来自目标公司中文
	 */
	private String detailCN;
	/**
	 *来自目标公司英文
	 */
	private String detailEN;
	/**
	 *科氏号码
	 */
	private String crefoNo;
	/**
	 *删除标记
	 */
	private String delFlag;
	/**
	 *更新时间
	 */
	private String updateTime;
	/**
	 *关联企业信息的唯一标识
	 */
	private Integer fullReportId;


	public HistoryInfos() {
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDetailCN() {
		return detailCN;
	}

	public void setDetailCN(String detailCN) {
		this.detailCN = detailCN;
	}

	public String getDetailEN() {
		return detailEN;
	}

	public void setDetailEN(String detailEN) {
		this.detailEN = detailEN;
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
}
