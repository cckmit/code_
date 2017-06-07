package com.mika.credit.facade.gugu.model;

public class ScanningCardExtend {
    private Integer id;

    private Integer scanningCardId;

    private String type;

    private String paramType;

    private String param1;

    private String param2;

    private String paramExt;

    private String paramNote;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScanningCardId() {
        return scanningCardId;
    }

    public void setScanningCardId(Integer scanningCardId) {
        this.scanningCardId = scanningCardId;
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