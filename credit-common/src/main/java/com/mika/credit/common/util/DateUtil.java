package com.mika.credit.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
     * 当前日期
     * 默认格式 yyyy-MM-dd
     * @return
     */
    public static String getRatingLostReasonDateSince(){
        Date date = new Date();
        String result = defaultFormat.format(date);


        return result;
    }

    /**
     * 时间类型转毫秒
     * @param parseDate
     * @return
     * @throws Exception
     */
    public Long getTime(String parseDate) throws Exception{
        Date date = timeFormat.parse(String.valueOf(parseDate));
        Calendar cTime = Calendar.getInstance();
        cTime.setTime(date);
        return cTime.getTimeInMillis();
    }

    /**
     * 当前时间
     * @param format 日期格式
     * @return
     */
    public static String getCurrentDate(String format){
        Date date = new Date();
        String result = "";
        if(null != format && !format.trim().equals("")){
            SimpleDateFormat sdf = new SimpleDateFormat(String.valueOf(format));
            result = sdf.format(date);
        }else{
            result = defaultFormat.format(date);
        }
        return result;
    }

    public static String parseTimeToDate(Long dateTime) {
        try {
            Date date = new Date(dateTime);
            return defaultFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
