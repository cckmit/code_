package com.mika.credit.common.enums;

import java.util.Objects;

/**
 *
 * @author Nancy
 */
public enum EnumCreditRiskCode {
    RiskCode001("001","001","Development remains to be seen",""),//
    RiskCode002("002","002","Very high creditworthiness",""),//
    RiskCode003("003","003","High creditworthiness",""),//
    RiskCode004("004","004","Moderate creditworthiness",""),
    RiskCode005("005","005","Low creditworthiness",""),//
    RiskCode006("006","006","No creditworthiness","");//


    private String nameDB;
    private String nameBigNet;
    private String bigNetDec;
    private String dbDec;

    EnumCreditRiskCode(String nameDB, String nameBigNet, String bigNetDec, String dbDec) {
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
        EnumCreditRiskCode[] values = EnumCreditRiskCode.values();
        for (EnumCreditRiskCode value : values) {
            if (Objects.equals(value.nameDB, nameDB)){
                return value.nameBigNet;
            }
        }
        return nameDB;
    }

    public static String getNameDBByBigNet(String nameBigNet) {
        EnumCreditRiskCode[] values = EnumCreditRiskCode.values();
        for (EnumCreditRiskCode value : values) {
            if (Objects.equals(value.nameBigNet, nameBigNet)){
                return value.nameDB;
            }
        }
        return nameBigNet;
    }


}
