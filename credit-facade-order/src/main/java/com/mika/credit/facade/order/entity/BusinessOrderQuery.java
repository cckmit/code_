package com.mika.credit.facade.order.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Gavin on 2017/5/9.
 */
public class BusinessOrderQuery extends BusinessOrder {
    private static final long serialVersionUID = -7686225750286729400L;
    /**
     * 订单创建时间结束
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDateTo;
    /**
     * 订单创建时间开始
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
