package com.mika.credit.common.entity.report.cn;

import com.mika.credit.common.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public class IndustryClassBig extends BaseEntity {

    private String name;

    private String code;

    private List<IndustryClassMiddle> industryClassMiddle=new ArrayList<>();


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
    public List<IndustryClassMiddle> getIndustryClassMiddle() {
        return industryClassMiddle;
    }

    public void setIndustryClassMiddle(List<IndustryClassMiddle> industryClassMiddle) {
        this.industryClassMiddle = industryClassMiddle;
    }
}