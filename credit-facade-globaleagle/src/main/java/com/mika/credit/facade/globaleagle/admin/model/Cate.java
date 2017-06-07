package com.mika.credit.facade.globaleagle.admin.model;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 鍒嗙被椤?
 * @author gavin
 *
 */
public class Cate implements Serializable {
	private String id;
private String name;
private int sort;
	private boolean isSYS;
	private List<Menu> menus = new ArrayList<Menu>();

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public boolean getIsSYS() {
		return isSYS;
	}

	public void setIsSYS(boolean isSYS) {
		this.isSYS = isSYS;
	}

	public String getId() {
	return id;
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
public int getSort() {
	return sort;
}
public void setSort(int sort) {
	this.sort = sort;
}
@Override
	public String toString() {
		return this.sort + "=>" + this.name;
	}
}
