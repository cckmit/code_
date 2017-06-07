package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;

public class IndustryClassSmall extends BaseEntity {

    private String name;

    private String code;

    private Long bigId;

    private Long middleId;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Long getBigId() {
        return bigId;
    }

    public void setBigId(Long bigId) {
        this.bigId = bigId;
    }

    public Long getMiddleId() {
        return middleId;
    }

    public void setMiddleId(Long middleId) {
        this.middleId = middleId;
    }
}