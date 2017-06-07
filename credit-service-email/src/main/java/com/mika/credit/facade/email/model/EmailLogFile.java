package com.mika.credit.facade.email.model;

import java.util.Date;

/**
 * Created by dell on 2017/2/7.
 */
public class EmailLogFile {

    private String invokeObj;

    private String sendMail;

    private String receiveMail;

    private String copytoMail;

    private String mailContent;

    private String mailSubject;

    private String isSuccess;

    private Date startTime;

    private Date endTime;

    public String getInvokeObj() {
        return invokeObj;
    }

    public void setInvokeObj(String invokeObj) {
        this.invokeObj = invokeObj;
    }

    public String getSendMail() {
        return sendMail;
    }

    public void setSendMail(String sendMail) {
        this.sendMail = sendMail;
    }

    public String getReceiveMail() {
        return receiveMail;
    }

    public void setReceiveMail(String receiveMail) {
        this.receiveMail = receiveMail;
    }

    public String getCopytoMail() {
        return copytoMail;
    }

    public void setCopytoMail(String copytoMail) {
        this.copytoMail = copytoMail;
    }

    public String getMailContent() {
        return mailContent;
    }

    public void setMailContent(String mailContent) {
        this.mailContent = mailContent;
    }

    public String getMailSubject() {
        return mailSubject;
    }

    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }

    public String getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
