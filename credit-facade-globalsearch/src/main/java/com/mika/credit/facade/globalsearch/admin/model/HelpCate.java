package com.mika.credit.facade.globalsearch.admin.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/9/19.
 */
public class HelpCate implements Serializable{
    private Integer id;
    private String name;
    private List<Help> helps;

    public Integer getId() {
        return id;
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
