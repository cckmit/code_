package com.mika.credit.common.entity.index;

import java.io.Serializable;

/**
 * 索引查询参数基准类
 * Created by dell on 2017/4/26.
 */
public class BaseSearchParam implements Serializable{
    private static final long serialVersionUID = 364555408788649588L;
    /**
     * 分页参数(当前页数)
     */
    private int current;    //当前页数
    /**
     * 分页参数(每页记录数)
     */
    private int rowCount;   //每页记录数
    /**
     * 需要最大查询结果数量
     */
    private Integer maxHitCount;
    /**
     * 所在省/直辖市
     */
    private String address;
    /**
     * 公司英文名
     */
    private String nameEN;
    /**
     * 公司中文名
     */
    private String nameCN;
    /**
     * 电话号码
     */
    private String phoneNumber;
    /**
     * 注册号
     */
    private String reg;

    public Integer getMaxHitCount() {
        return maxHitCount;
    }

    public void setMaxHitCount(Integer maxHitCount) {
        this.maxHitCount = maxHitCount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }
}
