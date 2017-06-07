package com.mika.credit.facade.globalsearch.admin.dao;


import com.mika.credit.facade.globalsearch.admin.model.Help;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HelpMapper {

	Help queryById(Integer id);
	List<Help> queryAll();
	List<Help> queryAllByCate(Integer cateId);
	List<Help> queryByCondition(Help condition);
	Integer queryCountByCondition(Help condition);
	int add(Help menu);
	int mod(Help menu);
	int del(Integer id);
	int selectCountByCate(Integer id);
}
