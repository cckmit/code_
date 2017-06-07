package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;
import com.mika.credit.common.util.DateUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * 字典类型
 * @author ZhuJun，ShenYi.
 * Created on  2014-03-17.
 */
public class DataType extends BaseEntity {
	/**
	 *ID编号
	 */
	private Integer id;

	private String code;

	private String codeName;
	/**
	 *删除标识
	 */
	private String delFlag;

	private Set<BasicData> basicData;
	/**
	 *更新时间
	 */
	private String updateTime;
	/**
	 *关联企业信息的唯一标识
	 */
	private Integer fullReportId;
	
	public DataType(){
		basicData = new HashSet<BasicData>();
		this.updateTime = DateUtil.getCurrentDate();
	}
	
	public void addBasicData(BasicData entity){
		basicData.add(entity);
	}
	
	/*  
	* @OneToMany: 指明Order 与OrderItem关联关系为一对多关系 
	*  
	* mappedBy: 定义类之间的双向关系。如果类之间是单向关系，不需要提供定义，如果类和类之间形成双向关系，我们就需要使用这个属性进行定义， 
	* 否则可能引起数据一致性的问题。 
	*  
	* cascade: CascadeType[]类型。该属性定义类和类之间的级联关系。定义的级联关系将被容器视为对当前类对象及其关联类对象采取相同的操作， 
	* 而且这种关系是递归调用的。举个例子：Order 和OrderItem有级联关系，那么删除Order 时将同时删除它所对应的OrderItem对象。 
	* 而如果OrderItem还和其他的对象之间有级联关系，那么这样的操作会一直递归执行下去。cascade的值只能从CascadeType.PERSIST（级联新建）、 
	* CascadeType.REMOVE（级联删除）、CascadeType.REFRESH（级联刷新）、CascadeType.MERGE（级联更新）中选择一个或多个。 
	* 还有一个选择是使用CascadeType.ALL，表示选择全部四项。 
	*  
	* fatch: 可选择项包括：FetchType.EAGER 和FetchType.LAZY。前者表示关系类(本例是OrderItem类)在主类(本例是Order类)加载的时候 
	* 同时加载;后者表示关系类在被访问时才加载,默认值是FetchType. LAZY。 
	*  
	*/  

	public Set<BasicData> getBasicData() {
		return basicData;
	}

	public void setBasicData(Set<BasicData> basicData) {
		this.basicData = basicData;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
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
