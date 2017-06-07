package com.mika.credit.common.entity.report.cn;
import com.mika.credit.common.entity.BaseEntity;
import com.mika.credit.common.util.DateUtil;


/**
 * 经营异常
 * @author ZhuJun，ShenYi.
 */
public class OperationAbnormalInfos extends BaseEntity {
	/**
	 * ID编号
	 */
	private Integer id;
	/**
	 * 列入经营异常名录原因
	 */
	private String includeReasons;
	/**
	 * 列入日期
	 */
	private String includeDate;
	/**
	 * 移出经营异常名录原因
	 */
	private String removeReason;
	/**
	 *移出日期
	 */
	private String removeDate;
	/**
	 *作出决定机关
	 */
	private String orgDecision;
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

	public OperationAbnormalInfos() {
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

	public String getIncludeReasons() {
		return includeReasons;
	}

	public void setIncludeReasons(String includeReasons) {
		this.includeReasons = includeReasons;
	}

	public String getIncludeDate() {
		return includeDate;
	}

	public void setIncludeDate(String includeDate) {
		this.includeDate = includeDate;
	}

	public String getRemoveReason() {
		return removeReason;
	}

	public void setRemoveReason(String removeReason) {
		this.removeReason = removeReason;
	}

	public String getRemoveDate() {
		return removeDate;
	}

	public void setRemoveDate(String removeDate) {
		this.removeDate = removeDate;
	}

	public String getOrgDecision() {
		return orgDecision;
	}

	public void setOrgDecision(String orgDecision) {
		this.orgDecision = orgDecision;
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
