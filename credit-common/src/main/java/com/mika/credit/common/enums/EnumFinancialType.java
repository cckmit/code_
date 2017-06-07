package com.mika.credit.common.enums;

/**
 * Created by Zhu Jun on 2017/5/16.
 */
public enum EnumFinancialType {

    ASSET("1"),//资产
    OWNERSHIP_INTEREST("2"),//所有者权益
    PROFIT("3"),//利润
    REGISTRATION("4"),//注册
    FINANCIAL_ANALYSIS("5");//财务分析

    private String i;

    EnumFinancialType(String i) {
        this.i = i;
    }

    public String getI() {
        return i;
    }

    public void setI(String i) {
        this.i = i;
    }
}
