package com.mika.credit.common.enums;

/**
 * Created by Gavin on 2017/5/18.
 */
public enum EnumCreditRatingEN {
    VERY_HIGH(1, "000-014", 0, 14, "Very High Risk", "极高风险"),
    HIGH(2, "015-029", 15, 29, "High Risk", "高风险"),
    AVERAGE(3, "030-049", 30, 49, "Average Risk", "平均风险"),
    LOW(4, "050-074", 20, 74, "Low Risk", "低风险"),
    VERY_LOW(5, "075-100", 75, 100, "Very High Risk", "极低风险"),
    NONE(0, "0-0", 0, 0, "NONE", "未评级");

    private int level;
    private String code;
    private int lowValue;
    private int highValue;
    private String descriptionEN;
    private String descriptionCN;

    public static EnumCreditRatingEN getRatingByScore(int score){
        for(EnumCreditRatingEN enumCreditRatingEN : EnumCreditRatingEN.values()){
            if(score >= enumCreditRatingEN.getLowValue() && score <= enumCreditRatingEN.getHighValue()){
                return enumCreditRatingEN;
            }
        }
        return EnumCreditRatingEN.NONE;
    }

    public static EnumCreditRatingEN getRatingByLevel(int level){
        for(EnumCreditRatingEN enumCreditRatingEN : EnumCreditRatingEN.values()){
            if(level == enumCreditRatingEN.getLevel()){
                return enumCreditRatingEN;
            }
        }
        return EnumCreditRatingEN.NONE;
    }

    EnumCreditRatingEN(int level, String code, int lowValue, int highValue, String descriptionEN, String descriptionCN) {
        this.level = level;
        this.code = code;
        this.lowValue = lowValue;
        this.highValue = highValue;
        this.descriptionEN = descriptionEN;
        this.descriptionCN = descriptionCN;
    }

    public int getLevel() {
        return level;
    }

    public int getLowValue() {
        return lowValue;
    }

    public int getHighValue() {
        return highValue;
    }

    public String getCode(){
        return code;
    }

    public String getDescriptionEN() {
        return descriptionEN;
    }

    public String getDescriptionCN() {
        return descriptionCN;
    }
}
