package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;
import com.mika.credit.common.util.DateUtil;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 银行信息
 * @author ZhuJun，ShenYi.
 * Created on 2014-03-17.
 */
public class BankInfos extends BaseEntity{
	/**
	 * ID编号
	 */
	private Integer id;
	/**
	 *中文名称
	 */
	private String nameCN;
	/**
	 *英文名称
	 */
	private String nameEN;
	/**
	 *中文地址
	 */
	private String addressCN;
	/**
	 *英文地址
	 */
	private String addressEN;
	/**
	 *账号
	 */
	private String account;
	/**
	 *中文银行评价
	 */
	private String commentCN;
	/**
	 *英文银行评价
	 */
	private String commentEN;
	/**
	 *访问电话
	 */
	private String tel;
	/**
	 *联系日期
	 */
	private String date;
	/**
	 *采访对象
	 */
	private String interviewedCN;
	/**
	 *采访对象
	 */
	private String interviewedEN;
	/**
	 *科氏号码
	 */
	private String crefoNo;
	/**
	 *系统已存在公司的crefoNo
	 */
	private String comCrefoNo;
	/**
	 *中文备注
	 */
	private String noteCN;
	/**
	 *英文备注
	 */
	private String noteEN;
	/**
	 *删除标识
	 */
	private String delFlag;
	/**
	 *中文质押
	 */
	private String pledgeCN;
	/**
	 *英文质押
	 */
	private String pledgeEN;
	/**
	 *信用额度
	 */
	private String credits;
	/**
	 *不良贷款
	 */
	private String badLoans;
	/**
	 *贷款总额
	 */
	private String loansTotal;
	/**
	 *更新时间
	 */
	private String updateTime;
	/**
	 *关联企业信息的唯一标识
	 */
	private Integer fullReportId;


	public BankInfos() {
		this.updateTime = DateUtil.getCurrentDate();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFullReportId() {
		return fullReportId;
	}
	public void setFullReportId(Integer fullReportId) {
		this.fullReportId = fullReportId;
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

	
	public String getAddressCN() {
		return addressCN;
	}
	public void setAddressCN(String addressCN) {
		this.addressCN = addressCN;
	}
	
	public String getAddressEN() {
		return addressEN;
	}
	public void setAddressEN(String addressEN) {
		this.addressEN = addressEN;
	}
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	public String getCommentCN() {
		return commentCN;
	}
	public void setCommentCN(String commentCN) {
		this.commentCN = commentCN;
	}
	
	public String getCommentEN() {
		return commentEN;
	}
	public void setCommentEN(String commentEN) {
		this.commentEN = commentEN;
	}
	
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getCrefoNo() {
		return crefoNo;
	}
	public void setCrefoNo(String crefoNo) {
		this.crefoNo = crefoNo;
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
	
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	
	public String getComCrefoNo() {
		return comCrefoNo;
	}
	public void setComCrefoNo(String comCrefoNo) {
		this.comCrefoNo = comCrefoNo;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	public String getPledgeCN() {
		return pledgeCN;
	}
	public void setPledgeCN(String pledgeCN) {
		this.pledgeCN = pledgeCN;
	}
	
	public String getPledgeEN() {
		return pledgeEN;
	}
	public void setPledgeEN(String pledgeEN) {
		this.pledgeEN = pledgeEN;
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
	public String getCredits() {
		return credits;
	}
	public void setCredits(String credits) {
		this.credits = credits;
	}
	public String getBadLoans() {
		return badLoans;
	}
	public void setBadLoans(String badLoans) {
		this.badLoans = badLoans;
	}
	public String getLoansTotal() {
		return loansTotal;
	}
	public void setLoansTotal(String loansTotal) {
		this.loansTotal = loansTotal;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
	
	
	
	
	
	
	

}
