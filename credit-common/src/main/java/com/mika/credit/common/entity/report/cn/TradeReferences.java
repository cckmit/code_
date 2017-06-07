package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;


public class TradeReferences extends BaseEntity {

	/**
	 * 贸易参考
	 * @author ZhuJun，ShenYi.
	 * Created on 2014-03-17.
	 */
	private static final long serialVersionUID = 1L;
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
	 *电话
	 */
	private String tel;
	/**
	 *中文备注
	 */
	private String noteCN;
	/**
	 *英文备注
	 */
	private String noteEN;
	/**
	 *科氏号码
	 */
	private String crefoNo;
	/**
	 *系统已存在公司的crefoNo
	 */
	private String comCrefoNo;
	/**
	 *删除标识
	 */
	private String delFlag;
	/**
	 *0:供应商，1表示客户
	 */
	private String flag;
	/**
	 *注册号
	 */
	private String reg;
	/**
	 *成立日期,注册日期
	 */
	private String establishDate;
	/**
	 *企业性质cpid
	 */
	private Integer companyPropertiesId;
	/**
	 *公司状态	csid
	 */
	private Integer companyStatusId;
	/**
	 *合作日期
	 */
	private String cooperationDate;
	/**
	 *关联企业信息的唯一标识
	 */
	private Integer fullReportId;
	/**
	 *企业性质  接口使用  不存入数据库
	 */
	private String enterprisenature;
	/**
	 *企业性质  接口使用  不存入数据库
	 */
	private String enterprisenatureEN;
	/**
	 *企业状态  接口使用 不存入数据库
	 */
	private String entStatus;
	/**
	 *企业状态  接口使用 不存入数据库
	 */
	private String entStatusEN;
	/**
	 *更新时间
	 */
	private String updateTime;
	//private String updateTime;

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

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getReg() {
		return reg;
	}

	public void setReg(String reg) {
		this.reg = reg;
	}

	public String getEstablishDate() {
		return establishDate;
	}

	public void setEstablishDate(String establishDate) {
		this.establishDate = establishDate;
	}

	public Integer getCompanyPropertiesId() {
		return companyPropertiesId;
	}

	public void setCompanyPropertiesId(Integer companyPropertiesId) {
		this.companyPropertiesId = companyPropertiesId;
	}

	public Integer getCompanyStatusId() {
		return companyStatusId;
	}

	public void setCompanyStatusId(Integer companyStatusId) {
		this.companyStatusId = companyStatusId;
	}

	public String getCooperationDate() {
		return cooperationDate;
	}

	public void setCooperationDate(String cooperationDate) {
		this.cooperationDate = cooperationDate;
	}

	public Integer getFullReportId() {
		return fullReportId;
	}

	public void setFullReportId(Integer fullReportId) {
		this.fullReportId = fullReportId;
	}

	public String getEnterprisenature() {
		return enterprisenature;
	}

	public void setEnterprisenature(String enterprisenature) {
		this.enterprisenature = enterprisenature;
	}

	public String getEnterprisenatureEN() {
		return enterprisenatureEN;
	}

	public void setEnterprisenatureEN(String enterprisenatureEN) {
		this.enterprisenatureEN = enterprisenatureEN;
	}

	public String getEntStatus() {
		return entStatus;
	}

	public void setEntStatus(String entStatus) {
		this.entStatus = entStatus;
	}

	public String getEntStatusEN() {
		return entStatusEN;
	}

	public void setEntStatusEN(String entStatusEN) {
		this.entStatusEN = entStatusEN;
	}

	/*public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}*/
}
