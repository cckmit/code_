package com.mika.credit.facade.order.entity;

/**
 * 向cpm下单使用
 * Created by dell on 2017/5/3.
 */
public class OrdersBiz {

    private String crefoNo;
    private Integer cid;//客户编号
    private String subjectObj;//调查对象
    private String subjectAdd;//调查对象地址
    private String subjectTel;//调查对象电话
    private Integer rtId;//报告类型  ==== CustomerReportType
    private String note;//备注
    private Double price;//售价
    private String orderData;//订购日期
    private Integer bizid;
    private String osid;//订单状态
    private String status;//3abiz订单状态
    private String bizOrderId;//3abiz订单Id
    private Integer orderId;//全球鹰订单id
    private String customerNum;
    private String reportTypeId;//报告类型:1:即时报告 2:流程报告
    private String orderSourceId;//订单来源:1:3abiz 2:app 3:全球鹰



    public OrdersBiz() {
        super();
    }


    public OrdersBiz(String bizOrderId,String status,String crefoNo) {
        super();
        this.status = status;
        this.bizOrderId = bizOrderId;
        this.crefoNo=crefoNo;
    }


    public OrdersBiz(String crefoNo, String subjectObj, String subjectAdd,
                     String subjectTel, Integer rtId, String note, Double price) {
        super();
        this.crefoNo = crefoNo;
        this.subjectObj = subjectObj;
        this.subjectAdd = subjectAdd;
        this.subjectTel = subjectTel;
        this.rtId = rtId;
        this.note = note;
        this.price = price;
    }


    public String getCrefoNo() {
        return crefoNo;
    }


    public void setCrefoNo(String crefoNo) {
        this.crefoNo = crefoNo;
    }


    public String getSubjectObj() {
        return subjectObj;
    }


    public Integer getOrderId() {
        return orderId;
    }


    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }


    public void setSubjectObj(String subjectObj) {
        this.subjectObj = subjectObj;
    }


    public String getSubjectAdd() {
        return subjectAdd;
    }


    public void setSubjectAdd(String subjectAdd) {
        this.subjectAdd = subjectAdd;
    }


    public String getSubjectTel() {
        return subjectTel;
    }


    public void setSubjectTel(String subjectTel) {
        this.subjectTel = subjectTel;
    }


    public Integer getRtId() {
        return rtId;
    }


    public void setRtId(Integer rtId) {
        this.rtId = rtId;
    }


    public String getNote() {
        return note;
    }


    public void setNote(String note) {
        this.note = note;
    }


    public Double getPrice() {
        return price;
    }


    public void setPrice(Double price) {
        this.price = price;
    }


    public String getOrderData() {
        return orderData;
    }


    public void setOrderData(String orderData) {
        this.orderData = orderData;
    }


    public Integer getCid() {
        return cid;
    }


    public void setCid(Integer cid) {
        this.cid = cid;
    }


    public Integer getBizid() {
        return bizid;
    }


    public void setBizid(Integer bizid) {
        this.bizid = bizid;
    }


    public String getOsid() {
        return osid;
    }


    public void setOsid(String osid) {
        this.osid = osid;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }


    public String getBizOrderId() {
        return bizOrderId;
    }


    public void setBizOrderId(String bizOrderId) {
        this.bizOrderId = bizOrderId;
    }


    public String getCustomerNum() {
        return customerNum;
    }


    public void setCustomerNum(String customerNum) {
        this.customerNum = customerNum;
    }


    public String getReportTypeId() {
        return reportTypeId;
    }


    public void setReportTypeId(String reportTypeId) {
        this.reportTypeId = reportTypeId;
    }


    public String getOrderSourceId() {
        return orderSourceId;
    }


    public void setOrderSourceId(String orderSourceId) {
        this.orderSourceId = orderSourceId;
    }

}
