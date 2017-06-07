package com.mika.credit.facade.order.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by dell on 2017/5/16.
 */
public class DateUtil {
    private static List<Calendar> holidayList = new ArrayList<>();  //节假日列表


    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar = addDateByWorkDay(calendar, 16);
        System.out.println(format.format(calendar.getTime()));
    }
    /**
     *
     * <p>Title: addDateByWorkDay </P>
     * <p>Description:   计算相加day天，并且排除节假日和周末后的日期
     * @param calendar  当前的日期
     * @param day  相加天数
     * @return
     * return Calendar    返回类型   返回相加day天，并且排除节假日和周末后的日期
     * throws
     * date 2014-11-24 上午10:32:55
     */
    public static Calendar addDateByWorkDay(Calendar calendar,int day){

        try {
            for (int i = 0; i < day; i++) {

                calendar.add(Calendar.DAY_OF_MONTH, 1);

                if(checkHoliday(calendar)){
                    i--;
                }
            }
            return calendar;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return calendar;
    }

    /**
     *
     * <p>Title: checkHoliday </P>
     * <p>Description:  验证日期是否是节假日
     * @param calendar  传入需要验证的日期
     * @return
     * return boolean    返回类型  返回true是节假日，返回false不是节假日
     * throws
     * date 2014-11-24 上午10:13:07
     */
    public static boolean checkHoliday(Calendar calendar) throws Exception{

        //判断日期是否是周六周日
        if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
                calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
            return true;
        }
        //判断日期是否是节假日
        for (Calendar ca : holidayList) {
            if(ca.get(Calendar.MONTH) == calendar.get(Calendar.MONTH) &&
                    ca.get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH)&&
                    ca.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)){
                return true;
            }
        }

        return false;
    }

    /**
     *
     * <p>Title: initHolidayList </P>
     * <p>Description:   把所有节假日放入list
     * @param date  从数据库查 查出来的格式2014-05-09
     * return void    返回类型
     * throws
     * date 2014-11-24 上午10:11:35
     */
    public static void initHolidayList( String date){

        String [] da = date.split("-");

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, Integer.valueOf(da[0]));
        calendar.set(Calendar.MONTH, Integer.valueOf(da[1])-1);//月份比正常小1,0代表一月
        calendar.set(Calendar.DAY_OF_MONTH, Integer.valueOf(da[2]));
        holidayList.add(calendar);
    }
}
