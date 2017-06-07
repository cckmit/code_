package com.mika.credit.common.entity.pay;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 支付返回
 * Created by Gavin on 2017/2/17.
 */
public class PayBackBean implements Serializable{

       private static final long serialVersionUID = -134108768758982350L;
       private BigDecimal amount;//订单总金额
       private Date payTime;//支付完成时间
       private String orderNo;//订单编号
       private  Byte orderType;//订单类型
       private Integer payMethod;//支付方式


       public BigDecimal getAmount() {
              return amount;
       }
       public void setAmount(BigDecimal amount) {
              this.amount = amount;
       }

       public Integer getPayMethod() {
              return payMethod;
       }

       public void setPayMethod(Integer payMethod) {
              this.payMethod = payMethod;
       }

       public Date getPayTime() {
              return payTime;
       }

       public void setPayTime(Date payTime) {
              this.payTime = payTime;
       }

       public String getOrderNo() {
              return orderNo;
       }

       public void setOrderNo(String orderNo) {
              this.orderNo = orderNo;
       }

       public Byte getOrderType() {
              return orderType;
       }

       public void setOrderType(Byte orderType) {
              this.orderType = orderType;
       }

       public boolean isValid(){
              //TODO:完善验证字段，主要验证非空
              if(!StringUtils.isEmpty(this.getOrderNo()) || this.getAmount() !=null
                      || this.getPayTime() !=null || this.getOrderType() !=null
                      || this.getPayMethod() !=null){
                     return true;
              }
              return false;
       }
}
