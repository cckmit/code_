package com.mika.credit.common.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 报告模块类型
 * 
 * @author mika
 * 
 */
public enum ModuleTypeEnum {

	FINANCIAL("财务", 1),

	JUDICIAL("司法", 2),

	REGISTRATION("工商注册", 3),

	INTERVIEW("访问", 4),

	NEWS("新闻", 5),

	APTITUDE("资质", 6),

	OTHERS("其他", 7),

	;


	private String desc;

	private int value;

	private ModuleTypeEnum(String desc, int value) {
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

	public static ModuleTypeEnum getEnum(int value) {
		ModuleTypeEnum resultEnum = null;
		ModuleTypeEnum[] enumAry = ModuleTypeEnum.values();
		for (int i = 0; i < enumAry.length; i++) {
			if (enumAry[i].getValue() == value) {
				resultEnum = enumAry[i];
				break;
			}
		}
		return resultEnum;
	}

	public static List toList() {
		ModuleTypeEnum[] ary = ModuleTypeEnum.values();
		List list = new ArrayList();
		for (int i = 0; i < ary.length; i++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("value", String.valueOf(ary[i].getValue()));
			map.put("desc", ary[i].getDesc());
			list.add(map);
		}
		return list;
	}
}
