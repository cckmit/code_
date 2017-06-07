package com.mika.credit.common.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通知类型
 * 
 * @author mika
 * 
 */
public enum MqTypeEnum {

	FRONT_CN("通知frontcn", 1),

	FRONT_EN("通知fronten", 2),

	EMAIL("通知email", 3),

	PDF("通知pdf", 5),

	CPM("通知cpm", 5),

	EBIZ("通知ebiz", 6),

	GLOBALEAGLE("通知globaleagle", 7),

	GLOBALSEARCH("通知globalsearch", 8),

	INDEX("通知index", 9),

	ADMIN("通知admin", 10),

	ORDER_CN_FULLREPORT("通知cn查询全报告", 11),
	ORDER_EN_FULLREPORT("通知en查询全报告", 12),
	ORDER_CN_PARTREPORT("通知cn查询部分报告", 13),
	ORDER_EN_PARTREPORT("通知en查询部分报告", 14),
	ORDER_PDF_DATAPDF("order通知pdf生成pdf文件",15),
	_EMAIL_SENDEMAIL("通知email发送邮件",16),
	CN_CN_SAVEFULLREPORT("cn异步保存全报告",17),
	CPM_CN_PARSEFULLREPORT("cpm数据解析保存",18),
	CN_ORDER_UPDATEFULLREPORT("cn数据通知order修改对应订单企业txt数据",19),
	EN_ORDER_UPDATEFULLREPORT("en数据通知order修改对应订单企业txt数据",22),
	CPM_ORDER_UPDATEFULLREPORT("cpm数据通知order修改对应订单企业txt数据",20),
	CPM_BIGNETORDER_UPDATEFULLREPORT("cpm数据通知bignetorder修改对应订单企业txt数据",21),
	;


	private String desc;

	private int value;

	private MqTypeEnum(String desc, int value) {
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

	public static MqTypeEnum getEnum(int value) {
		MqTypeEnum resultEnum = null;
		MqTypeEnum[] enumAry = MqTypeEnum.values();
		for (int i = 0; i < enumAry.length; i++) {
			if (enumAry[i].getValue() == value) {
				resultEnum = enumAry[i];
				break;
			}
		}
		return resultEnum;
	}

	public static List toList() {
		MqTypeEnum[] ary = MqTypeEnum.values();
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
