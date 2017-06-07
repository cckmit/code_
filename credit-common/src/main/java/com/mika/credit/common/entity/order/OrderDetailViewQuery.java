package com.mika.credit.common.entity.order;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 视图区间查询扩充类
 *
 * @author zj001
 */
public class OrderDetailViewQuery extends OrderDetailView {

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
