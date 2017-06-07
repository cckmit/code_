package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public class IndustryClassMiddle extends BaseEntity {

    private String name;

    private String code;

    private Long bigId;

    private List<IndustryClassSmall> industryClassSmalls=new ArrayList<>();

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

    public List<IndustryClassSmall> getIndustryClassSmalls() {
        return industryClassSmalls;
    }

    public void setIndustryClassSmalls(List<IndustryClassSmall> industryClassSmalls) {
        this.industryClassSmalls = industryClassSmalls;
    }
}