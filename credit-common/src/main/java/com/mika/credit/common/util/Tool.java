package com.mika.credit.common.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Tool {
	
	public static String httpUrl;
	
	
	public static  String loadHttpUrl(){
		Properties p = new Properties();;
		InputStream in = null;
		try {
			in=Tool.class.getClassLoader().getResourceAsStream("url.properties");
			p.load(in);  
			in.close();  
			httpUrl = p.getProperty("httpUrl");//����
			System.out.println("�ӿ�Url==="+httpUrl);
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
	
	
	public static  String loadHttpdetailUrl(){
		Properties p = new Properties();;
		InputStream in = null;
		try {
			in=Tool.class.getClassLoader().getResourceAsStream("url.properties");
			p.load(in);  
			in.close();  
			httpUrl = p.getProperty("httpdetailUrl");//����
			System.out.println("�ӿ�Url==="+httpUrl);
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

	public static Map<String,String> loadEmailInfo(){
		Properties p = new Properties();
		InputStream in = null;
		try {
			in=Tool.class.getClassLoader().getResourceAsStream("email.properties");
			p.load(in);
			in.close();
			Map<String,String> map = new HashMap<String,String>();
			map.put("emailSmtp", p.getProperty("emailSmtp"));
			map.put("emailName",p.getProperty("emailName"));
			map.put("emailPwd",p.getProperty("emailPwd"));
			map.put("emailFromAddress",p.getProperty("emailFromAddress"));
			map.put("emailServerPort",p.getProperty("emailServerPort"));
			map.put("emailImagesPath",p.getProperty("emailImagesPath"));
			return map;
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
		return null;
	}

	public static  String loadHttpUrlByRegistrationNumber(){
		Properties p = new Properties();;
		InputStream in = null;
		try {
			in=Tool.class.getClassLoader().getResourceAsStream("url.properties");
			p.load(in);
			in.close();
			httpUrl = p.getProperty("httpUrlByRegistrationNumber");//����
			System.out.println("�ӿ�Url==="+httpUrl);
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

	public static  String loadHttpUrlV2(){
		Properties p = new Properties();;
		InputStream in = null;
		try {
			in=Tool.class.getClassLoader().getResourceAsStream("url.properties");
			p.load(in);
			in.close();
			httpUrl = p.getProperty("httpUrlV2");//����
			System.out.println("�ӿ�Url==="+httpUrl);
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
	public static  String loadHttpUrlByRegistrationNumberV2(){
		Properties p = new Properties();;
		InputStream in = null;
		try {
			in=Tool.class.getClassLoader().getResourceAsStream("url.properties");
			p.load(in);
			in.close();
			httpUrl = p.getProperty("httpUrlByRegistrationNumberV2");//����
			System.out.println("�ӿ�Url==="+httpUrl);
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

	//精确查找url
	public static  String loadHttpUrlAccurate(){
		Properties p = new Properties();;
		InputStream in = null;
		try {
			in=Tool.class.getClassLoader().getResourceAsStream("url.properties");
			p.load(in);
			in.close();
			httpUrl = p.getProperty("httpUrlAccurate");//����
			System.out.println("�ӿ�Url==="+httpUrl);
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

	public static  String loadHttpdetailUrlV2(){
		Properties p = new Properties();;
		InputStream in = null;
		try {
			in=Tool.class.getClassLoader().getResourceAsStream("url.properties");
			p.load(in);
			in.close();
			httpUrl = p.getProperty("httpdetailUrlV2");//����
			System.out.println("�ӿ�Url==="+httpUrl);
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

	public static  String loadCpmSearchListByName(){
		Properties p = new Properties();;
		InputStream in = null;
		try {
			in=Tool.class.getClassLoader().getResourceAsStream("url.properties");
			p.load(in);
			in.close();
			httpUrl = p.getProperty("cpmSearchListByName");//����
			System.out.println("�ӿ�Url==="+httpUrl);
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

	public static  String loadCpmAddOrder(){
		Properties p = new Properties();;
		InputStream in = null;
		try {
			in=Tool.class.getClassLoader().getResourceAsStream("url.properties");
			p.load(in);
			in.close();
			httpUrl = p.getProperty("cpmAddOrder");//����
			System.out.println("�ӿ�Url==="+httpUrl);
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

	public static  String loadCpmV3Url(){
		Properties p = new Properties();;
		InputStream in = null;
		try {
			in=Tool.class.getClassLoader().getResourceAsStream("url.properties");
			p.load(in);
			in.close();
			httpUrl = p.getProperty("cpmV3Url");//����
			System.out.println("�ӿ�Url==="+httpUrl);
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


	public static  String loadCpmV2Url(){
		Properties p = new Properties();;
		InputStream in = null;
		try {
			in=Tool.class.getClassLoader().getResourceAsStream("url.properties");
			p.load(in);
			in.close();
			httpUrl = p.getProperty("cpmV2Url");//����
			System.out.println("�ӿ�Url==="+httpUrl);
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



	public static  String loadCommonUrl(String url){
		Properties p = new Properties();;
		InputStream in = null;
		try {
			in=Tool.class.getClassLoader().getResourceAsStream("url.properties");
			p.load(in);
			in.close();
			httpUrl = p.getProperty(url);//����
			System.out.println("�ӿ�Url==="+httpUrl);
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
}
