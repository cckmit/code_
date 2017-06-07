package com.mika.credit.facade.verify.util;

import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.entity.report.cn.BasicData;
import com.mika.credit.common.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tool {
	
	public static String httpUrl;


	/**
	 * 过滤特殊字符
	 * @param str
	 * @return
	 */
	public static String FilterString(String str){
		String regEx="[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？-]";
		if(null != str && !str.trim().equals("")){
			Pattern p   =   Pattern.compile(regEx);
			Matcher m   =   p.matcher(str);
			String result = m.replaceAll(" ").trim();
			//return result.replaceAll(" ", "");
			return result;
		}


		return str;
	}

	public static  String loadCommonUrl(String urlName){
		Properties p = new Properties();;
		InputStream in = null;
		try {
			in=Tool.class.getClassLoader().getResourceAsStream("url.properties");
			p.load(in);
			in.close();
			httpUrl = p.getProperty(urlName);
			System.out.println("Url==="+httpUrl);
			return httpUrl;
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(in!=null){
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "";
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
	/**
	 * 用户IP
	 * @return String
	 */
	public static String getIP(HttpServletRequest request){
		//获取IP
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("x-forwarded-for");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}



	//验证手机
	public static String formatePhone(String phone){
		if(null != phone && !phone.equals("") ){
			String [] arr = new String [] {"+","+86","86"};
			for (int i = 0; i < arr.length; i++) {
				phone = phone.replace(arr[i], "");
			}
			if(phone.length()>11){
				String v = phone.substring(0, 3);
				if(v.equals("086"))
					phone = phone.replace("086", "");
				v = phone.substring(0, 2);
				if(v.equals("86"))
					phone = phone.replace("86", "");
			}

			return phone;
		}
		return "";
	}

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
