package com.mika.credit.facade.globalsearch.admin.dao;



import com.mika.credit.facade.globalsearch.admin.model.Corp;

import java.util.List;

public interface CorpMapper {

	Corp queryById(String id);
	List<Corp> queryAll();
	int add(Corp corp);
	int mod(Corp corp);
	int del(String id);
}
