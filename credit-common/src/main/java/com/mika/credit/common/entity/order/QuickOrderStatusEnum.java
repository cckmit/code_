package com.mika.credit.common.entity.order;

import java.util.Objects;

/**
 * 快速订单状态枚举项
 *
 * @author zj001
 */
public enum QuickOrderStatusEnum {
    CANCELED((byte)0,"Canceled","取消"),
    TO_PAY((byte)1,"ToPay","待支付"),
    CONFIRMING((byte)3,"Confirming","确认中"),
    MAKING((byte)4,"Making","制作中"),
    FINISHED((byte)8,"Finished","已完成");

    private Byte statusCode;
    private String nameEN;
    private String nameCN;
    QuickOrderStatusEnum(Byte statusCode, String nameEN, String nameCN) {
        this.statusCode=statusCode;
        this.nameEN=nameEN;
        this.nameCN=nameCN;
    }
    public Byte getStatusCode(){
        return statusCode;
    }
    public String getNameEN(){
        return nameEN;
    }
    public String getNameCN(){
        return nameCN;
    }

    public static String getNameEN(Byte typeCode) {
        QuickOrderStatusEnum[] values = QuickOrderStatusEnum.values();
        for (QuickOrderStatusEnum value : values) {
            if (Objects.equals(value.statusCode, typeCode)){
                return value.nameEN;
            }
        }
        return null;
    }

    public static String getNameCN(Byte typeCode) {
        QuickOrderStatusEnum[] values = QuickOrderStatusEnum.values();
        for (QuickOrderStatusEnum value : values) {
            if (Objects.equals(value.statusCode, typeCode)){
                return value.nameCN;
            }
        }
        return null;
    }

    public static String getOptionNameCN() {
//        StringBuilder option = new StringBuilder("<select id=\"quickOrderStatusType\" class=\"form-control\">");
        StringBuilder option = new StringBuilder("<select id=\"quickOrderStatusType\" class=\"form-control\">");
        option.append("<option value=\"\">所有状态</option>");
        QuickOrderStatusEnum[] values = QuickOrderStatusEnum.values();
        for (QuickOrderStatusEnum value : values) {
            option.append("<option value=\"").append(value.statusCode).append("\">").append(value.getNameCN()).append("</option>");
        }
//        option.append("</select>");
        return option.toString();
    }

    public static String getOptionNameEN() {
//        StringBuilder option = new StringBuilder("<select id=\"quickOrderStatusType\" class=\"form-control\">");
        StringBuilder option = new StringBuilder();
        option.append("<option value=\"\">All Status</option>");
        QuickOrderStatusEnum[] values = QuickOrderStatusEnum.values();
        for (QuickOrderStatusEnum value : values) {
            option.append("<option value=\"").append(value.statusCode).append("\">").append(value.getNameEN()).append("</option>");
        }
//        option.append("</select>");
        return option.toString();
    }
    
}
