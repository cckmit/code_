package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;
import com.mika.credit.common.util.DateUtil;

/**
 * 数据字典表
 * @author Nancy.
 * Created on 2014-03-17.
 */
public class BasicData extends BaseEntity {
	private static final long serialVersionUID = 1L;
	/**
	 *ID编号
	 */
	private Integer id;
	/**
	 *字典类型标识
	 */
	private Integer dictionaryId;
	/**
	 *自定义编号
	 */
	private Integer code;
	/**
	 *中文名称
	 */
	private String valueCN;
	/**
	 *英文名称
	 */
	private String valueEN;
	/**
	 *备注
	 */
	private String remark;
	/**
	 *删除标识
	 */
	private String delFlag;

	private String orderBy;
	/**
	 *序列
	 */
	private String basicCode;
	/**
	 *更新时间
	 */
	private String updateTime;
	/**
	 *关联企业信息的唯一标识
	 */
	private Integer fullReportId;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public BasicData(){
		this.updateTime = DateUtil.getCurrentDate();
	}
	
	public BasicData(Integer id){
		this.id = id;
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

	
	
	/*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public Set<CustomerReportType> getReportType() {
		return reportType;
	}

	public void setReportType(Set<CustomerReportType> reportType) {
		this.reportType = reportType;
	}*/


	public Integer getDictionaryId() {
		return dictionaryId;
	}

	public void setDictionaryId(Integer dictionaryId) {
		this.dictionaryId = dictionaryId;
	}

	public String getValueCN() {
		return valueCN;
	}
	
	public void setValueCN(String valueCN) {
		this.valueCN = valueCN;
	}
	
	public String getValueEN() {
		return valueEN;
	}
	public void setValueEN(String valueEN) {
		this.valueEN = valueEN;
	}
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	public String getBasicCode() {
		return basicCode;
	}

	public void setBasicCode(String basicCode) {
		this.basicCode = basicCode;
	}

	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
	
	
	

}
