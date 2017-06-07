package com.mika.credit.facade.admin.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by credit on 2017/3/16.
 */
public class Group implements Serializable{
	private static final long serialVersionUID = -3348022256407493161L;
	private String id;
	private String code;//组编码
	private String name;//组名称
	private Boolean enable;
	private List<Resource> resources =new ArrayList<Resource>();
	private List<User> users=new ArrayList<User>();

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
}
