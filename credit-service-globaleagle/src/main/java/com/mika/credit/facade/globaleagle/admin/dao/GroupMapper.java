package com.mika.credit.facade.globaleagle.admin.dao;

import com.mika.credit.facade.globaleagle.admin.model.Group;

import java.util.List;

public interface GroupMapper {

	Group queryById(String id);
	List<Group> queryAll();
	int add(Group group);
	int mod(Group group);
	int del(String id);
}
