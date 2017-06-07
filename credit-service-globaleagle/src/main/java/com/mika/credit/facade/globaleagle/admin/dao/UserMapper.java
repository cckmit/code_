package com.mika.credit.facade.globaleagle.admin.dao;

import com.mika.credit.facade.globaleagle.admin.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

	User queryById(String id);
	List<User> queryAll();
	int add(User user);
	int mod(User user);
	int del(String id);
	List<User> selectSelective(User user);
}
