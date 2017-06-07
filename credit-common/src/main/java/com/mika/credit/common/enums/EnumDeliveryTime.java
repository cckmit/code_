package com.mika.credit.common.enums;

/**
 * Created by Gavin on 2017/5/17.
 */
public enum EnumDeliveryTime {
    NRM("NRM",5*24,"Normal Order = Delivery* within 5 working days"),
    EXP("NRM",48,"Express Order = Delivery* within 48 working hours");

    private String code;
    private Integer hour;
    private String description;

    EnumDeliveryTime(String code, int hour, String description) {
        this.code = code;
        this.hour = hour;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public Integer getHour() {
        return hour;
    }

    public String getDescription() {
        return description;
    }
}
