package com.mika.credit.common.util;

/**
 * Created by gavin on 16-10-27.
 */
public class ReportFormatUtil {
    /**
     * 返回3位一组的整数
     * @param source
     * @return
     */
    public static String toStdNumberStr(String source){
        if (source == null || source == "") {
            return "";
        }
        double d = 0;
        try {
            d = Double.parseDouble(source);
        } catch (NumberFormatException e) {
            return "";
        }
        return UtilMath.toStdNumberString(d, 0);
    }
    /**
     * 返回3位一组的整数
     * @param source
     * @return
     */
    public static String toStdNumberStr(double source){
        return UtilMath.toStdNumberString(source, 0);
    }
    /**
     * 返回3位一组带2位小数的数值
     * @param source
     * @return
     */
    public static String toStdAmountStr(String source){
        if (source == null || source == "") {
            return "";
        }
        double d = 0;
        try {
            d = Double.parseDouble(source);
        } catch (NumberFormatException e) {
            return "";
        }
        return UtilMath.toStdAmountString(d, true);
    }
    /**
     * 返回3位一组带2位小数的数值
     * @param source
     * @return
     */
    public static String toStdAmountStr(double source){
        return UtilMath.toStdAmountString(source, true);
    }

    /**
     * 将yyyy-MM-ddTHH:mm:ss返回yyyy-MM-dd
     * @param source
     * @return
     */
    public static String toShortDate(String source){
        if (source == null || source == ""){
            return "";
        }else{
            String result[] = source.split("T");
            return result[0];
        }
    }
}
