package com.mika.credit.facade.admin.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by credit on 2017/3/15.
 */
public class Resource implements Serializable{
    private static final long serialVersionUID = 8966433791815810407L;
    private String id;//页面上菜单ID采用menu+ID
    private String name;//菜单显示名
    private String icon;//菜单图标样式名
    private String url;//菜单链接
    private String perms;//资源名,多名用,隔开
    private Integer type;//  1：菜单 2：按钮
    private Boolean enable;//是否启用
    private Integer sort;//序号，页面显示时根据序号排序
    private Boolean isSYS;//是否内置，不允许前台修改
    private Category category;
    private System system;
    private List<Group> groupList=new ArrayList<Group>();

    public List<Group> getGroupList() {
        return groupList;
    }

    public System getSystem() {
        return system;
    }

    public void setSystem(System system) {
        this.system = system;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
