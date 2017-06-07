package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;
import com.mika.credit.common.util.DateUtil;


/**
 * 股权冻结记录
 * @author ZhuJun，ShenYi.
 */
public class ShareFrozenHis  extends BaseEntity {
    /**
     * ID编号
     */
    private Integer id;
    /**
     * 冻结文号
     */
    private String fileNo;
    /**
     * 冻结机关
     */
    private String orgName;
    /**
     *冻结起始日期
     */
    private String beginDate;
    /**
     *冻结截至日期
     */
    private String endDate;
    /**
     *冻结金额
     */
    private String frozenAmount;
    /**
     *解冻机关
     */
    private String disOrgName;
    /**
     *解冻文号
     */
    private String disFileNo;
    /**
     *解冻日期
     */
    private String disDate;
    /**
     *解冻说明
     */
    private String disDesc;
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

    public ShareFrozenHis() {this.updateTime = DateUtil.getCurrentDate();}

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileNo() {
        return fileNo;
    }

    public void setFileNo(String fileNo) {
        this.fileNo = fileNo;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getFrozenAmount() {
        return frozenAmount;
    }

    public void setFrozenAmount(String frozenAmount) {
        this.frozenAmount = frozenAmount;
    }

    public String getDisOrgName() {
        return disOrgName;
    }

    public void setDisOrgName(String disOrgName) {
        this.disOrgName = disOrgName;
    }

    public String getDisFileNo() {
        return disFileNo;
    }

    public void setDisFileNo(String disFileNo) {
        this.disFileNo = disFileNo;
    }

    public String getDisDate() {
        return disDate;
    }

    public void setDisDate(String disDate) {
        this.disDate = disDate;
    }

    public String getDisDesc() {
        return disDesc;
    }

    public void setDisDesc(String disDesc) {
        this.disDesc = disDesc;
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
