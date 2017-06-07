package com.mika.credit.common.entity;

/**
 * 城市信息
 *
 * Created by michael on 2017/5/4.
 */
public class CityInfo extends BaseEntity{
    /**
     * 城市信息主键id
     */
    private Integer id;
    /**
     * 城市编号
     */
    private Long code;
    /**
     * 城市
     */
    private String city;
    /**
     * 城市英文
     */
    private String cityEN;
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
    /**
     * 关联省市信息表code
     */
    private Long provinceInfoCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getMetropolitanArea() {
        return metropolitanArea;
    }

    public void setMetropolitanArea(String metropolitanArea) {
        this.metropolitanArea = metropolitanArea == null ? null : metropolitanArea.trim();
    }

    public String getCityEN() {
        return cityEN;
    }

    public void setCityEN(String cityEN) {
        this.cityEN = cityEN;
    }

    public String getMetropolitanAreaEN() {
        return metropolitanAreaEN;
    }

    public void setMetropolitanAreaEN(String metropolitanAreaEN) {
        this.metropolitanAreaEN = metropolitanAreaEN;
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

    public Long getProvinceInfoCode() {
        return provinceInfoCode;
    }

    public void setProvinceInfoCode(Long provinceInfoCode) {
        this.provinceInfoCode = provinceInfoCode;
    }
}