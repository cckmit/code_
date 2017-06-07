package com.mika.credit.facade.admin.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by credit on 2017/3/16.
 */
public class Corp implements Serializable {
    private static final long serialVersionUID = -8241502397146639729L;
    private String id;
    private String pid;//上级机构
    private String lev;//从最上级开始，每级用-连接
    private String code;//机构编码
    private String name;//机构名称
    private String tel;//电话
    private String addr;//地址
    private String artificial;//法人代表
    private String job;//主要职能
    private CorpType corpType;
    private List<Dept> depts = new ArrayList<Dept>();

    public List<Dept> getDepts() {
        return depts;
    }

    public void setDepts(List<Dept> depts) {
        this.depts = depts;
    }

    public CorpType getCorpType() {
        return corpType;
    }

    public void setCorpType(CorpType corpType) {
        this.corpType = corpType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getLev() {
        return lev;
    }

    public void setLev(String lev) {
        this.lev = lev;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
    public String getArtificial() {
        return artificial;
    }

    public void setArtificial(String artificial) {
        this.artificial = artificial;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
