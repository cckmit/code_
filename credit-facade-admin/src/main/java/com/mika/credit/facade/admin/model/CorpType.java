package com.mika.credit.facade.admin.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by credit on 2017/3/16.
 */
public class CorpType implements Serializable{
    private static final long serialVersionUID = -3413458394415078406L;
    private String id;
    private String name;
    private String code;
    private List<Corp> corps = new ArrayList<Corp>();

    public String getId() {
        return id;
    }

    public List<Corp> getCorps() {
        return corps;
    }

    public void setCorps(List<Corp> corps) {
        this.corps = corps;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
