package com.mika.credit.facade.globaleagle.core.dao;

import com.mika.credit.facade.globaleagle.core.model.Manager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerMapper {

	Manager queryById(int id);
	List<Manager> queryAll();
	int addManger(Manager manager);
	int updateByPrimaryKeySelective(Manager manager);
	int delManager(int id);
	List<Manager> selectSelective(Manager manager);
	int selectCountSelective(Manager manager);
	String selManEmail(Integer manId);
}
