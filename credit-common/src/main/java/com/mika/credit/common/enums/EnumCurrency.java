package com.mika.credit.common.enums;

/**
 * Created by Zhu Jun on 2017/5/17.
 */
public enum EnumCurrency {
    CNY("142","CNY","人民币","Chinese Yuan","￥"),
    HKD("84","HKD","港币","Hong Kong dollar",""),
    JPY("116","JPY","日元","Japanese yen",""),
    MOP("121","MOP","澳门元","Macanese pataca",""),
    MYR("122","MYR","马来西亚林吉特","Malaysian ringgit",""),
    SGD("132","SGD","新加坡元","Singapore dollar",""),
    EUR("300","EUR","欧元","Euro",""),
    DKK("302","DKK","丹麦克朗","Danish krone",""),
    GBP("303","GBP","英镑","Pound sterling",""),
    NOK("326","NOK","挪威克朗","Norwegian krone",""),
    SEK("330","SEK","瑞典克朗","Swedish krona/kronor",""),
    CHF("331","CHF","瑞士法郎","Swiss franc",""),
    ASF("501","CAD","加拿大元","Canadian dollar",""),
    USD("502","USD","美元","United States dollar","$"),
    AUD("601","AUD","澳大利亚元","Australian dollar",""),
    NZD("319","NZD","新西兰","New Zealand dollar","");
    //todo:比利时法郎,BEF,301
    //todo:德国马克,DEM,304
    //todo:法国法郎,FRF,305
    //todo:意大利里拉,ITL,307
    //todo:荷兰盾,NLG,309
    //todo:奥地利先令,ATS,315
    //todo:芬兰马克,FIM,318
    //todo:清算瑞士法郎,NTD,603
    //todo:台币,ASF,398


    private String codeCN;
    private String codeEN;
    private String nameCN;
    private String nameEN;
    private String symbol;

    public String getCodeCN() {
        return codeCN;
    }

    public String getCodeEN() {
        return codeEN;
    }

    public String getNameCN() {
        return nameCN;
    }

    public String getNameEN() {
        return nameEN;
    }

    public String getSymbol() {
        return symbol;
    }

    EnumCurrency(String codeCN, String codeEN, String nameCN, String nameEN, String symbol){
        this.codeCN = codeCN;
        this.codeEN = codeEN;
        this.nameCN = nameCN;
        this.nameEN = nameEN;
        this.symbol = symbol;
    }

    public static EnumCurrency getByCodeCN(String codeCN){
        for (EnumCurrency currencyEnum : EnumCurrency.values()){
            if(currencyEnum.codeCN.equals(codeCN)){
                return currencyEnum;
            }
        }
        return null;
    }


    public static EnumCurrency getByCodeEN(String codeEN){
        for (EnumCurrency currencyEnum : EnumCurrency.values()){
            if(currencyEnum.codeEN.equals(codeEN)){
                return currencyEnum;
            }
        }
        return null;
    }
}
