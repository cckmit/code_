package com.mika.credit.facade.globaleagle.admin.dao;

import com.mika.credit.facade.globaleagle.admin.model.CorpType;

import java.util.List;

public interface CorpTypeMapper {

	CorpType queryById(String id);
	List<CorpType> queryAll();
	int add(CorpType corp);
	int mod(CorpType corp);
	int del(String id);
}
