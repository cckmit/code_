package com.mika.credit.facade.front.en.Util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Tool {
	
	public static Map safeAccount;

	public static Map<String,String> loadSafeAccount(){
		Properties p = new Properties();
		InputStream in = null;
		try {
			in=Tool.class.getClassLoader().getResourceAsStream("base.properties");
			p.load(in);
			in.close();
			Map<String,String> map = new HashMap<String,String>();
			map.put("username", p.getProperty("safeAccount.username"));
			map.put("password",p.getProperty("safeAccount.password"));
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

	public static String loadSafeUrl(){
		Properties p = new Properties();
		InputStream in = null;
		try {
			in=Tool.class.getClassLoader().getResourceAsStream("base.properties");
			p.load(in);
			in.close();
			String safeURL = p.getProperty("safeURL");
			return safeURL;
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
}
