package com.mika.credit.facade.email.util;

import java.io.Serializable;

/**
 * Created by dong jian hua on 2017/3/16.
 */
public class EmailData<T> implements Serializable {

    //实体类
    private T entity;
    //邮件接收方
    private String dataToAddress;
    //抄送地址
    private String dataCopyToAddress;
    //url(forget需用)
    private String dataUrl;
    //姓名
    private String dataSubject;



    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public String getDataToAddress() {
        return dataToAddress;
    }

    public void setDataToAddress(String dataToAddress) {
        this.dataToAddress = dataToAddress;
    }

    public String getDataUrl() {
        return dataUrl;
    }

    public void setDataUrl(String dataUrl) {
        this.dataUrl = dataUrl;
    }

    public String getDataSubject() {
        return dataSubject;
    }

    public void setDataSubject(String dataSubject) {
        this.dataSubject = dataSubject;
    }

    //    public String getpName() {
//        return pName;
//    }
//
//    public void setpName(String pName) {
//        this.pName = pName;
//    }

    public String getDataCopyToAddress() {
        return dataCopyToAddress;
    }

    public void setDataCopyToAddress(String dataCopyToAddress) {
        this.dataCopyToAddress = dataCopyToAddress;
    }
}
