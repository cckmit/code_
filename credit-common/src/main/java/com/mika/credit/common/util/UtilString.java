package com.mika.credit.common.util;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.Collator;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("UnusedDeclaration")
public class UtilString {
    private static Collator chineseCollator = Collator.getInstance(Locale.CHINA);

    /**
     * strSrc中寻找第一个strSe并且返回以其分隔的Left部分，汉字长度也为1
     *
     * @param strSrc 源字符串
     * @param strSe  分割字符
     * @return String 返回
     */
    public static String getLeft(String strSrc, String strSe) {
        if (UtilPub.isEmpty(strSrc))
            return "";
        if (UtilPub.isEmpty(strSe))
            strSe = " ";

        String result = "";
        int pos = strSrc.indexOf(strSe);
        if (pos >= 0)
            result = strSrc.substring(0, pos);
        return result;
    }

    /**
     * 返回字符串的左边部分，汉字长度也为1
     *
     * @param strSrc 源串,如果为空，则返回“”；
     * @param count  要获取的右边字符串长度,负数将返回“”，如果count>字符串长度，则返回整个字符串；
     * @return String return
     */
    public static String getLeft(String strSrc, int count) {
        if (UtilPub.isEmpty(strSrc) || count <= 0) {
            return "";
        }
        if (strSrc.length() < count) {
            return strSrc;
        } else {
            return strSrc.substring(0, count);
        }
    }

    /**
     * strSrc中寻找第一个strSe并且返回以其分隔的Right部分,汉字长度也为1
     *
     * @param strSrc 源串
     * @param strSe  分隔符,一个字符
     * @return String right部分
     */
    public static String getRight(String strSrc, String strSe) {
        if (UtilPub.isEmpty(strSrc))
            return "";
        if (UtilPub.isEmpty(strSe))
            strSe = " ";

        String result = strSrc;
        int pos = strSrc.indexOf(strSe);
        if (pos >= 0)
            result = strSrc.substring(pos + 1);
        return result;
    }

    /**
     * 返回字符串的右边部分，汉字长度也为1
     *
     * @param strSrc 源串
     * @param count  要获取的右边字符串长度,负数将返回“”，如果count>字符串长度，则返回整个字符串；
     * @return String return
     */
    public static String getRight(String strSrc, int count) {
        if (UtilPub.isEmpty(strSrc) || count <= 0) {
            return "";
        }
        int l = strSrc.length();
        if (l <= count) {
            return strSrc;
        }
        return strSrc.substring(l - count);
    }

    /**
     * 左边补齐字符
     *
     * @param src    源串
     * @param pad    补齐字符
     * @param length 最终长度
     * @return 补齐后的字符串
     */
    public static String padLeft(String src, String pad, int length) {
        StringBuilder sb = new StringBuilder(repeatString(pad, length));
        sb.append(src);
        return sb.substring(sb.length() - length);
    }

    public static String padLeft(long src, String pad, int length) {
        StringBuilder sb = new StringBuilder(repeatString(pad, length));
        sb.append(src);
        return sb.substring(sb.length() - length);
    }

    public static String padRight(String src, String pad, int length) {
        StringBuilder sb = new StringBuilder(length * pad.length() + src.length());
        sb.append(src).append(repeatString(pad, length));
        return sb.substring(0, length);
    }

    public static String padRight(long src, String pad, int length) {
        StringBuilder sb = new StringBuilder(length * pad.length());
        sb.append(src).append(repeatString(pad, length));
        return sb.substring(0, length);
    }

    /**
     * 由于jdk1.3提供的replace函数不能满足替换要求，自己写一个
     *
     * @param src  源串
     * @param oldS 将...
     * @param newS 替换成...
     * @return 替换后的字符串
     */
    public static String replaceString(String src, String oldS, String newS) {
        StringBuilder ret = new StringBuilder(64);
        int pos = src.indexOf(oldS);
        while (pos >= 0) {
            ret.append(src.substring(0, pos)).append(newS);
            src = src.substring(pos + oldS.length());
            pos = src.indexOf(oldS);
        }
        ret.append(src);
        return ret.toString();
    }

    /**
     * 取得指定字符串左边的有效数字,首先去掉两边空格
     *
     * @param s 源串
     * @return 串左边的有效数字
     */
    public static String getStringLeftNumber(String s) {
        String ret = "";
        int dotCount = 0;
        s = s.trim();
        char[] carr = s.toCharArray();
        for (char aCarr : carr) {
            if (Character.isDigit(aCarr)) {
                ret += aCarr;
            } else if (aCarr == '.' && dotCount == 0) {
                ret += aCarr;
                dotCount++;
            } else {
                break;
            }
        }
        if (ret.endsWith(".")) {
            ret = ret.substring(0, ret.length() - 1);
        }
        return ret;
    }

    /**
     * 取得重复字串
     *
     * @param repeatString 重复字串
     * @param count        重复次数
     * @return String
     */
    public static String repeatString(String repeatString, int count) {
        if (count <= 0) return "";
        StringBuilder ret = new StringBuilder(repeatString.length() * count);
        for (int i = 1; i <= count; i++) {
            ret.append(repeatString);
        }
        return ret.toString();
    }

    /**
     * 去除字符串左边的指定字符串
     *
     * @param src 源字符串
     * @param cut 要去掉的字符串；
     * @return 处理结果
     */
    public static String cutStringLeft(String src, String cut) {
        if (UtilPub.isEmpty(src) || UtilPub.isEmpty(cut)) {
            return "";
        }
        if (src.startsWith(cut)) {
            return cutStringLeft(src.substring(cut.length()), cut);
        } else {
            return src;
        }
    }

    public static String cutStringRight(String src, String cut) {
        if (UtilPub.isEmpty(src) || UtilPub.isEmpty(cut)) {
            return "";
        }
        while (src.endsWith(cut))
            src = src.substring(0, src.length() - cut.length());

        return src;
    }

    /**
     * Removes all spaces from a string
     * 可以替换大部分空白字符， 不限于空格,\s 可以匹配空格、制表符、换页符等空白字符的其中任意一个
     */
    public static String removeSpaces(String str) {
        return str.replaceAll("\\s*", "");
    }

    /**
     * Creates a single string from a List of strings seperated by a delimiter.
     *
     * @param list  a list of strings to join
     * @param delim the delimiter character(s) to use. (null value will join with no delimiter)
     * @return a String of all values in the list seperated by the delimiter
     */
    public static String join(List<String> list, String delim) {
        if (list == null || list.size() < 1)
            return null;
        StringBuffer buf = new StringBuffer();
        Iterator i = list.iterator();

        while (i.hasNext()) {
            buf.append((String) i.next());
            if (i.hasNext())
                buf.append(delim);
        }
        return buf.toString();
    }

    /**
     * Splits a String on a delimiter into a List of Strings.
     *
     * @param str   the String to split
     * @param delim the delimiter character(s) to join on (null will split on whitespace)
     * @return a list of Strings
     */
    public static List<String> split(String str, String delim) {
        List<String> splitList = null;
        StringTokenizer st;
        if (str == null)
            return splitList;

        if (delim != null)
            st = new StringTokenizer(str, delim);
        else
            st = new StringTokenizer(str);

        if (st.hasMoreTokens()) {
            splitList = new ArrayList<String>();
            while (st.hasMoreTokens())
                splitList.add(st.nextToken());
        }
        return splitList;
    }

    //是否为true,(1,y,true,yes)
    public static boolean toBoolean(String v) {
        return "1".equals(v) || "y".equalsIgnoreCase(v) || "true".equalsIgnoreCase(v) || "yes".equalsIgnoreCase(v);
    }

    public static int chineseCompare(String s1, String s2) {
        return chineseCollator.compare(s1, s2);
    }

    /**
     * 按照编码级次，得到类型的真实编码，主要用于like 'parentCode%'
     * getSplitTypeCode('GF82000',2, 2, 1) == GF82
     * getSplitTypeCode('GF82100',3, 2, 1) == GF821
     * getSplitTypeCode('82100'  ,3, 0, 1) == 821
     *
     * @param curLevel   当前编码的所在层次
     * @param startIndex 数字编码的开始选项
     * @param perSize    每层的数字编码长度
     */
    public static String getRealCode(String code, int curLevel, int startIndex, int perSize) {
        StringBuilder sb = new StringBuilder(code.length());
        if (startIndex > 0) sb.append(code.substring(0, startIndex));
        for (int i = startIndex, l = 0; i < code.length(); i += perSize) {
            if (l < curLevel) {
                sb.append(code.substring(i, i + perSize));
                ++l;
            } else {
                break;
            }
        }
        return sb.toString();
    }

    //函数功能: 正整数
    public static boolean isPureNumber(String inputString) {
        return inputString.matches("^[1-9]\\d*$");
    }

    //函数功能: 正整数
    public static boolean isNumber(String inputString) {
        return inputString.matches("^[0-9]\\d*$");
    }

    //首字母大写
    public static String upFirst(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    public static String padRightBytes(String src, String pad, int length) {
        length -= src.replaceAll("[^\\x00-\\xff]", "**").length();
        return src + repeatString(pad, length);
    }

    //按字节数取子串，begin不是按字节的
    public static String substrByte(String src, int begin, int len) {
        StringBuilder sb = new StringBuilder(32);
        char c;
        int tl = src.length();
        for (int i = begin; i < len + begin && i < tl; i++) {

            c = src.charAt(i);
            sb.append(c);
            if (String.valueOf(c).replaceAll("[^\\x00-\\xff]", "**").length() > 1) {
                // 遇到中文汉字，截取字节总数减1
                --len;
            }
        }
        return sb.toString();
    }

    public static float[] getFloatArr(String source, String split){
        if(source == null || source.length() == 0){
            return null;
        }
        String[] floatArr = source.split(split);
        float[] result = new float[floatArr.length];
        for(int i = 0; i < floatArr.length; i++){
            try {
                result[i] = Float.parseFloat(floatArr[i]);
            } catch (NumberFormatException e) {
                result[i] = 0;
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 将字符串转成int
     * @param str - 转换的字符串
     * @param def - 默认或出现情况下的�??
     * @return
     */
    public static int convertStrWithZero(String str,int def){
        try{
            if(str==null || str.equals("undefined")) return def;
            return Integer.parseInt(str.trim());
        }catch(Exception e){
            return def;
        }
    }

    /**
     * 将字符串转成int
     * @param str - 转换的字符串
     * @param def - 默认或出现情况下的�??
     * @return
     */
    public static int convertStr(String str,int def){
        try{
            if(str==null || str.equals("0") || str.equals("undefined")) return def;
            return Integer.parseInt(str.trim());
        }catch(Exception e){
            return def;
        }
    }

    /**
     * 将字符串转成long�?
     * @param str - 转换的字符串
     * @param def - 默认或出现情况下的�??
     * @return
     */
    public static long convertStrToLong(String str,long def){
        try{
            if(str==null || str.equals("0") || str.equals("undefined")) return def;
            return Long.parseLong(str.trim());
        }catch(Exception e){
            return def;
        }
    }

    /**
     * 将字符串转成float�?
     * @param str - 转换的字符串
     * @param def - 默认或出现情况下的�??
     * @return
     */
    public static float convertStrToFloat(String str,float def){
        try{
            if(str==null || str.equals("0") || str.equals("undefined")) return def;
            return Float.parseFloat(str.trim());
        }catch(Exception e){
            return def;
        }
    }

    /**
     * 将以逗号分隔的字符穿两边加上 '';  比如 aaa,bbbb  返回 'aaa','bbb'
     * @param str - 转换的字符串
     * @return
     */
    public static String convertStr4Sql(String str){
        try{
            if(str==null || str.equals("0")) return str;
            String idsTem="";
            if(str.contains(",")){
                for(String idStr:str.split(",")){
                    idsTem+="'"+idStr+"',";
                }
                if(idsTem.length()>0)idsTem=idsTem.substring(0, idsTem.length()-1);
            }else{
                idsTem="'"+str+"'";
            }
            return idsTem;
        }catch(Exception e){
            return str;
        }
    }


    public static String formatNum(Object obj) {
        DecimalFormat df = new DecimalFormat("###,###,###.##");
        return df.format(Double.valueOf(UtilString.rep(obj, "0")));
    }


    public static String rep(Object s, String mark) {
        if (s == null || s.equals("") || s.equals("undefined"))
            return mark;
        if (s instanceof String) {
            String new_name = (String) s;
            if (new_name.equals(""))
                return mark;

            return new_name.trim();
        }
        return s + "";
    }

    public static String rep(Object s) {
        if (s == null  || s.equals("") || s.equals("undefined"))
            return "";
        if (s instanceof String) {
            String new_name = (String) s;
            //长字符串替换 暂时不使�?
            //new_name = StringUtil.longStringFomrat(new_name);
            return new_name.trim();
        }
        return s + "";
    }

    /**
     * 获取支付传�??:aaa=bbb|ccc=ddd
     *
     * @param name
     *            要获取的字段名称�?
     * @return
     */
    public static String getPara(String src, String name) {
        src = "|" + src + "|";
        int begin = src.indexOf("|" + name + "=");
        if (begin > -1) {
            int end = src.indexOf("|", begin + 2);
            return src.substring(begin + 2 + name.length(), end);
        }
        return "";
    }

    /**将原有list中含有oldKey的map 替换其key为newKey
     * param dataList 旧list oldKey�?要转换的key newKey 转后后的key
     *
     * */
    @SuppressWarnings("unchecked")
    public static List changeList(List<Map> dataList,String oldKey,String newKey){
        if(oldKey==null || newKey==null || oldKey.equals(newKey)) return dataList;		//不需要转�?(名称为空，或相等)
        if(dataList==null || dataList.size()<=0) return dataList;
        ArrayList newList=new ArrayList();
        for(Map object:dataList){
            Map newMap=new HashMap();
            Iterator it = object.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                Object value = entry.getValue();
                if(oldKey.equalsIgnoreCase(String.valueOf(key))){
                    newMap.put(newKey, value);
                    newMap.put(oldKey, value);
                }else{
                    newMap.put(key, value);
                }
            }
            newList.add(newMap);
        }
        return newList;
    }

    /**
     * Pie图存在数据类型的判断
     * @param dataList - �?要转发的list
     * @param oldKey - �?要查找的key
     * @param newKey - 替换后的新key
     * @param sign - 1:int,2:String,3:object
     * @return
     */
    public static List changeList(List<Map> dataList,String oldKey,String newKey,int sign){
        if(oldKey==null || newKey==null || oldKey.equals(newKey)) return dataList;		//不需要转�?(名称为空，或相等)
        ArrayList newList=new ArrayList();
        for(Map object:dataList){
            Map newMap=new HashMap();
            Iterator it = object.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                Object value = entry.getValue();
                if(oldKey.equalsIgnoreCase(String.valueOf(key))){
                    if(sign==1){
                        newMap.put(newKey, UtilString.convertStr(value+"",0));
                        newMap.put(oldKey, UtilString.convertStr(value+"",0));
                    }
                    if(sign==2){
                        newMap.put(newKey, value+"");
                        newMap.put(oldKey, value+"");
                    }
                    if(sign==3){
                        newMap.put(newKey, value);
                        newMap.put(oldKey, value);
                    }
                }else{
                    newMap.put(key, value);
                }
            }
            newList.add(newMap);
        }
        return newList;
    }






    /**
     * 将数据补入list�?
     * @param list 旧list
     * @param id map的key
     * @param value map的Value

     * @return
     */
    @SuppressWarnings("unchecked")
    public static List put(List list,String id,String value)
    {
        for(Iterator it =list.iterator();it.hasNext();)
        {
            Map map = (Map)it.next();
            map.put(id,value);
        }
        return list;
    }

    /**
     * 获得小列表不在大列表中的结果集合
     * @param smallList - 小列表，使用,分隔
     * @param bigList - 大列表，使用,分隔
     * @return string
     */
    public static String findOtherList(String smallList,String bigList){
        if(bigList==null || bigList.equals("")) return null;
        if(smallList==null || smallList.equals("")) return null;
        if(bigList.equals(smallList)) return null;
        smallList = ","+smallList+",";
        String[] bigs = bigList.split(",");
        String otherStr = "";
        for(String str:bigs){
            String tmp=","+str+",";
            if(!smallList.contains(tmp)) otherStr +=str+",";
        }
        if(otherStr.length()>1) otherStr = otherStr.substring(0,otherStr.length()-1);
        return otherStr;
    }

    /**
     * 对list<map>这种数据结构  进行排序
     * @param list 旧list
     * @param key map的key  按照此key对应的value进行排序
     * @return 排序后的List
     */
    @SuppressWarnings("unchecked")
    public static List sortListAsc(List list,final String key)
    {
        Comparator<Map<String, Integer>> comparator = new Comparator<Map<String, Integer>>() {
            public int compare(Map<String, Integer> o1, Map<String, Integer> o2) {
                return UtilString.convertStr((o1.get(key)+""),0) - UtilString.convertStr((o2.get(key)+""),0);
            }
        };
        Collections.sort(list,comparator);
        return list;
    }
    /**
     * 对list<map>这种数据结构  进行排序
     * @param list 旧list
     * @param key map的key  按照此key对应的value进行排序
     * @return 排序后的List
     */
    @SuppressWarnings("unchecked")
    public static List sortListDesc(List list,final String key)
    {
        Map otherMap = new HashMap();
        for(int i=0;i<list.size();i++){
            Map map = (Map)list.get(i);
            if(map.containsKey("TYPE_ID"))
                if(map.get("TYPE_ID").equals("其他")){
                    otherMap = map;
                    break;
                }
        }
        list.remove(otherMap);					//剔除其他数据
        Comparator<Map> comparator = new Comparator<Map>() {
            public int compare(Map o1, Map o2) {
                return Integer.parseInt(o2.get(key)+"") - Integer.parseInt((o1.get(key))+"");
            }
        };
        Collections.sort(list,comparator);
        if(otherMap.size()>0) list.add(otherMap);	//追加其他数据到最下面
        return list;
    }



    public static String subString(Object src1, int byteline) {

        if (src1 == null || "".equals(src1))
            return "";
        String s = src1.toString();
        StringBuffer sb = new StringBuffer(s);
        int leng = 0;
        for(int i=0;i<s.length();i++)
        {
            String c = sb.substring(i,i+1);
            if(c.getBytes().length>1)
            {
                leng =leng+2;
            }else
            {
                leng =leng+1;
            }

            if(leng>=byteline)
            {
                return sb.substring(0,i+1)+"...";
            }
        }
        return s;
    }
    /**对list进行深复�?*/
    @SuppressWarnings("unchecked")
    public static List<Map> deepClone(List<Map> result)
            throws IOException, ClassNotFoundException {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(outStream);
        out.writeObject(result);

        ByteArrayInputStream inStream = new ByteArrayInputStream(outStream
                .toByteArray());
        ObjectInputStream in = new ObjectInputStream(inStream);
        List<Map> retList = (List<Map>) in.readObject();

        return retList;
    }
    /**
     * 替换特殊�?
     * @param str - �?要替换的文字
     * @param re - 替换规则
     * @return str - 替换后的文字
     */
    public static String transSpe(String str,String[] re){
        if(re==null || re.length<=0) re = new String[]{"&,~!@","+,~@$"};			//默认�?:&替换成~!@,+替换成~@$
        for(int i=0;i<re.length;i++){
            String a = re[i].split(",")[0];
            String b = re[i].split(",")[1];
            str = str.replace(b, a);
        }
        return str;
    }


//	public long getTimestamp() throws ParseException{
//	   Date date1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
//	        .parse("2009/12/11 00:00:00");
//	        Date date2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
//	        .parse("1970/01/01 08:00:00");
//	        long l = date1.getTime() - date2.getTime() > 0 ? date1.getTime()
//	        - date2.getTime() : date2.getTime() - date1.getTime();
//	        long rand = (int)(Math.random()*1000);
//
//	        return rand;
//	}

    @SuppressWarnings("deprecation")
    public static Date getDate(long unixDate) {
        try{
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sd.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            String strDate = sd.format(new Date(unixDate*1000L));
            return sd.parse(strDate);
        }catch(Exception e){
            return null;
        }

    }
    /**
     *
     * @param temp		�?要过滤的正则表达�?
     * @param searchKey	�?要过滤的�?
     * @return
     */
    public static boolean getSearchKey(String temp,String searchKey){
        Pattern pattern = Pattern.compile("^.*["+temp+"].*");
        Matcher matcher = pattern.matcher(searchKey);
        return matcher.matches() ;
    }

    /**
     * 获得客户端ip
     *
     * */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");//当使用反向代理的时�??  通过此获取ip
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");   //当使用反向代理的时�??  通过此获取ip
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();      //正常情况下获取Ip
        }
        return ip;
    }
    /**
     * 获得合法xml数据
     * @param str
     * @return str
     */
    public static String getValidXml(String str){
        if(str==null || str.equals("") || str.equalsIgnoreCase("null")) return "";
        return "<![CDATA["+ str +"]]>";
    }

    /**
     * 特殊字符处理
     * 去除特殊字符
     * @param str
     * @return
     */
    public static String StringFilter(String str){
        String regEx="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#�?%…�??&*（）—�??+|{}【�?��?�；：�?��?��?��?�，、？]";
        Pattern   p   =   Pattern.compile(regEx);
        Matcher   m   =   p.matcher(str);
        return   m.replaceAll("").trim();
    }
    /**
     * 字符高亮
     * @param keys
     * @param text
     * @return
     */
    public static String getReplayKeys(String keys,String text){
        if(keys==null || keys.equals("") || text==null || text.equals("")) return text;
        String[] key = keys.split(" ");								//按空格拆�?
        for(int i=0;i<key.length;i++){
            String myKey = key[i];
            if(myKey==null || myKey.equals("")) continue;
            myKey = StringFilter(myKey) ;						//特殊字符处理
            text = text.replaceAll(myKey, "<span class='color_3'>"+ myKey +"</span>");
        }
        key = keys.split("~");										//按~拆分
        for(int i=0;i<key.length;i++){
            String myKey = key[i];
            if(myKey==null || myKey.equals("")) continue;
            myKey = StringFilter(myKey) ;						//特殊字符处理
            text = text.replaceAll(myKey, "<span class='color_3'>"+ myKey +"</span>");
        }
        return text;
    }

    @SuppressWarnings("deprecation")
    public static void main(String[] args){

//		System.out.println(timeChange("2012-11-12 18:57:56","",""));
//		String secretKey = StringUtil.getSign("mediaUserId=1770318172&tweetId=3500000161897095&mediaType=1", "iwomcic");
//		System.out.println(secretKey);
//		secretKey = StringUtil.getSign("", "iwomcic");
//		System.out.println(secretKey);
//		secretKey = StringUtil.getSign("mediaUserId=1770318172&tweetId=3500000161897095&mediaType=1", "");
//		System.out.println(secretKey);
//		secretKey = StringUtil.getSign("", "");
//		System.out.println(secretKey);
//		secretKey = StringUtil.getSign(null, "1");
//		System.out.println(secretKey);
//		secretKey = StringUtil.getSign("1", null);
//		System.out.println(secretKey);
//		secretKey = StringUtil.getSign(null, null);
//		System.out.println(secretKey);
//		String para="para=|userIds=1652752642,1770318172|indexType=NUM_OF_TWEETS|freq=week|dateId=2010-11-30";
//		System.out.print
//		System.out.println(getPara(para,"userIds"));
//		Date myDate = StringUtil.getDate(1297673149);
//		System.out.println(StringUtil.getSearchKey("中国|�?", "")) ;
//		SimpleDateFormat fm2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		System.out.println(myDate.toLocaleString());
//		System.out.println(myDate.toLocaleString());
//		System.out.println(fm2.format(myDate));
//		 SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//         sd.setTimeZone(TimeZone.getTimeZone("GMT+8"));
//         String strDate = sd.format(new Date(1297673149*1000L));
//         System.out.println("正八区当前时�?:"+strDate);

//		System.out.println(""+new java.text.SimpleDateFormat("yyyy MM-dd HH:mm:ss").format(new java.util.Date (1297673149*1000L)));
//		 String timezone_info = System.getProperty("user.timezone");
//	        System.out.println("当前的时�?:"+timezone_info);
//	        System.out.println("时区信息:"+TimeZone.getDefault());
//		String smallStr = "3,5,7";
//		String bigStr = "1,2,3,4,5,6,7";
//		String otherStr = StringUtil.findOtherList(smallStr, bigStr);
//		System.out.print(otherStr);

//		Date   date=null;
//		String   str= "2003-07-15 " ;
//		DateFormat   df=DateFormat.getDateInstance();
//		try {
//			date=df.parse(str);
////			System.out.println("dad000="+date) ;
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}

//		String keys = "(Adidas Osafasdf~阿迪达斯)三叶�?";
        String keys = "宝马~奔驰~土豪 汽车";
        String text = "~";
        String text1 = UtilString.keyWordsTrans(keys);
        System.out.println(text1);
    }
    public   static  String percent(double p1,double  p2)  {
        String str = "" ;
        double  p3  =  p1  /  p2;
        NumberFormat nf  =  NumberFormat.getPercentInstance();
        nf.setMinimumFractionDigits(2);
        str  =  nf.format(p3);
        return  str;
    }


    /**
     * 获得�?大或�?�?
     */
    public int getRightNum(int sNum,int rtNum,int ctNum,int sign){
        if(sign==0){		//比小
            if(sNum<rtNum){
                if(sNum<ctNum) return sNum;
                else return ctNum;
            }else{
                if(rtNum<ctNum) return rtNum;
                else return ctNum;
            }
        }
        if(sign==1){		//比大
            if(sNum>rtNum){
                if(sNum>ctNum) return sNum;
                else return ctNum;
            }else{
                if(rtNum>ctNum) return rtNum;
                else return ctNum;
            }
        }
        return sNum;
    }

    /**
     * 补齐小时�?/工作日数�?
     * @param data - �?要补齐的数据
     * @param sign - �?要补齐的类型,1:小时�?,2:工作�?
     * @param scene - 场景StatUserBar,StatUserBarLine
     * @return
     */
    @SuppressWarnings("unchecked")
    public List addOther(List data,int sign,String scene){
        if(data==null || data.size()<=0) return data;
        int maxLeng = 0;
        String key = "";
        int start = 0;
        if(sign==1){
            maxLeng = 24;
            if(data.size()==maxLeng) return data;
            key = "HOUR_ID";
        }else if(sign==2){
            maxLeng = 8;
            start = 1;
            if(data.size()==maxLeng) return data;
            if(scene!=null && scene.trim().equals("statUserBarLine"))
                key = "WEKDAY_ID";
            if(scene!=null && scene.trim().equals("statUserBar"))
                key = "WORKDAY_ID";
        }else if(sign==3){				//补齐粉丝数分�?
            maxLeng = 13;
            key = "TYPE";
        }

        for(int i=start;i<maxLeng;i++){
            boolean ret = false;
            for(int j=0;j<data.size();j++){
                Map map = (Map)data.get(j);
                int t = UtilString.convertStr(map.get(key)+"", 0);
                if(i==t){
                    ret = true;
                    break;
                }
            }
            if(!ret){
                Map map = new HashMap();
//				map.put("Post", 0);
                map.put(key, i);
//				map.put("Thread", 0);
                if(start==1)
                    data.add(i-1, map);			//每工作日
                else
                    data.add(i, map);			//每小�?
            }
        }
        return data;
    }

    /**
     * 格式化腾讯事件戳
     * @param timestamp
     * @param request
     * @return
     */
    public static String formatQQDate(String timestamp,HttpServletRequest request){
//		Date date = StringUtil.getDate(timestamp);
//		String text = SinaTag.formatDate(date);
//		HttpSession session = request.getSession();
//		Locale local = (Locale)session.getAttribute(Globals.LOCALE_KEY);
//		String lang = local.toString();
//		if(lang!=null && lang.contains("en")){				//英文界面
//			text = text.replace("秒前", " seconds ago");
//			text = text.replace("分钟�?", " minutes ago");
//			text = text.replace("小时�?", " hours ago");
//			text = text.replace("�?", " half ");
//		}
//		return text;
        return null;
    }


    /**
     * 字符高亮 多个字符高亮�?
     * @param keys
     * @param text
     * @param text
     * @return
     */
    public static String replayKeysAndCut(String keys,String text){
        if(keys==null || keys.equals("") || text==null || text.equals("")) return text;

        keys = keys.replaceAll("~", " ").replaceAll("�?", " ").replaceAll("-", " ");
        String[] key = keys.split(" ");						//按空格拆�?

        String aimKey = "";
        int minLength = Integer.MAX_VALUE;
        for(int i=0;i<key.length;i++){
            String myKey = key[i];
            if(myKey==null || myKey.equals("")) continue;
            myKey = StringFilter(myKey) ;					//特殊字符处理
            int thisLength = text.indexOf(myKey);
            if((thisLength>-1)&&(thisLength<minLength)){
                minLength = thisLength;
                aimKey = myKey;
            }
        }
        // 长度限制
        int textLength = text.length();
        int beginSpot = Math.max(0, text.indexOf(aimKey)-140);
        int endSpot = Math.min(textLength, text.indexOf(aimKey)+140);
        text = text.substring(beginSpot, endSpot).trim();
        if(beginSpot>0){
            text = "......"+text;
        }
        if(endSpot<textLength){
            text = text+"......";
        }

        text = UtilString.replayKeys(keys, text);

        return text;
    }

    /**
     * 字符高亮 多个字符高亮�?
     * @param keys
     * @param text
     * @return
     */
    public static String replayKeys(String keys,String text){
        if(keys==null || keys.equals("") || text==null || text.equals("")) return text;
        keys = keys.replaceAll("~", " ").replaceAll("�?", " ").replaceAll("-", " ");
        String[] key = keys.split(" ");						//按空格拆�?
        for(int i=0;i<key.length;i++){
            String myKey = key[i];
            if(myKey==null || myKey.equals("")) continue;
            myKey = StringFilter(myKey) ;					//特殊字符处理
            text = text.replaceAll(myKey, "<span class='color_3'>"+ myKey +"</span>");
        }
        return text;
    }

    /**
     * 通过授权状�?�和媒体类型获取媒体用户类型
     * @param medias - 媒体类型(1新浪�?2腾讯�?1,2新浪和腾�?,5微信)
     * @param authed - 授权状�??(1授权�?2非授权；1,2授权非授�?)
     * */
    public static String getMediaTypes(String medias,String authed){
        if("".equals(medias))medias="1,2,5,6";
        if("".equals(authed))authed="1,2";
        String mediaTypes="";
        if("1".equals(medias)){
            if("1".equals(authed)){
                mediaTypes = "1";
            }
            else if("2".equals(authed)){
                mediaTypes = "11";
            }
            else if("1,2".equals(authed)){
                mediaTypes = "1,11";
            }
        }
        else if("2".equals(medias)){
            if("1".equals(authed)){
                mediaTypes = "2";
            }
            else if("2".equals(authed)){
                mediaTypes = "12";
            }
            else if("1,2".equals(authed)){
                mediaTypes = "2,12";
            }
        }
        else if("5".equals(medias)){
            mediaTypes = "5";
        }
        else if("1,2".equals(medias)){
            if("1".equals(authed)){
                mediaTypes = "1,2";
            }
            else if("2".equals(authed)){
                mediaTypes = "11,12";
            }
            else if("1,2".equals(authed)){
                mediaTypes = "1,2,11,12";
            }
        }
        else if("1,2,5".equals(medias)){
            if("1".equals(authed)){
                mediaTypes = "1,2";
            }
            else if("2".equals(authed)){
                mediaTypes = "11,12";
            }
            else if("1,2".equals(authed)){
                mediaTypes = "1,2,11,12,5";
            }
        }else if("6".equals(medias)){
            mediaTypes = "6";
        }
        return mediaTypes;
    }




    //获得任务管理页面显示的名�?
    public static String getPagesName(String lang,int taskType){
        //获得前台传过来的�?    为后续多条件查询  End
        String pageName="";
        if(taskType==0){
            if(lang.equals("zh")){
                pageName = "我的任务" ;
            }else{
                pageName="Assigned to me";
            }
        }
        if(taskType==1){
            if(lang.equals("zh")){
                pageName = "已解决任�?" ;
            }else{
                pageName="Resolved by me";
            }
        }
        if(taskType==2){
            if(lang.equals("zh")){
                pageName = "�?有任�?" ;
            }else{
                pageName="All Tasks";
            }
        }
        if(taskType==3){
            if(lang.equals("zh")){
                pageName = "我分配的任务" ;
            }else{
                pageName="Reported by me";
            }
        }
        return pageName;
    }

    /**
     * 去除腾讯内容中的A标签
     * @param text
     * @return
     */
    public static String formatText(String text){
        if(text ==null || text.equals(""))return "" ;
        text=text.replaceAll("<a href[^>]*>", "");
        text=text.replaceAll("</a>", "");
        return text ;
    }


    public static String keyWordsTrans(String keywords){
        if(keywords==null||keywords.length()==0)return "";
        String keysNew="";
        String[] keys=keywords.split("~");
        for(String key:keys){
            keysNew+="("+key +") OR ";
        }
        if(keysNew.length()>0)keysNew=keysNew.substring(0, keysNew.length()-4);
        return keysNew;
    }

    public static String cutLetters(String source){
//        String regEx="^(\\-|\\+)?\\d+(\\.\\d+)?$";
        String regEx="[A-Z]|[a-z]]*";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(source);
        return m.replaceAll("").trim();
    }
    /**
     * 生成随机数字和单词
     * @param length
     * @return
     */
    public static String getRandomStringByLength(int length) {
        String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 生成随机数字
     * @param length
     * @return
     */
    public static String getRandomNumberByLength(int length) {
        String base = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

}
