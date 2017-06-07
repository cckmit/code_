package com.mika.credit.common.entity.order;

import java.util.Objects;

/**
 * 订单状态枚举项
 * @author zj001
 */
public enum OrderStatusEnum {
    FAILURE((byte) -1, "Failure", "失败"),
    CANCELED((byte) 0, "Canceled", "取消"),
    TO_PAY((byte) 1, "ToPay", "待支付"),
    MAKING((byte) 4, "Making", "制作中"),
    FINISHED((byte) 8, "Finished", "已完成");

    private Byte statusCode;
    private String nameEN;
    private String nameCN;

    OrderStatusEnum(Byte statusCode, String nameEN, String nameCN) {
        this.statusCode = statusCode;
        this.nameEN = nameEN;
        this.nameCN = nameCN;
    }

    public Byte getStatusCode() {
        return statusCode;
    }

    public String getNameEN() {
        return nameEN;
    }

    public String getNameCN() {
        return nameCN;
    }

    public static String getNameEN(Byte typeCode) {
        OrderStatusEnum[] values = OrderStatusEnum.values();
        for (OrderStatusEnum value : values) {
            if (Objects.equals(value.statusCode, typeCode)) {
                return value.nameEN;
            }
        }
        return null;
    }

    public static String getNameCN(Byte typeCode) {
        OrderStatusEnum[] values = OrderStatusEnum.values();
        for (OrderStatusEnum value : values) {
            if (Objects.equals(value.statusCode, typeCode)) {
                return value.nameCN;
            }
        }
        return null;
    }

    /**
     * <select id="productType" class="form-control">
     * <option value="">All</option>
     * <option value="1">db report</option>
     * <option value="2">full report</option>
     * <option value="3">db full report</option>
     * </select>
     *
     * @return
     */
    public static String getOptionNameCN() {
//        StringBuilder option = new StringBuilder("<select id=\"orderStatusType\" class=\"form-control\">");
        StringBuilder option = new StringBuilder();
        option.append("<option value=\"\">所有状态</option>");
        OrderStatusEnum[] values = OrderStatusEnum.values();
        for (OrderStatusEnum value : values) {
            option.append("<option value=\"").append(value.statusCode).append("\">").append(value.getNameCN()).append("</option>");
        }
//        option.append("</select>");
        return option.toString();
    }

    public static String getOptionNameEN() {
//        StringBuilder option = new StringBuilder("<select id=\"orderStatusType\" class=\"form-control\">");
        StringBuilder option = new StringBuilder();
        option.append("<option value=\"\">All Status</option>");
        OrderStatusEnum[] values = OrderStatusEnum.values();
        for (OrderStatusEnum value : values) {
            option.append("<option value=\"").append(value.statusCode).append("\">").append(value.getNameEN()).append("</option>");
        }
//        option.append("</select>");
        return option.toString();
    }
}
