package com.mika.credit.facade.globalsearch.admin.dao;


import com.mika.credit.facade.globalsearch.admin.model.Menu;

import java.util.List;

public interface MenuMapper {

	Menu queryById(String id);
	List<Menu> queryAll();
	List<Menu> queryAllByCate(String cateId);
	int add(Menu menu);
	int mod(Menu menu);
	int del(String id);
}
