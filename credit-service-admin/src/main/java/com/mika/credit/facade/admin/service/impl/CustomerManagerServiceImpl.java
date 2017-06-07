package com.mika.credit.facade.admin.service.impl;


import com.github.pagehelper.PageHelper;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.admin.dao.ge.GECustomerMapper;
import com.mika.credit.facade.admin.dao.gs.GSCustomerMapper;
import com.mika.credit.facade.admin.model.Customer;
import com.mika.credit.facade.admin.service.CustomerManagerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("customerManagerService")
public class CustomerManagerServiceImpl implements CustomerManagerService {

	private static Logger logger = Logger.getLogger(CustomerManagerService.class);
	@Autowired
	private GECustomerMapper geCustomerMapper;
	@Autowired
	private GSCustomerMapper gsCustomerMapper;


	/**
	 * 条件查询用户信息
	 * @param customer
	 * @return
	 */
	@Override
	public BootGrid<Customer> getCustomersGE(BootGrid<Customer> bootGrid, Customer customer) {
		PageHelper.startPage(bootGrid.getCurrent(), bootGrid.getRowCount());
		bootGrid.setRows(geCustomerMapper.selectSelective(customer));
		bootGrid.setTotal(geCustomerMapper.selectSelective(customer).size());
		bootGrid.setResult(true);
		return bootGrid;
	}

	@Override
	public BootGrid<Customer> getCustomersGS(BootGrid<Customer> bootGrid, Customer customer) {
		PageHelper.startPage(bootGrid.getCurrent(), bootGrid.getRowCount());
		bootGrid.setRows(gsCustomerMapper.selectSelective(customer));
		bootGrid.setTotal(gsCustomerMapper.selectSelective(customer).size());
		bootGrid.setResult(true);
		return bootGrid;
	}



	@Override
	public ResponseResult<Customer> updateCusGE(Customer customer){
		ResponseResult<Customer> result=new ResponseResult<>();
		int chang=geCustomerMapper.updateByPrimaryKeySelective(customer);
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
	public ResponseResult<Customer> updateCusGS(Customer customer){
		ResponseResult<Customer> result=new ResponseResult<>();
		int chang=gsCustomerMapper.updateByPrimaryKeySelective(customer);
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
	public ResponseResult<Customer> addCusGE(Customer customer) {
		ResponseResult<Customer> bootGrid=new ResponseResult<>();
		if(geCustomerMapper.selectByEmail(customer.getEmail())!=null){  //判断新增客户的email
			bootGrid.setMsg("这个email已存在，添加失败！");
			bootGrid.setCode(false);
			return bootGrid;
		}else{
			Date date=new Date();
			customer.setCreateTime(date);
			if(geCustomerMapper.insert(customer) > 0){
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
	public ResponseResult<Customer> addCusGS(Customer customer) {
		ResponseResult<Customer> bootGrid=new ResponseResult<>();
		if(gsCustomerMapper.selectByEmail(customer.getEmail())!=null){  //判断新增客户的email
			bootGrid.setMsg("这个email已存在，添加失败！");
			bootGrid.setCode(false);
			return bootGrid;
		}else{
			Date date=new Date();
			customer.setCreateTime(date);
			if(gsCustomerMapper.insert(customer) > 0){
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
	public ResponseResult<Customer> deleteCusGE(int id) {
		ResponseResult<Customer> result=new ResponseResult<>();
		if(geCustomerMapper.deleteByPrimaryKey(id) > 0){
			result.setMsg("删除成功");
			result.setCode(true);
		}else{
			result.setMsg("删除失败");
			result.setCode(false);
		}
		return result;
	}

	@Override
	public ResponseResult<Customer> deleteCusGS(int id) {
		ResponseResult<Customer> result=new ResponseResult<>();
		if(gsCustomerMapper.deleteByPrimaryKey(id) > 0){
			result.setMsg("删除成功");
			result.setCode(true);
		}else{
			result.setMsg("删除失败");
			result.setCode(false);
		}
		return result;
	}



	@Override
	public ResponseResult<Customer> editCheckStatusGE(Customer customer) {
		ResponseResult<Customer> result = new ResponseResult<>();
		if(geCustomerMapper.updateCheckStatusById(customer)>0){
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

	@Override
	public ResponseResult<Customer> editCheckStatusGS(Customer customer) {
		ResponseResult<Customer> result = new ResponseResult<>();
		if(gsCustomerMapper.updateCheckStatusById(customer)>0){
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
	public ResponseResult<Customer> modifyCertifyGE(Customer record) {
		ResponseResult<Customer> result = new ResponseResult<>();
		if(geCustomerMapper.updateCheckStatusById(record) > 0){
			result.setCode(true);
		}
		return result;
	}

	@Override
	public ResponseResult<Customer> modifyCertifyGS(Customer record) {
		ResponseResult<Customer> result = new ResponseResult<>();
		if(gsCustomerMapper.updateCheckStatusById(record) > 0){
			result.setCode(true);
		}
		return result;
	}


}
