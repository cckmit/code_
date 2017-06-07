package com.mika.credit.common.enums;

import java.util.Objects;

/**
 *
 * @author Nancy
 */
public enum EnumEmployeesClass {
    ECC001("001","001","number of employees unknown",""),//
    ECC002("002","002","company has no employees",""),//
    ECC003("003","003","1-5",""),//
    ECC004("004","004","6-9",""),
    ECC005("005","005","10-19", ""),//
    ECC006("006","006","20-49", ""),//
    ECC007("007","007","50-99", ""),//
    ECC008("008","008","100-199", ""),//
    ECC009("009","009","200-499", ""),//
    ECC010("010","010","500-999",""),
    ECC011("011","011","1,000-1,999", ""),//
    ECC012("012","012",">= 2,000", "");//


    private String nameDB;
    private String nameBigNet;
    private String bigNetDec;
    private String dbDec;

    EnumEmployeesClass(String nameDB, String nameBigNet, String bigNetDec, String dbDec) {
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
        EnumEmployeesClass[] values = EnumEmployeesClass.values();
        for (EnumEmployeesClass value : values) {
            if (Objects.equals(value.nameDB, nameDB)){
                return value.nameBigNet;
            }
        }
        return nameDB;
    }

    public static String getNameDBByBigNet(String nameBigNet) {
        EnumEmployeesClass[] values = EnumEmployeesClass.values();
        for (EnumEmployeesClass value : values) {
            if (Objects.equals(value.nameBigNet, nameBigNet)){
                return value.nameDB;
            }
        }
        return nameBigNet;
    }


}
