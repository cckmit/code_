package com.mika.credit.common.enums;

/**
 * Created by Gavin on 2017/5/18.
 */
public enum EnumCreditRatingCN {
    LOW(6, 100, 193, "Low Risk", "低风险"),
    LOWER_THAN_AVERAGE(5, 194, 229, "Lower than Average Risk", "低于平均风险"),
    AVERAGE(4, 230, 294, "Average Risk", "平均风险"),
    MODERATE(3, 295, 353, "Moderate Risk", "高于平均风险"),
    MEDIUM(2, 354, 439, "Medium Risk", "中度风险"),
    HIGH(1, 440, 600, "High Risk", "高风险"),
    NONE(0, 0, 0, "NONE", "未评级");

    private int level;
    private int lowValue;
    private int highValue;
    private String descriptionEN;
    private String descriptionCN;

    public static EnumCreditRatingCN getRatingByScore(int score){
        for(EnumCreditRatingCN enumCreditRatingCN : EnumCreditRatingCN.values()){
            if(score >= enumCreditRatingCN.getLowValue() && score <= enumCreditRatingCN.getHighValue()){
                return enumCreditRatingCN;
            }
        }
        return EnumCreditRatingCN.NONE;
    }

    public static EnumCreditRatingCN getRatingByLevel(int level){
        for(EnumCreditRatingCN enumCreditRatingCN : EnumCreditRatingCN.values()){
            if(level == enumCreditRatingCN.getLevel()){
                return enumCreditRatingCN;
            }
        }
        return EnumCreditRatingCN.NONE;
    }

    EnumCreditRatingCN(int level, int lowValue, int highValue, String descriptionEN, String descriptionCN) {
        this.level = level;
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

    public String getDescriptionEN() {
        return descriptionEN;
    }

    public String getDescriptionCN() {
        return descriptionCN;
    }
}
