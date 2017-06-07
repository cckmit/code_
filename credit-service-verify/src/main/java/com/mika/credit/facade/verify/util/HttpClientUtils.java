package com.mika.credit.facade.verify.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class HttpClientUtils {
	
	private final static String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.94 Safari/537.36";

	private static List<NameValuePair> getParam(Map<String, String> parameterMap) {
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		if(parameterMap != null){
			Set<String> keySet = parameterMap.keySet();
			for (String key : keySet) {
				nameValuePairs.add(new BasicNameValuePair(key, parameterMap.get(key)));
			}
		}
		return nameValuePairs;
	}
	public static String httpClient(String url){
		//创建HttpClientBuilder
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		//HttpClient
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
		
		HttpGet httpGet = new HttpGet(url);
		System.out.println(httpGet.getRequestLine());
		try {
		    //执行get请求
		    HttpResponse httpResponse = closeableHttpClient.execute(httpGet);
		    //获取响应消息实体
		    HttpEntity entity = httpResponse.getEntity();
		    //响应状态
		    //System.out.println("status:" + httpResponse.getStatusLine());
		    //判断响应实体是否为空
		    if (entity != null) {
		        //System.out.println("contentEncoding:" + entity.getContentEncoding());
		        //response content:{"saxNum":"","message":"ERROR : Data is NULL . ","orderNum":"","code":"-1"}
//		        System.out.println("response content:" + EntityUtils.toString(entity));
		        return EntityUtils.toString(entity);
		    }else{
		    	return null;
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {                //关闭流并释放资源
		        closeableHttpClient.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
		return null;
	}
	
	public static String doPost(String url, Map<String, String> params) {
		//创建HttpClientBuilder
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		//HttpClient
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
		String result = null;
		HttpPost httpPost = new HttpPost(url);
		UrlEncodedFormEntity postEntity;
		try {
			postEntity = new UrlEncodedFormEntity(getParam(params), "UTF-8");
			httpPost.setEntity(postEntity);
			httpPost.setHeader("User-Agent", USER_AGENT);
			HttpResponse response = closeableHttpClient.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity entity = response.getEntity();
				result = EntityUtils.toString(entity);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
    public static void main(String args[]) throws Exception {
    	/*String url = "http://116.62.43.197/api/verify/cmcc_mobile_name";//
		Map<String, String> ingredients = new HashMap<String, String>();
		ingredients.put("accountID", "shanganxin01");
		ingredients.put("token", "3382093691b0d6484fd9");
		ingredients.put("mobile", "13812525856");
		ingredients.put("name", "马志勇");*/
		
		String url = "http://120.76.45.82/tx/MobileVerify/timeLength/query";
		Map<String, String> ingredients = new HashMap<String, String>();
		ingredients.put("accountID", "shanganxin02");
		ingredients.put("token", "e1ad343a-cb3b-11e6-b3af-00163e120866");
		ingredients.put("mobile", "13816241747");
		
		String result = doPost(url, ingredients);
		System.out.println(result);
    }
}