package com.mika.credit.common.enums;

import java.util.Objects;

/**
 *
 * @author Nancy
 */
public enum EnumPaymentBehaviour {
    PBC010("010","010","No payment experience",""),//
    PBC020("020","020","Prompt, mostly cash discount",""),//
    PBC021("021","021","As far as known, prompt",""),//
    PBC030("030","030","Within agreed terms",""),
    PBC031("031","031","Within agreed terms of 30 to 60 days", ""),//
    PBC032("032","032","Within agreed terms of 60 to 90 days", ""),//
    PBC033("033","033","Within agreed terms of 90 days and more", ""),//
    PBC040("040","040","Mostly within agreed terms, but partly also delayed / Occasional payment reminders", ""),//
    PBC050("050","050","Delays", ""),//
    PBC051("051","051","Delays exceeding 30 days after due date",""),
    PBC052("052","052","Delays exceeding 60 days after due date", ""),//
    PBC053("053","053","Delays exceeding 90 days after due date", ""),//
    PBC060("060","060","Constant collections", ""),//
    PBC070("070","070","Recoveries at law / Legal claims", ""),//
    PBC080("080","080","Payment defaults", "");//

    private String nameDB;
    private String nameBigNet;
    private String bigNetDec;
    private String dbDec;

    EnumPaymentBehaviour(String nameDB, String nameBigNet, String bigNetDec, String dbDec) {
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
        EnumPaymentBehaviour[] values = EnumPaymentBehaviour.values();
        for (EnumPaymentBehaviour value : values) {
            if (Objects.equals(value.nameDB, nameDB)){
                return value.nameBigNet;
            }
        }
        return nameDB;
    }

    public static String getNameDBByBigNet(String nameBigNet) {
        EnumPaymentBehaviour[] values = EnumPaymentBehaviour.values();
        for (EnumPaymentBehaviour value : values) {
            if (Objects.equals(value.nameBigNet, nameBigNet)){
                return value.nameDB;
            }
        }
        return nameBigNet;
    }


}
