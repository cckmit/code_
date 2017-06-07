package com.mika.credit.facade.gugu.model;

import java.io.Serializable;
import java.util.Date;

public class CardNote implements Serializable {
    private Integer id;

    private Integer userId;

    private String title;

    private String content;

    private Date updateTime;

    private String delFlag;

    private String addFlag;

    private Integer businessCardId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBusinessCardId() {
        return businessCardId;
    }

    public void setBusinessCardId(Integer businessCardId) {
        this.businessCardId = businessCardId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getAddFlag() {
        return addFlag;
    }

    public void setAddFlag(String addFlag) {
        this.addFlag = addFlag == null ? null : addFlag.trim();
    }
}