package com.mika.credit.facade.record.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CustomerBehaviorQuery extends CustomerBehavior {
    private static final long serialVersionUID = 1L;
    /**
     * 创建时间结束
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDateTo;
    /**
     * 创建时间开始
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDateFrom;

    public Date getCreateDateTo() {
        return createDateTo;
    }

    public void setCreateDateTo(Date createDateTo) {
        this.createDateTo = createDateTo;
    }

    public Date getCreateDateFrom() {
        return createDateFrom;
    }

    public void setCreateDateFrom(Date createDateFrom) {
        this.createDateFrom = createDateFrom;
    }
}