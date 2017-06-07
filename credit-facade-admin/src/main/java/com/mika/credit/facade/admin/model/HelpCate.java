package com.mika.credit.facade.admin.model;

import java.io.Serializable;
import java.util.List;

/**
 * 帮助类别
 * Created by Administrator on 2016/9/19.
 * @author dhl007
 */
public class HelpCate implements Serializable{
    private static final long serialVersionUID = -2137937816320314352L;

    /**
     * 帮助类别id
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 帮助来源,1：全球鹰 2：全搜 3：CPM 4：估估
     */
    private Byte source;

    /**
     * 对应的所有帮助信息
     */
    private List<Help> helps;

    public Integer getId() {
        return id;
    }

    public Byte getSource() {
        return source;
    }

    public void setSource(Byte source) {
        this.source = source;
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

    public List<Help> getHelps() {
        return helps;
    }

    public void setHelps(List<Help> helps) {
        this.helps = helps;
    }
}
