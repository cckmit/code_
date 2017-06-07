package com.mika.credit.common.enums;

/**
 * Created by Zhu Jun on 2017/5/16.
 */
public enum EnumRelatedType {
    ULTIMATE_PARENT(12),//最终母公司
    PARENT_COMPANY(1),//母公司
    SUBSIDIARIES(2),//子公司
    BRANCH(3),//分支机构
    AFFILIATE(4),//关联公司
    COMPETITOR(5),//竞争对手
    SUPERVISAL_DEPARTMENT(6),//上级主管部门
    HEADQUARTER(7),//总部
    HEAD_OFFICE(8),//总公司
    REPRESENTATIVE_OFFICE(9),//办事处
    SHAREHOLDER(10),//股东
    SHAREHOLDING_ENTERPRISE(11),//参股企业
    ENTERPRISE_EXTERNAL_INVESTMENT(13);//企业对外投资


    private Integer i;

    EnumRelatedType(Integer i) {
        this.i = i;
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }
}
