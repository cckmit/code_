package com.mika.credit.facade.globaleagle.core.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/12/19.
 */
public class Message implements Serializable {
    private Integer id;  //默认ID

    private String url;  //URL

    private String content;  //内容

    private String fromId;  //发送ID

    private String toId;  //接收ID

    private String isRead;  //是否已读

    private String isDelete;  //是否删除

    private Date sendTime;  //发送时间

    private Date receiveTime;  //接收时间

    private String status;  //状态

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }

    public String getisDelete() {
        return isDelete;
    }

    public void setisDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}