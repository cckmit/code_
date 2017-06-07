package com.mika.credit.facade.globaleagle.admin.model;


import java.io.Serializable;

/**
 * 鍒嗙被椤?
 * @author mika
 *
 */
public class Corp implements Serializable {
	private String id;
	private int lev;
	private String code;
	private String name;
	private String tel;
	private String addr;
	private String artificial;
	private  String job;
	private String pid;
	private String corpTypeId;
	private Corp parent;
	private CorpType corpType;

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getLev() {
		return lev;
	}

	public void setLev(int lev) {
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

	public Corp getParent() {
		return parent;
	}

	public void setParent(Corp parent) {
		this.parent = parent;
	}

	public CorpType getCorpType() {
		return corpType;
	}

	public void setCorpType(CorpType corpType) {
		this.corpType = corpType;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getCorpTypeId() {
		return corpTypeId;
	}

	public void setCorpTypeId(String corpTypeId) {
		this.corpTypeId = corpTypeId;
	}
}
