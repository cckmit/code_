package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;
import com.mika.credit.common.util.DateUtil;

/**
 * 曝光台
 * @author ZhuJun，ShenYi.
 * Created on 2017/2/18.
 */
public class Bgt extends BaseEntity {
    /**
     * ID编号
     */
    private Integer id;
    /**
     * 曝光台ID
     */
    private String bgtId;
    /**
     * 立案日期
     */
    private String sortTime;
    /**
     *内容
     */
    private String body;
    /**
     *曝光日期
     */
    private String bgDate;
    /**
     *当事人类型
     */
    private String partyType;
    /**
     *法院名称
     */
    private String court;
    /**
     *申请人
     */
    private String proposer;
    /**
     *身份证/组织机构代码
     */
    private String idcardNo;
    /**
     *案由
     */
    private String caseCause;
    /**
     *未执行金额
     */
    private String unexecMoney;
    /**
     *地址
     */
    private String address;
    /**
     *当事人
     */
    private String pname;
    /**
     *案号
     */
    private String caseNo;
    /**
     *依据
     */
    private String yiju;
    /**
     *标的金额
     */
    private String execMoney;
    /**
     *科室号码
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
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getBgtId() {
        return bgtId;
    }
    public void setBgtId(String bgtId) {
        this.bgtId = bgtId;
    }
    public String getSortTime() {
        return sortTime;
    }
    public void setSortTime(String sortTime) {
        this.sortTime = sortTime;
    }
    public Integer getFullReportId() {
        return fullReportId;
    }
    public void setFullReportId(Integer fullReportId) {
        this.fullReportId = fullReportId;
    }

    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public String getBgDate() {
        return bgDate;
    }
    public void setBgDate(String bgDate) {
        this.bgDate = bgDate;
    }
    public String getPartyType() {
        return partyType;
    }
    public void setPartyType(String partyType) {
        this.partyType = partyType;
    }
    public String getCourt() {
        return court;
    }
    public void setCourt(String court) {
        this.court = court;
    }
    public String getProposer() {
        return proposer;
    }
    public void setProposer(String proposer) {
        this.proposer = proposer;
    }
    public String getIdcardNo() {
        return idcardNo;
    }
    public void setIdcardNo(String idcardNo) {
        this.idcardNo = idcardNo;
    }
    public String getCaseCause() {
        return caseCause;
    }
    public void setCaseCause(String caseCause) {
        this.caseCause = caseCause;
    }

    public String getUnexecMoney() {
        return unexecMoney;
    }

    public void setUnexecMoney(String unexecMoney) {
        this.unexecMoney = unexecMoney;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
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
    public String getYiju() {
        return yiju;
    }
    public void setYiju(String yiju) {
        this.yiju = yiju;
    }
    public String getExecMoney() {
        return execMoney;
    }
    public void setExecMoney(String execMoney) {
        this.execMoney = execMoney;
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

    public Bgt() {
        this.updateTime = DateUtil.getCurrentDate();
    }
}
