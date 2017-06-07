package com.mika.credit.facade.index.bean;

import java.io.Serializable;

/**
 * Created by dell on 2017/3/22.
 */
public class QueryENByName implements Serializable{
    private static final long serialVersionUID = -338784078491889268L;
    private String nameEN;//英文名
    private String nameCN;//中文名
    private String province;//所在省(地区)
    private String exIm;//进出口
    private String status;//状态
    private String reg;//注册号

    public String getNameEN() {
        return nameEN;
    }

    public void setNameEN(String nameEN) {
        this.nameEN = nameEN;
    }

    public String getNameCN() {
        return nameCN;
    }

    public void setNameCN(String nameCN) {
        this.nameCN = nameCN;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getExIm() {
        return exIm;
    }

    public void setExIm(String exIm) {
        this.exIm = exIm;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }
}
