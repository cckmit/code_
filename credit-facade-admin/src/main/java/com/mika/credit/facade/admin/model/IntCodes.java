package com.mika.credit.facade.admin.model;

import com.mika.credit.common.entity.BaseEntity;

/**
 *  国际行业代码
 * @author michael
 *          Created on 2017/5/15.
 */
public class IntCodes extends BaseEntity {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 国际代码
     */
    private String intCode;
    /**
     * 中文名称
     */
    private String nameCn;
    /**
     * 英文名称
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