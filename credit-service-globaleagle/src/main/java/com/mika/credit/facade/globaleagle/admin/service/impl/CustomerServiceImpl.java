package com.mika.credit.facade.globaleagle.admin.service.impl;


import com.github.pagehelper.PageHelper;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.globaleagle.core.dao.CustomerMapper;
import com.mika.credit.facade.globaleagle.core.model.Customer;
import com.mika.credit.facade.globaleagle.admin.service.CustomerManagerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("customerManagerService")
public class CustomerServiceImpl implements CustomerManagerService {

	private static Logger logger = Logger.getLogger(CustomerManagerService.class);
	@Autowired
	private CustomerMapper customerMapper;


	/**
	 * 条件查询用户信息
	 * @param customer
	 * @return
	 */
	@Override
	public BootGrid<Customer> getCustomers(BootGrid<Customer> bootGrid, Customer customer) {
		logger.info("条件查询用户信息方法开始...");
		PageHelper.startPage(bootGrid.getCurrent(), bootGrid.getRowCount());
		bootGrid.setRows(customerMapper.selectSelective(customer));
		bootGrid.setTotal(customerMapper.selectSelective(customer).size());
		bootGrid.setResult(true);
		return bootGrid;
	}

	@Override
	public ResponseResult<Customer> updateCus(Customer customer){
		logger.info("修改用户信息方法开始...");
		ResponseResult<Customer> result=new ResponseResult<>();
		int chang=customerMapper.updateByPrimaryKeySelective(customer);
		if(chang>0){
			result.setMsg("修改成功");
			result.setCode(true);
		}else{
			result.setMsg("修改失败");
			result.setCode(false);
		}
		return result;
	}

	@Override
	public ResponseResult<Customer> addCus(Customer customer) {
		logger.info("添加用户信息方法开始...");
		ResponseResult<Customer> bootGrid=new ResponseResult<>();
		if(customerMapper.selectByEmail(customer.getEmail())!=null){  //判断新增客户的email
			bootGrid.setMsg("这个email已存在，添加失败！");
			bootGrid.setCode(false);
			return bootGrid;
		}else{
			Date date=new Date();
			customer.setCreateTime(date);
			if(customerMapper.insert(customer) > 0){
				bootGrid.setMsg("添加成功！");
				bootGrid.setCode(true);
			}else{
				bootGrid.setMsg("添加失败！");
				bootGrid.setCode(false);
			}
			return bootGrid;
		}
	}

	@Override
	public ResponseResult<Customer> deleteCus(int id) {
		logger.info("删除用户信息方法开始...");
		ResponseResult<Customer> result=new ResponseResult<>();
		if(customerMapper.deleteByPrimaryKey(id) > 0){
			result.setMsg("删除成功");
			result.setCode(true);
		}else{
			result.setMsg("删除失败");
			result.setCode(false);
		}
		return result;
	}

	@Override
	public ResponseResult<Customer> editCheckStatus(Customer customer) {
		logger.info("认证用户信息方法开始...");
		ResponseResult<Customer> result = new ResponseResult<>();
		if(customerMapper.updateCheckStatusById(customer)>0){
			if (customer.getCheckStatus().equals("是")){
				result.setMsg("认证成功");
			}else{
				result.setMsg("保存成功");
			}
			result.setCode(true);
		}else {
			result.setMsg("保存/认证失败");
			result.setCode(false);
		}
		return result;
	}

	/**
	 * 客户认证
	 * @param record
	 * @return
	 */
	@Override
	public ResponseResult<Customer> modifyCertify(Customer record) {
		logger.info("客户认证用户信息方法开始...");
		ResponseResult<Customer> result = new ResponseResult<>();
		if(customerMapper.updateCheckStatusById(record) > 0){
			result.setCode(true);
		}
		return result;
	}


}
