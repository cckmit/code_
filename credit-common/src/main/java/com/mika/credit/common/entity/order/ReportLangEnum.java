package com.mika.credit.common.entity.order;

import java.util.Objects;

/**
 * 报告语言枚举项
 *
 * @author zj001
 */
public enum ReportLangEnum {
    UNKNOWN((byte)0,"UnKnown","未知"),
    CHINESE((byte)1,"Chinese","中文"),
    ENGLISH((byte)2,"English","英文");

    private Byte reportLang;
    private String nameEN;
    private String nameCN;
    ReportLangEnum(Byte reportLang, String nameEN, String nameCN) {
        this.reportLang=reportLang;
        this.nameEN=nameEN;
        this.nameCN=nameCN;
    }
    public Byte getReportLang(){
        return reportLang;
    }
    public String getNameEN(){
        return nameEN;
    }
    public String getNameCN(){
        return nameCN;
    }

    public static String getNameEN(Byte typeCode) {
        ReportLangEnum[] values = ReportLangEnum.values();
        for (ReportLangEnum value : values) {
            if (Objects.equals(value.reportLang, typeCode)){
                return value.nameEN;
            }
        }
        return null;
    }

    public static String getNameCN(Byte typeCode) {
        ReportLangEnum[] values = ReportLangEnum.values();
        for (ReportLangEnum value : values) {
            if (Objects.equals(value.reportLang, typeCode)){
                return value.nameCN;
            }
        }
        return null;
    }

    public static String getOptionNameCN() {
//        StringBuilder option = new StringBuilder("<select id=\"reportLangType\" class=\"form-control\">");
        StringBuilder option = new StringBuilder();
        option.append("<option value=\"\">所有语言</option>");
        ReportLangEnum[] values = ReportLangEnum.values();
        for (ReportLangEnum value : values) {
            option.append("<option value=\"").append(value.reportLang).append("\">").append(value.getNameCN()).append("</option>");
        }
//        option.append("</select>");
        return option.toString();
    }

    public static String getOptionNameEN() {
//        StringBuilder option = new StringBuilder("<select id=\"reportLangType\" class=\"form-control\">");
        StringBuilder option = new StringBuilder();
        option.append("<option value=\"\">All Language</option>");
        ReportLangEnum[] values = ReportLangEnum.values();
        for (ReportLangEnum value : values) {
            option.append("<option value=\"").append(value.reportLang).append("\">").append(value.getNameEN()).append("</option>");
        }
//        option.append("</select>");
        return option.toString();
    }
}
