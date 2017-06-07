package com.mika.credit.facade.admin.model;

import java.io.Serializable;
import java.util.List;

/**
 * 洲
 * @author dhl007
 */
public class Continent implements Serializable {
    /**
     * 洲的编号
     */
    private Integer id;

    /**
     * 中文名字
     */
    private String cnName;

    /**
     * 英文名
     */
    private String enName;

    /**
     * 是否启用
     */
    private String isEnable;

    /**
     * 对应的所有国家
     */
    private List<Country> countries;


    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName == null ? null : cnName.trim();
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName == null ? null : enName.trim();
    }

    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable == null ? null : isEnable.trim();
    }
}