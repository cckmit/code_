package com.mika.credit.facade.gugu.model;

import java.util.Date;

public class PublicizePhoto {
    private Integer id;

    private Integer publicizeId;

    private String photoPath;

    private Date updateTime;

    private String delFlag;

    private String orderBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPublicizeId() {
        return publicizeId;
    }

    public void setPublicizeId(Integer publicizeId) {
        this.publicizeId = publicizeId;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath == null ? null : photoPath.trim();
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

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy == null ? null : orderBy.trim();
    }
}