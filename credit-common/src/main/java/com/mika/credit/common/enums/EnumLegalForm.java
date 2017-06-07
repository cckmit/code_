package com.mika.credit.common.enums;

import java.util.Objects;

/**
 *
 * @author Nancy
 */
public enum EnumLegalForm {
    SPS("SPS","SPS","Sole Proprietorship","独资企业"),//
    LTD("LTD","LTD","Limited Liability Company / Private Limited Company","有限责任公司/私人有限公司"),//
    PLC("PLC","PLC","Public Limited Liability / Joint stock company","公众有限责任公司/股份公司"),//
    PLQ("PLQ","PLQ","Public limited company quoted",""),
    SEU("SEU","SEU","Societas Europaea (European PLC)", "欧洲欧洲协会"),//
    CLP("CLP","CLP","Civil Law Partnership", "民法合作"),//
    GPS("GPS","GPS","General partnership", "普通合伙"),//
    LPS("LPS","LPS","Limited partnership", "有限合伙制"),//
    ASS("ASS","ASS","Association", "协会"),//
    MUT("MUT","MUT","Mutual guarantee association","互保协会"),
    EEI("EEI","EEI","Association of economic interests (EIG)", "经济利益协会 (EIG)）"),//
    BOD("BOD","BOD","Body corporate (public) / Company statutory body", "公司（公众）/公司法定机构"),//
    COO("COO","COO","Cooperative Society", "合作社"),//
    FGN("FGN","FGN","Foreign company / Branch office of foreign company", "外国公司/外国公司分公司"),//
    STA("STA","STA","State-owned enterprise", "国有企业"),//
    OTH("OTH","OTH","Other Legal Form", "其他法律形式"),//
    FND("FND","FND","", "");//

    private String nameDB;
    private String nameBigNet;
    private String bigNetDec;
    private String dbDec;

    EnumLegalForm(String nameDB, String nameBigNet, String bigNetDec, String dbDec) {
        this.nameDB = nameDB;
        this.nameBigNet = nameBigNet;
        this.bigNetDec =bigNetDec;
        this.dbDec = dbDec;
    }

    public String getNameDB(){
        return nameDB;
    }
    public String getNameBigNet(){
        return nameBigNet;
    }
    public String getBigNetDec() {
        return bigNetDec;
    }

    public String getDbDec() {
        return dbDec;
    }

    public static String getNameBigNetByDB(String nameDB) {
        EnumLegalForm[] values = EnumLegalForm.values();
        for (EnumLegalForm value : values) {
            if (Objects.equals(value.nameDB, nameDB)){
                return value.nameBigNet;
            }
        }
        return nameDB;
    }

    public static String getNameDBByBigNet(String nameBigNet) {
        EnumLegalForm[] values = EnumLegalForm.values();
        for (EnumLegalForm value : values) {
            if (Objects.equals(value.nameBigNet, nameBigNet)){
                return value.nameDB;
            }
        }
        return nameBigNet;
    }


}
