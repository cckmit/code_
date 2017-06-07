package com.mika.credit.common.util;


import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 基础工具类；
 */
@SuppressWarnings("UnusedDeclaration")
public class UtilPub {
    public static final String ROOT_PATH = UtilPub.class.getResource("/").getPath().toString();
    public static String WEB_PATH = "";
    private static SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat tFormat = new SimpleDateFormat("HH:mm:ss");
    private static SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat dLFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static SimpleDateFormat dLFormat2 = new SimpleDateFormat("yyyyMMdd");
    private static DecimalFormat df2Format = new DecimalFormat("###,###,###,###,##0.00");

    public static <K, V> Map<K, V> toMap(K k1, V v1) {
        Map<K, V> map = new HashMap<>();
        map.put(k1, v1);
        return map;
    }

    public static <K, V> Map<K, V> toMap(K k1, V v1, K k2, V v2) {
        Map<K, V> map = new HashMap<>();
        map.put(k1, v1);
        map.put(k2, v2);
        return map;
    }

    public static <K, V> Map<K, V> toMap(K k1, V v1, K k2, V v2, K k3, V v3) {
        Map<K, V> map = new HashMap<>();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        return map;
    }

    public static <K, V> Map<K, V> toMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        Map<K, V> map = new HashMap<>();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        return map;
    }

    public static <K, V> Map<K, V> toMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        Map<K, V> map = new HashMap<>();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        return map;
    }

    @SafeVarargs
    public static <T> T[] asArray(T... args) {
        return args;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.size() == 0;
    }

    public static boolean isEmpty(Object[] o) {
        return o == null || o.length == 0;
    }

    public static boolean isEmptyStr(String str) {
        return str == null || str.trim().length() == 0 || "-".equals(str);
    }

    //判断Id是否为空id,有可能是"-","-1"
    public static boolean isEmptyId(String id) {
        return id == null || id.trim().length() == 0 || "0".equals(id) || "-".equals(id) || "-1".equals(id) || "null".equals(id) || "(无)".equals(id);
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isNotEmptyId(String str) {
        return !isEmptyId(str);
    }

    public static boolean isNotEmptyStr(String str) {
        return !isEmptyStr(str);
    }

    public static boolean isNotEmpty(Collection collection) {
        return !isEmpty(collection);
    }

    public static boolean isNotEmpty(Object[] o) {
        return !isEmpty(o);
    }

    /**
     * 将空指针转换为空串
     *
     * @param str 带检查的字符串
     * @return 字符串
     */
    public static String ignoreNull(String str) {
        if (str == null)
            return "";
        return str;
    }

    /**
     * 将空指针转换为空串，并截去前后的空格
     *
     * @param str 带检查的字符串
     * @return 字符串
     */
    public static String trimIgnoreNull(String str) {
        if (str == null)
            return "";
        return str.trim();
    }

    /**
     * 获取浮点数(有错误默认为0)，可以识别金额中的逗号格式
     *
     * @param str 带转换的字符串
     * @return 浮点数
     */
    public static double getDoubleIgnoreErr(String str) {
        if (str == null)
            return 0;
        str = str.trim();
        if (str.equals(""))
            return 0;
        str = str.replaceAll(",", "").replaceAll("，", "");
        try {
            return Double.valueOf(str);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 得到int 获取转换的int值，有错返回0
     *
     * @param str 带转换的字符串
     * @return int
     */
    public static int getIntIgnoreErr(String str) {
        return getIntIgnoreErr(str, 0);
    }

    public static int getIntIgnoreErr(String str, int defValue) {
        if (str == null)
            return defValue;
        str = str.trim();
        if (str.equals(""))
            return defValue;
        str = str.replaceAll(",", "").replaceAll("，", "");
        if (str.contains("."))
            str = str.substring(0, str.indexOf('.'));
        try {
            return Integer.valueOf(str);
        } catch (Exception e) {
            return defValue;
        }
    }

    /**
     * 得到Long 获取转换的Long值，有错返回0
     *
     * @param str 带转换的字符串
     * @return long
     */
    public static long getLongIgnoreErr(String str) {
        return getLongIgnoreErr(str, 0L);
    }

    public static long getLongIgnoreErr(String str, long defValue) {
        if (str == null)
            return defValue;
        str = str.trim();
        if (str.equals(""))
            return defValue;
        str = str.replaceAll(",", "").replaceAll("，", "");
        try {
            return Long.valueOf(str);
        } catch (Exception e) {
            return defValue;
        }
    }

    public static Date getDateFromTimestampIgnoreNull(Timestamp datetime) {
        if (datetime == null)
            return null;
        return new Date(datetime.getTime());
    }

    public static Date getSqlDateFromUtilDate(java.util.Date utilDate) {
        return new Date(utilDate.getTime());
    }

    public static java.util.Date getUtilDateFromSqlDate(Date sqlDate) {
        return new java.util.Date(sqlDate.getTime());
    }

    public static Date getDateFromStrIgnoreErr(String dateStr) {
        try {
            return Date.valueOf(dateStr);
        } catch (Exception e) {
            return null;
        }
    }

    public static String getDateStrIgnoreNull(java.util.Date obj) {
        if (obj == null)
            return "";
        return dFormat.format(obj);
    }

    public static String getDateStrIgnoreNull(Date obj) {
        if (obj == null)
            return "";
        return dFormat.format(obj);
    }

    public static String getDateHtmlStrIgnoreNull(java.util.Date obj) {
        return UtilHtml.getHtmlStr(getDateStrIgnoreNull(obj));
    }

    public static String getDateHtmlStrIgnoreNull(Date obj) {
        return UtilHtml.getHtmlStr(getDateStrIgnoreNull(obj));
    }

    public static String getDateStrIgnoreNull(Timestamp obj) {
        if (obj == null)
            return "";
        return dFormat.format(obj);
    }

    public static String getDateHtmlStrIgnoreNull(Timestamp obj) {
        return UtilHtml.getHtmlStr(getDateStrIgnoreNull(obj));
    }

    public static String getTimeStrIgnoreNull(Timestamp obj) {
        if (obj == null)
            return "";
        return tFormat.format(obj);
    }

    public static String getTimeHtmlStrIgnoreNull(Timestamp obj) {
        return UtilHtml.getHtmlStr(getTimeStrIgnoreNull(obj));
    }

    public static Timestamp getDateTimeFromStrIgnoreErr(String dateTimeStr) {
        try {
            return Timestamp.valueOf(dateTimeStr);
        } catch (Exception e) {
            return null;
        }
    }

    public static String getDateTimeStrIgnoreNull(Timestamp obj) {
        if (obj == null)
            return "";
        return dtFormat.format(obj);
    }

    public static String getDateTimeBRHtmlStrIgnoreNull(Timestamp obj) {
        if (obj == null)
            return "&nbsp;";
        return getDateStrIgnoreNull(obj) + "<br>" + getTimeStrIgnoreNull(obj);
    }

    public static String getDateTimeHtmlStrIgnoreNull(Timestamp obj) {
        return UtilHtml.getHtmlStr(getDateTimeStrIgnoreNull(obj));
    }

    public static Date getCurDate() {
        return new Date(System.currentTimeMillis());
    }

    public static String getCurDateStr() {
        return dFormat.format(new Date(System.currentTimeMillis()));
    }

    public static Timestamp getCurDatetime() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static String getCurDatetimeStr() {
        return dtFormat.format(new Timestamp(System.currentTimeMillis()));
    }

    /**
     * Func:为空，返回""
     *
     * @param str 带检查的字符串
     * @return ""
     */
    public static String checkNull(String str) {
        if (isEmpty(str))
            return "";
        return str.trim();
    }

    public static String checkNull(Integer n) {
        return checkNull(n, true);
    }

    public static String checkNull(Integer n, boolean zeroToEmpty) {
        int v;
        if (n == null || n == 0)
            v = 0;
        else
            v = n;
        return v != 0 ? String.valueOf(v): zeroToEmpty ? "": "0";
    }

    public static String checkNull(Long n) {
        return checkNull(n, 0L);
    }

    public static String checkNull(Long n, long defValue) {
        return n != null ? String.valueOf(n) : String.valueOf(defValue);
    }

    public static String checkNull(Double n) {
        return checkNull(n, 0d);
    }

    public static String checkNull(Double n, double defValue) {
        double d = n != null ? n : defValue;
        return String.valueOf(d);
    }

    /**
     * 账期转改成年月显示，如201201：2012-01
     *
     * @param period_id
     * @return
     */
    public static String periodIdToYm(String period_id) {
        if (isEmpty(period_id) || period_id.trim().length() != 6)
            return "";
        return period_id.trim().substring(0, 4).concat("-").concat(period_id.trim().substring(4));
    }

    /**
     * Func:取当前年
     *
     * @return ""
     */
    public static String getThisYear() {
        Calendar tlpDate = new GregorianCalendar();
        tlpDate.setTime(getCurDate());
        return String.valueOf(tlpDate.get(Calendar.YEAR));
    }

    /**
     * Func:取当前月
     *
     * @return ""
     */
    public static String getThisMonth() {
        Calendar tlpDate = new GregorianCalendar();
        tlpDate.setTime(getCurDate());
        return String.valueOf(tlpDate.get(Calendar.MONTH));
    }

    /**
     * Func:str字符串是否包含subStr
     *
     * @param str    字符串
     * @param subStr 待查找的串
     * @return boolean
     */
    public static boolean isContain(String str, String subStr) {
        return !isEmpty(str) && !isEmpty(subStr) && str.contains(subStr);
    }

    /**
     * 功能：null过滤，返回默认值
     *
     * @param strValue     带检查的字符串
     * @param defaultValue 为空返回的字符串
     * @return str
     */
    public static String checkNull(String strValue, String defaultValue) {
        return strValue == null ? defaultValue: strValue;
    }

    /**
     * 功能：空值过滤，返回默认值
     *
     * @param strValue     待检查的字符串
     * @param defaultValue 为空返回的字符串
     * @return str
     */
    public static String checkEmpty(String strValue, String defaultValue) {
        return isEmpty(strValue) ? defaultValue: strValue;
    }

	public static String checkEmptyId(String strValue, String defaultValue) {
        return isEmptyId(strValue) ? defaultValue: strValue;
    }

    /**
     * Func:List是否包含str
     *
     * @param str 字符串
     * @param lt  列表
     * @return boolean
     */
    public static boolean isInList(String str, List lt) {
        if (lt == null)
            return false;
        if (isEmpty(str))
            return false;
        for (Object aLt : lt) {
            if (str.equals(aLt)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 比较两个数组长度是否相等.
     */
    public static boolean arrayLengthIsSame(Object[] a, Object[] b) {
        int size_a = (a == null ? 0: a.length);
        int size_b = (b == null ? 0: b.length);
        return size_a == size_b;
    }

    /**
     * 去掉字符串最后一个字符,一般用于去逗号","处理 add by Cr
     *
     * @param str 字符串
     * @return 去掉最后一个支付的字符串
     */
    public static String subLastChar(String str) {
        if (isEmpty(str))
            return "";
        return str.substring(0, str.length() - 1);
    }

    public static String getOrigMsg(Throwable e) {
        String s = e.getMessage();
        Throwable t = e.getCause();
        while (t != null) {
            s = t.getMessage();
            t = t.getCause();
        }
        return s;
    }

    //从map中取值，key不区分大小写
    public static <V> V getValueFromMapIgnoreCase(Map<String, V> map, String key) {
        for (String k : map.keySet()) {
            if (k.equalsIgnoreCase(key)) {
                return map.get(k);
            }
        }
        return null;
    }

    /**
     * 字符串转Map
     *
     * @param str      源串，格式 name1=value1&name2=value2
     * @param map      目标map
     * @param upperKey 是否需要将key转为大写
     */
    public static void strToMap(String str, Map<String, String> map, boolean upperKey) {
        String[] ss = str.split("&");
        String[] sp;
        String key;
        for (String s : ss) {
            if (UtilPub.isEmpty(s))
                continue;
            sp = s.split("=");
            if (upperKey)
                key = sp[0].toUpperCase();
            else
                key = sp[0];
            if (sp.length > 1) {
                map.put(key, sp[1]);
            } else
                map.put(key, "");
        }
    }

    //计算一个字符串source的长度(英文和数字占一个长度,其他字符(中文和特殊符号等)占2个长度)
    public static int strLength(String source) {
        int totalLength = source.length();// 总长度
        String otherStr = source.replaceAll("\\d|\\w", "");// 去掉字符串中的数字和英文字符
        int otherLength = otherStr.length();// 占2个长度的字符
        return (totalLength - otherLength) + otherLength * 2;
    }

    /**
     * 格式化最后修改时间
     *
     * @param strTime YYYYMMDDhhmmss
     * @return YYYY-MM-DD hh:mm:ss
     */
    public static String checkLastTime(String strTime) {
        if (isEmpty(strTime))
            return "";
        return checkLastTime(UtilMath.tolong(strTime, 0));
    }

    public static String checkLastTime(long lngTime) {
        if (0 >= lngTime)
            return "";
        String s1 = String.valueOf(lngTime + "").trim();
        if (s1.length() != 14)
            return "";
        return s1.substring(0, 4).concat("-").concat(s1.substring(4, 6)).concat("-").concat(s1.substring(6, 8)).concat(" ").concat(s1.substring(8, 10)).concat(":").concat(s1.substring(10, 12)).concat(":").concat(s1.substring(12));
    }

    /**
     * 取最后修改时间
     *
     * @return Long
     */
    public static Long getLastTime() {
        return UtilDateTime.nowDateTimeNumber();
    }

    /**
     * 取最后修改日期
     *
     * @return
     */
    public static Long getLastDate() {
        return Long.valueOf(dLFormat2.format(new Timestamp(System.currentTimeMillis())));
    }

    public static String getAmountStr(double amount) {
        return df2Format.format(amount);
    }

    public static String getAmountStr(double amount, boolean zeroShowEmpty) {
        if (zeroShowEmpty && UtilMath.isEqualsZero(amount))
            return "";
        else
            return df2Format.format(amount);
    }

    public static String getIntStr(int d) {
        if (d == 0)
            return "";
        else
            return String.valueOf(d);
    }

    /**
     * 截取右边的0串
     *
     * @param codeStr
     * @return
     */
    public static String cutZero(String codeStr) {
        int j = 0;
        int len = codeStr.length() - 1;
        for (int i = len; i > -1; i--) {
            if ('0' == codeStr.charAt(i)) {
                j++;
            } else {
                break;
            }
        }
        return codeStr.substring(0, len - j + 1);
    }

    /**
     * 右边补0串
     *
     * @param codeLen
     * @param cutedCode
     * @return
     */
    public static String fillZero(int codeLen, String cutedCode) {
        StringBuilder codeStr = new StringBuilder(20).append(cutedCode);
        for (int len = cutedCode.length(), i = 0; i < codeLen - len; i++) {
            codeStr.append("0");
        }
        return codeStr.toString();
    }

	/**
	 * 转换为boolean
	 */
	public static boolean toBoolean(String v, boolean b) {
		if (v == null) return b;
		return "1".equals(v) || "true".equalsIgnoreCase(v) || "Y".equalsIgnoreCase(v) || "yes".equalsIgnoreCase(v);
	}

	public static class FileName {
        public String path = "";
        public String name = "";
        public String mainName = "";
        public String exName = "";

        public FileName(String fileFullName) {
            File file = new File(fileFullName);
            path = file.getParent();
            name = file.getName();
            int i = name.lastIndexOf(".");
            if (i < 0) {
                mainName = name;
                exName = "";
            } else {
                mainName = name.substring(0, i);
                exName = name.substring(i + 1, name.length());
            }
        }
    }

    public static String getDateStr(Object _dateTime) { //yyyymmddhhMMss
        String dateTime = String.valueOf(_dateTime);
        if (UtilPub.isEmpty(dateTime) || dateTime.length() < 7) {
            return "";
        } else {
            String s1 = String.valueOf(dateTime);
            return s1.substring(0, 4) + "-" + s1.substring(4, 6) + "-" + s1.substring(6, 8);
        }
    }

    public static String getDateTimeStr(Object _dateTime) { //yyyymmddhhMMss
        String dateTime = String.valueOf(_dateTime);
        if (UtilPub.isEmpty(dateTime) || dateTime.length() < 14) {
            return "";
        } else {
            String s1 = String.valueOf(dateTime);
            return s1.substring(0, 4) + "-" + s1.substring(4, 6) + "-" + s1.substring(6, 8);// + " " + s1.substr(8, 10) + ":" + s1.substr(10, 12) + ":" + s1.substr(12);
        }
    }

    public static String getYearMonthStr(Object _dateTime) { //返回yyyy-MM  by tdc
        String dateTime = String.valueOf(_dateTime);
        if (UtilPub.isEmpty(dateTime) || dateTime.length() < 7) {
            return "";
        } else {
            String s1 = String.valueOf(dateTime);
            return s1.substring(0, 4) + s1.substring(4, 6);
        }
    }

    //获取以逗号分隔的字符串的第一部分
    public static String getStrArrayFirst(String sa) {
        String[] ss = sa.split(",");
        if (ss.length > 0)
            return ss[0];
        return "";
    }

    //删除除 {"0","1","2","3","4","5","6","7","8","9",".","/","-"}以外的字符
    public static String remove(String str){
        if(isEmpty(str)) return "";
        char[] charArray=str.toCharArray();
        char[] strArray ={'0','1','2','3','4','5','6','7','8','9','.','/','-'};
        for(char c:charArray){
            if(!ArrayUtils.contains(strArray, c)){
                str = StringUtils.remove(str, c);
            }
        }
        return str;
    }
}
