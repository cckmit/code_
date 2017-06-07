package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;
import com.mika.credit.common.util.DateUtil;

/**
 * 支付款记录
 * @author ZhuJun，ShenYi
 * Created on 2014-03-17
 */
public class PaymentHistories  extends BaseEntity {
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
	 *中文主要供应商品
	 */
	private String mainSuppliersCN;
	/**
	 *英文主要供应商品
	 */
	private String mainSuppliersEN;
	/**
	 *访问电话
	 */
	private String tel;
	/**
	 *联系日期
	 */
	private String date;
	/**
	 *采访对象CN
	 */
	private String interviewedCN;
	/**
	 *采访对象EN
	 */
	private String interviewedEN;
	/**
	 *支付模式  ppid
	 */
	private String paymentPatternId;
	/**
	 *支付方式 ptid
	 */
	private String paymentTermsId;
	/**
	 *中文拖欠付款情况
	 */
	private String paymentCN;
	/**
	 *英文拖欠付款情况
	 */
	private String paymentEN;
	/**
	 *中文债务催收情况
	 */
	private String collectionCN;
	/**
	 *英文债务催收情况
	 */
	private String collectionEN;
	/**
	 *科氏号码
	 */
	private String crefoNo;
	/**
	 *针对系统已存在或者新建的公司的crefoNo
	 */
	private String comCrefoNo;
	/**
	 *删除标识
	 */
	private String delFlag;
	/**
	 *关联企业信息的唯一标识
	 */
	private Integer fullReportId;
	/**
	 *支付模式
	 */
	private String paymentMode;
	/**
	 *支付模式EN
	 */
	private String paymentModeEN;
	/**
	 *支付方式
	 */
	private String paymentMethod;
	/**
	 *支付方式EN
	 */
	private String paymentMethodEN;
	/**
	 *更新时间
	 */
	private String updateTime;

	public PaymentHistories() {
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

	public String getMainSuppliersCN() {
		return mainSuppliersCN;
	}

	public void setMainSuppliersCN(String mainSuppliersCN) {
		this.mainSuppliersCN = mainSuppliersCN;
	}

	public String getMainSuppliersEN() {
		return mainSuppliersEN;
	}

	public void setMainSuppliersEN(String mainSuppliersEN) {
		this.mainSuppliersEN = mainSuppliersEN;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getInterviewedCN() {
		return interviewedCN;
	}

	public void setInterviewedCN(String interviewedCN) {
		this.interviewedCN = interviewedCN;
	}

	public String getInterviewedEN() {
		return interviewedEN;
	}

	public void setInterviewedEN(String interviewedEN) {
		this.interviewedEN = interviewedEN;
	}

	public String getPaymentPatternId() {
		return paymentPatternId;
	}

	public void setPaymentPatternId(String paymentPatternId) {
		this.paymentPatternId = paymentPatternId;
	}

	public String getPaymentTermsId() {
		return paymentTermsId;
	}

	public void setPaymentTermsId(String paymentTermsId) {
		this.paymentTermsId = paymentTermsId;
	}

	public String getPaymentCN() {
		return paymentCN;
	}

	public void setPaymentCN(String paymentCN) {
		this.paymentCN = paymentCN;
	}

	public String getPaymentEN() {
		return paymentEN;
	}

	public void setPaymentEN(String paymentEN) {
		this.paymentEN = paymentEN;
	}

	public String getCollectionCN() {
		return collectionCN;
	}

	public void setCollectionCN(String collectionCN) {
		this.collectionCN = collectionCN;
	}

	public String getCollectionEN() {
		return collectionEN;
	}

	public void setCollectionEN(String collectionEN) {
		this.collectionEN = collectionEN;
	}

	public String getCrefoNo() {
		return crefoNo;
	}

	public void setCrefoNo(String crefoNo) {
		this.crefoNo = crefoNo;
	}

	public String getComCrefoNo() {
		return comCrefoNo;
	}

	public void setComCrefoNo(String comCrefoNo) {
		this.comCrefoNo = comCrefoNo;
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

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getPaymentModeEN() {
		return paymentModeEN;
	}

	public void setPaymentModeEN(String paymentModeEN) {
		this.paymentModeEN = paymentModeEN;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentMethodEN() {
		return paymentMethodEN;
	}

	public void setPaymentMethodEN(String paymentMethodEN) {
		this.paymentMethodEN = paymentMethodEN;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
}
