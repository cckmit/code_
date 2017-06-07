package com.mika.credit.common.entity.order;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 快速订单区间查询扩充类
 */
public class QuickOrderQuery extends QuickOrder{

    private static final long serialVersionUID = 7849220978674059610L;
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