package com.mika.credit.facade.admin.model;


import com.mika.credit.common.entity.BaseEntity;

/**
 *  中国行业代码
 * @author michael
 *          Created on 2017/5/15.
 */
public class ChnCodes extends BaseEntity{
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 中国代码
     */
    private String chnCode;
    /**
     *  国际代码
     */
    private String intCode;
    /**
     *  中文名称
     */
    private String nameCn;
    /**
     *  英文名称
     */
    private String nameEn;
    /**
     *  标识是否删除
     */
    private String delFlag;
    /**
     *  中文行业说明
     */
    private String industryDescriptionCn;
    /**
     *  英文行业说明
     */
    private String industryDescriptionEn;
    /**
     *  中文行业简介
     */
    private String industryOverviewCn;
    /**
     *  英文行业简介
     */
    private String industryOverviewEn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChnCode() {
        return chnCode;
    }

    public void setChnCode(String chnCode) {
        this.chnCode = chnCode == null ? null : chnCode.trim();
    }

    public String getIntCode() {
        return intCode;
    }

    public void setIntCode(String intCode) {
        this.intCode = intCode == null ? null : intCode.trim();
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn == null ? null : nameCn.trim();
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn == null ? null : nameEn.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getIndustryDescriptionCn() {
        return industryDescriptionCn;
    }

    public void setIndustryDescriptionCn(String industryDescriptionCn) {
        this.industryDescriptionCn = industryDescriptionCn == null ? null : industryDescriptionCn.trim();
    }

    public String getIndustryDescriptionEn() {
        return industryDescriptionEn;
    }

    public void setIndustryDescriptionEn(String industryDescriptionEn) {
        this.industryDescriptionEn = industryDescriptionEn == null ? null : industryDescriptionEn.trim();
    }

    public String getIndustryOverviewCn() {
        return industryOverviewCn;
    }

    public void setIndustryOverviewCn(String industryOverviewCn) {
        this.industryOverviewCn = industryOverviewCn == null ? null : industryOverviewCn.trim();
    }

    public String getIndustryOverviewEn() {
        return industryOverviewEn;
    }

    public void setIndustryOverviewEn(String industryOverviewEn) {
        this.industryOverviewEn = industryOverviewEn == null ? null : industryOverviewEn.trim();
    }
}