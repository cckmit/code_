package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;
import com.mika.credit.common.util.DateUtil;

/**
 * 股权出质记录
 * @author ZhuJun，ShenYi.
 */
public class SharePledgeHis extends BaseEntity {

    /**
     * ID编号
     */
    private Integer id;
    /**
     * 质权人姓名
     */
    private String pawneeName;
    /**
     *出质人类别
     */
    private String pledgeType;
    /**
     *出质金额
     */
    private String pledgeAmt;
    /**
     *出质审批部门
     */
    private String pledgeChkSit;
    /**
     *出质备案日期
     */
    private String pledgeRecDate;
    /**
     *出质批准日期
     */
    private String pledgeAppDate;
    /**
     *出质截至日期
     */
    private String pledgeEndDate;
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

    public SharePledgeHis() {this.updateTime = DateUtil.getCurrentDate();}

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getPawneeName() {
        return pawneeName;
    }

    public void setPawneeName(String pawneeName) {
        this.pawneeName = pawneeName;
    }

    public String getPledgeType() {
        return pledgeType;
    }

    public void setPledgeType(String pledgeType) {
        this.pledgeType = pledgeType;
    }

    public String getPledgeAmt() {
        return pledgeAmt;
    }

    public void setPledgeAmt(String pledgeAmt) {
        this.pledgeAmt = pledgeAmt;
    }

    public String getPledgeChkSit() {
        return pledgeChkSit;
    }

    public void setPledgeChkSit(String pledgeChkSit) {
        this.pledgeChkSit = pledgeChkSit;
    }

    public String getPledgeRecDate() {
        return pledgeRecDate;
    }

    public void setPledgeRecDate(String pledgeRecDate) {
        this.pledgeRecDate = pledgeRecDate;
    }

    public String getPledgeAppDate() {
        return pledgeAppDate;
    }

    public void setPledgeAppDate(String pledgeAppDate) {
        this.pledgeAppDate = pledgeAppDate;
    }

    public String getPledgeEndDate() {
        return pledgeEndDate;
    }

    public void setPledgeEndDate(String pledgeEndDate) {
        this.pledgeEndDate = pledgeEndDate;
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
