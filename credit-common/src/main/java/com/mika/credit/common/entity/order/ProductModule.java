package com.mika.credit.common.entity.order;

import java.io.Serializable;

/**
 * 产品模块中间类
 *
 * @author zj001
 */
public class ProductModule implements Serializable{

    private static final long serialVersionUID = 1L;
    /**
     * 明细id
     */
    private Integer id;//明细id
    /**
     * 产品id
     */
    private Integer productId;//产品id
    /**
     * 模块id
     */
    private Integer moduleId;//模块id
    /**
     * 是否供应商
     */
    private Boolean isProvider;
    /**
     * 查询SQL，需要加密
     */
    private String sql;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public Boolean getProvider() {
        return isProvider;
    }

    public void setProvider(Boolean provider) {
        isProvider = provider;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}

