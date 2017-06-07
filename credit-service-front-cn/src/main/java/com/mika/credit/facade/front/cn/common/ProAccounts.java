package com.mika.credit.facade.front.cn.common;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


@SuppressWarnings("Duplicates")
public class ProAccounts {

	static Map<String,String>  yiweiMap = new HashMap<String, String>();       //获取亿微信息
	static Map<String,String>  yiweicourtMap = new HashMap<String, String>();  //获取亿微司法信息
	static Map<String,String>  yiweiTelMap = new HashMap<String, String>();    //获取亿微电话信息
	static Map<String,String>  yiweiIDCardMap = new HashMap<String, String>(); //获取身份证信息
	static Map<String,String>  iT3acreditFinancialDataMap = new HashMap<String, String>(); //获取iT3acredit财务数据
	static Map<String,String>  jieAnMap = new HashMap<String, String>(); //获取捷安数据



	static Map<String,String>  gztMap = new HashMap<String, String>();			//国政通
	static Map<String,String>  gldMap = new HashMap<String, String>();			//格兰德
	
	static Map<String,String> qhMap = new HashMap<String, String>(); //前海

	static Map<String,String> hxMap = new HashMap<String, String>(); //翰鑫

	static Map<String,String> fhMap = new HashMap<String, String>(); //法海

	static String limitIP = null ;

	static String soapUrl = null ;

	private static String pathDir = null ;
	private static Logger logger = Logger.getLogger(ProAccounts.class);

	static String gldUser = null ;
	static String gldPwd = null ;






	static {
		logger.info("ProAccounts autoLoading start.");


		Properties prop = new Properties();
		InputStream in = ProAccounts.class.getResourceAsStream("/interface.properties");

		Properties p = new Properties();
		try {
			p.load(in);
		} catch (IOException e1) {
			System.out.println("e1 error:");
			e1.printStackTrace();
		}

		if(!(p.getProperty("yiweiUrl")).equals("")){
			yiweiMap.put("yiweiUrl", (p.getProperty("yiweiUrl")).trim()) ;
			yiweiMap.put("yiweiPwd", (p.getProperty("yiweiPwd")).trim()) ;
			yiweiMap.put("yiweiName", (p.getProperty("yiweiName")).trim()) ;
		}

		if(!(p.getProperty("yiweitelUrl")).equals("")){
			yiweiTelMap.put("yiweitelUrl", (p.getProperty("yiweitelUrl")).trim()) ;
			yiweiTelMap.put("yiweiPwd", (p.getProperty("yiweiPwd")).trim()) ;
			yiweiTelMap.put("yiweiName", (p.getProperty("yiweiName")).trim()) ;
		}

		if(!(p.getProperty("yiweiIDCardUrl")).equals("")){
			yiweiIDCardMap.put("yiweiIDCardUrl", (p.getProperty("yiweiIDCardUrl")).trim()) ;
			yiweiIDCardMap.put("yiweiPwd", (p.getProperty("yiweiPwd")).trim()) ;
			yiweiIDCardMap.put("yiweiName", (p.getProperty("yiweiName")).trim()) ;
		}


		if(!(p.getProperty("yiweiUrl")).equals("")){
			yiweicourtMap.put("yiweiCourtUrl", (p.getProperty("yiweiCourtUrl")).trim()) ;
			yiweicourtMap.put("yiweiPwd", (p.getProperty("yiweiPwd")).trim()) ;
			yiweicourtMap.put("yiweiName", (p.getProperty("yiweiName")).trim()) ;
		}

		if(!(p.getProperty("guozhengtongUrl")).equals("")){
			gztMap.put("guozhengtongUrl", (p.getProperty("guozhengtongUrl")).trim()) ;
			gztMap.put("guozhengtongName", (p.getProperty("guozhengtongName")).trim()) ;
			gztMap.put("guozhengtongPwd", (p.getProperty("guozhengtongPwd")).trim()) ;
			gztMap.put("guozhengtongKey", (p.getProperty("guozhengtongKey")).trim()) ;
		}

		if(!(p.getProperty("grandeKey")).equals("")){
			gldMap.put("grandeKey", (p.getProperty("grandeKey")).trim()) ;
			gldMap.put("grandeSendOrderUrl", (p.getProperty("grandeSendOrderUrl")).trim()) ;
			gldMap.put("grandeQueryOrderUrl", (p.getProperty("grandeQueryOrderUrl")).trim()) ;
			gldMap.put("grandeMonitorOrderUrl", (p.getProperty("grandeMonitorOrderUrl")).trim()) ;
			gldMap.put("grandeMonitorQueryUrl", (p.getProperty("grandeMonitorQueryUrl")).trim()) ;
			gldMap.put("grandeOrgDataUrl", (p.getProperty("grandeOrgDataUrl")).trim()) ;
			gldMap.put("grandeOrgDataV2Url", (p.getProperty("grandeOrgDataV2Url")).trim()) ;
			gldMap.put("grandeSifaDataUrl", (p.getProperty("grandeSifaDataUrl")).trim()) ;
		}

		if(!(p.getProperty("IT3acreditFinancialDataUrl")).equals("")){
			iT3acreditFinancialDataMap.put("IT3acreditFinancialDataUrl", (p.getProperty("IT3acreditFinancialDataUrl")).trim()) ;
		}
		if(!(p.getProperty("JieAnVerifyUrl")).equals("")){
			jieAnMap.put("JieAnVerifyUrl", (p.getProperty("JieAnVerifyUrl")).trim()) ;
			jieAnMap.put("JieAnCustomerId", (p.getProperty("JieAnCustomerId")).trim()) ;
			jieAnMap.put("JieAnMAC", (p.getProperty("JieAnMAC")).trim()) ;
		}
		//---------------------------------
		if(!(p.getProperty("grandeKey")).equals("")){
			soapUrl = (p.getProperty("soapUrl")).trim() ;
		}

		//---------------------------------
		if(!(p.getProperty("ip")).equals("")){
			limitIP =  (p.getProperty("ip")).trim();
		}

		//---------------------------------
		if(!(p.getProperty("grandeUser")).equals("")){
			gldUser =  (p.getProperty("grandeUser")).trim();
			gldPwd =  (p.getProperty("grandePwd")).trim();
		}
		
		//---------------------------------
		if(!(p.getProperty("qianHaiUrl")).equals("")){
			qhMap.put("qianHaiUrl", (p.getProperty("qianHaiUrl")).trim()) ;
			qhMap.put("qianHaiUser", (p.getProperty("qianHaiUser")).trim()) ;
			qhMap.put("qianHaiPwd", (p.getProperty("qianHaiPwd")).trim()) ;
		}

		//---------------------------------
		if(!(p.getProperty("fahaiQueryUrl")).equals("")){
			fhMap.put("fahaiQueryUrl", (p.getProperty("fahaiQueryUrl")).trim()) ;
			fhMap.put("fahaiEntryUrl", (p.getProperty("fahaiEntryUrl")).trim()) ;
			fhMap.put("fahaiPersonUrl", (p.getProperty("fahaiPersonUrl")).trim()) ;
			fhMap.put("fahaiAuthCode", (p.getProperty("fahaiAuthCode")).trim()) ;
		}

		//---------------------------------
		if(!(p.getProperty("hanXinUrl")).equals("")){
			hxMap.put("hanXinUrl", (p.getProperty("hanXinUrl")).trim()) ;
			hxMap.put("hanXinChannelId", (p.getProperty("hanXinChannelId")).trim()) ;
			hxMap.put("hanXinPublicKey", (p.getProperty("hanXinPublicKey")).trim()) ;
		}
		
		//---------------------------------
		//初始化目录
		pathDir = (p.getProperty("pathDir")).trim() ;
		if(pathDir==null || pathDir.equals("")){
			URL url = ProAccounts.class.getClassLoader().getResource("/");
			if(url!= null){
				pathDir = ((new File((new File(url.getPath())).getParent())).getParent()+"\\").trim() ;
			}

		}

		System.out.println("pathDir = "+pathDir);
		System.setProperty("log4jdir", pathDir);
		//---------------------------------


		logger.info("ProAccounts autoLoading end.");
	}

	public static Map<String, String> getjieAnMap() {
		return jieAnMap;
	}

	public static Map<String, String> getiT3acreditFinancialDataMap() {
		return iT3acreditFinancialDataMap;
	}

	public static void setiT3acreditFinancialDataMap(Map<String, String> iT3acreditFinancialDataMap) {
		ProAccounts.iT3acreditFinancialDataMap = iT3acreditFinancialDataMap;
	}

	public static Map<String, String> getYiweiIDCardMap() {
		return yiweiIDCardMap;
	}

	public static void setYiweiIDCardMap(Map<String, String> yiweiIDCardMap) {
		ProAccounts.yiweiIDCardMap = yiweiIDCardMap;
	}

	public static Map<String, String> getYiweiTelMap() {
		return yiweiTelMap;
	}

	public static void setYiweiTelMap(Map<String, String> yiweiTelMap) {
		ProAccounts.yiweiTelMap = yiweiTelMap;
	}

	public static String getSoapUrl() {
		return soapUrl;
	}


	public static Map<String, String> getGldMap() {
		return gldMap;
	}

	public static Map<String, String> getYiweicourtMap() {
		return yiweicourtMap;
	}

	public static String getLimitIP() {
		return limitIP;
	}

	public static Map<String,String> getYiweiMap() {
		return yiweiMap;
	}

	public static Map<String, String> getGztMap() {
		return gztMap;
	}

	public Map<String, String> getYiWeiAccounts(){


		InputStream ins = this.getClass().getResourceAsStream("/interface.properties");
		Properties p = new Properties();

		try {
			p.load(ins);
			ins.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		Map<String,String> map = new HashMap<String, String>();
		map.put("yiweiUrl", (p.getProperty("yiweiUrl")).trim()) ;
		map.put("yiweiPwd", (p.getProperty("yiweiPwd")).trim()) ;
		map.put("yiweiName", (p.getProperty("yiweiName")).trim()) ;

		//System.out.println("map = "+map );

		return map;
	}


	public static String getIpAddr(HttpServletRequest request) {

		String ip = request.getHeader("x-forwarded-for");
		if (null == ip || 0 == ip.length()
				|| "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (null == ip || 0 == ip.length()
				|| "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (null == ip || 0 == ip.length()
				|| "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Real-IP");
		}
		if (null == ip || 0 == ip.length()
				|| "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}


	public static Boolean checkIPAddr(HttpServletRequest request){

		//String ip = getIpAddr(request) ;		

		if(limitIP.indexOf(getIpAddr(request)) > 0){
			System.out.println("Success ip:" + limitIP + "\t ip ="+ getIpAddr(request));
			return true ;
		}else{
			System.out.println("Error ip:" + limitIP + "\t ip ="+ getIpAddr(request));
			return false ;
		}

	}

	//todo modified by mika  change Timestamp to Date ,perhaps some error will be happened

	public static long getCalculateDate(Date data){
		if(data != null){
			long selectStartTime = (new Date()).getTime();
			long selectEndTime = data.getTime();
			long selectTime = (selectStartTime - selectEndTime) / 86400000 ;//(1000 * 60 * 60 * 24);

			return selectTime ;
		}else{
			return 100000;
		}
	}


	public static Timestamp getConvertTimestamp(String endDate){
		if(endDate!= null && !endDate.equals("")){
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
			try {
				ts =  Timestamp.valueOf((formatter.format(formatter.parse(endDate))+" 00:00:00"));
				System.out.println(ts);
			} catch (Exception e) {
				e.printStackTrace();
			}

			return ts ;
		}

		return null;
	}

	public static Timestamp getConvertTimestampGBK(String endDate){
		//System.out.println("ok111");

		if(endDate!= null && !endDate.equals("")){
			//endDate.replaceAll("年","-").replaceAll("月", "-").replaceAll("日", "");

			if(endDate.indexOf("年")>0){
				endDate = endDate.replaceAll("年","-").replaceAll("月", "-").replaceAll("日", "");
			}
			//System.out.println("endDate = "+endDate);

			Timestamp ts = new Timestamp(System.currentTimeMillis());
			DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
			try {
				ts =  Timestamp.valueOf((formatter.format(formatter.parse(endDate))+" 00:00:00"));
				//System.out.println(ts);
			} catch (Exception e) {
				e.printStackTrace();
			}

			return ts ;
		}

		return null;
	}

	public static boolean checkTime(Timestamp oldTime , Timestamp newTime){
		System.out.println("newTime:"+(newTime).getTime());
		System.out.println("oldTime:"+oldTime.getTime());
		if(oldTime!= null && newTime!= null ){

			System.out.println("getConvertTimestamp(newTime).getTime() - oldTime.getTime() = "+((newTime).getTime() - oldTime.getTime()));
			if((newTime).getTime() - oldTime.getTime()  > 0){

				return true ;
			}else{
				return false ;
			}
		}
		System.out.println("NULL");
		return true ;
	}


	public static String getTimeSubDay(int day){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//定义格
		Calendar c = Calendar.getInstance();
		//c.add(Calendar.DATE, - 7);
		c.add(Calendar.DATE, - day);
		Date monday = c.getTime();
		String preMonday = df.format(monday);

		//System.out.println("preMonday = " +preMonday);

		return preMonday ;
	}


	public static String getGldUser() {
		return gldUser;
	}


	public static String getGldPwd() {
		return gldPwd;
	}

	public static Map<String, String> getQhMap() {
		return qhMap;
	}

	public static void setQhMap(Map<String, String> qhMap) {
		ProAccounts.qhMap = qhMap;
	}

	public static Map<String, String> getHxMap() {
		return hxMap;
	}

	public static void setHxMap(Map<String, String> hxMap) {
		ProAccounts.hxMap = hxMap;
	}

	public static Map<String, String> getFhMap() {
		return fhMap;
	}
}
