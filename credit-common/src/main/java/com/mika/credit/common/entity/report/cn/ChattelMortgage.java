package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;
import com.mika.credit.common.util.DateUtil;

/**
 * 动产抵押登记信息
 * @author ZhuJun，ShenYi.
 * */
public class ChattelMortgage extends BaseEntity {
	/**
	 * ID编号
	 */
	private Integer id;
	/**
	 *登记编号
	 */
	private String registrationNo;
	/**
	 *登记日期
	 */
	private String registrationDate;
	/**
	 *登记机关
	 */
	private String registrationOffices;
	/**
	 *被担保债权数额
	 */
	private String amount;
	/**
	 *状态
	 */
	private String status;
	/**
	 *详情
	 */
	private String details;
	/**
	 *科氏号码
	 */
	private String crefoNo;
	/**
	 *更新时间
	 */
	private String updateTime;
	/**
	 *关联企业信息的唯一标识
	 */
	private Integer fullReportId;

	public ChattelMortgage() {
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

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getRegistrationOffices() {
		return registrationOffices;
	}

	public void setRegistrationOffices(String registrationOffices) {
		this.registrationOffices = registrationOffices;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
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

	public Integer getFullReportId() {
		return fullReportId;
	}

	public void setFullReportId(Integer fullReportId) {
		this.fullReportId = fullReportId;
	}
}
