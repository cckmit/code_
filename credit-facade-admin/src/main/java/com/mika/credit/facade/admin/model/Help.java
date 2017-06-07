package com.mika.credit.facade.admin.model;

import java.io.Serializable;

/**
 * 帮助
 * Created by Administrator on 2016/9/19.
 * @author dhl007
 */
public class Help implements Serializable{
    private static final long serialVersionUID = 5179026218304424956L;

    /**
     * 帮助编号
     */
    private Integer id;

    /**
     * 主题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 帮助来源,1：全球鹰 2：全搜 3：CPM 4：估估
     */
    private Byte source;
    /**
     * 帮助类别
     */
    private HelpCate cate;

    public Byte getSource() {
        return source;
    }

    public void setSource(Byte source) {
        this.source = source;
    }

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
