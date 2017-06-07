package com.mika.credit.facade.front.cn.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dell on 2017/2/18.
 */
public class DateUtil {

    static  SimpleDateFormat timeFormat =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static SimpleDateFormat defaultFormat = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 当前时间
     * 默认格式 yyyy-MM-dd
     * @return
     */
    public static String getCurrentDate(){
        Date date = new Date();
        String result = timeFormat.format(date);


        return result;
    }

    /**
     * String 转date
     * */
    public static Date getStringToDate(String updateTime){
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = sdf.parse(updateTime);
            return date;
        }catch (Exception ex){
            return null;
        }
    }

    public static String parseTimeToDate(Long dateTime) {
        Date date = new Date(dateTime);
        return defaultFormat.format(date);
    }

    public static void main(String[] args) {
        String s = parseTimeToDate(1478188800000L);
        System.out.println(s);
    }
}
