package com.mika.credit.facade.admin.model;


import com.mika.credit.common.entity.BaseEntity;

/**
 *  美国行业代码
 * @author michael
 *          Created on 2017/5/15.
 */
public class UsCodes extends BaseEntity {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 美国代码
     */
    private String usCode;
    /**
     * 国际代码
     */
    private String intCode;
    /**
     * 中文简称
     */
    private String nameCn;
    /**
     * 英文简称
     */
    private String nameEn;
    /**
     * 标识是否删除
     */
    private String delFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsCode() {
        return usCode;
    }

    public void setUsCode(String usCode) {
        this.usCode = usCode == null ? null : usCode.trim();
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
}