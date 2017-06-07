package com.mika.credit.facade.globalsearch.admin.dao;


import com.mika.credit.facade.globalsearch.admin.model.HelpCate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HelpCateMapper {
	HelpCate queryById(Integer id);
	List<HelpCate> queryAll();
	int add(HelpCate cate);
	int mod(HelpCate cate);
	int del(Integer id);
}
