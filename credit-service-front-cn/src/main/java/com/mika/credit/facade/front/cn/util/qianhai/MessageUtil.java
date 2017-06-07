package com.mika.credit.facade.front.cn.util.qianhai;

import com.mika.credit.common.util.UtilDateTime;

import java.util.Random;

public class MessageUtil
{    
	
	
    public static String getMHeader_DMZ()
    {
    	UtilDateTime dateUtil = new UtilDateTime();
    	String transNo = dateUtil.getCurrentDate("yyyyMMddHHmmssSSS")+new Random().nextInt(10);//流水号，唯一
    	String transDate = dateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss");//交易期yyyy-MM-dd HH:mm:ss
    	String authDate = dateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss");//授权时间yyyy-MM-dd HH:mm:ss
        StringBuffer sb = new StringBuffer(
                "{\"orgCode\":\"310113001088635\",\"chnlId\":\"lftouzi\",\"transNo\":\""+transNo+"\",\"transDate\":\""+transDate+"\",\"authCode\":\"INV0433XX\",\"authDate\":\""+transDate+"\"}");
        return sb.toString();
    }  
    
    public static String getBusiData_MSC8004(String verifyType, String companyName, String crefoNo)
    {
        UtilDateTime dateUtil = new UtilDateTime();
    	if(null == verifyType || verifyType.equals("")){
    		verifyType = "2";
    	}
    	String entityAuthDate = dateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss");
        StringBuffer sb = new StringBuffer(
                "{\"batchNo\":\"33adfsf323236\",\"records\":[{\"verifyType\":\""+verifyType+"\",\"verifyKey\":\""+companyName+"\",\"reasonCode\":\"04\",\"entityAuthCode\":"
                + "\"936000000\",\"entityAuthDate\":\""+entityAuthDate+"\",\"seqNo\":\"r231545334532\"}]}");
        System.out.println("sb.toString()＝＝＝＝＝＝＝＝：" + sb.toString());
        return sb.toString();
    } 
    
    public static String getSecurityInfo(String signatureValue,String userName, String pwd)
    {
        StringBuffer sb = new StringBuffer("{\"signatureValue\":\"" + signatureValue
                + "\",\"userName\":\""+userName+"\",\"userPassword\":\"" + pwd + "\"}");
        return sb.toString();
    }
}
