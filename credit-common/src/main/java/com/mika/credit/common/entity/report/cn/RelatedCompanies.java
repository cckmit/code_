package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;
import com.mika.credit.common.util.DateUtil;


/**
 * 关联公司信息
 * @author ZhuJun，ShenYi
 * Created on 2014-06-11
 */
public class RelatedCompanies  extends BaseEntity {
	/**
	 * ID编号
	 */
	private Integer id;
	/**
	 *公司中文名
	 */
	private String nameCN;
	/**
	 *公司英文名
	 */
	private String nameEN;
	/**
	 *科氏号码
	 */
	private String crefoNo;
	/**
	 *系统已存在公司的crefoNo
	 */
	private String comCrefoNo;
	/**
	 *关系		rid
	 */
	private Integer relationId;
	/**
	 *电话
	 */
	private String tel;
	/**
	 *地址，个人需要CN
	 */
	private String addressCN;
	/**
	 *地址，个人需要EN
	 */
	private String addressEN;
	/**
	 *中文备注
	 */
	private String noteCN;
	/**
	 *英文备注
	 */
	private String noteEN;
	/**
	 *注册号
	 */
	private String reg;
	/**
	 *成立日期,注册日期
	 */
	private String establishDate;
	/**
	 *企业性质	cpid
	 */
	private Integer companyPropertiesId;
	/**
	 *公司状态	csid
	 */
	private Integer companyStatusId;
	/**
	 *负责人		brprincipal
	 */
	private String principal;
	/**
	 *删除标识
	 */
	private String delFlag;
	/**
	 *公司关系   接口使用 不存入数据库
	 */
	private String relationship;
	/**
	 *公司关系   接口使用 不存入数据库
	 */
	private String relationshipEN;
	/**
	 *公司性质  接口使用 不存入数据库
	 */
	private String entNature;
	/**
	 *公司性质EN  接口使用 不存入数据库
	 */
	private String entNatureEN;
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
	/**
	 *关联企业信息的唯一标识
	 */
	private Integer fullReportId;


	public RelatedCompanies() {
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


	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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

	public Integer getRelationId() {
		return relationId;
	}

	public void setRelationId(Integer relationId) {
		this.relationId = relationId;
	}

	public Integer getCompanyStatusId() {
		return companyStatusId;
	}

	public void setCompanyStatusId(Integer companyStatusId) {
		this.companyStatusId = companyStatusId;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getEntNature() {
		return entNature;
	}

	public void setEntNature(String entNature) {
		this.entNature = entNature;
	}

	public String getEntStatus() {
		return entStatus;
	}

	public void setEntStatus(String entStatus) {
		this.entStatus = entStatus;
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

	public String getEntNatureEN() {
		return entNatureEN;
	}

	public void setEntNatureEN(String entNatureEN) {
		this.entNatureEN = entNatureEN;
	}

	public String getRelationshipEN() {
		return relationshipEN;
	}

	public void setRelationshipEN(String relationshipEN) {
		this.relationshipEN = relationshipEN;
	}

	public String getEntStatusEN() {
		return entStatusEN;
	}

	public void setEntStatusEN(String entStatusEN) {
		this.entStatusEN = entStatusEN;
	}
}
