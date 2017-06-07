package com.mika.credit.facade.gugu.util;

import com.mika.credit.common.util.StringUtil;

/**
 * Created by dong jian hua on 2017/5/27.
 */
public class TranslateTools {

    /**
     * 去除汉字的货币类型
     * @param money
     * @return
     */
    public static String currencyType(String money){
        String regCapital = "";
        if(StringUtil.isNotNull(money)){
            if (StringUtil.isNotNull(money.trim())){
                regCapital = money.replace("万人民币","").replace("万美元","").replace("万港币","").replace("万欧元","").replace("万日元","").replace("万加元澳元","").replace("万瑞士法郎","").replace(" ","");
            }
        }
        return regCapital;
    }
}
