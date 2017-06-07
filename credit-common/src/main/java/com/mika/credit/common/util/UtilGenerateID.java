package com.mika.credit.common.util;

import java.net.URL;
import java.util.Date;
import java.util.UUID;

public class UtilGenerateID {
	private static UtilGenerateID utilComm;
	static {
		utilComm = new UtilGenerateID();
	}
	private UtilGenerateID(){
		
	}
	public static UtilGenerateID getInstance(){
		return utilComm;
	}
	/**
	 * classes文件夹目录URL
	 */
	public static final URL CLASSES_ROOT_URL = Thread.currentThread().getContextClassLoader().getResource("");
	/**
	 * classes文件夹目录路径
	 */
	public static final String CLASSES_ROOT_PATH = CLASSES_ROOT_URL.getPath();
	
	private static long curgenerateID = 0L;
	
	public static synchronized String generateID(String pre){
		long time = new Date().getTime();
		if(time == curgenerateID)
			time++;
		curgenerateID = time;
		try {
			Thread.sleep(1L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (pre + Long.toHexString(time).toString()).toUpperCase();
	}
	
	public static void main(String[] args){
		System.out.println(UUID.randomUUID().toString());
		System.out.println(UUID.randomUUID().toString());
		System.out.println(UUID.randomUUID().toString());
		System.out.println(UUID.randomUUID().toString());
		System.out.println(UUID.randomUUID().toString());
		System.out.println(UUID.randomUUID().toString());
		System.out.println(utilComm.generateID(""));
		System.out.println(utilComm.generateID(""));
		System.out.println(utilComm.generateID(""));
		System.out.println(utilComm.generateID(""));
		System.out.println(utilComm.generateID(""));
		System.out.println(utilComm.generateID(""));
		System.out.println(utilComm.generateID(""));
		System.out.println(utilComm.generateID(""));
	}
}
