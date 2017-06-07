package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;
import com.mika.credit.common.util.DateUtil;

/**
 * 股东链
 * @author ZhuJun，ShenYi.
 * Created on 2016-6-20.
 */
public class ShareholdersChain extends BaseEntity {
	/**
	 * ID编号
	 */
	private Integer id;
	/**
	 * 所处股东链层
	 */
	private String shareLayer;
	/**
	 * 持股公司CN
	 */
	private String shareholdingNameCN;
	/**
	 * 被持股公司CN
	 */
	private String beShareholdingNameCN;
	/**
	 * 持股公司EN
	 */
	private String shareholdingNameEN;
	/**
	 *被持股公司EN
	 */
	private String beShareholdingNameEN;
	/**
	 *股份
	 */
	private String shares;
	/**
	 *删除标识
	 */
	private String delFlag;
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
	

	public ShareholdersChain() {
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

	public String getShareLayer() {
		return shareLayer;
	}

	public void setShareLayer(String shareLayer) {
		this.shareLayer = shareLayer;
	}

	public String getShareholdingNameCN() {
		return shareholdingNameCN;
	}

	public void setShareholdingNameCN(String shareholdingNameCN) {
		this.shareholdingNameCN = shareholdingNameCN;
	}

	public String getBeShareholdingNameCN() {
		return beShareholdingNameCN;
	}

	public void setBeShareholdingNameCN(String beShareholdingNameCN) {
		this.beShareholdingNameCN = beShareholdingNameCN;
	}

	public String getShareholdingNameEN() {
		return shareholdingNameEN;
	}

	public void setShareholdingNameEN(String shareholdingNameEN) {
		this.shareholdingNameEN = shareholdingNameEN;
	}

	public String getBeShareholdingNameEN() {
		return beShareholdingNameEN;
	}

	public void setBeShareholdingNameEN(String beShareholdingNameEN) {
		this.beShareholdingNameEN = beShareholdingNameEN;
	}

	public String getShares() {
		return shares;
	}

	public void setShares(String shares) {
		this.shares = shares;
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
