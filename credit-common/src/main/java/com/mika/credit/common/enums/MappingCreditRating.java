package com.mika.credit.common.enums;

/**
 * Created by Gavin on 2017/5/18.
 */
public class MappingCreditRating {
    public static int transferCNScoreToEN(int scoreCN){
        EnumCreditRatingCN enumCreditRatingCN = EnumCreditRatingCN.getRatingByScore(scoreCN);
        int level = enumCreditRatingCN.getLevel();
        int lowCN = enumCreditRatingCN.getLowValue();
        int highCN = enumCreditRatingCN.getHighValue();
        if(level == 6 || level == 5){//5档与6档合并到EN的5档，因为EN没有6档
            level = 5;
            lowCN = EnumCreditRatingCN.LOW.getLowValue();
            highCN = EnumCreditRatingCN.LOWER_THAN_AVERAGE.getHighValue();
        }
        double rangeCN = highCN - lowCN;

        EnumCreditRatingEN enumCreditRatingEN = EnumCreditRatingEN.getRatingByLevel(level);
        int lowEN = enumCreditRatingEN.getLowValue();
        int highEN = enumCreditRatingEN.getHighValue();
        double rangeEN = highEN - lowEN;

        //从低分往高分走，但换算EN的时候反过来走。
        double percent = (scoreCN - lowCN) / rangeCN;
        double result = highEN - (percent * rangeEN);
        return (int)Math.floor(result);
    }

    public static int transferENScoreToCN(int scoreEN){
        EnumCreditRatingEN enumCreditRatingEN = EnumCreditRatingEN.getRatingByScore(scoreEN);
        int level = enumCreditRatingEN.getLevel();
        int lowEN = enumCreditRatingEN.getLowValue();
        int highEN = enumCreditRatingEN.getHighValue();
        double rangeEN = highEN - lowEN;

        EnumCreditRatingCN enumCreditRatingCN = EnumCreditRatingCN.getRatingByLevel(level);
        int lowCN = enumCreditRatingCN.getLowValue();
        int highCN = enumCreditRatingCN.getHighValue();
        if(level == 5){
            lowCN = EnumCreditRatingCN.LOW.getLowValue();
            highCN = EnumCreditRatingCN.LOWER_THAN_AVERAGE.getHighValue();
        }
        double rangeCN = highCN - lowCN;

        //从低分往高分走，但换算CN的时候反过来走。
        double percent = (scoreEN - lowEN) / rangeEN;
        double result = highCN - (percent * rangeCN);
        return (int)Math.floor(result);
    }

    public static void main(String[] args){
        System.out.println(transferCNScoreToEN(100));
        System.out.println(transferCNScoreToEN(101));
        System.out.println(transferCNScoreToEN(193));
        System.out.println(transferCNScoreToEN(192));
        System.out.println(transferCNScoreToEN(194));
        System.out.println(transferCNScoreToEN(195));
        System.out.println(transferCNScoreToEN(228));
        System.out.println(transferCNScoreToEN(233));

        System.out.println("====================================");
        System.out.println(transferENScoreToCN(100));
        System.out.println(transferENScoreToCN(98));
        System.out.println(transferENScoreToCN(88));
        System.out.println(transferENScoreToCN(79));
        System.out.println(transferENScoreToCN(75));
        System.out.println(transferENScoreToCN(74));
        System.out.println(transferENScoreToCN(60));
        System.out.println(transferENScoreToCN(50));

    }
}
