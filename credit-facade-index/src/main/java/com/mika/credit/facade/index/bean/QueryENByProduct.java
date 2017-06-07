package com.mika.credit.facade.index.bean;

import java.io.Serializable;

/**
 * Created by dell on 2017/3/22.
 */
public class QueryENByProduct implements Serializable{
    private static final long serialVersionUID = 3760962162485799118L;
    private String productLabel;//产品标签
    private Integer a;//a认证
    private Integer v;//v认证
    private String province;//所在省
    private String status;//状态
    private String scale;//大小规模
    private String chnCode;//行业代码

    public String getProductLabel() {
        return productLabel;
    }

    public void setProductLabel(String productLabel) {
        this.productLabel = productLabel;
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getChnCode() {
        return chnCode;
    }

    public void setChnCode(String chnCode) {
        this.chnCode = chnCode;
    }
}
