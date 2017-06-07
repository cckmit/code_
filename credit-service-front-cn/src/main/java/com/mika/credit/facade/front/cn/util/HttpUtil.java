package com.mika.credit.facade.front.cn.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class HttpUtil {
	
	  static String GET_URL = "http://122.144.131.79:8090/ssmdc/ywcourt?Param=zxgg&keyWord=河北盛华化工有限公司";

	  static String POST_URL = "http://122.144.131.79:8082/translate?m=0&t=测试&t=方法";
	
	/**
     * 接口调用 GET
	 * @return 
     */
    public static String httpURLConectionGET(String Stringurl) {
        try {
            URL url = new URL(Stringurl);    // 把字符串转换为URL请求地址
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 打开连接
            connection.connect();// 连接会话
            // 获取输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {// 循环读取流
                sb.append(line);
            }
            br.close();// 关闭流
            connection.disconnect();// 断开连接
            System.out.println(sb.toString());
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("失败!");
        }
       return null;
    }
    
    /**
     * 接口调用  POST
     */
    public static String httpURLConnectionPOST (String Stringurl) {
        try {
            URL url = new URL(Stringurl);
            
            // 将url 以 open方法返回的urlConnection  连接强转为HttpURLConnection连接  (标识一个url所引用的远程对象连接)
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 此时cnnection只是为一个连接对象,待连接中
            
            // 设置连接输出流为true,默认false (post 请求是以流的方式隐式的传递参数)
            connection.setDoOutput(true);
            
            // 设置连接输入流为true
            connection.setDoInput(true);
            
            // 设置请求方式为post
            connection.setRequestMethod("POST");
            
            // post请求缓存设为false
            connection.setUseCaches(false);
            
            // 设置该HttpURLConnection实例是否自动执行重定向
            connection.setInstanceFollowRedirects(true);
            
            // 设置请求头里面的各个属性 (以下为设置内容的类型,设置为经过urlEncoded编码过的from参数)
            // application/x-javascript text/xml->xml数据 application/x-javascript->json对象 application/x-www-form-urlencoded->表单数据
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            
            // 建立连接 (请求未开始,直到connection.getInputStream()方法调用时才发起,以上各个参数设置需在此方法之前进行)
            connection.connect();
            
            // 创建输入输出流,用于往连接里面输出携带的参数,(输出内容为?后面的内容)
            DataOutputStream dataout = new DataOutputStream(connection.getOutputStream());
            String parm = "storeId=" + URLEncoder.encode("32", "utf-8"); //URLEncoder.encode()方法  为字符串进行编码
            
            // 将参数输出到连接
            dataout.writeBytes(parm);
            
            // 输出完成后刷新并关闭流
            dataout.flush();
            dataout.close(); // 重要且易忽略步骤 (关闭流,切记!) 
            
            System.out.println(connection.getResponseCode());
            
            // 连接发起请求,处理服务器响应  (从连接获取到输入流并包装为bufferedReader)
            BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream())); 
            String line;
            StringBuilder sb = new StringBuilder(); // 用来存储响应数据
            
            // 循环读取流,若不到结尾处
            while ((line = bf.readLine()) != null) {
                sb.append(bf.readLine());
            }
            bf.close();    // 重要且易忽略步骤 (关闭流,切记!) 
            connection.disconnect(); // 销毁连接
            System.out.println(sb.toString());
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public static String syncData(String Stringurl ) {
    	String strReturn = "";
    	String strContent = "";
    	String strHttpUrl =   Stringurl 		;	
//    	"http://122.144.131.79:8090/ssmdc/ywcourt?Param=zxgg&keyWord=河北盛华化工有限公司";
    	try {
    	/**
    	* 组织接口的URL 一般在URL 后面加个id参数，其值需不同(可取一个随机值)，主要用于
    	并发
    	*/
    	URL url = new URL(strHttpUrl);
    	/**
    	* 获取一个HttpURLConnection 链接对象
    	*/
    	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//    	connsetConnectTimeout(30000); //设置超时时间
//    	connsetReadTimeout(30000);
    	/**
    	* 用post 方式传递数据
    	*/
    	conn.setRequestMethod("POST");
    	conn.setDoOutput(true);
    	java.io.OutputStream out = conn.getOutputStream();
    	/**
    	* 写内容到输出流中
    	*/
    	out.write(strContent.getBytes("UTF-8"));
    	out.flush();
    	out.close();
    	/**
    	* 接口调用后获得输入流
    	*/
    	InputStream ins2 = conn.getInputStream();
    	/**
    	* 将接口返回的流转换为字符串String
    	*/
    	strReturn = convertStreamToString(ins2);
    	ins2.close();
    	} catch (Exception e) {
    	System.out.println("接收的URL" + strHttpUrl + "不正确, 发送失败!");
    	e.printStackTrace();
    	}
//    	System.out.println("data=="+strReturn);
    	return strReturn;
    	}
	    /**
	    * 流转换
	    * @param ins
	    * @return
	    */
	    private static String convertStreamToString(InputStream ins) {
	    String strRet = "";
	    try {
	    StringBuffer sbuf = new StringBuffer();
	    InputStreamReader reader = new InputStreamReader(ins, "UTF-8");
	    Reader buf = new BufferedReader(reader);
	    int ch;
	    int iCharNum = 0;
	    while ((ch = buf.read()) > -1) {
	    iCharNum += 1;
	    sbuf.append((char) ch);
	    } buf.close();
	    strRet = sbuf.toString();
	    sbuf.delete(0, sbuf.length());
	    } catch (Exception e) {
	    e.printStackTrace();
	    return "";
	    } return strRet;
	    }
    
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(syncData(POST_URL));
//      httpURLConectionGET(POST_URL);
//      httpURLConnectionPOST(POST_URL);
	}

}
