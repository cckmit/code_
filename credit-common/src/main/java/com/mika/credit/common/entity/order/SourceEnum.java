package com.mika.credit.common.entity.order;

import java.util.Objects;

/**
 * 来源枚举项
 *
 * @author zj001
 */
public enum SourceEnum {
    UNKNOWN((byte)0,"UnKnown","未知"),
    GLOBAL_EAGLE((byte)1,"Global_Eagle","全球鹰"),
    GLOBAL_SEARCH((byte)2,"Global_Search","全搜"),
    CPM((byte)3,"CPM","CPM"),
    GUGU((byte)4,"GUGU","估估信用"),
    BIG_NET((byte)5, "bigNet", "bigNet"),
    SAFE((byte)6, "safe", "safe"),
    CREDITREFORM((byte)7, "creditreform", "creditreform"),
    CN((byte)8, "CN", "CN"),
    EN((byte)9, "EN", "EN");

    private Byte source;
    private String nameEN;
    private String nameCN;

    SourceEnum(Byte source,String nameEN,String nameCN) {
        this.source=source;
        this.nameEN=nameEN;
        this.nameCN=nameCN;
    }

    public Byte getSource(){
        return source;
    }
    public String getNameEN(){
        return nameEN;
    }
    public String getNameCN(){
        return nameCN;
    }

    public static String getNameEN(Byte typeCode) {
        SourceEnum[] values = SourceEnum.values();
        for (SourceEnum value : values) {
            if (Objects.equals(value.source, typeCode)){
                return value.nameEN;
            }
        }
        return null;
    }

    public static String getNameCN(Byte typeCode) {
        SourceEnum[] values = SourceEnum.values();
        for (SourceEnum value : values) {
            if (Objects.equals(value.source, typeCode)){
                return value.nameCN;
            }
        }
        return null;
    }

    public static String getOptionNameCN() {
//        StringBuilder option = new StringBuilder( "<select id=\"sourceType\" class=\"form-control\">");
        StringBuilder option = new StringBuilder("<select id=\"sourceType\" class=\"form-control\">");
        option.append("<option value=\"\">所有来源</option>");
        SourceEnum[] values = SourceEnum.values();
        for (SourceEnum value : values) {
            option.append("<option value=\"").append(value.source).append("\">").append(value.getNameCN()).append("</option>");
        }
//        option.append("</select>");
        return option.toString();
    }

    public static String getOptionNameEN() {
//        StringBuilder option = new StringBuilder("<select id=\"sourceType\" class=\"form-control\">");
        StringBuilder option = new StringBuilder("<select id=\"sourceType\" class=\"form-control\">");
        option.append("<option value=\"\">All Source</option>");
        SourceEnum[] values = SourceEnum.values();
        for (SourceEnum value : values) {
            option.append("<option value=\"").append(value.source).append("\">").append(value.getNameEN()).append("</option>");
        }
//        option.append("</select>");
        return option.toString();
    }
}
