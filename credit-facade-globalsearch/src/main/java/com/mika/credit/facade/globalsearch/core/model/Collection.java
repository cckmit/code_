package com.mika.credit.facade.globalsearch.core.model;

import java.io.Serializable;
import java.util.Date;

public class Collection implements Serializable {
    private Integer id;

    private Integer customerId;

    private String collectionCompany;

    private Date collectionTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCollectionCompany() {
        return collectionCompany;
    }

    public void setCollectionCompany(String collectionCompany) {
        this.collectionCompany = collectionCompany;
    }

    public Date getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(Date collectionTime) {
        this.collectionTime = collectionTime;
    }
}