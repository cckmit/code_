package com.mika.credit.facade.admin.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by credit on 2017/3/15.
 */
public class Category implements Serializable{
    private static final long serialVersionUID = 1750522836929636509L;
    private String id;//分类Id
    private String name; //分类名称
    private Integer sort;//序号，页面显示时根据序号排序
    private Boolean isSYS = false;//是否内置，不允许前台修改
    private System system;
    private List<Resource> resources = new ArrayList<Resource>();

    public System getSystem() {
        return system;
    }

    public void setSystem(System system) {
        this.system = system;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getSYS() {
        return isSYS;
    }

    public void setSYS(Boolean SYS) {
        isSYS = SYS;
    }

}
