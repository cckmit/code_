package com.mika.credit.common.util;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("UnusedDeclaration")
public class UtilDateTime {
    public final static SimpleDateFormat stdTimeFormat = new SimpleDateFormat("HH:mm:ss");
    public final static SimpleDateFormat stdDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public final static SimpleDateFormat stdDatetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public final static SimpleDateFormat stdLongDatetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    public final static SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("HHmmss");
    public final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    public final static SimpleDateFormat simpleYearMonthFormat = new SimpleDateFormat("yyyyMM");
    public final static SimpleDateFormat simpleDatetimeFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    public final static SimpleDateFormat simpleLongDatetimeFormat = new SimpleDateFormat("yyyyMMddHHmmssS");

    public final static SimpleDateFormat yFormat = new SimpleDateFormat("yyyy");

    public final static SimpleDateFormat mFormat = new SimpleDateFormat("MM");

    public final static SimpleDateFormat dFormat = new SimpleDateFormat("dd");

    final static int[] m_seasonBeginTable = new int[]{
            Calendar.JANUARY, Calendar.JANUARY, Calendar.JANUARY,
            Calendar.APRIL, Calendar.APRIL, Calendar.APRIL,
            Calendar.JULY, Calendar.JULY, Calendar.JULY,
            Calendar.OCTOBER, Calendar.OCTOBER, Calendar.OCTOBER
    };
    private static TimeZone mTimeZone = TimeZone.getTimeZone("Asia/Shanghai");

    static {
        stdTimeFormat.setTimeZone(mTimeZone);
        stdDateFormat.setTimeZone(mTimeZone);
        stdDatetimeFormat.setTimeZone(mTimeZone);
        stdLongDatetimeFormat.setTimeZone(mTimeZone);

        simpleTimeFormat.setTimeZone(mTimeZone);
        simpleDateFormat.setTimeZone(mTimeZone);
        simpleYearMonthFormat.setTimeZone(mTimeZone);
        simpleDatetimeFormat.setTimeZone(mTimeZone);
        simpleLongDatetimeFormat.setTimeZone(mTimeZone);
    }

    /**
     * 比较两个日期是否相等
     */
    public static int compareDate(Date a, Date b) {
        // java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
        // date中,会保留有时间秒数.
        // java.sql.Date a = java.sql.Date.valueOf("2007-01-01");
        // a中,就没有时间秒数
        // 所以,在比较时就统一按字符串[yyyy-MM-dd]进行比较而不直接用a.compareTo(b)
        String stra = toStdDateString(a);
        String strb = toStdDateString(b);
        return stra.compareTo(strb);
    }

    /**
     * 根据自定义pattern获取字符串
     * @param date
     * @param pattern
     * @return
     */
    public static String getCustomString(Date date, String pattern){
        DateFormat df = new SimpleDateFormat(pattern);
        return df.format(date);
    }

    /**
     * Return a Timestamp for right now
     *
     * @return Timestamp for right now
     */
    public static Timestamp nowTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 获取今日
     *
     * @return 获取今日java.sql.Date类型日期；
     */
    public static java.sql.Date nowDate() {
        return new java.sql.Date(System.currentTimeMillis());
    }


    /**
     * 取得系统今天的时间串
     *
     * @return current datetime, pattern: "yyyy-MM-dd HH:mm:ss".
     */
    public static String nowStdDateTimeString() {
        return stdDatetimeFormat.format(nowTimestamp());
    }

    /**
     * 取得系统今天的时间串,包含毫秒
     *
     * @return current datetime, pattern: "yyyy-MM-dd HH:mm:ss.SSS".
     */
    public static String nowStdLongDateTimeString() {
        return stdLongDatetimeFormat.format(nowTimestamp());
    }

    /**
     * 获取标准今日日期串
     *
     * @return 今日日期字符串 yyyy-MM-dd；
     */
    public static String nowStdDateString() {
        return stdDateFormat.format(nowTimestamp());
    }

    /**
     * 获取当前标准时间串
     *
     * @return 今日日期字符串 HH:mm:ss
     */
    public static String nowStdTimeString() {
        return stdTimeFormat.format(nowTimestamp());
    }

    /**
     * 返回当前标准年月
     *
     * @return YYYY-MM
     */
    public static String nowStdYearMonth() {
        return nowStdDateString().substring(0, 7);
    }

    /**
     * 取得系统今天的时间串
     *
     * @return current datetime, pattern:"yyyyMMddHHmmss"
     */
    public static String nowDateTimeString() {
        return simpleDatetimeFormat.format(nowTimestamp());
    }

    /**
     * 取得系统今天的时间串(包含毫秒)
     *
     * @return current datetime, pattern:"yyyyMMddHHmmssS"
     */
    public static String nowLongDateTimeString() {
        return simpleLongDatetimeFormat.format(nowTimestamp());
    }

    /**
     * 获取今日日期串，不带分隔符
     *
     * @return 今日日期字符串 yyyyMMdd；
     */
    public static String nowDateString() {
        return simpleDateFormat.format(nowTimestamp());
    }

    /**
     * 获取年月日期串，不带分隔符
     *
     * @return 年月字符串 yyyyMM；
     */
    public static String nowYearMonthString(){
        return simpleYearMonthFormat.format(nowTimestamp());
    }
    /**
     * 获取当前时间串，不带分隔符
     *
     * @return 今日日期字符串 HHmmss；
     */
    public static String nowTimeString() {
        return simpleTimeFormat.format(nowTimestamp());
    }

    /**
     * 获取当前时间数字串，例如20100909121359 标识2010年09月09日 12时13分59秒
     *
     * @return Long
     */
    public static Long nowDateTimeNumber() {
        return Long.valueOf(nowDateTimeString());
    }

    /**
     * 获取今日
     *
     * @return Long，yyyymmdd，例如20100909
     */
    public static Long nowDateNumber() {
        return Long.valueOf(nowDateString());
    }

    public static String nowYear() {
        return nowStdDateString().substring(0, 4);
    }

    public static String nowYear(String stddate) {
        return stddate.substring(0, 4);
    }

    //两位的月
    public static String nowMonth2() {
        return nowStdDateString().substring(5, 7);
    }

    //获取当前日期所处月,却掉了前置的0.
    public static String nowMonth() {
        String month = nowMonth2();
        if (month.charAt(0) == '0') {
            return String.valueOf(month.charAt(1));
        }
        return month;
    }

    public static String nowYearMonthL() {
        return nowStdDateString().substring(0, 7).replaceAll("-", "");
    }

    public static String nowDay() {
        return nowStdDateString().substring(8, 10);
    }

    public static int nowHour() {
        Calendar calendar = getGMT8Calendar();
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * return a.minute() + minutes
     */
    public static java.sql.Date getAfterMinute(Date d, int minutes) {
        if (d == null) return null;
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeZone(mTimeZone);
        gc.setTime(d);
        gc.add(GregorianCalendar.MINUTE, minutes);
        return new java.sql.Date(gc.getTimeInMillis());
    }

    /**
     * 得到date + days的日期
     *
     * @param dt   日期
     * @param days 间隔天数，正数往前，负数往后
     * @return String java.sql.Date.toString()
     */
    public static String getAfterDays(Date dt, int days) {
        if (dt == null) return "";
        if (days == 0) return dt.toString();
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeZone(mTimeZone);
        gc.setTime(dt);
        gc.add(GregorianCalendar.DATE, days);
        java.sql.Date ret = new java.sql.Date(gc.getTimeInMillis());
        return ret.toString();
    }

    /**
     * 得到date + days的日期
     *
     * @param date      日期(yyyy-mm-dd)
     * @param days      间隔天数，正数往前，负数往后
     * @param include67 是否包含星期六和星期日
     */
    public static String getAfterDays(String date, int days, boolean include67) {
        if (include67 || days == 0) return getAfterDays(date, days);
        //要剔除信息，需要特殊处理
        int absd = Math.abs(days);
        int step = days > 0 ? 1: -1;
        java.sql.Date in = toDateDefaultNow(date);
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeZone(mTimeZone);
        gc.setTimeInMillis(in.getTime());
        //这里要判断days是正数还是负数，正数是未来，负数是过去
        for (int d = 0; d < absd; ) {
            //获取当前是星期几；
            int w = gc.get(GregorianCalendar.DAY_OF_WEEK);
            // [ 星期日 | w | 星期六 ]
            if (w > GregorianCalendar.SUNDAY && w < GregorianCalendar.SATURDAY) {
                ++d;
            }
            // 向前或向后逐天循环；
            gc.add(GregorianCalendar.DATE, step);
        }
        java.sql.Date dr = new java.sql.Date(gc.getTimeInMillis());
        return dr.toString();
    }

    public static java.sql.Date getAfterDate(Date dt, int days) {
        if (dt == null) return null;
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dt);
        gc.add(GregorianCalendar.DATE, days);
        return new java.sql.Date(gc.getTimeInMillis());
    }

    /**
     * 得到date + days的日期
     *
     * @param dt   日期(yyyy-mm-dd)
     * @param days 间隔天数，正数往前，负数往后
     * @return String java.sql.Date.toString()
     */
    public static String getAfterDays(String dt, int days) {
        if (days == 0) return dt;
        try {
            return getAfterDays(java.sql.Date.valueOf(dt), days);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 取与指定日期间隔月的日期(yyyy-mm-dd)
     *
     * @return String java.sql.Date.toString()
     */
    public static String getAfterMonth(Date dt, int months) {
        if (dt == null) return "";
        if (months == 0) return dt.toString();
        GregorianCalendar dy = new GregorianCalendar();
        dy.setTime(dt);
        dy.add(GregorianCalendar.MONTH, months);
        java.sql.Date ret = new java.sql.Date(dy.getTimeInMillis());
        return ret.toString();
    }

    /**
     * 取与指定日期间隔月的日期(yyyy-mm-dd)
     *
     * @param dt     (yyyy-mm-dd)
     * @param months 间隔月
     * @return java.sql.Date.toString()
     */
    public static String getAfterMonth(String dt, int months) {
        return getAfterMonth(java.sql.Date.valueOf(dt), months);
    }

    /**
     * 取与指定日期间隔年的日期
     *
     * @return String java.sql.Date.toString()
     */
    public static String getAfterYear(Date dt, int years) {
        if (dt == null) return "";
        if (years == 0) return dt.toString();
        GregorianCalendar dy = new GregorianCalendar();
        dy.setTime(dt);
        dy.add(GregorianCalendar.YEAR, years);
        java.sql.Date ret = new java.sql.Date(dy.getTimeInMillis());
        return ret.toString();
    }

    /**
     * 取与指定日期间隔年的日期
     *
     * @param dt    (yyyy-mm-dd)
     * @param years 间隔年         j
     * @return java.sql.Date.toString()
     */
    public static String getAfterYear(String dt, int years) {
        return getAfterYear(java.sql.Date.valueOf(dt), years);
    }

    /**
     * get days between fromDate and thruDate
     *
     * @return the days between fromDate and thruDate
     */
    public static int getDifferDays(Date f, Date t) throws IllegalArgumentException {
        return getDifferSeconds(f, t) / (24 * 60 * 60);
    }

    public static int getDifferMinutes(Date f, Date t) throws IllegalArgumentException {
        return getDifferSeconds(f, t) / 60;
    }

    public static int getDifferMinutes(String f, String t) throws IllegalArgumentException {
        return getDifferSeconds(Timestamp.valueOf(f), Timestamp.valueOf(t)) / 60;
    }

    public static int getDifferSeconds(Date f, Date t) throws IllegalArgumentException {
        if (f == null || t == null) return 0;
        if (t.compareTo(f) < 0) {
            String msg = "[" + t + "] 比" + "[" + f + "] 早, 应该相反!";
            throw new IllegalArgumentException(msg);
        }
        return (int) ((t.getTime() - f.getTime()) / 1000);
    }


    /**
     * 判断strDate 是否是日期格式的字符串(支持如 yyyy-mm-dd)。
     *
     * @param strDate 字符串，判断其是否为日期格式。
     * @return boolean 如果为日期格式则返回=true;
     */
    public static boolean isDateFormat(String strDate) {
        return isDateFormat(strDate, "YYYY-MM-DD");
    }

    /**
     * 判断strDate 是否是日期格式的字符串。
     *
     * @param strDate 字符串，判断其是否为日期格式。
     * @param format  字符串，YYYY-MM,YYYYMM,YYYYMMDD,YYYY-MM-DD,YYYY-MM-DD:HH, 空表示所有上述格式,非上述内容将默认为YYYY-MM-DD；
     * @return boolean 如果为日期格式则返回=true;
     */
    public static boolean isDateFormat(String strDate, String format) {
        if (UtilPub.isEmpty(strDate)) {
            return false;
        }
        if (UtilPub.isEmpty(format)) {
            format = "YYYY-MM-DD";
        }
        switch (format) {
            case "YYYY-MM":
                return strDate.matches("\\d{4}-\\d{2}") && isDateValue(strDate.substring(0, 4), strDate.substring(5), "01");
            case "YYYYMM":
                return strDate.matches("\\d{6}") && isDateValue(strDate.substring(0, 4), strDate.substring(4), "01");
            case "YYYYMMDD":
                return strDate.matches("\\d{8}") && isDateValue(strDate.substring(0, 4), strDate.substring(4, 6), strDate.substring(6));
            case "YYYY-MM-DD":
                return strDate.matches("\\d{4}-\\d{2}-\\d{2}") && isDateValue(strDate.substring(0, 4), strDate.substring(5, 7), strDate.substring(8));
            case "YYYY-MM-DD:HH":
                return strDate.matches("\\d{4}-\\d{2}-\\d{2}:[0-5][0-9]") && isDateValue(strDate.substring(0, 4), strDate.substring(5, 7), strDate.substring(8, 10));
            case "HHmmss":
                return strDate.matches("[0-5][0-9][0-5][0-9][0-5][0-9]") && isTimeValue(strDate.substring(0, 2), strDate.substring(2, 4), strDate.substring(4));
            default:
                return false;
        }
    }

    public static boolean isDateValue(String year, String month, String day) {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        s.setLenient(false);//这个的功能是不把1996-13-3 转换为1997-1-3
        try {
            s.parse(year + "-" + month + "-" + day);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static boolean isTimeValue(String hour, String min, String sec) {
        SimpleDateFormat s = new SimpleDateFormat("HH:mm:ss");
        s.setLenient(false);
        try {
            s.parse(hour + ":" + min + ":" + sec);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }


    /**
     * a是否小于当前日期
     */
    public static boolean isLessThanCurrentDate(java.sql.Date a) {
        int i = compareDate(a, new java.sql.Date(System.currentTimeMillis()));
        return i < 0;
    }

    /**
     * a是否小于b
     */
    public static boolean isLessThanCurrentDate(java.sql.Date a, java.sql.Date b) {
        int i = compareDate(a, b);
        return i < 0;
    }

    /**
     * 检查beging + days 是否在end前[包括end];(如:招行开始日期与结束日期之差只能在100以内)
     *
     * @return false 大于了end
     */
    public static boolean isBeforeDate(Date beging, int days, Date end) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeZone(mTimeZone);
        gc.setTime(beging);
        gc.add(GregorianCalendar.DATE, days - 1);
        Date addDate = gc.getTime();
        return (end.compareTo(addDate) <= 0);
    }


    /**
     * 得到如下字符串 "YYYY-MM-DD HH:MM:SS"
     *
     * @param d 时间戳，如果传入为null,则返回“”；
     * @return 日期时间串
     */
    public static String toStdDateTimeString(Date d) {
        if (d == null) return "";
        return stdDatetimeFormat.format(d);
    }

    /**
     * 得到如下字符串 "YYYY-MM-DD HH:MM:SS"
     *
     * @param d long, 例如20110304131101
     * @return 日期时间串，如：2011-03-04 13:11:01
     */
    public static String toStdDateTimeString(long d) {
        return toStdDateTimeString(String.valueOf(d));
    }

    /**
     * 得到如下字符串 "YYYY-MM-DD HH:MM:SS"
     *
     * @param d String, 例如20110304131101
     * @return 日期时间串，如：2011-03-04 13:11:01
     */
    public static String toStdDateTimeString(String d) {
        if (d == null || d.length() != 14) return "";
        return toStdDateString(d.substring(0, 8)) + " " + d.substring(8, 10) + ":" + d.substring(10, 12) + ":" + d.substring(12);
    }

    /**
     * 得到如下格式字符串 "YYYY-MM-DD"
     *
     * @param d 时间戳 如果传入为null,则返回“”；
     * @return 日期时间串
     */
    public static String toStdDateString(Date d) {
        if (d == null) return "";
        return stdDateFormat.format(d);
    }

    /**
     * 将yyyyMMdd变为yyyy-mm-dd
     *
     * @param s 原日期串，默认用-进行分割
     * @return yyyy-mm-dd
     */
    public static String toStdDateString(String s) {
        return toStdDateString(s, "-", false);
    }

    /**
     * 将yyyyMMdd日期串用分隔符进行分割
     *
     * @param s                    原日期串，默认用-进行分割
     * @param split                分隔符；
     * @param returnEmptyIfErrDate 如果不是8位的日期串，则控制是反馈“”，还是返回原串；
     * @return 用分隔符，如“-”，“.”进行分割后的日期串；
     */
    public static String toStdDateString(String s, String split, boolean returnEmptyIfErrDate) {
        try {
            if (s == null || s.length() < 8) {
                return returnEmptyIfErrDate ? "": s;
            }
            return s.substring(0, 4) + split + s.substring(4, 6) + split + s.substring(6, 8);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 将yyyy-M-d转成yyyy-MM-dd格式
     *
     * @param s
     * @return
     */
    public static String toStdDateStringEx(String s) {
        try {
            String[] ss = s.split("-");
            if (ss.length < 3) return "";
            return ss[0] + "-" + (ss[1].length() == 2 ? ss[1]: ("0" + ss[1])) + "-" + (ss[2].length() == 2 ? ss[2]: ("0" + ss[2]));
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 将20010101类型数字分割为2001-01-01，默认分隔符为"-";
     *
     * @param l long
     * @return yyyy-mm-dd
     */
    public static String toStdDateString(long l) {
        return toStdDateString(String.valueOf(l), "-", false);
    }

    /**
     * 将20010101格式的数据转换成2001?01?01格式的显示，?标识分隔符
     *
     * @param l                    日期
     * @param split                分隔符；
     * @param returnEmptyIfErrDate 如果不是8位的日期串，则控制是反馈“”，还是返回原串；
     * @return 2001-01-01
     */
    public static String toStdDateString(long l, String split, boolean returnEmptyIfErrDate) {
        return toStdDateString(String.valueOf(l), split, returnEmptyIfErrDate);
    }

    /**
     * 得到如下字符串 "HH:mm:ss"
     *
     * @param date 时间戳，如果传入为null,则返回为当前日期；
     * @return 时间串
     */
    public static String toStdTimeString(Date date) {
        if (date == null) date = nowDate();
        return stdTimeFormat.format(date);
    }

    /**
     * 将日期变为"yyyyMMdd"
     *
     * @param date 日期
     * @return 字符串，如果传入参数为null,则返回当前日期；
     */
    public static String toDateString(Date date) {
        if (date == null) date = nowDate();
        return simpleDateFormat.format(date);
    }

    /**
     * 得到如下字符串 "HHmmss"
     *
     * @param date 时间戳 如果传入为NULL,则返回当前日期；
     * @return 时间串
     */
    public static String toTimeString(Date date) {
        if (date == null) date = nowDate();
        return simpleTimeFormat.format(date);
    }

    /**
     * 得到长日期时间字符[yyyyMMddHHmmss]
     *
     * @param date 时间戳，如果传入为null,则返回当前日期
     * @return 日期时间串
     */
    public static String toDateTimeString(Date date) {
        if (date == null) date = nowDate();
        return simpleDatetimeFormat.format(date);
    }

    /**
     * 得到长日期时间字符[yyyyMMddHHmmssS]
     *
     * @param date 时间戳，如果传入为null,则返回当前日期
     * @return 日期时间串，长
     */
    public static String toLongDateTimeString(Date date) {
        if (date == null) date = nowDate();
        return simpleLongDatetimeFormat.format(date);
    }

    /**
     * 将日期格式：2010-01-01,2011.01.01,2011年01月01日转换成数字；
     *
     * @param ds 日期字符串
     * @return Long, 例如20100101
     */
    public static Long toDateNumber(String ds) {
        if (UtilPub.isEmpty(ds) || "-1".equals(ds) || "0".equals(ds)) return -1L;
        try {
            //即去掉串中的非数字字符；
            Pattern pattern = Pattern.compile("\\D", Pattern.DOTALL);
            Matcher matcher = pattern.matcher(ds);
            return Long.valueOf(matcher.replaceAll(""));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return -1L;
        }
    }

    /**
     * 将strDateTime换成Timestamp对象，如果不能转会，则返回当前时间戳。
     *
     * @param datetime 一个时间格式的字符串；
     * @return 如果strDateTime 有效，则返回它的时间戳，否则返回当前系统时间戳.
     */
    public static Timestamp toTimestampDefaultNow(String datetime) {
        try {
            return Timestamp.valueOf(datetime);
        } catch (Exception e) {
            return nowTimestamp();
        }
    }

    /**
     * 将字符串转换成Java.sql.Date,不能转换，这返回null
     *
     * @param src 源串
     * @return java.sql.Date
     */
    public static java.sql.Date toDate(String src) {
        try {
            if (UtilPub.isEmpty(src)) return null;
            return java.sql.Date.valueOf(src);
        } catch (Exception e) {
            return null;
        }
    }

    public static java.sql.Date toDate(Timestamp datetime) {
        if (datetime == null) return null;
        return new java.sql.Date(datetime.getTime());
    }

    /**
     * 将字符串转换成Java.sql.Date,不能转换，则返回当前日期
     *
     * @param src 源串
     * @return java.sql.Date
     */
    public static java.sql.Date toDateDefaultNow(String src) {
        try {
            if (UtilPub.isEmpty(src)) return nowDate();
            return java.sql.Date.valueOf(src);
        } catch (Exception e) {
            return nowDate();
        }
    }

    /**
     * 将字符串转换成Java.sql.Date,不能转换，则返回当前日期
     *
     * @param datetime 源串
     * @return java.sql.Date
     */
    public static java.sql.Date toDateDefaultNow(Timestamp datetime) {
        if (datetime == null) return nowDate();
        return new java.sql.Date(datetime.getTime());
    }

    /**
     * Makes a Date from separate ints for month, day, year, hour, minute, and second.
     *
     * @param month  The month int
     * @param day    The day int
     * @param year   The year int
     * @param hour   The hour int
     * @param minute The minute int
     * @param second The second int
     * @return A Date made from separate ints for month, day, year, hour, minute, and second.
     */
    public static java.sql.Date toDate(int month, int day, int year, int hour, int minute, int second) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.set(year, month - 1, day, hour, minute, second);
        } catch (Exception e) {
            return null;
        }
        return new java.sql.Date(calendar.getTime().getTime());
    }

    /**
     * Makes a Date from separate Strings for month, day, year, hour, minute, and second.
     *
     * @param monthStr  The month String
     * @param dayStr    The day String
     * @param yearStr   The year String
     * @param hourStr   The hour String
     * @param minuteStr The minute String
     * @param secondStr The second String
     * @return A Date made from separate Strings for month, day, year, hour, minute, and second.
     */
    public static java.sql.Date toDate(String monthStr, String dayStr, String yearStr, String hourStr, String minuteStr, String secondStr) {
        int month, day, year, hour, minute, second;
        try {
            month = Integer.parseInt(monthStr);
            day = Integer.parseInt(dayStr);
            year = Integer.parseInt(yearStr);
            hour = Integer.parseInt(hourStr);
            minute = Integer.parseInt(minuteStr);
            second = Integer.parseInt(secondStr);
        } catch (Exception e) {
            return null;
        }
        return toDate(month, day, year, hour, minute, second);
    }

    public static Calendar getGMT8Calendar() {
        return Calendar.getInstance(mTimeZone);
    }

    /**
     * 用中方格式化年月日
     *
     * @param yearMonth YYYYMM
     */
    public static String fmtZHCNYearMonth(String yearMonth) {
        if (UtilPub.getIntIgnoreErr(yearMonth) > 190000)
            return String.format("%s-%s", yearMonth.substring(0, 4), yearMonth.substring(4));
        return "";
    }

    /**
     * 用中方格式化年月日
     *
     * @param stdYearMonthDay YYYY-MM-DD
     */
    public static String fmtZHCNYearMonthDay(String stdYearMonthDay) {
        return String.format("%s年%s月%s日", stdYearMonthDay.substring(0, 4), stdYearMonthDay.substring(5, 7), stdYearMonthDay.substring(8));
    }


    public static String getYearFirstDay() {
        return nowYear() + "-01-01";
    }

    public static String getYearLastDay() {
        return nowYear() + "-12-31";
    }

    /**
     * 得到本季度的第一天
     *
     * @return
     */
    public static String getSeasonFirstDay() {
        return toStdDateString(getSeasonBegin());
    }

    /**
     * 得到本季度最后一天
     *
     * @return
     */
    public static String getSeasonLastDay() {
        String s = toStdDateString(getNextSeasonBegin());
        return getAfterDays(s, -1);
    }

    //季度开始
    public static Date getSeasonBegin() {
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        int curMonth = now.get(Calendar.MONTH);
        int seasonMonth = m_seasonBeginTable[curMonth];

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.MONTH, seasonMonth);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.AM_PM, Calendar.AM);
        return new Timestamp(calendar.getTime().getTime());
    }

    //下个季度开始
    public static Date getNextSeasonBegin() {
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        int curMonth = now.get(Calendar.MONTH);
        int seasonMonth = m_seasonBeginTable[curMonth] + 3;

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.MONTH, seasonMonth);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.AM_PM, Calendar.AM);
        return new Timestamp(calendar.getTime().getTime());
    }

    /**
     * 取得当月第一天日期串YYYY-MM-DD
     *
     * @return 月第一天的标准日期串
     */
    public static String getMonthStart() {
        return nowStdYearMonth() + "-01";
    }

    /**
     * 取得指定日期所在月第一天日期串YYYY-MM-DD
     *
     * @return 月第一天的标准日期串
     */
    public static String getMonthStart(Date d) {
        if (d == null) return "";
        return toStdDateString(d).substring(0, 7) + "-01";
    }

    /**
     * 取得当月最后一天YYYY-MM-DD
     *
     * @return 当前月最后一天的日期串；
     */
    public static String getMonthEnd() {
        return getAfterDays(getAfterMonth(getMonthStart(), 1), -1);
    }

    /**
     * 取得指定日期所在月最后一天YYYY-MM-DD
     *
     * @return 所在前月最后一天的日期串；
     */
    public static String getMonthEnd(Date d) {
        return getAfterDays(getAfterMonth(getMonthStart(d), 1), -1);
    }

    /**
     * 取得当月第一天日期串
     *
     * @return String
     */
    public static String getMonthFirstDay() {
        return nowMonth2() + "-01";
    }

    /**
     * 取得当月最后一天
     *
     * @return String
     */
    public static String getMonthLastDay() {
        return getAfterDays(getAfterMonth(getMonthFirstDay(), 1), -1);
    }


    /**
     * 得到当前日期所在周次的星期一
     *
     * @return 返回的时间戳
     */
    public static Timestamp getWeekStart() {
        return getWeekStart(new Timestamp(System.currentTimeMillis()));
    }

    /**
     * 得到日期所在周次的星期一
     *
     * @param stamp 参数时间戳，如果传入为null,则返回为null
     * @return 返回时间戳
     */
    public static Timestamp getWeekStart(Timestamp stamp) {
        if (stamp == null) return null;
        GregorianCalendar tempCal = new GregorianCalendar(mTimeZone);
        tempCal.setTime(stamp);
        tempCal.set(tempCal.get(Calendar.YEAR), tempCal.get(Calendar.MONTH), tempCal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        if (tempCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            // AKzz fix bug:
            // 如果今天是星期天, 天数再减1,找到上周(外国人的星期天是本周).
            tempCal.add(Calendar.DATE, -1);                 // 再将天数减一
        }
        tempCal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); // 设为星期一.

        Timestamp retStamp = new Timestamp(tempCal.getTime().getTime());
        retStamp.setNanos(0);
        return retStamp;
    }

    /**
     * 当前日期的下周星期一
     */
    public static Timestamp getNextWeekStart() {
        return getNextWeekStart(new Timestamp(System.currentTimeMillis()));
    }

    /**
     * 当前日期的下周星期一,如果传入null,则返回为null
     *
     * @param t 要计算的时间戳
     * @return 返回的时间戳
     */
    public static Timestamp getNextWeekStart(Timestamp t) {
        if (t == null) return null;
        Calendar tempCal = new GregorianCalendar(mTimeZone);
        tempCal.setTime(t);
        tempCal.set(tempCal.get(Calendar.YEAR), tempCal.get(Calendar.MONTH), tempCal.get(Calendar.DAY_OF_MONTH),
                // 没有时,分,秒
                0, 0, 0);
        tempCal.add(Calendar.WEEK_OF_MONTH, 1);             // 周数加1
        tempCal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); // 设为星期一.

        Timestamp retStamp = new Timestamp(tempCal.getTime().getTime());
        retStamp.setNanos(0);
        return retStamp;
    }

    //获取年月，YYYYMM格式
    public static String getDateYm(Date dt) {
        String s = simpleDateFormat.format(dt);
        return s.substring(0, 6);
    }

    //获取年月，YYYYMM格式
    public static String getNowYm() {
        return getDateYm(nowTimestamp());
    }

    //获取季度开始年月，YYYYMM格式
    public static String getSeasonBeginYm() {
        return getDateYm(getSeasonBegin());
    }

    //获取季度结束年月，YYYYMM格式
    public static String getSeasonEndYm() {
        return getDateYm(getAfterDate(getNextSeasonBegin(), -1));
    }

    //获取年度开始年月，YYYYMM格式
    public static String getYearBeginYm() {
        return nowYear() + "01";
    }

    //获取年度结束年月，YYYYMM格式
    public static String getYearEndYm() {
        return nowYear() + "12";
    }

    //获取上一月，YYYYMM格式
    public static String getPrevYm(String period_id) {
        return getNextYm(period_id, -1);
    }

    //获取下一月，YYYYMM格式
    public static String getNextYm(String period_id) {
        return getNextYm(period_id, 1);
    }

    public static String getNextYm(String period_id, int add) {
        if (UtilPub.isEmptyId(period_id)) return period_id;
        int curYear = Integer.parseInt(period_id.substring(0, 4));
        int curMonth = Integer.parseInt(period_id.substring(4)) + add;
        if (curMonth > 12) {
            do {
                curYear++;
                curMonth -= 12;
            } while (curMonth > 12);
        } else if (curMonth <= 0) {
            do {
                curYear--;
                curMonth += 12;
            } while (curMonth <= 0);
        }
        return curYear + UtilString.getRight("00" + curMonth, 2);
    }

    //取小的月份
    public static String min(String p1, String p2) {
        if ("-1".equals(p1)) return p2;
        if ("-1".equals(p2)) return p1;
        p1 = UtilPub.checkNull(p1);
        p2 = UtilPub.checkNull(p2);
        if (p1.compareTo(p2) < 0) return p1;
        return p2;
    }

    //取大的月份
    public static String max(String p1, String p2) {
        if ("-1".equals(p1)) return p2;
        if ("-1".equals(p2)) return p1;
        p1 = UtilPub.checkNull(p1);
        p2 = UtilPub.checkNull(p2);
        if (p1.compareTo(p2) < 0) return p2;
        return p1;
    }

    public static int compareYm(String ym1, String ym2) {
        boolean isEmpty1 = UtilPub.isEmptyId(ym1);
        boolean isEmpty2 = UtilPub.isEmptyId(ym2);
        if (isEmpty1 && isEmpty2) return 0;
        if (isEmpty1) return -1;
        if (isEmpty2) return 1;
        return ym1.compareTo(ym2);
    }

    /**
     * 当前时间
     * 默认格式 yyyy-MM-dd
     * @return
     */
    public static String getCurrentDate(){
        Date date = new Date();
        String result = stdDateFormat.format(date);
        return result;
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
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            result = sdf.format(date);
        }else{
            result = stdDateFormat.format(date);
        }
        return result;
    }


    /**
     * 字符串转换日期
     * @param date
     * @return
     */
    public static Date conversionDate(String date){
        Date result = null;
        try {
            result = stdDateFormat.parse(date);
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
    public static String getCurrentYear(){
        Date date = new Date();
        String year = yFormat.format(date);
        return year;
    }

    /**
     * 字符串转换年
     * @param parseDate 转换日期
     * @return
     */
    public static String getYear(String parseDate){
        String year = "";
        try {
            year = yFormat.format(stdDateFormat.parse(parseDate));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return year;
    }

    /**
     * 字符串转换年
     * @param parseDate 转换日期
     * @param pattern 传入日期的格式
     * @return
     */
    public static String getYear(String parseDate, String pattern){
        String year = "";
        DateFormat df = new SimpleDateFormat(pattern);
        try {
            year = yFormat.format(df.parse(parseDate));
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
    public static String getYear(Date parseDate){
        return yFormat.format(parseDate);
    }

    /**
     * 当前月
     * @return
     */
    public static String getCurrentMonth(){
        Date date = new Date();
        String month = mFormat.format(date);
        return month;
    }

    /**
     * 字符串转换月
     * @param parseDate 转换日期
     * @return
     */
    public static String getMonth(String parseDate){
        String month = "";
        try {
            month = mFormat.format(stdDateFormat.parse(parseDate));
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
    public static String getMonth(Date parseDate){
        String month = mFormat.format(parseDate);
        return month;
    }

    /**
     * 当前日
     * @return
     */
    public static String getDay(){
        Date date = new Date();
        String day = dFormat.format(date);
        return day;
    }

    /**
     * 字符串转换日
     * @param parseDate 转换日期
     * @return
     */
    public static String getDay(String parseDate){
        String day = dFormat.format(parseDate);
        return day;
    }

    /**
     * 日期转换日
     * @param parseDate 转换日期
     * @return
     */
    public static String getDay(Date parseDate){
        String day = dFormat.format(parseDate);
        return day;
    }

    /**
     * 当前月的第一天
     * 默认格式 yyyy-MM-dd
     * @return
     */
    public static String getCurrentMonthFirstOfDay(){
        Date date = new Date();
        Calendar cDay = Calendar.getInstance();
        cDay.setTime(date);
        cDay.set(Calendar.DAY_OF_MONTH, 1);
        String monthDay = stdDateFormat.format(cDay.getTime());
        return monthDay;
    }

    /**
     * 当前月的第一天
     * @param format
     * @return
     */
    public static String getCurrentMonthFirstOfDay(String format){
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
    public static String getMonthFirstOfDay(String parseDate) throws Exception{
        Date date = stdDateFormat.parse(parseDate);
        Calendar cDay = Calendar.getInstance();
        cDay.setTime(date);
        cDay.set(Calendar.DAY_OF_MONTH, 1);
        String monthDay = stdDateFormat.format(cDay.getTime());
        return monthDay;
    }



    /**
     * 日期转换获取此月第一天
     * 默认格式 yyyy-MM-dd
     * @param parseDate 转换日期
     * @return
     * @throws Exception
     */
    public static String getMonthFirstOfDay(Date parseDate) throws Exception{
        Calendar cDay = Calendar.getInstance();
        cDay.setTime(parseDate);
        cDay.set(Calendar.DAY_OF_MONTH, 1);
        String monthDay = stdDateFormat.format(cDay.getTime());
        return monthDay;
    }

    /**
     * 当前月的最后一天
     * 默认格式 yyyy-MM-dd
     * @return
     * @throws Exception
     */
    public static String getCurrentMonthLastOfDay() throws Exception{
        Date date = new Date();
        Calendar cDay = Calendar.getInstance();
        cDay.setTime(date);
        cDay.set(Calendar.DAY_OF_MONTH, cDay.getActualMaximum(Calendar.DAY_OF_MONTH));
        String monthDay = stdDateFormat.format(cDay.getTime());
        return monthDay;
    }

    /**
     * 当前月的最后一天
     * @param format
     * @return
     * @throws Exception
     */
    public static String getCurrentMonthLastOfDay(String format) throws Exception{
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
    public static String getMonthLastOfDay(String parseDate) throws Exception{
        Date date = stdDateFormat.parse(parseDate);
        Calendar cDay = Calendar.getInstance();
        cDay.setTime(date);
        cDay.set(Calendar.DAY_OF_MONTH, cDay.getActualMaximum(Calendar.DAY_OF_MONTH));
        String monthDay = stdDateFormat.format(cDay.getTime());
        return monthDay;
    }

    /**
     * 日期转换获取此月的最后一天
     * 默认格式 yyyy-MM-dd
     * @param parseDate 转换日期
     * @return
     * @throws Exception
     */
    public static String getMonthLastOfDay(Date parseDate) throws Exception{
        Calendar cDay = Calendar.getInstance();
        cDay.setTime(parseDate);
        cDay.set(Calendar.DAY_OF_MONTH, cDay.getActualMaximum(Calendar.DAY_OF_MONTH));
        String monthDay = stdDateFormat.format(cDay.getTime());
        return monthDay;
    }


    /**
     * 当前年的第一天
     * 默认格式 yyyy-MM-dd
     * @return
     */
    public static String getCurrentYearFirstOfDay(){
        Date date = new Date();
        Calendar cDay = Calendar.getInstance();
        cDay.setTime(date);
        cDay.set(Calendar.DAY_OF_YEAR, 1);
        String firstDay = stdDateFormat.format(cDay.getTime());
        return firstDay;
    }

    /**
     * 当前年的第一天
     * @param format
     * @return
     */
    public static String getCurrentYearFirstOfDay(String format){
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
    public static String getYearFirstOfDay(String parseDate) throws Exception{
        Date date = stdDateFormat.parse(parseDate);
        Calendar cDay = Calendar.getInstance();
        cDay.setTime(date);
        cDay.set(Calendar.DAY_OF_YEAR, 1);
        String firstDay = stdDateFormat.format(cDay.getTime());
        return firstDay;
    }

    /**
     * 符串转换日期获取此年的第一天
     * @param parseDate
     * @param format
     * @return
     * @throws Exception
     */
    public static String getYearFirstOfDay(String parseDate, String format) throws Exception{
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
    public static String getYearFirstOfDay(Date parseDate) throws Exception{
        Calendar cDay = Calendar.getInstance();
        cDay.setTime(parseDate);
        cDay.set(Calendar.DAY_OF_YEAR, 1);
        String firstDay = stdDateFormat.format(cDay.getTime());
        return firstDay;
    }



    /**
     * 当前年的最后一天
     * 默认格式 yyyy-MM-dd
     * @return
     */
    public static String getCurrentYearLastOfDay(){
        Date date = new Date();
        Calendar cDay = Calendar.getInstance();
        cDay.setTime(date);
        cDay.set(Calendar.DAY_OF_YEAR, cDay.getActualMaximum(Calendar.DAY_OF_YEAR));
        String lastDay = stdDateFormat.format(cDay.getTime());
        return lastDay;
    }

    /**
     * 当前年的最后一天
     * @param format
     * @return
     */
    public static String getCurrentYearLastOfDay(String format){
        Date date = new Date();
        Calendar cDay = Calendar.getInstance();
        cDay.setTime(date);
        cDay.set(Calendar.DAY_OF_YEAR, cDay.getActualMaximum(Calendar.DAY_OF_YEAR));
        String lastDay = stdDateFormat.format(cDay.getTime());
        return lastDay;
    }

    /**
     * 字符串转换日期获取此年的最后一天
     * 默认格式 yyyy-MM-dd
     * @param parseDate 转换日期
     * @return
     * @throws Exception
     */
    public static String getYearLastOfDay(String parseDate) throws Exception{
        Date date = stdDateFormat.parse(parseDate);
        Calendar cDay = Calendar.getInstance();
        cDay.setTime(date);
        cDay.set(Calendar.DAY_OF_YEAR, cDay.getActualMaximum(Calendar.DAY_OF_YEAR));
        String lastDay = stdDateFormat.format(cDay.getTime());
        return lastDay;
    }


    /**
     * 日期转换获取此年的最后一天
     * 默认格式 yyyy-MM-dd
     * @param parseDate 转换日期
     * @return
     * @throws Exception
     */
    public static String getYearLastOfDay(Date parseDate) throws Exception{
        Calendar cDay = Calendar.getInstance();
        cDay.setTime(parseDate);
        cDay.set(Calendar.DAY_OF_YEAR, cDay.getActualMaximum(Calendar.DAY_OF_YEAR));
        String lastDay = stdDateFormat.format(cDay.getTime());
        return lastDay;
    }


    /**
     * 数字拼凑日期格式化
     * 默认格式 yyyy-MM-dd
     * @param parseNumber 转换日期数字格式
     * @return
     * @throws Exception
     */
    public static String getFormatNumberToDate(String parseNumber) throws Exception{
        SimpleDateFormat sf1 = new SimpleDateFormat("yyyyMMdd");
        String result = stdDateFormat.format(sf1.parse(parseNumber));
        return result;
    }

    /**
     * 日期格式转化
     */
    public static String getFormatDate(String parseDate,String format, String toFormat) throws Exception{
        SimpleDateFormat sf1 = new SimpleDateFormat(format);
        String result = "";
        if(null == toFormat)
            result = stdDateFormat.format(sf1.parse(parseDate));
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
    public static Integer getMonthOfDay(){
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
    public static String modifiedSecond(String dateStr, Long second){
        try {
            Date date = stdDatetimeFormat.parse(dateStr);
            Calendar calendar = Calendar.getInstance();//获得当前时间
            calendar.setTime(date);
            calendar.add(Calendar.SECOND, Integer.parseInt(second.toString()));
            Date time = calendar.getTime();//返回Date类
            return stdDatetimeFormat.format(time);

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
    public static String modifiedMinute(String dateStr, Long minute){
        try {
            Date date = stdDatetimeFormat.parse(dateStr);
            Calendar calendar = Calendar.getInstance();//获得当前时间
            calendar.setTime(date);
            calendar.add(Calendar.MINUTE, Integer.parseInt(minute.toString()));
            Date time = calendar.getTime();//返回Date类
            return stdDatetimeFormat.format(time);

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
    public static String modifiedDay(String parseDate, Integer parseNumber) throws Exception{
        Date date = stdDateFormat.parse(parseDate);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_YEAR,parseNumber);
        Date time=c.getTime();
        String result = stdDateFormat.format(time);
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
    public static String modifiedMonth(String parseDate, Integer parseNumber) throws Exception{
        Date date = stdDateFormat.parse(parseDate);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH,parseNumber);
        Date time=c.getTime();
        String result = stdDateFormat.format(time);
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
    public static String modifiedYear(String parseDate, Integer parseNumber) throws Exception{
        Date date = stdDateFormat.parse(parseDate);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.YEAR,parseNumber);
        Date time=c.getTime();
        String result = stdDateFormat.format(time);
        return result;
    }


    /**
     * 比较日期大小
     * @param date1
     * @param date2
     * @return
     */
    public static String compareDate(String date1, String date2){
        try {
            Date dt1 = stdDateFormat.parse(date1);
            Date dt2 = stdDateFormat.parse(date2);
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
    public static String compareDate(String date1, String date2, String format){
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
    public static String numberToTime(Integer second){
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
    public static String numberToTime(Long second){
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
    public static Long getTimeDifference(String startDate, String endDate){
        try {
            Date start = stdDatetimeFormat.parse(startDate);
            Date end = stdDatetimeFormat.parse(endDate);
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
    public static Long getTimeDifference(Date startDate, Date endDate){
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
    public static int conversionTimeToYear(Date date1, Date date2){
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

    /**
     * 计算两个时间的间隔
     * @param StartData
     * @param endDate
     * @return
     */
    public static long getCalculateDate(Date StartData,Date endDate) {
        if (StartData != null && endDate != null) {
            long selectStartTime = StartData.getTime();
            long selectEndTime = endDate.getTime();
            long selectTime = (selectStartTime - selectEndTime) / 86400000;//(1000 * 60 * 60 * 24);

            return selectTime;
        } else {
            return 100000;
        }
    }

    /**
     * Date转为XMLGregorianCalendar
     * @param date
     * @return
     */
    public static XMLGregorianCalendar dateToXmlDate(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        DatatypeFactory dtf = null;
        try {
            dtf = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException e) {
        }
        XMLGregorianCalendar dateType = dtf.newXMLGregorianCalendar();
        dateType.setYear(cal.get(Calendar.YEAR));
        //由于Calendar.MONTH取值范围为0~11,需要加1
        dateType.setMonth(cal.get(Calendar.MONTH)+1);
        dateType.setDay(cal.get(Calendar.DAY_OF_MONTH));
        dateType.setHour(cal.get(Calendar.HOUR_OF_DAY));
        dateType.setMinute(cal.get(Calendar.MINUTE));
        dateType.setSecond(cal.get(Calendar.SECOND));
        return dateType;
    }

    /**
     * XMLGregorianCalendar转为Date
     * @param xmlDate
     * @return
     */
    public static Date xmlDateToDate(XMLGregorianCalendar xmlDate){
        return xmlDate.toGregorianCalendar().getTime();
    }

    public static void main(String[] args) {
        System.out.println(getNextYm("201407", 5));
        System.out.println(getNextYm("201407", 10));
        System.out.println(getNextYm("201407", -7));
        System.out.println(getPrevYm("201407"));
        System.out.println(getYear("2017-10-25"));
    }
}
