package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;
import com.mika.credit.common.util.DateUtil;

/**
 * 财物说明
 * @author ZhuJun，ShenYi.
 * Created on 2014-03-17.
 */
public class FinancialFigures   extends BaseEntity {
	/**
	 * ID编号
	 */
	private Integer id;

	private Integer informationSourceId;
	/**
	 *中文备注
	 */
	private String noteCN ;
	/**
	 *英文备注
	 */
	private String noteEN;
	/**
	 *中文审计单位
	 */
	private String auditorNameCN;
	/**
	 *英文审计单位
	 */
	private String auditorNameEN;
	/**
	 *中文审计评价
	 */
	private String auditorCommentCN;
	/**
	 *英文审计评价
	 */
	private String auditorCommentEN;
	/**
	 *财物分析
	 */
	private String isFinancial;
	/**
	 *科氏编号
	 */
	private String crefoNo;
	/**
	 *删除标识
	 */
	private String delFlag;
	/**
	 *内部使用
	 */
	private String internalUse;
	/**
	 *财务备注 2016-10-18//因批量财务数据 无法短时间录入系统，所以做一个备注！让订单部知道该报告已有财务，避免重复订购财务
	 */
	private String financialNote;
	/**
	 *更新时间
	 */
	private String updateTime;
	/**
	 *关联企业信息的唯一标识
	 */
	private Integer fullReportId;

	public FinancialFigures() {
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

	public Integer getInformationSourceId() {
		return informationSourceId;
	}

	public void setInformationSourceId(Integer informationSourceId) {
		this.informationSourceId = informationSourceId;
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

	public String getAuditorNameCN() {
		return auditorNameCN;
	}

	public void setAuditorNameCN(String auditorNameCN) {
		this.auditorNameCN = auditorNameCN;
	}

	public String getAuditorNameEN() {
		return auditorNameEN;
	}

	public void setAuditorNameEN(String auditorNameEN) {
		this.auditorNameEN = auditorNameEN;
	}

	public String getAuditorCommentCN() {
		return auditorCommentCN;
	}

	public void setAuditorCommentCN(String auditorCommentCN) {
		this.auditorCommentCN = auditorCommentCN;
	}

	public String getAuditorCommentEN() {
		return auditorCommentEN;
	}

	public void setAuditorCommentEN(String auditorCommentEN) {
		this.auditorCommentEN = auditorCommentEN;
	}

	public String getIsFinancial() {
		return isFinancial;
	}

	public void setIsFinancial(String isFinancial) {
		this.isFinancial = isFinancial;
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

	public String getInternalUse() {
		return internalUse;
	}

	public void setInternalUse(String internalUse) {
		this.internalUse = internalUse;
	}

	public String getFinancialNote() {
		return financialNote;
	}

	public void setFinancialNote(String financialNote) {
		this.financialNote = financialNote;
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
