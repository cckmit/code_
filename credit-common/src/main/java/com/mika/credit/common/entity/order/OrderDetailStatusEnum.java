package com.mika.credit.common.entity.order;

import java.util.Objects;

/**
 * 订单明细状态枚举项
 *
 * @author zj001
 */
public enum OrderDetailStatusEnum {
    CANCELED((byte)0,"Canceled","已取消"),
    TO_PAY((byte)1,"ToPay","待支付"),
    SURVEYING((byte)2,"Surveying","调查中"),
    TO_DISTRIBUTE((byte)3,"ToDistribute","待分配"),
    MAKING((byte)4,"Making","制作中"),
    TO_CHECK((byte)5,"Check","待审核"),
    CHECKING((byte)6,"Checking","审核中"),
    TO_PUBLISH((byte)7,"ToPublish","待发布"),
    FINISHED((byte)8,"Finished","已完成");

    private Byte statusCode;
    private String nameEN;
    private String nameCN;
    OrderDetailStatusEnum(Byte statusCode, String nameEN, String nameCN) {
        this.statusCode=statusCode;
        this.nameEN=nameEN;
        this.nameCN=nameCN;
    }


    public byte getStatusCode(){
        return statusCode;
    }

    public String getNameCN(){
        return this.nameCN;
    }

    public String getNameEN(){
        return this.nameEN;
    }

    public static String getNameEN(Byte typeCode) {
        OrderDetailStatusEnum[] values = OrderDetailStatusEnum.values();
        for (OrderDetailStatusEnum value : values) {
            if (Objects.equals(value.statusCode, typeCode)){
                return value.nameEN;
            }
        }
        return null;
    }

    public static String getNameCN(Byte typeCode) {
        OrderDetailStatusEnum[] values = OrderDetailStatusEnum.values();
        for (OrderDetailStatusEnum value : values) {
            if (Objects.equals(value.statusCode, typeCode)){
                return value.nameCN;
            }
        }
        return null;
    }

    public static String getOptionNameCN() {
//        StringBuilder option = new StringBuilder("<select id=\"orderDetailStatusType\" class=\"form-control\">");
        StringBuilder option = new StringBuilder();
        option.append("<option value=\"\">所有明细状态</option>");
        OrderDetailStatusEnum[] values = OrderDetailStatusEnum.values();
        for (OrderDetailStatusEnum value : values) {
            option.append("<option value=\"").append(value.statusCode).append("\">").append(value.getNameCN()).append("</option>");
        }
//        option.append("</select>");
        return option.toString();
    }

    public static String getOptionNameEN() {
//        StringBuilder option = new StringBuilder("<select id=\"orderDetailStatusType\" class=\"form-control\">");
        StringBuilder option = new StringBuilder();
        option.append("<option value=\"\">All Detail Status</option>");
        OrderDetailStatusEnum[] values = OrderDetailStatusEnum.values();
        for (OrderDetailStatusEnum value : values) {
            option.append("<option value=\"").append(value.statusCode).append("\">").append(value.getNameEN()).append("</option>");
        }
//        option.append("</select>");
        return option.toString();
    }
}
