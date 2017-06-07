package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;


/**
 * 分析评估
 * @author ZhuJun，ShenYi.
 * Created on 2014-07-03.
 */
public class CreditAssessments extends BaseEntity {
	/**
	 * ID编号
	 */
	private Integer id;
	/**
	 * 信用评级
	 */
	private Integer rrid;
	/**
	 *中文分析
	 */
	private String creditAnalysisCN ;
	/**
	 *英文分析
	 */
	private String creditAnalysisEN;
	/**
	 *中文信用评价
	 */
	private String creditOpinionCN;
	/**
	 *英文信用评价
	 */
	private String creditOpinionEN;
	/**
	 *偿还指数
	 */
	private String solvencyIndex;
	/**
	 *偿还微调
	 */
	private String solvencyIndexOffset;
	/**
	 *最终偿还指数
	 */
	private String resultSolvency;
	/**
	 *全球鹰最终偿还指数
	 */
	private String globalSolvency;
	/**
	 *信用额度
	 */
	private String recommended;
	/**
	 *信用微调
	 */
	private String recommendedOffset;
	/**
	 *最终信用额度
	 */
	private String resultRecommended;
	/**
	 *科氏号码
	 */
	private String crefoNo;
	/**
	 *删除标识
	 */
	private String delFlag;
	/**
	 *关联企业信息的唯一标识
	 */
	private Integer fullReportId;
	/**
	 *信用评级  接口使用
	 */
	private String creditRating;
	/**
	 *信用评级EN  接口使用
	 */
	private String creditRatingEN;
	/**
	 *更新时间
	 */
	private String updateTime;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRrid() {
		return rrid;
	}

	public void setRrid(Integer rrid) {
		this.rrid = rrid;
	}

	public String getCreditAnalysisCN() {
		return creditAnalysisCN;
	}

	public void setCreditAnalysisCN(String creditAnalysisCN) {
		this.creditAnalysisCN = creditAnalysisCN;
	}

	public String getCreditAnalysisEN() {
		return creditAnalysisEN;
	}

	public void setCreditAnalysisEN(String creditAnalysisEN) {
		this.creditAnalysisEN = creditAnalysisEN;
	}

	public String getCreditOpinionCN() {
		return creditOpinionCN;
	}

	public void setCreditOpinionCN(String creditOpinionCN) {
		this.creditOpinionCN = creditOpinionCN;
	}

	public String getCreditOpinionEN() {
		return creditOpinionEN;
	}

	public void setCreditOpinionEN(String creditOpinionEN) {
		this.creditOpinionEN = creditOpinionEN;
	}

	public String getSolvencyIndex() {
		return solvencyIndex;
	}

	public void setSolvencyIndex(String solvencyIndex) {
		this.solvencyIndex = solvencyIndex;
	}

	public String getSolvencyIndexOffset() {
		return solvencyIndexOffset;
	}

	public void setSolvencyIndexOffset(String solvencyIndexOffset) {
		this.solvencyIndexOffset = solvencyIndexOffset;
	}

	public String getResultSolvency() {
		return resultSolvency;
	}

	public void setResultSolvency(String resultSolvency) {
		this.resultSolvency = resultSolvency;
	}

	public String getRecommended() {
		return recommended;
	}

	public void setRecommended(String recommended) {
		this.recommended = recommended;
	}

	public String getRecommendedOffset() {
		return recommendedOffset;
	}

	public void setRecommendedOffset(String recommendedOffset) {
		this.recommendedOffset = recommendedOffset;
	}

	public String getResultRecommended() {
		return resultRecommended;
	}

	public void setResultRecommended(String resultRecommended) {
		this.resultRecommended = resultRecommended;
	}

	public String getCrefoNo() {
		return crefoNo;
	}

	public void setCrefoNo(String crefoNo) {
		this.crefoNo = crefoNo;
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

	public String getCreditRating() {
		return creditRating;
	}

	public void setCreditRating(String creditRating) {
		this.creditRating = creditRating;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreditRatingEN() {
		return creditRatingEN;
	}

	public void setCreditRatingEN(String creditRatingEN) {
		this.creditRatingEN = creditRatingEN;
	}

	public String getGlobalSolvency() {
		return globalSolvency;
	}

	public void setGlobalSolvency(String globalSolvency) {
		this.globalSolvency = globalSolvency;
	}
}
