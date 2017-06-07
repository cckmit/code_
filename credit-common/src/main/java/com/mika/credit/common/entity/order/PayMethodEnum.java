package com.mika.credit.common.entity.order;

import java.util.Objects;

/**
 * 支付方式枚举项
 *
 * @author zj001
 */
public enum PayMethodEnum {
    UNKNOWN((byte)0,"UnKnown","未知"),
    BALANCE((byte)1,"Balance","账户余额"),
    ALIPAY((byte)2,"Alipay","支付宝"),
    WXPAY((byte)3,"WXpay","微信");

    private Byte payMethod;
    private String nameEN;
    private String nameCN;
    PayMethodEnum(Byte payMethod,String nameEN,String nameCN) {
        this.payMethod=payMethod;
        this.nameEN=nameEN;
        this.nameCN=nameCN;
    }
    public Byte getPayMethod(){
        return payMethod;
    }
    public String getNameEN(){
        return nameEN;
    }
    public String getNameCN(){
        return nameCN;
    }

    public static String getNameEN(Byte typeCode) {
        PayMethodEnum[] values = PayMethodEnum.values();
        for (PayMethodEnum value : values) {
            if (Objects.equals(value.payMethod, typeCode)){
                return value.nameEN;
            }
        }
        return null;
    }

    public static String getNameCN(Byte typeCode) {
        PayMethodEnum[] values = PayMethodEnum.values();
        for (PayMethodEnum value : values) {
            if (Objects.equals(value.payMethod, typeCode)){
                return value.nameCN;
            }
        }
        return null;
    }

    public static String getOptionNameCN() {
//        StringBuilder option = new StringBuilder("<select id=\"payMethodType\" class=\"form-control\">");
        StringBuilder option = new StringBuilder();
        option.append("<option value=\"\">所有支付方式</option>");
        PayMethodEnum[] values = PayMethodEnum.values();
        for (PayMethodEnum value : values) {
            option.append("<option value=\"").append(value.payMethod).append("\">").append(value.getNameCN()).append("</option>");
        }
//        option.append("</select>");
        return option.toString();
    }

    public static String getOptionNameEN() {
//        StringBuilder option = new StringBuilder("<select id=\"payMethodType\" class=\"form-control\">");
        StringBuilder option = new StringBuilder();
        option.append("<option value=\"\">All Pay Method</option>");
        PayMethodEnum[] values = PayMethodEnum.values();
        for (PayMethodEnum value : values) {
            option.append("<option value=\"").append(value.payMethod).append("\">").append(value.getNameEN()).append("</option>");
        }
//        option.append("</select>");
        return option.toString();
    }
}
