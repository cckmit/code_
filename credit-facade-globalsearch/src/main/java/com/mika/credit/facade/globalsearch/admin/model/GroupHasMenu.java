package com.mika.credit.facade.globalsearch.admin.model;

/**
 * 鍒嗙被椤?
 * @author mika
 *
 */
public class GroupHasMenu {
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
