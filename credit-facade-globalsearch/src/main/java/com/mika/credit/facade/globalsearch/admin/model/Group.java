package com.mika.credit.facade.globalsearch.admin.model;


import java.util.List;

/**
 * 鍒嗙被椤?
 * @author mika
 *
 */
public class Group {
	private String id;
	private String code;
	private String name;
	private List<GroupHasMenu> groupHasMenus;

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

	public List<GroupHasMenu> getGroupHasMenus() {
		return groupHasMenus;
	}

	public void setGroupHasMenus(List<GroupHasMenu> groupHasMenus) {
		this.groupHasMenus = groupHasMenus;
	}
}
