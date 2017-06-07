package com.mika.credit.common.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public enum MqStatusEnum {
	
	SUCCESS("通知成功", 100),
	FAILED("通知失败", 101),
	HTTP_REQUEST_SUCCESS("http请求响应成功", 200), 
	HTTP_REQUEST_FALIED("http请求失败", 201);

	private String desc;

	private int value; 

	private MqStatusEnum(String desc, int value) {
		this.desc = desc;
		this.value = value;
	}
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static MqStatusEnum getEnum(int value){
		MqStatusEnum resultEnum = null;
		MqStatusEnum[] enumAry = MqStatusEnum.values();
		for(int i = 0;i<enumAry.length;i++){
			if(enumAry[i].getValue() == value){
				resultEnum = enumAry[i];
				break;
			}
		}
		return resultEnum;
	}
	
	public static Map<String, Map<String, Object>> toMap() {
		MqStatusEnum[] ary = MqStatusEnum.values();
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>();
		for (int num = 0; num < ary.length; num++) {
			Map<String, Object> map = new HashMap<String, Object>();
			String key = String.valueOf(getEnum(ary[num].getValue()));
			map.put("value", String.valueOf(ary[num].getValue()));
			map.put("desc", ary[num].getDesc());
			enumMap.put(key, map);
		}
		return enumMap;
	}
	
	
	public static List toList(){
		MqStatusEnum[] ary = MqStatusEnum.values();
		List list = new ArrayList();
		for(int i=0;i<ary.length;i++){
			Map<String,String> map = new HashMap<String,String>();
			map.put("value",String.valueOf(ary[i].getValue()));
			map.put("desc", ary[i].getDesc());
			list.add(map);
		}
		return list;
	}
	
	public static String getJsonStr(){
		MqStatusEnum[] enums = MqStatusEnum.values();
		StringBuffer jsonStr = new StringBuffer("[");
		for (MqStatusEnum senum : enums) {
			if(!"[".equals(jsonStr.toString())){
				jsonStr.append(",");
			}
			jsonStr.append("{id:'")
					.append(senum.toString())
					.append("',desc:'")
					.append(senum.getDesc())
					.append("',value:'")
					.append(senum.getValue())
					.append("'}");
		}
		jsonStr.append("]");
		return jsonStr.toString();
	}

}
