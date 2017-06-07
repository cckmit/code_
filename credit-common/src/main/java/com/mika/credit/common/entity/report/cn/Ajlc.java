package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;
import com.mika.credit.common.util.DateUtil;

/**
 * 案件流程信息
 *
 * @author ZhuJun，ShenYi.
 *         Created on 2017/2/19.
 */
public class Ajlc extends BaseEntity {
    /**
     * ID编号
     */
    private Integer id;
    /**
     * 案件流程ID
     */
    private String ajlcId;
    /**
     * 法庭成员
     */
    private String member;
    /**
     * 立案时间
     */
    private String sortTime;
    /**
     * 当值员电话
     */
    private String clerkPhone;
    /**
     * 案件类别
     */
    private String caseType;
    /**
     * 内容
     */
    private String body;
    /**
     * 内容 英文
     */
    private String bodyEN;

    /**
     * 审理程序
     */
    private String trialProcedure;
    /**
     * 判决日期
     */
    private String sentencingDate;
    /**
     * 案件状态
     */
    private String caseStatus;
    /**
     * 组织者
     */
    private String organizer;
    /**
     * 归档日期
     */
    private String fillingDate;
    /**
     * 法院名称
     */
    private String court;
    /**
     * 审理状态
     */
    private String ajlcStatus;
    /**
     * 审理状态EN
     */
    private String ajlcStatusEN;
    /**
     * 主要法官
     */
    private String chiefJudge;
    /**
     * 案由
     */
    private String caseCause;
    /**
     * 审判限制日期
     */
    private String trialLimitDate;
    /**
     * 书记员
     */
    private String clerk;
    /**
     * 法官
     */
    private String judge;
    /**
     * 诉讼标的
     */
    private String actionObject;
    /**
     * 当事人
     */
    private String pname;
    /**
     * 当事人EN
     */
    private String pnameEN;
    /**
     * 案号
     */
    private String caseNo;
    /**
     * 案号EN
     */
    private String caseNoEN;
    /**
     * 有效日期
     */
    private String effectiveDate;
    /**
     * 科室号码
     */
    private String crefoNo;
    /**
     * 更新时间
     */
    private String updateTime;
    /**
     * 关联企业信息的唯一标识
     */
    private Integer fullReportId;


    public Ajlc() {
        this.updateTime = DateUtil.getCurrentDate();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAjlcId() {
        return ajlcId;
    }

    public void setAjlcId(String ajlcId) {
        this.ajlcId = ajlcId;
    }


    public Integer getFullReportId() {
        return fullReportId;
    }

    public void setFullReportId(Integer fullReportId) {
        this.fullReportId = fullReportId;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getSortTime() {
        return sortTime;
    }

    public void setSortTime(String sortTime) {
        this.sortTime = sortTime;
    }

    public String getClerkPhone() {
        return clerkPhone;
    }

    public void setClerkPhone(String clerkPhone) {
        this.clerkPhone = clerkPhone;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTrialProcedure() {
        return trialProcedure;
    }

    public void setTrialProcedure(String trialProcedure) {
        this.trialProcedure = trialProcedure;
    }

    public String getSentencingDate() {
        return sentencingDate;
    }

    public void setSentencingDate(String sentencingDate) {
        this.sentencingDate = sentencingDate;
    }

    public String getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getFillingDate() {
        return fillingDate;
    }

    public void setFillingDate(String filingDate) {
        this.fillingDate = filingDate;
    }

    public String getCourt() {
        return court;
    }

    public void setCourt(String court) {
        this.court = court;
    }

    public String getAjlcStatus() {
        return ajlcStatus;
    }

    public void setAjlcStatus(String ajlcStatus) {
        this.ajlcStatus = ajlcStatus;
    }

    public String getChiefJudge() {
        return chiefJudge;
    }

    public void setChiefJudge(String chiefJudge) {
        this.chiefJudge = chiefJudge;
    }

    public String getCaseCause() {
        return caseCause;
    }

    public void setCaseCause(String caseCause) {
        this.caseCause = caseCause;
    }

    public String getTrialLimitDate() {
        return trialLimitDate;
    }

    public void setTrialLimitDate(String trialLimitDate) {
        this.trialLimitDate = trialLimitDate;
    }

    public String getClerk() {
        return clerk;
    }

    public void setClerk(String clerk) {
        this.clerk = clerk;
    }

    public String getJudge() {
        return judge;
    }

    public void setJudge(String judge) {
        this.judge = judge;
    }

    public String getActionObject() {
        return actionObject;
    }

    public void setActionObject(String actionObject) {
        this.actionObject = actionObject;
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

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
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

    public String getAjlcStatusEN() {
        return ajlcStatusEN;
    }

    public void setAjlcStatusEN(String ajlcStatusEN) {
        this.ajlcStatusEN = ajlcStatusEN;
    }

    public String getPnameEN() {
        return pnameEN;
    }

    public void setPnameEN(String pnameEN) {
        this.pnameEN = pnameEN;
    }

    public String getCaseNoEN() {
        return caseNoEN;
    }

    public void setCaseNoEN(String caseNoEN) {
        this.caseNoEN = caseNoEN;
    }

    public String getBodyEN() {
        return bodyEN;
    }

    public void setBodyEN(String bodyEN) {
        this.bodyEN = bodyEN;
    }
}
