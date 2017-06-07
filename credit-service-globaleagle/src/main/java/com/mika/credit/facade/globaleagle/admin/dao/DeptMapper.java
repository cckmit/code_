package com.mika.credit.facade.globaleagle.admin.dao;


import com.mika.credit.facade.globaleagle.admin.model.Dept;

import java.util.List;

public interface DeptMapper {

	Dept queryById(String id);
	List<Dept> queryAll();
	int add(Dept dept);
	int mod(Dept dept);
	int del(String id);
}
