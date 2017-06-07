package com.mika.credit.facade.verify.model;

import java.io.Serializable;
import java.util.Date;

public class MobilephoneName implements Serializable{
    private static final long serialVersionUID = -7145645674925054791L;
    private Integer id;

    private String correctPersonName;

    private String delFlag;

    private String note;

    private String personName;

    private String phone;

    private String sourceFlag;

    private Date updateTime;

    private Date createDate;

    private String timeScore;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorrectPersonName() {
        return correctPersonName;
    }

    public void setCorrectPersonName(String correctPersonName) {
        this.correctPersonName = correctPersonName == null ? null : correctPersonName.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName == null ? null : personName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getSourceFlag() {
        return sourceFlag;
    }

    public void setSourceFlag(String sourceFlag) {
        this.sourceFlag = sourceFlag == null ? null : sourceFlag.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getTimeScore() {
        return timeScore;
    }

    public void setTimeScore(String timeScore) {
        this.timeScore = timeScore == null ? null : timeScore.trim();
    }
}