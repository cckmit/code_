package com.mika.credit.facade.globalsearch.core.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Administrator on 2016/9/2.
 */
public class OrderQuery extends Order {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDateFrom;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDateTo;

    public Date getCreateDateFrom() {
        return createDateFrom;
    }

    public void setCreateDateFrom(Date createDateFrom) {
        this.createDateFrom = createDateFrom;
    }

    public Date getCreateDateTo() {
        return createDateTo;
    }

    public void setCreateDateTo(Date createDateTo) {
        this.createDateTo = createDateTo;
    }
}
