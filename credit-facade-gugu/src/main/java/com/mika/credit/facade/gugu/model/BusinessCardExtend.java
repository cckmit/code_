package com.mika.credit.facade.gugu.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BusinessCardExtend implements Serializable {
    private Integer id;

    private Integer cardId;

    private String type;

    private String paramType;

    private String param1;

    private String param2;

    private String paramExt;

    private String paramNote;

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType == null ? null : paramType.trim();
    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1 == null ? null : param1.trim();
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2 == null ? null : param2.trim();
    }

    public String getParamExt() {
        return paramExt;
    }

    public void setParamExt(String paramExt) {
        this.paramExt = paramExt == null ? null : paramExt.trim();
    }

    public String getParamNote() {
        return paramNote;
    }

    public void setParamNote(String paramNote) {
        this.paramNote = paramNote == null ? null : paramNote.trim();
    }
}