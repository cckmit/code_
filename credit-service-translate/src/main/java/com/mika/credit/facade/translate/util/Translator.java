
package com.mika.credit.facade.translate.util;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.facade.translate.model.TranslatorJson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;




public class Translator {
	
	public static Integer Common = 0;//0 -- 通用模式
	public static Integer BasicName = 1;//1 -- 公司名称
	public static Integer Address = 2;// 2 -- 地址
	public static Integer Name = 3;//3 -- 姓名
	public static String  [] text ;

	/**
	 * 翻译接口调用  json接口
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		long startTime=System.currentTimeMillis();   //获取开始时间
		text = new String[30];
		for (int i = 0; i < text.length; i++) {
			if(i%2==0){
				text[i] = "测试";
			}else{
				text[i] = "方法";
			}			
		}
	
		TranslatorJson json = translateMany(Common, text);
		for (int i = 0; i <json.source.length; i++) {
			System.out.println("json.source["+i+"]=="+json.source[i]);
		}
		for (int i = 0; i <json.dest.length; i++) {
			System.out.println("json.dest["+i+"]=="+json.dest[i]);
		}
		long endTime=System.currentTimeMillis(); //获取结束时间  
		System.out.println("创建索引耗费时间： "+(endTime-startTime)+"ms");
	}

	

	public static TranslatorJson translateMany(Integer number, String [] text) {
		TranslatorJson tjson = new TranslatorJson();
		if(number == null || text == null) {
			return null;
		}

		BufferedReader reader = null;
		try {
			URL url = new URL("http://122.144.131.79:8080/translate");
			
			Map<String, Object> params = new LinkedHashMap<String, Object>();
			params.put("m", number);
			System.out.println("number=="+number);
//			if(text.length>0){
//				params.put("t", text[0]);
//			}
			for (int i = 0; i < text.length; i++) {
				if(null != text[i]){
					params.put("t" + i, text[i]);
				}else{
					params.put("t" + i, "");
				}
			}
			StringBuilder postData = new StringBuilder();
			for(Map.Entry<String, Object> param : params.entrySet()) {
				if(postData.length() != 0) {
					postData.append('&');
				}
				postData.append(URLEncoder.encode(param.getKey().substring(0, 1), "UTF-8")).append('=').append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
			}
			byte[] postDataBytes = postData.toString().getBytes("UTF-8");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setConnectTimeout(5 * 60 * 1000);
			conn.setReadTimeout(5 * 60 * 1000);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
	        conn.setDoOutput(true);
	        conn.getOutputStream().write(postDataBytes);
	        
	        StringBuilder json = new StringBuilder();
	        reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
	        String line;
	        while((line = reader.readLine()) != null) {
	        	json.append(line);
	        }
	        if(json.length() == 0) {
	        	return null;
	        }
	        
	        String strJson = json.toString();
	        System.out.println("strJson=="+strJson);
	        JSONObject jsonobjet = JSON.parseObject(strJson);
	        String success = jsonobjet.getString("success");
	        if(null!=success &&"true".equals(success)){
	        	JSONArray source=jsonobjet.getJSONArray("source");
				JSONArray dest=jsonobjet.getJSONArray("dest");				
				tjson.source = new String[source.size()];
				tjson.dest = new String[dest.size()];
				for (int i = 0; i < source.size(); i++) {
					String str = source.getString(i);				
					tjson.source[i] = str;
				}
				for (int i = 0; i < dest.size(); i++) {
					String str = dest.getString(i);				
					tjson.dest[i] = str;
				}
	        }else{
	        	tjson.source = new String[text.length];
				tjson.dest = new String[text.length];
	        	for (int i = 0; i < text.length; i++) {				
					tjson.source[i] = " ";
				}
				for (int i = 0; i < text.length; i++) {						
					tjson.dest[i] = " ";
				}
	        }
			
	        return tjson;
		} catch (Exception e) {	
			tjson.source = new String[text.length];
			tjson.dest = new String[text.length];
        	for (int i = 0; i < text.length; i++) {				
				tjson.source[i] = " ";
			}
			for (int i = 0; i < text.length; i++) {						
				tjson.dest[i] = " ";
			}
			 return tjson;
		}
		
	}


	public static String translateOnly(Integer number, String text) {
		if(number == null || text == null) {
			return null;
		}
		
		BufferedReader reader = null;
		try {
			URL url = new URL("http://122.144.131.79:8080/translate");
			
			Map<String, Object> params = new LinkedHashMap<String, Object>();
			//System.out.println(mode.ordinal());
			params.put("m", number);
			if(text!=null && !"".equals(text)){
				params.put("t", text);
			}else{
				params.put("t", "");
			}
			StringBuilder postData = new StringBuilder();
			for(Map.Entry<String, Object> param : params.entrySet()) {
				if(postData.length() != 0) {
					postData.append('&');
				}
				postData.append(URLEncoder.encode(param.getKey(), "UTF-8")).append('=')
					.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
			}
			byte[] postDataBytes = postData.toString().getBytes("UTF-8");
			
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setConnectTimeout(5 * 60 * 1000);
			conn.setReadTimeout(5 * 60 * 1000);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
	        conn.setDoOutput(true);
	        conn.getOutputStream().write(postDataBytes);
	        
	        StringBuilder json = new StringBuilder();
	        reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
	        String line;
	        while((line = reader.readLine()) != null) {
	        	json.append(line);
	        }
	        if(json.length() == 0) {
	        	return null;
	        }
	        return JSON.parseObject(json.toString(), Result.class).getDest();
		} catch (Exception e) {
			e.getMessage();
		}
		return "";
	}
	
	public static String translate(Integer number, String text) {
		if(number == null || text == null) {
			return null;
		}
		
		BufferedReader reader = null;
		try {
			URL url = new URL("http://122.144.131.79:8080/translate");
			
			Map<String, Object> params = new LinkedHashMap<String, Object>();
			//System.out.println(mode.ordinal());
			params.put("m", number);
			params.put("t", text);
			
			StringBuilder postData = new StringBuilder();
			for(Map.Entry<String, Object> param : params.entrySet()) {
				if(postData.length() != 0) {
					postData.append('&');
				}
				postData.append(URLEncoder.encode(param.getKey(), "UTF-8")).append('=')
					.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
			}
			byte[] postDataBytes = postData.toString().getBytes("UTF-8");
			
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setConnectTimeout(5 * 60 * 1000);
			conn.setReadTimeout(5 * 60 * 1000);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
	        conn.setDoOutput(true);
	        conn.getOutputStream().write(postDataBytes);
	        
	        StringBuilder json = new StringBuilder();
	        reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
	        String line;
	        while((line = reader.readLine()) != null) {
	        	json.append(line);
	        }
	        if(json.length() == 0) {
	        	return null;
	        }
			return JSON.parseObject(json.toString(), Result.class).getDest();
		} catch (Exception e) {
			
		}
		return "";
	}
}

class Result {
	
	private boolean success;
	
	private String error;
	
	private String source;
	
	public String dest;

	
	public Result() {
		
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	
	
}
 