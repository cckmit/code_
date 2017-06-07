package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;
import com.mika.credit.common.util.DateUtil;

/**
 *网单黑名单
 * @author ZhuJun，ShenYi.
 */
public class Wdhmd extends BaseEntity {
	/**
	 * ID编号
	 */
	private Integer id;
	/**
	 *裁判文书Id
	 */
	private String wdhmdId;
	/**
	 *贷款时间
	 */
	private String sortTime;
	/**
	 *内容
	 */
	private String body;
	/**
	 *性别
	 */
	private String sex;
	/**
	 *居住电话
	 */
	private String phone;
	/**
	 *信息更新时间
	 */
	private String updateTime;
	/**
	 *执行法院
	 */
	private String execCourt;
	/**
	 *相关当事人
	 */
	private String relatedParty;
	/**
	 *未还/罚息
	 */
	private String whfx;
	/**
	 *身份证号
	 */
	private String idcardNo;
	/**
	 *籍贯地址
	 */
	private String birthPlace;
	/**
	 *本金/本息
	 */
	private String bjbx;
	/**
	 *案号
	 */
	private String caseCode;
	/**
	 *居住地址
	 */
	private String address;
	/**
	 *邮箱地址
	 */
	private String email;
	/**
	 *来源单位名称
	 */
	private String sourceName;
	/**
	 *年龄
	 */
	private String age;
	/**
	 *姓名
	 */
	private String pname;
	/**
	 *数据源
	 */
	private String datasource;
	/**
	 *已还金额
	 */
	private String yhje;
	/**
	 *手机号
	 */
	private String mobile;
	/**
	 *执行法院名称
	 */
	private String court;
	/**
	 *当事人名称
	 */
	private String partyName;
	/**
	 *案号
	 */
	private String docketNo;
	/**
	 *科室号码
	 */
	private String crefoNo;
	/**
	 *关联企业信息的唯一标识
	 */
	private Integer fullReportId;


	public Wdhmd() {
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


	public String getWdhmdId() {
		return wdhmdId;
	}
	public void setWdhmdId(String wdhmdId) {
		this.wdhmdId = wdhmdId;
	}

	public String getSortTime() {
		return sortTime;
	}
	public void setSortTime(String sortTime) {
		this.sortTime = sortTime;
	}

	public String getCourt() {
		return court;
	}
	public void setCourt(String court) {
		this.court = court;
	}

	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getDocketNo() {
		return docketNo;
	}
	public void setDocketNo(String docketNo) {
		this.docketNo = docketNo;
	}

	public String getCrefoNo() {
		return crefoNo;
	}
	public void setCrefoNo(String crefoNo) {
		this.crefoNo = crefoNo;
	}

	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}

	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getExecCourt() {
		return execCourt;
	}
	public void setExecCourt(String execCourt) {
		this.execCourt = execCourt;
	}

	public String getRelatedParty() {
		return relatedParty;
	}
	public void setRelatedParty(String relatedParty) {
		this.relatedParty = relatedParty;
	}

	public String getWhfx() {
		return whfx;
	}
	public void setWhfx(String whfx) {
		this.whfx = whfx;
	}

	public String getIdcardNo() {
		return idcardNo;
	}
	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}

	public String getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getBjbx() {
		return bjbx;
	}
	public void setBjbx(String bjbx) {
		this.bjbx = bjbx;
	}

	public String getCaseCode() {
		return caseCode;
	}
	public void setCaseCode(String caseCode) {
		this.caseCode = caseCode;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}

	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getDatasource() {
		return datasource;
	}
	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}

	public String getYhje() {
		return yhje;
	}
	public void setYhje(String yhje) {
		this.yhje = yhje;
	}

	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
