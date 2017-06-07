package com.mika.credit.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * StringUtil工具类
 * Created by Hunter on 2017/3/16.
 */
public class StringUtil {

    /**
     * 验证对象是否为空
     * @param obj
     * @return
     */
    public static boolean isNotNull(Object obj){
        boolean flag = true;
        if(null == obj || "".equals(obj)){
            flag = false;
        }
        return flag;
    }

    /**
     * 过滤字符
     * @param source
     * @return
     */
    public static String cutLetters(String source){
//        String regEx="^(\\-|\\+)?\\d+(\\.\\d+)?$";
        String regEx="[A-Z]|[a-z]]*";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(source);
        return m.replaceAll("").trim();
    }

    /**
     * 去除信用分数string后面.0
     * @param value
     * @return
     */
    public static String isIndex(String value){
        Integer  indexValue = null;
        Integer  indexValues = null;
        if(value != null && !value.trim().equals("")){
            try {
                indexValue = (int)Double.parseDouble(value);
                System.out.println("indexValue=="+indexValue);
                //不符合指数要求，出现异常的数据
                if(indexValue<100 || indexValue > 600){
                    indexValue = 600;
                }
                //取余
                indexValues = indexValue % 10;
                //取模
                indexValue = indexValue/10;
                if(null!=indexValues && indexValues>4){
                    indexValue = (indexValue+1) * 10;
                }else{
                    indexValue = indexValue * 10;
                }
                System.out.println("indexValue=="+indexValue);
                return indexValue+"";
            } catch (Exception e) {
                // TODO: handle exception
                return "600";
            }

        }else{
            //不存在，默认600
            return "600";
        }

    }
}
