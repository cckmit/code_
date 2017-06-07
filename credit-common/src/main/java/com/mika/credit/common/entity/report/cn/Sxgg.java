package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;
import com.mika.credit.common.util.DateUtil;

/**
 * 失信被执行人
 * @author Diviner.
 * Created on 2016-9-29.
 */
public class Sxgg extends BaseEntity {
	/**
	 * ID编号
	 */
	private Integer id;
	/**
	 * 被执行人名称
	 */
	private String enforceeNameCN;
	/**
	 *被执行人名称
	 */
	private String enforceeNameEN;
	/**
	 *执行法院名称
	 */
	private String entCourtNameCN;
	/**
	 *执行法院名称
	 */
	private String entCourtNameEN;
	/**
	 *中文省份
	 */
	private String provinceCN;
	/**
	 *英文省份
	 */
	private String provinceEN;
	/**
	 *执行依据文号
	 */
	private String enforcementBasisNumberCN ;
	/**
	 *执行依据文号
	 */
	private String enforcementBasisNumberEN ;
	/**
	 *立案时间
	 */
	private String sortTime;
	/**
	 *案号
	 */
	private String docketNoCN;
	/**
	 *案号
	 */
	private String docketNoEN;
	/**
	 *做出依据单位
	 */
	private String basisUnitCN;
	/**
	 *做出依据单位
	 */
	private String basisUnitEN;
	/**
	 *生效法律文书确定的义务
	 */
	private String effectiveObligationCN;
	/**
	 *生效法律文书确定的义务
	 */
	private String effectiveObligationEN;
	/**
	 *被执行人的履行情况
	 */
	private String enforceePerformCN;
	/**
	 *被执行人的履行情况
	 */
	private String enforceePerformEN;
	/**
	 *失信被执行人行为具体情形
	 */
	private String specificCircumstanceCN;
	/**
	 *失信被执行人行为具体情形
	 */
	private String specificCircumstanceEN;
	/**
	 *发布日期
	 */
	private String finishDate;
	/**
	 *删除标识
	 */
	private String delFlag;
	/**
	 *科氏号码
	 */
	private String crefoNo;
	/**
	 *工商导入选中
	 */
	private String childCheck;
	/**
	 *失信公告id
	 */
	private String sxggId;
	/**
	 *性别
	 */
	private String sex;
	/**
	 *相关当事人
	 */
	private String relatedParty;
	/**
	 *身份证/组织机构代码
	 */
	private String idcardNo;
	/**
	 *年龄
	 */
	private String age;
	/**
	 *更新时间
	 */
	private String updateTime;
	/**
	 *关联企业信息的唯一标识
	 */
	private Integer fullReportId;
	/**
	 *内容
	 */
	private String body;
	/**
	 *立案时间
	 */
	private String sortTimeString;
	/**
	 *被执行人的履行情况
	 */
	private String lxqk;
	/**
	 *执行依据文号
	 */
	private String yjCode;
	/**
	 *执行法院名称
	 */
	private String court;
	/**
	 *做出执行依据单位
	 */
	private String yjdw;

	private String dataType;
	/**
	 *失信被执行人行为具体情形
	 */
	private String jtqx;
	/**
	 *生效法律文书确定的义务
	 */
	private String yiwu;
	/**
	 *省份
	 */
	private String province;
	/**
	 *被执行人姓名
	 */
	private String pname;
	/**
	 *案号
	 */
	private String caseNo;
	/**
	 *发布时间
	 */
	private String postTime;
	/**
	 *曝光台ID
	 */
	private String bgtId;
	/**
	 *曝光日期
	 */
	private String bgDate;
	/**
	 *当事人类型
	 */
	private String partyType;
	/**
	 *申请人
	 */
	private String proposer;
	/**
	 *网贷黑名单ID
	 */
	private String wdhmdId;
	/**
	 *居住电话
	 */
	private String phone;
	/**
	 *执行法院
	 */
	private String execCourt;
	/**
	 *未还/罚息
	 */
	private String whfx;
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
	 *时间戳
	 */
	private int sortTimes;
	
	public Sxgg() {
		this.updateTime = DateUtil.getCurrentDate();
	}	

	


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getEnforceeNameCN() {
		return enforceeNameCN;
	}

	public void setEnforceeNameCN(String enforceeNameCN) {
		this.enforceeNameCN = enforceeNameCN;
	}

	public String getEnforceeNameEN() {
		return enforceeNameEN;
	}

	public void setEnforceeNameEN(String enforceeNameEN) {
		this.enforceeNameEN = enforceeNameEN;
	}

	public String getEntCourtNameCN() {
		return entCourtNameCN;
	}

	public void setEntCourtNameCN(String entCourtNameCN) {
		this.entCourtNameCN = entCourtNameCN;
	}

	public String getEntCourtNameEN() {
		return entCourtNameEN;
	}

	public void setEntCourtNameEN(String entCourtNameEN) {
		this.entCourtNameEN = entCourtNameEN;
	}

	public Integer getFullReportId() {
		return fullReportId;
	}

	public void setFullReportId(Integer fullReportId) {
		this.fullReportId = fullReportId;
	}

	public String getProvinceCN() {
		return provinceCN;
	}
	public void setProvinceCN(String provinceCN) {
		this.provinceCN = provinceCN;
	}

	public String getProvinceEN() {
		return provinceEN;
	}
	public void setProvinceEN(String provinceEN) {
		this.provinceEN = provinceEN;
	}

	public String getEnforcementBasisNumberCN() {
		return enforcementBasisNumberCN;
	}
	public void setEnforcementBasisNumberCN(String enforcementBasisNumberCN) {
		this.enforcementBasisNumberCN = enforcementBasisNumberCN;
	}

	public String getEnforcementBasisNumberEN() {
		return enforcementBasisNumberEN;
	}
	public void setEnforcementBasisNumberEN(String enforcementBasisNumberEN) {
		this.enforcementBasisNumberEN = enforcementBasisNumberEN;
	}

	public String getSortTime() {
		return sortTime;
	}
	public void setSortTime(String sortTime) {
		this.sortTime = sortTime;
	}

	public String getDocketNoCN() {
		return docketNoCN;
	}
	public void setDocketNoCN(String docketNoCN) {
		this.docketNoCN = docketNoCN;
	}

	public String getDocketNoEN() {
		return docketNoEN;
	}
	public void setDocketNoEN(String docketNoEN) {
		this.docketNoEN = docketNoEN;
	}

	public String getBasisUnitCN() {
		return basisUnitCN;
	}
	public void setBasisUnitCN(String basisUnitCN) {
		this.basisUnitCN = basisUnitCN;
	}

	public String getBasisUnitEN() {
		return basisUnitEN;
	}
	public void setBasisUnitEN(String basisUnitEN) {
		this.basisUnitEN = basisUnitEN;
	}

	public String getEffectiveObligationCN() {
		return effectiveObligationCN;
	}
	public void setEffectiveObligationCN(String effectiveObligationCN) {
		this.effectiveObligationCN = effectiveObligationCN;
	}

	public String getEffectiveObligationEN() {
		return effectiveObligationEN;
	}
	public void setEffectiveObligationEN(String effectiveObligationEN) {
		this.effectiveObligationEN = effectiveObligationEN;
	}

	public String getEnforceePerformCN() {
		return enforceePerformCN;
	}
	public void setEnforceePerformCN(String enforceePerformCN) {
		this.enforceePerformCN = enforceePerformCN;
	}

	public String getEnforceePerformEN() {
		return enforceePerformEN;
	}
	public void setEnforceePerformEN(String enforceePerformEN) {
		this.enforceePerformEN = enforceePerformEN;
	}

	public String getSpecificCircumstanceCN() {
		return specificCircumstanceCN;
	}
	public void setSpecificCircumstanceCN(String specificCircumstanceCN) {
		this.specificCircumstanceCN = specificCircumstanceCN;
	}

	public String getSpecificCircumstanceEN() {
		return specificCircumstanceEN;
	}
	public void setSpecificCircumstanceEN(String specificCircumstanceEN) {
		this.specificCircumstanceEN = specificCircumstanceEN;
	}

	public String getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}

	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getCrefoNo() {
		return crefoNo;
	}
	public void setCrefoNo(String crefoNo) {
		this.crefoNo = crefoNo;
	}

	public String getChildCheck() {
		return childCheck;
	}
	public void setChildCheck(String childCheck) {
		this.childCheck = childCheck;
	}

	public String getSxggId() {
		return sxggId;
	}

	public void setSxggId(String sxggId) {
		this.sxggId = sxggId;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getRelatedParty() {
		return relatedParty;
	}

	public void setRelatedParty(String relatedParty) {
		this.relatedParty = relatedParty;
	}

	public String getIdcardNo() {
		return idcardNo;
	}

	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getSortTimeString() {
		return sortTimeString;
	}

	public void setSortTimeString(String sortTimeString) {
		sortTimeString = sortTimeString.replace("年", "-");
		sortTimeString = sortTimeString.replace("月", "-");
		sortTimeString = sortTimeString.replace("日", "");
		this.sortTimeString = sortTimeString;
	}

	public String getLxqk() {
		return lxqk;
	}

	public void setLxqk(String lxqk) {
		this.lxqk = lxqk;
	}

	public String getYjCode() {
		return yjCode;
	}

	public void setYjCode(String yjCode) {
		this.yjCode = yjCode;
	}

	public String getCourt() {
		return court;
	}

	public void setCourt(String court) {
		this.court = court;
	}

	public String getYjdw() {
		return yjdw;
	}

	public void setYjdw(String yjdw) {
		this.yjdw = yjdw;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getJtqx() {
		return jtqx;
	}

	public void setJtqx(String jtqx) {
		this.jtqx = jtqx;
	}

	public String getYiwu() {
		return yiwu;
	}

	public void setYiwu(String yiwu) {
		this.yiwu = yiwu;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getPostTime() {
		return postTime;
	}

	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}

	public String getBgtId() {
		return bgtId;
	}

	public void setBgtId(String bgtId) {
		this.bgtId = bgtId;
	}

	public String getBgDate() {
		return bgDate;
	}

	public void setBgDate(String bgDate) {
		this.bgDate = bgDate;
	}

	public String getPartyType() {
		return partyType;
	}

	public void setPartyType(String partyType) {
		this.partyType = partyType;
	}

	public String getProposer() {
		return proposer;
	}

	public void setProposer(String proposer) {
		this.proposer = proposer;
	}

	public String getWdhmdId() {
		return wdhmdId;
	}

	public void setWdhmdId(String wdhmdId) {
		this.wdhmdId = wdhmdId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getExecCourt() {
		return execCourt;
	}

	public void setExecCourt(String execCourt) {
		this.execCourt = execCourt;
	}

	public String getWhfx() {
		return whfx;
	}

	public void setWhfx(String whfx) {
		this.whfx = whfx;
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

	public int getSortTimes() {
		return sortTimes;
	}

	public void setSortTimes(int sortTimes) {
		this.sortTimes = sortTimes;
	}

	public void setSortTimes(String str) {
		int sortTimes = 0;
		try {
			sortTimes = Integer.parseInt(str.toString().substring(0,8));
		} catch (NumberFormatException e) {}
		this.sortTimes = sortTimes;
	}
}
