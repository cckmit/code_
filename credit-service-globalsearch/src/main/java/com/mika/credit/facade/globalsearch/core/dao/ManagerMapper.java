package com.mika.credit.facade.globalsearch.core.dao;


import com.mika.credit.facade.globalsearch.core.model.Manager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerMapper {

	Manager queryById(String id);
	List<Manager> queryAll();
	int add(Manager manager);
	int mod(Manager manager);
	int del(String id);
	List<Manager> selectSelective(Manager manager);
}
