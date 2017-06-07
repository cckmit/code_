package com.mika.credit.facade.globaleagle.admin.model;

import java.io.Serializable;

/**
 * 鍒嗙被椤?
 * @author mika
 *
 */
public class GroupHasMenu implements Serializable {
	private String groupId;
	private String menuId;
	private String access;

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}
}
