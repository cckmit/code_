package com.mika.credit.facade.globaleagle.admin.service;


import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.globaleagle.core.model.Customer;


public interface CustomerManagerService {

	BootGrid<Customer> getCustomers(BootGrid<Customer> bootGrid,Customer customer);   //查询客户

	ResponseResult<Customer> updateCus(Customer customer);        //更新当前客户

	ResponseResult<Customer> addCus(Customer customer);       //增加或更新客户（新建时根据email判断，如果email相同，则保持email不变，完全更新用户）

	ResponseResult<Customer> deleteCus(int id);         //删除客户

	ResponseResult<Customer> modifyCertify(Customer customer);
	//	修改验证状态
	ResponseResult<Customer> editCheckStatus(Customer customer);

}
