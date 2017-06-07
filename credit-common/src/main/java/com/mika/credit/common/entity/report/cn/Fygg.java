package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;
import com.mika.credit.common.util.DateUtil;

/**
 * 法院公告
 * @author ZhuJun，ShenYi.
 */
public class Fygg  extends BaseEntity {
    /**
     * ID编号
     */
    private Integer id;
    /**
     * 失信公告ID
     */
    private String fyggId;
    /**
     *发布时间
     */
    private String sortTime;
    /**
     *内容
     */
    private String body;
    /**
     *内容 英文
     */
    private String bodyEN;
    /**
     *版面
     */
    private String layout;
    /**
     *相关当事人
     */
    private String relatedParty;
    /**
     *姓名
     */
    private String pname;
    /**
     *姓名 英文
     */
    private String pnameEN;
    /**
     *法院名称
     */
    private String court;
    /**
     *法院名称 英文
     */
    private String courtEN;

    /**
     *公告类型
     */
    private String noticeType;
    /**
     *公告类型 英文
     */
    private String noticeTypeEN;

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

    public Fygg() {
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

    public void setFyggId(String fyggId) {
        this.fyggId = fyggId;
    }

    public String getFyggId() {
        return fyggId;
    }

    public String getSortTime() {
        return sortTime;
    }

    public void setSortTime(String sortTime) {
        this.sortTime = sortTime;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getRelatedParty() {
        return relatedParty;
    }

    public void setRelatedParty(String relatedParty) {
        this.relatedParty = relatedParty;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getCourt() {
        return court;
    }

    public void setCourt(String court) {
        this.court = court;
    }

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
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

    public String getPnameEN() {
        return pnameEN;
    }

    public void setPnameEN(String pnameEN) {
        this.pnameEN = pnameEN;
    }

    public String getCourtEN() {
        return courtEN;
    }

    public void setCourtEN(String courtEN) {
        this.courtEN = courtEN;
    }

    public String getNoticeTypeEN() {
        return noticeTypeEN;
    }

    public void setNoticeTypeEN(String noticeTypeEN) {
        this.noticeTypeEN = noticeTypeEN;
    }

    public String getBodyEN() {
        return bodyEN;
    }

    public void setBodyEN(String bodyEN) {
        this.bodyEN = bodyEN;
    }
}
