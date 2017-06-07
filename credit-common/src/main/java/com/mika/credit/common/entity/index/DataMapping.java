package com.mika.credit.common.entity.index;

import java.util.HashMap;
import java.util.Map;

/**
 * 字段映射
 * Created by Gavin on 2017/2/8.
 */
public class DataMapping {
    public static Map<Integer, String> status = new HashMap<>();
    static {
        status.put(1, "Active");
        status.put(2, "Inactive");
        status.put(3, "Dissolved");
        status.put(4, "Business licence has been revoked");
        status.put(5, "Bankruptcy");
        status.put(6, "Receivership");
        status.put(7, "Suspend");
        status.put(8, "Closed");
        status.put(9, "Unknown");
    }

    public static Map<Integer, String> statusCN = new HashMap<>();
    static {
        statusCN.put(1, "活跃的");
        statusCN.put(2, "不活跃");
        statusCN.put(3, "已解散");
        statusCN.put(4, "营业执照被吊销");
        statusCN.put(5, "已破产");
        statusCN.put(6, "破产在管");
        statusCN.put(7, "暂时停业");
        statusCN.put(8, "已倒闭");
        statusCN.put(9, "未知");
    }
}
