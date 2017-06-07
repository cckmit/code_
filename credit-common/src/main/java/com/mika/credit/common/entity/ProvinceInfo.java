package com.mika.credit.common.entity;

/**
 * 省份信息
 *
 * Created by michael on 2017/5/4.
 */
public class ProvinceInfo extends BaseEntity {
    /**
     * 省份信息主键id
     */
    private Integer id;
    /**
     * 省份编号
     */
    private Long code;
    /**
     * 省份
     */
    private String province;
    /**
     * 省份英文
     */
    private String provinceEN;
    /**
     * 所属地区
     */
    private String metropolitanArea;
    /**
     * 所属地区英文
     */
    private String metropolitanAreaEN;
    /**
     * 全国生产总值
     */
    private Long nominalGdpTotal;
    /**
     * 人均生产总值
     */
    private Long nominalGdpPerCapita;
    /**
     * 占地面积
     */
    private Long area;
    /**
     * 人口数量
     */
    private Long population;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvinceEN() {
        return provinceEN;
    }

    public void setProvinceEN(String provinceEN) {
        this.provinceEN = provinceEN;
    }

    public String getMetropolitanAreaEN() {
        return metropolitanAreaEN;
    }

    public void setMetropolitanAreaEN(String metropolitanAreaEN) {
        this.metropolitanAreaEN = metropolitanAreaEN;
    }

    public String getMetropolitanArea() {
        return metropolitanArea;
    }

    public void setMetropolitanArea(String metropolitanArea) {
        this.metropolitanArea = metropolitanArea;
    }



    public Long getNominalGdpTotal() {
        return nominalGdpTotal;
    }

    public void setNominalGdpTotal(Long nominalGdpTotal) {
        this.nominalGdpTotal = nominalGdpTotal;
    }

    public Long getNominalGdpPerCapita() {
        return nominalGdpPerCapita;
    }

    public void setNominalGdpPerCapita(Long nominalGdpPerCapita) {
        this.nominalGdpPerCapita = nominalGdpPerCapita;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }
}