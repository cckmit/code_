package com.mika.credit.common.entity.order;

import java.io.Serializable;

/**
 * 模块实体类
 *
 * @author zj001
 */
public class Module implements Serializable {

    private static final long serialVersionUID = 8794749294346752502L;
    /**
     * 明细id
     */
    private Integer id;
    /**
     * 模块名
     */
    private String name;
    /**
     * 是否启用
     */
    private Boolean enable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}
