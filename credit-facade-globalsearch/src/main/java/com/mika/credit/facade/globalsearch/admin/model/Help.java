package com.mika.credit.facade.globalsearch.admin.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/9/19.
 */
public class Help implements Serializable{
    private Integer id;
    private String title;
    private String content;
    private HelpCate cate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public HelpCate getCate() {
        return cate;
    }

    public void setCate(HelpCate cate) {
        this.cate = cate;
    }
}
