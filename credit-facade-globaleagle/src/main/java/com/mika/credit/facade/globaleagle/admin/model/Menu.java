package com.mika.credit.facade.globaleagle.admin.model;


import java.io.Serializable;

/**
 * Created by gavin on 2015/7/2.
 */
public class Menu implements Serializable {
    private String id;
    private String name;
    private String icon;
    private String url;
    private String formURL;
    private String querySQL;
    private boolean enable;
    private int sort;
    private boolean isSYS;

    private Cate cate;

    public boolean getIsSYS() {
        return isSYS;
    }

    public void setIsSYS(boolean isSYS) {
        this.isSYS = isSYS;
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

    public String getFormURL() {
        return formURL;
    }

    public void setFormURL(String formURL) {
        this.formURL = formURL;
    }

    public String getQuerySQL() {
        return querySQL;
    }

    public void setQuerySQL(String querySQL) {
        this.querySQL = querySQL;
    }

    public boolean getEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public Cate getCate() {
        return cate;
    }

    public void setCate(Cate cate) {
        this.cate = cate;
    }
}
