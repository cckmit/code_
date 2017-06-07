package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;
import com.mika.credit.common.util.DateUtil;


/**
 * 工商行政处罚记录
 * @author ZhuJun，ShenYi
 */
public class PenaltyHis  extends BaseEntity {
    /**
     * ID编号
     */
    private Integer id;
    /**
     * 案发时间
     */
    private String caseDate;
    /**
     *案由
     */
    private String caseReason;
    /**
     *违法行为类型
     */
    private String caseType;
    /**
     *执行类别
     */
    private String executeType;
    /**
     *案件结果
     */
    private String caseResult;
    /**
     *作出行政处罚决定日期
     */
    private String penaltyDecDate;
    /**
     *作出行政处罚决定机关名称
     */
    private String penaltyOrg;
    /**
     *主要违法事实
     */
    private String breakLawFact;
    /**
     *处罚依据
     */
    private String penaltyBasis;
    /**
     *处罚种类
     */
    private String penaltyType;
    /**
     *处罚执行情况
     */
    private String penaltyResult;
    /**
     *处罚金额
     */
    private String penaltyAmt;
    /**
     *行政处罚内容
     */
    private String penaltyExecute;
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

    public PenaltyHis() {this.updateTime = DateUtil.getCurrentDate();}

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getCaseDate() {
        return caseDate;
    }

    public void setCaseDate(String caseDate) {
        this.caseDate = caseDate;
    }

    public String getCaseReason() {
        return caseReason;
    }

    public void setCaseReason(String caseReason) {
        this.caseReason = caseReason;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getExecuteType() {
        return executeType;
    }

    public void setExecuteType(String executeType) {
        this.executeType = executeType;
    }

    public String getCaseResult() {
        return caseResult;
    }

    public void setCaseResult(String caseResult) {
        this.caseResult = caseResult;
    }

    public String getPenaltyDecDate() {
        return penaltyDecDate;
    }

    public void setPenaltyDecDate(String penaltyDecDate) {
        this.penaltyDecDate = penaltyDecDate;
    }

    public String getPenaltyOrg() {
        return penaltyOrg;
    }

    public void setPenaltyOrg(String penaltyOrg) {
        this.penaltyOrg = penaltyOrg;
    }

    public String getBreakLawFact() {
        return breakLawFact;
    }

    public void setBreakLawFact(String breakLawFact) {
        this.breakLawFact = breakLawFact;
    }

    public String getPenaltyBasis() {
        return penaltyBasis;
    }

    public void setPenaltyBasis(String penaltyBasis) {
        this.penaltyBasis = penaltyBasis;
    }

    public String getPenaltyType() {
        return penaltyType;
    }

    public void setPenaltyType(String penaltyType) {
        this.penaltyType = penaltyType;
    }

    public String getPenaltyResult() {
        return penaltyResult;
    }

    public void setPenaltyResult(String penaltyResult) {
        this.penaltyResult = penaltyResult;
    }

    public String getPenaltyAmt() {
        return penaltyAmt;
    }

    public void setPenaltyAmt(String penaltyAmt) {
        this.penaltyAmt = penaltyAmt;
    }

    public String getPenaltyExecute() {
        return penaltyExecute;
    }

    public void setPenaltyExecute(String penaltyExecute) {
        this.penaltyExecute = penaltyExecute;
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
