package com.mika.credit.common.entity.order;

import java.util.Objects;

/**
 * 产品类型枚举项
 *
 * @author zj001
 */
public enum ProductTypeEnum {
    CHINA((byte)1,"CHINA","中国报告"),//中国报告
    FOREIGN((byte)2,"FOREIGN","外国报告"),//外国报告
    SELFDEFINED((byte)3,"SELFDEFINED","自定义报告");//自定义报告

    private Byte typeCode;
    private String nameCN;
    private String nameEN;
    ProductTypeEnum(Byte typeCode, String nameEN, String nameCN) {
        this.typeCode=typeCode;
        this.nameCN=nameCN;
        this.nameEN=nameEN;
    }
    public Byte getTypeCode(){
        return typeCode;
    }
    public String getNameCN(){
        return nameCN;
    }
    public String getNameEN(){
        return nameEN;
    }
    public static String getNameEN(Byte typeCode) {
        ProductTypeEnum[] values = ProductTypeEnum.values();
        for (ProductTypeEnum value : values) {
            if (Objects.equals(value.typeCode, typeCode)){
                return value.nameEN;
            }
        }
        return null;
    }

    public static String getNameCN(Byte typeCode) {
        ProductTypeEnum[] values = ProductTypeEnum.values();
        for (ProductTypeEnum value : values) {
            if (Objects.equals(value.typeCode, typeCode)){
                return value.nameCN;
            }
        }
        return null;
    }

    public static String getOptionNameCN() {
//        StringBuilder option = new StringBuilder("<select id=\"productType\" class=\"form-control\">");
        StringBuilder option = new StringBuilder();
        option.append("<option value=\"\">所有产品类型</option>");
        ProductTypeEnum[] values = ProductTypeEnum.values();
        for (ProductTypeEnum value : values) {
            option.append("<option value=\"").append(value.typeCode).append("\">").append(value.getNameCN()).append("</option>");
        }
//        option.append("</select>");
        return option.toString();
    }

    public static String getOptionNameEN() {
//        StringBuilder option = new StringBuilder("<select id=\"productType\" class=\"form-control\">");
        StringBuilder option = new StringBuilder();
        option.append("<option value=\"\">All Product Type</option>");
        ProductTypeEnum[] values = ProductTypeEnum.values();
        for (ProductTypeEnum value : values) {
            option.append("<option value=\"").append(value.typeCode).append("\">").append(value.getNameEN()).append("</option>");
        }
//        option.append("</select>");
        return option.toString();
    }
}
