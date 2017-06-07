package com.mika.credit.facade.front.cn.util;

import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.entity.report.cn.BasicData;
import com.mika.credit.common.entity.report.cn.RegistrationInfos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * Created by dong jian hua on 2017/2/18.
 */
public class Tool {


    private static String cpmUrl;
    private static String marketUrl;

//    public static void main(String[] args){
//        String url = "marketUrl";
//        String marketUrl = loadUrl(url);
//        System.out.println(marketUrl);
//    }

    /**
     * 获取配置文件CpmInterface
     */
    public static  String loadUrl(String url){
        Properties p = new Properties();
        InputStream in = null;
        try{
            in=Tool.class.getClassLoader().getResourceAsStream("CpmInterface.properties");
            p.load(in);
            in.close();
            cpmUrl = p.getProperty("cpmUrl");//常数
            marketUrl = p.getProperty("marketUrl");//常数
        }catch(FileNotFoundException e1){
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(in!=null){
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if("cpmUrl".equals(url)){
            return cpmUrl;
        }else if ("marketUrl".equals(url)){
            return marketUrl;
        }else {
            return null;
        }
    }


    public static boolean compare_date(String DATE1, String DATE2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                return true;
            } else if (dt1.getTime() < dt2.getTime()){
                return false;
            } else {
                return false;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }



    /**
     * String类型转数值类型
     * */
    public static int StringToInt(String str){
        int count = 0;
        try{
            count = Integer.parseInt(str);
        }catch(Exception ex){

        }
        return count;
    }

    public static String getinfoData(JSONObject info, String data){
        try{
            String str = info.getString(data);
            if(null!=str && "null".equals(str)){
                str = "";
            }
            return  str;
        }catch (Exception e){
            return "";
        }

    }
    //中文括号转英文括号
    public static String replaceSymbol(String str){
        if(null!=str && !"".equals(str.trim()) ){
            str = str.replace("（","(");
            str = str.replace("）",")");
            return str;
        }else{
            return null!=str && !"".equals(str.trim()) ?str:"";
        }
    }

    //String转Int
    public static int stringToIntStr(String str){
        try{
            if(null!=str && !"".equals(str)){
                return Integer.parseInt(str);
            }
        }catch (Exception ex){
            return 0;
        }
        return 0;
    }
    //英文括号转中文括号
    public static String replaceSymbolCN(String str){
        if(null!=str && !"".equals(str.trim()) ){
            str = str.replace("(","（");
            str = str.replace(")","）");
            return str;
        }else{
            return null!=str && !"".equals(str.trim()) ?str:"";
        }
    }

    /**
     * 中英文符号转换
     * */
    public static String Symbolconversion(String str){
        if(null!=str && !"".equals(str.trim()) ){
            str = str.replace("，", ",");
            str = str.replace("！", "!");
            str = str.replace("？", "?");
            str = str.replace("；", ";");
            str = str.replace("。", ".");
            str = str.replace("【", "[");
            str = str.replace("】", "]");
            str = str.replace("（", "(");
            str = str.replace("）", ")");
            str = str.replace("（", "(");
            str = str.replace("）", ")");
            str = str.replace('“', '"');
            str = str.replace('”', '"');
            str = str.replace("‘", "'");
            str = str.replace("’", "'");
            str = str.replace("：", ":");
            str = str.replace("《", "<");
            str = str.replace("》", ">");
            str = str.replace("、", "");
            str = str.replace(" ", "");
            str = str.replace(" ", "");
            return str;
        }else{
            return null!=str && !"".equals(str.trim()) ?str:"";
        }
    }

    //货币代码
    public static Integer getIntRcid(List<BasicData> currencyList, String currency){
        Integer rcid = 0;
        if(null!=currency&&!"".equals(currency.trim())){
            for (int i = 0; i < currencyList.size(); i++) {
                BasicData data =  currencyList.get(i);
                if(data.getValueCN().equals(currency.trim())){
                    rcid = data.getCode();
                }else if(currency.trim().contains(data.getValueCN())){
                    rcid = data.getCode();
                }
            }
        }

        return rcid;
    }

    public static String getStringRcid(List<BasicData> currencyList, String currency){
        String rcid = "";
        if(null!=currency&&!"".equals(currency.trim())){
            for (int i = 0; i < currencyList.size(); i++) {
                BasicData data =  currencyList.get(i);
                if(data.getValueCN().equals(currency.trim())){
                    rcid = data.getValueCN();
                }else if(currency.trim().contains(data.getValueCN())){
                    rcid = data.getValueCN();
                }
            }
        }

        return rcid;
    }

    //判断是否为空
    public static boolean isNull(String str){
        if(null!=str&&!"".equals(str.trim())){
            return true;
        }else{
            return false;
        }

    }

    //格式化年报企业资产
    public static String SetMoneyMultiplied_YearReport(String money){
        Long price = 0L;
        money = money.replace(" ", "");
        money = money.replace("万元人民币", "");
        money = money.replace(",", "");
        money = money.replace("万元", "");
        money = money.replace("万", "");
	    	/*if(null!=money&&!"".equals(money.trim())){
	    		try {
					price = Long.valueOf(money.trim());
					price = price*10000;
					money = price+"";
					return money;
				} catch (NumberFormatException e) {
					money = "";
					return money;
				}
	    	}else{
	    		return money;
	    	}	*/
        return money;
    }


    //判断企业状态
    public static int EnterpriseStatus(String Status){
        Status = Symbolconversion(Status);
        int returnobj = 0;
        if(null!=Status&&"在营(开业)".equals(Status)){
            returnobj = 1;
        }else if(null!=Status&&"吊销".equals(Status)){
            returnobj = 4;
        }else if(null!=Status&&"存续(在营开业在册)".equals(Status)){
            returnobj = 1;
        }else if(null!=Status&&"存续".equals(Status)){
            returnobj = 1;
        }else if(null!=Status&&"注销".equals(Status)){
            returnobj = 3;
        }else{
            returnobj = 9;
        }
        return returnobj;
    }
    public static String EnterpriseStatusStr(String Status){
        Status = Symbolconversion(Status);
        String returnobj = "";
        if(null!=Status&&"在营(开业)".equals(Status)){
            returnobj = "存续";
        }else if(null!=Status&&"吊销".equals(Status)){
            returnobj = "营业执照被吊销";
        }else if(null!=Status&&"存续(在营开业在册)".equals(Status)){
            returnobj = "存续";
        }else if(null!=Status&&"存续".equals(Status)){
            returnobj = "存续";
        }else if(null!=Status&&"注销".equals(Status)){
            returnobj = "注销";
        }else{
            returnobj = "未知";
        }
        return returnobj;
    }
    //判断企业类型和企业性质
    public static String TypeAndNatureOfBusinessStr(String EntType){
        EntType = Symbolconversion(EntType);
        String EntTypes = "";
        if(null!=EntType&&"有限责任公司(外商投资企业法人独资)".equals(EntType)){
            EntTypes = "外商投资企业";
        }else if(null!=EntType&&"全民所有制".equals(EntType)){
            EntTypes = "国有企业";
        }else if(null!=EntType&&"股份有限公司(非上市国有控股)".equals(EntType)){
            EntTypes = "股份有限公司";
        }else if(null!=EntType&&"有限责任公司(中外合资)".equals(EntType)){
            EntTypes = "中外合资经营企业";
        }else if(null!=EntType&&"股份有限公司(上市)".equals(EntType)){
            EntTypes = "股份有限公司";
        }else if(null!=EntType&&"有限责任公司(自然人投资或控股)".equals(EntType)){
            EntTypes = "有限责任公司";
        }else if(null!=EntType&&"有限责任公司(非自然人投资或控股的法人独资)".equals(EntType)){
            EntTypes = "有限责任公司";
        }else if(null!=EntType&&"股份有限公司(非上市自然人投资或控股)".equals(EntType)){
            EntTypes = "股份有限公司";
        }else if(null!=EntType&&"有限责任公司(中外合资)".equals(EntType)){
            EntTypes = "中外合资经营企业";
        }else if(null!=EntType&&"有限责任公司(法人独资)".equals(EntType)){
            EntTypes = "有限责任公司";
        }else if(null!=EntType&&"其他有限责任公司".equals(EntType)){
            EntTypes = "其他企业";
        } else{
            EntTypes = "其他企业";
        }
        return EntTypes;
    }

    public static int TypeAndNatureOfBusiness(String EntType){
        EntType = Symbolconversion(EntType);
        int EntTypes = 0;
        if(null!=EntType&&"有限责任公司(外商投资企业法人独资)".equals(EntType)){
            EntTypes = 300;
        }else if(null!=EntType&&"全民所有制".equals(EntType)){
            EntTypes = 110;
        }else if(null!=EntType&&"股份有限公司(非上市国有控股)".equals(EntType)){
            EntTypes = 160;
        }else if(null!=EntType&&"有限责任公司(中外合资)".equals(EntType)){
            EntTypes = 310;
        }else if(null!=EntType&&"股份有限公司(上市)".equals(EntType)){
            EntTypes = 160;
        }else if(null!=EntType&&"有限责任公司(自然人投资或控股)".equals(EntType)){
            EntTypes = 150;
        }else if(null!=EntType&&"有限责任公司(非自然人投资或控股的法人独资)".equals(EntType)){
            EntTypes = 150;
        }else if(null!=EntType&&"股份有限公司(非上市自然人投资或控股)".equals(EntType)){
            EntTypes = 160;
        }else if(null!=EntType&&"有限责任公司(中外合资)".equals(EntType)){
            EntTypes = 310;
        }else if(null!=EntType&&"有限责任公司(法人独资)".equals(EntType)){
            EntTypes = 150;
        }else if(null!=EntType&&"其他有限责任公司".equals(EntType)){
            EntTypes = 190;
        } else{
            EntTypes = 190;
        }
        return EntTypes;
    }

    //判断企业类型和企业性质
    public static RegistrationInfos TypeAndNature(String EntType){
        EntType = Symbolconversion(EntType);
        RegistrationInfos reg = new RegistrationInfos();
        if(null!=EntType&&"有限责任公司(外商投资企业法人独资)".equals(EntType)){
            reg.setCompanyTypesId(300);
            reg.setCompanyPropertiesId(1);
        }else if(null!=EntType&&"全民所有制".equals(EntType)){
            reg.setCompanyTypesId(110);
            reg.setCompanyPropertiesId(4);
        }else if(null!=EntType&&"股份有限公司(非上市国有控股)".equals(EntType)){
            reg.setCompanyTypesId(160);
            reg.setCompanyPropertiesId(2);
        }else if(null!=EntType&&"有限责任公司(中外合资)".equals(EntType)){
            reg.setCompanyTypesId(310);
            reg.setCompanyPropertiesId(1);
        }else if(null!=EntType&&"股份有限公司(上市)".equals(EntType)){
            reg.setCompanyTypesId(160);
            reg.setCompanyPropertiesId(2);
        }else if(null!=EntType&&"有限责任公司(自然人投资或控股)".equals(EntType)){
            reg.setCompanyTypesId(150);
            reg.setCompanyPropertiesId(1);
        }else if(null!=EntType&&"有限责任公司(非自然人投资或控股的法人独资)".equals(EntType)){
            reg.setCompanyTypesId(150);
            reg.setCompanyPropertiesId(1);
        }else if(null!=EntType&&"股份有限公司(非上市自然人投资或控股)".equals(EntType)){
            reg.setCompanyTypesId(160);
            reg.setCompanyPropertiesId(2);
        }else if(null!=EntType&&"有限责任公司(中外合资)".equals(EntType)){
            reg.setCompanyTypesId(310);
            reg.setCompanyPropertiesId(1);
        }else if(null!=EntType&&"有限责任公司(法人独资)".equals(EntType)){
            reg.setCompanyTypesId(150);
            reg.setCompanyPropertiesId(1);
        }else if(null!=EntType&&"其他有限责任公司".equals(EntType)){
            reg.setCompanyTypesId(159);
            reg.setCompanyPropertiesId(1);
        } else if(null!=EntType&&"有限责任公司".equals(EntType)){
            reg.setCompanyTypesId(150);
            reg.setCompanyPropertiesId(1);
        }else if(null!=EntType&&"其他股份有限公司(非上市)".equals(EntType)){
            reg.setCompanyTypesId(160);
            reg.setCompanyPropertiesId(1);
        } else{
            reg.setCompanyTypesId(190);
            reg.setCompanyPropertiesId(5);
        }
        return reg;
    }
    //三位一撇
    public static String formatMoney(String value) throws Exception{
        try {
            if(value != null && value.length()!=0 && !value.trim().equals("") && !value.trim().equals("null")){
                boolean bool = value.contains(".");
                Double b = Double.parseDouble(value.trim());
                BigDecimal a = new BigDecimal(b);
                DecimalFormat format = null ;
                if(bool){
                    format = new DecimalFormat("##,###,###,###,###,###");
                }else{
                    format = new DecimalFormat("##,###,###,###,###,###");
                }
                value=format.format(a);
                return value;
            }else{
                return " ";
            }
        } catch (Exception e) {
            throw new Exception("格式化数值有问题-"+value);
        }
    }
    //格式化资金
    public static String SetMoneyMultiplied(String money){
        double price = 0;
        money = money.replace(" ", "");
        if(null!=money&&!"".equals(money.trim())){
            try {
                if(money.contains(".")&&money.contains("万")){
                    money = money.substring(0,money.lastIndexOf("万"));
                    price = Double.valueOf(money.trim());
                    price = price*10000;
                    int i = (int) price;
                    money = i+"";
                }if(money.contains("万")){
                    money = money.substring(0,money.lastIndexOf("万"));
                    price = Double.valueOf(money.trim());
                    price = price*10000;
                    int i = (int) price;
                    money = i+"";
                }else{
                    if(money.length()>2){
                        String lstr = money.substring(money.lastIndexOf(".")+1,money.length());
                        money = money.substring(0,money.lastIndexOf("."));
//						System.out.println(lstr);
                        if(lstr.length()==0){
                            lstr = "0000";
                        }else if(lstr.length()==1){
                            lstr = lstr + "000";
                        }else if(lstr.length()==2){
                            lstr = lstr +  "00";
                        }else if(lstr.length()==3){
                            lstr = lstr +  "0";
                        }if(lstr.length()==3){
                            lstr = lstr;
                        }else if(lstr.length()>4){
                            lstr = lstr.substring(0,4);
                        }
                        money = money + lstr;
                    }else{
                        price = Double.valueOf(money.trim());
                        price = price*10000;
                        int i = (int) price;
                        money = i+"";
                    }
                }
                return money;
            } catch (NumberFormatException e) {
                money = "";
                return money;
            }
        }else{
            return money;
        }
    }


}

