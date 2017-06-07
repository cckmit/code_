package com.mika.credit.facade.verify.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtil {
	
	SimpleDateFormat timeFormat =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	SimpleDateFormat defaultFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	SimpleDateFormat yFormat = new SimpleDateFormat("yyyy");
	
	SimpleDateFormat mFormat = new SimpleDateFormat("MM");
	
	SimpleDateFormat dFormat = new SimpleDateFormat("dd");
	
	
	/**
	 * 当前时间
	 * 默认格式 yyyy-MM-dd
	 * @param emailformat
	 * @return
	 */
	public String getCurrentDate(){
		Date date = new Date();
		String result = defaultFormat.format(date);
		
		
		return result;
	}
	
	
	/**
	 * 当前时间
	 * @param format 日期格式
	 * @return
	 */
	public String getCurrentDate(String format){
		Date date = new Date();
		String result = "";
		if(null != format && !format.trim().equals("")){
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			result = sdf.format(date);
		}else{
			result = defaultFormat.format(date);
		}
		return result;
	}
	
	
	/**
	 * 字符串转换日期
	 * @param date
	 * @return
	 */
	public Date conversionDate(String date){
		Date result = null;
		try {
			result = defaultFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 当前年
	 * @return
	 */
	public String getCurrentYear(){
		Date date = new Date();
		String year = yFormat.format(date);
		return year;
	}
	
	/**
	 * 字符串转换年
	 * @param parseDate 转换日期
	 * @return
	 */
	public String getYear(String parseDate){
		String year = "";
		try {
			year = yFormat.format(defaultFormat.parse(parseDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return year;
	}
	
	/**
	 * 日期转换年
	 * @param parseDate 转换日期
	 * @return
	 */
	public String getYear(Date parseDate){
		String year = yFormat.format(parseDate);
		return year;
	}
	
	/**
	 * 当前月
	 * @return
	 */
	public String getCurrentMonth(){
		Date date = new Date();
		String month = mFormat.format(date);
		return month;
	}
	
	/**
	 * 字符串转换月
	 * @param parseDate 转换日期
	 * @return
	 */
	public String getMonth(String parseDate){
		String month = "";
		try {
			month = mFormat.format(defaultFormat.parse(parseDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return month;
	}
	
	/**
	 * 日期转换月
	 * @param parseDate 转换日期
	 * @return
	 */
	public String getMonth(Date parseDate){
		String month = mFormat.format(parseDate);
		return month;
	}
	
	/**
	 * 当前日
	 * @return
	 */
	public String getDay(){
		Date date = new Date();
		String day = dFormat.format(date);
		return day;
	}
	
	/**
	 * 字符串转换日
	 * @param parseDate 转换日期
	 * @return
	 */
	public String getDay(String parseDate){
		String day = dFormat.format(parseDate);
		return day;
	}
	
	/**
	 * 日期转换日
	 * @param parseDate 转换日期
	 * @return
	 */
	public String getDay(Date parseDate){
		String day = dFormat.format(parseDate);
		return day;
	}
	
	/**
	 * 字符串转毫秒
	 * @param parseDate
	 * @return
	 * @throws Exception
	 */
	public Long getTime(String parseDate) throws Exception{
		Date date = timeFormat.parse(parseDate);
		Calendar cTime = Calendar.getInstance();     
		cTime.setTime(date); 
		return cTime.getTimeInMillis();
	}
	
	/**
	 * 当前月的第一天
	 * 默认格式 yyyy-MM-dd
	 * @return
	 */
	public String getCurrentMonthFirstOfDay(){
		Date date = new Date();
		Calendar cDay = Calendar.getInstance();     
		cDay.setTime(date);  
		cDay.set(Calendar.DAY_OF_MONTH, 1);  
		String monthDay = defaultFormat.format(cDay.getTime());
		return monthDay;
	}
	
	/**
	 * 当前月的第一天
	 * @param format
	 * @return
	 */
	public String getCurrentMonthFirstOfDay(String format){
		SimpleDateFormat sf = new SimpleDateFormat(format);
		Date date = new Date();
		Calendar cDay = Calendar.getInstance();     
		cDay.setTime(date);  
		cDay.set(Calendar.DAY_OF_MONTH, 1);  
		String monthDay = sf.format(cDay.getTime());
		return monthDay;
	}
	
	/**
	 * 字符串转换日期此月的第一天
	 * @param parseDate 转换日期
	 * @return
	 * @throws Exception
	 */
	public String getMonthFirstOfDay(String parseDate) throws Exception{
		Date date = defaultFormat.parse(parseDate);
		Calendar cDay = Calendar.getInstance();     
		cDay.setTime(date);  
		cDay.set(Calendar.DAY_OF_MONTH, 1);  
		String monthDay = defaultFormat.format(cDay.getTime());
		return monthDay;
	}
	
	
	
	/**
	 * 日期转换获取此月第一天
	 * 默认格式 yyyy-MM-dd
	 * @param parseDate 转换日期
	 * @return
	 * @throws Exception
	 */
	public String getMonthFirstOfDay(Date parseDate) throws Exception{
		Calendar cDay = Calendar.getInstance();     
		cDay.setTime(parseDate);  
		cDay.set(Calendar.DAY_OF_MONTH, 1);  
		String monthDay = defaultFormat.format(cDay.getTime());
		return monthDay;
	}
	
	/**
	 * 当前月的最后一天
	 * 默认格式 yyyy-MM-dd
	 * @return
	 * @throws Exception
	 */
	public String getCurrentMonthLastOfDay() throws Exception{
		Date date = new Date();
		Calendar cDay = Calendar.getInstance();     
		cDay.setTime(date);  
		cDay.set(Calendar.DAY_OF_MONTH, cDay.getActualMaximum(Calendar.DAY_OF_MONTH));  
		String monthDay = defaultFormat.format(cDay.getTime());
		return monthDay;
	}
	
	/**
	 * 当前月的最后一天
	 * @param format
	 * @return
	 * @throws Exception
	 */
	public String getCurrentMonthLastOfDay(String format) throws Exception{
		SimpleDateFormat sf = new SimpleDateFormat(format);
		Date date = new Date();
		Calendar cDay = Calendar.getInstance();     
		cDay.setTime(date);  
		cDay.set(Calendar.DAY_OF_MONTH, cDay.getActualMaximum(Calendar.DAY_OF_MONTH));  
		String monthDay = sf.format(cDay.getTime());
		return monthDay;
	}
	
	/**
	 * 字符串转换日期获取此月的最后一天
	 * 默认格式 yyyy-MM-dd
	 * @param parseDate 转换日期
	 * @return
	 * @throws Exception
	 */
	public String getMonthLastOfDay(String parseDate) throws Exception{
		Date date = defaultFormat.parse(parseDate);
		Calendar cDay = Calendar.getInstance();         
		cDay.setTime(date);  
		cDay.set(Calendar.DAY_OF_MONTH, cDay.getActualMaximum(Calendar.DAY_OF_MONTH));  
		String monthDay = defaultFormat.format(cDay.getTime());
		return monthDay;
	}
	
	/**
	 * 日期转换获取此月的最后一天
	 * 默认格式 yyyy-MM-dd
	 * @param parseDate 转换日期
	 * @return
	 * @throws Exception
	 */
	public String getMonthLastOfDay(Date parseDate) throws Exception{
		Calendar cDay = Calendar.getInstance();         
		cDay.setTime(parseDate);  
		cDay.set(Calendar.DAY_OF_MONTH, cDay.getActualMaximum(Calendar.DAY_OF_MONTH));  
		String monthDay = defaultFormat.format(cDay.getTime());
		return monthDay;
	}
	
	
	/**
	 * 当前年的第一天
	 * 默认格式 yyyy-MM-dd
	 * @return
	 */
	public  String getCurrentYearFirstOfDay(){
		Date date = new Date();
		Calendar cDay = Calendar.getInstance();     
		cDay.setTime(date);  
		cDay.set(Calendar.DAY_OF_YEAR, 1);  
		String firstDay = defaultFormat.format(cDay.getTime());
		return firstDay;
	}
	
	/**
	 * 当前年的第一天
	 * @param format
	 * @return
	 */
	public  String getCurrentYearFirstOfDay(String format){
		SimpleDateFormat sf = new SimpleDateFormat(format);
		Date date = new Date();
		Calendar cDay = Calendar.getInstance();     
		cDay.setTime(date);  
		cDay.set(Calendar.DAY_OF_YEAR, 1);  
		String firstDay = sf.format(cDay.getTime());
		return firstDay;
	}
	
	
	/**
	 * 字符串转换日期获取此年的第一天
	 * 默认格式 yyyy-MM-dd
	 * @param parseDate 转换日期
	 * @return
	 * @throws Exception
	 */
	public  String getYearFirstOfDay(String parseDate) throws Exception{
		Date date = defaultFormat.parse(parseDate);
		Calendar cDay = Calendar.getInstance();     
		cDay.setTime(date);  
		cDay.set(Calendar.DAY_OF_YEAR, 1);  
		String firstDay = defaultFormat.format(cDay.getTime());
		return firstDay;
	}
	
	/**
	 * 符串转换日期获取此年的第一天
	 * @param parseDate
	 * @param format
	 * @return
	 * @throws Exception
	 */
	public  String getYearFirstOfDay(String parseDate, String format) throws Exception{
		SimpleDateFormat sf = new SimpleDateFormat(format);
		Date date = sf.parse(parseDate);
		Calendar cDay = Calendar.getInstance();     
		cDay.setTime(date);  
		cDay.set(Calendar.DAY_OF_YEAR, 1);  
		String firstDay = sf.format(cDay.getTime());
		return firstDay;
	}
	
	/**
	 * 日期转换获取此年的第一天
	 * 默认格式 yyyy-MM-dd
	 * @param parseDate 转换日期
	 * @return
	 * @throws Exception
	 */
	public  String getYearFirstOfDay(Date parseDate) throws Exception{
		Calendar cDay = Calendar.getInstance();     
		cDay.setTime(parseDate);  
		cDay.set(Calendar.DAY_OF_YEAR, 1);  
		String firstDay = defaultFormat.format(cDay.getTime());
		return firstDay;
	}
	
	
	
	/**
	 * 当前年的最后一天
	 * 默认格式 yyyy-MM-dd
	 * @return
	 */
	public String getCurrentYearLastOfDay(){
		Date date = new Date();
		Calendar cDay = Calendar.getInstance();     
		cDay.setTime(date);  
		cDay.set(Calendar.DAY_OF_YEAR, cDay.getActualMaximum(Calendar.DAY_OF_YEAR));  
		String lastDay = defaultFormat.format(cDay.getTime());
		return lastDay;
	}
	
	/**
	 * 当前年的最后一天
	 * @param format
	 * @return
	 */
	public String getCurrentYearLastOfDay(String format){
		Date date = new Date();
		Calendar cDay = Calendar.getInstance();     
		cDay.setTime(date);  
		cDay.set(Calendar.DAY_OF_YEAR, cDay.getActualMaximum(Calendar.DAY_OF_YEAR));  
		String lastDay = defaultFormat.format(cDay.getTime());
		return lastDay;
	}
	
	/**
	 * 字符串转换日期获取此年的最后一天
	 * 默认格式 yyyy-MM-dd
	 * @param parseDate 转换日期
	 * @return
	 * @throws Exception
	 */
	public String getYearLastOfDay(String parseDate) throws Exception{
		Date date = defaultFormat.parse(parseDate);
		Calendar cDay = Calendar.getInstance();     
		cDay.setTime(date);  
		cDay.set(Calendar.DAY_OF_YEAR, cDay.getActualMaximum(Calendar.DAY_OF_YEAR));  
		String lastDay = defaultFormat.format(cDay.getTime());
		return lastDay;
	}
	
	
	/**
	 * 日期转换获取此年的最后一天
	 * 默认格式 yyyy-MM-dd
	 * @param parseDate 转换日期
	 * @return
	 * @throws Exception
	 */
	public String getYearLastOfDay(Date parseDate) throws Exception{
		Calendar cDay = Calendar.getInstance();     
		cDay.setTime(parseDate);  
		cDay.set(Calendar.DAY_OF_YEAR, cDay.getActualMaximum(Calendar.DAY_OF_YEAR));  
		String lastDay = defaultFormat.format(cDay.getTime());
		return lastDay;
	}

	
	/**
	 * 数字拼凑日期格式化
	 * 默认格式 yyyy-MM-dd
	 * @param parseNumber 转换日期数字格式
	 * @return
	 * @throws Exception 
	 */
	public String getFormatNumberToDate(String parseNumber) throws Exception{
		SimpleDateFormat sf1 = new SimpleDateFormat("yyyyMMdd");
	    String result = defaultFormat.format(sf1.parse(parseNumber));
	    return result;
	}
	
	/**
	 * 日期格式转化
	 */
	public String getFormatDate(String parseDate,String format, String toFormat) throws Exception{
		SimpleDateFormat sf1 = new SimpleDateFormat(format);
		String result = "";
		if(null == toFormat)
			result = defaultFormat.format(sf1.parse(parseDate));
		else{
			SimpleDateFormat sf2 = new SimpleDateFormat(toFormat);
			result = sf2.format(sf1.parse(parseDate));
		}
	    return result;
	}
	
	
	/**
	 * 当前月的天数
	 * @return
	 */
	public Integer getMonthOfDay(){
		Date date = new Date();
		String year = yFormat.format(date);
		String month = mFormat.format(date);
		Calendar c=Calendar.getInstance(); 
		c.clear(); 
		c.set(Calendar.YEAR,Integer.parseInt(year)); 
		c.set(Calendar.MONTH,Integer.parseInt(month)-1);//注意,Calendar对象默认一月为0 
		int day=c.getActualMaximum(Calendar.DAY_OF_MONTH);//月份的天数 
		return day;
	}
	
	/**
	 * 日期的秒加减
	 * @param dateStr
	 * @param second
	 * @return
	 */
	public String modifiedSecond(String dateStr, Long second){
		try {
			Date date = timeFormat.parse(dateStr);
			Calendar calendar = Calendar.getInstance();//获得当前时间
			calendar.setTime(date);
			calendar.add(Calendar.SECOND, Integer.parseInt(second.toString()));
			Date time = calendar.getTime();//返回Date类
			return timeFormat.format(time);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 日期的分加减
	 * @param dateStr
	 * @param minute
	 * @return
	 */
	public String modifiedMinute(String dateStr, Long minute){
		try {
			Date date = timeFormat.parse(dateStr);
			Calendar calendar = Calendar.getInstance();//获得当前时间
			calendar.setTime(date);
			calendar.add(Calendar.MINUTE, Integer.parseInt(minute.toString()));
			Date time = calendar.getTime();//返回Date类
			return timeFormat.format(time);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 日期的日加减
	 * 默认格式 yyyy-MM-dd
	 * @param parseDate 转换日期
	 * @param parseNumber 加减数字
	 * @return
	 * @throws Exception
	 */
	public String modifiedDay(String parseDate, Integer parseNumber) throws Exception{
		Date date = defaultFormat.parse(parseDate);
		 Calendar c = Calendar.getInstance();
	     c.setTime(date);
	     c.add(Calendar.DAY_OF_YEAR,parseNumber);
	     Date time=c.getTime();
	     String result = defaultFormat.format(time);
		return result;
	}
	
	
	/**
	 * 日期的月加减
	 * 默认格式 yyyy-MM-dd
	 * @param parseDate 转换日期
	 * @param parseNumber 加减数字
	 * @return
	 * @throws Exception
	 */
	public String modifiedMonth(String parseDate, Integer parseNumber) throws Exception{
		Date date = defaultFormat.parse(parseDate);
		 Calendar c = Calendar.getInstance();
	     c.setTime(date);
	     c.add(Calendar.MONTH,parseNumber);
	     Date time=c.getTime();
	     String result = defaultFormat.format(time);
		return result;
	}
	
	
	/**
	 * 日期的年加减
	 * 默认格式 yyyy-MM-dd
	 * @param parseDate
	 * @param parseNumber
	 * @return
	 * @throws Exception
	 */
	public String modifiedYear(String parseDate, Integer parseNumber) throws Exception{
		Date date = defaultFormat.parse(parseDate);
		 Calendar c = Calendar.getInstance();
	     c.setTime(date);
	     c.add(Calendar.YEAR,parseNumber);
	     Date time=c.getTime();
	     String result = defaultFormat.format(time);
		return result;
	}
	
	
	/**
	 * 比较日期大小
	 * @param date1
	 * @param date2
	 * @return
	 */
	public String compareDate(String date1, String date2){
        try {
            Date dt1 = defaultFormat.parse(date1);
            Date dt2 = defaultFormat.parse(date2);
            if (dt1.getTime() > dt2.getTime()) {
               // System.out.println("dt1 在dt2前");
                return "1";
                
            } else if (dt1.getTime() < dt2.getTime()) {
            	return "-1";
                
            } else {
            	return "0";
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
		return "0";
	}
	
	
	/**
	 * 比较日期大小
	 * @param date1
	 * @param date2
	 * @return
	 */
	public String compareDate(String date1, String date2, String format){
        try {
        	SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date dt1 = sdf.parse(date1);
            Date dt2 = sdf.parse(date2);
            if (dt1.getTime() > dt2.getTime()) {
               // System.out.println("dt1 在dt2前");
                return "1";
                
            } else if (dt1.getTime() < dt2.getTime()) {
            	return "-1";
                
            } else {
            	return "0";
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
		return "0";
	}
	
	/**
	 * 通过数字获得天/时/分/秒. 
	 * @param second
	 * @return
	 */
	public String numberToTime(Integer second){
		//一天=24小时=24*60分=24*60*60秒
		Integer dayHelper = 24*60*60;
		Integer day = second/dayHelper;
		second = second%dayHelper;
		Integer hour = second/(60*60);
		second = second%(60*60);
		Integer minute = second/60;
		Integer seconds = second%60;
		
		return day+"天"+hour+"时"+minute+"分"+seconds+"秒";
	}
	
	/**
	 * 通过数字获得天/时/分/秒. 
	 * @param second
	 * @return
	 */
	public String numberToTime(Long second){
		//一天=24小时=24*60分=24*60*60秒
		Long dayHelper = (long) (24*60*60);
		Long day = (long) (second/dayHelper);
		second = second%dayHelper;
		Long hour = second/(60*60);
		second = second%(60*60);
		Long minute = second/60;
		Long seconds = second%60;
		
		return day+"天"+hour+"时"+minute+"分"+seconds+"秒";
	}
	
	
	/**
	 * 字符串类型获取时间差
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public Long getTimeDifference(String startDate, String endDate){
		try {
			Date start = timeFormat.parse(startDate);
			Date end = timeFormat.parse(endDate);
			//将两个日期毫秒相减法除以1000得到秒
			Long time = (start.getTime()-end.getTime())/(1000L);
			//返回绝对值
			return Math.abs(time);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0L;
	}
	
	/**
	 * 日期类型获取时间差
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public Long getTimeDifference(Date startDate, Date endDate){
		if(null != startDate && null != endDate){
			//将两个日期毫秒相减法除以1000得到秒
			Long time = (startDate.getTime()-endDate.getTime())/(1000L);
			
			//返回绝对值
			return Math.abs(time);
		}else{
			return 0L;
		}
			
	}
	
	
	/**
	 * 两个日期比较获取日期差距（年月）
	 * @param date1
	 * @param date2
	 * @return
	 */
	public int conversionTimeToYear(Date date1, Date date2){
		int year1 = Integer.parseInt( getYear(date1));
	    int year2 = Integer.parseInt(  getYear(date2) );
	    
	    if(year1>year2){
	    	int a = year1 - year2;
	    	int b = Integer.parseInt( getYear(date1) );
	    	int c = Integer.parseInt( getYear(date2) );
	    	
	    	if(b<c){
	    		a = a - 1;
	    	}
	    	return a;
	    	
	    }else if(year1<year2){
	    	int a = year2 - year1;
	    	int b = Integer.parseInt( getYear(date1) );
	    	int c = Integer.parseInt( getYear(date2) );
	    	if(b>c){
	    		a = a - 1;
	    	}
	    	return a;
	    	
	    }else{
	    	int a = 0;
	    	return a;
	    	
	    }
		
			
	}
	
	public static void main(String[] args) {
		DateUtil du = new DateUtil();
		System.out.println(du.numberToTime(3600L));
	}
}
