package com.mika.credit.facade.admin.model;


import java.io.Serializable;

/**
 * Created by credit on 2017/3/16.
 */
public class Dept implements Serializable {
	private static final long serialVersionUID = -1819214125495213014L;
	private String id;
	private String pid;  //上级机构
	private String lev;//从最上级开始，每级用-连接
	private String code;
	private String name;
	private String chief;//负责人
	private String job;//主要职能
	private Corp corp;
	private CorpType corpType;

	public CorpType getCorpType() {
		return corpType;
	}

	public void setCorpType(CorpType corpType) {
		this.corpType = corpType;
	}

	public Corp getCorp() {
		return corp;
	}

	public void setCorp(Corp corp) {
		this.corp = corp;
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

	public String getChief() {
		return chief;
	}

	public void setChief(String chief) {
		this.chief = chief;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

}
